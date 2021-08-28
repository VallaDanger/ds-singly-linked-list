package mx.chux.cs.ds.list;

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
    
    public LinkedList<E> push(E value) {
        
        if( this.root == null ) {
            return addRoot(value);
        }
        
        if( this.size == this.maxSize ) {
            throw new IllegalStateException("list is full");
        }
        
        final SingleLinkNode<E> root = new SingleLinkNode<>(value);
        
        root.next(this.root);
        this.root = root;
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
    
    public LinkedList<E> remove(E value) {
        
        while( (this.root != null) 
                && this.root.get().equals(value) ) {
            this.root = this.root.next();
            this.size -= 1;
        }
        
        if( this.root == null ) {
            return this;
        }
        
        SingleLinkNode<E> current = this.root;
        
        while( current.next() != null ) {
            
            if( current.next().get().equals(value) ) {
                current.next(current.next().next());
                this.size -= 1;
            } else {
                current = current.next();
            }
            
        }

        return this;
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
    
    public LinkedList<E> reverse() {
        
        if( (this.root == null) || (this.root.next() == null) ) { 
            return this;
        }
        
        // dynamic of inversion is by blocks: 1 , 2 , 3 , 4 , 5
        // A: ( 1 ) , B: ( 2 , 3 , 4 , 5 )
        // ====================================================================
        // A: ( ( 1 ) , 2 ) , 2 -> B: ( 3 , 4 , 5 ) => invert block A
        // A: ( 2 , ( 1 ) ) , B: ( 3 , 4 , 5 )
        // ====================================================================
        // A: ( ( 2 , ( 1 ) ) , 3 ) , 3 -> B: ( 4 , 5 ) => invert block A
        // A: ( 3 , ( 2 , ( 1 ) ) ) , B: ( 4 , 5 )
        // ====================================================================
        // A: ( ( 3 , ( 2 , ( 1 ) ) ) , 4 ) , 4 -> B: ( 5 ) => invert block A
        // A: ( 4 , ( 3 , ( 2 , ( 1 ) ) ) ) , B: ( 5 )
        // ====================================================================
        // A: ( ( 4 , ( 3 , ( 2 , ( 1 ) ) ) ) , 5 ) => invert block A
        // A: ( 5 , ( 4 , ( 3 , ( 2 , ( 1 ) ) ) ) )
        
        // initialize pointers
        SingleLinkNode<E> prev = null;
        SingleLinkNode<E> curr = this.root;
        
        while( curr != null ) {
            // save a reference to 'curr'.next ( prev -> curr -> next ) 
            // 'curr'.next is going to be assigned to to 'prev'
            // effectively, this means save block B
            SingleLinkNode<E> next = curr.next();
            
            // invert block A ( prepend current to previous )
            curr.next(prev);
            
            // shift right by one ( pop one from B )
            prev = curr;
            curr = next;
        }
        
        // root is prev
        //curr is out of bounds
        this.root = prev;
        
        return this;
    }
    
    public LinkedList<E> invert() {
        this.root = invert(null, this.root);
        return this;
    }
    
    private SingleLinkNode<E> invert(SingleLinkNode<E> prev, SingleLinkNode<E> curr) {
        
        if( (curr == null) ) {
            return prev;
        }
        
        // save block B
        SingleLinkNode<E> next = curr.next();
        
        // invert block A
        curr.next(prev);
        
        // / shift right by one ( recurse / pop left most item from B )
        return invert(curr, next);
    }
    
    @Override
    public String toString() {
        
        if( this.size == 0 || this.root == null ) {
            return "{ }";
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

