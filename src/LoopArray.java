public class LoopArray<E> {
    private static final int DEFAULT_INSTANCE = 10;

    private int front;
    private int tail;
    private int size;
    private E[] array;

    public LoopArray() {
        this(DEFAULT_INSTANCE);
    }

    public LoopArray(int capacity) {
        front = 0;
        tail = 0;
        size = 0;
        array = (E[]) new Object[capacity];
    }

    public void offer(E e) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        int newIdx = tail % array.length;
        array[newIdx] = e;
        tail++;
        size++;
    }


    public E poll() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        size--;
        return array[front++];
    }

    public E peek() {
        return array[front];
    }

    public int size() {
        System.out.println("Size: " + size);
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//    private boolean isFull() {}
//
//    private void doEmptyCheck() {}

    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(array[(i + front) % array.length]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        LoopArray<Integer> array = new LoopArray<>(2);
        array.offer(0);
        array.offer(0);
        array.offer(1);
        array.offer(2);
        array.offer(3);
        array.offer(4);
        array.poll();
        array.print();
        array.size();

        array.poll();
        array.offer(5);
        array.poll();
        array.offer(6);
        array.poll();
        array.print();
        array.size();
    }
}
