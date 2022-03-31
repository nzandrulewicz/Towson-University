import java.util.*;

public class Menu
{
	// MenuItem[] menuItems;
	ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	int numberOfItems = 0;
	
	// Static Constants
	// These are to be passed as an argument when requesting an ItemIterator
	public static final int APPETIZERS = 1;
	public static final int MAIN_DISH = 2;
	public static final int DESSERT = 3;
	public static final boolean HEART_HEALTHY = true;
	public static final boolean NOT_HEART_HEALTHY = false;
	
	public Menu()
	{
        menuItems = new ArrayList<MenuItem>();
    	}
	
	public void add(String foodName, int foodType, boolean heartHealthy, String foodPrice) 
	{
		MenuItem newItem = new MenuItem(foodName, foodType, heartHealthy, foodPrice);
		
		menuItems.add(newItem);
	}

	private class AllItemsIterator implements MenuIterator
	{
		int current = 0;
		
		public boolean hasNext() 
		{
			if (current > menuItems.size() - 1 || menuItems.get(current) == null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		public MenuItem next() 
		{
			return menuItems.get(current++);
		}
		
	}
	
	public MenuIterator getAllItemsIterator() 
	{
		return new AllItemsIterator();
	}
}
