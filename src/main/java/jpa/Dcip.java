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
@Table(name = "dcip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dcip.findAll", query = "SELECT d FROM Dcip d")
    ,
    @NamedQuery(name = "Dcip.findByIdDCIP", query = "SELECT d FROM Dcip d WHERE d.idDCIP = :idDCIP")
    ,
    @NamedQuery(name = "Dcip.findByCounselingpretest", query = "SELECT d FROM Dcip d WHERE d.counselingpretest = :counselingpretest")
    ,
    @NamedQuery(name = "Dcip.findByCode", query = "SELECT d FROM Dcip d WHERE d.code = :code")
    ,
    @NamedQuery(name = "Dcip.findByTestVIH", query = "SELECT d FROM Dcip d WHERE d.testVIH = :testVIH")
    ,
    @NamedQuery(name = "Dcip.findByResultat", query = "SELECT d FROM Dcip d WHERE d.resultat = :resultat")
    ,
    @NamedQuery(name = "Dcip.findByCounselingposttest", query = "SELECT d FROM Dcip d WHERE d.counselingposttest = :counselingposttest")
    ,
    @NamedQuery(name = "Dcip.findByInformerResultatposttest", query = "SELECT d FROM Dcip d WHERE d.informerResultatposttest = :informerResultatposttest")})
public class Dcip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDCIP")
    private Integer idDCIP;
    @Size(max = 4)
    @Column(name = "Counseling_pre_test")
    private String counselingpretest;
    @Size(max = 10)
    @Column(name = "Code")
    private String code;
    @Size(max = 4)
    @Column(name = "Test_VIH")
    private String testVIH;
    @Size(max = 11)
    @Column(name = "Resultat")
    private String resultat;
    @Size(max = 4)
    @Column(name = "Counseling_post_test")
    private String counselingposttest;
    @Size(max = 4)
    @Column(name = "Informer_Resultat_post_test")
    private String informerResultatposttest;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;
    @JoinColumn(name = "NumDossier", referencedColumnName = "NumDossier")
    @ManyToOne(optional = false)
    private InfosFemme numDossier;

    public Dcip() {
    }

    public Dcip(Integer idDCIP) {
        this.idDCIP = idDCIP;
    }

    public Integer getIdDCIP() {
        return idDCIP;
    }

    public void setIdDCIP(Integer idDCIP) {
        this.idDCIP = idDCIP;
    }

    public String getCounselingpretest() {
        return counselingpretest;
    }

    public void setCounselingpretest(String counselingpretest) {
        if (counselingpretest.length() == 0) {
            counselingpretest = null;
        }
        this.counselingpretest = counselingpretest;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTestVIH() {

        return testVIH;
    }

    public void setTestVIH(String testVIH) {
        if (testVIH.length() == 0) {
            testVIH = null;
        }
        this.testVIH = testVIH;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        if (resultat.length() == 0) {
            resultat = null;
        }
        this.resultat = resultat;
    }

    public String getCounselingposttest() {
        return counselingposttest;
    }

    public void setCounselingposttest(String counselingposttest) {
        if (counselingposttest.length() == 0) {
            counselingposttest = null;
        }
        this.counselingposttest = counselingposttest;
    }

    public String getInformerResultatposttest() {
        return informerResultatposttest;
    }

    public void setInformerResultatposttest(String informerResultatposttest) {
        if (informerResultatposttest.length() == 0) {
            informerResultatposttest = null;
        }
        this.informerResultatposttest = informerResultatposttest;
    }

    public Users getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Users utilisateur) {
        this.utilisateur = utilisateur;
    }

    public InfosFemme getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(InfosFemme numDossier) {
        this.numDossier = numDossier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDCIP != null ? idDCIP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dcip)) {
            return false;
        }
        Dcip other = (Dcip) object;
        if ((this.idDCIP == null && other.idDCIP != null) || (this.idDCIP != null && !this.idDCIP.equals(other.idDCIP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Dcip[ idDCIP=" + idDCIP + " ]";
    }

}
