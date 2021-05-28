public class A {
    int instance;


    public A(int x){
        System.out.println(x);
    }

    public static final int try1(int x){
        System.out.println(x);
        return 1;
    }

    public static void main(String args[]){
        try1(5);
    }
}
