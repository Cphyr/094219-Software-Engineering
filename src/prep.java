import java.util.ArrayList;
import java.util.List;

public class prep {
    public static void main(String[] args) {
        LinkedList<Integer> l=new LinkedList<Integer>(5);
    }
}
class LinkedList<T>{
    T value;
    LinkedList<T> next;
    public LinkedList(T value){
        this.value=value;
        next= null;
    }
    public LinkedList(T value, LinkedList<T> next){
        this.next=next;
        this.value=value;
    }
    public void sum(ArrayList<? extends Integer> l){
        int sum=0;
        for(Integer i: l){

        }

    }
}




