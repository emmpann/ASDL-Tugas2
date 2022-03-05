import java.util.LinkedList;

public class App {

    static int option;
    static boolean isContinue;

    private static boolean isManual;

    public static LinkedList<Integer> list = new LinkedList<Integer>();
    public static DoubleLinkedList dList = new DoubleLinkedList();

    public static void main(String[] args) {
        menuUtama();
    }

    public static void menuUtama() {
        System.out.println("*** DOUBLE LINKED LIST ***");
        System.out.println("    1. Manual");
        System.out.println("    2. Pustaka");
        System.out.println("    3. Keluar");
        option = ScannerUtil.integerScn("    Silakan pilih [1/2/3]");

        switch (option) {
            /**
             * di opsi ini akan ditentukan apakah program menyimpan data di double linked list manual atau library
             * ketika case 1 terpilih maka, method setIsManual akan menyimpan value true di variable isManual(boolean)
             * begitupun sebaliknya untuk case 2
             * 
             * ketika variable isManual sudah memiliki value (true atau false) maka variable ini bisa dimanfaatkan untuk method lainnya
             * baca line 208
             */
            case 1:
                setIsManual(true);
                pilihanOperasi();
                break;
            case 2:
                setIsManual(false);
                pilihanOperasi();
                break;
            case 3:
                break;
            default:
                System.out.println("pilihan tidak diketahui");
        }
    }

    public static void pilihanOperasi() {
        isContinue = true;
        option = 0;

        System.out.println("*** OPERASI DOUBLE LINKED LIST ***");
        System.out.println("    1. Tambah Data");
        System.out.println("    2. Hapus Data");
        System.out.println("    3. Pencarian/Pengubahan Data");
        System.out.println("    4. Kembali");

        while (isContinue) {
            option = ScannerUtil.integerScn("    Silakan pilih [1/2/3/4]");

            switch (option) {
                case 1:
                    isContinue = false;
                    tambahDataMenu();
                    break;
                case 2:
                    isContinue = false;
                    hapusDataMenu();
                    break;
                case 3:
                    isContinue = false;
                    ubahDataMenu();
                    break;
                case 4:
                    isContinue = false;
                    menuUtama();
                    break;
                default:
                    isContinue = true;
            }
        }

    }

    public static void tambahDataMenu() {
        // 1. Tambah Data
        isContinue = true;
        option = 0;

        System.out.println("*** OPERASI TAMBAH DATA DOUBLE LINKED LIST ***");
        System.out.println("    1. Tambah Data Awal");
        System.out.println("    2. Tambah Data Tengah");
        System.out.println("    3. Tambah Data Akhir");
        System.out.println("    4. Cetak Data");
        System.out.println("    5. Kembali");

        while (isContinue) {
            option = ScannerUtil.integerScn("Silakan pilih [1/2/3/4/5]");

            switch (option) {
                case 1:
                    isContinue = false;
                    tambahDataAwalView();
                    break;
                case 2:
                    isContinue = false;
                    tambahDataTengahView();
                    break;
                case 3:
                    isContinue = false;
                    tambahDataAkhirView();
                    break;
                case 4:
                    isContinue = false;
                    cetakData(1); // true karena menu tambah data
                    break;
                case 5:
                    isContinue = false;
                    pilihanOperasi();
                    break;
                default :
                    isContinue = true;
            }

        }

    }

    public static void hapusDataMenu(){
        // 2. Hapus data

        isContinue = true;
        option = 0;

        System.out.println("*** OPERASI HAPUS DATA DOUBLE LINKED LIST ***");
        System.out.println("    1. Hapus Data Awal");
        System.out.println("    2. Hapus Data Tengah");
        System.out.println("    3. Hapus Data Akhir");
        System.out.println("    4. Cetak Data");
        System.out.println("    5. Kembali");

        while (isContinue) {
            option = ScannerUtil.integerScn("Silakan pilih [1/2/3/4/5]");

            switch (option) {
                case 1:
                    isContinue = false;
                    hapusDataAwalView();
                    break;
                case 2:
                    isContinue = false;
                    hapusDataTengahView();
                    break;
                case 3:
                    isContinue = false;
                    hapusDataAkhirView();
                    break;
                case 4:
                    isContinue = false;
                    cetakData(2); // false karena bukan menu tambah data
                    break;
                case 5:
                    isContinue = false;
                    pilihanOperasi();
                    break;
                default :
                    isContinue = true;
            }

        }

    }

    public static void ubahDataMenu(){
        // 3. Ubah data dan cari data
        
        isContinue = true;
        option = 0;
        
        System.out.println("*** OPERASI PENCARIAN/PENGUBAHAN DATA DOUBLE LINKED LIST ***");
        System.out.println();
        System.out.println("    1. Cari data");
        System.out.println("    2. Ubah data");
        System.out.println("    3. Cetak data");
        System.out.println("    4. Kembali");
        option = ScannerUtil.integerScn("    Silakan pilih [1/2/3/4]");

        switch(option){
            case 1 : 
                isContinue = false;
                cariDataView();
                break;
            case 2 :
                isContinue = false;
                ubahDataView();                
                break;
            case 3 :
                isContinue = false;
                cetakData(3);;
                break;
            case 4 :
                isContinue = false;
                pilihanOperasi();
                break;
            default :
                isContinue = true;
        }

    }

