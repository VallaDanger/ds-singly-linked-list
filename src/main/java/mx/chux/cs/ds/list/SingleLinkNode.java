package mx.chux.cs.ds.list;

public class SingleLinkNode<E> extends Node<E> {

    private SingleLinkNode<E> next;
    
    SingleLinkNode(E value) {
        super(value);
    }
    
    public SingleLinkNode<E> next() {
        return this.next;
    }
    
    SingleLinkNode<E> next(E next) {
        return this.next(new SingleLinkNode<E>(next));
    }
    
    SingleLinkNode<E> next(SingleLinkNode<E> next) {
        this.next = next;
        return this;
    }

    SingleLinkNode<E> disconnect() {
        final SingleLinkNode<E> next = this.next;
        this.next = null;
        return next;
    }
    
}
