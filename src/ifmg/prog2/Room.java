package ifmg.prog2;

import java.util.HashMap;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room
{
    private String description;
    private HashMap<String, Room> rooms;
    private String name;

    /**
     * @author Bruno Alef, Bruno Giovani, Lazaro Junior, Lucas Laet e Matheus Giovanny.
     * @version 1.0 de 2019.
     */
    public Room(String name, String description)
    {
        this.description = description;
        rooms = new HashMap<String,Room>();
        this.name = name;
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

    public String getName()
    {
        return name;
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
        return (String) ("Você está em " + getDescription() + "\nSaídas:\n" + rooms.keySet());
    }
}
