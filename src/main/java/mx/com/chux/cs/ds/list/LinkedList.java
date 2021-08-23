package mx.com.chux.cs.ds.list;

public class LinkedList<E> {
    
    private final int maxSize;
    
    private SingleLinkNode<E> root;
    private int size;
    
    protected LinkedList() {
        this(Integer.MAX_VALUE);
    }

    protected LinkedList(int maxSize) {
        
        if( maxSize <= 0 ) {
            throw new IllegalArgumentException("max-size must be greater than 0");
        }
        
        this.maxSize = maxSize;
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public LinkedList<E> add(E value) {
        if( this.root == null ) {
            return addRoot(value);
        }
        
        if( this.size == this.maxSize ) {
            throw new IllegalStateException("list is full");
        }
        
        SingleLinkNode<E> current = this.root;
        
        while( current.next() != null ) {
            current = current.next();
        }
        
        current.next(value);
        
        this.size += 1;
        
        return this;
    }

    public E pop() {
        
        if( this.root == null ) {
            return null;
        }

        if( this.root.next() == null ) {
            return this.popRoot();
        }

        SingleLinkNode<E> current = this.root;

        while( current.next().next() != null ) {
            current = current.next();
        }

        final SingleLinkNode<E> next = current.disconnect();

        this.size -= 1;

        return next.get();
    }
    
    private final LinkedList<E> addRoot(E value) {
        this.root = new SingleLinkNode<>(value);
        this.size += 1;
        return this;
    }

    private E popRoot() {
        final E value = this.root.get();
        this.root = null;
        this.size -= 1;
        return value;
    }
    
    @Override
    public String toString() {
        if( this.size == 0 || this.root == null ) {
            return "";
        }
        
        final StringBuilder list = new StringBuilder("{ ");
        
        list.append(this.root.toString());
        
        SingleLinkNode<E> current = this.root.next();
        
        while( current != null ) {
            list.append(", ").append(current.toString());
            current = current.next();
        }
        
        list.append(" }");
        
        return list.toString();
    }

}