    /**
     * TAMBAH DATA
     */

    public static void tambahDataAwalView(){
        isContinue = true;
        String element;
        int index = 1;

        System.out.println("*** OPERASI TAMBAH DATA AWAL DOUBLE LINKED LIST ***");
        System.out.println();
        System.out.println("    INFO: - Masukan data angka (integer)");
        System.out.println("          - Ketik 'stop' untuk kembali ke menu sebelumnya");
        System.out.println();
        
        while(isContinue){
            element = ScannerUtil.stringScn("Data ke-" + index);

            char[] chars = element.toCharArray();
            if(Character.isDigit(chars[0])){
                tambahDataAwal(Integer.parseInt(element));
                index++;
            } else {
                if(!element.equals("stop")){
                    // Jika user tidak memasukan kata "stop" maka loop tetap berlangsung
                    isContinue = true;
                } else {
                    // loop  berhenti karena user memasukan kata "stop"
                    isContinue = false;
                    tambahDataMenu();
                }
            }
        }
    }

    public static void tambahDataAwal(int element) {
        // 1. Tambah data awal

        /**
         * Ini merupakan salah satu method yang memanfaatkan variable isManual
         * dengan menggunakan method getIsmanual() maka kita bisa mengambil value dari varible isManual
         * 
         * bisa diperhatikan perkondisian dibawah, ketika isManual bervalue true maka program akan menginstruksikan untuk menyimpan data
         * menggunakan double linked list manual
         * 
         * jika isManual bervalue false maka data akan disimpan menggunakan double linked list library
         */
        if(getIsManual()){
            // Manual
            dList.addFirst(element, dList);
        } else if(!getIsManual()) {
            // Pustaka
            list.addFirst(element);
        }
    }

    /**
     * TAMBAH DATA TENGAH
     */

    public static void tambahDataTengahView(){
        int index, element;
        isContinue = true;
        System.out.println("*** OPERASI TAMBAH DATA TENGAH DOUBLE LINKED LIST ***");
        System.out.println();
        System.out.println("    INFO: - Masukan index angka (integer)");
        System.out.println("          - Masukan data angka (integer)");
        
        index = ScannerUtil.integerScn("Index ke-");
        element = ScannerUtil.integerScn("Masukan data");
        
        tambahDataTengah(index, element);
        // cek bagaimana jika index yang dimasukan belum ada
        System.out.print("Tekan enter untuk lanjut");
        try {System.in.read();} 
        catch (Exception e) {}
        tambahDataMenu();
    }

    public static void tambahDataTengah(int index, int element) {
        // 2. Tambah data tengah
        if(getIsManual()){
            // Manual
            dList.add(index, element);
        } else if(!getIsManual()) {
            // Pustaka
            list.add(index, element);
        }
    }

    /**
     * TAMBAH DATA AKHIR
     */

    public static void tambahDataAkhirView(){
        String element;
        isContinue = true;
        
        System.out.println("*** OPERASI TAMBAH DATA AKHIR DOUBLE LINKED LIST ***");
        System.out.println();
        System.out.println("    INFO - Masukan data angka (integer)");
        System.out.println();

        while(isContinue){
            element = ScannerUtil.stringScn("Data");

            char[] chars = element.toCharArray();
            if(Character.isDigit(chars[0])){
                tambahDataAwal(Integer.parseInt(element));
            } else {
                if(!element.equals("stop")){
                    // Jika user tidak memasukan kata "stop" maka loop tetap berlangsung
                    isContinue = true;
                } else {
                    // loop  berhenti karena user memasukan kata "stop"
                    isContinue = false;
                    tambahDataMenu();
                }
            }
        }
    }

    public static void tambahDataAkhir(int element) {
        // 3. Tambah data akhir
        if(getIsManual()){
            // Manual
            dList.addLast(element);
        } else if(!getIsManual()) {
            // Pustaka

            list.addLast(element);

        }
    }

    /**
     * HAPUS DATA
     */

    public static void hapusDataAwalView(){
        isContinue = true;
        String argument;

        System.out.println("*** OPERASI HAPUS DATA AWAL DOUBLE LINKED LIST ***");
        System.out.println();
        System.out.println("    INFO - Masukan Y (enter) untuk menghapus data");
        System.out.println();
        
        while(isContinue){
            argument = ScannerUtil.stringScn("Yakin ingin menghapus data di awal? ");
            if(argument.equalsIgnoreCase("y")){
                hapusDataAwal();
                isContinue = false;
                System.out.print("Tekan enter untuk lanjut");
                try{System.in.read();}
                catch(Exception e){}
                hapusDataMenu();
            } else if (argument.equalsIgnoreCase("n")){
                hapusDataMenu();
                isContinue = false;
            } else {
                isContinue = true;
            }
        }

    }

