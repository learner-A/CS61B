public class OffByN implements CharacterComparator{
    public int n;

    public OffByN(int i) {
        this.n = i;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return ((x - y) * (x - y) == (this.n * this.n));
    }
}

