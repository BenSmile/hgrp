/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dtp
 */
@Entity
@Table(name = "mesures_preventives")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MesuresPreventives.findAll", query = "SELECT m FROM MesuresPreventives m")
    ,
    @NamedQuery(name = "MesuresPreventives.findByIdMesPrev", query = "SELECT m FROM MesuresPreventives m WHERE m.idMesPrev = :idMesPrev")
    ,
    @NamedQuery(name = "MesuresPreventives.findByVat", query = "SELECT m FROM MesuresPreventives m WHERE m.vat = :vat")
    ,
    @NamedQuery(name = "MesuresPreventives.findByFemmecompletementvaccinee", query = "SELECT m FROM MesuresPreventives m WHERE m.femmecompletementvaccinee = :femmecompletementvaccinee")
    ,
    @NamedQuery(name = "MesuresPreventives.findBySp", query = "SELECT m FROM MesuresPreventives m WHERE m.sp = :sp")
    ,
    @NamedQuery(name = "MesuresPreventives.findByDortsousMild", query = "SELECT m FROM MesuresPreventives m WHERE m.dortsousMild = :dortsousMild")
    ,
    @NamedQuery(name = "MesuresPreventives.findByMebendaAu2emeTrimestre", query = "SELECT m FROM MesuresPreventives m WHERE m.mebendaAu2emeTrimestre = :mebendaAu2emeTrimestre")
    ,
    @NamedQuery(name = "MesuresPreventives.findByVermifuge", query = "SELECT m FROM MesuresPreventives m WHERE m.vermifuge = :vermifuge")
    ,
    @NamedQuery(name = "MesuresPreventives.findBySupplementaion", query = "SELECT m FROM MesuresPreventives m WHERE m.supplementaion = :supplementaion")
    ,
    @NamedQuery(name = "MesuresPreventives.findByFefol", query = "SELECT m FROM MesuresPreventives m WHERE m.fefol = :fefol")
    ,
    @NamedQuery(name = "MesuresPreventives.findByConseilDepistageVolontaire", query = "SELECT m FROM MesuresPreventives m WHERE m.conseilDepistageVolontaire = :conseilDepistageVolontaire")
    ,
    @NamedQuery(name = "MesuresPreventives.findByDepister", query = "SELECT m FROM MesuresPreventives m WHERE m.depister = :depister")
    ,
    @NamedQuery(name = "MesuresPreventives.findByResultat", query = "SELECT m FROM MesuresPreventives m WHERE m.resultat = :resultat")
    ,
    @NamedQuery(name = "MesuresPreventives.findByFemmeinformee", query = "SELECT m FROM MesuresPreventives m WHERE m.femmeinformee = :femmeinformee")
    ,
    @NamedQuery(name = "MesuresPreventives.findByFerPlusAcideFollique", query = "SELECT m FROM MesuresPreventives m WHERE m.ferPlusAcideFollique = :ferPlusAcideFollique")})
