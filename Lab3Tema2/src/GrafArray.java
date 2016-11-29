import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bobby on 31-10-2016.
 */
public class GrafArray {

        public static void main(String arg[]) throws IOException {

            //citesc numarul de varfuri si muchii
            Scanner sc = new Scanner(new File("date.in"));
            int nr_varfuri, nr_muchii, inceput;

            nr_varfuri = sc.nextInt();
            nr_muchii = sc.nextInt();

            //citesc listele de muchii
            ArrayDeque<Integer>[] lista = new ArrayDeque[nr_varfuri];
            for (int i=0;i<nr_varfuri;i++) {
                lista[i]=new ArrayDeque<>();
            }


            int temp,temp2;
            for (int i=0;i<nr_muchii;i++){
                temp=sc.nextInt();
                temp2=sc.nextInt();
                lista[temp-1].add(temp2);
                lista[temp2-1].add(temp);
            }

            //citesc initial
            int initial=sc.nextInt();

            //pregatesc iesirea
            File file = new File("date.out");
            if(!file.exists()) file.createNewFile();
            FileWriter fw =new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

        /*for (int i=0;i<lista.length;i++) {
            Collections.sort(lista[i]);
        }*/


            //afisez lista de adiacenta
            for (int i=0;i<lista.length;i++){
                bw.write((i+1)+": ");
                bw.write(lista[i]+" ");
                /*for (ArrayDeque<Integer> arrayDeque : lista[i])
                {

                }*/
                /*for (int j=0;j<lista[i].size();j++){

                    bw.write(lista[j]+" ");
                    //System.out.println(lista[i]);
                }*/
                bw.newLine();
            }
            //initializez o noua coada coada pentru afisare in latime
            ArrayDeque<Integer> parc_latime= new ArrayDeque();
            parc_latime.add(initial);
            int[] vizitat = new int[nr_varfuri];
            for (int i=0;i<vizitat.length;i++){
                vizitat[i]=0;
            }
            vizitat[initial-1]=1;

            while(parc_latime.size()!=0){
                int capVizitat= parc_latime.element();
                for (int i=0;i<lista[(capVizitat-1)].size();i++){
                    //int temp1=lista[(capVizitat-1)].get(i)-1;
                    //int temp1=lista[(capVizitat-1)].indexOf(i)-1;
                    if (vizitat[lista[(capVizitat-1)].peek()-1]==0){
                        parc_latime.add(lista[(capVizitat-1)].peek());
                        lista[capVizitat-1].remove();
                        vizitat[lista[(capVizitat-1)].peek()-1]=1;
                    }
                }
                bw.write(parc_latime.element()+" ");
                parc_latime.remove();
            }

            bw.close();
        }
}
