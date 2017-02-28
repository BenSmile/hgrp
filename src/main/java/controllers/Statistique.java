/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import javafx.scene.chart.Axis;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author dtp
 */
@ManagedBean
public class Statistique implements Serializable {

    private LineChartModel animatedModel1;
    private BarChartModel animatedModel2;

    @PostConstruct
    public void init() {
        createAnimatedModels();
    }

    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }

    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }

    private void createAnimatedModels() {
        animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Fréquence des visites au cours du mois");
        animatedModel1.setAnimate(true);
        animatedModel1.setLegendPosition("se");
        org.primefaces.model.chart.Axis yAxis = animatedModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Bar Charts");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);

        model.addSeries(boys);
        model.addSeries(girls);

        return model;
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("ZS");

        
        series1.set(4, 6);
        series1.set(5, 8);
        series1.set(6, 2);
        series1.set(7, 1);
        series1.set(8, 3);
        series1.set(9, 6);
        series1.set(10, 8);
        series1.set(11, 2);
        series1.set(12, 1);
        series1.set(13, 3);
        series1.set(14, 6);
        series1.set(15, 8);
        series1.set(16, 2);
        series1.set(17, 1);
        series1.set(18, 3);
        series1.set(19, 6);
        series1.set(20, 8);
        series1.set(21, 2);
        series1.set(22, 1);
        series1.set(23, 3);
        series1.set(24, 6);
        series1.set(25, 8);
        series1.set(26, 2);
        series1.set(27, 1);
        series1.set(28, 3);
        series1.set(29, 6);
        series1.set(30, 8);
        series1.set(31, 2);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("HZ");

        
        series2.set(4, 7);
        series2.set(5, 9);
        series2.set(6, 2);
        series2.set(7, 1);
        series2.set(8, 3);
        series2.set(9, 6);
        series2.set(10, 3);
        series2.set(11, 6);
        series2.set(12, 7);
        series2.set(13, 2);
        series2.set(14, 2);
        series2.set(15, 2);
        series2.set(16, 2);
        series2.set(17, 9);
        series2.set(18, 4);
        series2.set(19, 6);
        series2.set(20, 9);
        series2.set(21, 2);
        series2.set(22, 1);
        series2.set(23, 6);
        series2.set(24, 2);
        series2.set(25, 9);
        series2.set(26, 5);
        series2.set(27, 1);
        series2.set(28, 7);
        series2.set(29, 6);
        series2.set(30, 3);
        series2.set(31, 10);
        model.setMouseoverHighlight(true);
        model.setShadow(true);
        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }

}
