package controller;

import model.Persona;

public class PersonaController {
    
    private Persona[] persones;

    public PersonaController() {
        persones = new Persona[0];
    }

    public Persona[] getPersones() {
        return persones;
    }

    public void setPersones(Persona[] persones) {
        this.persones = persones;
    }

    public boolean checkExistPersona(Persona persona) {

        //comprovem que hi ha persones a la llista
        if (persones != null && persones.length > 0) {
            //recorrem totes les persones comprovant totes les dades i retornem true si la trobem
            for (Persona p :persones) {
                if (p.equals(persona)) {
                    return true;
                }
            }
        }

        //en cas de npo trobar la persona retornarem false
        return false;
    }

    public void afegirPersona(Persona persona) {

        Persona[] aux = new Persona[persones.length + 1];

        for (int i = 0; i < persones.length; i++) {
            aux[i] = persones[i];
        }

        aux[aux.length - 1] = persona;
        persones = aux;

    }

    public void eliminarPersona(int id) {

        Persona[] aux = new Persona[persones.length - 1];

        for (int i = 0, j = 0; i < persones.length; i++) {
            if (persones[i].getId() != id) {
                aux[j] = persones[i];
                j++;
            }
        }

        persones = aux;

    }

    public void eliminarPersonesPerIdGrup(int idGrup) {
        // Comptar quantes persones pertanyen al grup a eliminar
        int count = 0;
        for (Persona persona : persones) {
            if (persona != null && persona.getIdGrup() == idGrup) {
                count++;
            }
        }
    
        // Crear un nou array amb la mida adequada
        Persona[] aux = new Persona[persones.length - count];
    
        // Copiar les persones que no pertanyen al grup a eliminar
        for (int i = 0, j = 0; i < persones.length; i++) {
            if (persones[i] != null && persones[i].getIdGrup() != idGrup) {
                aux[j] = persones[i];
                j++;
            }
        }
    
        // Actualitzar l'array de persones
        persones = aux;
    }

    public boolean isValidId(int id) {
        for (Persona p : persones) {
            if (p.getId() == id) {
                return true;
            }
        }
    
        return false;
    }

    public Persona getPersonaById(int id) {

        for (Persona persona : persones) {
            if (persona.getId() == id) {
                return persona;
            }
        }
        return null;
    }

    public Persona[] setPersona(Persona persona) {
        afegirPersona(persona);
        return persones;
    }

    
    
}
