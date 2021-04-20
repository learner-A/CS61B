public class LinkedListDeque<T> {
    private class node {
        T item;
        node next;
        node prev;

        public node(T i, node n, node p) {
            this.item = i;
            this.next = n;
            this.prev = p;
        }
    }

    private int size;
    private node sentinelFront;
    private node sentinelEnd;

    public LinkedListDeque() {
        sentinelFront = new node(null, null, null);
        sentinelEnd = new node(null, null, null);

        sentinelFront.next = sentinelEnd;
        sentinelEnd.prev = sentinelFront;
        this.size = 0;
    }

    public LinkedListDeque(T i) {
        sentinelFront = new node(null, null, null);
        sentinelEnd = new node(null, null, null);
        node temp = new node(i, sentinelEnd, sentinelFront);

        sentinelFront.next = temp;
        sentinelEnd.prev = temp;
        this.size = 1;
    }

    public void addFirst(T i) {
        node temp = new node(i, sentinelFront.next, sentinelFront);
        sentinelFront.next.prev = temp;
        sentinelFront.next = temp;

        this.size += 1;
    }

    public void addLast(T i) {
        node temp = new node(i, sentinelEnd, sentinelEnd.prev);
        sentinelEnd.prev.next = temp;
        sentinelEnd.prev = temp;

        this.size += 1;
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Empty");
            return null;
        }

        node ans = this.sentinelFront.next;
        node temp = this.sentinelFront.next.next;
        this.sentinelFront.next = temp;
        temp.prev = sentinelFront;

        this.size -= 1;
        return ans.item;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            System.out.println("Empty");
            return null;
        }

        node ans = this.sentinelEnd.prev;
        node temp = this.sentinelEnd.prev.prev;
        this.sentinelEnd.prev = temp;
        temp.next = sentinelEnd;

        this.size -= 1;
        return ans.item;
    }

    public T get(int n) {
        if ((n > this.size() - 1) || (n < 0)) {
            System.out.println("Error: Out of Bound.");
            return null;
        }

        node p = this.sentinelFront.next;

        for (int i = 0; i < n; i += 1) {
            p = p.next;
        }

        return p.item;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void printDeque() {
        node p = this.sentinelFront.next;
        while (p.item != null) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    public static void main(String[] args) {

    }
}