public class MesuresPreventives implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMesPrev")
    private Integer idMesPrev;
    @Size(max = 5)
    @Column(name = "VAT")
    private String vat;
    @Size(max = 4)
    @Column(name = "Femme_completement_vaccinee")
    private String femmecompletementvaccinee;
    @Size(max = 10)
    @Column(name = "SP")
    private String sp;
    @Size(max = 4)
    @Column(name = "Dort_sous_Mild")
    private String dortsousMild;
    @Size(max = 4)
    @Column(name = "Mebenda_Au_2emeTrimestre")
    private String mebendaAu2emeTrimestre;
    @Size(max = 4)
    @Column(name = "Vermifuge")
    private String vermifuge;
    @Size(max = 4)
    @Column(name = "Supplementaion")
    private String supplementaion;
    @Size(max = 4)
    @Column(name = "Fefol")
    private String fefol;
    @Size(max = 4)
    @Column(name = "ConseilDepistageVolontaire")
    private String conseilDepistageVolontaire;
    @Size(max = 4)
    @Column(name = "depister")
    private String depister;
    @Size(max = 11)
    @Column(name = "Resultat")
    private String resultat;
    @Size(max = 4)
    @Column(name = "Femme_informee")
    private String femmeinformee;
    @Size(max = 12)
    @Column(name = "FerPlusAcideFollique")
    private String ferPlusAcideFollique;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;
    @JoinColumn(name = "idRDV", referencedColumnName = "idRDV")
    @ManyToOne(optional = false)
    private Consultation idRDV;

    public MesuresPreventives() {
    }

    public MesuresPreventives(Integer idMesPrev) {
        this.idMesPrev = idMesPrev;
    }

    public Integer getIdMesPrev() {
        return idMesPrev;
    }

    public void setIdMesPrev(Integer idMesPrev) {
        this.idMesPrev = idMesPrev;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        if (vat.length() == 0) {
            vat = null;
        }
        this.vat = vat;
    }

    public String getFemmecompletementvaccinee() {
        return femmecompletementvaccinee;
    }

    public void setFemmecompletementvaccinee(String femmecompletementvaccinee) {
        if (femmecompletementvaccinee.length() == 0) {
            femmecompletementvaccinee = null;
        } this.femmecompletementvaccinee = femmecompletementvaccinee;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        if (sp.length() == 0) {
            sp = null;
        } this.sp = sp;
    }

    public String getDortsousMild() {
        return dortsousMild;
    }

    public void setDortsousMild(String dortsousMild) {
        if (dortsousMild.length() == 0) {
            dortsousMild = null;
        } this.dortsousMild = dortsousMild;
    }

    public String getMebendaAu2emeTrimestre() {
        return mebendaAu2emeTrimestre;
    }

    public void setMebendaAu2emeTrimestre(String mebendaAu2emeTrimestre) {
         if (mebendaAu2emeTrimestre.length() == 0) {
            mebendaAu2emeTrimestre = null;
        } this.mebendaAu2emeTrimestre = mebendaAu2emeTrimestre;
    }

    public String getVermifuge() {
        return vermifuge;
    }

    public void setVermifuge(String vermifuge) {
          if (vermifuge.length() == 0) {
            vermifuge = null;
        } this.vermifuge = vermifuge;
    }

    public String getSupplementaion() {
        return supplementaion;
    }

    public void setSupplementaion(String supplementaion) {
          if (supplementaion.length() == 0) {
            supplementaion = null;
        } this.supplementaion = supplementaion;
    }

    public String getFefol() {
        return fefol;
    }

    public void setFefol(String fefol) {
        if (fefol.length() == 0) {
            fefol = null;
        }
        this.fefol = fefol;
    }

    public String getConseilDepistageVolontaire() {
        return conseilDepistageVolontaire;
    }

    public void setConseilDepistageVolontaire(String conseilDepistageVolontaire) {
        if (conseilDepistageVolontaire.length() == 0) {
            conseilDepistageVolontaire = null;
        }
        this.conseilDepistageVolontaire = conseilDepistageVolontaire;
    }

    public String getDepister() {
        return depister;
    }

    public void setDepister(String depister) {
        if (depister.length() == 0) {
            depister = null;
        } this.depister = depister;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        if (resultat.length() == 0) {
            resultat = null;
        } this.resultat = resultat;
    }

    public String getFemmeinformee() {
        return femmeinformee;
    }

    public void setFemmeinformee(String femmeinformee) {
        if (femmeinformee.length() == 0) {
            femmeinformee = null;
        }
        this.femmeinformee = femmeinformee;
    }

    public String getFerPlusAcideFollique() {
        return ferPlusAcideFollique;
    }

    public void setFerPlusAcideFollique(String ferPlusAcideFollique) {
       if (ferPlusAcideFollique.length() == 0) {
            ferPlusAcideFollique = null;
        }
       this.ferPlusAcideFollique = ferPlusAcideFollique;
    }

    public Users getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Users utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Consultation getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(Consultation idRDV) {
        this.idRDV = idRDV;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMesPrev != null ? idMesPrev.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesuresPreventives)) {
            return false;
        }
        MesuresPreventives other = (MesuresPreventives) object;
        if ((this.idMesPrev == null && other.idMesPrev != null) || (this.idMesPrev != null && !this.idMesPrev.equals(other.idMesPrev))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.MesuresPreventives[ idMesPrev=" + idMesPrev + " ]";
    }

}
