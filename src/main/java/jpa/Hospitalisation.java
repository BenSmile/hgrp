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
@Table(name = "hospitalisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospitalisation.findAll", query = "SELECT h FROM Hospitalisation h")
    ,
    @NamedQuery(name = "Hospitalisation.findByIdHosp", query = "SELECT h FROM Hospitalisation h WHERE h.idHosp = :idHosp")
    ,
    @NamedQuery(name = "Hospitalisation.findByDateHospitalisation", query = "SELECT h FROM Hospitalisation h WHERE h.dateHospitalisation = :dateHospitalisation")
    ,
    @NamedQuery(name = "Hospitalisation.findByHospitalisation", query = "SELECT h FROM Hospitalisation h WHERE h.hospitalisation = :hospitalisation")
    ,
    @NamedQuery(name = "Hospitalisation.findByPourTraitementSpecifique", query = "SELECT h FROM Hospitalisation h WHERE h.pourTraitementSpecifique = :pourTraitementSpecifique")})
public class Hospitalisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHosp")
    private Integer idHosp;
    @Column(name = "DateHospitalisation")
    @Temporal(TemporalType.DATE)
    private Date dateHospitalisation;
    @Size(max = 44)
    @Column(name = "Hospitalisation")
    private String hospitalisation;
    @Size(max = 50)
    @Column(name = "Pour_Traitement_Specifique")
    private String pourTraitementSpecifique;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne(optional = false)
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public Hospitalisation() {
    }

    public Hospitalisation(Integer idHosp) {
        this.idHosp = idHosp;
    }

    public Integer getIdHosp() {
        return idHosp;
    }

    public void setIdHosp(Integer idHosp) {
        this.idHosp = idHosp;
    }

    public Date getDateHospitalisation() {
        return dateHospitalisation;
    }

    public void setDateHospitalisation(Date dateHospitalisation) {
        this.dateHospitalisation = dateHospitalisation;
    }

    public String getHospitalisation() {
        return hospitalisation;
    }

    public void setHospitalisation(String hospitalisation) {
        if (hospitalisation.length() == 0) {
            hospitalisation = null;
        }
        this.hospitalisation = hospitalisation;
    }

    public String getPourTraitementSpecifique() {
        return pourTraitementSpecifique;
    }

    public void setPourTraitementSpecifique(String pourTraitementSpecifique) {
        this.pourTraitementSpecifique = pourTraitementSpecifique;
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
        hash += (idHosp != null ? idHosp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospitalisation)) {
            return false;
        }
        Hospitalisation other = (Hospitalisation) object;
        if ((this.idHosp == null && other.idHosp != null) || (this.idHosp != null && !this.idHosp.equals(other.idHosp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Hospitalisation[ idHosp=" + idHosp + " ]";
    }

}
