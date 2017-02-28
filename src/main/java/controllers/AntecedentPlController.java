package controllers;

import controllers.util.MobilePageController;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import jpa.AntecedentPl;
import javax.inject.Named;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;

@Named(value = "antecedentPlController")
@SessionScoped
public class AntecedentPlController extends AbstractController<AntecedentPl> {

    @Inject
    private InfosFemmeController numDossierController;
    @Inject
    private UsersController utilisateurController;
    @Inject
    private MobilePageController mobilePageController;
    private String user;
    private List<String> antecedentsMedicauxPL;
    private List<String> antecedentsObstetricauxPl;

    public List<String> getAntecedentsMedicauxPL() {

          ArrayList<String> arrayList = new ArrayList<String>();
        String antecedentPL = (super.getSelected() == null) ? "" : super.getSelected().getAntecedentsMedicauxPL();
        if (antecedentPL != null) {
            String[] split = antecedentPL.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setAntecedentsMedicauxPL(List<String> antecedentsMedicauxPL) {
        StringBuilder sb = new StringBuilder();
        for (String string : antecedentsMedicauxPL) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setAntecedentsMedicauxPL(sb.toString());
    }

    public List<String> getAntecedentsObstetricauxPl() {
         ArrayList<String> arrayList = new ArrayList<String>();
        String antecedentPL = (super.getSelected() == null) ? "" : super.getSelected().getAntecedentsObstétricauxPL();
        if (antecedentPL != null) {
            String[] split = antecedentPL.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setAntecedentsObstetricauxPl(List<String> antecedentsObstetricauxPl) {
        StringBuilder sb = new StringBuilder();
        for (String string : antecedentsObstetricauxPl) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setAntecedentsObstétricauxPL(sb.toString());
    }

    public String getUser() {
        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }

    public AntecedentPlController() {
        // Inform the Abstract parent controller of the concrete AntecedentPl Entity
        super(AntecedentPl.class);
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
