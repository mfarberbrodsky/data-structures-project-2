import java.util.concurrent.ThreadLocalRandom;

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

    // Returns a random modular hash function, with parameters m (range size) and p (large prime).
    // Complexity: O(1)
    public static ModHash GetFunc(int m, long p) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        long a = random.nextLong(1, p);
        long b = random.nextLong(0, p);
        return new ModHash(m, p, a, b);
    }

    // Computes the hash function on a key.
    // Complexity: O(1)
    public int Hash(long key) {
        return (int) (((a * key + b) % p) % m);
    }
}
