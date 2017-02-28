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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dtp
 */
@Entity
@Table(name = "infos_accouchement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfosAccouchement.findAll", query = "SELECT i FROM InfosAccouchement i")
    ,
    @NamedQuery(name = "InfosAccouchement.findByIdInfoAcc", query = "SELECT i FROM InfosAccouchement i WHERE i.idInfoAcc = :idInfoAcc")
    ,
    @NamedQuery(name = "InfosAccouchement.findByDateaccouchement", query = "SELECT i FROM InfosAccouchement i WHERE i.dateaccouchement = :dateaccouchement")
    ,
    @NamedQuery(name = "InfosAccouchement.findByDatesortie", query = "SELECT i FROM InfosAccouchement i WHERE i.datesortie = :datesortie")
    ,
    @NamedQuery(name = "InfosAccouchement.findByAccoucheuse", query = "SELECT i FROM InfosAccouchement i WHERE i.accoucheuse = :accoucheuse")
    ,
    @NamedQuery(name = "InfosAccouchement.findByEtatMere", query = "SELECT i FROM InfosAccouchement i WHERE i.etatMere = :etatMere")
    ,
    @NamedQuery(name = "InfosAccouchement.findByDecesmaternelPostTravail", query = "SELECT i FROM InfosAccouchement i WHERE i.decesmaternelPostTravail = :decesmaternelPostTravail")
    ,
    @NamedQuery(name = "InfosAccouchement.findByDecesMaternelApresIntervention", query = "SELECT i FROM InfosAccouchement i WHERE i.decesMaternelApresIntervention = :decesMaternelApresIntervention")
    ,
    @NamedQuery(name = "InfosAccouchement.findByModeaccouchement", query = "SELECT i FROM InfosAccouchement i WHERE i.modeaccouchement = :modeaccouchement")
    ,
    @NamedQuery(name = "InfosAccouchement.findByEutocique", query = "SELECT i FROM InfosAccouchement i WHERE i.eutocique = :eutocique")
    ,
    @NamedQuery(name = "InfosAccouchement.findByDystocique", query = "SELECT i FROM InfosAccouchement i WHERE i.dystocique = :dystocique")
    ,
    @NamedQuery(name = "InfosAccouchement.findByHa", query = "SELECT i FROM InfosAccouchement i WHERE i.ha = :ha")
    ,
    @NamedQuery(name = "InfosAccouchement.findByTrans", query = "SELECT i FROM InfosAccouchement i WHERE i.trans = :trans")
    ,
    @NamedQuery(name = "InfosAccouchement.findByInfection", query = "SELECT i FROM InfosAccouchement i WHERE i.infection = :infection")
    ,
    @NamedQuery(name = "InfosAccouchement.findByIndication", query = "SELECT i FROM InfosAccouchement i WHERE i.indication = :indication")
    ,
    @NamedQuery(name = "InfosAccouchement.findByEtatEnfant", query = "SELECT i FROM InfosAccouchement i WHERE i.etatEnfant = :etatEnfant")
    ,
    @NamedQuery(name = "InfosAccouchement.findByVivant", query = "SELECT i FROM InfosAccouchement i WHERE i.vivant = :vivant")
    ,
    @NamedQuery(name = "InfosAccouchement.findByMortne", query = "SELECT i FROM InfosAccouchement i WHERE i.mortne = :mortne")
    ,
    @NamedQuery(name = "InfosAccouchement.findByPoids", query = "SELECT i FROM InfosAccouchement i WHERE i.poids = :poids")
    ,
    @NamedQuery(name = "InfosAccouchement.findBySexe", query = "SELECT i FROM InfosAccouchement i WHERE i.sexe = :sexe")
    ,
    @NamedQuery(name = "InfosAccouchement.findByPresentation", query = "SELECT i FROM InfosAccouchement i WHERE i.presentation = :presentation")
    ,
    @NamedQuery(name = "InfosAccouchement.findByParticulariteEnfant", query = "SELECT i FROM InfosAccouchement i WHERE i.particulariteEnfant = :particulariteEnfant")
    ,
    @NamedQuery(name = "InfosAccouchement.findByObservation", query = "SELECT i FROM InfosAccouchement i WHERE i.observation = :observation")
    ,
    @NamedQuery(name = "InfosAccouchement.findByAccouchementVIHPositif", query = "SELECT i FROM InfosAccouchement i WHERE i.accouchementVIHPositif = :accouchementVIHPositif")
    ,
    @NamedQuery(name = "InfosAccouchement.findByTritherapiePourVIH", query = "SELECT i FROM InfosAccouchement i WHERE i.tritherapiePourVIH = :tritherapiePourVIH")
    ,
    @NamedQuery(name = "InfosAccouchement.findByEnfantVIHPositif", query = "SELECT i FROM InfosAccouchement i WHERE i.enfantVIHPositif = :enfantVIHPositif")
    ,
    @NamedQuery(name = "InfosAccouchement.findByTritherapieEnfantVIHPositif", query = "SELECT i FROM InfosAccouchement i WHERE i.tritherapieEnfantVIHPositif = :tritherapieEnfantVIHPositif")
    ,
    @NamedQuery(name = "InfosAccouchement.findByCPoN18emeJour", query = "SELECT i FROM InfosAccouchement i WHERE i.cPoN18emeJour = :cPoN18emeJour")
    ,
    @NamedQuery(name = "InfosAccouchement.findByCPoN242emeJour", query = "SELECT i FROM InfosAccouchement i WHERE i.cPoN242emeJour = :cPoN242emeJour")
    ,
    @NamedQuery(name = "InfosAccouchement.findByRecuVitamineA", query = "SELECT i FROM InfosAccouchement i WHERE i.recuVitamineA = :recuVitamineA")
    ,
    @NamedQuery(name = "InfosAccouchement.findByRecuFerAcideFollique", query = "SELECT i FROM InfosAccouchement i WHERE i.recuFerAcideFollique = :recuFerAcideFollique")
    ,
    @NamedQuery(name = "InfosAccouchement.findByComplicationApresAcc", query = "SELECT i FROM InfosAccouchement i WHERE i.complicationApresAcc = :complicationApresAcc")})
