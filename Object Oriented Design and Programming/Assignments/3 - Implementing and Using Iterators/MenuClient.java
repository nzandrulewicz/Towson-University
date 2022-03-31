import java.util.*;

public class MenuClient
{
	public static void main(String[] args)
	{	
		Menu nicksMenu = new Menu();
		
		nicksMenu.add("Lobster Dinner", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, "24.99");
		nicksMenu.add("Rice Pudding", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, "3.50");
		nicksMenu.add("12oz NY Strip", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, "24.99");
		nicksMenu.add("Chips and Beer Cheese", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, "6.99");
		nicksMenu.add("Grilled Salmon", Menu.MAIN_DISH, Menu.HEART_HEALTHY, "14.99");
		
		actionMenu(nicksMenu);
	}
	
	public static void actionMenu(Menu nicksMenu)
	{
		try (Scanner cin = new Scanner(System.in)) {
			System.out.println("ACTION MENU");
			System.out.println();
			System.out.println("1) Display All Menu Items");
			System.out.println();
			System.out.print("Enter action number: ");
			int userChoice = cin.nextInt();
			
			switch(userChoice)
			{
				case 1:
					System.out.println();
					displayAllMenuItems(nicksMenu);
			}
		}
	}
	
	public static void displayAllMenuItems(Menu nicksMenu)
	{
		MenuItem menuItem;
		MenuIterator itr = nicksMenu.getAllItemsIterator();
		
		System.out.println("============================");
		System.out.println("ALL MENU ITEMS");
		System.out.println("----------------------------");
		while (itr.hasNext())
		{
			menuItem = itr.next();
			System.out.println(menuItem.getFoodName() + " $" + menuItem.getFoodPrice());
		}
		System.out.println("----------------------------");
		System.out.println("============================");
		System.out.println();
		
		actionMenu(nicksMenu);
	}
}
