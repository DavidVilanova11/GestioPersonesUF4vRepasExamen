
package util;

import java.util.Scanner;

public class Utils {

    public static int getValidInt(String missatge) {
        Scanner lector = new Scanner(System.in);
        int num;
        System.out.print(missatge);
        while (!lector.hasNextInt()) {
            System.out.println(missatge); 
            lector.nextLine();           
        }
        num = lector.nextInt();
        lector.nextLine();
        return num;
    }

    public static String getString(String missatge) {
        Scanner lector = new Scanner(System.in);
        System.out.print(missatge);
        return lector.nextLine();
    }
}