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
@Table(name = "donnees_objectives")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonneesObjectives.findAll", query = "SELECT d FROM DonneesObjectives d")
    ,
    @NamedQuery(name = "DonneesObjectives.findByIdDonnObject", query = "SELECT d FROM DonneesObjectives d WHERE d.idDonnObject = :idDonnObject")
    ,
    @NamedQuery(name = "DonneesObjectives.findByDateRDVPL", query = "SELECT d FROM DonneesObjectives d WHERE d.dateRDVPL = :dateRDVPL")
    ,
    @NamedQuery(name = "DonneesObjectives.findByPoids", query = "SELECT d FROM DonneesObjectives d WHERE d.poids = :poids")
    ,
    @NamedQuery(name = "DonneesObjectives.findByTa", query = "SELECT d FROM DonneesObjectives d WHERE d.ta = :ta")
    ,
    @NamedQuery(name = "DonneesObjectives.findBySigneinfectiongyneco", query = "SELECT d FROM DonneesObjectives d WHERE d.signeinfectiongyneco = :signeinfectiongyneco")
    ,
    @NamedQuery(name = "DonneesObjectives.findByIst", query = "SELECT d FROM DonneesObjectives d WHERE d.ist = :ist")
    ,
    @NamedQuery(name = "DonneesObjectives.findByAmenorhee6emSEm", query = "SELECT d FROM DonneesObjectives d WHERE d.amenorhee6emSEm = :amenorhee6emSEm")
    ,
    @NamedQuery(name = "DonneesObjectives.findBySigneGrossesse", query = "SELECT d FROM DonneesObjectives d WHERE d.signeGrossesse = :signeGrossesse")
    ,
    @NamedQuery(name = "DonneesObjectives.findByVisiontroublee", query = "SELECT d FROM DonneesObjectives d WHERE d.visiontroublee = :visiontroublee")
    ,
    @NamedQuery(name = "DonneesObjectives.findByCephaleesintenses", query = "SELECT d FROM DonneesObjectives d WHERE d.cephaleesintenses = :cephaleesintenses")
    ,
    @NamedQuery(name = "DonneesObjectives.findByMasseSuspecte", query = "SELECT d FROM DonneesObjectives d WHERE d.masseSuspecte = :masseSuspecte")
    ,
    @NamedQuery(name = "DonneesObjectives.findByNauseeVaumissement", query = "SELECT d FROM DonneesObjectives d WHERE d.nauseeVaumissement = :nauseeVaumissement")
    ,
    @NamedQuery(name = "DonneesObjectives.findByDouleurPelvienne", query = "SELECT d FROM DonneesObjectives d WHERE d.douleurPelvienne = :douleurPelvienne")
    ,
    @NamedQuery(name = "DonneesObjectives.findByIcteres", query = "SELECT d FROM DonneesObjectives d WHERE d.icteres = :icteres")
    ,
    @NamedQuery(name = "DonneesObjectives.findByFatigabilite", query = "SELECT d FROM DonneesObjectives d WHERE d.fatigabilite = :fatigabilite")
    ,
    @NamedQuery(name = "DonneesObjectives.findByExamenSeins", query = "SELECT d FROM DonneesObjectives d WHERE d.examenSeins = :examenSeins")
    ,
    @NamedQuery(name = "DonneesObjectives.findByExamenAbdomen", query = "SELECT d FROM DonneesObjectives d WHERE d.examenAbdomen = :examenAbdomen")
    ,
    @NamedQuery(name = "DonneesObjectives.findByExamengyneco", query = "SELECT d FROM DonneesObjectives d WHERE d.examengyneco = :examengyneco")
    ,
    @NamedQuery(name = "DonneesObjectives.findByGainanormalePoids", query = "SELECT d FROM DonneesObjectives d WHERE d.gainanormalePoids = :gainanormalePoids")
    ,
    @NamedQuery(name = "DonneesObjectives.findByTAtropelevee", query = "SELECT d FROM DonneesObjectives d WHERE d.tAtropelevee = :tAtropelevee")
    ,
    @NamedQuery(name = "DonneesObjectives.findBySigneAnemie", query = "SELECT d FROM DonneesObjectives d WHERE d.signeAnemie = :signeAnemie")
    ,
    @NamedQuery(name = "DonneesObjectives.findByAutressignesAnormaux", query = "SELECT d FROM DonneesObjectives d WHERE d.autressignesAnormaux = :autressignesAnormaux")
    ,
    @NamedQuery(name = "DonneesObjectives.findByMethode", query = "SELECT d FROM DonneesObjectives d WHERE d.methode = :methode")
    ,
    @NamedQuery(name = "DonneesObjectives.findByQuantite", query = "SELECT d FROM DonneesObjectives d WHERE d.quantite = :quantite")
    ,
    @NamedQuery(name = "DonneesObjectives.findByDateProchaineVisite", query = "SELECT d FROM DonneesObjectives d WHERE d.dateProchaineVisite = :dateProchaineVisite")})
