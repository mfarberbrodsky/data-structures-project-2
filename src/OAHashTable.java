public abstract class OAHashTable implements IHashTable {

    private static final HashTableElement DELETED = new HashTableElement(0, 0);
    private final HashTableElement[] table;

    public OAHashTable(int m) {
        this.table = new HashTableElement[m];
    }

    @Override
    public HashTableElement Find(long key) {
        for (int i = 0; i < this.table.length; i++) {
            int index = this.Hash(key, i);
            HashTableElement elem = this.table[index];
            if (elem == null) {
                return null;
            }
            if ((elem.GetKey() == key) && (elem != DELETED)) {
                return elem;
            }
        }
        return null;
    }

    // Inserts an hash table element to the hash table,
    // throws KeyAlreadyExistsException if there is an identical key in the hash permutation
    // or TableIsFullException if all cells in the hash permutation were full.
    // Complexity: O(1) expected time if load factor is constant, O(m) worst case time
    @Override
    public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
        for (int i = 0; i < this.table.length; i++) {
            int index = this.Hash(hte.GetKey(), i); // ith index in probing sequence
            HashTableElement elem = this.table[index];
            if ((elem == null) || (elem == DELETED)) { // item can be inserted
                this.table[index] = hte;
                return;
            }
            if (elem.GetKey() == hte.GetKey()) {
                throw new KeyAlreadyExistsException(hte); // identical key in probing sequence
            }
        }
        throw new TableIsFullException(hte); // all indices in probing sequence are full
    }

    @Override
    public void Delete(long key) throws KeyDoesntExistException {
        for (int i = 0; i < this.table.length; i++) {
            int index = this.Hash(key, i);
            HashTableElement elem = this.table[index];
            if (elem == null) {
                throw new KeyDoesntExistException(key);
            }
            if ((elem.GetKey() == key) && (elem != DELETED)) {
                this.table[index] = DELETED;
                return;
            }
        }
        throw new KeyDoesntExistException(key);
    }

    /**
     * @param x - the key to hash
     * @param i - the index in the probing sequence
     * @return the index into the hash table to place the key x
     */
    public abstract int Hash(long x, int i);
}
