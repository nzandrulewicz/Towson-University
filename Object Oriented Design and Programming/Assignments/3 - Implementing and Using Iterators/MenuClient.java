import java.text.DecimalFormat;
import java.text.NumberFormat;
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
		nicksMenu.add("Grilled Salmon", Menu.MAIN_DISH, Menu.HEART_HEALTHY, "19.99");
		
		actionMenu(nicksMenu);
	}
	
	public static void actionMenu(Menu nicksMenu)
	{
		try (Scanner cin = new Scanner(System.in)) {
			System.out.println("ACTION MENU");
			System.out.println();
			System.out.println("1) Display All Menu Items");
			System.out.println("2) Display All Appetizers");
			System.out.println("3) Display All Main Dishes");
			System.out.println("4) Display All Desserts");
			System.out.println("5) Display All Heart Healthy Items");
			System.out.println("6) Display All Items Under A Price");
			System.out.println();
			System.out.print("Enter action number: ");
			int userChoice = cin.nextInt();
			
			switch(userChoice)
			{
				case 1:
					System.out.println();
					displayAllMenuItems(nicksMenu);
				case 2:
					System.out.println();
					displayAllAppetizers(nicksMenu);
				case 3:
					System.out.println();
					displayAllMainDishes(nicksMenu);
				case 4:
					System.out.println();
					displayAllDesserts(nicksMenu);
				case 5:
					System.out.println();
					displayAllHeartHealthy(nicksMenu);
				case 6:
					System.out.println();
					System.out.print("Enter max price: ");
					Double maxPrice = cin.nextDouble();
					System.out.println();
					displayItemsUnderPrice(nicksMenu, maxPrice);
			}
		}
	}
	
	// ALL MENU ITEMS
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
	
	// APPETIZERS
	public static void displayAllAppetizers(Menu nicksMenu)
	{
		MenuItem menuItem;
		MenuIterator itr = nicksMenu.getItemsIterator(Menu.APPETIZERS);
		
		System.out.println("============================");
		System.out.println("APPETIZERS");
		System.out.println("----------------------------");
		
		while (itr.hasNext())
		{
			menuItem = itr.next();
			if (menuItem.getFoodType() == Menu.APPETIZERS)
			{
				System.out.println(menuItem.getFoodName() + " $" + menuItem.getFoodPrice());
			}
		}
		
		System.out.println("----------------------------");
		System.out.println("============================");
		System.out.println();
		
		actionMenu(nicksMenu);
	}
	
	// MAIN DISHES
	public static void displayAllMainDishes(Menu nicksMenu)
	{
		MenuItem menuItem;
		MenuIterator itr = nicksMenu.getItemsIterator(Menu.MAIN_DISH);
		
		System.out.println("============================");
		System.out.println("MAIN DISHES");
		System.out.println("----------------------------");
		
		while (itr.hasNext())
		{
			menuItem = itr.next();
			if (menuItem.getFoodType() == Menu.MAIN_DISH)
			{
				System.out.println(menuItem.getFoodName() + " $" + menuItem.getFoodPrice());
			}
		}
		
		System.out.println("----------------------------");
		System.out.println("============================");
		System.out.println();
		
		actionMenu(nicksMenu);
	}
	
	// DESSERTS
	public static void displayAllDesserts(Menu nicksMenu)
	{
		MenuItem menuItem;
		MenuIterator itr = nicksMenu.getItemsIterator(Menu.DESSERT);
		
		System.out.println("============================");
		System.out.println("DESSERTS");
		System.out.println("----------------------------");
		
		while (itr.hasNext())
		{
			menuItem = itr.next();
			if (menuItem.getFoodType() == Menu.DESSERT)
			{
				System.out.println(menuItem.getFoodName() + " $" + menuItem.getFoodPrice());
			}
		}
		
		System.out.println("----------------------------");
		System.out.println("============================");
		System.out.println();
		
		actionMenu(nicksMenu);
	}
	
	// HEART HEALTHY
	public static void displayAllHeartHealthy(Menu nicksMenu)
	{
		MenuItem menuItem;
		MenuIterator itr = nicksMenu.getHeartHealthyIterator(Menu.HEART_HEALTHY);
		
		System.out.println("============================");
		System.out.println("HEART HEALTHY");
		System.out.println("----------------------------");
		
		while (itr.hasNext())
		{
			menuItem = itr.next();
			if (menuItem.getHeartHealthy() == Menu.HEART_HEALTHY)
			{
				System.out.println(menuItem.getFoodName() + " $" + menuItem.getFoodPrice());
			}
		}
		
		System.out.println("----------------------------");
		System.out.println("============================");
		System.out.println();
		
		actionMenu(nicksMenu);
	}
	
	// ITEMS UNDER PRICE
	public static void displayItemsUnderPrice(Menu nicksMenu, Double maxPrice)
	{
		NumberFormat df = new DecimalFormat("##0.00");
		
		MenuItem menuItem;
		MenuIterator itr = nicksMenu.getHeartHealthyIterator(Menu.HEART_HEALTHY);
		
		System.out.println("============================");
		System.out.println("ALL ITEMS UNDER $" + df.format(maxPrice));
		System.out.println("----------------------------");
		
		while (itr.hasNext())
		{
			menuItem = itr.next();
			
			double foodPrice = Double.parseDouble(menuItem.getFoodPrice());
			
			if (foodPrice < maxPrice)
			{
				System.out.println(menuItem.getFoodName() + " $" + menuItem.getFoodPrice());
			}
		}
		
		System.out.println("----------------------------");
		System.out.println("============================");
		System.out.println();
		
		actionMenu(nicksMenu);
	}
}
