package login.beans;

import controllers.InfosFemmeController;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import jpa.InfosFemme;
import jpa.Users;

import login.dao.LoginDAO;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private String user;
    private boolean visible = false;
    private boolean admin = false;
    private InfosFemmeController infosFemmeController;

    public boolean isAdmin() {
        return userConnected.getRole().equals("admin");
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    private static Users userConnected;

    public static Users getUserConnected() {
        return userConnected;
    }

    public void setUserConnected(Users userConnected) {
        this.userConnected = userConnected;
    }

    public String getSelectedItem() {
        return (infosFemmeController.getSelected() == null) ? "" : infosFemmeController.getSelected().getNumDossier();
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible() {
        this.visible = true;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //validate login
    public String validateUsernamePassword() {
        boolean valid = LoginDAO.validate(user, pwd);
        if (valid) {
            userConnected = LoginDAO.userConnected;
//            System.out.println("userConnected = " + userConnected);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            // HttpSession session = SessionBean.getSession();
            session.setAttribute("username", user);
            return "infosFemme/index";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Nom d'utilisateur ou mot de passe incorrect",
                            "veillez entrer des données correctes"));
            return "login";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
      //  HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "/login";
    }
}
