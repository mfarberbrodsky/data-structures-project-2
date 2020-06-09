import java.util.Random;

public class QPHashTable extends OAHashTable {
    private final ModHash modhash;
    private final int m;

    public QPHashTable(int m, long p) {
        super(m);
        this.m = m;
        modhash = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        return (modhash.Hash(x) + i * i) % m;
    }
}
