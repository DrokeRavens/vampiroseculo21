import java.util.HashMap;
import java.util.ArrayList;

/**
 * @authors Bruno Alef, Bruno Giovani, Lazaro Junior, Lucas Laet e Matheus Giovanny.
 * @version 1.0 of 2019.
 */

public class Room 
{
   private String description;
   private String longDescription;
   private HashMap<String, Room> roomExits;
   private String name;
   private Inventory roomInventory;
   private Item item;
   private boolean longDescriptionviewer;
   
   public Room(String name, String description, String longDescription) 
   {
        this.description = description;
        this.longDescription = longDescription;
        roomExits = new HashMap<String,Room>();
        roomInventory = new Inventory();
        this.name = name;
   }

   /**
   * Define uma saída dessa sala.
   * @param direction  A direção da saída.
   * @param neighbor  O objeto Room na direção especificada.
   */
   public void setExit(String direction, Room neighbor)
    {
       if(neighbor != null)
       {
           if(roomExits.containsKey(direction))
           {
               roomExits.replace(direction, neighbor);
           }
           else
           {
               roomExits.put(direction, neighbor);
           }
       }       
    }
    
   public String getLongDescription()
    {
        longDescriptionviewer = true;
        return longDescription +
                "\nInterações ao redor: [" + roomInventory.getItensName() + "]";
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

   public Room getExit(String description)
   {
       return roomExits.get(description);
   }
    
   /**
   * Return a description of a room exit,
   * for example, "Exits: north west"
   * @return one description of follow exits avaliable.
   */
   public String getExitString()
   {
       return ("\nSaída(s):\n  " + roomExits.keySet());
   }
   

    /**
     * Tenta localizar um item de nome informado
     * @return O inventário da sala
     */
    public Inventory getRoomInventory()
    {
        return roomInventory;
    }
    
    /**
     * This method verify if the long description has seen before the player tried...
     * ...to catch a item.
     */
    public boolean longDescriptionHasSeenBefore(){
        return longDescriptionviewer;
    }
    
}
