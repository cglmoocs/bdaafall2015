
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;



/**
 * Methods to create data set and  implement the K-Nearest Neighbors Algorithm
 * 
 * Compilation:  javac KNearestNeighbor.java
 *
 */

public class KNearestNeighbor {
	static Logger logger = Logger.getLogger("KNearestNeighbor");
	Neighbor[] neighbors;
	int neighborsIndex;
	int k;
	
	class Neighbor {
		double distance;
		String label;
	}
	
	/**
	 * Constructor with number of nearest neighbors as parameter
	 * @param k - nearest neighbors
	 */
	public KNearestNeighbor(int k) {
		this.k = k;
		neighbors = new Neighbor[k];
	}
	
	
	/**
	 * Adds the given neighbor to list of nearest neighbors if current nearest neighbors
	 * are less than k else replaces with the current farthest neighbor
	 * @param value - distance to the point
	 * @param label - label of the point
	 */
	public void addToNearestNeighbors(double value, String label) {
		if (neighborsIndex < k) {
			neighbors[neighborsIndex] = new Neighbor();			
			neighbors[neighborsIndex].distance = value;
			neighbors[neighborsIndex].label = label;
			neighborsIndex++;
		} else {
			double maxDistance = 0;
			int maxDistanceIndex = 0;
			for (int i = 0; i < k; i++) {
				if (neighbors[i].distance > maxDistance) {
					maxDistanceIndex = i;
					maxDistance = neighbors[i].distance;
				}
			}
			if(maxDistance > value){
			neighbors[maxDistanceIndex].distance = value;
			neighbors[maxDistanceIndex].label = label;
			}
		}

	}
	
	/**
	 * Classifies the give datapoint depending upon the KNearest neighbors in Dataset
	 * @param newDataPoint
	 * @param dataSet
	 * @return
	 */
	public String classify(Data newDataPoint , Data[] dataSet){
		String label = null;
		for(int index=0 ; index <dataSet.length ; index++){
			addToNearestNeighbors( getDistance(newDataPoint.dimensionValues,dataSet[index].dimensionValues), dataSet[index].actualLabel);	
		}
		label = findLabelWithMaxVotes();
		return label;
	}
	
	/**
	 * Classifies the predictDataSet using the training Dataset
	 * @param predictDataSet - test dataset
	 * @param trainDataSet - train dataset
	 * @return
	 */
	public Data[] classify(Data[] predictDataSet , Data[] trainDataSet){
		for(Data predictData : predictDataSet){
			classify(predictData , trainDataSet);
			predictData.setClassifiedLable(findLabelWithMaxVotes());
			neighborsIndex = 0;
			neighbors = new Neighbor[k];
		}
		return predictDataSet;
	}
	
	/**
	 * Counts the points which are classified incorrectly
	 * @param predictDataSet - test data set
	 */
	public float findErrorCount(Data[] predictDataSet){
		float errorCount  = 0;
		for(Data predictData : predictDataSet){
			if(!predictData.actualLabel.equals(predictData.classifiedLable)){
				errorCount++;
			}
		}
		System.out.println(errorCount);
		return errorCount/predictDataSet.length;
	}
	
	
	/**
	 * Iterates through all the neighbors and finds which label has maximum
	 * votes.
	 * @return
	 */
	private String findLabelWithMaxVotes() {		
		Map<String,Integer> labelVotes = new HashMap<String,Integer>();
		int currentMaxVotes =0;
		String labelWithMaxVotes = null;
		for(Neighbor neighbor: neighbors){
			Integer numberOfVotes= labelVotes.get(neighbor.label);
			if(numberOfVotes == null){
				labelVotes.put(neighbor.label, 1);
			}else{
				labelVotes.put(neighbor.label, numberOfVotes+1);
			}
		}		
		
		for(String label :labelVotes.keySet()){
			if(labelVotes.get(label) > currentMaxVotes){
				currentMaxVotes = labelVotes.get(label);
				labelWithMaxVotes = label;
			}
		}	
		return labelWithMaxVotes;
	}

	/**
	 * Returns the euclidean distance between given points.
	 * @param point1 - point 1
	 * @param point2 - point 2
	 * @return double - euclidean distance
	 */
	public double getDistance(double[] point1 , double[] point2){
		
		double xDistance = point1[0] - point2[0];
		double yDistance = point1[1] - point2[1];
		
		xDistance = xDistance*xDistance;
		yDistance = yDistance*yDistance;
		
		return Math.sqrt(xDistance+yDistance);
	}
	
	
	/**
	 * Normalizes the given data set using the formula
	 * 
	 * new Value = value - minValue/(maxValue - minValue)
	 * 
	 * @param args
	 */
	public void normalizeDataSet(Data[] dataSet) {
		int length = dataSet[0].dimensionValues.length;
		double[] minValues = new double[length];
		double[] maxValues = new double[length];
		for (int i = 0; i < length; i++) {
			minValues[i] = dataSet[0].dimensionValues[i];
			maxValues[i] = dataSet[0].dimensionValues[i];
		}

		for (Data data : dataSet) {
			for (int i = 0; i < length; i++) {
				if (data.dimensionValues[i] < minValues[i])
					minValues[i] = data.dimensionValues[i];
				if (data.dimensionValues[i] > minValues[i])
					maxValues[i] = data.dimensionValues[i];
			}

		}
		for (Data data : dataSet) {
			for (int i = 0; i < length; i++) {
				if (data.dimensionValues[i] < minValues[i])
					minValues[i] = data.dimensionValues[i];
				if (data.dimensionValues[i] > minValues[i])
					maxValues[i] = data.dimensionValues[i];
			}

		}

		for (Data data : dataSet) {
			for (int i = 0; i < length; i++) {
				data.dimensionValues[i] = (data.dimensionValues[i] - minValues[i])
						/ (maxValues[i] - minValues[i]);
			}

		}

	}
	
	
	public static void main(String args[]){
		
		
		
	}
	

}
