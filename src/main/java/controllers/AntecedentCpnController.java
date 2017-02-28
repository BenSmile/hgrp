package controllers;

import controllers.util.MobilePageController;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import jpa.AntecedentCpn;
import javax.inject.Named;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;

@Named(value = "antecedentCpnController")
@SessionScoped
public class AntecedentCpnController extends AbstractController<AntecedentCpn> {

    @Inject
    private InfosFemmeController numDossierController;
    @Inject
    private UsersController utilisateurController;
    @Inject
    private MobilePageController mobilePageController;

    private List<String> complicationTraitement;
    private List<String> antecedentsMedicauxCPN;
    private List<String> antecedentsChirurgicauxCPN;

    public List<String> getComplicationTraitement() {
          ArrayList<String> arrayList = new ArrayList<String>();
        String complication = (super.getSelected() == null) ? "" : super.getSelected().getComplicationtraitement();
        if (complication != null) {
            String[] split = complication.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setComplicationTraitement(List<String> complicationTraitement) {
         StringBuilder sb = new StringBuilder();
        for (String string : complicationTraitement) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setComplicationtraitement(sb.toString());
    }

    
    
    public List<String> getAntecedentsMedicauxCPN() {
          ArrayList<String> arrayList = new ArrayList<String>();
        String antecedentCPN = (super.getSelected() == null) ? "" : super.getSelected().getAntecedentMedicauxCPN();
        if (antecedentCPN != null) {
            String[] split = antecedentCPN.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setAntecedentsMedicauxCPN(List<String> antecedentsMedicauxCPN) {
        StringBuilder sb = new StringBuilder();
        for (String string : antecedentsMedicauxCPN) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setAntecedentMedicauxCPN(sb.toString());
    }

    public List<String> getAntecedentsChirurgicauxCPN() {
         ArrayList<String> arrayList = new ArrayList<String>();
        String antecedentCPN = (super.getSelected() == null) ? "" : super.getSelected().getAntecedentChirurgicauxCPN();
        if (antecedentCPN != null) {
            String[] split = antecedentCPN.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setAntecedentsChirurgicauxCPN(List<String> antecedentsChirurgicauxCPN) {
        StringBuilder sb = new StringBuilder();
        for (String string : antecedentsChirurgicauxCPN) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setAntecedentChirurgicauxCPN(sb.toString());
    }

    private String user;

    public String getUser() {
        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }

    public AntecedentCpnController() {
        // Inform the Abstract parent controller of the concrete AntecedentCpn Entity
        super(AntecedentCpn.class);
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
