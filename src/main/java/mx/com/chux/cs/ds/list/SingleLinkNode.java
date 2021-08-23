package mx.com.chux.cs.ds.list;

public class SingleLinkNode<E> extends Node<E> {

    private SingleLinkNode<E> next;
    
    SingleLinkNode(E value) {
        super(value);
    }
    
    SingleLinkNode<E> next() {
        return this.next;
    }
    
    SingleLinkNode<E> next(E next) {
        return this.next(new SingleLinkNode<E>(next));
    }
    
    SingleLinkNode<E> next(SingleLinkNode<E> next) {
        this.next = next;
        return this;
    }
    
}
