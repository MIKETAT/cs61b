public class ArrayDeque<T> {
    /* array */
    private T[] array = (T []) new Object[8];
    private int nextFirst;
    private int nextLast;
    private int size;
    private int length;
    public static int REFACTOR = 2;

    /* methods */
    /* 
        flag == true  -> augment 
        flag == false -> shrink
    */
    public void resize(boolean flag) {
        if(flag == true) {
            T[] newArray = (T []) new Object[length * REFACTOR];
            System.arraycopy(array,0,newArray,0,length);
            length = length * REFACTOR;
        }
        /* shrink */
        else {
            T[] newArray = (T []) new Object[length / REFACTOR];
            if(nextFirst < nextLast) {
                System.arraycopy(array,nextFirst + 1,newArray,1,size);
            }else {
                int index = (nextFirst + 1) % length;
                for(int i = 1;i <= size; i++) {
                    newArray[i] = array[index];
                    index = (index + 1) % length;
                }
            }
            nextFirst = 0;
            nextLast = size + 1;
            length = length / REFACTOR;
        }
    }

    public void addFirst(T item) {
        if(size == length) {
            resize(true);
        }
        array[nextFirst] = item;
        nextFirst = (nextFirst - 1 + length) % length;
        size += 1;
    }

    public void addLast(T item) {
        if(size == length) {
            resize(true);
        }
        array[nextLast] = item;
        nextLast = (nextLast + 1) % length;
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
        int index = (nextFirst + 1) % length;
        while((index + 1) % length != nextLast) {
            System.out.print(array[index]);
            index = (index + 1) % length;
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        T items = array[(nextFirst + 1) % length];
        nextFirst = (nextFirst + 1) % length;
        size -= 1;
        if(size >= 16 && size < length / 4) {
            resize(false);
        }
        return items;
    }

    public T removeLast() {
        T items = array[(nextLast - 1) % length];
        nextLast = (nextLast - 1) % length;
        size -= 1;
        if(size >= 16 && size < length / 4) {
            resize(false);
        }
        return items;
    }

    public T get(int index) {
        T items = array[(nextFirst + 1 + index) % length];
        return items;
    }

    public ArrayDeque() {
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque<T> other) {
        size = other.size;
        length = other.length;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;  
        int index = (nextFirst + 1) % length;
        for(int i = 0; i < size; i++ ) {
            array[index] = other.array[index];
            index = (index + 1) % length;
        }
    }
}