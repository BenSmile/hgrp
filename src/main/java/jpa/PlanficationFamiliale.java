/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dtp
 */
@Entity
@Table(name = "planfication_familiale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanficationFamiliale.findAll", query = "SELECT p FROM PlanficationFamiliale p")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findByIdPF", query = "SELECT p FROM PlanficationFamiliale p WHERE p.idPF = :idPF")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findByNouvelleacceptante", query = "SELECT p FROM PlanficationFamiliale p WHERE p.nouvelleacceptante = :nouvelleacceptante")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findByRenouvellement", query = "SELECT p FROM PlanficationFamiliale p WHERE p.renouvellement = :renouvellement")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findByMethodeanterieure", query = "SELECT p FROM PlanficationFamiliale p WHERE p.methodeanterieure = :methodeanterieure")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findByAutreMethodeAnterieure", query = "SELECT p FROM PlanficationFamiliale p WHERE p.autreMethodeAnterieure = :autreMethodeAnterieure")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findBySourcerenseignementsurPF", query = "SELECT p FROM PlanficationFamiliale p WHERE p.sourcerenseignementsurPF = :sourcerenseignementsurPF")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findByRaisondechangement", query = "SELECT p FROM PlanficationFamiliale p WHERE p.raisondechangement = :raisondechangement")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findByPlanification", query = "SELECT p FROM PlanficationFamiliale p WHERE p.planification = :planification")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findByCounsling", query = "SELECT p FROM PlanficationFamiliale p WHERE p.counsling = :counsling")
    ,
    @NamedQuery(name = "PlanficationFamiliale.findByMethodechoisie", query = "SELECT p FROM PlanficationFamiliale p WHERE p.methodechoisie = :methodechoisie")})
public class PlanficationFamiliale implements Serializable {

    @Size(max = 5)
    @Column(name = "Retrait_implant")
    private String retraitimplant;
    @Size(max = 5)
    @Column(name = "Retrait_DIU")
    private String retraitDIU;
    @Size(max = 5)
    @Column(name = "Complication")
    private String complication;
    @Size(max = 5)
    @Column(name = "Limite_information")
    private String limiteinformation;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPF")
    private Integer idPF;
    @Size(max = 4)
    @Column(name = "Nouvelle_acceptante")
    private String nouvelleacceptante;
    @Size(max = 16)
    @Column(name = "Renouvellement")
    private String renouvellement;
    @Size(max = 17)
    @Column(name = "Methode_anterieure")
    private String methodeanterieure;
    @Size(max = 50)
    @Column(name = "AutreMethodeAnterieure")
    private String autreMethodeAnterieure;
    @Size(max = 30)
    @Column(name = "Source_renseignement_sur_PF")
    private String sourcerenseignementsurPF;
    @Size(max = 45)
    @Column(name = "Raison_de_changement")
    private String raisondechangement;
    @Size(max = 26)
    @Column(name = "Planification")
    private String planification;
    @Size(max = 4)
    @Column(name = "Counsling")
    private String counsling;
    @Size(max = 17)
    @Column(name = "Methode_choisie")
    private String methodechoisie;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne(optional = false)
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPF")
    private Collection<MotifConsultation> motifConsultationCollection;
        


    public PlanficationFamiliale() {
    }

    public PlanficationFamiliale(Integer idPF) {
        this.idPF = idPF;
    }

    public Integer getIdPF() {
        return idPF;
    }

    public void setIdPF(Integer idPF) {
        this.idPF = idPF;
    }

    public String getNouvelleacceptante() {
        return nouvelleacceptante;
    }

    public void setNouvelleacceptante(String nouvelleacceptante) {
        if (nouvelleacceptante.length() == 0) {
            nouvelleacceptante = null;
        }
        this.nouvelleacceptante = nouvelleacceptante;
    }

    public String getRenouvellement() {
        return renouvellement;
    }

    public void setRenouvellement(String renouvellement) {
        if (renouvellement.length() == 0) {
            renouvellement = null;
        }
        this.renouvellement = renouvellement;
    }

    public String getMethodeanterieure() {
        return methodeanterieure;
    }

    public void setMethodeanterieure(String methodeanterieure) {
        if (methodeanterieure.length() == 0) {
            methodeanterieure = null;
        }
        this.methodeanterieure = methodeanterieure;
    }

    public String getAutreMethodeAnterieure() {
        return autreMethodeAnterieure;
    }

    public void setAutreMethodeAnterieure(String autreMethodeAnterieure) {
        this.autreMethodeAnterieure = autreMethodeAnterieure;
    }

    public String getSourcerenseignementsurPF() {
        return sourcerenseignementsurPF;
    }

    public void setSourcerenseignementsurPF(String sourcerenseignementsurPF) {
        this.sourcerenseignementsurPF = sourcerenseignementsurPF;
    }

    public String getRaisondechangement() {
        return raisondechangement;
    }

    public void setRaisondechangement(String raisondechangement) {
        this.raisondechangement = raisondechangement;
    }

    public String getPlanification() {
        return planification;
    }

    public void setPlanification(String planification) {
        this.planification = planification;
    }

    public String getCounsling() {
        return counsling;
    }

    public void setCounsling(String counsling) {
        if (counsling.length() == 0) {
            counsling = null;
        }
        this.counsling = counsling;
    }

    public String getMethodechoisie() {
        return methodechoisie;
    }

    public void setMethodechoisie(String methodechoisie) {
        if (methodechoisie.length() == 0) {
            methodechoisie = null;
        }
        this.methodechoisie = methodechoisie;
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

    @XmlTransient
    public Collection<MotifConsultation> getMotifConsultationCollection() {
        return motifConsultationCollection;
    }

    public void setMotifConsultationCollection(Collection<MotifConsultation> motifConsultationCollection) {
        this.motifConsultationCollection = motifConsultationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPF != null ? idPF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanficationFamiliale)) {
            return false;
        }
        PlanficationFamiliale other = (PlanficationFamiliale) object;
        if ((this.idPF == null && other.idPF != null) || (this.idPF != null && !this.idPF.equals(other.idPF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("dd-MM-yyyy").format(this.date)+" / "+this.getNumDossier().toString();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRetraitimplant() {
        return retraitimplant;
    }

    public void setRetraitimplant(String retraitimplant) {
        this.retraitimplant = retraitimplant;
    }

    public String getRetraitDIU() {
        return retraitDIU;
    }

    public void setRetraitDIU(String retraitDIU) {
        this.retraitDIU = retraitDIU;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getLimiteinformation() {
        return limiteinformation;
    }

    public void setLimiteinformation(String limiteinformation) {
        this.limiteinformation = limiteinformation;
    }

}
