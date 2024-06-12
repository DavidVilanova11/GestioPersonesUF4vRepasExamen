package model;

public class Persona {
    
    private int id;
    private String nom;
    private String cognom;
    private int edat;
    private String telefon;
    private int idGrup;

    public Persona() {

    }

    public Persona(String nom, String cognom, int edat, String telefon, int idGrup) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.telefon = telefon;
        this.idGrup =idGrup;
    }

    public Persona(int id, String nom, String cognom, int edat, String telefon, int idGrup) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.telefon = telefon;
        this.idGrup =idGrup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getIdGrup() {
        return idGrup;
    }

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nom=" + nom + ", cognom=" + cognom + ", edat=" + edat + ", telefon=" + telefon + ", grup=" + idGrup+ '}';
    }


}
