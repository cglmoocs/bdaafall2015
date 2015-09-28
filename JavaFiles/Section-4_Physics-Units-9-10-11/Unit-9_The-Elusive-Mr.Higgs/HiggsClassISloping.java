

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import jhplot.*;
import jhplot.math.Random;


/**
 * Code for the unit "The Elusive Mr. Higgs". 
 * It explains the experiment with higgs signal and background signal under different settings
 * 
 * Compilation:  javac HiggsClassISloping.java
 * Execution:    java HiggsClassISloping
 * Dependencies: SCAVIS jars added to classpath
 * 
 */

public class HiggsClassISloping {
	
	/**
	 * Concatenates two given arrays
	 * @param firstArray
	 * @param secondArray
	 * @return concatenated aray
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
	
	/**
	 * Plottings for the Physics unit 'The Elusive Mr. Higgs'	
	 */
	public void doPlottings(){
		java.util.Random random =null;
/****************************************************************************************************
 * 					Create the background for the setup and plot the same							*
 ****************************************************************************************************/
		
// A random array have 42000 elements according to the uniform distribution. The numbers generated will between 0 and 1
	int noOfElements = 42000;
	double[] testrand = new double[noOfElements];
	for (int index = 0; index < noOfElements; index++) {
		testrand[index] = Random.rand();
	}
// Generating a uniform background(base) between a 110 GeV and 140 GeV 		
	double[] base = new double[noOfElements];
	for(int index =0 ; index<noOfElements ; index++){
		base[index] = 110 + 30*Random.rand();
	}
// To create a boolean index which has True for 100% samples at 110GeV; 
//This percentage reduces linearly as the value for background increases and has ture for 50% samples as 140 GeV		
	boolean[] indexes = new boolean[42000];
	int noOfTrueValues = 0;
	for (int index = 0; index < 42000; index++) {
		if ((1.0 - 0.5 * (base[index] - 110) / 30) > testrand[index]) {
			indexes[index] = true;
			noOfTrueValues++;
		}
	}	
// This generates a sloping background. Here the values in base corresponding the True values in "index" are retained rest are discarded. 
//So this has a distribution as described above		
	double[] sloping = new double[noOfTrueValues];
	for (int index = 0, index2 = 0; index < 42000; index++) {
		if (indexes[index]) {
			sloping[index2] = base[index];
			index2++;
		}
	}
//Plotting - Sloping Background. 
//See The Plot named "Sloping"		
	H1D histogram1 = new H1D("Sloping Background rom 42000 events", 15,
			110, 140);
	histogram1.setFill(true);
	histogram1.setBars(true);
	fillHistogram(histogram1, sloping);
	createPlot("Sloping", histogram1);
		
/************************************************************************************************************************************
 * 		Create a Gaussian Higgs signal(Gaussian signal is what we will get due to error in measurement). 							*
 *		The width of the Gaussian indicated the extent of measurement error. This signal has 300 samples																															*
 ************************************************************************************************************************************/	
//The signal is centered at 126 GeV and has a width of 2.
	double[] gauss = new double[300];
	random = new java.util.Random();
	for (int index = 0; index < gauss.length; index++) {
		gauss[index] = 2 * random.nextGaussian() + 126;
	}
//A signal with centered at 126 GeV and width of 0.5(Error in measurement is less than previous signal
	double[] narrowGauss = new double[300];
	random = new java.util.Random();
	for (int index = 0; index < narrowGauss.length; index++) {
		narrowGauss[index] = 0.5 * random.nextGaussian() + 12;
	}
//Plotting - The Higgs Signal with width 2.0. 
// See the plot named "Higgs Alone"		
	H1D histogram2 = new H1D("2Gev Higgs in 2 GeV bins on its own", 15,
			110, 140);
	histogram1.setFill(true);
	histogram2.setBars(true);
	fillHistogram(histogram2, gauss);
	createPlot("HiggsAlone", histogram2);
/************************************************************************************************************
 * Create the actual Signal by combining the higs signals(Gaussian signals) and the background signals		*
 ************************************************************************************************************/		
//Accumalate the sloping Background and gauss(width = 2.0)
	double[] total = concatenate(sloping, gauss);
//Accumalate the sloping background and narrowGauss(width = 0.5)
	double[] narrowTotal = concatenate(sloping, narrowGauss);
//Plotting - The 3 kinds of signals(Sloping Background, Higgs Signal, Combined Signal) where Higgs Signal has width 0.5. 
//The plot has 15 bins(each bin represents 2 GeV). 
//See The Plot named "Total Narrow Higgs"
	H1D histogram3 = new H1D("narrowtotal", 15, 110, 140);
	histogram3.setFill(true);
	histogram3.setBars(true);
	fillHistogram(histogram3, narrowTotal);

	H1D histogram4 = new H1D("sloping", 15, 110, 140);
	histogram4.setFill(true);
	histogram4.setBars(true);
	fillHistogram(histogram4, sloping);

	H1D histogram5 = new H1D("narrowgauss", 15, 110, 140);
	histogram5.setFill(true);
	histogram5.setBars(true);
	fillHistogram(histogram5, narrowGauss);
			
	createPlot("0.5 Ge Higgs", histogram3,histogram4,histogram5);
		
//Plotting - The 3 kinds of signals(Sloping Background, Higgs Signal, Combined Signal) 
//where Higgs Signal has width 0.5. The plot has 30 bins(each bin represents 1GeV).
//See The Plot named "Total Narrow Higgs Bin 1 GeV"
		
	H1D histogram6 = new H1D("narrowtotal", 30, 110, 140);
	histogram6.setFill(true);
	histogram6.setBars(true);
	fillHistogram(histogram6, narrowTotal);
	
	H1D histogram7 = new H1D("sloping", 30, 110, 140);
	histogram7.setFill(true);
	histogram7.setBars(true);
	fillHistogram(histogram7, sloping);
	
	H1D histogram8 = new H1D("narrowgauss", 30, 110, 140);
	histogram8.setFill(true);
	histogram8.setBars(true);
	fillHistogram(histogram8, narrowGauss);
	
	createPlot("Total Narrow Higgs Bin 1 GeV", histogram6, histogram7,
			histogram8);
// Plotting - The 3 kinds of signals(Sloping Background, Higgs Signal,
// Combined Signal) where Higgs Signal has width 0.5.
// See The Plot named "Total Narrow Higgs Bin 0.5 GeV

	H1D histogram9 = new H1D("narrowtotal", 60, 110, 140);
	histogram9.setFill(true);
	histogram9.setBars(true);
	fillHistogram(histogram9, narrowTotal);

	H1D histogram10 = new H1D("sloping", 60, 110, 140);
	histogram10.setFill(true);
	histogram10.setBars(true);
	fillHistogram(histogram10, sloping);

	H1D histogram11 = new H1D("narrowgauss", 60, 110, 140);
	histogram11.setFill(true);
	histogram11.setBars(true);
	fillHistogram(histogram11, narrowGauss);

	createPlot("Total Narrow Higgs Bin 0.5 GeV", histogram9, histogram10,
			histogram11);
				
//Plotting - The 3 kinds of signals(Sloping Background, Higgs Signal, Combined Signal) signal where Higgs Signal has width 2.0. 
//The plot has 15 bins(each bin represents 2GeV).
//See The Plot named "Total Wide Higgs Bin 2 GeV"
		
	H1D histogram12 = new H1D("total", 60, 110, 140);
	histogram12.setFill(true);
	histogram12.setBars(true);
	histogram12.setColor(Color.blue);
	fillHistogram(histogram12, total);

	H1D histogram13 = new H1D("sloping", 60, 110, 140);
	histogram13.setFill(true);
	histogram13.setBars(true);
	//histogram13.g
	//histogram13.setColor(Color.green);
	fillHistogram(histogram13, sloping);

	H1D histogram14 = new H1D("gauss", 60, 110, 140);
	histogram14.setFill(true);
	histogram14.setBars(true);
	histogram14.setColor(Color.red);
	fillHistogram(histogram14, gauss);

	createPlot("2 Gev Higgs in 2 GeV bins with Sloping Background",
			histogram12, histogram13, histogram14);
		
/********************************************
 * Computing the bin centers and Errors		*
 ********************************************/
	double centres[] = histogram12.binCenters();
	double errors[] ;
				
	// Plotting - The 3 kinds of signals(Sloping Background, Higgs Signal,
	// Combined Signal) and
	// expected errors where Higgs Signal has width 2.0. The plot has 60
	// bins(each bin represents 0.5GeV).
	// See The Plot named "Total Wide Higgs Bin 2 GeV with errors"

	H1D histogram15 = new H1D("total", 15, 110, 140);
	histogram15.setFill(true);
	histogram15.setBars(true);
	histogram15.setColor(Color.blue);
	fillHistogram(histogram15, total);

	H1D histogram16 = new H1D("sloping", 60, 15, 140);
	histogram16.setFill(true);
	histogram16.setBars(true);
	histogram16.setColor(Color.green);
	fillHistogram(histogram16, sloping);

	H1D histogram17 = new H1D("gauss", 60, 15, 140);
	histogram17.setFill(true);
	histogram17.setBars(true);
	histogram17.setColor(Color.red);
	fillHistogram(histogram17, gauss);
	createPlot(
			"2 Gev Higgs in 2 GeV bins with Sloping Background + Errors",
			histogram15, histogram16, histogram17);
/************************************************************************************************************************************
 * Creating a Higgs Signal with 30000 elements. If we use this against the original backgrounds, we study the effect of 			*
 *		making the Higgs 100 times more likely(The original number of Higgs samples was 300)										*
 ************************************************************************************************************************************/				

	double[] gaussBig = new double[30000];
	random = new java.util.Random();
	for (int index = 0; index < gauss.length; index++) {
		gauss[index] = 2 * random.nextGaussian() + 126;
	}
	double[] guassNarrowBig = new double[30000];
	random = new java.util.Random();
	for (int index = 0; index < narrowGauss.length; index++) {
		narrowGauss[index] = 0.5 * random.nextGaussian() + 126;
	}
	double[] totalBig = concatenate(gaussBig, guassNarrowBig);
		//H1D histogram6 

	H1D histogram18 = new H1D("gaussBig", 60, 110, 140);
	histogram18.setFill(true);
	histogram18.setBars(true);
	//histogram15.setColor(Color.blue);
	fillHistogram(histogram18, gaussBig);

	H1D histogram19 = new H1D("guassNarrowBig", 60, 15, 140);
	histogram19.setFill(true);
	histogram19.setBars(true);
	//histogram16.setColor(Color.green);
	fillHistogram(histogram19, guassNarrowBig);
	createPlot(
			"30000 Narrow and Wide Higgs in 0.5 GeV bins",
			histogram18, histogram19);
//Plotting - The 3 kinds of signals(Sloping Background, Higgs Signal, Combined Signal) where Higgs Signal has width 2.0 and is 100 times more frequent.
// The plot has 15 bins(each bin represents 2GeV).
//See The Plot named "Total Wide Higgs Bin 2 GeV 100 times Higgs" 	

	H1D histogram20 = new H1D("totalBig", 15, 110, 140);
	histogram20.setFill(true);
	histogram20.setBars(true);
	//histogram15.setColor(Color.blue);
	fillHistogram(histogram20, totalBig);

	H1D histogram21 = new H1D("sloping", 15, 110, 140);
	histogram21.setFill(true);
	histogram21.setBars(true);
	//histogram21.getV
	//histogram16.setColor(Color.green);
	fillHistogram(histogram21, sloping);
	
	H1D histogram22 = new H1D("gaussbig", 15, 110, 140);
	histogram22.setFill(true);
	histogram22.setBars(true);
	//histogram16.setColor(Color.green);
	fillHistogram(histogram22, gaussBig);
	createPlot(
			"Total Wide Higgs Bin 2 GeV 100 times Higgs",
			histogram20, histogram21,histogram22);
		
	
	
	// 'Creating a setup with 1% data. Now the background has initially 420 elements
	double[] testrand420 = new double[420];	
	random = new java.util.Random();
	for (int index = 0; index < testrand420.length; index++) {
		testrand420[index] =  random.nextGaussian();
	}
	double[] base420 = new double[420];	
	random = new java.util.Random();
	for (int index = 0; index < base420.length; index++) {
		base420[index] =  110 + 30*random.nextGaussian();
	}
	List<Double> sloping420 = new ArrayList<Double>();
	random = new java.util.Random();
	for (int index = 0; index < base420.length; index++) {
		if((1.0 - 0. * (base420[index]-110)/30) > testrand420[index]){
			sloping420.add(base420[index]);
		}	
	}
	double[] sloping420Array = new double[sloping420.size()];
	int index = 0;
	for(double value : sloping420){
		sloping420Array[index++] = value;
	}
	H1D histogram23 = new H1D("sloping420", 15, 110, 140);
	histogram23.setFill(true);
	histogram23.setBars(true);
	fillHistogram(histogram23, sloping420Array);
	createPlot(
			"Sloping Background from 420 events (1%)",
			histogram23);
	
	}

	/**
	 * Client for the The Elusive Mr. Higgs unit
	 * @param args
	 */
	public static void main(String args[]){		
	new HiggsClassISloping().doPlottings();	
	}

}
