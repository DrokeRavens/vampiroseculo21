import java.util.HashMap;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> rooms;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        rooms = new HashMap<String,Room>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room south, Room east, Room west, Room above, Room under) 
    {
        setExit("norte", north);
        setExit("sul", south);
        setExit("leste", east);
        setExit("oeste", west);
        setExit("acima", above);
        setExit("abaixo", under);
    }
    
    /**
     * Define uma saída dessa sala.
     * @param direction  A direção da saída.
     * @param vizinha  O objeto Room na direção especificada.
     */
    public void setExit(String direction, Room vizinha)
    {
       if(vizinha != null)
       {
           if(rooms.containsKey(direction))
           {
               rooms.replace(direction, vizinha);
           }
           else
           {
               rooms.put(direction, vizinha);
           }
       }
       
    }
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public Room getExit(String description){
        if(rooms.containsKey(description)){
            return (Room) rooms.get(description);
        }
        return null;
    }
    
    /**
    * Return a description of a room exit,
    * for example, "Exits: north west"
    * @return one description of follow exits avaliable.
    */
   public String getExitString()
   {
       return "Você está em " + getDescription() + "\nSaídas:\n" + 
       getExit("north") + getExit("east") + getExit("south") + getExit("west") +
       getExit("above") + getExit("under");
    }
}
