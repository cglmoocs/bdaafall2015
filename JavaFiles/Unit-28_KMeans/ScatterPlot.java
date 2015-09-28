// package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ScatterPlot extends JFrame {

	/**
	 * Constructor
	 * @param title 
	 * @param size
	 * @param plottingDataSet
	 */
	public ScatterPlot(String title, int size,
			Map<String, XYSeries> plottingDataSet) {
		super(title);
		final ChartPanel chartPanel = createPlottingPanel(title, plottingDataSet);
		chartPanel.setPreferredSize(new Dimension(size, size));
		this.add(chartPanel, BorderLayout.CENTER);

	}

	/**
	 * Creates the Plotting Panel
	 * @param title - Title of the Plot
	 * @param plottingDataSet - PLotting Data Set
	 * @return - Plotting Panel
	 */
	private ChartPanel createPlottingPanel(String title,
			Map<String, XYSeries> plottingDataSet) {
		JFreeChart jfreechart = ChartFactory.createScatterPlot(title, "X", "Y",
				createSampleData(plottingDataSet), PlotOrientation.VERTICAL,
				true, true, false);
		XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
		xyPlot.setDomainCrosshairVisible(true);
		xyPlot.setRangeCrosshairVisible(true);
		xyPlot.setBackgroundPaint(Color.white);
		return new ChartPanel(jfreechart);
	}

	/**
	 * Creates XYSeriesCollection for the given Plotting Data Set
	 * @param plottingDataSet - Plotting Data set of each cluster.
	 * @return
	 */
	public XYDataset createSampleData(Map<String, XYSeries> plottingDataSet) {
		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		for (String key : plottingDataSet.keySet()) {
			xySeriesCollection.addSeries(plottingDataSet.get(key));
		}
		return xySeriesCollection;
	}

}
