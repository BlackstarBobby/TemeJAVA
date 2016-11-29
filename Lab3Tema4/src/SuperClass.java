/**
 * Created by bobby on 31-10-2016.
 */
public class SuperClass implements Comparable<SuperClass> {

    public int getInfo() {
        return info;
    }

    private int info;

    SuperClass(int info){
        this.info=info;
    }

    @Override
    public int compareTo(SuperClass o) {

        System.out.println("Compare din super");
        if(getInfo()>o.getInfo())
            return 1;
        else if(getInfo()==o.getInfo())
            return 0;
        return -1;
    }

    public String toString(){
        return Integer.toString(info);
    }
}
