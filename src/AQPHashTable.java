import java.util.Random;

public class AQPHashTable extends OAHashTable {
    private final ModHash modhash;
    private final int m;

    public AQPHashTable(int m, long p) {
        super(m);
        this.m = m;
        modhash = ModHash.GetFunc(m, p);
    }

    // Return ith table index in probing sequence, where indices increase and decrease (alternating) quadratically
    @Override
    public int Hash(long x, int i) {
        if (i % 2 == 0) {
            return (modhash.Hash(x) + i * i) % m;
        } else {
            // floorMod is used because modhash.Hash(x) - i * i may be negative,
            // and in that case regular modulo produces negative numbers
            return Math.floorMod(modhash.Hash(x) - i * i, m);
        }
    }
}
