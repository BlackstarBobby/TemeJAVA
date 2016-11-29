import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bobby on 30-10-2016.
 */

class Node<T extends Comparable<? super T>>{
    T key;

    Node leftChild;
    Node rightChild;

    Node(T key){
        this.key=key;
    }

    public String toString(){
        return  key+"";
    }

    public int comparableTo(Node<T> node){
        if(key.equals(node.key))
            return 0;
        return  1;
    }
}
public class Arbore<T extends Comparable<? super T>> {

    Node<T> root;
    String toStringReturn;
    ArrayList<T> forEquals;

    public boolean add(T key){
        Node<T> newNode = new Node<T>(key);

        if(root==null){
            root=newNode;
            return true;
        }else{
            Node<T> focusNode = root;

            Node<T> parent;

            while(true){
                parent=focusNode;

                if(key.compareTo(focusNode.key)==0) return false;
                if(key.compareTo(focusNode.key)<0){
                    focusNode=focusNode.leftChild;
                    if(focusNode==null){
                        parent.leftChild=newNode;
                        return true;
                    }
                }else{
                    focusNode=focusNode.rightChild;
                    if (focusNode==null){
                        parent.rightChild=newNode;
                        return true;
                    }
                }
            }
        }
    }

    public void inOrder(Node<T> focusNode){
        if(focusNode!=null){
            inOrder(focusNode.leftChild);
            //System.out.print(focusNode+" ");
            toStringReturn+=focusNode.key+" ";
            inOrder(focusNode.rightChild);
        }
    }

    public String toString(){
        toStringReturn=new String();
        inOrder(root);
        //return (String)inOrder(root);
        return toStringReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arbore )) return false;

        Arbore<?> arbore = (Arbore<?>) o;

        if (root != null ? !root.equals(arbore.root) : arbore.root != null) return false;
        if (toStringReturn != null ? !toStringReturn.equals(arbore.toStringReturn) : arbore.toStringReturn != null)
            return false;
        return forEquals != null ? forEquals.equals(arbore.forEquals) : arbore.forEquals == null;

    }

    @Override
    public int hashCode() {
        int result = root != null ? root.hashCode() : 0;
        result = 31 * result + (toStringReturn != null ? toStringReturn.hashCode() : 0);
        result = 31 * result + (forEquals != null ? forEquals.hashCode() : 0);
        return result;
    }
    /*
    public void inOrderEquals(Node<T> focusNode){
        if(focusNode!=null){
            inOrderEquals(focusNode.leftChild);
            this.forEquals.add(focusNode.key);
            inOrderEquals(focusNode.rightChild);
        }
    }

    public boolean equals(Arbore<T> arb){
        forEquals= new ArrayList<>();
        inOrderEquals(root);
        arb.forEquals= new ArrayList<T>();
        arb.inOrderEquals(arb.root);
        if(forEquals.equals(arb.forEquals))
            return true;
        return false;
    }
    */
}

class BinaryTree{

    public static void main(String arg[]) throws FileNotFoundException {
       /* Arbore<Integer> bt = new Arbore<>();
        bt.add(20);
        bt.add(30);
        bt.add(10);
        bt.add(25);

        System.out.println(bt);

        Arbore<String> bts = new Arbore<>();
        bts.add("Bb");
        bts.add("Ee");
        bts.add("Aa");
        bts.add("Dd");

        System.out.println(bts);*/

        Scanner sc = new Scanner(new File("date.in"));
        Arbore<Integer> ai = new Arbore<>();

        while(sc.hasNext()){
            ai.add(sc.nextInt());
        }

        System.out.println(ai);


        ///Ultima liniuta

        Arbore<SuperClass> asc  = new Arbore<>();
        asc.add(new SuperClass(3));
        asc.add(new SuperClass(1));
        asc.add(new SuperClass(7));
        asc.add(new SubClass(8));
        asc.add(new SubClass(9));

        System.out.println(asc);

        Arbore<SuperClass> ascc  = new Arbore<>();
        ascc.add(new SuperClass(3));
        ascc.add(new SuperClass(1));
        ascc.add(new SuperClass(7));
        ascc.add(new SubClass(8));
        ascc.add(new SubClass(9));

        System.out.println(ascc);

        //asc.equals(ascc);

        System.out.println();

        Arbore<Character> abc  = new Arbore<>();
        abc.add('a');
        abc.add('b');
        abc.add('c');
        abc.add('d');

        System.out.println(abc);

        Arbore<Character> abcc  = new Arbore<>();
        abcc.add('a');
        abcc.add('b');
        abcc.add('c');
        abcc.add('d');

        System.out.println(abcc);
        System.out.println("Cu el insusi");
        if(abc.equals(abc)){
            System.out.println("Egale");
        }else{
            System.out.println("Nu sunt egale");
        }

        System.out.println("cu altceva");
        if(abc.equals(abcc)){
            System.out.println("Egale");
        }else{
            System.out.println("Nu sunt egale");
        }

        Arbore<Integer> abi  = new Arbore<>();
        abi.add(2);
        abi.add(3);
        abi.add(4);
        abi.add(5);

        System.out.println(abc);

        Arbore<Integer> abii  = new Arbore<>();
        abii.add(3);
        abii.add(5);
        abii.add(2);
        abii.add(4);

        System.out.println(abcc);

        if(abi.equals(abii)){
            System.out.println("Egale");
        }else{
            System.out.println("Nu sunt egale");
        }
    }
}


