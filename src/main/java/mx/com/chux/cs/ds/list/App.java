package mx.com.chux.cs.ds.list;

public class App {
    public static void main( String[] args ) {
        final LinkedList<Integer> list = new LinkedList<>(3);
        list.add(1).add(2).add(3);
        System.out.println(list);
        final int lastElement = list.pop();
        System.out.println(lastElement);
        System.out.println(list);
    }

}
