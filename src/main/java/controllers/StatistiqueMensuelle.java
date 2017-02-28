/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author smile
 */
@Named(value = "statPF")
@SessionScoped
public class StatistiqueMensuelle implements Serializable {

    @PersistenceContext(unitName = "hrgpwebPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    private BarChartModel statModel;

    public BarChartModel getStatModel() {
        return statModel;
    }

    public void setStatModel(BarChartModel statModel) {
        this.statModel = statModel;
    }

    private String mois;
    private String annee;

    private HashMap<String, String> mapMap;

    public void setMapMap(HashMap<String, String> mapMap) {
        this.mapMap = mapMap;
    }

    public HashMap<String, String> getMapMap() {
        mapMap = new HashMap<>();
        mapMap.put("1", "Janvier");
        mapMap.put("2", "Fevrier");
        mapMap.put("3", "Mars");
        mapMap.put("4", "Avril");
        mapMap.put("5", "Mai");
        mapMap.put("6", "Juin");
        mapMap.put("7", "Juillet");
        mapMap.put("8", "Aout");
        mapMap.put("9", "Septembre");
        mapMap.put("10", "Octobre");
        mapMap.put("11", "Novembre");
        mapMap.put("12", "Decembre");

        return mapMap;
    }

    public StatistiqueMensuelle() {

    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @PostConstruct
    public void init() {
        try {
            createStatModels();
        } catch (Exception e) {
        }
    }

    private void createStatModels() {
        statModel = initBarModel();
        statModel.setTitle("Fréquence des visites au cours du mois");
        statModel.setAnimate(true);
        statModel.setLegendPosition("se");
        org.primefaces.model.chart.Axis yAxis = statModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries methods = new ChartSeries();

        methods.set("LTB", LTB());
        methods.set("IMPLANTS", Implants());
        methods.set("COC", COC());
        methods.set("COP", COP());
        methods.set("DMPA", DMPA());
        methods.set("Noristerat", Noristerat());
        methods.set("Méthode Naturelle'", MethodeNaturelle());
        methods.set("DIU Stérilet", DUISterilet());
        methods.set("Fémidon", Femidon());
        methods.set("Préservatif", Preservatif());
        methods.set("mama", Mama());
        methods.set("Collier du cycle", CollierCycle());
        methods.set("Autre", Autre());

        System.out.println("LTB = " + LTB());
        
        model.addSeries(methods);

        return model;
    }

    /*
    METHODES DE CONTRACEPTION
     */
    public int LTB() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where year(date)=" + annee + " and month(date)=" + mois + " and Methode_choisie='ltb'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int Implants() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='IMPLANTS'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int COC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='COC'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int COP() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='COP'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int CollierCycle() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='Collier du cycle'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int DMPA() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='DMPA'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int Noristerat() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='Noristerat'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int MethodeNaturelle() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='Méthode Naturelle'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int DUISterilet() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='DIU Stérilet'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int Femidon() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='Fémidon'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int Preservatif() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Methode_choisie='Préservatif'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int Mama() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='mama'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

    public int Autre() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='autre'");
        Object firstResult = query.getSingleResult();
        return Integer.parseInt(String.valueOf(firstResult));
    }

}
