import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.data.xy.XYSeries; 

/**
 * Client for the KNearestNeigbour Algorithm
 * 
 * Compilation:  javac KNNClient.java
 * Execution:    java KNNClient
 * Dependencies: KNearestNeighbor , Data
 *
 */
public class KNNClient {
	
	static Logger logger = Logger.getLogger("KNNClient");

	
	/**
	 * Sample Data set with 4 points
	 * @return
	 */
	public static Data[] createDataset(){
		Data[] dataset = new Data[4];
		
		Data dataPoint = new Data();
		dataPoint.setPoints(new double[]{1.0,1.1});
		dataPoint.setLabel("A");
		dataset[0] = dataPoint;
		
		dataPoint = new Data();
		dataPoint.setPoints(new double[]{1.0,1.0});
		dataPoint.setLabel("A");
		dataset[1] = dataPoint;
		
		dataPoint = new Data();
		dataPoint.setPoints(new double[]{0,0});
		dataPoint.setLabel("B");
		dataset[2] = dataPoint;
		
		dataPoint = new Data();
		dataPoint.setPoints(new double[]{0,0.1});
		dataPoint.setLabel("B");
		dataset[3] = dataPoint;			
		
		return dataset;
	}
	
	/**
	 * Creates a data record from the given string with the below 
	 * @param value
	 * @return
	 */
	public static Data createDataSetFromString(String value , String separator) {

		Data dataset = new Data();
		String[] values = value.split(separator);
		int index = 0;
		double[] points = new double[values.length - 2];
		for (int i = 0; i < values.length - 2; i++) {
			points[index++] = Double.valueOf(values[i]);
		}
		//dataset.setId(values[0]);
		dataset.setLabel(values[values.length - 1]);
		dataset.setPoints(points);

		return dataset;
	}
	
	/**
	 * Creates a dataset from the given file
	 * @param file - Location of the inputFile
	 * @param separtor - value separator
	 * @return dataset
	 */
	public static Data[] createDataSetFromFile(String file, String separtor) {
		List<Data> dataSet = null;
		File dataFile = new File(file);
		String line = null;
		if (dataFile != null && dataFile.exists()) {
			try (FileReader fileReader = new FileReader(dataFile);
					BufferedReader bufferedReader = new BufferedReader(
							fileReader);) {
				dataSet = new ArrayList<Data>();
				while ((line = bufferedReader.readLine()) != null) {
					try {
						dataSet.add(createDataSetFromString(line, separtor));
					} catch (Exception ex) {
						logger.warning("Invalid data format");
					}
				}
			} catch (Exception ex) {
				logger.severe("Exception while reading from file " + ex.getMessage());
			}
		}
		Data[] ds = new Data[dataSet.size()];
		return (dataSet.toArray(ds));
	}
	/**
	 * Classification based on 4 sample points
	 */
	public static void classifySampleDataSet(){
		KNearestNeighbor knn = new KNearestNeighbor(3);
		Data[] sampleDataSet = createDataset();
		Data newDataPoint = new Data(new double[]{0.2,0.2});		
		String label = knn.classify(newDataPoint, sampleDataSet);
		logger.info("Label of the new data point "+ newDataPoint.toString() + " is classified as :: " +label);
		knn = new KNearestNeighbor(3);
		newDataPoint = new Data(new double[]{0.5,0.5});
		label = knn.classify(newDataPoint, sampleDataSet);
		logger.info("Label of the new data point "+ newDataPoint.toString() + " is classified as :: " +label);
		knn = new KNearestNeighbor(3);
		newDataPoint = new Data(new double[]{0.75,0.75});
		label = knn.classify(newDataPoint, sampleDataSet);
		logger.info("Label of the new data point "+ newDataPoint.toString() + " is classified as :: " +label);
		Map<String, XYSeries> xy =  Plotting.createXYSeries(sampleDataSet);
		Plotting plot= new Plotting("XY", 400, xy);
		plot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plot.pack();
		plot.setLocationRelativeTo(null);
		plot.setVisible(true);
	}
	
	/**
	 * Classification of the data in the given file
	 * 
	 * @param fileName - name of file
	 * @param separator - column separator in the file
	 * @param trainPercentage - percentage of values to predict and rest will be used for training
	 */
	
	public static void classifyFileDataSet(String fileName , String separator , int trainPercentage){
		Data[] fileDataSet  = createDataSetFromFile(fileName ,separator);
		plot("DatingTest Set" , fileDataSet);
		KNearestNeighbor knn = new KNearestNeighbor(3);
		knn.normalizeDataSet(fileDataSet);
		logger.info("Size of the file " + fileDataSet.length);
		int partitionIndex = (fileDataSet.length*trainPercentage)/100;
		Data[] predictData = Arrays.copyOfRange(fileDataSet, 0, partitionIndex);
		Data[] trainData = Arrays.copyOfRange(fileDataSet,partitionIndex, fileDataSet.length);
		knn.classify(predictData, trainData);
		logger.info("Error Percentage " +knn.findErrorCount(predictData));
		plot("Normalized DatingTest Set" , fileDataSet);
	}
	
	
	/**
	 *  Plots the given dataset 
	 * @param title
	 * @param dataSet
	 */
	public static void plot(String title , Data[] dataSet){
		Map<String, XYSeries> xy =  Plotting.createXYSeries(dataSet);
		Plotting plot= new Plotting(title, 800, xy);
		plot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plot.pack();
		plot.setLocationRelativeTo(null);
		plot.setVisible(true);		
	}
	
	public static void main(String[] args){
		// Classifies the sample data
		KNNClient.classifySampleDataSet();
		// Classifies the dating test set
		KNNClient.classifyFileDataSet("datingTestSet2.txt" ,"\t",10);
	}
	
}
