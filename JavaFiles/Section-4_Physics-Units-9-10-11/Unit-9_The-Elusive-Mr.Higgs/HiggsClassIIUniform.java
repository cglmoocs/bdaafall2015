import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import jhplot.*;
import jhplot.math.Random;

/**
 * HomeWork
 * 
 */
public class HiggsClassIIUniform {
	
	
	/**
	 * Concatenates two given arrays
	 * @param firstArray
	 * @param secondArray
	 * @return concatenaed aray
	 */
	 double[] concatenate(double[] firstArray , double[] secondArray){
		int aLen = firstArray.length;
		   int bLen = secondArray.length;
		   double[] finalArray= new double[aLen+bLen];
		   System.arraycopy(firstArray, 0, finalArray, 0, aLen);
		   System.arraycopy(secondArray, 0, finalArray, aLen, bLen);
		   return finalArray;
	}
	 
	 /**
	  * Fills the given Histogram with given values
	  * @param histogram
	  * @param values
	  * @return H1D filled with given values
	  */
	 H1D fillHistogram(H1D histogram , double[] values){
		for(int index =0 ; index < values.length ; index++){			
			histogram.fill(values[index]);			
	}
		return histogram;
	}

	/**
	 * Creates Plot object with the given histograms
	 * @param plotName
	 * @param histograms
	 * @return Plot object
	 */
	HPlot createPlot(String plotName , H1D... histograms){
		HPlot plot = new HPlot(plotName, 800, 600);
		plot.visible();		
		plot.cd(1, 1);
		plot.setAutoRange();		
		if(histograms.length == 1){
			plot.draw(histograms[0]);
		}else {
			plot.draw(histograms);
		}	
		return plot;
	}
	
	
	public void doPlottings(){
		//Base is set of observations with an expected 2800 background events  per bin	
		// Note we assume here flat but in class I used a "sloping" curve that represented experiment better
		int noOfElements = 42000;
		java.util.Random random =null;
		double[] base = new double[noOfElements];
		for(int index =0 ; index<noOfElements ; index++){
			base[index] = 110 + 30*Random.rand();
		}
		
		// Gauss is Number of Higgs particles
		double[] gauss = new double[300];
		random = new java.util.Random();
		for (int index = 0; index < gauss.length; index++) {
			gauss[index] = 2 * random.nextGaussian() + 126;
		}
		//# simpletotal is Higgs+Background
		double[] simpletotal = concatenate(base, gauss);
				
		H1D histogram1 = new H1D("base", 15, 110, 140);
		histogram1.setFill(true);
		histogram1.setBars(true);
		histogram1.setColor(Color.blue);
		fillHistogram(histogram1, base);
		
		H1D histogram2 = new H1D("gauss", 15, 110, 140);
		histogram2.setFill(true);
		histogram2.setBars(true);
		histogram2.setColor(Color.red);
		fillHistogram(histogram2, gauss);
		
		// Plotting without the error bar . This histogram API doesnt return the binedges and centers
		// Look corresponding Python program for error plot.
		createPlot("Uniform Background from 42000 events; 2 Gev Higgs", histogram1,histogram2);
		
		
	}
	
	public static void main(String[] args){
		new HiggsClassIIUniform().doPlottings();
	}
	
	
	
}
