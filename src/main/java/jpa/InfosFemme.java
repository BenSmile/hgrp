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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "infos_femme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfosFemme.findAll", query = "SELECT i FROM InfosFemme i"),
    @NamedQuery(name = "InfosFemme.findByNumDossier", query = "SELECT i FROM InfosFemme i WHERE i.numDossier = :numDossier"),
    @NamedQuery(name = "InfosFemme.findByNom", query = "SELECT i FROM InfosFemme i WHERE i.nom = :nom"),
    @NamedQuery(name = "InfosFemme.findByPostNom", query = "SELECT i FROM InfosFemme i WHERE i.postNom = :postNom"),
    @NamedQuery(name = "InfosFemme.findByPrenom", query = "SELECT i FROM InfosFemme i WHERE i.prenom = :prenom"),
    @NamedQuery(name = "InfosFemme.findByProfession", query = "SELECT i FROM InfosFemme i WHERE i.profession = :profession"),
    @NamedQuery(name = "InfosFemme.findByProfessioConjoint", query = "SELECT i FROM InfosFemme i WHERE i.professioConjoint = :professioConjoint"),
    @NamedQuery(name = "InfosFemme.findByZoneSante", query = "SELECT i FROM InfosFemme i WHERE i.zoneSante = :zoneSante"),
    @NamedQuery(name = "InfosFemme.findByAireSante", query = "SELECT i FROM InfosFemme i WHERE i.aireSante = :aireSante"),
    @NamedQuery(name = "InfosFemme.findByProvince", query = "SELECT i FROM InfosFemme i WHERE i.province = :province"),
    @NamedQuery(name = "InfosFemme.findByDistrict", query = "SELECT i FROM InfosFemme i WHERE i.district = :district"),
    @NamedQuery(name = "InfosFemme.findByAdresseCPN", query = "SELECT i FROM InfosFemme i WHERE i.adresseCPN = :adresseCPN"),
    @NamedQuery(name = "InfosFemme.findByTelephone", query = "SELECT i FROM InfosFemme i WHERE i.telephone = :telephone"),
    @NamedQuery(name = "InfosFemme.findByAge", query = "SELECT i FROM InfosFemme i WHERE i.age = :age"),
    @NamedQuery(name = "InfosFemme.findByProvenance", query = "SELECT i FROM InfosFemme i WHERE i.provenance = :provenance"),
    @NamedQuery(name = "InfosFemme.findByEtatCivil", query = "SELECT i FROM InfosFemme i WHERE i.etatCivil = :etatCivil"),
    @NamedQuery(name = "InfosFemme.findByNiveauEtude", query = "SELECT i FROM InfosFemme i WHERE i.niveauEtude = :niveauEtude")})
public class InfosFemme implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Genre")
    private String genre;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NumDossier")
    private String numDossier;
    @Size(max = 30)
    @Column(name = "nom")
    private String nom;
    @Size(max = 30)
    @Column(name = "Post_Nom")
    private String postNom;
    @Size(max = 30)
    @Column(name = "Prenom")
    private String prenom;
    @Size(max = 30)
    @Column(name = "Profession")
    private String profession;
    @Size(max = 30)
    @Column(name = "Professio_Conjoint")
    private String professioConjoint;
    @Size(max = 30)
    @Column(name = "Zone_Sante")
    private String zoneSante;
    @Size(max = 30)
    @Column(name = "Aire_Sante")
    private String aireSante;
    @Size(max = 30)
    @Column(name = "Province")
    private String province;
    @Size(max = 30)
    @Column(name = "District")
    private String district;
    @Size(max = 30)
    @Column(name = "AdresseCPN")
    private String adresseCPN;
    @Size(max = 50)
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "age")
    private Integer age;
    @Size(max = 3)
    @Column(name = "Provenance")
    private String provenance;
    @Size(max = 11)
    @Column(name = "Etat_Civil")
    private String etatCivil;
    @Size(max = 10)
    @Column(name = "Niveau_Etude")
    private String niveauEtude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDossier")
    private Collection<PlanficationFamiliale> planficationFamilialeCollection;
    @OneToMany(mappedBy = "numDossier")
    private Collection<DonneesObjectives> donneesObjectivesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDossier")
    private Collection<Grossesse> grossesseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDossier")
    private Collection<InfosAccouchement> infosAccouchementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDossier")
    private Collection<Dcip> dcipCollection;
    @OneToMany(mappedBy = "numDossier")
    private Collection<AntecedentCpn> antecedentCpnCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDossier")
    private Collection<Hospitalisation> hospitalisationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDossier")
    private Collection<Regles> reglesCollection;
    @OneToMany(mappedBy = "numDossier")
    private Collection<AutresProblemes> autresProblemesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDossier")
    private Collection<ExamenLabo> examenLaboCollection;
    @JoinColumn(name = "utilisateur", referencedColumnName = "uname")
    @ManyToOne(optional = false)
    private Users utilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDossier")
    private Collection<AntecedentPl> antecedentPlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDossier")
    private Collection<Consultation> consultationCollection;

    public InfosFemme() {
    }

    public InfosFemme(String numDossier) {
        this.numDossier = numDossier;
    }

    public String getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(String numDossier) {
        this.numDossier = numDossier;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfessioConjoint() {
        return professioConjoint;
    }

    public void setProfessioConjoint(String professioConjoint) {
        this.professioConjoint = professioConjoint;
    }

    public String getZoneSante() {
        return zoneSante;
    }

    public void setZoneSante(String zoneSante) {
        this.zoneSante = zoneSante;
    }

    public String getAireSante() {
        return aireSante;
    }

    public void setAireSante(String aireSante) {
        this.aireSante = aireSante;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdresseCPN() {
        return adresseCPN;
    }

    public void setAdresseCPN(String adresseCPN) {
        this.adresseCPN = adresseCPN;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    @XmlTransient
    public Collection<PlanficationFamiliale> getPlanficationFamilialeCollection() {
        return planficationFamilialeCollection;
    }

    public void setPlanficationFamilialeCollection(Collection<PlanficationFamiliale> planficationFamilialeCollection) {
        this.planficationFamilialeCollection = planficationFamilialeCollection;
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

    public Users getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Users utilisateur) {
        this.utilisateur = utilisateur;
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
        hash += (numDossier != null ? numDossier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfosFemme)) {
            return false;
        }
        InfosFemme other = (InfosFemme) object;
        if ((this.numDossier == null && other.numDossier != null) || (this.numDossier != null && !this.numDossier.equals(other.numDossier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.numDossier+" : "+this.nom+" "+this.prenom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}
