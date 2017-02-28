/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@Table(name = "antecedent_cpn")
@XmlRootElement
@EntityListeners({
    AntecedantCPNListerner.class
})
@NamedQueries({
    @NamedQuery(name = "AntecedentCpn.findAll", query = "SELECT a FROM AntecedentCpn a")
    ,
    @NamedQuery(name = "AntecedentCpn.findByIdAntecObstr", query = "SELECT a FROM AntecedentCpn a WHERE a.idAntecObstr = :idAntecObstr")
    ,
    @NamedQuery(name = "AntecedentCpn.findByDdr", query = "SELECT a FROM AntecedentCpn a WHERE a.ddr = :ddr")
    ,
    @NamedQuery(name = "AntecedentCpn.findByDpa", query = "SELECT a FROM AntecedentCpn a WHERE a.dpa = :dpa")
    ,
    @NamedQuery(name = "AntecedentCpn.findByGrossesse", query = "SELECT a FROM AntecedentCpn a WHERE a.grossesse = :grossesse")
    ,
    @NamedQuery(name = "AntecedentCpn.findByEnfantsvie", query = "SELECT a FROM AntecedentCpn a WHERE a.enfantsvie = :enfantsvie")
    ,
    @NamedQuery(name = "AntecedentCpn.findByAvortement1erTrim", query = "SELECT a FROM AntecedentCpn a WHERE a.avortement1erTrim = :avortement1erTrim")
    ,
    @NamedQuery(name = "AntecedentCpn.findByPrimipare15ansOuMoin", query = "SELECT a FROM AntecedentCpn a WHERE a.primipare15ansOuMoin = :primipare15ansOuMoin")
    ,
    @NamedQuery(name = "AntecedentCpn.findByPrimipare30ansOuPlus", query = "SELECT a FROM AntecedentCpn a WHERE a.primipare30ansOuPlus = :primipare30ansOuPlus")
    ,
    @NamedQuery(name = "AntecedentCpn.findByDernieraccouchementdatede", query = "SELECT a FROM AntecedentCpn a WHERE a.dernieraccouchementdatede = :dernieraccouchementdatede")
    ,
    @NamedQuery(name = "AntecedentCpn.findByType", query = "SELECT a FROM AntecedentCpn a WHERE a.type = :type")
    ,
    @NamedQuery(name = "AntecedentCpn.findByIntInf2ans", query = "SELECT a FROM AntecedentCpn a WHERE a.intInf2ans = :intInf2ans")
    ,
    @NamedQuery(name = "AntecedentCpn.findByPlusgrospoidsnaiss", query = "SELECT a FROM AntecedentCpn a WHERE a.plusgrospoidsnaiss = :plusgrospoidsnaiss")
    ,
    @NamedQuery(name = "AntecedentCpn.findByPlusde4kg", query = "SELECT a FROM AntecedentCpn a WHERE a.plusde4kg = :plusde4kg")
    ,
    @NamedQuery(name = "AntecedentCpn.findByDernierEnfant", query = "SELECT a FROM AntecedentCpn a WHERE a.dernierEnfant = :dernierEnfant")
    ,
    @NamedQuery(name = "AntecedentCpn.findByComplicationtraitement", query = "SELECT a FROM AntecedentCpn a WHERE a.complicationtraitement = :complicationtraitement")
    ,
    @NamedQuery(name = "AntecedentCpn.findByComplicationpostPartum", query = "SELECT a FROM AntecedentCpn a WHERE a.complicationpostPartum = :complicationpostPartum")
    ,
    @NamedQuery(name = "AntecedentCpn.findByTraitementpoursterilite", query = "SELECT a FROM AntecedentCpn a WHERE a.traitementpoursterilite = :traitementpoursterilite")
    ,
    @NamedQuery(name = "AntecedentCpn.findByParite", query = "SELECT a FROM AntecedentCpn a WHERE a.parite = :parite")
    ,
    @NamedQuery(name = "AntecedentCpn.findByAvortement", query = "SELECT a FROM AntecedentCpn a WHERE a.avortement = :avortement")
    ,
    @NamedQuery(name = "AntecedentCpn.findByDeces", query = "SELECT a FROM AntecedentCpn a WHERE a.deces = :deces")
    ,
    @NamedQuery(name = "AntecedentCpn.findByVbg", query = "SELECT a FROM AntecedentCpn a WHERE a.vbg = :vbg")
    ,
    @NamedQuery(name = "AntecedentCpn.findByAntecedentChirurgicauxCPN", query = "SELECT a FROM AntecedentCpn a WHERE a.antecedentChirurgicauxCPN = :antecedentChirurgicauxCPN")
    ,
    @NamedQuery(name = "AntecedentCpn.findByAntecedentMedicauxCPN", query = "SELECT a FROM AntecedentCpn a WHERE a.antecedentMedicauxCPN = :antecedentMedicauxCPN")
    ,
    @NamedQuery(name = "AntecedentCpn.findByGrossesseissuduviol", query = "SELECT a FROM AntecedentCpn a WHERE a.grossesseissuduviol = :grossesseissuduviol")})
