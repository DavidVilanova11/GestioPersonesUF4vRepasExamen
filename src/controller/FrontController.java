package controller;

import data.Dades;
import util.Utils;
import view.GrupVista;
import view.PersonaVista;

public class FrontController {
    
    private GrupController gc;
    private GrupVista gv;
    private PersonaVista pv;

    public FrontController() {

        gc = new GrupController();
        gc.setGrups(Dades.assignarPersonesAGrups());

        int opcio;
        do {
            System.out.println("\nSelecciona una opció: ");
            System.out.println("1.Gestionar Persones");
            System.out.println("2.Gestionar Grups");
            System.out.println("0.Sortir");
            opcio = Utils.getValidInt("Opció: ");
            switch (opcio) {
                case 1://Gestionar Persones
                    pv = new PersonaVista(gc);
                    break;
                case 2://Gestionar Grups
                    gv = new GrupVista(gc);
                    break;
                case 0:
                    System.out.println("Adéu!");
                    break;
                default:
                System.out.println("Opció incorrecta!");
            }
            
        } while (opcio != 0);

    }

}
