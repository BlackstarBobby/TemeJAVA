import java.util.Scanner;
import java.util.Arrays;

import static java.util.Arrays.sort;

class Propozitie{

    public static void main(String arg[]){


       Scanner sc = new Scanner(System.in);

        System.out.print("Give me the sentence:");

        String propozitie = sc.nextLine();

        //String propozitie = "Aceasta, este o propozitie!";

       // String bucati[]= propozitie.split("[ !,.]");

        propozitie=propozitie.toLowerCase();

        String[] bucati= propozitie.split("[^A-Za-z0-9]+");



        sort(bucati);

        for (int i=0;i<bucati.length;i++){
            System.out.println(bucati[i]);
        }
    }

}