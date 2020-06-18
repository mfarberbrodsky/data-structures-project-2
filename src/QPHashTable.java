import java.util.Random;

public class QPHashTable extends OAHashTable {
    private final ModHash modhash;
    private final int m;

    public QPHashTable(int m, long p) {
        super(m);
        this.m = m;
        modhash = ModHash.GetFunc(m, p);
    }

    // Return ith table index in probing sequence, where indices increase quadratically
    @Override
    public int Hash(long x, int i) {
        return (modhash.Hash(x) + i * i) % m;
    }
}
