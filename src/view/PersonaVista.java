package view;

import controller.PersonaController;
import util.Utils;
import controller.GrupController;
import model.Grup;
import model.Persona;

public class PersonaVista {

    private PersonaController pc;
    private GrupController gc;

    public PersonaVista(GrupController gc) {
        this.gc = gc;

        int opcio;

        do {
            System.out.println("\nSelecciona una opció: ");
            System.out.println("1.Afegir persona");
            System.out.println("2.Llistar persones");
            System.out.println("3.Llistar una persona");
            System.out.println("4.Modificar persona");
            System.out.println("5.Eliminar persona");
            System.out.println("0.Tronar al menú principal");
            opcio = Utils.getValidInt("Opció:");
            
            switch (opcio) {
                case 1:// Afegir persona
                    afegir();
                    break;
                case 2: //Llistar persones
                    llistar();
                    break;
                case 3:// Llistar una persona
                    llistarUnaPersona();
                    break;
                case 4:
                    modificar();
                    break;
                case 5:// Eliminar persona
                    eliminar();
                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció incorrecta...");
                    break;
            }
            
        } while (opcio !=0);
    }

    private void afegir() {
        // Demanem les dades de la nova persona
        String nom = Utils.getString("Donam el nom: ");
        String cognom = Utils.getString("Donam el cognom: ");
        int edat = Utils.getValidInt("Dona'mm l'edat: ");
        String telefon = String.valueOf(Utils.getValidInt("Donam el telèfon: "));

        // Llistem els grups
        gc.llistar();
        int idGrup = Utils.getValidInt("selecciona un grup: ");
        Grup grup = gc.getGrupById(idGrup);
        pc = grup.getPc();

        // creem una nova persona
        Persona persona = new Persona(nom, cognom, edat, telefon, idGrup);

        if (!pc.checkExistPersona(persona)) {
            persona.setId(gc.getNewIdPersona());
            grup.afegirPersona(persona);
        } else {
            // mostrem missatge si ja existeix
            System.out.println("Ja existeix una persona amb aquestes dades!");
        }
    }

    private void llistar() {
        // llistem els grups i seleccionem el grup a llistar
        gc.llistar();
        int idGrup = Utils.getValidInt("Selecciona un grup: ");
        Grup grup = gc.getGrupById(idGrup);
        pc = grup.getPc();

        // llistem les persones del grup
        Persona[] persones = pc.getPersones();
        if (persones == null || persones.length == 0) {
            System.out.println("No hi ha persones a la bd...");
        } else {
            for (Persona p : persones) {
                System.out.println(p.toString());
            }
        }
    }

    private void llistarUnaPersona() {
        // llistem els grups i seleccionem el grup a llistar
        gc.llistar();
        int idGrup = Utils.getValidInt("Selecciona un grup: ");
        Grup grup = gc.getGrupById(idGrup);
        pc = grup.getPc();

        //recuperem les persones del grup
        Persona[] persones = grup.getPc().getPersones();

        if (persones ==  null || persones.length == 0) {
            System.out.println("No hi ha persones a la bd...");
        } else {
            for (Persona persona : persones) {
                System.out.println("Id: " + persona.getId() + " Nom: " + persona.getNom() + " " + persona.getCognom());
            }

            int id = Utils.getValidInt(("Selecciona el id de la persona a llistar: "));
            if (pc.isValidId(id)) {
                System.out.printf("%4s %10s %15s %4s %10s\n", "Id", "Nom", "Cognom", "Edat", "Telèfon", "Grup");
                Persona persona = pc.getPersonaById(id);
                System.out.printf("%4s %10s %15s %4s %10s\n", 
                        persona.getId(),
                        persona.getNom(),
                        persona.getCognom(),
                        persona.getEdat(),
                        persona.getTelefon(),
                        persona.getIdGrup());
            } else {
                System.out.println("No s'ha trobat cap persona amb aquest id!");
            }
        }

    }

    private void modificar() {

        //llistem els grups i seleccionem el grup a llistar
        gc.llistar();
        int idGrup = Utils.getValidInt("Selecciona un grup: ");
        Grup grup = gc.getGrupById(idGrup);
        pc = grup.getPc();

        //recuperem les persones del grup
        Persona[] persones = grup.getPc().getPersones();

        if (persones == null || persones.length == 0) {
            System.out.println("No hi ha persones a la bd");                        
        } else {
            for (Persona persona : persones) {
                System.out.println("Id: " + persona.getId() + " Nom: " + persona.getNom() + " " + persona.getCognom());
            }

            int id = Utils.getValidInt(("Selecciona el id de la persona a modificar: "));
            if (pc.isValidId(id)) {
                System.out.printf("%4s %10s %15s %4s %10s\n", "Id", "Nom", "Cognom", "Edat", "Telèfon", "Grup");
                Persona persona = pc.getPersonaById(id);
                System.out.printf("%4s %10s %15s %4s %10s\n", 
                        persona.getId(),
                        persona.getNom(),
                        persona.getCognom(),
                        persona.getEdat(),
                        persona.getTelefon(),
                        persona.getIdGrup());

            //Demanem les dades de la persona i la assignem
                persona.setNom(Utils.getString("Donam el nom: "));
                persona.setCognom(Utils.getString("Donam el cognom: "));
                persona.setEdat(Utils.getValidInt("Donam l'edat: "));
                persona.setTelefon(Utils.getString("Donam el Telèfon: "));

                //llistem els grups
                gc.llistar();
                idGrup = Utils.getValidInt("Selecciona un grup: ");

                //hem de comprovar si canvia de grup a la persona
                if (persona.getIdGrup() != idGrup) {
                    //alternativa per posar al nou grup
                    gc.getGrupById(idGrup).afegirPersona(persona);
                    persona.setIdGrup(idGrup);
                }

            } else {
                System.out.println("No s'ha trobat cap persona amb aquest id!");
            }
        }
    }

    private void eliminar() {
        //llistem els grups i seleccionem el grup a llistar
        gc.llistar();
        int idGrup = Utils.getValidInt("Selecciona un grup: ");
        Grup grup = gc.getGrupById(idGrup);
        pc = grup.getPc();

        //recuperem les persones del grup
        Persona[] persones = grup.getPc().getPersones();

        if (persones == null || persones.length == 0) {
            System.out.println("Ni ho ha persones a la bd");
        } else {
            for (Persona persona : persones) {
                System.out.println("Id: " + persona.getId() + " Nom: " + persona.getNom() + " " + persona.getCognom());
            }
            int id = Utils.getValidInt("Introdueix l'id de la persona a eliminar: ");
            if (pc.isValidId(id)) {
                pc.eliminarPersona(id);
            } else {
                System.out.println("L'id introduït no és correcte!");
            }
        }

    }

}
