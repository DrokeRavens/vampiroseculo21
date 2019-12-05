/**
 * @authors Bruno Alef, Bruno Giovani, Lazaro Junior, Lucas Laet and Matheus Giovanny.
 * @version 1.0 of 2019.
 */

public class Item {

    private String itemName;
    private boolean collectible;
    private boolean interactable;
    private String itemDescription;
    private float itemWeigth;

    public Item(String itemName, String itemDescription,
                float itemWeigth, boolean collectible, boolean interactable)
    {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeigth = itemWeigth;
        this.collectible = collectible;
        this.interactable = interactable;
    }

    /**
     * Retorna o nome do item
     * @return O nome do item atual em String
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * Retorna a descrição do item
     * @return descrição do item em String
     */
    public String getItemDescription()
    {
        return itemDescription;
    }

    /**
     * Retorna o peso do item
     * @return peso total do item em float
     */
    public float getItemWeight()
    {
      return itemWeigth;
    }

    /**
     * Retorna se o item é um item que pode ser coletável ou não.
     * @return True caso o item seja coletável, false caso contrário.
     */
    public boolean isCollectible()
    {
      return collectible;
    }
    
    /**
     * Retorna se o item é um item que pode ser coletável ou não.
     * @return True caso o item seja coletável, false caso contrário.
     */
    public boolean isInteractable()
    {
      return interactable;
    }
    
    public void setCollectible(boolean collectible)
    {
       this.collectible = collectible;
    }

    public void setInteractable( boolean interactable)
    {
        this.interactable = interactable;
    }
}