public class DonneesObjectives implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDonnObject")
    private Integer idDonnObject;
    @Column(name = "DateRDVPL")
    @Temporal(TemporalType.DATE)
    private Date dateRDVPL;
    @Column(name = "Poids")
    private Integer poids;
    @Column(name = "TA")
    private String ta;
    @Size(max = 10)
    @Column(name = "Signe_infection_gyneco")
    private String signeinfectiongyneco;
    @Size(max = 10)
    @Column(name = "IST")
    private String ist;
    @Size(max = 10)
    @Column(name = "Amenorhee_6emSEm")
    private String amenorhee6emSEm;
    @Size(max = 10)
    @Column(name = "Signe_Grossesse")
    private String signeGrossesse;
    @Size(max = 10)
    @Column(name = "Vision_troublee")
    private String visiontroublee;
    @Size(max = 10)
    @Column(name = "Cephalees_intenses")
    private String cephaleesintenses;
    @Size(max = 10)
    @Column(name = "Masse_Suspecte")
    private String masseSuspecte;
    @Size(max = 10)
    @Column(name = "Nausee_Vaumissement")
    private String nauseeVaumissement;
    @Size(max = 10)
    @Column(name = "douleur_Pelvienne")
    private String douleurPelvienne;
    @Size(max = 10)
    @Column(name = "Icteres")
    private String icteres;
    @Size(max = 10)
    @Column(name = "Fatigabilite")
    private String fatigabilite;
    @Size(max = 10)
    @Column(name = "Examen_Seins")
    private String examenSeins;
    @Size(max = 10)
    @Column(name = "Examen_Abdomen")
    private String examenAbdomen;
    @Size(max = 10)
    @Column(name = "Examen_gyneco")
    private String examengyneco;
    @Size(max = 10)
    @Column(name = "Gain_anormale_Poids")
    private String gainanormalePoids;
    @Size(max = 10)
    @Column(name = "TA_trop_elevee")
    private String tAtropelevee;
    @Size(max = 10)
    @Column(name = "Signe_Anemie")
    private String signeAnemie;
    @Size(max = 10)
    @Column(name = "Autres_signes_Anormaux")
    private String autressignesAnormaux;
    @Size(max = 17)
    @Column(name = "Methode")
    private String methode;
    @Column(name = "Quantite")
    private Integer quantite;
    @Column(name = "Date_Prochaine_Visite")
    @Temporal(TemporalType.DATE)
    private Date dateProchaineVisite;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public DonneesObjectives() {
    }

    public DonneesObjectives(Integer idDonnObject) {
        this.idDonnObject = idDonnObject;
    }

    public Integer getIdDonnObject() {
        return idDonnObject;
    }

    public void setIdDonnObject(Integer idDonnObject) {
        this.idDonnObject = idDonnObject;
    }

    public Date getDateRDVPL() {
        return dateRDVPL;
    }

    public void setDateRDVPL(Date dateRDVPL) {
        this.dateRDVPL = dateRDVPL;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public String getSigneinfectiongyneco() {
        return signeinfectiongyneco;
    }

    public void setSigneinfectiongyneco(String signeinfectiongyneco) {
        if (signeinfectiongyneco.length() == 0) {
            signeinfectiongyneco = null;
        }
        this.signeinfectiongyneco = signeinfectiongyneco;
    }

    public String getIst() {
        return ist;
    }

    public void setIst(String ist) {
        if (ist.length() == 0) {
            ist = null;
        }
        this.ist = ist;
    }

    public String getAmenorhee6emSEm() {
        return amenorhee6emSEm;
    }

    public void setAmenorhee6emSEm(String amenorhee6emSEm) {
        if (amenorhee6emSEm.length() == 0) {
            amenorhee6emSEm = null;
        }
        this.amenorhee6emSEm = amenorhee6emSEm;
    }

    public String getSigneGrossesse() {
        return signeGrossesse;
    }

    public void setSigneGrossesse(String signeGrossesse) {
        if (signeGrossesse.length() == 0) {
            signeGrossesse = null;
        }
        this.signeGrossesse = signeGrossesse;
    }

    public String getVisiontroublee() {
        return visiontroublee;
    }

    public void setVisiontroublee(String visiontroublee) {
        if (visiontroublee.length() == 0) {
            visiontroublee = null;
        }
        this.visiontroublee = visiontroublee;
    }

    public String getCephaleesintenses() {
        return cephaleesintenses;
    }

    public void setCephaleesintenses(String cephaleesintenses) {
        if (cephaleesintenses.length() == 0) {
            cephaleesintenses = null;
        }
        this.cephaleesintenses = cephaleesintenses;
    }

    public String getMasseSuspecte() {
        return masseSuspecte;
    }

    public void setMasseSuspecte(String masseSuspecte) {
        if (masseSuspecte.length() == 0) {
            masseSuspecte = null;
        }
        this.masseSuspecte = masseSuspecte;
    }

    public String getNauseeVaumissement() {
        return nauseeVaumissement;
    }

    public void setNauseeVaumissement(String nauseeVaumissement) {
        if (nauseeVaumissement.length() == 0) {
            nauseeVaumissement = null;
        }
        this.nauseeVaumissement = nauseeVaumissement;
    }

    public String getDouleurPelvienne() {
        return douleurPelvienne;
    }

    public void setDouleurPelvienne(String douleurPelvienne) {
        if (douleurPelvienne.length() == 0) {
            douleurPelvienne = null;
        }
        this.douleurPelvienne = douleurPelvienne;
    }

    public String getIcteres() {
        return icteres;
    }

    public void setIcteres(String icteres) {
        if (icteres.length() == 0) {
            icteres = null;
        }
        this.icteres = icteres;
    }

    public String getFatigabilite() {
        return fatigabilite;
    }

    public void setFatigabilite(String fatigabilite) {
        if (fatigabilite.length() == 0) {
            fatigabilite = null;
        }
        this.fatigabilite = fatigabilite;
    }

    public String getExamenSeins() {
        return examenSeins;
    }

    public void setExamenSeins(String examenSeins) {
        if (examenSeins.length() == 0) {
            examenSeins = null;
        }
        this.examenSeins = examenSeins;
    }

    public String getExamenAbdomen() {
        return examenAbdomen;
    }

    public void setExamenAbdomen(String examenAbdomen) {
       if (examenAbdomen.length() == 0) {
            examenAbdomen = null;
        }  this.examenAbdomen = examenAbdomen;
    }

    public String getExamengyneco() {
        return examengyneco;
    }

    public void setExamengyneco(String examengyneco) {
        if (examengyneco.length() == 0) {
            examengyneco = null;
        } 
        this.examengyneco = examengyneco;
    }

    public String getGainanormalePoids() {
        return gainanormalePoids;
    }

    public void setGainanormalePoids(String gainanormalePoids) {
        if (gainanormalePoids.length() == 0) {
            gainanormalePoids = null;
        }  this.gainanormalePoids = gainanormalePoids;
    }

    public String getTAtropelevee() {
        return tAtropelevee;
    }

    public void setTAtropelevee(String tAtropelevee) {
        if (tAtropelevee.length() == 0) {
            tAtropelevee = null;
        }  this.tAtropelevee = tAtropelevee;
    }

    public String getSigneAnemie() {
        return signeAnemie;
    }

    public void setSigneAnemie(String signeAnemie) {
        if (signeAnemie.length() == 0) {
            signeAnemie = null;
        } this.signeAnemie = signeAnemie;
    }

    public String getAutressignesAnormaux() {
        return autressignesAnormaux;
    }

    public void setAutressignesAnormaux(String autressignesAnormaux) {
       if (autressignesAnormaux.length() == 0) {
            autressignesAnormaux = null;
        }  this.autressignesAnormaux = autressignesAnormaux;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        if (methode.length() == 0) {
            methode = null;
        }
        this.methode = methode;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Date getDateProchaineVisite() {
        return dateProchaineVisite;
    }

    public void setDateProchaineVisite(Date dateProchaineVisite) {
        this.dateProchaineVisite = dateProchaineVisite;
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
        hash += (idDonnObject != null ? idDonnObject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonneesObjectives)) {
            return false;
        }
        DonneesObjectives other = (DonneesObjectives) object;
        if ((this.idDonnObject == null && other.idDonnObject != null) || (this.idDonnObject != null && !this.idDonnObject.equals(other.idDonnObject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.DonneesObjectives[ idDonnObject=" + idDonnObject + " ]";
    }

}
