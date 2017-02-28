/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dtp
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUname", query = "SELECT u FROM Users u WHERE u.uname = :uname"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByNom", query = "SELECT u FROM Users u WHERE u.nom = :nom"),
    @NamedQuery(name = "Users.findByPostNom", query = "SELECT u FROM Users u WHERE u.postNom = :postNom"),
    @NamedQuery(name = "Users.findByPrenom", query = "SELECT u FROM Users u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "Users.findByRole", query = "SELECT u FROM Users u WHERE u.role = :role")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "uname")
    private String uname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "post_nom")
    private String postNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<PlanficationFamiliale> planficationFamilialeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<MesuresPreventives> mesuresPreventivesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<DonneesObjectives> donneesObjectivesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Grossesse> grossesseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<InfosAccouchement> infosAccouchementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Dcip> dcipCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<AntecedentCpn> antecedentCpnCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Hospitalisation> hospitalisationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Regles> reglesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<AutresProblemes> autresProblemesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<ExamenLabo> examenLaboCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<InfosFemme> infosFemmeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<MotifConsultation> motifConsultationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<AntecedentPl> antecedentPlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Consultation> consultationCollection;

    public Users() {
    }

    public Users(String uname) {
        this.uname = uname;
    }

    public Users(String uname, String password, String nom, String postNom, String prenom, String role) {
        this.uname = uname;
        this.password = password;
        this.nom = nom;
        this.postNom = postNom;
        this.prenom = prenom;
        this.role = role;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostNom() {
        return postNom;
    }

    public void setPostNom(String postNom) {
        this.postNom = postNom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<PlanficationFamiliale> getPlanficationFamilialeCollection() {
        return planficationFamilialeCollection;
    }

    public void setPlanficationFamilialeCollection(Collection<PlanficationFamiliale> planficationFamilialeCollection) {
        this.planficationFamilialeCollection = planficationFamilialeCollection;
    }

    @XmlTransient
    public Collection<MesuresPreventives> getMesuresPreventivesCollection() {
        return mesuresPreventivesCollection;
    }

    public void setMesuresPreventivesCollection(Collection<MesuresPreventives> mesuresPreventivesCollection) {
        this.mesuresPreventivesCollection = mesuresPreventivesCollection;
    }

    @XmlTransient
    public Collection<DonneesObjectives> getDonneesObjectivesCollection() {
        return donneesObjectivesCollection;
    }

    public void setDonneesObjectivesCollection(Collection<DonneesObjectives> donneesObjectivesCollection) {
        this.donneesObjectivesCollection = donneesObjectivesCollection;
    }

    @XmlTransient
    public Collection<Grossesse> getGrossesseCollection() {
        return grossesseCollection;
    }

    public void setGrossesseCollection(Collection<Grossesse> grossesseCollection) {
        this.grossesseCollection = grossesseCollection;
    }

    @XmlTransient
    public Collection<InfosAccouchement> getInfosAccouchementCollection() {
        return infosAccouchementCollection;
    }

    public void setInfosAccouchementCollection(Collection<InfosAccouchement> infosAccouchementCollection) {
        this.infosAccouchementCollection = infosAccouchementCollection;
    }

    @XmlTransient
    public Collection<Dcip> getDcipCollection() {
        return dcipCollection;
    }

    public void setDcipCollection(Collection<Dcip> dcipCollection) {
        this.dcipCollection = dcipCollection;
    }

    @XmlTransient
    public Collection<AntecedentCpn> getAntecedentCpnCollection() {
        return antecedentCpnCollection;
    }

    public void setAntecedentCpnCollection(Collection<AntecedentCpn> antecedentCpnCollection) {
        this.antecedentCpnCollection = antecedentCpnCollection;
    }

    @XmlTransient
    public Collection<Hospitalisation> getHospitalisationCollection() {
        return hospitalisationCollection;
    }

    public void setHospitalisationCollection(Collection<Hospitalisation> hospitalisationCollection) {
        this.hospitalisationCollection = hospitalisationCollection;
    }

    @XmlTransient
    public Collection<Regles> getReglesCollection() {
        return reglesCollection;
    }

    public void setReglesCollection(Collection<Regles> reglesCollection) {
        this.reglesCollection = reglesCollection;
    }

    @XmlTransient
    public Collection<AutresProblemes> getAutresProblemesCollection() {
        return autresProblemesCollection;
    }

    public void setAutresProblemesCollection(Collection<AutresProblemes> autresProblemesCollection) {
        this.autresProblemesCollection = autresProblemesCollection;
    }

    @XmlTransient
    public Collection<ExamenLabo> getExamenLaboCollection() {
        return examenLaboCollection;
    }

    public void setExamenLaboCollection(Collection<ExamenLabo> examenLaboCollection) {
        this.examenLaboCollection = examenLaboCollection;
    }

    @XmlTransient
    public Collection<InfosFemme> getInfosFemmeCollection() {
        return infosFemmeCollection;
    }

    public void setInfosFemmeCollection(Collection<InfosFemme> infosFemmeCollection) {
        this.infosFemmeCollection = infosFemmeCollection;
    }

    @XmlTransient
    public Collection<MotifConsultation> getMotifConsultationCollection() {
        return motifConsultationCollection;
    }

    public void setMotifConsultationCollection(Collection<MotifConsultation> motifConsultationCollection) {
        this.motifConsultationCollection = motifConsultationCollection;
    }

    @XmlTransient
    public Collection<AntecedentPl> getAntecedentPlCollection() {
        return antecedentPlCollection;
    }

    public void setAntecedentPlCollection(Collection<AntecedentPl> antecedentPlCollection) {
        this.antecedentPlCollection = antecedentPlCollection;
    }

    @XmlTransient
    public Collection<Consultation> getConsultationCollection() {
        return consultationCollection;
    }

    public void setConsultationCollection(Collection<Consultation> consultationCollection) {
        this.consultationCollection = consultationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uname != null ? uname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uname == null && other.uname != null) || (this.uname != null && !this.uname.equals(other.uname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Users{" + "uname=" + uname + ", password=" + password + ", nom=" + nom + ", postNom=" + postNom + ", prenom=" + prenom + ", role=" + role + '}';
    }

    
    
    
}
