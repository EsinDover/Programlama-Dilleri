package gramer;


import java.util.Scanner;

public class Gramer {
    public static void main(String[] args) {
        
        String[] ozne = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesne = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklem = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cümleyi giriniz: ");
        String cumle = scanner.nextLine();

        
        String[] kelimeler = cumle.split("\\s+");

        
        if (kelimeler.length != 3) {
            System.out.println("Hatalı cümle: Özne, Nesne ve Yüklem olmak üzere tam 3 kelime içermelidir.");
        } else {
            String ozneKelime = kelimeler[0];
            String nesneKelime = kelimeler[1];
            String yuklemKelime = kelimeler[2];

          
            if (!contains(ozne, ozneKelime) && !contains(nesne, nesneKelime) && !contains(yuklem, yuklemKelime)) {
                System.out.println("HAYIR");
            } else {
                System.out.println("EVET");
            }
        }
    }

   
    public static boolean contains(String[] array, String str) {
        for (String s : array) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }
}