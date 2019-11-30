package listimplmy;

public class ArrayList1<T> implements IList<T> {

    private T[] array;
    private final int incrValue = 1;
    private int size = 0;

    public ArrayList1() {
        array = (T[]) new Object[incrValue];
    }

    public ArrayList1(int startLength) {
        array = (T[]) new Object[startLength];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) {
        if (array.length == size)
            extendTable();
        array[size++] = value;
    }

    private void extendTable() {
        T[] tmp = (T[]) new Object[array.length + incrValue];
        for (int i = 0; i < array.length; ++i)
            tmp[i] = array[i];
        array = tmp;
    }

    @Override
    public void add(T value, int index) {
        checkInsertBounds(index);
        if (index == size) {
            add(value);
            return;
        }
        if (array.length == size)
            extendTable();
        T[] tmp = (T[]) new Object[array.length];
        for (int i = 0; i < index; i++)
            tmp[i] = array[i];
        tmp[index] = value;
        for (int i = index; i < size; i++)
            tmp[i + 1] = array[i];
        array = tmp;
        size++;

    }

    private void checkInsertBounds(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

    private void checkGetBounds(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public T get(int index) {
        checkGetBounds(index);
        return array[index];
    }


    @Override
    public void set(T value, int index) {
        checkGetBounds(index);
        array[index] = value;
    }

    @Override
    public void remove(int index) {
        checkGetBounds(index);
        T[] tmp = (T[]) new Object[array.length];
        for (int i = 0; i < index; i++)
            tmp[i] = array[i];
        for (int i = index + 1; i < size; i++)
            tmp[i - 1] = array[i];
        array = tmp;
        size--;

    }
}

