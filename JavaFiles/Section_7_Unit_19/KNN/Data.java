
/**
 * Class to represent a DataPoint/Record in the dataset.
 * 
 */
public class Data {

	double[] dimensionValues = null; // Values in each dimension
	String id = null; // Id of this data point
	String actualLabel = null; // Actual label
	String classifiedLable = null; // Classified Label

	Data(){
		this(null,null,null);
	}
		
	Data(double[] dimensionValues) {
		this(dimensionValues,null,null);
	}
	
	Data(double[] dimensionValues, String id, String actualLabel) {
		this.dimensionValues = dimensionValues;
		this.id = id;
		this.actualLabel = actualLabel;
	}

	Data(double[] dimensionValues, String actualLabel) {
		this(dimensionValues, null, actualLabel);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActualLabel() {
		return actualLabel;
	}

	public void setActualLabel(String actualLabel) {
		this.actualLabel = actualLabel;
	}

	public String getClassifiedLable() {
		return classifiedLable;
	}

	public void setClassifiedLable(String classifiedLable) {
		this.classifiedLable = classifiedLable;
	}

	public double[] getPoints() {
		return dimensionValues;
	}

	public void setPoints(double[] points) {
		this.dimensionValues = points;
	}

	public String getLabel() {
		return actualLabel;
	}

	public void setLabel(String label) {
		this.actualLabel = label;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (double value : dimensionValues) {
			builder.append(value);
			builder.append(",");
		}
		builder.replace(builder.lastIndexOf(","), builder.lastIndexOf(",")+1, "]");
		return builder.toString();
	}

}
