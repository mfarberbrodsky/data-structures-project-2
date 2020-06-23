import java.util.Random;

public class LPHashTable extends OAHashTable {
	
	private final ModHash modhash;
	private int m;
	
	public LPHashTable(int m, long p) {
		super(m);
		this.m = m;
		this.modhash = ModHash.GetFunc(m, p);
	}
	
    // Return ith table index in probing sequence
	// Indexes increase linearly
	@Override
	public int Hash(long x, int i) {
		return ((modhash.Hash(x) + i) % m);
	}
	
}
