public class ArrayDeque<T> {
    /* array */
    private T[] array = (T []) new Object[8];
    private int nextFirst;
    private int nextLast;
    private int size;
    private int length;
    private static int REFACTOR = 2;

    /* methods */
    /* 
        flag == true  -> augment 
        flag == false -> shrink
    */
    private void resize(boolean flag) {
        if (flag) {
            T[] newArray = (T []) new Object[length * REFACTOR];
            int index = (nextFirst + 1) % length;
            int newArrayIndex = 0;
            while (index != nextLast) {
                newArray[newArrayIndex] = array[index];
                index = (index + 1) % length;
                newArrayIndex += 1;
            }
            length = length * REFACTOR;
            nextFirst = length - 1;
            nextLast = newArrayIndex;
            array = newArray;
        } else {    /* shrink */
            T[] newArray = (T []) new Object[length / REFACTOR];
            int index = (nextFirst + 1) % length;
            for (int i = 0; i < size; i++) {
                newArray[i] = array[index];
                index = (index + 1) % length;
            }
            length = length / REFACTOR;
            nextFirst = length - 1;
            nextLast = size;
            array = newArray;
        }
    }

    public void addFirst(T item) {
        if (size + 1 == length) {
            resize(true);
        }
        array[nextFirst] = item;
        nextFirst = (nextFirst - 1 + length) % length;
        if (nextFirst == nextLast) {
            resize(true);
        }

        size += 1;
    }

    public void addLast(T item) {
        if (size + 1 == length) {
            resize(true);
        }
        array[nextLast] = item;
        nextLast = (nextLast + 1) % length;
        if ((nextLast + 1) % length == nextFirst) {
            resize(true);
        }
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }    

    public int size() {
        return size;
    }

    public void printDeque() {
        int index = (nextFirst + 1) % length;
        while (index != nextLast) {
            System.out.print(array[index]);
            index = (index + 1) % length;
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T items = array[(nextFirst + 1) % length];
        nextFirst = (nextFirst + 1) % length;
        size -= 1;
        if (length >= 16 && size < length / 4) {
            resize(false);
        }
        return items;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T items = array[(nextLast - 1 + length) % length];
        nextLast = (nextLast - 1 + length) % length;
        size -= 1;
        if (length >= 16 && size < length / 4) {
            resize(false);
        }
        return items;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        T items = array[(nextFirst + 1 + index) % length];
        return items;
    }

    public ArrayDeque() {
        size = 0;
        length = 8;     //default
        nextFirst = 0;
        nextLast = 1;
    }
}
