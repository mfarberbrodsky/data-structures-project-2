import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	
	private final ModHash modhash1;
	private final ModHash modhash2;
	private int m;
	
	public DoubleHashTable(int m, long p) {
		super(m);
		this.m = m;
		this.modhash1 = ModHash.GetFunc(m, p);
		this.modhash2 = ModHash.GetFunc(m, p);
		
	}
	
	@Override
	public int Hash(long x, int i) {
		return ((modhash1.Hash(x) + i*modhash2.Hash(x)) % m);
	}
	
}
