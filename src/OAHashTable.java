import IHashTable.KeyAlreadyExistsException;
import IHashTable.KeyDoesntExistException;
import IHashTable.TableIsFullException;

public abstract class OAHashTable implements IHashTable {
	
	private static HashTableElement DELETED = new HashTableElement(0, 0);
	private static HashTableElement elem;
	
	private HashTableElement [] table;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		// TODO add to constructor as needed
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		int index;
		for (int i = 0; i < this.table.length ; i++) {
			index = this.Hash(key, i);
			elem = this.table[index];
			if (elem == null) {
				return null;
			}
			if ((elem.GetKey() == key) && (elem != DELETED)) {
				return this.table[index];
			}
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		// TODO implement insertion	
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		int index;
		for (int i = 0; i <  this.table.length; i++) {
			index = this.Hash(key, i);
			elem = this.table[index];
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
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
