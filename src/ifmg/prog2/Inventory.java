package ifmg.prog2;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private ArrayList<Item> inventory;

    public Inventory()
    {
        inventory = new ArrayList<>();
    }

    //Por ser um joo simples, vamos assumir que os itens não se
    //repetem
    public void addNewItem(Item item)
    {
        inventory.add(item);
    }

    public void removeItemByName(String itemNameToRemove)
    {
        Item itemToRemove = getItemByName(itemNameToRemove);
        if(itemNameToRemove != null)
            inventory.remove(itemToRemove);
    }

    public Item getItemByName(String itemName)
    {
        Item foundItem = null;
        for(Item item : inventory)
        {
            if(item.getItemName().equalsIgnoreCase(itemName)) {
                foundItem = item;
                break;
            }
        }
        return foundItem;
    }
}
