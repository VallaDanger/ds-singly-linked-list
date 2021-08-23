package mx.com.chux.cs.ds.list;

import java.util.function.Supplier;

public abstract class Node<E> implements Supplier<E> {

    protected E value;
    
    protected Node(E value) {
        this.value = value;
    }
    
    @Override
    public E get() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
    
}
