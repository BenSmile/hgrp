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
@Table(name = "antecedent_pl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AntecedentPl.findAll", query = "SELECT a FROM AntecedentPl a")
    ,
    @NamedQuery(name = "AntecedentPl.findByIdAntecedentPL", query = "SELECT a FROM AntecedentPl a WHERE a.idAntecedentPL = :idAntecedentPL")
    ,
    @NamedQuery(name = "AntecedentPl.findByAntecedentsMedicauxPL", query = "SELECT a FROM AntecedentPl a WHERE a.antecedentsMedicauxPL = :antecedentsMedicauxPL")
    ,
    @NamedQuery(name = "AntecedentPl.findByAntecedentsObst\u00e9tricauxPL", query = "SELECT a FROM AntecedentPl a WHERE a.antecedentsObst\u00e9tricauxPL = :antecedentsObst\u00e9tricauxPL")})
public class AntecedentPl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAntecedentPL")
    private Integer idAntecedentPL;
    @Size(max = 154)
    @Column(name = "AntecedentsMedicauxPL")
    private String antecedentsMedicauxPL;
    @Size(max = 147)
    @Column(name = "AntecedentsObst\u00e9tricauxPL")
    private String antecedentsObstétricauxPL;
    @JoinColumn(name = "numDossier", referencedColumnName = "NumDossier")
    @ManyToOne(optional = false)
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public AntecedentPl() {
    }

    public AntecedentPl(Integer idAntecedentPL) {
        this.idAntecedentPL = idAntecedentPL;
    }

    public Integer getIdAntecedentPL() {
        return idAntecedentPL;
    }

    public void setIdAntecedentPL(Integer idAntecedentPL) {
        this.idAntecedentPL = idAntecedentPL;
    }

    public String getAntecedentsMedicauxPL() {
        return antecedentsMedicauxPL;
    }

    public void setAntecedentsMedicauxPL(String antecedentsMedicauxPL) {
        if (antecedentsMedicauxPL.length() == 0) {
            antecedentsMedicauxPL = null;
        }
        this.antecedentsMedicauxPL = antecedentsMedicauxPL;
    }

    public String getAntecedentsObstétricauxPL() {
        return antecedentsObstétricauxPL;
    }

    public void setAntecedentsObstétricauxPL(String antecedentsObstétricauxPL) {
       if (antecedentsObstétricauxPL.length() == 0) {
            antecedentsObstétricauxPL = null;
        }
        this.antecedentsObstétricauxPL = antecedentsObstétricauxPL;
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
        hash += (idAntecedentPL != null ? idAntecedentPL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentPl)) {
            return false;
        }
        AntecedentPl other = (AntecedentPl) object;
        if ((this.idAntecedentPL == null && other.idAntecedentPL != null) || (this.idAntecedentPL != null && !this.idAntecedentPL.equals(other.idAntecedentPL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.AntecedentPl[ idAntecedentPL=" + idAntecedentPL + " ]";
    }

}
