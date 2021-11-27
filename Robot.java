public class Robot {
    private String name;
    private int hunger;
    private static final int MAX_HUNGER = 10;
    private static final int DEFAULT_HUNGER = 7;
    private int happiness;
    private static final int MAX_HAPPINESS = 10;
    private static final int DEFAULT_HAPINESS = 7;
    private int health;
    private static final int MAX_HEALTH = 10;
    private static final int DEFAULT_HEALTH = 7;
    //private int exhaustion;
    private static final int MAX_EXHAUST = 10;
    private static final int DEFAULT_EXHAUST = 10;

    public Robot(String name)
    {
        this.name = name;
        hunger = DEFAULT_HUNGER;
        happiness = DEFAULT_HAPINESS;
        health = DEFAULT_HEALTH;
        //exhaustion = DEFAULT_EXHAUST;

    }

    public String getName()
    {
        return name;
    }

    public int getHunger()
    {
        return hunger;
    }

    public int getHappiness()
    {
        return happiness;
    }

    public int getHealth()
    {
        return health;
    }

    public boolean isDead()
    {
        if(health == 0)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public void feed(Food food)
    {
        if(!(isDead()))
        {
            hunger += food.getHungerValue();
            happiness += food.getHappinessValue();
            health += food.getHealthValue();
        }
        checkOverFlow();
        
    
    }

    public void play(int playTime)
    {
        if(!(isDead()))
        {
            happiness += playTime;
            hunger -= Math.floorDiv(playTime, 2);
            checkOverFlow();
        }

    }

    private void checkOverFlow()
    {
        if(hunger>MAX_HUNGER){ hunger = MAX_HUNGER; }
        if(hunger<0){ hunger = 0; }
        if(health>MAX_HEALTH){ health = MAX_HEALTH; }
        if(health<0){ health = 0; }
        if(happiness>MAX_HAPPINESS){ happiness = MAX_HAPPINESS; }
        if(happiness<0){ happiness = 0; }

    }

}
