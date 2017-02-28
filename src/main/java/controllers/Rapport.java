package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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

/**
 *
 * @author dtp
 */
@ManagedBean
@RequestScoped
public class Rapport {

    @PersistenceContext(unitName = "hrgpwebPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of Rapport
     */
    public String print() throws JRException, IOException {

//        Connection con = null;
//
//        try {
//
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hgrpweb_bd1",
//                    "root", "root");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        String[] columns = new String[]{
            "SeancesRealisesees",
            "NbGestantesZS", "NbGestantesHZ", "NbGestantesCPN2Plus",
            "DontRefereParCsZS", "DontRefereParCsHZ", "DontRefereParCsCPN2Plus",
            "FeAvec3CPNAu8emEt9emMoisZS", "FeAvec3CPNAu8emEt9emMoisHZ",
            "FeAyantConcultePour2emCpnZS", "FeAyantConcultePour2emCpnHZ",
            "FeAyantConcultePour3emCpnZS", "FeAyantConcultePour3emCpnHZ",
            "FeAyantConcultePour4emCpnOuPlusZS", "FeAyantConcultePour4emCpnOuPlusHZ",
            "FeARisqueDetecteesZS", "FeARisqueDetecteesHZ",
            "FeARisqueRefereesZS", "FeARisqueRefereesHZ",
            "FerAcideFolique1ereDoseZS", "FerAcideFolique1ereDoseHZ",
            "FerAcideFolique2ereDoseZS", "FerAcideFolique2ereDoseHZ",
            "FerAcideFolique3ereDoseZS", "FerAcideFolique3ereDoseHZ",
            "SulfadoxPyrimet1ereDoseZS", "SulfadoxPyrimet1ereDoseHZ",
            "SulfadoxPyrimet2ereDoseZS", "SulfadoxPyrimet2ereDoseHZ",
            "SulfadoxPyrimet3ereDoseVIHPlusZS", "SulfadoxPyrimet3ereDoseVIHPlusHZ",
            "FeAyantRecuVAT2emeA5emeDoseZS", "FeAyantRecuVAT2emeA5emeDoseHZ",
            "FeAyantCompletementVaccineesAvantGrossesseZS", "FeAyantCompletementVaccineesAvantGrossesseHZ",
            "FeEnceintesAyantAcquisUneMilZS", "FeEnceintesAyantAcquisUneMilHZ",
            "FeEnceintesAyantRecuMebendazole2emeTrimZS", "FeEnceintesAyantRecuMebendazole2emeTrimHZ",
            "VAT1ZS", "VAT1HZ",
            "VAT2ZS", "VAT2HZ",
            "VAT3ZS", "VAT3HZ",
            "VAT4ZS", "VAT4HZ",
            "VAT5ZS", "VAT5HZ",
            "QuiOntEteConseilleePourTestZS", "QuiOntEteConseilleePourTestHZ",
            "QuiOntEteTesteePourVIHZS", "QuiOntEteTesteePourVIHHZ",
            "QuiOnteuTestPositifZS", "QuiOnteuTestPositifHZ",
            "QuiOnEteInformeeDuResultatZS", "QuiOnEteInformeeDuResultatHZ",
            "QuiOnEuTestPositifEtInformeeDuResultatZS", "QuiOnEuTestPositifEtInformeeDuResultatHZ",
            "QuiOntEuGrossesseALIssuDunViolZS", "QuiOntEuGrossesseALIssuDunViolHZ",
            "NBAccouchementVIHPlus", "dontAyantRecuTritherapie",
            "NBEnfantsNesDeMereVIHPlus", "dontAyantPrislaTritherapie",
            "NbConsultationsZS", "NbConsultationsHZ",
            "NbConsultationsCPoN2Plus42eJr", "NbAccouchementAyantRecuVitamineZS",
            "NbAccouchementAyantRecuVitamineHZ", "NbAccouchementAyantRecuFerAcideFoliqueZS",
            "NbAccouchementAyantRecuFerAcideFoliqueHZ", "NbFemmeAyantPresenteeComplicationApresAccouchement"};
        String[][] data = new String[][]{{
            "1024",
            NbGestantesZS(), NbGestantesHZ(), NbGestantesCPN2Plus(), DontRefereParCsZS(), DontRefereParCsHZ(), DontRefereParCsCPN2Plus(),
            FeAvec3CPNAu8emEt9emMoisZS(), FeAvec3CPNAu8emEt9emMoisHZ(), FeAyantConcultePour2emCpnZS(), FeAyantConcultePour2emCpnHZ(), FeAyantConcultePour3emCpnZS(), FeAyantConcultePour3emCpnHZ(),
            FeAyantConcultePour4emCpnOuPlusZS(), FeAyantConcultePour4emCpnOuPlusHZ(), FeARisqueDetecteesZS(), FeARisqueDetecteesHZ(), FeARisqueRefereesZS(), FeARisqueRefereesHZ(),
            FerAcideFolique1ereDoseZS(), FerAcideFolique1ereDoseHZ(), FerAcideFolique2ereDoseZS(), FerAcideFolique2ereDoseHZ(), FerAcideFolique3ereDoseZS(), FerAcideFolique3ereDoseHZ(),
            SulfadoxPyrimet1ereDoseZS(), SulfadoxPyrimet1ereDoseHZ(), SulfadoxPyrimet2ereDoseZS(), SulfadoxPyrimet2ereDoseHZ(), SulfadoxPyrimet3ereDoseVIHPlusZS(), SulfadoxPyrimet3ereDoseVIHPlusHZ(),
            FeAyantRecuVAT2emeA5emeDoseZS(), FeAyantRecuVAT2emeA5emeDoseHZ(), FeAyantCompletementVaccineesAvantGrossesseZS(), FeAyantCompletementVaccineesAvantGrossesseHZ(), FeEnceintesAyantAcquisUneMilZS(), FeEnceintesAyantAcquisUneMilHZ(),
            FeEnceintesAyantRecuMebendazole2emeTrimZS(), FeEnceintesAyantRecuMebendazole2emeTrimHZ(), VAT1ZS(), VAT1HZ(), VAT2ZS(), VAT2HZ(),
            VAT3ZS(), VAT3HZ(), VAT4ZS(), VAT4HZ(), VAT5ZS(), VAT5HZ(),
            QuiOntEteConseilleePourTestZS(), QuiOntEteConseilleePourTestHZ(), QuiOntEteTesteePourVIHZS(), QuiOntEteTesteePourVIHHZ(), QuiOnteuTestPositifZS(), QuiOnteuTestPositifHZ(),
            QuiOnEteInformeeDuResultatZS(), QuiOnEteInformeeDuResultatHZ(), QuiOnEuTestPositifEtInformeeDuResultatZS(), QuiOnEuTestPositifEtInformeeDuResultatHZ(), QuiOntEuGrossesseALIssuDunViolZS(), QuiOntEuGrossesseALIssuDunViolHZ(),
            NBAccouchementVIHPlus(), dontAyantRecuTritherapie(), NBEnfantsNesDeMereVIHPlus(), dontAyantPrislaTritherapie(), NbConsultationsZS(), NbConsultationsHZ(),
            NbConsultationsCPoN2Plus42eJr(), NbAccouchementAyantRecuVitamineZS(), NbAccouchementAyantRecuVitamineHZ(), NbAccouchementAyantRecuFerAcideFoliqueZS(), NbAccouchementAyantRecuFerAcideFoliqueHZ(), NbFemmeAyantPresenteeComplicationApresAccouchement()}};

        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rapports/cpn.jasper");
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
        return null;
    }

