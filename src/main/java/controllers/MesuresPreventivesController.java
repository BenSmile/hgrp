package controllers;

import controllers.util.MobilePageController;
import javax.enterprise.context.SessionScoped;
import jpa.MesuresPreventives;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;

@Named(value = "mesuresPreventivesController")
@SessionScoped
public class MesuresPreventivesController extends AbstractController<MesuresPreventives> {

    @Inject
    private UsersController utilisateurController;
    @Inject
    private ConsultationController idRDVController;
    @Inject
    private MobilePageController mobilePageController;
     private String user;

    public String getUser() {
        
        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }
    

    public MesuresPreventivesController() {
        // Inform the Abstract parent controller of the concrete MesuresPreventives Entity
        super(MesuresPreventives.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        utilisateurController.setSelected(null);
        idRDVController.setSelected(null);
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
     * Sets the "selected" attribute of the Consultation controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRDV(ActionEvent event) {
        if (this.getSelected() != null && idRDVController.getSelected() == null) {
            idRDVController.setSelected(this.getSelected().getIdRDV());
        }
    }
}
