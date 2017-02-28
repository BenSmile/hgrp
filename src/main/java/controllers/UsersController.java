package controllers;

import controllers.util.MobilePageController;
import javax.enterprise.context.SessionScoped;
import jpa.Users;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "usersController")
@SessionScoped
public class UsersController extends AbstractController<Users> {

    @Inject
    private MobilePageController mobilePageController;

    public UsersController() {
        // Inform the Abstract parent controller of the concrete Users Entity
        super(Users.class);
    }

    /**
     * Sets the "items" attribute with a collection of PlanficationFamiliale
     * entities that are retrieved from Users?cap_first and returns the
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
     * Sets the "items" attribute with a collection of MesuresPreventives
     * entities that are retrieved from Users?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MesuresPreventives page
     */
    public String navigateMesuresPreventivesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MesuresPreventives_items", this.getSelected().getMesuresPreventivesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/mesuresPreventives/index";
    }

    /**
     * Sets the "items" attribute with a collection of DonneesObjectives
     * entities that are retrieved from Users?cap_first and returns the
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
     * are retrieved from Users?cap_first and returns the navigation outcome.
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
     * entities that are retrieved from Users?cap_first and returns the
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
     * retrieved from Users?cap_first and returns the navigation outcome.
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
     * that are retrieved from Users?cap_first and returns the navigation
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
     * that are retrieved from Users?cap_first and returns the navigation
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
     * retrieved from Users?cap_first and returns the navigation outcome.
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
     * that are retrieved from Users?cap_first and returns the navigation
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
     * are retrieved from Users?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of InfosFemme entities that
     * are retrieved from Users?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for InfosFemme page
     */
    public String navigateInfosFemmeCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InfosFemme_items", this.getSelected().getInfosFemmeCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/infosFemme/index";
    }

    /**
     * Sets the "items" attribute with a collection of MotifConsultation
     * entities that are retrieved from Users?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MotifConsultation page
     */
    public String navigateMotifConsultationCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MotifConsultation_items", this.getSelected().getMotifConsultationCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/motifConsultation/index";
    }

    /**
     * Sets the "items" attribute with a collection of AntecedentPl entities
     * that are retrieved from Users?cap_first and returns the navigation
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
     * that are retrieved from Users?cap_first and returns the navigation
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
