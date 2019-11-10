/**
 * A direction in the game.
 * There exist only a few different directions.
 * 
 * @author Olaf Chitil
 * @version 4/2/2019
 */
public enum Direction
{
    NORTH("north"), 

    WEST("west"), 

    SOUTH("south"), 

    EAST("east"), 

    UP("up"), 

    DOWN("down");

    private String name;

    /**
     * Constructor with parameter.
     * Pre-condition: name is not null.
     */
    private Direction(String name)
    {
        assert name != null : "Direction.Direction has null name";
        this.name = name;
        assert toString().equals(name) : "Direction.Direction produces wrong toString";
    }

    /**
     * Return the direction name.
     */
    public String toString()
    {
        return name;
    }
}
