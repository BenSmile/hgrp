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
@Table(name = "consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c"),
    @NamedQuery(name = "Consultation.findByIdRDV", query = "SELECT c FROM Consultation c WHERE c.idRDV = :idRDV"),
    @NamedQuery(name = "Consultation.findByDate", query = "SELECT c FROM Consultation c WHERE c.date = :date"),
    @NamedQuery(name = "Consultation.findByAgeGrossesse", query = "SELECT c FROM Consultation c WHERE c.ageGrossesse = :ageGrossesse"),
    @NamedQuery(name = "Consultation.findByConjonctivehb", query = "SELECT c FROM Consultation c WHERE c.conjonctivehb = :conjonctivehb"),
    @NamedQuery(name = "Consultation.findByHauteurUterine", query = "SELECT c FROM Consultation c WHERE c.hauteurUterine = :hauteurUterine"),
    @NamedQuery(name = "Consultation.findBySurfaceuterine", query = "SELECT c FROM Consultation c WHERE c.surfaceuterine = :surfaceuterine"),
    @NamedQuery(name = "Consultation.findByMouvementfoetaux", query = "SELECT c FROM Consultation c WHERE c.mouvementfoetaux = :mouvementfoetaux"),
    @NamedQuery(name = "Consultation.findByBruitfoetaux", query = "SELECT c FROM Consultation c WHERE c.bruitfoetaux = :bruitfoetaux"),
    @NamedQuery(name = "Consultation.findByBcf", query = "SELECT c FROM Consultation c WHERE c.bcf = :bcf"),
    @NamedQuery(name = "Consultation.findByPresentation", query = "SELECT c FROM Consultation c WHERE c.presentation = :presentation"),
    @NamedQuery(name = "Consultation.findByPertesliquidi\u00e8nnes", query = "SELECT c FROM Consultation c WHERE c.pertesliquidi\u00e8nnes = :pertesliquidi\u00e8nnes"),
    @NamedQuery(name = "Consultation.findByOedemes", query = "SELECT c FROM Consultation c WHERE c.oedemes = :oedemes"),
    @NamedQuery(name = "Consultation.findByAlbuminure", query = "SELECT c FROM Consultation c WHERE c.albuminure = :albuminure"),
    @NamedQuery(name = "Consultation.findByGlycosurie", query = "SELECT c FROM Consultation c WHERE c.glycosurie = :glycosurie"),
    @NamedQuery(name = "Consultation.findByTa1", query = "SELECT c FROM Consultation c WHERE c.ta1 = :ta1"),
    @NamedQuery(name = "Consultation.findByTa2", query = "SELECT c FROM Consultation c WHERE c.ta2 = :ta2"),
    @NamedQuery(name = "Consultation.findByMictalgie", query = "SELECT c FROM Consultation c WHERE c.mictalgie = :mictalgie"),
    @NamedQuery(name = "Consultation.findByContraction", query = "SELECT c FROM Consultation c WHERE c.contraction = :contraction"),
    @NamedQuery(name = "Consultation.findByBassinPromonitoire", query = "SELECT c FROM Consultation c WHERE c.bassinPromonitoire = :bassinPromonitoire"),
    @NamedQuery(name = "Consultation.findByPoids", query = "SELECT c FROM Consultation c WHERE c.poids = :poids"),
    @NamedQuery(name = "Consultation.findByTaille", query = "SELECT c FROM Consultation c WHERE c.taille = :taille"),
    @NamedQuery(name = "Consultation.findByFemmeARisque", query = "SELECT c FROM Consultation c WHERE c.femmeARisque = :femmeARisque"),
    @NamedQuery(name = "Consultation.findByDecisioncentresante", query = "SELECT c FROM Consultation c WHERE c.decisioncentresante = :decisioncentresante"),
    @NamedQuery(name = "Consultation.findByRaison", query = "SELECT c FROM Consultation c WHERE c.raison = :raison")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRDV")
    private Integer idRDV;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Age_Grossesse")
    private String ageGrossesse;
    @Size(max = 20)
    @Column(name = "Conjonctive_hb")
    private String conjonctivehb;
    @Column(name = "hauteur_uterine")
    private Integer hauteurUterine;
    @Size(max = 11)
    @Column(name = "Surface_uterine")
    private String surfaceuterine;
    @Size(max = 8)
    @Column(name = "Mouvement_foetaux")
    private String mouvementfoetaux;
    @Size(max = 8)
    @Column(name = "Bruit_foetaux")
    private String bruitfoetaux;
    @Size(max = 8)
    @Column(name = "BCF")
    private String bcf;
    @Size(max = 13)
    @Column(name = "Presentation")
    private String presentation;
    @Size(max = 4)
    @Column(name = "Pertes_liquidi\u00e8nnes")
    private String pertesliquidiènnes;
    @Size(max = 8)
    @Column(name = "Oedemes")
    private String oedemes;
    @Size(max = 8)
    @Column(name = "Albuminure")
    private String albuminure;
    @Size(max = 8)
    @Column(name = "Glycosurie")
    private String glycosurie;
    @Column(name = "TA1")
    private Integer ta1;
    @Column(name = "TA2")
    private Integer ta2;
    @Size(max = 8)
    @Column(name = "Mictalgie")
    private String mictalgie;
    @Size(max = 8)
    @Column(name = "Contraction")
    private String contraction;
    @Size(max = 14)
    @Column(name = "Bassin_Promonitoire")
    private String bassinPromonitoire;
    @Column(name = "Poids")
    private Integer poids;
    @Column(name = "Taille")
    private String taille;
    @Size(max = 8)
    @Column(name = "Femme_A_Risque")
    private String femmeARisque;
    @Size(max = 44)
    @Column(name = "Decision_centre_sante")
    private String decisioncentresante;
    @Size(max = 450)
    @Column(name = "Raison")
    private String raison;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRDV")
    private Collection<MesuresPreventives> mesuresPreventivesCollection;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne(optional = false)
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public Consultation() {
    }

    public Consultation(Integer idRDV) {
        this.idRDV = idRDV;
    }

    public Consultation(Integer idRDV, String ageGrossesse) {
        this.idRDV = idRDV;
        this.ageGrossesse = ageGrossesse;
    }

    public Integer getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(Integer idRDV) {
        this.idRDV = idRDV;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAgeGrossesse() {
        return ageGrossesse;
    }

    public void setAgeGrossesse(String ageGrossesse) {
        this.ageGrossesse = ageGrossesse;
    }

    public String getConjonctivehb() {
        return conjonctivehb;
    }

    public void setConjonctivehb(String conjonctivehb) {
        if (conjonctivehb.length() == 0) {
            conjonctivehb = null;
        }
        this.conjonctivehb = conjonctivehb;
    }

    public Integer getHauteurUterine() {
        return hauteurUterine;
    }

    public void setHauteurUterine(Integer hauteurUterine) {
        this.hauteurUterine = hauteurUterine;
    }

    public String getSurfaceuterine() {
        return surfaceuterine;
    }

    public void setSurfaceuterine(String surfaceuterine) {
        if (surfaceuterine.length() == 0) {
            surfaceuterine = null;
        }
        this.surfaceuterine = surfaceuterine;
    }

    public String getMouvementfoetaux() {
        return mouvementfoetaux;
    }

    public void setMouvementfoetaux(String mouvementfoetaux) {
        if (mouvementfoetaux.length() == 0) {
            mouvementfoetaux = null;
        }
        this.mouvementfoetaux = mouvementfoetaux;
    }

    public String getBruitfoetaux() {
        return bruitfoetaux;
    }

    public void setBruitfoetaux(String bruitfoetaux) {
        if (bruitfoetaux.length() == 0) {
            bruitfoetaux = null;
        }
        this.bruitfoetaux = bruitfoetaux;
    }

    public String getBcf() {
        return bcf;
    }

    public void setBcf(String bcf) {
        if (bcf.length() == 0) {
            bcf = null;
        }
        this.bcf = bcf;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        if (presentation.length() == 0) {
            presentation = null;
        }
        this.presentation = presentation;
    }

    public String getPertesliquidiènnes() {
        return pertesliquidiènnes;
    }

    public void setPertesliquidiènnes(String pertesliquidiènnes) {
        if (pertesliquidiènnes.length() == 0) {
            pertesliquidiènnes = null;
        }
        this.pertesliquidiènnes = pertesliquidiènnes;
    }

    public String getOedemes() {
        return oedemes;
    }

    public void setOedemes(String oedemes) {
        if (oedemes.length() == 0) {
            oedemes = null;
        }
        this.oedemes = oedemes;
    }

    public String getAlbuminure() {
        return albuminure;
    }

    public void setAlbuminure(String albuminure) {
        if (albuminure.length() == 0) {
            albuminure = null;
        }
        this.albuminure = albuminure;
    }

    public String getGlycosurie() {
        return glycosurie;
    }

    public void setGlycosurie(String glycosurie) {
        if (glycosurie.length() == 0) {
            glycosurie = null;
        }
        this.glycosurie = glycosurie;
    }

    public Integer getTa1() {
        return ta1;
    }

    public void setTa1(Integer ta1) {
        this.ta1 = ta1;
    }

    public Integer getTa2() {
        return ta2;
    }

    public void setTa2(Integer ta2) {
        this.ta2 = ta2;
    }

    public String getMictalgie() {
        return mictalgie;
    }

    public void setMictalgie(String mictalgie) {
        if (mictalgie.length() == 0) {
            mictalgie = null;
        }
        this.mictalgie = mictalgie;
    }

    public String getContraction() {
        return contraction;
    }

    public void setContraction(String contraction) {
        if (contraction.length() == 0) {
            contraction = null;
        }
        this.contraction = contraction;
    }

    public String getBassinPromonitoire() {
        return bassinPromonitoire;
    }

    public void setBassinPromonitoire(String bassinPromonitoire) {
        if (bassinPromonitoire.length() == 0) {
            bassinPromonitoire = null;
        }
        this.bassinPromonitoire = bassinPromonitoire;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getFemmeARisque() {
        return femmeARisque;
    }

    public void setFemmeARisque(String femmeARisque) {
        if (femmeARisque.length() == 0) {
            femmeARisque = null;
        }
        this.femmeARisque = femmeARisque;
    }

    public String getDecisioncentresante() {
        return decisioncentresante;
    }

    public void setDecisioncentresante(String decisioncentresante) {
        if (decisioncentresante.length() == 0) {
            decisioncentresante = null;
        }
        this.decisioncentresante = decisioncentresante;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @XmlTransient
    public Collection<MesuresPreventives> getMesuresPreventivesCollection() {
        return mesuresPreventivesCollection;
    }

    public void setMesuresPreventivesCollection(Collection<MesuresPreventives> mesuresPreventivesCollection) {
        this.mesuresPreventivesCollection = mesuresPreventivesCollection;
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
        hash += (idRDV != null ? idRDV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.idRDV == null && other.idRDV != null) || (this.idRDV != null && !this.idRDV.equals(other.idRDV))) {
            return false;
        }
        return true;
    }
  

}
