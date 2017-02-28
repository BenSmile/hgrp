package controllers;

import controllers.util.MobilePageController;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import jpa.InfosAccouchement;
import javax.inject.Named;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;

@Named(value = "infosAccouchementController")
@SessionScoped
public class InfosAccouchementController extends AbstractController<InfosAccouchement> {

    @Inject
    private InfosFemmeController numDossierController;
    @Inject
    private UsersController utilisateurController;
    @Inject
    private MobilePageController mobilePageController;

    private List<String> infections;
    private List<String> indications;
    private List<String> particularitesEnfant;

    public List<String> getInfections() {
          ArrayList<String> arrayList = new ArrayList<String>();
        String infection = (super.getSelected() == null) ? "" : super.getSelected().getInfection();
        if (infection != null) {
            String[] split = infection.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setInfections(List<String> infections) {
        StringBuilder sb = new StringBuilder();
        for (String string : infections) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setInfection(sb.toString());
        System.out.println("sb = " + sb);
    }

    public List<String> getIndications() {
          ArrayList<String> arrayList = new ArrayList<String>();
        String indication = (super.getSelected() == null) ? "" : super.getSelected().getIndication();
        if (indication != null) {
            String[] split = indication.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setIndications(List<String> indications) {
        StringBuilder sb = new StringBuilder();
        for (String string : indications) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setIndication(sb.toString());
    }

    public List<String> getParticularitesEnfant() {
          ArrayList<String> arrayList = new ArrayList<String>();
        String particulariteEnfant = (super.getSelected() == null) ? "" : super.getSelected().getParticulariteEnfant();
        if (particulariteEnfant != null) {
            String[] split = particulariteEnfant.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setParticularitesEnfant(List<String> particularitesEnfant) {
        StringBuilder sb = new StringBuilder();
        for (String string : particularitesEnfant) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setParticulariteEnfant(sb.toString());
    }

    private String user;

    public String getUser() {
        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }

    public InfosAccouchementController() {
        // Inform the Abstract parent controller of the concrete InfosAccouchement Entity
        super(InfosAccouchement.class);
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

    public void add(ActionEvent event) {
        System.out.println("benjamin");
        super.saveNew(event);
    }
}
