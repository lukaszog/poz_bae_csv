package pl.bae.csv;

public class Main {

    public static void main(String[] args) {

        Perser.readFile();

        int tab[] = new int[3];
        try {
            System.out.println(tab[6]);
        }catch (ArrayIndexOutOfBoundsException err){
            System.out.println("Blad!");
            err.printStackTrace();
        }
        System.out.println("dzialam dalej....");
    }
}