    public static void hapusDataAwal() {
        // 1. Hapus Data awal
        if(getIsManual()){
            // Manual
            dList.removeFirst();
        } else if(!getIsManual()) {
            // Pustaka
            list.removeFirst();
        }
    }
    
    /**
     * HAPUS DATA TENGAH
     */

    public static void hapusDataTengahView(){
        int index;
        String argument;

        System.out.println("*** OPERASI HAPUS DATA TENGAH DOUBLE LINKED LIST");
        System.out.println();
        System.out.println("    INFO - Masukan index angka (integer) data yang ingin di hapus");
        System.out.println("         - Tekan Y (enter) untuk menghapus data");
        System.out.println();

        index = ScannerUtil.integerScn("Data ke (index)");
        
        argument = ScannerUtil.stringScn("Yakin ingin menghapus data di index ke-" + index);
        if(argument.equalsIgnoreCase("y")){
            hapusDataTengah(index);
        }
        System.out.print("Tekan enter untuk lanjut");
        try{System.in.read();}
        catch(Exception e){}

        hapusDataMenu();
    }

    public static void hapusDataTengah(int index) {
        // 2. Hapus data tengah
        if(getIsManual()){
            // Manual
            dList.remove(index);
        } else if(!getIsManual()) {
            // Pustaka
            list.remove(index);
        }
    }

    /**
     * HAPUS DATA AKHIR
     */

    public static void hapusDataAkhirView(){
        String argument;
        
        System.out.println("*** OPERASI HAPUS DATA AKHIR DOUBLE LINKED LIST ***");
        System.out.println();
        System.out.println("    INFO - Tekan Y (enter) untuk menghapus data");
        System.out.println();
        argument = ScannerUtil.stringScn("Yakin ingin menghapus data akhir? ");
        if(argument.equalsIgnoreCase("y")){
            hapusDataAkhir();
        }
        System.out.print("Tekan enter untuk lanjut");
        try{System.in.read();}
        catch(Exception e){}

        hapusDataMenu();
    }

    public static void hapusDataAkhir() {
        // 3. Hapus data akhir
        if(getIsManual()){
            // Manual
            dList.removeLast();
        } else if(!getIsManual()) {
            // Pustaka
            list.removeLast();
        }
    }
    
    /**
     * UBAH DATA
     */

    public static void ubahDataView(){
        int index, element;
        
        System.out.println("*** OPERASI UBAH DATA ***");
        System.out.println();
        System.out.println("    INFO - Masukan index angka (Integer)");
        System.out.println("         - Masukan data yang diubah berupa angka (Integer)");
        System.out.println();
        
        index = ScannerUtil.integerScn("Index");
        element = ScannerUtil.integerScn("Data");

        ubahData(index, element);

        System.out.print("Tekan enter untuk lanjut");
        try{System.in.read();}
        catch(Exception e){}
        ubahDataMenu();
    }
    
    public static void ubahData(int index, int element) {
        // 4. Ubah data
        if(getIsManual()){
            dList.setData(index, element);
        } else if(!getIsManual()){
            list.set(index, element);
        }
    }
    
    /**
     * CARI DATA
     */

    public static void cariDataView(){
        int element;
        
        System.out.println("*** OPERASI CARI DATA ***");
        System.out.println();
        System.out.println("    INFO - Masukan data yang ingin dicari berupa angka (Integer)");
        System.out.println();

        element = ScannerUtil.integerScn("Data");

        if(cariData(element)){
            System.out.println("Data ditemukan");
        } else {
            System.out.println("Data tidak ditemukan");
        }
        
        System.out.print("Tekan enter untuk lanjut");
        try{System.in.read();}
        catch(Exception e){}
        ubahDataMenu();
    }

    public static boolean cariData(int element){
        
        if(dList.searchByData(element)){
            return true;
        } else {
            return false;
        }
    }

    public static void cetakData(int key){
        if(getIsManual()){
            System.out.println("*** CETAK DATA DOUBLE LINKED LIST ***");
            System.out.println();
            System.out.print("    "); dList.printList(true);
            System.out.println();
            System.out.print("Tekan enter untuk lanjut");
            try{System.in.read();}
            catch(Exception e){}
            if(key == 1){
                tambahDataMenu();
            } else if (key == 2){
                hapusDataMenu();
            } else if(key == 3){
                ubahDataMenu();
            }
        } else if(!getIsManual()){
            System.out.println("*** CETAK DATA DOUBLE LINKED LIST ***");
            System.out.println();
            System.out.println("    " + list);
            System.out.println();
            System.out.print("Tekan enter untuk lanjut");
            try{System.in.read();}
            catch(Exception e){}
            if(key == 1){
                tambahDataMenu();
            } else if(key == 2){
                hapusDataMenu();
            } else if(key == 3){
                ubahDataMenu();
            }
        }
    }

    public static void setIsManual(boolean manual){
        isManual = manual;
    }

    public static boolean getIsManual(){
        return isManual;
    }
}
