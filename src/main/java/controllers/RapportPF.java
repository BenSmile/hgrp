/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author smile
 */
@Named(value = "rapportPF")
@SessionScoped
public class RapportPF implements Serializable {

    @PersistenceContext(unitName = "hrgpwebPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    private String mois;
    private String annee;

    private BarChartModel statModel;

    public BarChartModel getStatModel() {
        return statModel;
    }

    public void setStatModel(BarChartModel statModel) {
        this.statModel = statModel;
    }

    private HashMap<String, String> mapMap;

//    @PostConstruct
//    public void init() {
//        try {
//            createStatModels();
//        } catch (Exception e) {
//        }
//    }
    private void createStatModels() {
        statModel = initBarModel();
        statModel.setTitle("Fréquence des visites au cours du mois");
        statModel.setAnimate(true);
        statModel.setLegendPosition("se");
        org.primefaces.model.chart.Axis yAxis = statModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

    }

    public String stat() {
        createStatModels();
        return "/statistiqueMensuel.xhtml";
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries methods = new ChartSeries();

        methods.set("LTB", Integer.parseInt(LTB()));
        methods.set("IMPLANTS", Integer.parseInt(Implants()));
        methods.set("COC", Integer.parseInt(COC()));
        methods.set("COP", Integer.parseInt(COP()));
        methods.set("DMPA", Integer.parseInt(DMPA()));
        methods.set("Noristerat", Integer.parseInt(Noristerat()));
        methods.set("Méthode Naturelle'", Integer.parseInt(MethodeNaturelle()));
        methods.set("DIU Stérilet", Integer.parseInt(DIU()));
        methods.set("Fémidon", Integer.parseInt(Femidon()));
        methods.set("Préservatif", Integer.parseInt(Preservatif()));
        methods.set("Vasectomie", Integer.parseInt(Vasectomie()));
        methods.set("mama", Integer.parseInt(Mama()));
        methods.set("Collier du cycle", Integer.parseInt(CollierCycle()));
        methods.set("Autre", Integer.parseInt(Autre()));

        System.out.println("LTB = " + LTB());

        model.addSeries(methods);

        return model;
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

    public void setMapMap(HashMap<String, String> mapMap) {
        this.mapMap = mapMap;
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

    public RapportPF() {

    }

    public String print() throws IOException, JRException {

        String[] columns = new String[]{"EffectifConsulationPF", "EffectifConsulationPFHomme", "EffectifConsulationPFHommeCite", "EffectifConsulationPFHommeHC", "EffectifConsulationPFFemme",
            "EffectifConsulationPFFemmeCite", "EffectifConsulationPFFemmeHC", "ACTraites", "ACTraitesCite", "ACTraitesHC",
            "ACImplants", "ACImplantsCite", "ACImplantsHC", "ACRetraits", "ACRetraitsCite", "ACRetraitsHC", "NCSoustraits", "NCSoustraitsCite", "NCSoustraitsHC", "Date",
            "Complication", "ComplicationCite", "ComplicationHC", "LimiteInformation", "LimiteInformationCite", "LimiteInformationHC",
            "LTB", "LTBCite", "LTBHC", "Implants", "ImplantsCite", "ImplantsHC", "COC", "COCCite", "COCHC", "COP", "COPCite", "COPHC",
            "CollierCycle", "CollierCycleCite", "CollierCycleHC", "DMPA", "DMPACite", "DMPAHC", "Nosterilat", "NosterilatCite", "NosterilatHC",
            "MethodeNaturelle", "MethodeNaturelleCite", "MethodeNaturelleHC", "DIU", "DIUCite", "DIUHC", "Femidon", "FemidonCite", "FemidonHC",
            "Preservatif", "Mama", "Autres", "Vasectomie", "VasectomieCite", "VasectomieHC", "PreservatifCite",
            "PreservatifHC", "SuiviConseil", "SuiviConseilCite", "SuiviConseilHC", "MamaCite", "MamaHC", "AutreCite", "AutreHC", "NCSoustraitsHomme", "NCSoustraitsFemme",
             "NCSoustraitsCiteHomme", "NCSoustraitsHCHomme", "NCSoustraitsCiteFemme", "NCSoustraitsHCFemme"};
        System.out.println("columns = " + columns.length);
        String[][] data = new String[][]{{
            EffectifConsulationPF(), EffectifConsulationPFHomme(), EffectifConsulationPFHommeCite(), EffectifConsulationPFHommeHC(),
            EffectifConsulationPFFemme(), EffectifConsulationPFFemmeCite(), EffectifConsulationPFFemmeHC(), ACTraites(), ACTraitesCite(), ACTraitesHC(),
            ACRetraitsImplants(), ACRetraitsImplantsCite(), ACRetraitsImplantsHC(), ACRetraitsDIU(), ACRetraitsDIUCite(), ACRetraitsDIUHC(),
            NCSoustraits(), NCSoustraitsCite(), NCSoustraitsHC(), date(), Complication(), ComplicationCite(), ComplicationHC(), LimiteInformation(),
            LimiteInformationCite(), LimiteInformationHC(), LTB(), LTBCite(), LTBHC(),
            Implants(), ImplantsCite(), ImplantsHC(), COC(), COCCite(), COCHC(), COP(), COPCite(), COPHC(), CollierCycle(), CollierCycleCite(), CollierCycleHC(),
            DMPA(), DMPACite(), DMPAHC(), Noristerat(), NoristeratCite(), NoristeratHC(), MethodeNaturelle(), MethodeNaturelleCite(),
            MethodeNaturelleHC(), DIU(), DIUCite(), DIUHC(), Femidon(), FemidonCite(), FemidonHC(), Preservatif(), Mama(), Autre(), Vasectomie(),
            VasectomieCite(), VasectomieHC(), PreservatifCite(), PreservatifHC(), SuiviConseil(), SuiviConseilCite(), SuiviConseilHC(),
            MamaCite(), MamaHC(), AutreCite(), AutreHC(), NCSoustraitsHomme(), NCSoustraitsFemme(), NCSoustraitsCiteHomme(), NCSoustraitsHCHomme(), NCSoustraitsCiteFemme(), NCSoustraitsHCFemme()

        }};
        System.out.println("data = " + data.length);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rapports/pf3.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, null, new JRTableModelDataSource(new JTable(data, columns).getModel()));
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.addHeader("Content-disposition", "inline; filename=Rapport mensuel.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        servletOutputStream.write(JasperExportManager.exportReportToPdf(jasperPrint));
        servletOutputStream.flush();
        servletOutputStream.close();
        FacesContext.getCurrentInstance().renderResponse();
        FacesContext.getCurrentInstance().responseComplete();
        System.err.println("benjamin");
        System.out.println("Mois de " + mapMap.get(mois));
        System.out.println("mois " + mois);
        System.out.println("annee = " + annee);
        System.out.println("effectif consultations = " + EffectifConsulationPF());
        System.out.println("LTB = " + LTB());
        System.out.println("Preservatif = " + Preservatif());
        return "login";
    }

    public String printpage() {
        return "newjsf.xhtml?face-redirect=true";
    }

    private String EffectifConsulationPF() {
        Query query = em.createNativeQuery("select count(*) as nbre from "
                + " planfication_familiale where (month(date)=" + mois + " and year(date)=" + annee + ")");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String EffectifConsulationPFHomme() {
        Query query = em.createNativeQuery("select count(*) as nbre from "
                + " planfication_familiale inner join infos_femme using(numDossier) where genre='M' and (month(date)=" + mois + " and year(date)=" + annee + ")");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String EffectifConsulationPFFemme() {
        Query query = em.createNativeQuery("select count(*) as nbre from "
                + " planfication_familiale inner join infos_femme using(numDossier) where genre='F' and (month(date)=" + mois + " and year(date)=" + annee + ")");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ACTraites() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date)<=" + annee + "))");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ACTraitesCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale"
                + " inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date)<=" + annee + ")) "
                + "and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ACTraitesHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale "
                + "inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier in (select numDossier from planfication_familiale where"
                + " (month(date) <> " + mois + " and year(date)<=" + annee + ")) and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ACRetraitsImplants() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier in (select numDossier from planfication_familiale where (month(date) = " + mois + " and year(date)=" + annee + ")) "
                + "and Retrait_implant='oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ACRetraitsImplantsCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier in (select numDossier from planfication_familiale where (month(date) = " + mois + " and year(date)=" + annee + ")) "
                + "and Retrait_implant='oui' and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ACRetraitsImplantsHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier in (select numDossier from planfication_familiale where (month(date) = " + mois + " and year(date)=" + annee + ")) "
                + "and Retrait_implant='oui' and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ACRetraitsDIU() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Retrait_DIU='oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ACRetraitsDIUCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Retrait_DIU='oui'  and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ACRetraitsDIUHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Retrait_DIU='oui' and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ComplicationCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Complication='oui' and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String ComplicationHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Complication='oui' and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String Complication() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Complication='oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String SuiviConseil() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Counsling='oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String SuiviConseilCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Counsling='oui' and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String SuiviConseilHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Counsling='oui' and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String LimiteInformation() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + " Limite_information='oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String LimiteInformationCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + " Limite_information='oui' and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String LimiteInformationHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numDossier) where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + " Limite_information='oui' and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NCSoustraits() {
        Query query = em.createNativeQuery("select count(distinct numDossier) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier not in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date) <= " + annee + "))");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NCSoustraitsFemme() {
        Query query = em.createNativeQuery("select count(distinct numDossier) from planfication_familiale inner join infos_femme using(numdossier) where genre='F' and (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier not in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date) <= " + annee + "))");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NCSoustraitsHomme() {
        Query query = em.createNativeQuery("select count(distinct numDossier) from planfication_familiale inner join infos_femme using(numdossier) where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier not in (select numDossier from planfication_familiale where genre='M' and (month(date) <> " + mois + " and year(date) <= " + annee + "))");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NCSoustraitsCite() {
        Query query = em.createNativeQuery("select count(distinct numDossier) from planfication_familiale inner join infos_femme using(numdossier) where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier not in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date) <= " + annee + ")) and (provenance='AS' or provenance='ZS') ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NCSoustraitsCiteHomme() {
        Query query = em.createNativeQuery("select count(distinct numDossier) from planfication_familiale inner join infos_femme using(numdossier) where genre ='M' and  (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier not in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date) <= " + annee + ")) and (provenance='AS' or provenance='ZS') ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NCSoustraitsCiteFemme() {
        Query query = em.createNativeQuery("select count(distinct numDossier) from planfication_familiale inner join infos_femme using(numdossier) where genre ='F' and  (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier not in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date) <= " + annee + ")) and (provenance='AS' or provenance='ZS') ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NCSoustraitsHC() {
        Query query = em.createNativeQuery("select count(distinct numDossier) from planfication_familiale inner join infos_femme using(numdossier) where (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier  not in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date) <= " + annee + ")) and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NCSoustraitsHCHomme() {
        Query query = em.createNativeQuery("select count(distinct numDossier) from planfication_familiale inner join infos_femme using(numdossier) where genre ='M' and (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier  not in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date) <= " + annee + ")) and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NCSoustraitsHCFemme() {
        Query query = em.createNativeQuery("select count(distinct numDossier) from planfication_familiale inner join infos_femme using(numdossier) where genre ='F' and (month(date) = " + mois + " and year(date) = " + annee + ") and "
                + "numDossier  not in (select numDossier from planfication_familiale where (month(date) <> " + mois + " and year(date) <= " + annee + ")) and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String date() {
        return mapMap.get(mois) + " " + annee;
    }

    private String dateRapport() {
        return String.valueOf(new Date());
    }

    /*
    METHODES DE CONTRACEPTION
     */
    public String LTB() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where year(date)=" + annee + " and month(date)=" + mois + " and Methode_choisie='ltb'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String LTBCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='AS' or provenance='ZS') and methode_choisie='ltb'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String LTBHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='HZ' or provenance='HAS') and methode_choisie='ltb'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String Implants() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='IMPLANTS'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String ImplantsCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='ZS' or provenance='AS') and methode_choisie='IMPLANTS'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String ImplantsHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='HAS' or provenance='HZ') and methode_choisie='IMPLANTS'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String COC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='COC'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String COCHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='HAS' or provenance='HZ')  and methode_choisie='COC'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String COCCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='AS' or provenance='ZS') and methode_choisie='COC'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String COP() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='COP'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String COPCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='AS' or provenance='ZS')  and methode_choisie='COP'");
        Object firstResult = query.getSingleResult();;
        return String.valueOf(firstResult);
    }

    public String COPHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='HAS' or provenance='HZ') and methode_choisie='COP'");
        Object firstResult = query.getSingleResult();;
        return String.valueOf(firstResult);
    }

    public String CollierCycle() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='Collier du cycle'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String CollierCycleCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='AS' or provenance='ZS') and methode_choisie='Collier du cycle'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String CollierCycleHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='HZ' or provenance='HAS') and methode_choisie='Collier du cycle'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String DMPA() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='DMPA'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String DMPAHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier)"
                + " where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='DMPA' and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String DMPACite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier)"
                + " where  (provenance='AS' or provenance='ZS') and"
                + "(month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='DMPA'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String Noristerat() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='Noristerat'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String NoristeratCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='Noristerat' and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String NoristeratHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier)  where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='Noristerat' and (provenance='HZ' or provenance='HAS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String MethodeNaturelleHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale join infos_femme using(numdossier) "
                + "where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='Méthode Naturelle' and (provenance='HAS' or provenance='HS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String MethodeNaturelleCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale join infos_femme using(numdossier) "
                + "where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='Méthode Naturelle' and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String MethodeNaturelle() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='Méthode Naturelle'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String DIU() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='DIU Stérilet'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String DIUCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='AS' or provenance='ZS')  and methode_choisie='DIU Stérilet'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String DIUHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='HZ' or provenance='HAS') and methode_choisie='DIU Stérilet'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String Femidon() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='Fémidon'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String FemidonCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='ZS' or provenance='AS') and methode_choisie='Fémidon'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String FemidonHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='HZ' or provenance='HAS') and methode_choisie='Fémidon'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String Preservatif() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Methode_choisie='Préservatif'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String PreservatifCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Methode_choisie='Préservatif' and (provenance='ZS' or provenance='AS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String PreservatifBKV() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Methode_choisie='Préservatif'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String PreservatifHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (month(date) = " + mois + " and year(date) = " + annee + ") "
                + "and Methode_choisie='Préservatif' and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String Vasectomie() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='mama'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String VasectomieCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='mama' and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String VasectomieBKV() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='mama'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String VasectomieHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='mama' and (provenance='HAS' or provenance='HZ')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String Mama() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + "and Methode_choisie='mama'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String MamaCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='AS' or provenance='ZS') and methode_choisie='mama'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String MamaHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='HAS' or provenance='HZ') and methode_choisie='mama'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String Autre() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale where (month(date) = " + mois + " and year(date) = " + annee + ")"
                + " and Methode_choisie='autre'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String AutreCite() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='AS' or provenance='ZS') and methode_choisie='autre'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public String AutreHC() {
        Query query = em.createNativeQuery("select count(*) from planfication_familiale inner join infos_femme using(numdossier) "
                + "where (year(date)=" + annee + " and month(date) = " + mois + ") and (provenance='HAS' or provenance='HZ') and methode_choisie='autre'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String EffectifConsulationPFHommeCite() {
        Query query = em.createNativeQuery("select count(*) as nbre from "
                + " planfication_familiale inner join infos_femme using(numDossier) where genre='M' and (month(date)=" + mois + " and year(date)=" + annee + ")"
                + " and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String EffectifConsulationPFHommeHC() {
        Query query = em.createNativeQuery("select count(*) as nbre from "
                + " planfication_familiale inner join infos_femme using(numDossier) where genre='M' and (month(date)=" + mois + " and year(date)=" + annee + ")"
                + " and (provenance='HZ' or provenance='HAS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String EffectifConsulationPFFemmeCite() {
        Query query = em.createNativeQuery("select count(*) as nbre from "
                + " planfication_familiale inner join infos_femme using(numDossier) where genre='F' and (month(date)=" + mois + " and year(date)=" + annee + ")"
                + " and (provenance='AS' or provenance='ZS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String EffectifConsulationPFFemmeHC() {
        Query query = em.createNativeQuery("select count(*) as nbre from "
                + " planfication_familiale inner join infos_femme using(numDossier) where genre='F' and (month(date)=" + mois + " and year(date)=" + annee + ")"
                + " and (provenance='HZ' or provenance='HAS')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

}
