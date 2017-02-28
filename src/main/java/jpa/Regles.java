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
@Table(name = "regles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regles.findAll", query = "SELECT r FROM Regles r")
    ,
    @NamedQuery(name = "Regles.findByIdRegle", query = "SELECT r FROM Regles r WHERE r.idRegle = :idRegle")
    ,
    @NamedQuery(name = "Regles.findByAgeMenarche", query = "SELECT r FROM Regles r WHERE r.ageMenarche = :ageMenarche")
    ,
    @NamedQuery(name = "Regles.findByDdr", query = "SELECT r FROM Regles r WHERE r.ddr = :ddr")
    ,
    @NamedQuery(name = "Regles.findByDureeRegle", query = "SELECT r FROM Regles r WHERE r.dureeRegle = :dureeRegle")
    ,
    @NamedQuery(name = "Regles.findByFluxMenstruel", query = "SELECT r FROM Regles r WHERE r.fluxMenstruel = :fluxMenstruel")
    ,
    @NamedQuery(name = "Regles.findByRegularite", query = "SELECT r FROM Regles r WHERE r.regularite = :regularite")
    ,
    @NamedQuery(name = "Regles.findByDysmenorhee", query = "SELECT r FROM Regles r WHERE r.dysmenorhee = :dysmenorhee")
    ,
    @NamedQuery(name = "Regles.findByAmenorheedepuisaccouchement", query = "SELECT r FROM Regles r WHERE r.amenorheedepuisaccouchement = :amenorheedepuisaccouchement")})
public class Regles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegle")
    private Integer idRegle;
    @Column(name = "Age_Menarche")
    private Integer ageMenarche;
    @Column(name = "DDR")
    @Temporal(TemporalType.DATE)
    private Date ddr;
    @Column(name = "Duree_Regle")
    private Integer dureeRegle;
    @Size(max = 13)
    @Column(name = "Flux_Menstruel")
    private String fluxMenstruel;
    @Size(max = 4)
    @Column(name = "Regularite")
    private String regularite;
    @Size(max = 4)
    @Column(name = "Dysmenorhee")
    private String dysmenorhee;
    @Size(max = 4)
    @Column(name = "Amenorhee_depuis_accouchement")
    private String amenorheedepuisaccouchement;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne(optional = false)
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public Regles() {
    }

    public Regles(Integer idRegle) {
        this.idRegle = idRegle;
    }

    public Integer getIdRegle() {
        return idRegle;
    }

    public void setIdRegle(Integer idRegle) {
        this.idRegle = idRegle;
    }

    public Integer getAgeMenarche() {
        return ageMenarche;
    }

    public void setAgeMenarche(Integer ageMenarche) {
        this.ageMenarche = ageMenarche;
    }

    public Date getDdr() {
        return ddr;
    }

    public void setDdr(Date ddr) {
        this.ddr = ddr;
    }

    public Integer getDureeRegle() {
        return dureeRegle;
    }

    public void setDureeRegle(Integer dureeRegle) {
        this.dureeRegle = dureeRegle;
    }

    public String getFluxMenstruel() {
        return fluxMenstruel;
    }

    public void setFluxMenstruel(String fluxMenstruel) {
        if (fluxMenstruel.length() == 0) {
            fluxMenstruel = null;
        }
        this.fluxMenstruel = fluxMenstruel;
    }

    public String getRegularite() {
        return regularite;
    }

    public void setRegularite(String regularite) {
         if (regularite.length() == 0) {
            regularite = null;
        } this.regularite = regularite;
    }

    public String getDysmenorhee() {
        return dysmenorhee;
    }

    public void setDysmenorhee(String dysmenorhee) {
         if (dysmenorhee.length() == 0) {
            dysmenorhee = null;
        }
         this.dysmenorhee = dysmenorhee;
    }

    public String getAmenorheedepuisaccouchement() {
        return amenorheedepuisaccouchement;
    }

    public void setAmenorheedepuisaccouchement(String amenorheedepuisaccouchement) {
        if (amenorheedepuisaccouchement.length() == 0) {
            amenorheedepuisaccouchement = null;
        } this.amenorheedepuisaccouchement = amenorheedepuisaccouchement;
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
        hash += (idRegle != null ? idRegle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regles)) {
            return false;
        }
        Regles other = (Regles) object;
        if ((this.idRegle == null && other.idRegle != null) || (this.idRegle != null && !this.idRegle.equals(other.idRegle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Regles[ idRegle=" + idRegle + " ]";
    }

}
