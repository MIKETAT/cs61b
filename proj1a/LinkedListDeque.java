public class LinkedListDeque<T> {
    /* 结点类的定义 */ 
    public class TNode {
        T item;
        TNode next;
        TNode prev;
        /* constructor function */
        public TNode(T items) {
            item = items;
            next = null;
            prev = null;
        }
        public  TNode() {
            next = null;
            prev = null;
        }
    }

    /* member of LinkedListDeque */
    private TNode sentinel;     /* 哨兵  circular sentinel  topology */
    private int size;


    public void addFirst(T item) {
        TNode p = new TNode(item);
        p.next = sentinel.next;  
        p.next.prev = p;
        sentinel.next = p;
        p.prev = sentinel;
        size += 1;
    }

    public void addLast(T item) {
        TNode p = new TNode(item);
        p.prev = sentinel.next.prev;
        sentinel.next.prev.next = p;
        p.next = sentinel.next;
        sentinel.next.prev = p;
        size += 1;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode p = sentinel.next;
        int index = 0;
        while(index < size) {
            System.out.print(p.item);
            p = p.next;
            index += 1;
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T items = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return items;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T items = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return items;
    }

    public T get(int index) {
        int k = 0;
        TNode p = sentinel.next;
        while(k < index && k < size) {
            p = p.next;
            k += 1;
        }
        if(k != index) {
            return null;
        }
        return p.item;
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new TNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(LinkedListDeque other) {
        size = other.size;
        T items;
        TNode p = other.sentinel;
        sentinel = new TNode(p.item);
        p = p.next;
        int index = 0;
        while(index < size) {
            this.addFirst(p.item);
            p = p.next;
            index += 1;
        }
    }

    // helper function
    public T helpGetRecursive(TNode p, int index) {
        if(index >= size) {
            return null;
        }
        if(index == 0) {
            return p.item;
        }
        //recursion
        return helpGetRecursive(p.next,index - 1 );
    }
    public T getRecursive(int index) {
        TNode p = sentinel.next;
        return helpGetRecursive(p,index);
    }
}