package controllers;

import controllers.util.MobilePageController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jpa.Consultation;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;

@Named(value = "consultationController")
@ViewScoped
public class ConsultationController extends AbstractController<Consultation> {

    @Inject
    private InfosFemmeController numDossierController;
    @Inject
    private UsersController utilisateurController;
    @Inject
    private MobilePageController mobilePageController;

    private List<String> decisions;
    String name;

    private String user;
    private String ta;
    private Date date;

    public Date getDate() {
        if (super.getSelected().getDate() == null) {
            return new Date();
        } else {
            System.out.println(super.getSelected().getDate().toString());
            return super.getSelected().getDate();

        }
    }

    public void setDate(Date date) {
        this.date = date;
        super.getSelected().setDate(date);
    }

    public List<String> getDecisions() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String decisioncentresante = (super.getSelected() == null) ? "" : super.getSelected().getDecisioncentresante();
        if (decisioncentresante != null) {
            String[] split = decisioncentresante.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setDecisions(List<String> decisions) {
        StringBuilder sb = new StringBuilder();
        for (String string : decisions) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setDecisioncentresante(sb.toString());
    }

    public String getTa() {
        try {
            return String.valueOf(super.getSelected().getTa1()) + "/" + String.valueOf(super.getSelected().getTa2());

        } catch (Exception e) {
            return null;

        }
    }

    public void setTa(String ta) {
        System.out.println("ta = " + ta);
        this.ta = ta;
        super.getSelected().setTa1(Integer.parseInt(ta.substring(0, ta.indexOf("/"))));
        super.getSelected().setTa2(Integer.parseInt(ta.substring(ta.indexOf("/") + 1, ta.length())));

    }

    public String getUser() {

        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }

    public ConsultationController() {
        // Inform the Abstract parent controller of the concrete Consultation Entity
        super(Consultation.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        numDossierController.setSelected(null);
        utilisateurController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of MesuresPreventives
     * entities that are retrieved from Consultation?cap_first and returns the
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