public class AntecedentCpn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAntecObstr")
    private Integer idAntecObstr;
    @Column(name = "DDR")
    @Temporal(TemporalType.DATE)
    private Date ddr;
    @Column(name = "DPA")
    @Temporal(TemporalType.DATE)
    private Date dpa;
    @Column(name = "Grossesse")
    private Integer grossesse;
    @Column(name = "Enfants_vie")
    private Integer enfantsvie;
    @Size(max = 4)
    @Column(name = "Avortement_1er_Trim")
    private String avortement1erTrim;
    @Size(max = 4)
    @Column(name = "primipare_15ans_ou_moin")
    private String primipare15ansOuMoin;
    @Size(max = 4)
    @Column(name = "primipare_30ans_ou_plus")
    private String primipare30ansOuPlus;
    @Column(name = "Dernier_accouchement_date_de")
    @Temporal(TemporalType.DATE)
    private Date dernieraccouchementdatede;
    @Size(max = 9)
    @Column(name = "type")
    private String type;
    @Size(max = 4)
    @Column(name = "int_inf_2ans")
    private String intInf2ans;
    @Size(max = 4)
    @Column(name = "Plus_gros_poids_naiss")
    private String plusgrospoidsnaiss;
    @Size(max = 4)
    @Column(name = "Plus_de_4kg")
    private String plusde4kg;
    @Size(max = 18)
    @Column(name = "Dernier_Enfant")
    private String dernierEnfant;
    @Size(max = 50)
    @Column(name = "Complication_traitement")
    private String complicationtraitement;
    @Size(max = 40)
    @Column(name = "Complication_postPartum")
    private String complicationpostPartum;
    @Size(max = 4)
    @Column(name = "Traitement_pour_sterilite")
    private String traitementpoursterilite;
    @Column(name = "parite")
    private Integer parite;
    @Column(name = "Avortement")
    private Integer avortement;
    @Column(name = "Deces")
    private Integer deces;
    @Size(max = 4)
    @Column(name = "VBG")
    private String vbg;
    @Size(max = 55)
    @Column(name = "AntecedentChirurgicauxCPN")
    private String antecedentChirurgicauxCPN;
    @Size(max = 61)
    @Column(name = "AntecedentMedicauxCPN")
    private String antecedentMedicauxCPN;
    @Size(max = 4)
    @Column(name = "Grossesse_issu_du_viol")
    private String grossesseissuduviol;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne
    private InfosFemme numDossier;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;

    public AntecedentCpn() {
    }

    public AntecedentCpn(Integer idAntecObstr) {
        this.idAntecObstr = idAntecObstr;
    }

    public Integer getIdAntecObstr() {
        return idAntecObstr;
    }

    public void setIdAntecObstr(Integer idAntecObstr) {
        this.idAntecObstr = idAntecObstr;
    }

    public Date getDdr() {
        return ddr;
    }

    public void setDdr(Date ddr) {
        this.ddr = ddr;
    }

    public Date getDpa() {
        return dpa;
    }

    public void setDpa(Date dpa) {
        this.dpa = dpa;
    }

    public Integer getGrossesse() {
        return grossesse;
    }

    public void setGrossesse(Integer grossesse) {
        this.grossesse = grossesse;
    }

    public Integer getEnfantsvie() {
        return enfantsvie;
    }

    public void setEnfantsvie(Integer enfantsvie) {
        this.enfantsvie = enfantsvie;
    }

    public String getAvortement1erTrim() {
        return avortement1erTrim;
    }

    public void setAvortement1erTrim(String avortement1erTrim) {
        if (avortement1erTrim.length() == 0) {
            avortement1erTrim = null;
        }
        this.avortement1erTrim = avortement1erTrim;
    }

    public String getPrimipare15ansOuMoin() {
        return primipare15ansOuMoin;
    }

    public void setPrimipare15ansOuMoin(String primipare15ansOuMoin) {
        if (primipare15ansOuMoin.length() == 0) {
            primipare15ansOuMoin = null;
        }
        this.primipare15ansOuMoin = primipare15ansOuMoin;
    }

    public String getPrimipare30ansOuPlus() {
        return primipare30ansOuPlus;
    }

    public void setPrimipare30ansOuPlus(String primipare30ansOuPlus) {
        if (primipare30ansOuPlus.length() == 0) {
            primipare30ansOuPlus = null;
        }
        this.primipare30ansOuPlus = primipare30ansOuPlus;
    }

    public Date getDernieraccouchementdatede() {
        return dernieraccouchementdatede;
    }

    public void setDernieraccouchementdatede(Date dernieraccouchementdatede) {
        this.dernieraccouchementdatede = dernieraccouchementdatede;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.length() == 0) {
            type = null;
        }
        this.type = type;
    }

    public String getIntInf2ans() {
        return intInf2ans;
    }

    public void setIntInf2ans(String intInf2ans) {
        if (intInf2ans.length() == 0) {
            intInf2ans = null;
        }
        this.intInf2ans = intInf2ans;
    }

    public String getPlusgrospoidsnaiss() {
        return plusgrospoidsnaiss;
    }

    public void setPlusgrospoidsnaiss(String plusgrospoidsnaiss) {
        if (plusgrospoidsnaiss.length() == 0) {
            plusgrospoidsnaiss = null;
        }
        this.plusgrospoidsnaiss = plusgrospoidsnaiss;
    }

    public String getPlusde4kg() {
        return plusde4kg;
    }

    public void setPlusde4kg(String plusde4kg) {
        if (plusde4kg.length() == 0) {
            plusde4kg = null;
        }
        this.plusde4kg = plusde4kg;
    }

    public String getDernierEnfant() {
        return dernierEnfant;
    }

    public void setDernierEnfant(String dernierEnfant) {
        if (dernierEnfant.length() == 0) {
            dernierEnfant = null;
        }
        this.dernierEnfant = dernierEnfant;
    }

    public String getComplicationtraitement() {
        return complicationtraitement;
    }

    public void setComplicationtraitement(String complicationtraitement) {
        if (complicationtraitement.length() == 0) {
            complicationtraitement = null;
        }
        this.complicationtraitement = complicationtraitement;
    }

    public String getComplicationpostPartum() {
        return complicationpostPartum;
    }

    public void setComplicationpostPartum(String complicationpostPartum) {
        if (complicationpostPartum.length() == 0) {
            complicationpostPartum = null;
        }
        this.complicationpostPartum = complicationpostPartum;
    }

    public String getTraitementpoursterilite() {
        return traitementpoursterilite;
    }

    public void setTraitementpoursterilite(String traitementpoursterilite) {
        if (traitementpoursterilite.length() == 0) {
            traitementpoursterilite = null;
        }
        this.traitementpoursterilite = traitementpoursterilite;
    }

    public Integer getParite() {
        return parite;
    }

    public void setParite(Integer parite) {
        this.parite = parite;
    }

    public Integer getAvortement() {
        return avortement;
    }

    public void setAvortement(Integer avortement) {
        this.avortement = avortement;
    }

    public Integer getDeces() {
        return deces;
    }

    public void setDeces(Integer deces) {
        this.deces = deces;
    }

    public String getVbg() {
        return vbg;
    }

    public void setVbg(String vbg) {
        if (vbg.length() == 0) {
            vbg = null;
        }
        this.vbg = vbg;
    }

    public String getAntecedentChirurgicauxCPN() {
        return antecedentChirurgicauxCPN;
    }

    public void setAntecedentChirurgicauxCPN(String antecedentChirurgicauxCPN) {
        if (antecedentChirurgicauxCPN.length() == 0) {
            antecedentChirurgicauxCPN = null;
        }
        this.antecedentChirurgicauxCPN = antecedentChirurgicauxCPN;
    }

    public String getAntecedentMedicauxCPN() {
        return antecedentMedicauxCPN;
    }

    public void setAntecedentMedicauxCPN(String antecedentMedicauxCPN) {
        if (antecedentMedicauxCPN.length() == 0) {
            antecedentMedicauxCPN = null;
        }
        this.antecedentMedicauxCPN = antecedentMedicauxCPN;
    }

    public String getGrossesseissuduviol() {
        return grossesseissuduviol;
    }

    public void setGrossesseissuduviol(String grossesseissuduviol) {
        if (grossesseissuduviol.length() == 0) {
            grossesseissuduviol = null;
        }
        this.grossesseissuduviol = grossesseissuduviol;
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
        hash += (idAntecObstr != null ? idAntecObstr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentCpn)) {
            return false;
        }
        AntecedentCpn other = (AntecedentCpn) object;
        if ((this.idAntecObstr == null && other.idAntecObstr != null) || (this.idAntecObstr != null && !this.idAntecObstr.equals(other.idAntecObstr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.AntecedentCpn[ idAntecObstr=" + idAntecObstr + " ]";
    }

}
