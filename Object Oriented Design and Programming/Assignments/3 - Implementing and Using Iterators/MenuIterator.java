public interface MenuIterator
{
	// returns true if items of appropriate type left in list
	public boolean hasNext();
	
	// returns current item and advances to next item
	public MenuItem next();
}
