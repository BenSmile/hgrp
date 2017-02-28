package controllers;

import controllers.util.MobilePageController;
import javax.enterprise.context.SessionScoped;
import jpa.SuiviMaternite;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "suiviMaterniteController")
@SessionScoped
public class SuiviMaterniteController extends AbstractController<SuiviMaternite> {

    @Inject
    private MobilePageController mobilePageController;

    public SuiviMaterniteController() {
        // Inform the Abstract parent controller of the concrete SuiviMaternite Entity
        super(SuiviMaternite.class);
    }

}
