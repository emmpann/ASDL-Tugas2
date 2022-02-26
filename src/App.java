import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int option;

        System.out.println("*** DOUBLE LINKED LIST ***");
        System.out.println("    1. Manual");
        System.out.println("    2. Pustaka");
        System.out.println("    3. Keluar");
        System.out.print("    Silakan pilih [1/2/3]: ");
        option = sc.nextInt();

        switch (option){
            case 1 : 
                System.out.println("manual");
                manualDoubleLinkedList();
                break;
            case 2 : 
                System.out.println("pustaka");
                libraryDoubleLinkedList();
                break;
            case 3 :
                System.out.println("keluar");
                break;
            default : 
                System.out.println("pilihan tidak diketahui");
        }

    }

    public static void manualDoubleLinkedList(){

    }

    public static void libraryDoubleLinkedList(){

    }

}
