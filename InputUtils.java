import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int reqInt(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }

    public static float reqFloat(String msg) {
        System.out.print(msg);
        return scanner.nextFloat();
    }

    public static String reqString(String msg) {
        System.out.print(msg);
        String cadena = scanner.nextLine();

        if (cadena.length() == 0) {
            cadena = scanner.nextLine();
        }

        return cadena.trim();
    }

}