/**
 * @authors Bruno Alef, Bruno Giovani, Lazaro Junior, Lucas Laet and Matheus Giovanny.
 * @version 1.0 of 2019.
 */

public class Player
{
   
  private String playerName;
  private Inventory playerInventory;
  private float playerWeight;
  private float playerMaxWeight = 120; //KG

  public Player(String playerName)
  {
    this.playerName = playerName;
    playerInventory = new Inventory();
  }
  /**
   * Altera o peso maximo que o jogador consegue carregar
   * @param novoPesoMaximo O peso máximo que o jogador poderar carregar
   */
  public void setPlayerMaxWeight(float novoPesoMaximo)
  {
    playerMaxWeight = novoPesoMaximo;
  }
  /**
   * Adiciona um item ao inventário do jogador
   * @param item O item a ser adicionado ao inventário do jogador
   */
  public boolean addPlayerInventoryItem(Item item)
  {
    if(item.isCollectible())
    {
      if ((item.getItemWeight() + playerInventory.getCurrentWeight() <= playerMaxWeight))
      {
        System.out.println("Novo item no inventário: [" + item.getItemName() + "].");
        playerInventory.addNewItem(item);
        return true;
      }
      else if((item.getItemWeight() + playerInventory.getCurrentWeight() > playerMaxWeight))
      {
        System.out.println("O item não pôde ser adicionado ao inventário, pois o peso de seu inventário será excedido em: "
                + (item.getItemWeight() + playerInventory.getCurrentWeight() - playerMaxWeight));
      }
    }
    else
      {
        System.out.println("Este item não é coletável.\nHum... já tentou interagir de outra forma? Nunca se sabe...");
        return false;
      }
      return false;
  }

  /**
   * Retorna o inventário do jogador
   * @return O inventário do jogador
   */
  public Inventory getPlayerInventory(){
    return playerInventory;
  }
  
  /**
   * Retorna o nome do jogador
   * @return O nome do jogador em Strin
   */
  public String getPlayerName()
  { 
      return playerName; 
  }
  
}
