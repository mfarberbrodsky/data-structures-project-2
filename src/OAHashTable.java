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

    @Override
    public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
        for (int i = 0; i < this.table.length; i++) {
            int index = this.Hash(hte.GetKey(), i);
            HashTableElement elem = this.table[index];
            if ((elem == null) || (elem == DELETED)) {
                this.table[index] = hte;
                return;
            }
            if ((elem.GetKey() == hte.GetKey()) && (elem != DELETED)) {
                throw new KeyAlreadyExistsException(hte);
            }
        }
        throw new TableIsFullException(hte);
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
