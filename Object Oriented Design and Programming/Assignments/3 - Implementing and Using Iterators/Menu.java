import java.util.*; // Uses Iterator and LinkedList

public class Menu implements Iterable<Object>
{
	// Static Constants
	// These are to be passed as an argument when requesting an ItemIterator
	public static final int APPETIZERS = 1;
	public static final int MAIN_DISH = 2;
	public static final int DESSERT = 3;
	public static final boolean HEART_HEALTHY = true;
	public static final boolean NOT_HEART_HEALTHY = false;
	
	
	ArrayList<Object> menuItems = new ArrayList<Object>();
	
	public void add(String foodName, int foodType, boolean heartHealthy, String price)
	{
		Collections.addAll(menuItems, foodName, foodType, heartHealthy, price);
	}

	@Override
	public Iterator<Object> iterator()
	{
		return new ArrayIterator(menuItems);
	}
	
	private class ArrayIterator implements Iterator<Object>
    {
		private ArrayList<Object> menuItems = new ArrayList<Object>();
		private int current = 0;
		
		public ArrayIterator(ArrayList<Object> menuItem)
		{
			this.menuItems = menuItem;
		}
		
		@Override
		public Object next()
		{
			Object menuItem = menuItems.get(current);
			current++;
			return menuItem;
		}
		
		@Override
		public boolean hasNext() {
			if (current >= menuItems.size() || menuItems.get(current) == null)
    		{
    			return false;
    		}
			return true;
		}		
    }
}