    private String NbGestantesZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='ZS'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbGestantesHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='HZ'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbGestantesCPN2Plus() {
        Query query = em.createQuery("SELECT COUNT(i) FROM InfosFemme i WHERE (SELECT COUNT(c) FROM Consultation c WHERE c.numDossier.numDossier = i.numDossier) > 1");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String DontRefereParCsZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.decisioncentresante='RDV(référé) à la maternité' AND c.numDossier.provenance='ZS'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String DontRefereParCsHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.decisioncentresante='RDV(référé) à la maternité' AND c.numDossier.provenance='HZ'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String DontRefereParCsCPN2Plus() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.decisioncentresante='RDV(référé) à la maternité' AND (SELECT COUNT(e) FROM Consultation e WHERE e.numDossier.numDossier = c.numDossier.numDossier) > 1");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAvec3CPNAu8emEt9emMoisZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.ageGrossesse IN ('8ème mois','9ème mois') AND c.numDossier.provenance='ZS' AND (SELECT COUNT(e) FROM Consultation e WHERE e.numDossier.numDossier = c.numDossier.numDossier) > 2");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAvec3CPNAu8emEt9emMoisHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.ageGrossesse IN ('8ème mois','9ème mois') AND c.numDossier.provenance='HZ' AND (SELECT COUNT(e) FROM Consultation e WHERE e.numDossier.numDossier = c.numDossier.numDossier) > 2");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantConcultePour2emCpnZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='ZS' AND (SELECT COUNT(e) FROM Consultation e WHERE e.numDossier.numDossier = c.numDossier.numDossier) = 2");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantConcultePour2emCpnHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='HZ' AND (SELECT COUNT(e) FROM Consultation e WHERE e.numDossier.numDossier = c.numDossier.numDossier) = 2");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantConcultePour3emCpnZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='ZS' AND (SELECT COUNT(e) FROM Consultation e WHERE e.numDossier.numDossier = c.numDossier.numDossier) = 3");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantConcultePour3emCpnHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='HZ' AND (SELECT COUNT(e) FROM Consultation e WHERE e.numDossier.numDossier = c.numDossier.numDossier) = 3");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantConcultePour4emCpnOuPlusZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='ZS' AND (SELECT COUNT(e) FROM Consultation e WHERE e.numDossier.numDossier = c.numDossier.numDossier) > 3");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantConcultePour4emCpnOuPlusHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='HZ' AND (SELECT COUNT(e) FROM Consultation e WHERE e.numDossier.numDossier = c.numDossier.numDossier) > 3");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeARisqueDetecteesZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='ZS' AND c.femmeARisque='détectée'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeARisqueDetecteesHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='HZ' AND c.femmeARisque='détectée'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeARisqueRefereesZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='ZS' AND c.femmeARisque='référée'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeARisqueRefereesHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT c.numDossier.numDossier) FROM Consultation c WHERE c.numDossier.provenance='HZ' AND c.femmeARisque='référée'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FerAcideFolique1ereDoseZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.ferPlusAcideFollique='1ère dose'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FerAcideFolique1ereDoseHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.ferPlusAcideFollique='1ère dose'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FerAcideFolique2ereDoseZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.ferPlusAcideFollique='2ème dose'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FerAcideFolique2ereDoseHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.ferPlusAcideFollique='2ème dose'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FerAcideFolique3ereDoseZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.ferPlusAcideFollique='3ème dose'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FerAcideFolique3ereDoseHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.ferPlusAcideFollique='3ème dose'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String SulfadoxPyrimet1ereDoseZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.sp='SP1'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String SulfadoxPyrimet1ereDoseHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.sp='SP1'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String SulfadoxPyrimet2ereDoseZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.sp='SP2'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String SulfadoxPyrimet2ereDoseHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.sp='SP2'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String SulfadoxPyrimet3ereDoseVIHPlusZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.sp='SP3 Si PVV'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String SulfadoxPyrimet3ereDoseVIHPlusHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.sp='SP3 Si PVV'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantRecuVAT2emeA5emeDoseZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.vat IN ('VAT2','VAT3','VAT4','VAT5')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantRecuVAT2emeA5emeDoseHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.vat IN ('VAT2','VAT3','VAT4','VAT5')");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantCompletementVaccineesAvantGrossesseZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.femmecompletementvaccinee='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeAyantCompletementVaccineesAvantGrossesseHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.femmecompletementvaccinee='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeEnceintesAyantAcquisUneMilZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.dortsousMild='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeEnceintesAyantAcquisUneMilHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.dortsousMild='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeEnceintesAyantRecuMebendazole2emeTrimZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.mebendaAu2emeTrimestre='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String FeEnceintesAyantRecuMebendazole2emeTrimHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.mebendaAu2emeTrimestre='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT1ZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.vat='VAT1'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT1HZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.vat='VAT1'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT2ZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.vat='VAT2'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT2HZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.vat='VAT2'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT3ZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.vat='VAT3'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT3HZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.vat='VAT3'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT4ZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.vat='VAT4'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT4HZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.vat='VAT4'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT5ZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.vat='VAT5'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String VAT5HZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.vat='VAT5'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOntEteConseilleePourTestZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.conseilDepistageVolontaire='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOntEteConseilleePourTestHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.conseilDepistageVolontaire='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOntEteTesteePourVIHZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.depister='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOntEteTesteePourVIHHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.depister='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOnteuTestPositifZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.resultat='Positif'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOnteuTestPositifHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.resultat='Positif'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOnEteInformeeDuResultatZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.femmeinformee='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOnEteInformeeDuResultatHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.femmeinformee='Oui'");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOnEuTestPositifEtInformeeDuResultatZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='ZS' AND m.resultat='Positif' AND m.femmeinformee='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOnEuTestPositifEtInformeeDuResultatHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT m.idRDV.numDossier.numDossier) FROM MesuresPreventives m WHERE m.idRDV.numDossier.provenance='HZ' AND m.resultat='Positif' AND m.femmeinformee='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOntEuGrossesseALIssuDunViolZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT a.numDossier.numDossier) FROM AntecedentCpn a WHERE a.numDossier.provenance='ZS' AND a.vbg='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String QuiOntEuGrossesseALIssuDunViolHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT a.numDossier.numDossier) FROM AntecedentCpn a WHERE a.numDossier.provenance='HZ' AND a.vbg='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NBAccouchementVIHPlus() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.accouchementVIHPositif='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String dontAyantRecuTritherapie() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.tritherapiePourVIH='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NBEnfantsNesDeMereVIHPlus() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.accouchementVIHPositif='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String dontAyantPrislaTritherapie() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.tritherapieEnfantVIHPositif='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbConsultationsZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.numDossier.provenance='ZS' AND ac.cPoN18emeJour='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbConsultationsHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.numDossier.provenance='HZ' AND ac.cPoN18emeJour='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbConsultationsCPoN2Plus42eJr() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.cPoN242emeJour='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbAccouchementAyantRecuVitamineZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.numDossier.provenance='ZS' AND ac.recuVitamineA='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbAccouchementAyantRecuVitamineHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.numDossier.provenance='HZ' AND ac.recuVitamineA='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbAccouchementAyantRecuFerAcideFoliqueZS() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.numDossier.provenance='ZS' AND ac.recuFerAcideFollique='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbAccouchementAyantRecuFerAcideFoliqueHZ() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.numDossier.provenance='HZ' AND ac.recuFerAcideFollique='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    private String NbFemmeAyantPresenteeComplicationApresAccouchement() {
        Query query = em.createQuery("SELECT COUNT (DISTINCT ac.numDossier.numDossier) FROM InfosAccouchement ac WHERE ac.complicationApresAcc='Oui' ");
        Object firstResult = query.getSingleResult();
        return String.valueOf(firstResult);
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

}
