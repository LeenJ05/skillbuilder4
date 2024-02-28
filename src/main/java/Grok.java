/**
 * Groks are bad actors in a game.  Groks have the ability to ingest
 * a PowerPill to replenish their energy.  This makes them difficult
 * to kill.
 *
 * @author (Leen)
 * @version (0.1)
 */
public class Grok
{
    private static final int DEFAULT_POWER_LEVEL=50;
    private static final int MAX_POWER_LEVEL = 100;

    // instance variables
    private int powerLevel;
    private boolean isAlive;

    /*
     * Initializes a Grok object to the default power level of 50.
     */
    public Grok()
    {
        isAlive = true;
        setPowerLevel(DEFAULT_POWER_LEVEL);
    }

    /*
     * Initializes a Grok object to power powerLevel
     *
     * @param powerLevel power level of this Grok
     */
    public Grok(int powerLevel)
    {
        isAlive = true;
        setPowerLevel(powerLevel);
    }

    // accessor methods

    /*
     * Returns the power level of this Grok.
     * @return returns the power level of this Grok
     */
    public int getPowerLevel()
    {
        return powerLevel;
    }

    public boolean isDead()
    {
        return !isAlive;
    }

    // mutator methods

    /*
     * Sets the power level of this Grok.
     * @param powerLevel the power value to set for this Grok.
     */
    public void setPowerLevel(int powerLevel){
        if (!isAlive)

    {
        return;
    }

    this.powerLevel = Math.min(Math.max(powerLevel, 0), MAX_POWER_LEVEL);

    // If power level drops below zero, Grok is dead
    if (this.powerLevel <= 0) {
        this.powerLevel = 0;
        isAlive = false;
    }
}

/*
     * Set the power level of this Grok to the power level of
     * the pill.
     * @param pill The PowerPill that the this Grok.  The power
     * of the pill is added to the power level of this Grok.
     */
    public void takePowerPill(PowerPill pill)
    {
        if (!isAlive){
            return;
        }
        setPowerLevel(powerLevel + pill.getPower());

    }

    /*
     * Invoked when this Grok takes a hit.  The power level of
     * this Grok is reduced by 5.
     */
    public void tookHit()
    {
        if (!isAlive){
            return;
        }
        setPowerLevel(powerLevel - 5);

    }
    private void maxMin() {
        if (powerLevel > MAX_POWER_LEVEL) {
            powerLevel = MAX_POWER_LEVEL;
        } else if (powerLevel <= 0) {
            powerLevel = 0;
            isAlive = false;
        }
    }

    //================== Do Not Touch Code Below this line =============================
    public String toString(){
        return "Grok:("+powerLevel+","+isAlive+")";
    }
}