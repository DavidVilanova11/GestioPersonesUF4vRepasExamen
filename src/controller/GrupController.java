package controller;

import model.Grup;
import model.Persona;
import controller.PersonaController;

public class GrupController {

    private Grup[] grups;
    
    public GrupController() {

    }

    public Grup[] getGrups() {
        return grups;
    }

    public void setGrups(Grup[] grups) {
        this.grups = grups;
    }

    public void afegirGrup(Grup grup) {
        grup.setId(grups[grups.length -1].getId() + 1); //creem un npu id per el Grup

        Grup[] aux = new Grup[grups.length + 1]; //creem un array amb una posició extra

        for (int i = 0; i < grups.length; i++) { //copiem els valors en el nou array
            aux[i] = grups[i];
        }

        aux[aux.length - 1] = grup; // afegim el nou grup en la última posició del array

        grups = aux; // igualem l'array auxiliar a grups
    }

    public void llistar() {
        System.out.printf("%4s %10s\n", "Id", "Nom");
        for (Grup grup : grups) {
            System.out.printf("%4s %10s\n", grup.getId(), grup.getNom());
        }

    }

    public void eliminarGrup(int id) {

        // primer eliminem les persones que pertanyin al grup
        PersonaController pc = new PersonaController();
        pc.eliminarPersonesPerIdGrup(id);

        // ara sí eliminem el grup
        Grup[] aux = new Grup[grups.length -1];

        for (int i = 0, j = 0; i < grups.length; i++) {
            if (grups[i].getId() !=id) {
                aux[j] = grups[i];
                j++;
            }
        }

        grups = aux;
        
    }

    public boolean isValidId(int id) {
        for (Grup g : grups) {
            if (g.getId() == id) {
                return true;
            }
        }
    
        return false;
    }


    public String getGroupNameById(int id) {
        for (Grup g : grups) {
            if (g.getId() == id) {
                return g.getNom();
            }
        }
        return null;
    }

    public boolean checkExistGroup (String groupName) {
        for (Grup g : grups) {
            if (g.getNom().equalsIgnoreCase(groupName)) {
                return true;
            }
        }

        return false;
    }

    public Grup getGrupById (int idGrup) {
        for (Grup g : grups) {
            if (g.getId() == idGrup) {
                return g;
            }
        }
        return null;
    }

    public int getNewIdPersona() {
        int max = 0;

        for(Grup g : grups) {
            Persona[] persones = g.getPc().getPersones();
            for (Persona p : persones) {
                if(p.getId() > max) {
                    max = p.getId();
                }
            }
        }
        
        return max+1;
    }


    
}
