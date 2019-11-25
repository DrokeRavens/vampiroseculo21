package ifmg.prog2;

public class Item {
    private String itemName;
    private boolean consumable;
    private String itemDescription;
    public Item(String itemName, String itemDescription, boolean consumable)
    {
        this.itemName = itemName;
        this.consumable = consumable;
        this.itemDescription = itemDescription;
    }

    public boolean isConsumable()
    {
        return consumable;
    }

    public String getItemName()
    {
        return itemName;
    }

    public String getItemDescription()
    {
        return itemDescription;
    }
}
