/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
@Table(name = "motif_consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotifConsultation.findAll", query = "SELECT m FROM MotifConsultation m")
    ,
    @NamedQuery(name = "MotifConsultation.findByIdMotCons", query = "SELECT m FROM MotifConsultation m WHERE m.idMotCons = :idMotCons")
    ,
    @NamedQuery(name = "MotifConsultation.findByMotif", query = "SELECT m FROM MotifConsultation m WHERE m.motif = :motif")
    ,
    @NamedQuery(name = "MotifConsultation.findByAutreprecision", query = "SELECT m FROM MotifConsultation m WHERE m.autreprecision = :autreprecision")})
public class MotifConsultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMotCons")
    private Integer idMotCons;
    @Size(max = 31)
    @Column(name = "Motif")
    private String motif;
    @Size(max = 35)
    @Column(name = "Autre_precision")
    private String autreprecision;
    @JoinColumn(name = "idPF", referencedColumnName = "idPF")
    @ManyToOne(optional = false)
    private PlanficationFamiliale idPF;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public MotifConsultation() {
    }

    public MotifConsultation(Integer idMotCons) {
        this.idMotCons = idMotCons;
    }

    public Integer getIdMotCons() {
        return idMotCons;
    }

    public void setIdMotCons(Integer idMotCons) {
        this.idMotCons = idMotCons;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        if (motif.length() == 0) {
            motif = null;
        }
        this.motif = motif;
    }

    public String getAutreprecision() {
        return autreprecision;
    }

    public void setAutreprecision(String autreprecision) {
        this.autreprecision = autreprecision;
    }

    public PlanficationFamiliale getIdPF() {
        return idPF;
    }

    public void setIdPF(PlanficationFamiliale idPF) {
        this.idPF = idPF;
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
        hash += (idMotCons != null ? idMotCons.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotifConsultation)) {
            return false;
        }
        MotifConsultation other = (MotifConsultation) object;
        if ((this.idMotCons == null && other.idMotCons != null) || (this.idMotCons != null && !this.idMotCons.equals(other.idMotCons))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.MotifConsultation[ idMotCons=" + idMotCons + " ]";
    }
    
    public String toStringDate(){
        return new SimpleDateFormat("dd/MM/yyyy").format(this.idPF.getDate());
    }

}
