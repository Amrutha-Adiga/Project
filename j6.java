import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class j6 {
    public static void main(String[] args) throws FileNotFoundException {
        int s;
        String ding = "";

        ArrayList<String> a = new ArrayList<>();    //dishes
        ArrayList<Integer> b = new ArrayList<>();   //price
        ArrayList<String> c = new ArrayList<>();    //name of person ordered
        ArrayList<String> e = new ArrayList<>();    //ordered dishes
        ArrayList<Integer> d = new ArrayList<>();   //quantity
        ArrayList<String> f = new ArrayList<>();    //ordered date

        File f1 = new File("menu.txt");
        File f2 = new File("order.txt");
        Scanner sc1 = new Scanner(f1);
        Scanner sc2 = new Scanner(f2);
        File file = new File("newFile.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists. Overwriting initial content.");
            }

            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write("--- Start of Processing Results ---\n");
            }

        } catch (IOException e1) {
            System.err.println("An IO error occurred while creating or initializing the file.");
            e1.printStackTrace();
        }

        while (sc1.hasNextLine()) {
            String line = sc1.nextLine();
            String[] arr1 = line.split(",");
            String a1 = arr1[0];
            int a2 = Integer.parseInt(arr1[1]);
            a.add(a1);
            b.add(a2);
        }
        sc1.close(); // Close the Scanner for f1

        while (sc2.hasNextLine()) {
            String line = sc2.nextLine();
            String[] arr1 = line.split(",");
            String b1 = arr1[0];
            String b2 = arr1[1];
            int b3 = Integer.parseInt(arr1[2]);
            String b4 = arr1[3];
            c.add(b1);
            d.add(b3);
            e.add(b2);
            f.add(b4);
        }
        sc2.close();

        try (FileWriter writer = new FileWriter(file, true)) {

            for(int i=0; i < a.size(); i++) {     //Replace the number with the size of any list(menu)
                for(int j=0; j < c.size(); j++) {     //Replace the number with the size of any list(order)
                    if (a.get(i).equals(e.get(j))) {
                        s = b.get(i) * d.get(j);

                        ding = c.get(j) + " " + s + " " + f.get(j);

                        System.out.println(ding);

                        writer.write(ding + "\n");
                    }
                }
            }

        } catch (IOException ioException) {
            System.err.println("An error occurred while writing the 'ding' values to the file.");
            ioException.printStackTrace();
        }
    }
}