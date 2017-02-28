package controllers;

import controllers.util.MobilePageController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import jpa.InfosFemme;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;
import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@Named(value = "infosFemmeController")
@SessionScoped
public class InfosFemmeController extends AbstractController<InfosFemme> {

    @Inject
    private UsersController utilisateurController;
    @Inject
    private MobilePageController mobilePageController;
    private boolean skip;
    File destFile = null;
    Map<Integer, StreamedContent> fileMap = new HashMap<>();

    private String user;

    public Map<Integer, StreamedContent> getFileMap() throws FileNotFoundException {

        File file = new File("GFE" + File.separator + "images");
        File[] listFiles = file.listFiles();
        for (File fil : listFiles) {
            if (fil.getName().contains(".jpg") || fil.getName().contains(".jpeg") || fil.getName().contains(".png") || fil.getName().contains(".gif") || fil.getName().contains(".bitmap")) {
                fileMap.put(Integer.valueOf(fil.getName().substring(0, fil.getName().lastIndexOf("."))), new DefaultStreamedContent(new FileInputStream(fil)));
            }
        }
        return fileMap;
    }

    public void setFileMap(Map<Integer, StreamedContent> fileMap) {

        this.fileMap = fileMap;
    }

    public StreamedContent getGraphicImage(String dossier) throws FileNotFoundException {

        if (new File("GFE" + File.separator + "images" + File.separator + dossier + ".png").exists()) {
            return new org.primefaces.model.DefaultStreamedContent(
                    new java.io.FileInputStream("GFE" + File.separator + "images" + File.separator + dossier + ".png"), "image/png");
        } else if (new File("GFE" + File.separator + "images" + File.separator + dossier + ".jpeg").exists()) {
            return new org.primefaces.model.DefaultStreamedContent(
                    new java.io.FileInputStream("GFE" + File.separator + "images" + File.separator + dossier + ".jpeg"), "image/jpeg");
        } else if (new File("GFE" + File.separator + "images" + File.separator + dossier + ".jpg").exists()) {
            return new org.primefaces.model.DefaultStreamedContent(
                    new java.io.FileInputStream("GFE" + File.separator + "images" + File.separator + dossier + ".jpg"), "image/jpg");
        } else if (new File("GFE" + File.separator + "images" + File.separator + dossier + ".gif").exists()) {
            return new org.primefaces.model.DefaultStreamedContent(
                    new java.io.FileInputStream("GFE" + File.separator + "images" + File.separator + dossier + ".gif"), "image/gif");
        } else {
            return null;
        }

    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {

        //get uploaded file from the event
        UploadedFile uploadedFile = (UploadedFile) event.getFile();

        //create an InputStream from the uploaded file
        InputStream inputStr = null;
        try {
            inputStr = uploadedFile.getInputstream();
        } catch (IOException e) {
            //log error
        }

        //create destination File
        String destPath = "GFE" + File.separator + "images" + File.separator + event.getFile().getFileName();
        destFile = new File(destPath);
        //use org.apache.commons.io.FileUtils to copy the File
        try {
            FileUtils.copyInputStreamToFile(inputStr, destFile);
        } catch (IOException e) {
            //log error
        }
    }

    @Override
    public void saveNew(ActionEvent event) {
        String numDossier = super.getSelected().getNumDossier();

        super.saveNew(event); //To change body of generated methods, choose Tools | Templates.
        if (null != destFile) {
            String ext = "";

            int i = destFile.getName().lastIndexOf('.');
            if (i > 0) {
                ext = destFile.getName().substring(i + 1);
            }
            try {
                FileUtils.copyFile(destFile, new File("GFE" + File.separator + "images" + File.separator + numDossier + "." + ext));
                destFile.delete();
            } catch (IOException ex) {
                Logger.getLogger(InfosFemmeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getUser() {

        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {

            return event.getNewStep();

        }
    }

    public InfosFemmeController() {
        // Inform the Abstract parent controller of the concrete InfosFemme Entity
        super(InfosFemme.class);
        // System.out.println(Login.getUserConnected());
        //  super.setSelected(new InfosFemme());
        //  super.getSelected().setUtilisateur(Login.getUserConnected());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        utilisateurController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PlanficationFamiliale
     * entities that are retrieved from InfosFemme?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PlanficationFamiliale page
     */
    public String navigatePlanficationFamilialeCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PlanficationFamiliale_items", this.getSelected().getPlanficationFamilialeCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/planficationFamiliale/index";
    }

    /**
     * Sets the "items" attribute with a collection of DonneesObjectives
     * entities that are retrieved from InfosFemme?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DonneesObjectives page
     */
    public String navigateDonneesObjectivesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DonneesObjectives_items", this.getSelected().getDonneesObjectivesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/donneesObjectives/index";
    }

    /**
     * Sets the "items" attribute with a collection of Grossesse entities that
     * are retrieved from InfosFemme?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Grossesse page
     */
    public String navigateGrossesseCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Grossesse_items", this.getSelected().getGrossesseCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/grossesse/index";
    }

    /**
     * Sets the "items" attribute with a collection of InfosAccouchement
     * entities that are retrieved from InfosFemme?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for InfosAccouchement page
     */
    public String navigateInfosAccouchementCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InfosAccouchement_items", this.getSelected().getInfosAccouchementCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/infosAccouchement/index";
    }

    /**
     * Sets the "items" attribute with a collection of Dcip entities that are
     * retrieved from InfosFemme?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Dcip page
     */
    public String navigateDcipCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Dcip_items", this.getSelected().getDcipCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/dcip/index";
    }

    /**
     * Sets the "items" attribute with a collection of AntecedentCpn entities
     * that are retrieved from InfosFemme?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AntecedentCpn page
     */
    public String navigateAntecedentCpnCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AntecedentCpn_items", this.getSelected().getAntecedentCpnCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/antecedentCpn/index";
    }

