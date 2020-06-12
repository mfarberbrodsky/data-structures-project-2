public class Q4 {
    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        int m = 10000019;
        long p = 1000000007;
        int n;

        // Part A
        System.out.println("Starting part A.");
        n = m / 2;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i);
            measureAll(m, p, n, true);
            System.out.println();
        }

        // Part B
        n = (19 * m) / 20;
        System.out.println("Starting part B.");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i);
            measureAll(m, p, n, false);
            System.out.println();
        }

        // Results (measured 5 times for each experiment for averaging)
        // should probably ignore the first one because of "load-up" time

        //Starting part A.
        //Iteration 1
        //Time linear probing: 1345
        //Time quadratic probing: 895
        //Time alternating quadratic probing: 1372
        //Time double hashing: 1912
        //
        //Iteration 2
        //Time linear probing: 1244
        //Time quadratic probing: 1214
        //Time alternating quadratic probing: 1247
        //Time double hashing: 1811
        //
        //Iteration 3
        //Time linear probing: 2176
        //Time quadratic probing: 1218
        //Time alternating quadratic probing: 1255
        //Time double hashing: 1816
        //
        //Iteration 4
        //Time linear probing: 1244
        //Time quadratic probing: 1336
        //Time alternating quadratic probing: 1401
        //Time double hashing: 1688
        //
        //Iteration 5
        //Time linear probing: 1232
        //Time quadratic probing: 1392
        //Time alternating quadratic probing: 1190
        //Time double hashing: 1769
        //
        //Starting part B.
        //Iteration 1
        //Time linear probing: 8839
        //Time alternating quadratic probing: 6124
        //Time double hashing: 9334
        //
        //Iteration 2
        //Time linear probing: 11139
        //Time alternating quadratic probing: 6240
        //Time double hashing: 9307
        //
        //Iteration 3
        //Time linear probing: 11998
        //Time alternating quadratic probing: 5691
        //Time double hashing: 8782
        //
        //Iteration 4
        //Time linear probing: 10577
        //Time alternating quadratic probing: 6181
        //Time double hashing: 9307
        //
        //Iteration 5
        //Time linear probing: 9537
        //Time alternating quadratic probing: 6048
        //Time double hashing: 9180

        // Average result (ignoring first one in each):

        // Part A
        // Time linear probing: 1474ms
        // Time quadratic probing: 1290ms
        // Time alternating quadratic probing: 1273ms
        // Time double hashing: 1771ms

        // Part B
        // Time linear probing: 10813ms
        // Time alternating quadratic probing: 6040ms
        // Time double hashing: 9144ms
    }

    public static void measureAll(int m, long p, int n, boolean doQP) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        IHashTable table;

        table = new LPHashTable(m, p);
        long timeLP = measure(table, n);
        System.out.println("Time linear probing: " + timeLP);

        if (doQP) {
            table = new QPHashTable(m, p);
            long timeQP = measure(table, n);
            System.out.println("Time quadratic probing: " + timeQP);
        }

        table = new AQPHashTable(m, p);
        long timeAQP = measure(table, n);
        System.out.println("Time alternating quadratic probing: " + timeAQP);

        table = new DoubleHashTable(m, p);
        long timeDoubleHash = measure(table, n);
        System.out.println("Time double hashing: " + timeDoubleHash);
    }

    public static long measure(IHashTable table, int n) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        long[] a = new long[n];

        long timeStart = System.currentTimeMillis();

        // Generate sequence
        for (int i = 0; i < n; i++) {
            a[i] = 100 * i + (int) (Math.random() * 100);
        }

        // Insert sequence
        for (int i = 0; i < n; i++) {
            HashTableElement elem = new HashTableElement(a[i], a[i]);
            table.Insert(elem);
        }

        long timeEnd = System.currentTimeMillis();

        return timeEnd - timeStart;
    }
}
