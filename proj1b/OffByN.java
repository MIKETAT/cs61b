public class OffByN implements CharacterComparator{
    int n;
    public OffByN(int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == n || y -  x == n) {
            return true;
        } else {
            return false;
        }
    }
}
