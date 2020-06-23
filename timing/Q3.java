public class Q3 {

    static double avg = 0;

    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        //partA();

        for (int i = 0; i < 100; i++) {
            System.out.println("Iteration " + i);
            partB();
        }
        avg = avg / 100;

        System.out.println("Avg number of Exceptions: " + avg);

        // Results:
        //Iteration 0
        //Iteration 1
        //Table is full: 6570
        //Iteration 2
        //Iteration 3
        //Iteration 4
        //Table is full: 6570
        //Iteration 5
        //Iteration 6
        //Table is full: 6569
        //Table is full: 6570
        //Iteration 7
        //Iteration 8
        //Table is full: 6565
        //Table is full: 6569
        //Iteration 9
        //Table is full: 6568
        //Table is full: 6570
        //Iteration 10
        //Table is full: 6570
        //Iteration 11
        //Table is full: 6570
        //Iteration 12
        //Table is full: 6568
        //Table is full: 6570
        //Iteration 13
        //Iteration 14
        //Table is full: 6569
        //Table is full: 6570
        //Iteration 15
        //Table is full: 6570
        //Iteration 16
        //Table is full: 6569
        //Table is full: 6570
        //Iteration 17
        //Table is full: 6570
        //Iteration 18
        //Table is full: 6568
        //Iteration 19
        //Table is full: 6568
        //Iteration 20
        //Table is full: 6569
        //Iteration 21
        //Table is full: 6569
        //Iteration 22
        //Iteration 23
        //Table is full: 6570
        //Iteration 24
        //Table is full: 6570
        //Iteration 25
        //Table is full: 6570
        //Iteration 26
        //Table is full: 6566
        //Table is full: 6570
        //Iteration 27
        //Table is full: 6569
        //Iteration 28
        //Table is full: 6570
        //Iteration 29
        //Table is full: 6568
        //Table is full: 6569
        //Iteration 30
        //Table is full: 6564
        //Iteration 31
        //Iteration 32
        //Table is full: 6570
        //Iteration 33
        //Iteration 34
        //Table is full: 6569
        //Table is full: 6570
        //Iteration 35
        //Iteration 36
        //Iteration 37
        //Table is full: 6568
        //Iteration 38
        //Table is full: 6570
        //Iteration 39
        //Table is full: 6567
        //Iteration 40
        //Iteration 41
        //Iteration 42
        //Table is full: 6566
        //Table is full: 6570
        //Iteration 43
        //Iteration 44
        //Iteration 45
        //Table is full: 6567
        //Iteration 46
        //Table is full: 6569
        //Iteration 47
        //Table is full: 6570
        //Iteration 48
        //Iteration 49
        //Iteration 50
        //Iteration 51
        //Table is full: 6569
        //Table is full: 6570
        //Iteration 52
        //Table is full: 6569
        //Table is full: 6570
        //Iteration 53
        //Table is full: 6570
        //Iteration 54
        //Iteration 55
        //Table is full: 6568
        //Iteration 56
        //Iteration 57
        //Iteration 58
        //Table is full: 6568
        //Table is full: 6570
        //Iteration 59
        //Table is full: 6568
        //Iteration 60
        //Table is full: 6569
        //Table is full: 6570
        //Iteration 61
        //Table is full: 6568
        //Iteration 62
        //Table is full: 6568
        //Table is full: 6570
        //Iteration 63
        //Table is full: 6566
        //Iteration 64
        //Iteration 65
        //Iteration 66
        //Table is full: 6567
        //Iteration 67
        //Iteration 68
        //Table is full: 6570
        //Iteration 69
        //Table is full: 6568
        //Table is full: 6570
        //Iteration 70
        //Table is full: 6568
        //Iteration 71
        //Table is full: 6570
        //Iteration 72
        //Table is full: 6569
        //Table is full: 6570
        //Iteration 73
        //Iteration 74
        //Table is full: 6570
        //Iteration 75
        //Table is full: 6568
        //Iteration 76
        //Table is full: 6570
        //Iteration 77
        //Table is full: 6569
        //Iteration 78
        //Table is full: 6570
        //Iteration 79
        //Table is full: 6569
        //Iteration 80
        //Table is full: 6567
        //Table is full: 6568
        //Table is full: 6570
        //Iteration 81
        //Iteration 82
        //Table is full: 6570
        //Iteration 83
        //Iteration 84
        //Iteration 85
        //Iteration 86
        //Table is full: 6569
        //Iteration 87
        //Table is full: 6567
        //Iteration 88
        //Table is full: 6570
        //Iteration 89
        //Iteration 90
        //Iteration 91
        //Table is full: 6570
        //Iteration 92
        //Table is full: 6569
        //Iteration 93
        //Iteration 94
        //Table is full: 6568
        //Iteration 95
        //Table is full: 6570
        //Iteration 96
        //Table is full: 6570
        //Iteration 97
        //Table is full: 6568
        //Iteration 98
        //Table is full: 6569
        //Table is full: 6570
        //Iteration 99
        //Table is full: 6569
        //Table is full: 6570
        //Avg number of Exceptions: 0.89
    }


    public static void partA() {

        System.out.println("Starting part A");

        int[] cntA = new int[6571];
        for (int i = 0; i < 6571; i++) {
            cntA[(i * i % 6571)]++;
        }

        int cnt = 0;
        for (int i = 0; i < 6571; i++) {
            if (cntA[i] != 0)
                cnt++;
        }

        System.out.println("Size of Q1: " + cnt);

        int[] cntB = new int[6571];
        for (int i = 0; i < 6571; i++) {
            if (i % 2 == 0) {
                cntB[(i * i % 6571)]++;
            } else {
                cntB[Math.floorMod(-i * i, 6571)]++;
            }
        }

        cnt = 0;
        for (int i = 0; i < 6571; i++) {
            if (cntB[i] != 0)
                cnt++;
        }

        System.out.println("Size of Q2: " + cnt);

    }

    public static void partB() {

        int m = 6571;
        long p = 1000000007;
        IHashTable table = new QPHashTable(m, p);

        int a;
        int b;

        for (int i = 0; i < m; i++) {
            b = (int) (Math.random() * 100);
            a = 100 * i + b;

            try {
                table.Insert(new HashTableElement(a, a));
            } catch (IHashTable.TableIsFullException E1) {
                System.out.println("Table is full: " + i);
                avg++;
            } catch (IHashTable.KeyAlreadyExistsException E2) {
                System.out.println("Key already exists" + i);
                avg++;
            }
        }
    }
}
