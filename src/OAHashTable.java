public abstract class OAHashTable implements IHashTable {

    private static final HashTableElement DELETED = new HashTableElement(0, 0);
    private final HashTableElement[] table;

    public OAHashTable(int m) {
        this.table = new HashTableElement[m];
    }

    // Checks if an element with this key exists in the table,
    // if such an element exists, returns the element. 
    // Otherwise, returns null.
    
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
    @Override
    public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
    	
    	HashTableElement found = Find(hte.GetKey());
    	if (found != null) {
    		throw new KeyAlreadyExistsException(hte);
    	}
    	
        for (int i = 0; i < this.table.length; i++) {
            int index = this.Hash(hte.GetKey(), i);
            HashTableElement elem = this.table[index];
            if ((elem == null) || (elem == DELETED)) {
                this.table[index] = hte;
                return;
            }
        }

        throw new TableIsFullException(hte); // all indices in probing sequence are full
    }

    

    // Removes an element with this key from the hash table if exists,
    // or throws KeyDoesntExistException.
    
    @Override
    public void Delete(long key) throws KeyDoesntExistException {
        for (int i = 0; i < this.table.length; i++) {
            int index = this.Hash(key, i);
            HashTableElement elem = this.table[index];
            if (elem == null) {
                throw new KeyDoesntExistException(key);
            }
            if ((elem.GetKey() == key) && (elem != DELETED)) {
                this.table[index] = DELETED; // marks the cell. DELETED != null
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
