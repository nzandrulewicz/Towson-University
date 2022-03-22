import java.util.*;

public class MenuClient
{
	public static void main(String[] args)
	{	
		Menu nicksMenu = new Menu();
		
		nicksMenu.add("Lobster Dinner", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, "24.99");
		nicksMenu.add("Rice Pudding", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, "3.50");
		nicksMenu.add("12oz NY Strip", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, "$24.99");
		nicksMenu.add("Chips and Beer Cheese", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, "$6.99");
	
		Iterator<Object> arrayListIterator = nicksMenu.iterator();
		
		while(arrayListIterator.hasNext())
    {
    	System.out.println(arrayListIterator.next() + " ");
    }
	}
}
