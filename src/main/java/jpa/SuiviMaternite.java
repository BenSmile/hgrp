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
@Table(name = "suivi_maternite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuiviMaternite.findAll", query = "SELECT s FROM SuiviMaternite s"),
    @NamedQuery(name = "SuiviMaternite.findByIdSuiv", query = "SELECT s FROM SuiviMaternite s WHERE s.idSuiv = :idSuiv"),
    @NamedQuery(name = "SuiviMaternite.findByExamenPhysique", query = "SELECT s FROM SuiviMaternite s WHERE s.examenPhysique = :examenPhysique"),
    @NamedQuery(name = "SuiviMaternite.findByExamenParacliniques", query = "SELECT s FROM SuiviMaternite s WHERE s.examenParacliniques = :examenParacliniques"),
    @NamedQuery(name = "SuiviMaternite.findByAutreObservation", query = "SELECT s FROM SuiviMaternite s WHERE s.autreObservation = :autreObservation"),
    @NamedQuery(name = "SuiviMaternite.findByConclusion", query = "SELECT s FROM SuiviMaternite s WHERE s.conclusion = :conclusion"),
    @NamedQuery(name = "SuiviMaternite.findByDecision", query = "SELECT s FROM SuiviMaternite s WHERE s.decision = :decision"),
    @NamedQuery(name = "SuiviMaternite.findByNumDossierCPN", query = "SELECT s FROM SuiviMaternite s WHERE s.numDossierCPN = :numDossierCPN")})
public class SuiviMaternite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSuiv")
    private Integer idSuiv;
    @Size(max = 50)
    @Column(name = "Examen_Physique")
    private String examenPhysique;
    @Size(max = 50)
    @Column(name = "Examen_Para_cliniques")
    private String examenParacliniques;
    @Size(max = 100)
    @Column(name = "Autre_Observation")
    private String autreObservation;
    @Size(max = 75)
    @Column(name = "conclusion")
    private String conclusion;
    @Size(max = 50)
    @Column(name = "Decision")
    private String decision;
    @Size(max = 15)
    @Column(name = "NumDossierCPN")
    private String numDossierCPN;

    public SuiviMaternite() {
    }

    public SuiviMaternite(Integer idSuiv) {
        this.idSuiv = idSuiv;
    }

    public Integer getIdSuiv() {
        return idSuiv;
    }

    public void setIdSuiv(Integer idSuiv) {
        this.idSuiv = idSuiv;
    }

    public String getExamenPhysique() {
        return examenPhysique;
    }

    public void setExamenPhysique(String examenPhysique) {
        this.examenPhysique = examenPhysique;
    }

    public String getExamenParacliniques() {
        return examenParacliniques;
    }

    public void setExamenParacliniques(String examenParacliniques) {
        this.examenParacliniques = examenParacliniques;
    }

    public String getAutreObservation() {
        return autreObservation;
    }

    public void setAutreObservation(String autreObservation) {
        this.autreObservation = autreObservation;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getNumDossierCPN() {
        return numDossierCPN;
    }

    public void setNumDossierCPN(String numDossierCPN) {
        this.numDossierCPN = numDossierCPN;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuiv != null ? idSuiv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuiviMaternite)) {
            return false;
        }
        SuiviMaternite other = (SuiviMaternite) object;
        if ((this.idSuiv == null && other.idSuiv != null) || (this.idSuiv != null && !this.idSuiv.equals(other.idSuiv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.SuiviMaternite[ idSuiv=" + idSuiv + " ]";
    }
    
}
