public class MenuItem
{
	String foodName;
	int foodType;
	boolean heartHealthy;
	String foodPrice;
	
	public MenuItem(String foodName, int foodType, boolean heartHealthy, String foodPrice)
	{
		this.foodName = foodName;
		this.foodType = foodType;
		this.heartHealthy = heartHealthy;
		this.foodPrice = foodPrice;
	}
	
	public String getFoodName()
	{
		return foodName;
	}
	
	public int getFoodType()
	{
		return foodType;
	}
	
	public boolean getHeartHealthy()
	{
		return heartHealthy;
	}
	
	public String getFoodPrice()
	{
		return foodPrice;
	}
}
