import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by bobby on 28-11-2016.
 */

class Punct{

    private int x, y;

    public Punct(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Distanta {

    Scanner sc=new Scanner( new File("date.in"));
    ArrayList<Punct> puncte = new ArrayList<>();
    ArrayList<Integer> abscisa = new ArrayList<>();
    ArrayList<Integer> ordonata = new ArrayList<>();

    int nrPuncte;


    public Distanta() throws FileNotFoundException {
        nrPuncte = sc.nextInt();

        int xx,yy;

        for (int i=0;i<nrPuncte;i++){
            xx=sc.nextInt();
            yy=sc.nextInt();
            puncte.add(new Punct(xx,yy));
            abscisa.add(xx);
            ordonata.add(yy);
        }

        Collections.sort(abscisa);
        

    }

    public static void main(String arg[]){

    }
}
