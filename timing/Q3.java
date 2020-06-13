public class Q3 {
	
	static double avg = 0;
	
	public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
			//partA();
			
			for (int i = 0; i < 100; i++) {
				System.out.println("Iteration " + i);
				partB();
			}
			avg = avg/100;
			
			System.out.println("Avg number of Exceptions: " + avg);
		}

	
	public static void partA() {
		
		System.out.println("Starting part A");
		
		int[] cntA = new int[6571];
		for (int i = 0; i < 6571; i++) {
			cntA[(i*i % 6571)] ++;
		}
		
		int cnt = 0;
		for (int i = 0; i < 6571; i++) {
			if (cntA[i] != 0)
				cnt ++;
		}
		
		System.out.println("Size of Q1: " + cnt);
		
		int[] cntB = new int[6571];
		for (int i = 0; i < 6571; i++) {
			if (i % 2 == 0) {
				cntB[(i*i % 6571)] ++;
			}
			else {
				cntB[Math.floorMod(-i*i, 6571)] ++;
			}
		}
		
		cnt = 0;
		for (int i = 0; i < 6571; i++) {
			if (cntB[i] != 0)
				cnt ++;
		}
		
		System.out.println("Size of Q2: " + cnt);
		
	}
	
	public static void partB() {
		
		int m = 6571;
		long p = 1000000007;
		IHashTable table = new QPHashTable(m, p);
	
		int a;
		int b;

		for (int i = 0; i <m; i++) {
			b = (int) (Math.random() * 100);
			a = 100*i + b;
					
			try {
				table.Insert(new HashTableElement(a, a));
			}
			catch (IHashTable.TableIsFullException E1) {
				System.out.println("Table is full: " + i);
				avg ++;
			}
			catch (IHashTable.KeyAlreadyExistsException E2) {
				System.out.println("Key already exists" + i);
				avg ++;
			}
		}
	}
}
