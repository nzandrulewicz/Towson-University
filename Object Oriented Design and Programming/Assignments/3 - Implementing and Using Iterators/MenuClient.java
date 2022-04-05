import java.util.*;

public class MenuClient
{
	static Scanner cin = new Scanner(System.in);
	
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
		System.out.println("ACTION MENU");
		System.out.println();
		System.out.println("1) Display All Menu Items");
		System.out.println("2) Display Appetizers");
		System.out.println("3) Display Main Dishes");
		System.out.println("4) Display Desserts");
		System.out.println("5) Display Heart Healthy Items");
		System.out.println("6) Display All Main Dishes Under A Price");
		System.out.println("7) Add A Menu Item");
		System.out.println("8) Remove A Menu Item");
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
				String maxPrice = cin.next();
				System.out.println();
				displayItemsUnderPrice(nicksMenu, maxPrice);
			case 7:
				System.out.println();
				addMenuItem(nicksMenu);
			case 8:
				System.out.println();
				removeMenuItem(nicksMenu);
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
		System.out.println("Press Enter to go back to the action menu.");
		try{System.in.read();}
		catch(Exception e){}
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
		System.out.println("Press Enter to go back to the action menu.");
		try{System.in.read();}
		catch(Exception e){}
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
		System.out.println("Press Enter to go back to the action menu.");
		try{System.in.read();}
		catch(Exception e){}
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
		System.out.println("Press Enter to go back to the action menu.");
		try{System.in.read();}
		catch(Exception e){}
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
		System.out.println("Press Enter to go back to the action menu.");
		try{System.in.read();}
		catch(Exception e){}
		System.out.println();
		
		actionMenu(nicksMenu);
	}
	
	// MAIN DISHES UNDER PRICE
	public static void displayItemsUnderPrice(Menu nicksMenu, String maxPrice)
	{
		MenuItem menuItem;
		// TODO: Check if the input is the correct format.
		MenuIterator itr = nicksMenu.getPriceIterator(maxPrice);
		
		System.out.println("============================");
		System.out.println("ALL MAIN DISHES UNDER $" + maxPrice);
		System.out.println("----------------------------");
		
		while (itr.hasNext())
		{
			menuItem = itr.next();
			
			double foodPrice = Double.parseDouble(menuItem.getFoodPrice());
			double dMaxPrice = Double.parseDouble(maxPrice);
			
			if (foodPrice < dMaxPrice && menuItem.getFoodType() == Menu.MAIN_DISH)
			{
				System.out.println(menuItem.getFoodName() + " $" + menuItem.getFoodPrice());
			}
		}
		
		System.out.println("----------------------------");
		System.out.println("============================");
		System.out.println("Press Enter to go back to the action menu.");
		try{System.in.read();}
		catch(Exception e){}
		System.out.println();
		
		actionMenu(nicksMenu);
	}

	// ADD A MENU ITEM
	// Food name and type
	public static void addMenuItem(Menu nicksMenu)
	{	
		String foodName;
		
		System.out.println("============================");
		System.out.println("ADD A MENU ITEM");
		System.out.println("----------------------------");
		
		System.out.print("Enter the name of the menu item: ");
		cin.nextLine(); // This line prevents Java from skipping an input while allowing spaces in the foodName string.
		foodName = cin.nextLine(); // Actual user input line.
		System.out.println();
		
		// TODO: Prevent code from crashing when user enters a value other than an integer.
		System.out.print("Enter 1 if " + foodName + " is an Appetizer, 2 if it's a Main Dish, or 3 if it's a Dessert: ");
		int foodType = cin.nextInt();
		System.out.println();
		if (foodType == 1 || foodType == 2 || foodType == 3)
		{
			addHeartHealthy(nicksMenu, foodName, foodType);
		}
		else
		{
			System.out.println("Error: Please enter either 1, 2, or 3.");
			System.out.println();

			addMenuItem(nicksMenu);
		}
	}
	
	// Heart Healthy or Not Heart Healthy
	public static void addHeartHealthy(Menu nicksMenu, String foodName, int foodType)
	{
		// TODO: Prevent code from crashing when user enters a value other than an integer.
		System.out.print("Enter 1 if it is a heart healthy item or 2 if it is not: ");
		int intHeartHealthy = cin.nextInt();
		System.out.println();
		
		if (intHeartHealthy == 1)
		{
			addFoodPrice(nicksMenu, foodName, foodType, Menu.HEART_HEALTHY);
		}
		else if (intHeartHealthy == 2)
		{
			addFoodPrice(nicksMenu, foodName, foodType, Menu.NOT_HEART_HEALTHY);
		}
		else
		{
			System.out.println("Error: Please enter 1 for Heart Healthy or 2 for Not Heart Healthy.");
			System.out.println();
			addMenuItem(nicksMenu);
		}
	}
	
	// Food Price
	public static void addFoodPrice(Menu nicksMenu, String foodName, int foodType, boolean heartHealthy)
	{
		// TODO: Make sure user enters in a price in the format of $##0.00 where the dollar sign and # symbols are optional
		System.out.print("Enter the price of " + foodName + ": ");
		String foodPrice = cin.next();
		nicksMenu.add(foodName, foodType, heartHealthy, foodPrice);
		System.out.println("You just added " + foodName + " for $" + foodPrice + ".");
		System.out.println("Press Enter to go back to the action menu.");
		try{System.in.read();}
		catch(Exception e){}
		
		actionMenu(nicksMenu);
	}

	// REMOVE A MENU ITEM
	public static void removeMenuItem(Menu nicksMenu)
	{
		// TODO: Alert the user if an item is not listed in the menu already.
		// TODO: Don't make input case sensitive.
		// TODO: Implement input validation.
		System.out.print("Enter the name of the menu item you would like to remove: ");
		cin.nextLine(); // This line prevents Java from skipping an input while allowing spaces in the foodName string.
		String foodName = cin.nextLine(); // Actual user input line.
		System.out.println();
		
		MenuItem menuItem;
		MenuIterator itr = nicksMenu.getAllItemsIterator();
		
		while (itr.hasNext())
		{
			menuItem = itr.next();
			if (menuItem.getFoodName().equals(foodName))
			{
				nicksMenu.remove(menuItem);
			}
		}
		
		System.out.println();
		System.out.println("You have successfully removed " + foodName + ".");
		System.out.println("Below is your current menu.");
		displayAllMenuItems(nicksMenu);
	}
}
