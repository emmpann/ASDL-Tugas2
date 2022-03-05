import java.util.Scanner;

public class ScannerUtil {

    private static Scanner scanner = new Scanner(System.in);
    
    public static String stringScn(String message){
        System.out.print(message + ": " );
        return scanner.next();
    }

    public static int integerScn(String message){
        System.out.print(message + ": ");
        return scanner.nextInt();
    }
}
