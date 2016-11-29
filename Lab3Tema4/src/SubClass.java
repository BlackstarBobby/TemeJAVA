/**
 * Created by bobby on 31-10-2016.
 */
public class SubClass extends SuperClass {

    public int getInformation() {
        return information;
    }

    int information;

    SubClass(int info) {
        super(info);
        information=info-1;
    }



    @Override
    public int compareTo(SuperClass oo) {

        if(oo instanceof SubClass && this instanceof SubClass) {
            System.out.println("Compare din sub");
            //SubClass o = (SubClass) oo;
            if (getInformation() > oo.getInfo())
                return 1;
            else if (getInformation() == oo.getInfo())
                return 0;
            return -1;
        }
        else return super.compareTo(oo);
    }
}
