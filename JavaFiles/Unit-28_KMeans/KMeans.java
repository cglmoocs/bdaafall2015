// package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.mahout.clustering.Cluster;
import org.apache.mahout.clustering.classify.WeightedVectorWritable;
import org.apache.mahout.clustering.kmeans.KMeansDriver;
import org.apache.mahout.clustering.kmeans.RandomSeedGenerator;
import org.apache.mahout.common.distance.EuclideanDistanceMeasure;
import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.NamedVector;
import org.apache.mahout.math.Vector;
import org.apache.mahout.math.VectorWritable;
import org.jfree.data.xy.XYSeries;

public class KMeans {

	/**
	 * Creates a Hadoop SeqFile from the Input CSV file
	 * 
	 * @param filePath
	 *            - CSV file Path
	 * @param conf
	 *            - Configuration
	 * @param fs
	 *            - File System
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void createInputSeqFile(String filePath, Configuration conf,
			FileSystem fs) throws FileNotFoundException, IOException {
		 //Java 7 standard for creating closeable resources
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				filePath));
				SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf,
						new Path("kmeans/input/sample.seq"), Text.class,
						VectorWritable.class)) {

			String line = null;
			// Named Vector for each line in the Data set. There are other type
			// vectors like Dense Vector , RandomAccessSparse Vector etc.
			List<NamedVector> inputVectors = new ArrayList<NamedVector>();
			VectorWritable vectorWritable = null;
			String[] values = null;
			double[] doubleValues =  null;
			Vector vec =  null;
			NamedVector namedVector = null;
			while ((line = bufferedReader.readLine()) != null) {
				values = line.split(",");
				doubleValues = new double[values.length - 1];
				for (int index = 1; index < values.length; index++) {
					doubleValues[index - 1] = Double.parseDouble(values[index]);
				}
				vec = new DenseVector(doubleValues);
				namedVector = new NamedVector(vec, values[0]);
				inputVectors.add(namedVector);
			}
			//	 Writing to the input sequential File
			for (NamedVector nv : inputVectors) {
				vectorWritable = new VectorWritable();
				vectorWritable.set(nv);
				writer.append(new Text(nv.getName()), vectorWritable);
			}

		}

	}

	public static void main(String args[]) throws IOException,
			ClassNotFoundException, InterruptedException {
	
		Configuration conf = new Configuration();
		// Hadoop FileSystem
		FileSystem fs = FileSystem.get(conf);
		// Write Input vectors to a sequential File
		KMeans.createInputSeqFile("kmeans/sample.csv", conf, fs);
		// Input sequence File Path
		Path inputPath = new Path("kmeans/input");
		// Clusters Path
		Path clustersPath = new Path("kmeans/clusters");
		// Output file path
		Path outputPath = new Path("kmeans/output");
		// Creates initial centroids and writes to the cluster path.
		// We can use CanopyClustering for initial clusters
		Path centeroids = RandomSeedGenerator.buildRandom(conf, inputPath,
				clustersPath, 5, new EuclideanDistanceMeasure());
		/****************************************************************************************************************
		 * Calling the KMeansDriver.run method by passing the below mentioned paramenters					   		    *
		 * i) conf - hadoop configruation																				*
		 * ii) input path 																					            *
		 * iii)initial cluster path																					    *
		 * iv) output path																			             		*
		 * v) Distance measure 																        					*
		 * vi) Convergence threshold																					*
		 * vii) Maximum number of iterations											     							*
		 * viii)flag to indicate about clustering of points after iterations											*
		 * ix)cluster classification threshold																			*
		 * x) flag to indicate how to run the Kmean - sequential or using MapReduce										*
		 ***************************************************************************************************************/
		KMeansDriver.run(conf, inputPath, centeroids, outputPath,
				new EuclideanDistanceMeasure(), 0.001, 5, true, 0, false);

		// Reading the Output of the KMeans clustering
		int count = 0;
		Map<String, Integer> clusterIds = new HashMap<String, Integer>();
		Map<String, XYSeries> plottingDataSet = new HashMap<String, XYSeries>();
		SequenceFile.Reader reader = new SequenceFile.Reader(fs, new Path(
				"kmeans/output/" + Cluster.CLUSTERED_POINTS_DIR
						+ "/part-m-00000"), conf);

		// Parsing and Setting it to the Plotting Data Set
		IntWritable key = new IntWritable();
		WeightedVectorWritable value = new WeightedVectorWritable();
		while (reader.next(key, value)) {
			NamedVector vector = (NamedVector) value.getVector();
			if (!clusterIds.keySet().contains(key.toString())) {
				clusterIds.put(key.toString(), ++count);
				plottingDataSet.put(key.toString(), new XYSeries("Cluster-"
						+ count));
			}
			plottingDataSet.get(key.toString()).add(vector.get(0),
					vector.get(1));
		}
		reader.close();
		// Plotting the created clusters using JFreeChart plotting
		ScatterPlot plot = new ScatterPlot("KMeans Output", 800,
				plottingDataSet);
		plot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plot.pack();
		plot.setLocationRelativeTo(null);
		plot.setVisible(true);

	}

}
