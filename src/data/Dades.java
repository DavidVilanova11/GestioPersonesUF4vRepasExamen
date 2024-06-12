package data;

import model.Grup;
import model.Persona;

public class Dades {

    private static Grup[] grups = {new Grup (0, "zero"), new Grup(1, "primer"), new Grup(2, "segon")};
    
    private static Persona[] persones = {
        new Persona(1, "Nom1", "Cognom1", 10, "telèfon1", 0),
        new Persona(2, "Nom2", "Cognom2", 10, "telèfon2", 0),
        new Persona(3, "Nom3", "Cognom3", 10, "telèfon3", 1),
        new Persona(4, "Nom4", "Cognom4", 10, "telèfon4", 1),
        new Persona(5, "Nom5", "Cognom5", 10, "telèfon5", 2),
        new Persona(6, "Nom6", "Cognom6", 10, "telèfon6", 2)
    };

    public static Persona[] getPersones() {
        return persones;
    }

    public static void setPersones(Persona[] persones) {
        Dades.persones = persones;
    }

    public static Grup[] getGrups() {
        return grups;
    }

    public static void setGrups(Grup[] grups) {
        Dades.grups = grups;
    }

    public static Grup[] assignarPersonesAGrups() {
        for (Persona p : persones) {
            for (Grup g : grups) {
                if (p.getIdGrup() == g.getId()) {
                    g.afegirPersona(p);
                }
            }
        }
        return grups;
    }
    




}
