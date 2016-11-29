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
}



class graf{

    public static void main(String arg[]){
        coada queue = new coada();
        queue.Add(10);
        queue.Add(20);
        queue.Add(30);
        queue.Add(40);
        queue.Show();
        System.out.println();
        System.out.println(queue.Element());

        queue.Remove();
        queue.Show();

        System.out.println();
        System.out.println(queue.ElementAt(2));

        System.out.println();
        System.out.println(queue.toString());
    }
}