package bagli_sirala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bagli_Sirala {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dosya ismini giriniz:");
        String dosyaYolu = scanner.nextLine();

        List<Node> nodes = new ArrayList<>();
        List<Node> copyNode = new ArrayList<>();
        int index = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); 
                if (!line.isEmpty()) { 
                    try {
                        int data = Integer.parseInt(line);
                        nodes.add(new Node(data, index));
                        copyNode.add(new Node(data, index));
                        index++;
                    } catch (NumberFormatException ex) {
                        System.err.println("Hata: Geçersiz bir tamsayı: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Node> sortedNodes = new ArrayList<>(nodes);
        selectionSort(sortedNodes);

        System.out.println("Siralanmamis Hali\t\tSiralanmis Hali");
        System.out.println("Veri\tAdres\t\t\tVeri\tAdres");
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            Node copy = copyNode.get(i);
            System.out.println(copy.data + "\t" + copy.adres + "\t\t\t" + node.data + "\t" + node.adres);
        }
    }

    public static void selectionSort(List<Node> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(j).data < nodes.get(minIndex).data) {
                    minIndex = j;
                }
            }
            int tempAddress = nodes.get(minIndex).adres;
            nodes.get(minIndex).adres = nodes.get(i).adres;
            nodes.get(i).adres = tempAddress;

            Node temp = nodes.get(minIndex);
            nodes.set(minIndex, nodes.get(i));
            nodes.set(i, temp);
        }
    }
}
