import java.awt.Color;
import java.util.Random;
import jhplot.H1D;
import jhplot.HPlot;

/**
 * This file contains code for a the Unit "A Calculated Dice Roll. It explains random number generation
 * 
 * Compilation:  javac HiggsClassIVSeeds.java
 * Execution:    java HiggsClassIVSeeds
 * Dependencies: SCAVIS jars added to classpath
 */

public class HiggsClassIVSeeds {

	public static void main(String arg[]) {

		Random random = null;
		/***********************************************************************************************************************************
		 * Create two sets of random numbers with the same seed(1234567) and plot them on top of each other.                               *
		 * As identical sets of random numbers are created with identical seeds, you will get two plots exactly on top of each other       *
		 **********************************************************************************************************************************/
		
		 random = new Random(1234567); //set the seed of the random number generator to 1234567
		double[] base = new double[42000];// generate 42000 random numbers between 110 and 140
		for (int i = 0; i < base.length; i++) {
			base[i] = 110 + 30 * random.nextGaussian();
		}

		H1D histogram = new H1D("Base", 15, 110, 140);
		histogram.fill(base); //Plot the histogram for the first set
		histogram.setFill(true);
		histogram.setBars(true);
		histogram.setFillColor(Color.blue);
		histogram.setFillColorTransparency(0.5);

		random = new Random(1234567); //set the seed of the random number generator to 1234567 for the second set
		double[] base2 = new double[42000]; //Generate the second set of random numbers
		for (int i = 0; i < base2.length; i++) {
			base2[i] = 110 + 30 * random.nextGaussian();
		}

		H1D histogram1 = new H1D("Base", 15, 110, 140); //Plot the histogram for the second set
		histogram1.fill(base2);
		histogram1.setFill(true);
		histogram1.setBars(true);
		histogram1.setFillColor(Color.yellow);
		histogram1.setFillColorTransparency(0.5);

		HPlot hPlot = new HPlot(
				"Two histograms on top of each other as identical random numbers",
				800, 600);
		hPlot.visible();
		hPlot.cd(1, 1);
		hPlot.setAutoRange();
		hPlot.draw(new H1D[] { histogram, histogram1 });
		
		/***********************************************************************************************************************************
		 * Create two sets of random  numbers with different seeds and plot them on top of each other                                      *
		 * Differences can be seen in the plot																						       *
		 **********************************************************************************************************************************/
		 random = new Random(1234567); //set the seed of the random number generator to 1234567 for the first set of random numbers
		double[] base3 = new double[42000];//Generate a set of 42000 random numbers between 110 and 140(first set)
		for (int i = 0; i < base3.length; i++) {
			base3[i] = 110 + 30 * random.nextGaussian();
		}

		H1D histogram2 = new H1D("Base3", 15, 110, 140);
		histogram2.fill(base3);
		histogram2.setFill(true);
		histogram2.setBars(true);
		histogram2.setFillColor(Color.blue);
		histogram2.setFillColorTransparency(0.5);

		double[] base4 = new double[42000];// Generate the second set of 42000 numbers between 110 and 140. 
		//Note that for this set the seed set will depend on where the first set ends.
		for (int i = 0; i < base4.length; i++) {
			base4[i] = 110 + 30 * random.nextGaussian();
		}

		H1D histogram3 = new H1D("Base4", 15, 110, 140);
		histogram3.fill(base4);
		histogram3.setFill(true);
		histogram3.setBars(true);
		histogram3.setFillColor(Color.green);
		histogram3.setFillColorTransparency(0.5);
		
		random = new Random(7654321); //Set the seed value for the generator to be 7654321
		double[] base5 = new double[42000];
		for (int i = 0; i < base5.length; i++) {
			base5[i] = 110 + 30 * random.nextGaussian();
		}

		H1D histogram4 = new H1D("Base5", 15, 110, 140);
		histogram4.fill(base5);
		histogram4.setFill(true);
		histogram4.setBars(true);
		histogram4.setFillColor(Color.red);
		histogram4.setFillColorTransparency(0.5);
		
		
		HPlot hPlot2 = new HPlot(
				"Three distinct histograms as different random numbers",
				800, 600);
		hPlot2.visible();
		hPlot2.setAutoRange();
		hPlot2.draw(new H1D[] { histogram2, histogram3,histogram4 });

	}

}
