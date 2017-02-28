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
@Table(name = "autres_problemes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutresProblemes.findAll", query = "SELECT a FROM AutresProblemes a"),
    @NamedQuery(name = "AutresProblemes.findByIdAutreProbl", query = "SELECT a FROM AutresProblemes a WHERE a.idAutreProbl = :idAutreProbl"),
    @NamedQuery(name = "AutresProblemes.findByDateAutreProbl", query = "SELECT a FROM AutresProblemes a WHERE a.dateAutreProbl = :dateAutreProbl"),
    @NamedQuery(name = "AutresProblemes.findByProbleme", query = "SELECT a FROM AutresProblemes a WHERE a.probleme = :probleme"),
    @NamedQuery(name = "AutresProblemes.findByObservationTraitement", query = "SELECT a FROM AutresProblemes a WHERE a.observationTraitement = :observationTraitement")})
public class AutresProblemes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAutreProbl")
    private Integer idAutreProbl;
    @Column(name = "DateAutreProbl")
    @Temporal(TemporalType.DATE)
    private Date dateAutreProbl;
    @Size(max = 100)
    @Column(name = "Probleme")
    private String probleme;
    @Size(max = 150)
    @Column(name = "Observation_Traitement")
    private String observationTraitement;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public AutresProblemes() {
    }

    public AutresProblemes(Integer idAutreProbl) {
        this.idAutreProbl = idAutreProbl;
    }

    public Integer getIdAutreProbl() {
        return idAutreProbl;
    }

    public void setIdAutreProbl(Integer idAutreProbl) {
        this.idAutreProbl = idAutreProbl;
    }

    public Date getDateAutreProbl() {
        return dateAutreProbl;
    }

    public void setDateAutreProbl(Date dateAutreProbl) {
        this.dateAutreProbl = dateAutreProbl;
    }

    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }

    public String getObservationTraitement() {
        return observationTraitement;
    }

    public void setObservationTraitement(String observationTraitement) {
        this.observationTraitement = observationTraitement;
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
        hash += (idAutreProbl != null ? idAutreProbl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutresProblemes)) {
            return false;
        }
        AutresProblemes other = (AutresProblemes) object;
        if ((this.idAutreProbl == null && other.idAutreProbl != null) || (this.idAutreProbl != null && !this.idAutreProbl.equals(other.idAutreProbl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.AutresProblemes[ idAutreProbl=" + idAutreProbl + " ]";
    }
    
}
