public interface Deque<T> {
    void addFirst(T i);
    void addLast(T i);
    T removeFirst();
    T removeLast();
    T get(int n);
    int size();
    boolean isEmpty();
    void printDeque();
}