public class InfosAccouchement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInfoAcc")
    private Integer idInfoAcc;
    @Column(name = "Date_accouchement")
    @Temporal(TemporalType.DATE)
    private Date dateaccouchement;
    @Column(name = "Date_sortie")
    @Temporal(TemporalType.DATE)
    private Date datesortie;
    @Size(max = 30)
    @Column(name = "Accoucheuse")
    private String accoucheuse;
    @Size(max = 8)
    @Column(name = "EtatMere")
    private String etatMere;
    @Size(max = 4)
    @Column(name = "Deces_maternel_PostTravail")
    private String decesmaternelPostTravail;
    @Size(max = 4)
    @Column(name = "Deces_Maternel_ApresIntervention")
    private String decesMaternelApresIntervention;
    @Size(max = 10)
    @Column(name = "Mode_accouchement")
    private String modeaccouchement;
    @Size(max = 4)
    @Column(name = "Eutocique")
    private String eutocique;
    @Size(max = 11)
    @Column(name = "Dystocique")
    private String dystocique;
    @Size(max = 4)
    @Column(name = "HA")
    private String ha;
    @Size(max = 4)
    @Column(name = "Trans")
    private String trans;
    @Size(max = 26)
    @Column(name = "Infection")
    private String infection;
    @Size(max = 149)
    @Column(name = "Indication")
    private String indication;
    @Size(max = 14)
    @Column(name = "Etat_Enfant")
    private String etatEnfant;
    @Size(max = 11)
    @Column(name = "Vivant")
    private String vivant;
    @Size(max = 10)
    @Column(name = "Mort_ne")
    private String mortne;
    @Size(max = 20)
    @Column(name = "Poids")
    private String poids;
    @Size(max = 9)
    @Column(name = "Sexe")
    private String sexe;
    @Size(max = 11)
    @Column(name = "Presentation")
    private String presentation;
    @Size(max = 94)
    @Column(name = "Particularite_Enfant")
    private String particulariteEnfant;
    @Size(max = 150)
    @Column(name = "Observation")
    private String observation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Accouchement_VIH_Positif")
    private String accouchementVIHPositif;
    @Size(max = 4)
    @Column(name = "Tritherapie_Pour_VIH")
    private String tritherapiePourVIH;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Enfant_VIH_Positif")
    private String enfantVIHPositif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Tritherapie_Enfant_VIH_Positif")
    private String tritherapieEnfantVIHPositif;
    @Size(max = 4)
    @Column(name = "CPoN1_8emeJour")
    private String cPoN18emeJour;
    @Size(max = 4)
    @Column(name = "CPoN2_42emeJour")
    private String cPoN242emeJour;
    @Size(max = 4)
    @Column(name = "Recu_VitamineA")
    private String recuVitamineA;
    @Size(max = 4)
    @Column(name = "Recu_Fer_AcideFollique")
    private String recuFerAcideFollique;
    @Size(max = 4)
    @Column(name = "Complication_Apres_Acc")
    private String complicationApresAcc;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne(optional = false)
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public InfosAccouchement() {
    }

    public InfosAccouchement(Integer idInfoAcc) {
        this.idInfoAcc = idInfoAcc;
    }

    public InfosAccouchement(Integer idInfoAcc, String accouchementVIHPositif, String enfantVIHPositif, String tritherapieEnfantVIHPositif) {
        this.idInfoAcc = idInfoAcc;
        this.accouchementVIHPositif = accouchementVIHPositif;
        this.enfantVIHPositif = enfantVIHPositif;
        this.tritherapieEnfantVIHPositif = tritherapieEnfantVIHPositif;
    }

    public Integer getIdInfoAcc() {
        return idInfoAcc;
    }

    public void setIdInfoAcc(Integer idInfoAcc) {
        this.idInfoAcc = idInfoAcc;
    }

    public Date getDateaccouchement() {
        return dateaccouchement;
    }

    public void setDateaccouchement(Date dateaccouchement) {
        this.dateaccouchement = dateaccouchement;
    }

    public Date getDatesortie() {
        return datesortie;
    }

    public void setDatesortie(Date datesortie) {
        this.datesortie = datesortie;
    }

    public String getAccoucheuse() {
        return accoucheuse;
    }

    public void setAccoucheuse(String accoucheuse) {
        this.accoucheuse = accoucheuse;
    }

    public String getEtatMere() {
        return etatMere;
    }

    public void setEtatMere(String etatMere) {
        if (etatMere.length() == 0) {
            etatMere = null;
        }
        this.etatMere = etatMere;
    }

    public String getDecesmaternelPostTravail() {
        return decesmaternelPostTravail;
    }

    public void setDecesmaternelPostTravail(String decesmaternelPostTravail) {
        if (decesmaternelPostTravail.length() == 0) {
            decesmaternelPostTravail = null;
        }
        this.decesmaternelPostTravail = decesmaternelPostTravail;
    }

    public String getDecesMaternelApresIntervention() {
        return decesMaternelApresIntervention;
    }

    public void setDecesMaternelApresIntervention(String decesMaternelApresIntervention) {
        if (decesMaternelApresIntervention.length() == 0) {
            decesMaternelApresIntervention = null;
        }
        this.decesMaternelApresIntervention = decesMaternelApresIntervention;
    }

    public String getModeaccouchement() {
        return modeaccouchement;
    }

    public void setModeaccouchement(String modeaccouchement) {
       if (modeaccouchement.length() == 0) {
            modeaccouchement = null;
        }
       this.modeaccouchement = modeaccouchement;
    }

    public String getEutocique() {
        return eutocique;
    }

    public void setEutocique(String eutocique) {
       if (eutocique.length() == 0) {
            eutocique = null;
        }
       this.eutocique = eutocique;
    }

    public String getDystocique() {
        return dystocique;
    }

    public void setDystocique(String dystocique) {
         if (dystocique.length() == 0) {
            dystocique = null;
        }
         this.dystocique = dystocique;
    }

    public String getHa() {
        return ha;
    }

    public void setHa(String ha) {
        if (ha.length() == 0) {
            ha = null;
        }  this.ha = ha;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        if (trans.length() == 0) {
            trans = null;
        }  this.trans = trans;
    }

    public String getInfection() {
        return infection;
    }

    public void setInfection(String infection) {
        if (infection.length() == 0) {
            infection = null;
        }  this.infection = infection;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
       if (indication.length() == 0) {
            indication = null;
        } 
       this.indication = indication;
    }

    public String getEtatEnfant() {
        return etatEnfant;
    }

    public void setEtatEnfant(String etatEnfant) {
        if (etatEnfant.length() == 0) {
            etatEnfant = null;
        }  this.etatEnfant = etatEnfant;
    }

    public String getVivant() {
        return vivant;
    }

    public void setVivant(String vivant) {
       if (vivant.length() == 0) {
            vivant = null;
        }  this.vivant = vivant;
    }

    public String getMortne() {
        return mortne;
    }

    public void setMortne(String mortne) {
        if (mortne.length() == 0) {
            mortne = null;
        } this.mortne = mortne;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        if (poids.length() == 0) {
            poids = null;
        }  this.poids = poids;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        if (sexe.length() == 0) {
            sexe = null;
        }  this.sexe = sexe;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        if (presentation.length() == 0) {
            presentation = null;
        }  this.presentation = presentation;
    }

    public String getParticulariteEnfant() {
        return particulariteEnfant;
    }

    public void setParticulariteEnfant(String particulariteEnfant) {
        if (particulariteEnfant.length() == 0) {
            particulariteEnfant = null;
        } 
        this.particulariteEnfant = particulariteEnfant;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getAccouchementVIHPositif() {
        return accouchementVIHPositif;
    }

    public void setAccouchementVIHPositif(String accouchementVIHPositif) {
         if (accouchementVIHPositif.length() == 0) {
            accouchementVIHPositif = null;
        }  this.accouchementVIHPositif = accouchementVIHPositif;
    }

    public String getTritherapiePourVIH() {
        return tritherapiePourVIH;
    }

    public void setTritherapiePourVIH(String tritherapiePourVIH) {
         if (tritherapiePourVIH.length() == 0) {
            tritherapiePourVIH = null;
        }
         this.tritherapiePourVIH = tritherapiePourVIH;
    }

    public String getEnfantVIHPositif() {
        return enfantVIHPositif;
    }

    public void setEnfantVIHPositif(String enfantVIHPositif) {
         if (enfantVIHPositif.length() == 0) {
            enfantVIHPositif = null;
        }
         this.enfantVIHPositif = enfantVIHPositif;
    }

    public String getTritherapieEnfantVIHPositif() {
        return tritherapieEnfantVIHPositif;
    }

    public void setTritherapieEnfantVIHPositif(String tritherapieEnfantVIHPositif) {
        if (tritherapieEnfantVIHPositif.length() == 0) {
            tritherapieEnfantVIHPositif = null;
        }
        this.tritherapieEnfantVIHPositif = tritherapieEnfantVIHPositif;
    }

    public String getCPoN18emeJour() {
        return cPoN18emeJour;
    }

    public void setCPoN18emeJour(String cPoN18emeJour) {
        if (cPoN18emeJour.length() == 0) {
            cPoN18emeJour = null;
        }
        this.cPoN18emeJour = cPoN18emeJour;
    }

    public String getCPoN242emeJour() {
        return cPoN242emeJour;
    }

    public void setCPoN242emeJour(String cPoN242emeJour) {
        if (cPoN242emeJour.length() == 0) {
            cPoN242emeJour = null;
        }
        this.cPoN242emeJour = cPoN242emeJour;
    }

    public String getRecuVitamineA() {
        return recuVitamineA;
    }

    public void setRecuVitamineA(String recuVitamineA) {
         if (recuVitamineA.length() == 0) {
            recuVitamineA = null;
        }
         this.recuVitamineA = recuVitamineA;
    }

    public String getRecuFerAcideFollique() {
        return recuFerAcideFollique;
    }

    public void setRecuFerAcideFollique(String recuFerAcideFollique) {
        if (recuFerAcideFollique.length() == 0) {
            recuFerAcideFollique = null;
        }
        this.recuFerAcideFollique = recuFerAcideFollique;
    }

    public String getComplicationApresAcc() {
        return complicationApresAcc;
    }

    public void setComplicationApresAcc(String complicationApresAcc) {
         if (complicationApresAcc.length() == 0) {
            complicationApresAcc = null;
        }
         this.complicationApresAcc = complicationApresAcc;
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
        hash += (idInfoAcc != null ? idInfoAcc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfosAccouchement)) {
            return false;
        }
        InfosAccouchement other = (InfosAccouchement) object;
        if ((this.idInfoAcc == null && other.idInfoAcc != null) || (this.idInfoAcc != null && !this.idInfoAcc.equals(other.idInfoAcc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.InfosAccouchement[ idInfoAcc=" + idInfoAcc + " ]";
    }

}
