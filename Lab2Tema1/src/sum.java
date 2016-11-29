import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class sum{

    public static void  main(String arg[]) throws IOException {

        //citesc datele
        Scanner sc = new Scanner(new File("date.in"));
        int nr_elemente = 0;
        if(sc.hasNextInt()) nr_elemente = sc.nextInt();
        int[] numbers = new int[nr_elemente];
        int i=0;
        while (sc.hasNextInt()){
            numbers[i]=sc.nextInt();
            i++;
        }

        //for the output
        File file = new File("date.out");

        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);


        //the problem
        Arrays.sort(numbers);
        int a,b,c,start,end;
        for (i=0;i<nr_elemente;i++){
            a=numbers[i];
            start=i+1;
            end=numbers.length-1;
            while (start<end){
                b=numbers[start];
                c=numbers[end];
                if(a+b+c==0) {
                    bw.write("(" + a + ", " + b + ", " + c + ") ");
                    bw.newLine();
                    start++;end--;
                }else if(a+b+c>0)end--;
                else start++;
            }
        }



       // for ( i=0;i<numbers.length;i++){
        //    bw.write(numbers[i]+ " ");
        //}


        bw.close();
    }
}