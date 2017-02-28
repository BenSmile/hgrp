package controllers;

import controllers.util.MobilePageController;
import javax.enterprise.context.SessionScoped;
import jpa.ExamenLabo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;

@Named(value = "examenLaboController")
@SessionScoped
public class ExamenLaboController extends AbstractController<ExamenLabo> {

    @Inject
    private InfosFemmeController numDossierController;
    @Inject
    private UsersController utilisateurController;
    @Inject
    private MobilePageController mobilePageController;

    private String user;

    public String getUser() {
        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }

    public ExamenLaboController() {
        // Inform the Abstract parent controller of the concrete ExamenLabo Entity
        super(ExamenLabo.class);
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
}
