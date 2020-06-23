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
        ///usr/lib/jvm/jdk1.8.0_251/bin/java -javaagent:/home/maya/.local/share/JetBrains/Toolbox/apps/IDEA-U/ch-0/201.7223.91/lib/idea_rt.jar=35531:/home/maya/.local/share/JetBrains/Toolbox/apps/IDEA-U/ch-0/201.7223.91/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/jdk1.8.0_251/jre/lib/charsets.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/deploy.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/dnsns.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/jaccess.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/jfxrt.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/localedata.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/nashorn.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/sunec.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/ext/zipfs.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/javaws.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/jce.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/jfr.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/jfxswt.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/jsse.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/management-agent.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/plugin.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/resources.jar:/usr/lib/jvm/jdk1.8.0_251/jre/lib/rt.jar:/home/maya/IdeaProjects/data-structures-project-2/out/production/data-structures-project-2 Q4
        //Starting part A.
        //Iteration 1
        //Time linear probing: 1412
        //Time quadratic probing: 1035
        //Time alternating quadratic probing: 1620
        //Time double hashing: 2177
        //
        //Iteration 2
        //Time linear probing: 1439
        //Time quadratic probing: 1418
        //Time alternating quadratic probing: 1471
        //Time double hashing: 2034
        //
        //Iteration 3
        //Time linear probing: 1625
        //Time quadratic probing: 2609
        //Time alternating quadratic probing: 1431
        //Time double hashing: 1928
        //
        //Iteration 4
        //Time linear probing: 1560
        //Time quadratic probing: 1429
        //Time alternating quadratic probing: 1459
        //Time double hashing: 2039
        //
        //Iteration 5
        //Time linear probing: 1433
        //Time quadratic probing: 1388
        //Time alternating quadratic probing: 1510
        //Time double hashing: 1865
        //
        //Starting part B.
        //Iteration 1
        //Time linear probing: 14101
        //Time alternating quadratic probing: 6946
        //Time double hashing: 10649
        //
        //Iteration 2
        //Time linear probing: 12774
        //Time alternating quadratic probing: 6937
        //Time double hashing: 10616
        //
        //Iteration 3
        //Time linear probing: 14733
        //Time alternating quadratic probing: 6874
        //Time double hashing: 10776
        //
        //Iteration 4
        //Time linear probing: 10692
        //Time alternating quadratic probing: 6808
        //Time double hashing: 10683
        //
        //Iteration 5
        //Time linear probing: 12804
        //Time alternating quadratic probing: 6813
        //Time double hashing: 10499
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
            a[i] = 100L * (long)i + (long) (Math.random() * 100);
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
