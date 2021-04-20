public class LinkedListDeque<T> {
    private class Node {
        T item;
        Node next;
        Node prev;

        public Node(T i, Node n, Node p) {
            this.item = i;
            this.next = n;
            this.prev = p;
        }

        private T getRecursiveHelper(int i) {
            if (i == 0) {
                return this.item;
            }

            return this.next.getRecursiveHelper(i - 1);
        }
    }

    private int size;
    private Node sentinelFront;
    private Node sentinelEnd;

    public LinkedListDeque() {
        sentinelFront = new Node(null, null, null);
        sentinelEnd = new Node(null, null, null);

        sentinelFront.next = sentinelEnd;
        sentinelEnd.prev = sentinelFront;
        this.size = 0;
    }

//    public LinkedListDeque(T i) {
//        sentinelFront = new Node(null, null, null);
//        sentinelEnd = new Node(null, null, null);
//        Node temp = new Node(i, sentinelEnd, sentinelFront);
//
//        sentinelFront.next = temp;
//        sentinelEnd.prev = temp;
//        this.size = 1;
//    }

    public void addFirst(T i) {
        Node temp = new Node(i, sentinelFront.next, sentinelFront);
        sentinelFront.next.prev = temp;
        sentinelFront.next = temp;

        this.size += 1;
    }

    public void addLast(T i) {
        Node temp = new Node(i, sentinelEnd, sentinelEnd.prev);
        sentinelEnd.prev.next = temp;
        sentinelEnd.prev = temp;

        this.size += 1;
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        Node ans = this.sentinelFront.next;
        Node temp = this.sentinelFront.next.next;
        this.sentinelFront.next = temp;
        temp.prev = sentinelFront;

        this.size -= 1;
        return ans.item;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        Node ans = this.sentinelEnd.prev;
        Node temp = this.sentinelEnd.prev.prev;
        this.sentinelEnd.prev = temp;
        temp.next = sentinelEnd;

        this.size -= 1;
        return ans.item;
    }

    public T get(int n) {
        if ((n > this.size() - 1) || (n < 0)) {
            return null;
        }

        Node p = this.sentinelFront.next;

        for (int i = 0; i < n; i += 1) {
            p = p.next;
        }

        return p.item;
    }

    public T getRecursive(int n) {
        if ((n > this.size() - 1) || (n < 0)) {
            return null;
        }
        return this.sentinelFront.next.getRecursiveHelper(n);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void printDeque() {
        Node p = this.sentinelFront.next;
        while (p.item != null) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }
}

