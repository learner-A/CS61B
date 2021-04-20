import javax.swing.plaf.synth.SynthTextAreaUI;

public class ArrayDeque <Item> {
    public int size;
    public Item[] item;
    public int startIndex;
    public int endIndex;

    public ArrayDeque() {
        this.item = (Item[]) new Object[8];
        this.size = 0;
        this.startIndex = 0;
        this.endIndex = this.size;
    }

    private void reSize() {
        Item[] temp;

        if (this.size + 1 > this.item.length) {
            temp = (Item[]) new Object[this.size * 2];
            for (int i = 0; i < this.size; i += 1) {
                temp[i] = this.item[(i + this.startIndex) % this.item.length];
            }
        } else {
            temp = (Item[]) new Object[this.item.length / 2];
            for (int i = 0; i < this.size; i += 1) {
                temp[i] = this.item[(i + this.startIndex) % this.item.length];
            }
        }

        this.item = temp;
        this.startIndex = 0;
        this.endIndex = this.size;
    }

    public void addFirst(Item i) {
        if (this.size + 1 > this.item.length) {
            this.reSize();
        }

        this.startIndex = (this.startIndex + this.item.length - 1) % this.item.length;
        this.item[startIndex] = i;
        this.size += 1;
    }

    public void addLast(Item i) {
        if (this.size + 1 > this.item.length) {
            this.reSize();
        }

        this.item[endIndex] = i;
        this.endIndex = (this.endIndex + 1) % this.item.length;
        this.size += 1;
    }

    public Item removeFirst() {
        Item ans = this.item[this.startIndex];
        this.item[this.startIndex] = null;
        this.size -= 1;
        this.startIndex = (this.startIndex + 1) % this.item.length;

        if ((this.size * 4 < this.item.length) && this.item.length > 16) {
            this.reSize();
        }

        return ans;
    }

    public Item removeLast() {
        Item ans = this.item[this.endIndex];
        this.item[this.endIndex] = null;
        this.size -= 1;
        this.endIndex = (this.endIndex + this.item.length - 1) % this.item.length;

        if ((this.size * 4 < this.item.length) && this.item.length > 16) {
            this.reSize();
        }

        return ans;
    }

    public Item get(int i) {
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

    public static void main(String[] args) { }
}
