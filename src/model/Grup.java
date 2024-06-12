package model;

import controller.PersonaController;

public class Grup {
    
    int id;
    String nom;

    PersonaController pc;

    public Grup(String nom) {
        this.nom = nom;
        pc = new PersonaController();
    }

    public Grup(int id, String nom) {
        this.id = id;
        this.nom = nom;
        pc = new PersonaController();
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

    public PersonaController getPc() {
        return pc;
    }

    public void setPc(PersonaController pc) {
        this.pc = pc;
    }


    public void afegirPersona(Persona p) {
        pc.afegirPersona(p);
    }

    public void eliminarPersona(Persona p) {
        pc.eliminarPersona(p.getId());
    }


}
