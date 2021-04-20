public class ArrayDeque<T> {
    private int size;
    private T[] item;
    private int startIndex;
    private int endIndex;

    public ArrayDeque() {
        this.item = (T[]) new Object[8];
        this.size = 0;
        this.startIndex = 0;
        this.endIndex = 0;
    }

    private void reSize() {
        T[] temp;

        if (this.size + 1 > this.item.length) {
            temp = (T[]) new Object[this.size * 2];
            for (int i = 0; i < this.size; i += 1) {
                temp[i] = this.item[(i + this.startIndex) % this.item.length];
            }
        } else {
            temp = (T[]) new Object[this.item.length / 2];
            for (int i = 0; i < this.size; i += 1) {
                temp[i] = this.item[(i + this.startIndex) % this.item.length];
            }
        }

        this.item = temp;
        this.startIndex = 0;
        this.endIndex = this.size - 1;
    }

    public void addFirst(T i) {
        if (this.size + 1 > this.item.length) {
            this.reSize();
        }

        if (!this.isEmpty()) {
            this.startIndex = (this.startIndex + this.item.length - 1) % this.item.length;
        }
        this.item[startIndex] = i;
        this.size += 1;
    }

    public void addLast(T i) {
        if (this.size + 1 > this.item.length) {
            this.reSize();
        }
        if (!this.isEmpty()) {
            this.endIndex = (this.endIndex + 1) % this.item.length;
        }
        this.item[endIndex] = i;
        this.size += 1;
    }

    public T removeFirst() {
        if (this.size <= 0) {
            return null;
        }

        T ans = this.item[this.startIndex];
        this.item[this.startIndex] = null;
        this.size -= 1;

        if (!this.isEmpty()) {
            this.startIndex = (this.startIndex + 1) % this.item.length;
        }

        if ((this.size * 4 < this.item.length) && this.item.length > 16) {
            this.reSize();
        }

        return ans;
    }

    public T removeLast() {
        if (this.size <= 0) {
            return null;
        }

        T ans = this.item[this.endIndex];
        this.item[this.endIndex] = null;
        this.size -= 1;

        if (!this.isEmpty()) {
            this.endIndex = (this.endIndex + this.item.length - 1) % this.item.length;
        }

        if ((this.size * 4 < this.item.length) && this.item.length > 16) {
            this.reSize();
        }

        return ans;
    }

    public T get(int i) {
        return this.item[(this.startIndex + i) % this.item.length];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void printDeque() {
        for (int i = this.startIndex; i < this.startIndex + this.item.length; i += 1) {
            if (this.item[i % this.item.length] == null) {
                return;
            }
            System.out.print(this.item[i % this.item.length]);
            System.out.print(" ");
        }
    }
}

//    private void print() {
//        for (int i = 0; i < this.item.length; i += 1) {
//            if (this.item[i % this.item.length] == null) {
//                return;
//            }
//            System.out.print(this.item[i]);
//            System.out.print(" ");
//        }
//    }
//
//
//    public static void main(String[] args) {
//        ArrayDeque<Integer> test1 = new ArrayDeque<>();
//        test1.addFirst(3);
//        test1.removeFirst();
//        System.out.println(test1.startIndex);
//        test1.addLast(-1);
//        System.out.println(test1.removeFirst());
//    }
//}
