public class Food {
    private String foodName;
    private int healthValue;
    private int hungerValue;
    private int happinessValue;
    


    public Food(String name, int health, int happiness, int hunger)
    {
            foodName = name;
            healthValue = health;
            hungerValue = hunger;
            happinessValue = happiness;
    }

    public String getName()
    {
        return foodName;
    }

    public int getHealthValue()
    {
        return healthValue;
    }

    public int getHungerValue()
    {
        return hungerValue;
    }

    public int getHappinessValue()
    {
        return happinessValue;
    }

    

}
