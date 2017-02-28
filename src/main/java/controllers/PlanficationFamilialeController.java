package controllers;

import controllers.util.MobilePageController;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import jpa.PlanficationFamiliale;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;

@Named(value = "planficationFamilialeController")
@SessionScoped
public class PlanficationFamilialeController extends AbstractController<PlanficationFamiliale> {

    @Inject
    private InfosFemmeController numDossierController;
    @Inject
    private UsersController utilisateurController;
    @Inject
    private MobilePageController mobilePageController;
    private String user;
    private Date date;

    public Date getDate() {
        if (super.getSelected().getDate() == null) {
            return new Date();
        } else {
            return super.getSelected().getDate();
        }
    }

    public void setDate(Date date) {
        this.date = date;
        super.getSelected().setDate(date);
    }

    public String getUser() {
        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }

    public PlanficationFamilialeController() {
        // Inform the Abstract parent controller of the concrete PlanficationFamiliale Entity
        super(PlanficationFamiliale.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        numDossierController.setSelected(null);
        utilisateurController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the InfosFemme controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNumDossier(ActionEvent event) {
        if (this.getSelected() != null && numDossierController.getSelected() == null) {
            numDossierController.setSelected(this.getSelected().getNumDossier());
        }
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
     * Sets the "items" attribute with a collection of MotifConsultation
     * entities that are retrieved from PlanficationFamiliale?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for MotifConsultation page
     */
    public String navigateMotifConsultationCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MotifConsultation_items", this.getSelected().getMotifConsultationCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/motifConsultation/index";
    }

}
