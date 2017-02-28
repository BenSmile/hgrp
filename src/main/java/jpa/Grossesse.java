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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dtp
 */
@Entity
@Table(name = "grossesse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grossesse.findAll", query = "SELECT g FROM Grossesse g"),
    @NamedQuery(name = "Grossesse.findByIdGros", query = "SELECT g FROM Grossesse g WHERE g.idGros = :idGros"),
    @NamedQuery(name = "Grossesse.findByEnfantsvivantsactuellement", query = "SELECT g FROM Grossesse g WHERE g.enfantsvivantsactuellement = :enfantsvivantsactuellement"),
    @NamedQuery(name = "Grossesse.findByP", query = "SELECT g FROM Grossesse g WHERE g.p = :p"),
    @NamedQuery(name = "Grossesse.findByG", query = "SELECT g FROM Grossesse g WHERE g.g = :g"),
    @NamedQuery(name = "Grossesse.findByA", query = "SELECT g FROM Grossesse g WHERE g.a = :a"),
    @NamedQuery(name = "Grossesse.findByD", query = "SELECT g FROM Grossesse g WHERE g.d = :d"),
    @NamedQuery(name = "Grossesse.findByDatedernierAccouchement", query = "SELECT g FROM Grossesse g WHERE g.datedernierAccouchement = :datedernierAccouchement"),
    @NamedQuery(name = "Grossesse.findByDateDernierRapportNonProteger", query = "SELECT g FROM Grossesse g WHERE g.dateDernierRapportNonProteger = :dateDernierRapportNonProteger"),
    @NamedQuery(name = "Grossesse.findByDateDernierRegle", query = "SELECT g FROM Grossesse g WHERE g.dateDernierRegle = :dateDernierRegle"),
    @NamedQuery(name = "Grossesse.findByNombrecesarienne", query = "SELECT g FROM Grossesse g WHERE g.nombrecesarienne = :nombrecesarienne")})
public class Grossesse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGros")
    private Integer idGros;
    @Column(name = "Enfants_vivants_actuellement")
    private Integer enfantsvivantsactuellement;
    @Column(name = "P")
    private Integer p;
    @Column(name = "G")
    private Integer g;
    @Column(name = "A")
    private Integer a;
    @Column(name = "D")
    private Integer d;
    @Column(name = "Date_dernier_Accouchement")
    @Temporal(TemporalType.DATE)
    private Date datedernierAccouchement;
    @Column(name = "Date_Dernier_Rapport_Non_Proteger")
    @Temporal(TemporalType.DATE)
    private Date dateDernierRapportNonProteger;
    @Column(name = "Date_Dernier_Regle")
    @Temporal(TemporalType.DATE)
    private Date dateDernierRegle;
    @Column(name = "Nombre_cesarienne")
    private Integer nombrecesarienne;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne(optional = false)
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public Grossesse() {
    }

    public Grossesse(Integer idGros) {
        this.idGros = idGros;
    }

    public Integer getIdGros() {
        return idGros;
    }

    public void setIdGros(Integer idGros) {
        this.idGros = idGros;
    }

    public Integer getEnfantsvivantsactuellement() {
        return enfantsvivantsactuellement;
    }

    public void setEnfantsvivantsactuellement(Integer enfantsvivantsactuellement) {
        this.enfantsvivantsactuellement = enfantsvivantsactuellement;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Date getDatedernierAccouchement() {
        return datedernierAccouchement;
    }

    public void setDatedernierAccouchement(Date datedernierAccouchement) {
        this.datedernierAccouchement = datedernierAccouchement;
    }

    public Date getDateDernierRapportNonProteger() {
        return dateDernierRapportNonProteger;
    }

    public void setDateDernierRapportNonProteger(Date dateDernierRapportNonProteger) {
        this.dateDernierRapportNonProteger = dateDernierRapportNonProteger;
    }

    public Date getDateDernierRegle() {
        return dateDernierRegle;
    }

    public void setDateDernierRegle(Date dateDernierRegle) {
        this.dateDernierRegle = dateDernierRegle;
    }

    public Integer getNombrecesarienne() {
        return nombrecesarienne;
    }

    public void setNombrecesarienne(Integer nombrecesarienne) {
        this.nombrecesarienne = nombrecesarienne;
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
        hash += (idGros != null ? idGros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grossesse)) {
            return false;
        }
        Grossesse other = (Grossesse) object;
        if ((this.idGros == null && other.idGros != null) || (this.idGros != null && !this.idGros.equals(other.idGros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Grossesse[ idGros=" + idGros + " ]";
    }
    
}
