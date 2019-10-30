import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Librarie.getInstance().setCarteList(new ArrayList<>());
        String line;
        String[] vector;
        boolean stop = false;
        while(!stop) {
            line = scanner.nextLine();
            vector = line.split("\\s+");
            switch (vector[0].toUpperCase()) {
                case "ADD" :
                    if (vector[1].equals("istorie")) {
                        try {
                            Librarie.getInstance().adaugareCarte(
                                    new Istorie(vector[2], vector[3], Integer.parseInt(vector[4]), Float.parseFloat(vector[5]),
                                            vector[6])
                            );
                        } catch (NotEnoughSpaceException e) {
                            e.printStackTrace();
                        } catch (DuplicateIsbnException e) {
                            e.printStackTrace();
                        }
                    }else if (vector[1].equals("beletristica")) {
                        try {
                            Librarie.getInstance().adaugareCarte(
                                    new Beletristica(vector[2], vector[3], Integer.parseInt(vector[4]), Float.parseFloat(vector[5]),
                                            Integer.parseInt(vector[6]))
                            );
                        } catch (NotEnoughSpaceException e) {
                            e.printStackTrace();
                        } catch (DuplicateIsbnException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            Librarie.getInstance().adaugareCarte(
                                    new Carte(vector[1], vector[2], Integer.parseInt(vector[3]), Float.parseFloat(vector[4])));
                        } catch (NotEnoughSpaceException e) {
                            e.printStackTrace();
                        } catch (DuplicateIsbnException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case "BUY" :
                    Librarie.getInstance().cumparareCarte(Integer.parseInt(vector[1]));
                    break;
                case "PRINT" :
                    Librarie.getInstance().afisareCarti();
                    break;
                case "PRINT_H" :
                    Librarie.getInstance().afisareCartiIstorie();
                    break;
                case "REMOVE" :
                    Librarie.getInstance().stergereCarteDupaAutor(vector[1]);
                    break;
                case "EXIT" :
                    stop = true;
                    break;
            }
        }
    }
}
