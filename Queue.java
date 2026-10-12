public interface Queue<E> {
    boolean offer(E elem);
    E element();
    E peek();
    E poll();
    E remove();
    boolean isEmpty();
    int size();
    void clear();
}