import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in a game.
 *
 * This class is part of the "World of Home" application. 
 * "World of Home" is a very simple, text based travel game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling, David J. Barnes, Olaf Chitil and Lucy Mercer
 * @version 19/2/2019
 */

public class Room 
{
    private String description;
    private HashMap<Direction, Room> exits;        // stores exits of this room.
    private ArrayList<Character> c;               //stores a list of characters.
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * Initialises array list for character
     * @param description The room's description.
     * Pre-condition: description is not null.
     */
    public Room(String description) 
    {
        assert description != null : "Room.Room has null description";
        this.description = description;
        exits = new HashMap<Direction, Room>();
        c = new ArrayList<Character>();
        sane();
    }

    /**
     * Class invariant: getShortDescription() and getLongDescription() don't return null.
     */
    public void sane()
    {
        assert getShortDescription() != null : "Room has no short description" ;
        assert getLongDescription() != null : "Room has no long description" ;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     * Pre-condition: neither direction nor neighbor are null; 
     * there is no room in given direction yet.
     */
    public void setExit(Direction direction, Room neighbor) 
    {
        assert direction != null : "Room.setExit gets null direction";
        assert neighbor != null : "Room.setExit gets null neighbor";
        assert getExit(direction) == null : "Room.setExit set for direction that has neighbor";
        sane();
        exits.put(direction, neighbor);
        sane();
        assert getExit(direction) == neighbor : "Room.setExit has wrong neighbor";
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     *     Characters: mother having the item egg;
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String longDescription = "You are " + description + ".\n" + getExitString();
        
        if(c.size() > 0) {
            longDescription = longDescription + "\nCharacters: ";
            
            for(Character character : c) {
                longDescription = longDescription + character.toString() + "; ";
            }
        }
        return longDescription;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        // Ensure some fixed ordering of keys, so that return String uniquely defined.
        List<Direction> keys = exits.keySet().stream().sorted().collect(Collectors.toList());
        for(Direction exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     * Pre-condition: direction is not null
     */
    public Room getExit(Direction direction) 
    {
        assert direction != null : "Room.getExit has null direction";
        sane();
        return exits.get(direction);
    }

    /**
     * Add given character to the room.
     * @param character The character to add.
     * Pre-condition: character is not null.
     */
    public void addCharacter(Character character)
    {
        assert c != null : "Room.addCharacter has null character";
        this.c.add(character);
    }

    /**
     * Take given item from a character in the room.
     * @param item The item to take.
     * @return true if taking was successful, false otherwise
     * Pre-Condition: item is not null.
     */
    public boolean take(Item item)
    {
        assert item != null : "Room.take is given null item";
        boolean taken = false;
        
        for(Character character : c){
            if(character.take(item)) {
                taken = true;
            }
        }
        return taken;
    }
}

