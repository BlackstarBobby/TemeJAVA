import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.util.*;

import static java.lang.StrictMath.sqrt;

class Distanta {

    public static void main(String arg[]) throws FileNotFoundException {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
        HashMap<String, Integer> hm2 = new HashMap<String, Integer>();

        Scanner sc = new Scanner(new File("date1.in"));
        sc.useDelimiter("[^A-Za-z0-9]+");
        String cuv;

        while (sc.hasNext()) {
            cuv = sc.next().toLowerCase();
            //String[] split = line.split("[A-Za-z0-9]+");
            if (hm1.get(cuv) == null) {
                hm1.put(cuv, 1);
            } else {
                int man = hm1.get(cuv);
                hm1.put(cuv, man + 1);
            }
        }

        sc = new Scanner(new File("date2.in"));
        sc.useDelimiter("[^A-Za-z0-9]+");
        while (sc.hasNext()) {
            cuv = sc.next().toLowerCase();
            if (hm2.get(cuv) == null) {
                hm2.put(cuv, 1);
            } else {
                hm2.put(cuv, hm2.get(cuv) + 1);
            }
        }

        Set<Map.Entry<String, Integer>> S1 = hm1.entrySet();
        System.out.println(S1);
        Set<Map.Entry<String, Integer>> S2 = hm2.entrySet();
        System.out.println(S2);


        Double dcos = 0.0, upper = 0.0, rad1 = 0.0, rad2 = 0.0;

        Iterator entries;
        entries = S2.iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            int temp = (Integer) thisEntry.getValue();
            rad2 += (double) (temp * temp);
        }

        if (rad2 != 0) {

            entries = S1.iterator();

            while (entries.hasNext()) {
                Map.Entry thisEntry = (Map.Entry) entries.next();
                int temp = (Integer) thisEntry.getValue();
                rad1 += (double) (temp * temp);
                cuv = (String) thisEntry.getKey();
                upper += (hm1.get(cuv) == null ? 0 : hm1.get(cuv)) * (hm2.get(cuv) == null ? 0 : hm2.get(cuv));
                if (hm1.get(cuv) != null) hm1.put(cuv, 0);
                if (hm2.get(cuv) != null) hm2.put(cuv, 0);
            }

            if(rad1!=0) {

                entries = S2.iterator();
                while (entries.hasNext()) {
                    Map.Entry thisEntry = (Map.Entry) entries.next();
                    cuv = (String) thisEntry.getKey();
                    upper += (hm1.get(cuv) == null ? 0 : hm1.get(cuv)) * (hm2.get(cuv) == null ? 0 : hm2.get(cuv));
                }


                dcos = upper / (sqrt(rad1) * sqrt(rad2));
                System.out.println(dcos);
            }else{
                System.out.println("Fisierul 1 nu contine cuvinte");
            }
        }else{
            System.out.println("Fisierul 2 nu contine cuvinte");
        }
    }
 }
