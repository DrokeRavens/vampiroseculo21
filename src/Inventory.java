/**
 * @authors Bruno Alef, Bruno Giovani, Lazaro Junior, Lucas Laet and Matheus Giovanny.
 * @version 1.0 of 2019.
 */

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    
    private ArrayList<Item> items;
    private Item item;

    public Inventory()
    {
        items = new ArrayList<>();
    }

    //Por ser um jogo simples, vamos assumir que os itens não se
    //repetem
    public void addNewItem(String itemName, String itemDescription, float itemWeigth, boolean collectible, boolean interactable)
    {
     items.add(new Item(itemName, itemDescription, itemWeigth, collectible, interactable));
    }
    
    //Override
    public void addNewItem(Item item)
    {
     items.add(item);
    }

    /**
     * Remove um item do inventario pelo nome informado
     * @param itemNameToRemove nome do item a ser removido
     */
    public void removeItemByName(String itemNameToRemove)
    {
        Item itemToRemove = getItemByName(itemNameToRemove);
        if(itemNameToRemove != null)
            items.remove(itemToRemove);
    }

    /**
     * Procura um item no inventário pelo nome informado
     * @param itemName nome do item a ser procurado
     * @return o item encontrado. Null caso o item não exista no inventário
     */
    public Item getItemByName(String itemName)
    {
        Item foundItem = null;
        for(Item item : items)
        {
            //Devido a complexidade dos nomes dos itens, a linha  item.getItemName().toLowerCase().contains(itemName.toLowerCase())
            //tenta localizar o item, mesmo que o nome esteja incompleto
            if(item.getItemName().equalsIgnoreCase(itemName) || item.getItemName().toLowerCase().contains(itemName.toLowerCase())) {
                foundItem = item;
                break;
            }
        }
        return foundItem;
    }

    /**
     * Verifica o peso total do inventário
     * @return o peso total em float
     */
    public float getCurrentWeight()
    {
      float pesoAtual = 0;
      for(Item item : items)
      {
          pesoAtual += item.getItemWeight();
      }
      return pesoAtual;
    }

    /**
     * Retorna o nome de todos os itens deste inventário
     * @return O nome dos itens.
     */
    public String getItensName()
    {
        String itensName = "";
        for(int index = 0; index < items.size() ; index ++)
        {
            if(index == items.size() - 1)
            {
                itensName += "Nome: " + items.get(index).getItemName() + " | Peso: " + items.get(index).getItemWeight();
            }
            else
                {
                    itensName += "Nome: " + items.get(index).getItemName() + " | Peso: " + items.get(index).getItemWeight() + ", ";
                }
        }
        return itensName;
    }

}