    /**
     * Sets the "items" attribute with a collection of Hospitalisation entities
     * that are retrieved from InfosFemme?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Hospitalisation page
     */
    public String navigateHospitalisationCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Hospitalisation_items", this.getSelected().getHospitalisationCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/hospitalisation/index";
    }

    /**
     * Sets the "items" attribute with a collection of Regles entities that are
     * retrieved from InfosFemme?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Regles page
     */
    public String navigateReglesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Regles_items", this.getSelected().getReglesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/regles/index";
    }

    /**
     * Sets the "items" attribute with a collection of AutresProblemes entities
     * that are retrieved from InfosFemme?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AutresProblemes page
     */
    public String navigateAutresProblemesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AutresProblemes_items", this.getSelected().getAutresProblemesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/autresProblemes/index";
    }

    /**
     * Sets the "items" attribute with a collection of ExamenLabo entities that
     * are retrieved from InfosFemme?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ExamenLabo page
     */
    public String navigateExamenLaboCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExamenLabo_items", this.getSelected().getExamenLaboCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/examenLabo/index";
    }

    /**
     * Sets the "selected" attribute of the Users controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUtilisateur(ActionEvent event) {
        if (this.getSelected() != null && utilisateurController.getSelected() == null) {
            utilisateurController.setSelected(this.getSelected().getUtilisateur());
        }
    }

    /**
     * Sets the "items" attribute with a collection of AntecedentPl entities
     * that are retrieved from InfosFemme?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AntecedentPl page
     */
    public String navigateAntecedentPlCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AntecedentPl_items", this.getSelected().getAntecedentPlCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/antecedentPl/index";
    }

    /**
     * Sets the "items" attribute with a collection of Consultation entities
     * that are retrieved from InfosFemme?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Consultation page
     */
    public String navigateConsultationCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Consultation_items", this.getSelected().getConsultationCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/consultation/index";
    }

}
