/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dtp
 */
@Entity
@Table(name = "examen_labo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenLabo.findAll", query = "SELECT e FROM ExamenLabo e")
    ,
    @NamedQuery(name = "ExamenLabo.findByIdExamenLabo", query = "SELECT e FROM ExamenLabo e WHERE e.idExamenLabo = :idExamenLabo")
    ,
    @NamedQuery(name = "ExamenLabo.findByDateExamenLabo", query = "SELECT e FROM ExamenLabo e WHERE e.dateExamenLabo = :dateExamenLabo")
    ,
    @NamedQuery(name = "ExamenLabo.findByNomtechnicien", query = "SELECT e FROM ExamenLabo e WHERE e.nomtechnicien = :nomtechnicien")
    ,
    @NamedQuery(name = "ExamenLabo.findByNomMedecin", query = "SELECT e FROM ExamenLabo e WHERE e.nomMedecin = :nomMedecin")
    ,
    @NamedQuery(name = "ExamenLabo.findByHemoglobine", query = "SELECT e FROM ExamenLabo e WHERE e.hemoglobine = :hemoglobine")
    ,
    @NamedQuery(name = "ExamenLabo.findByGroupeSanguin", query = "SELECT e FROM ExamenLabo e WHERE e.groupeSanguin = :groupeSanguin")
    ,
    @NamedQuery(name = "ExamenLabo.findByGoutteEpaisse", query = "SELECT e FROM ExamenLabo e WHERE e.goutteEpaisse = :goutteEpaisse")
    ,
    @NamedQuery(name = "ExamenLabo.findBySellesdirectes", query = "SELECT e FROM ExamenLabo e WHERE e.sellesdirectes = :sellesdirectes")
    ,
    @NamedQuery(name = "ExamenLabo.findByRubeole", query = "SELECT e FROM ExamenLabo e WHERE e.rubeole = :rubeole")
    ,
    @NamedQuery(name = "ExamenLabo.findByVdrl", query = "SELECT e FROM ExamenLabo e WHERE e.vdrl = :vdrl")
    ,
    @NamedQuery(name = "ExamenLabo.findByToxoplasmose", query = "SELECT e FROM ExamenLabo e WHERE e.toxoplasmose = :toxoplasmose")})
public class ExamenLabo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExamenLabo")
    private Integer idExamenLabo;
    @Column(name = "DateExamenLabo")
    @Temporal(TemporalType.DATE)
    private Date dateExamenLabo;
    @Size(max = 30)
    @Column(name = "Nom_technicien")
    private String nomtechnicien;
    @Size(max = 30)
    @Column(name = "Nom_Medecin")
    private String nomMedecin;
    @Column(name = "Hemoglobine")
    private Integer hemoglobine;
    @Size(max = 2)
    @Column(name = "groupe_sanguin")
    private String groupeSanguin;
    @Size(max = 50)
    @Column(name = "Goutte_Epaisse")
    private String goutteEpaisse;
    @Size(max = 50)
    @Column(name = "Selles_directes")
    private String sellesdirectes;
    @Size(max = 35)
    @Column(name = "Rubeole")
    private String rubeole;
    @Size(max = 35)
    @Column(name = "VDRL")
    private String vdrl;
    @Size(max = 45)
    @Column(name = "Toxoplasmose")
    private String toxoplasmose;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne(optional = false)
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public ExamenLabo() {
    }

    public ExamenLabo(Integer idExamenLabo) {
        this.idExamenLabo = idExamenLabo;
    }

    public Integer getIdExamenLabo() {
        return idExamenLabo;
    }

    public void setIdExamenLabo(Integer idExamenLabo) {
        this.idExamenLabo = idExamenLabo;
    }

    public Date getDateExamenLabo() {
        return dateExamenLabo;
    }

    public void setDateExamenLabo(Date dateExamenLabo) {
        this.dateExamenLabo = dateExamenLabo;
    }

    public String getNomtechnicien() {
        return nomtechnicien;
    }

    public void setNomtechnicien(String nomtechnicien) {
        this.nomtechnicien = nomtechnicien;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public Integer getHemoglobine() {
        return hemoglobine;
    }

    public void setHemoglobine(Integer hemoglobine) {
        this.hemoglobine = hemoglobine;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        if (groupeSanguin.length() == 0) {
            groupeSanguin = null;
        }
        this.groupeSanguin = groupeSanguin;
    }

    public String getGoutteEpaisse() {
        return goutteEpaisse;
    }

    public void setGoutteEpaisse(String goutteEpaisse) {
        this.goutteEpaisse = goutteEpaisse;
    }

    public String getSellesdirectes() {
        return sellesdirectes;
    }

    public void setSellesdirectes(String sellesdirectes) {
        this.sellesdirectes = sellesdirectes;
    }

    public String getRubeole() {
        return rubeole;
    }

    public void setRubeole(String rubeole) {
        this.rubeole = rubeole;
    }

    public String getVdrl() {
        return vdrl;
    }

    public void setVdrl(String vdrl) {
        this.vdrl = vdrl;
    }

    public String getToxoplasmose() {
        return toxoplasmose;
    }

    public void setToxoplasmose(String toxoplasmose) {
        this.toxoplasmose = toxoplasmose;
    }

    public InfosFemme getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(InfosFemme numDossier) {
        this.numDossier = numDossier;
    }

    public Users getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Users utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamenLabo != null ? idExamenLabo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenLabo)) {
            return false;
        }
        ExamenLabo other = (ExamenLabo) object;
        if ((this.idExamenLabo == null && other.idExamenLabo != null) || (this.idExamenLabo != null && !this.idExamenLabo.equals(other.idExamenLabo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ExamenLabo[ idExamenLabo=" + idExamenLabo + " ]";
    }

}
