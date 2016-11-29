import java.io.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

class coada<T>  implements Iterable<T>{

    private int total;
    private Node first,last;


    @Override
    public Iterator<T> iterator(){

        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex<total&&ElementAt(currentIndex)!=null;
            }

            @Override
            public T next() {
                return ElementAt(currentIndex++);
            }
        };
        return it;
    }


    private class Node{
        private T element;
        private Node next;
    }


    public coada(){
        total=0;
        first=null;
        last=null;
    }

    public coada Add(T value){
        Node current = last;
        last=new Node();
        last.element=value;

        if(total++==0) first=last;
        else current.next=last;

        return this;
    }

    public T Remove(){
        if(total==0) throw new java.util.NoSuchElementException();
        T ele=first.element;
        first=first.next;
        if(--total==0) last=null;
        return ele;
    }

    public T Element(){
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

    public T ElementAt(int value){
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

    public int size(){
        return total;
    }
}

public class AdvancedQueue {

    public static void main(String arg[]) throws IOException {

        //Integer
        coada<Integer> cd = new coada<>();

        for (int i=0;i<10;i++){
            cd.Add(i);
        }

        Iterator<Integer> ite = cd.iterator();
        while(ite.hasNext()){
            int temp = ite.next();
            System.out.print(temp+" ");
        }
        System.out.println();
        for (double i=0.0;i<10;i++){
            if(i%2==0) cd.Remove();
        }
        cd.Show();

        System.out.println();
        //Character
        coada<Character> cc = new coada<>();
        for (int i='a';i<'z';i++){
            cc.Add((char)i);
        }
        for(Character car:cc){
            System.out.print(car+" ");
        }
        System.out.println();
        for (int i=0;i<cc.size();i++){
            cc.Remove();
        }
        cc.Show();
        System.out.println();

        //Coada de cozi
        coada<coada<Integer>> cci = new coada<>();

        for(int i=0;i<2;i++){
            coada<Integer> temp = new coada<>();
            temp.Add((int) (Math.random()*100)+100);
            temp.Add((int) (Math.random()*100)+100);
            temp.Add((int) (Math.random()*100)+100);
            temp.Add((int) (Math.random()*100)+100);
            temp.Add((int) (Math.random()*100)+100);
            cci.Add(temp);
        }

        for (coada<Integer> ctemp:cci){
            ctemp.Show();
            System.out.println();
        }
        System.out.println();
        cci.Remove();
        for (coada<Integer> ctemp:cci){
            ctemp.Show();
            System.out.println();
        }


        /* /graf din tema anterioara-------------------------------------------------------- */

        Scanner sc = new Scanner(new File("date.in"));
        int nr_varfuri, nr_muchii, inceput;

        nr_varfuri = sc.nextInt();
        nr_muchii = sc.nextInt();

        //citesc listele de muchii
        coada<Integer>[] lista = new coada[nr_varfuri];
        for (int i=0;i<nr_varfuri;i++) {
            lista[i]=new coada<Integer>();
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


        //afisez lista de adiacenta
        for (int i=0;i<lista.length;i++){
            bw.write((i+1)+": ");

            for (int j=0;j<lista[i].size();j++){

                bw.write(lista[i].ElementAt(j)+" ");
            }
            bw.newLine();
        }
        //initializez o noua coada coada pentru afisare in latime
        coada<Integer> parc_latime= new coada<>();
        parc_latime.Add(initial);
        int[] vizitat = new int[nr_varfuri];
        for (int i=0;i<vizitat.length;i++){
            vizitat[i]=0;
        }
        vizitat[initial-1]=1;

        while(parc_latime.size()!=0){
            int capVizitat= (int) parc_latime.Element();
            for (int i=0;i<lista[(capVizitat-1)].size();i++){
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
