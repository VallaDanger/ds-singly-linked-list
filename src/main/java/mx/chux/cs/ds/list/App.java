package mx.chux.cs.ds.list;

public class App {
    public static void main( String[] args ) {
        final LinkedList<Integer> list = new LinkedList<>(5);
        
        list.add(1).add(2).add(3);
        System.out.println(list);
        
        final int lastElement = list.pop();
        System.out.println("lastElement: " + lastElement);
        System.out.println(list);
        System.out.println("size: " + list.size());
        
        list.push(4);
        System.out.println(list);
        System.out.println("size: " + list.size());
        
        list.remove(1);
        System.out.println(list);
        System.out.println("size: " + list.size());
        
        list.add(2);
        System.out.println(list);
        System.out.println("size: " + list.size());
        
        list.remove(2);
        System.out.println(list);
        System.out.println("size: " + list.size());
        
        list.remove(4);
        System.out.println(list);
        System.out.println("size: " + list.size());

        list.add(1).add(2).add(3).add(4).add(5);
        System.out.println(list.reverse());
        System.out.println(list.invert());
    }

}
