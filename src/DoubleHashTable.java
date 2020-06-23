import java.util.Random;

public class DoubleHashTable extends OAHashTable {

    private final ModHash modhash1;
    private final ModHash modhash2;
    private int m;

    public DoubleHashTable(int m, long p) {
        super(m);
        this.m = m;
        this.modhash1 = ModHash.GetFunc(m, p); //Chooses two hash functions independently
        this.modhash2 = ModHash.GetFunc(m - 1, p);
    }

    // Return ith table index in probing sequence
	// index depends on both hash functions
    @Override
    public int Hash(long x, int i) {
        return Math.floorMod(modhash1.Hash(x) + i * (modhash2.Hash(x) + 1), m);
    }

}
