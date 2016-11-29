import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bobby on 28-11-2016.
 */
public class Inversiune {

    Scanner sc = new Scanner(new File("date.in"));
    int nrElemente=sc.nextInt();
    int[] vector = new int[nrElemente];

    public int getNrElemente() {
        return nrElemente;
    }

    public Inversiune() throws FileNotFoundException {

        for(int i=0; i<nrElemente ; i++){
            vector[i] = sc.nextInt();
        }
    }



    int interclasare(int p, int m, int u){
        //int b[] = new int[u-p+1];
        ArrayList<Integer> b = new ArrayList<>();
        int i=p,j=m+1,k=0,nr=0,l=0;
        while((i<=m)&&(j<=u)){
            if(vector[i]<=vector[j]){
                for (int t=l;t<b.size();t++){
                    if(b.get(t)*2<vector[i])
                        nr++;
                    l=t;
                }
                //l++;
                //b[k]=vector[i];
                i++;
            }else{
                b.add(vector[j]);j++;
            }
            k++;
        }
        while(j<=u){b.add(vector[j]);k++;j++;}

        while(i<=m){
            for (int t=0;t<b.size();t++){
                if(b.get(t)*2<vector[i])
                    nr++;

            }

            k++;i++;}


        return nr;
    }

    int nrInversiuni(int p, int u){
        if(p==u) {
            return 0;
        }else{

            int m=(p+u)/2;

           // Arrays.sort(vector,0,m);
            //Arrays.sort(vector,m+1,u);

            int n1=nrInversiuni(p,m);
            int n2=nrInversiuni(m+1,u);
            return interclasare(p,m,u)+n1+n2;
        }
    }

    public static void main(String arg[]) throws IOException {
        int nrInversiuni=0;

        Inversiune inv = new Inversiune();

        nrInversiuni=inv.nrInversiuni(0,inv.getNrElemente()-1);

        System.out.println(nrInversiuni);

        File file =  new File("date.out");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(nrInversiuni+"");
        bw.close();
    }

}
