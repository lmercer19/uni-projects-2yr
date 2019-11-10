import java.util.ArrayList;
/**
 *  This class is the central class of the "World of Home" application. 
 *  "World of Home" is a very simple, text based travel game.  Users 
 *  can walk around some house. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 * @author  Michael Kölling, David J. Barnes, Olaf Chitil and Lucy Mercer
 * @version 19/2/2019
 */

public class Game 
{
    private Room currentRoom;
    private boolean finished;
    private Room goalRoom;
    private int time; //a counter of time
    private ArrayList<Item> items; //stores list of how many items youve taken
    private Room cookRoom; 

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        finished = false;
        createRooms();
        items = new ArrayList<Item>(); 
    }

    /**
     * Create all the rooms and link their exits together.
     * Adds characters to their rooms with items.
     * Sets the goal room, start room, and cooking room.
     */
    private void createRooms()
    {
        Room front, hall, kitchen, livingroom, garden, cloakroom, stairs, bathroom, 
        master, ensuite, guest;
        
        Character father, mother, daughter, son;

        // create the rooms
        front = new Room("in front of the house");
        hall = new Room("in the hallway");
        kitchen = new Room("in the kitchen");
        livingroom = new Room("in the livingroom");
        garden = new Room("in the garden");
        cloakroom = new Room("in the cloakroom");
        stairs = new Room("at the top of the stairs");
        bathroom = new Room("in the bathroom");
        master = new Room("in the master bedroom");
        ensuite = new Room("in the ensuite");
        guest = new Room("in the guest bedroom");

        // initialise room exits
        front.setExit(Direction.NORTH, hall);
        hall.setExit(Direction.SOUTH, front);
        hall.setExit(Direction.UP, stairs);
        hall.setExit(Direction.WEST, cloakroom);
        hall.setExit(Direction.EAST, kitchen);
        hall.setExit(Direction.NORTH, livingroom);
        kitchen.setExit(Direction.WEST, hall);
        kitchen.setExit(Direction.NORTH, livingroom);
        cloakroom.setExit(Direction.EAST, hall);
        livingroom.setExit(Direction.SOUTH, hall);
        livingroom.setExit(Direction.EAST, kitchen);
        livingroom.setExit(Direction.NORTH, garden);
        garden.setExit(Direction.SOUTH, livingroom);
        stairs.setExit(Direction.DOWN, hall);
        stairs.setExit(Direction.EAST, bathroom);
        stairs.setExit(Direction.SOUTH, guest);
        stairs.setExit(Direction.NORTH, master);
        bathroom.setExit(Direction.WEST, stairs);
        guest.setExit(Direction.NORTH, stairs);
        master.setExit(Direction.SOUTH, stairs);
        master.setExit(Direction.EAST, ensuite);
        ensuite.setExit(Direction.WEST, master);
        
        //create the characters
        father = new Character("father", Item.FLOUR);
        mother = new Character("mother", Item.EGG);
        daughter = new Character("daughter", null);
        son = new Character("son", Item.SUGAR);
        
        //spawn characters in rooms
        hall.addCharacter(mother);
        kitchen.addCharacter(father);
        livingroom.addCharacter(daughter);
        master.addCharacter(son);

        currentRoom = front;  // start game at the front of the house
        goalRoom = ensuite; // the goal is to get to this room
        cookRoom = kitchen; // you can only cook in this room
    }

    /**
     * Return the current room.
     * Post-condition: not null.
     */
    public Room getCurrent()
    {
        assert currentRoom != null : "Current room is null.";
        return currentRoom;
    }

    /**
     * Return whether the game has finished or not.
     */
    public boolean finished()
    {
        return finished;
    }

    /**
     * Opening message for the player.
     */
    public String welcome()
    {
        return "\nWelcome to the World of Home!\n" +
        "World of Home is a new game.\n" +
        currentRoom.getLongDescription() + "\n";
    }

    // implementations of user commands:
    /**
     * Give some help information.
     */
    public String help() 
    {
        return "You are lost. You are alone. You wander around the home.\n";
    }

    /** 
     * Try to go in one direction. 
     * If it is the goalRoom the game returns a congratulations message and ends the game. 
     * If there is an exit, enter the new room and return its long 
     * description; otherwise return an error message.
     * If time is up return time up message and ends the game.
     * @param direction The direction in which to go.
     * Pre-condition: direction is not null.
     */
    public String goRoom(Direction direction) 
    {
        assert direction != null : "Game.goRoom gets null direction";
        
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return "There is no exit in that direction!";
        }
        else if (nextRoom.equals(goalRoom)) {
            finished = true;
            return currentRoom.getLongDescription() + "\nCongratulations! You reached the goal.\nThank you for playing.  Good bye.";
        }
        else if (time >= 11) {
            finished = true;
            return currentRoom.getLongDescription() + "\nLost! You ran out of time.\nThank you for playing.  Good bye.";
        }
        else {
            currentRoom = nextRoom;
            time++; //adds one to the timer
            return currentRoom.getLongDescription();
        }
    }

    /**
     * Execute quit command.
     */
    public String quit()
    {
        finished = true;
        return "Thank you for playing.  Good bye.";
    }

    /**
     * Execute look command.
     */
    public String look()
    {
        return currentRoom.getLongDescription();
    }

    /**
     * Execute take command.
     * @param item The item to take.
     * Pre-condition: item is not null.
     */
    public String take(Item item)
    {
        assert item != null : "Game.take item is null";
        if (currentRoom.take(item)) {
            items.add(item);
            return "Item taken.";
        }
        return "Item not in this room.";
    }

    /**
     * Execute cook command.
     */
    public String cook()
    {
        if(currentRoom == cookRoom && items.size() == 3) {
            return ("Congratulations! You have won.\n" + quit());
        }
        
        return "You cannot cook yet.";
    }
}
