package controllers;

import controllers.util.MobilePageController;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import jpa.MotifConsultation;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import login.beans.Login;

@Named(value = "motifConsultationController")
@SessionScoped
public class MotifConsultationController extends AbstractController<MotifConsultation> {

    @Inject
    private PlanficationFamilialeController idPFController;
    @Inject
    private UsersController utilisateurController;
    @Inject
    private MobilePageController mobilePageController;
    private List<String> motifs;

    public List<String> getMotifs() {
          ArrayList<String> arrayList = new ArrayList<String>();
        String motif = (super.getSelected() == null) ? "" : super.getSelected().getMotif();
        if (motif != null) {
            String[] split = motif.split(",");
            for (String string1 : split) {
                arrayList.add(string1);
            }
        }
        return arrayList;
    }

    public void setMotifs(List<String> motifs) {
        StringBuilder sb = new StringBuilder();
        for (String string : motifs) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        super.getSelected().setMotif(sb.toString());
    }

    private String user;

    public String getUser() {
        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        super.getSelected().setUtilisateur(Login.getUserConnected());
    }

    public MotifConsultationController() {
        // Inform the Abstract parent controller of the concrete MotifConsultation Entity
        super(MotifConsultation.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPFController.setSelected(null);
        utilisateurController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PlanficationFamiliale controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPF(ActionEvent event) {
        if (this.getSelected() != null && idPFController.getSelected() == null) {
            idPFController.setSelected(this.getSelected().getIdPF());
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
