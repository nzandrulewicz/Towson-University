import java.util.*;

public class Menu
{
	ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
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
	
	public void remove(MenuItem menuItem) 
	{
		menuItems.remove(menuItem);
	}

	// ALL MENU ITEMS
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
	
	// APPETIZERS, MAIN DISH, or DESSERT
	private class ItemsIterator implements MenuIterator
	{
		int current = 0;
		
		public ItemsIterator(int foodType)
		{
		}

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
		
	public MenuIterator getItemsIterator(int foodType) 
	{
		return new ItemsIterator(foodType);
	}
	
	// HEART HEALTHY
	private class HeartHealthyIterator implements MenuIterator
	{
		int current = 0;
		
		public HeartHealthyIterator(boolean heartHealthy)
		{
		}

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
		
	public MenuIterator getHeartHealthyIterator(boolean heartHealthy) 
	{
		return new HeartHealthyIterator(heartHealthy);
	}

	// ITEMS UNDER PRICE
	private class PriceIterator implements MenuIterator
	{
		int current = 0;
		
		public PriceIterator(String foodPrice)
		{
		}

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
		
	public MenuIterator getPriceIterator(String foodPrice) 
	{
		return new PriceIterator(foodPrice);
	}
}
