package view;

import util.Utils;
import model.Grup;
import controller.GrupController;

public class GrupVista {
    private GrupController gc;

    public GrupVista(GrupController gc) {
        this.gc = gc;

        int opcio;

        do {
            System.out.println("\nSelecciona una opció:");
            System.out.println("1.Afegir grup");
            System.out.println("2.Llistar grups");
            System.out.println("3.Modificar grup");
            System.out.println("4.Eliminar grup");
            System.out.println("0.Tornar al menú principal");
            opcio = Utils.getValidInt("Opció: ");
            switch (opcio) {
                case 1:// Afegir grup
                    afegir();
                    break;
                case 2:// Llistar grups
                    llistar();
                    break;
                case 3:// Modificar grup
                    modificar();
                default:
                case 4:// Eliminar grup
                    eliminar();
                    break;
            }

        } while (opcio != 0);
    }

    private void afegir() {
        String nomGrup = Utils.getString("Donam el nom: ");
        // si no existeix el grup el creem i l'afegim
        if (!gc.checkExistGroup(nomGrup)) {
            Grup grup = new Grup(nomGrup);
            gc.afegirGrup(grup);
        } else {
            // mostrem missatge en cas que el grup ja existeixi
            System.out.println("Ja existeix un grup amb aquest nom!");
        }
    }

    private void llistar(){
        Grup[] grups = gc.getGrups();

        System.out.printf("%4s %10s\n", "Id", "Nom");
        for (Grup grup : grups) {
            System.out.printf("%4s %10s\n", grup.getId(), grup.getNom());
        }
    }

    private void modificar() {

        //llistem els grups i seleccionem el grup a modificar
        gc.llistar();
        int idGrup = Utils.getValidInt("Selecciona l'id de grup a modificar: ");
        Grup grup = gc.getGrupById(idGrup);

        //Demanem les dades de la p i les assignem directament a la posició que ocupa
        //aquella p a l'array
        grup.setNom(Utils.getString("Donam el nom: "));
    }

    private void eliminar() {
        //llistem els grups i seleccionem el grup a eliminar
        gc.llistar();
        int idGrup = Utils.getValidInt("Introdueix l'id grup a eliminar: ");
        if (gc.isValidId(idGrup)) {
            gc.eliminarGrup(idGrup);
        } else {
            System.out.println("L'id introduït no s'ha trobat!");
        }
    }
}
