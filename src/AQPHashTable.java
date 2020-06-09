import java.util.Random;

public class AQPHashTable extends OAHashTable {
    private final ModHash modhash;
    private final int m;

    public AQPHashTable(int m, long p) {
        super(m);
        this.m = m;
        modhash = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        if (i % 2 == 0) {
            return (modhash.Hash(x) + i * i) % m;
        } else {
            return (modhash.Hash(x) - i * i) % m;
        }
    }
}
