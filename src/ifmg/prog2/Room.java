package ifmg.prog2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room
{
    private String description;
    private HashMap<String, Room> roomExits;
    private String name;
    private Inventory roomInventory;

    /**
     * @author Bruno Alef, Bruno Giovani, Lazaro Junior, Lucas Laet e Matheus Giovanny.
     * @version 1.0 de 2019.
     */
    public Room(String name, String description)
    {
        this.description = description;
        roomExits = new HashMap<String,Room>();
        roomInventory = new Inventory();
        this.name = name;
    }

    /**
     * Adiciona um novo item a relação de itens do inventório da sala.
     * @param itemToAdd  Item a ser adicionado.
     */
    public void addRoomInventoryItem(Item itemToAdd)
    {
        roomInventory.addNewItem(itemToAdd);
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
            if(roomExits.containsKey(direction))
            {
                roomExits.replace(direction, vizinha);
            }
            else
            {
                roomExits.put(direction, vizinha);
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
        if(roomExits.containsKey(description)){
            return (Room) roomExits.get(description);
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
        return (String) ("Você está em " + getDescription() + "\nSaídas:\n" + roomExits.keySet());
    }
}
