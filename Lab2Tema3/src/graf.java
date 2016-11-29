import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.lang.reflect.Array;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

class coada{

    private int total;
    private Node first,last;

    private class Node{
        private int element;
        private Node next;
    }


    public coada(){
        total=0;
        first=null;
        last=null;
    }

    public coada Add(int value){
        Node current = last;
        last=new Node();
        last.element=value;

        if(total++==0) first=last;
        else current.next=last;

        return this;
    }

    public int Remove(){
        if(total==0) throw new java.util.NoSuchElementException();
        int ele=first.element;
        first=first.next;
        if(--total==0) last=null;
        return ele;
    }

    public int Element(){
        if(total==0) throw new java.util.NoSuchElementException();
        return first.element;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node temp = first;
        while(temp!=null){
            sb.append(temp.element).append(", ");
            temp=temp.next;
        }
        return sb.toString();
    }

    public int ElementAt(int value){
        if(value>total) throw new java.util.NoSuchElementException();
        Node temp=first;
        for (int i=0;i<value;i++)
            temp=temp.next;
        return temp.element;
    }

    public void Show(){
        if(total>0) {
            Node temp = first;
            while(temp!=null){
                System.out.print(temp.element+" ");
                temp=temp.next;
            }
        }
    }

    public int lungime(){
        return total;
    }
}

class Graf{
    public static void main(String arg[]) throws IOException {

        //citesc numarul de varfuri si muchii
        Scanner sc = new Scanner(new File("date.in"));
        int nr_varfuri, nr_muchii, inceput;

        nr_varfuri = sc.nextInt();
        nr_muchii = sc.nextInt();

        //citesc listele de muchii
        coada[] lista = new coada[nr_varfuri];
        for (int i=0;i<nr_varfuri;i++) {
            lista[i]=new coada();
        }


        int temp,temp2;
        for (int i=0;i<nr_muchii;i++){
            temp=sc.nextInt();
            temp2=sc.nextInt();
            lista[temp-1].Add(temp2);
            lista[temp2-1].Add(temp);
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

            for (int j=0;j<lista[i].lungime();j++){

                bw.write(lista[i].ElementAt(j)+" ");
            }
            bw.newLine();
        }
        //initializez o noua coada coada pentru afisare in latime
        coada parc_latime= new coada();
        parc_latime.Add(initial);
        int[] vizitat = new int[nr_varfuri];
        for (int i=0;i<vizitat.length;i++){
            vizitat[i]=0;
        }
        vizitat[initial-1]=1;

        while(parc_latime.lungime()!=0){
            int capVizitat= parc_latime.Element();
            for (int i=0;i<lista[(capVizitat-1)].lungime();i++){
                if (vizitat[lista[(capVizitat-1)].ElementAt(i)-1]==0){
                    parc_latime.Add(lista[(capVizitat-1)].ElementAt(i));
                    vizitat[lista[(capVizitat-1)].ElementAt(i)-1]=1;
                }
            }
            bw.write(parc_latime.Element()+" ");
            parc_latime.Remove();
        }

        bw.close();
    }
}