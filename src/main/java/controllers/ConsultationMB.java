/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.util.JsfUtil;
import ejb.ConsultationFacade;
import ejb.InfosFemmeFacade;
import ejb.UsersFacade;
import javax.inject.Named;
import jpa.Consultation;
import jpa.InfosFemme;
import jpa.Users;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import login.beans.Login;

/**
 *
 * @author Ben Kafirongo
 */
@Named(value = "consultation")
@RequestScoped
public class ConsultationMB {

    @EJB
    private UsersFacade usersFacade;

    @EJB
    private InfosFemmeFacade infosFemmeFacade;

    private List<Consultation> consulationsList;
    private List<InfosFemme> dossiers;
    private List<Users> users;

    private String user;
    private Date date;
    private List<String> decisions;
    private String ta;

    public String getTa() {
        try {
            return String.valueOf(consultation.getTa1()) + "/" + String.valueOf(consultation.getTa2());
        } catch (Exception e) {
            return null;
        }
    }

    public void setTa(String ta) {
        this.ta = ta;
        consultation.setTa1(Integer.parseInt(ta.substring(0, ta.indexOf("/"))));
        consultation.setTa2(Integer.parseInt(ta.substring(ta.indexOf("/") + 1, ta.length())));
    }

    public List<String> getDecisions() {
        return decisions;
    }

    public void setDecisions(List<String> decisions) {
        StringBuilder sb = new StringBuilder();
        for (String string : decisions) {
            sb.append(string + ",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        consultation.setDecisioncentresante(sb.toString());
    }

    public Date getDate() {
        if (consultation.getDate() == null) {
            return new Date();
        } else {
            System.out.println(consultation.getDate().toString());
            return consultation.getDate();

        }
    }

    public void setDate(Date date) {
        this.date = date;
        consultation.setDate(date);
    }

    public List<InfosFemme> getDossiers() {
        dossiers = new ArrayList<>();
        dossiers = infosFemmeFacade.findAll();
        return dossiers;
    }

    public void setDossiers(List<InfosFemme> dossiers) {
        this.dossiers = dossiers;
    }

    public List<Consultation> getConsulationsList() {
        return consultationFacade.findAll();
    }

    public void setConsulationsList(List<Consultation> consulationsList) {
        this.consulationsList = consulationsList;
    }

    public String getUser() {

        return Login.getUserConnected().getUname();
    }

    public void setUser(String user) {
        if (consultation == null) {
            consultation = new Consultation();
        }
        consultation.setUtilisateur(Login.getUserConnected());
    }

    public List<Users> getUsers() {
        users = new ArrayList<>();
        users = usersFacade.findAll();
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @EJB
    private ConsultationFacade consultationFacade;

    private Consultation consultation;

    public Consultation getConsultation() {
        if (consultation == null) {
            consultation = new Consultation();
        }
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public ConsultationMB() {
    }

    public void saveNew() {
        consultationFacade.create(consultation);
        JsfUtil.addSuccessMessage("Consultation créée avec succés");
        System.out.println("ok");
    }

    public void remove() {
        System.out.println("benjamin");
        if (null != consultation) {
            consultationFacade.remove(consultation);
            System.out.println("delete success");
        } else {
            System.out.println("selected is null");
        }

    }

    public void hello() {
        System.out.println("salut benjamin");
    }

}
