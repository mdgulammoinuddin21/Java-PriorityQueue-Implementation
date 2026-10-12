import java.util.Comparator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class PriorityQueue<E> implements Queue<E> {
    private int capacity;
    private E[] arr;
    private int size;
    private Comparator<E> comparator;
    
    
    
    public PriorityQueue(int capacity) {
        this.size = 0;
        this.capacity = Math.max(capacity, 16);
        this.arr = (E[]) new Object[this.capacity];
    }
    
    public PriorityQueue() {
        this(16);
    }
    
    public PriorityQueue(int capacity, Comparator<E> comparator) {
        this(capacity);
        this.comparator = comparator;
    }
    
    private void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    private void createNewArray() {
        capacity = capacity * 2;
        E[] newArr = (E[]) new Object[capacity];
        for(int i=0;i<arr.length;i++) {
          newArr[i] = arr[i];
        }
        
        arr = newArr;      
    }
    
    @Override
    public boolean offer(E elem) {
        if(comparator == null && !(elem instanceof Comparable)) {
          throw new ClassCastException("Can't add an element of type:" + elem.getClass().getName());
        }
        if(size == arr.length) {
          createNewArray();
        }
        arr[size] = elem;
        int index = size;
        size++;
        
        try {
          while(index > 0 && compare(arr[index], arr[(index - 1)/2]) < 0) {
            swap(arr, index, (index - 1)/2);
            index = (index - 1)/2;
          }
        }
        catch(Exception e) {
          size--;
          throw e;
        }
        
        
        return true;
    }
    
    private int compare(E e1, E e2) {
        if(comparator != null)
            return comparator.compare(e1,e2);
        
        return ((Comparable<E>)e1).compareTo(e2);
    }
        
    @Override
    public E element() {
        if(size == 0) {
            throw new NoSuchElementException("PriorityQueue is Empty");
        }
        return arr[0];
    }
        
    @Override
    public E peek() {
        if(size == 0)
            return null;
        
        return arr[0];
    }
    
    @Override
    public E poll() {
        if(size == 0)
            return null;
        
        E elem = arr[0];
        arr[0] = arr[size-1];
        arr[size - 1] = null;
        size--;
        
        if(size != 0) {
            heapify(0);
        }
        
        return elem;
    
    }
    
    private void heapify(int index) {
        int priority = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        
        if(left < size && compare(arr[left], arr[priority]) < 0)
        priority = left;
        
        if(right < size && compare(arr[right], arr[priority]) < 0)
        priority = right;
        
        if(priority != index) {
            swap(arr, priority, index);
            heapify(priority);
        }
    }
    
    @Override
    public E remove() {
        if(size == 0) {
            throw new NoSuchElementException("PriorityQueue is Empty");
        }
        
        return poll();
    }

    @Override
    public String toString() {
        if(isEmpty())
            return "[]";

        StringBuilder sb = new StringBuilder("[");

        for(int i=0;i<size;i++) {
            sb.append(arr[i] + ", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append("]");

        return sb.toString();
    }

    @Override
    public void clear() {
        for(int i=0;i<size;i++) {
            arr[i] = null;
        }
        size = 0;
    }


}