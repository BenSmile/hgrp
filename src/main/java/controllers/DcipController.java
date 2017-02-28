package controllers;

import controllers.util.MobilePageController;
import javax.enterprise.context.SessionScoped;
import jpa.Dcip;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;

@Named(value = "dcipController")
@SessionScoped
public class DcipController extends AbstractController<Dcip> {
    
    @Inject
    private UsersController utilisateurController;
    @Inject
    private InfosFemmeController numDossierController;
    @Inject
    private MobilePageController mobilePageController;
    
      private String user;

     public String getUser() {
        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }
    
    public DcipController() {
        // Inform the Abstract parent controller of the concrete Dcip Entity
        super(Dcip.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
   // @PostConstruct
    public void initUser() {
        this.getSelected().setUtilisateur(utilisateurController.getSelected());
    }
    
    public void resetParents() {
        utilisateurController.setSelected(null);
        numDossierController.setSelected(null);
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
}
