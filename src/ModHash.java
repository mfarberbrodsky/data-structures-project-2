import java.util.Random;

public class ModHash {
    private final int m;
    private final long p;
    private final long a;
    private final long b;

    private ModHash(int m, long p, long a, long b) {
        this.m = m;
        this.p = p;
        this.a = a;
        this.b = b;
    }

    public static ModHash GetFunc(int m, long p) {
        // We will maybe have to change this,
        // not sure if this is the best way to generate random long numbers

        Random random = new Random();
        long a = Math.abs(random.nextLong()) % (p - 1) + 1;
        long b = Math.abs(random.nextLong()) % p;
        return new ModHash(m, p, a, b);
    }

    public int Hash(long key) {
        return (int) (((a * key + b) % p) % m);
    }
}
