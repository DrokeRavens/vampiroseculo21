import java.util.concurrent.TimeUnit;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room casteloVilaEsperanca, butecoDoVladmilson, supermercadosHb, postoLipiranga, Ifmg;
      
        // create the rooms
        casteloVilaEsperanca = new Room("Um castelo feito de tijolo e reboco.");
        butecoDoVladmilson = new Room("Um buteco onde os demais seres sobrenaturais se reunem.");
        supermercadosHb = new Room("Um supermercado que tem muito além do que uma picanha sangrando.");
        postoLipiranga = new Room("Um posto comum, onde o preço da gasolina é mais assustador que qualquer monstro.");
        Ifmg = new Room("Uma faculdade onde o maior lorde Vampiro leciona, Calex Carlayle III.");
        // initialise room exits
        casteloVilaEsperanca.setExits(null, supermercadosHb, butecoDoVladmilson, postoLipiranga,null,null);
        supermercadosHb.setExits(casteloVilaEsperanca, null, null, null,null,null);
        postoLipiranga.setExits(null, null, casteloVilaEsperanca, Ifmg,null,null);
        

        currentRoom = casteloVilaEsperanca;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() throws Exception
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Obrigado por jogar. Um beijo no pescoço.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Bem vindo a Sabará Hills!");
        System.out.println("Você é um vampiro que vive no século XXI\nacorda em seu castelo localizado no bairro Vila Esperança");
        System.out.println("Digite 'acode eu' se precisar de ajuda.");
        System.out.println();
        currentRoom.getExitString();
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) throws Exception
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Não entendi oque você digitou...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.toLowerCase().equals("acode"))
            printHelp();
        else if (commandWord.toLowerCase().equals("partiu"))
            goRoom(command);
        else if (commandWord.toLowerCase().equals("sair"))
            wantToQuit = quit(command);

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() throws Exception 
    {
        System.out.println("Você está sozinho em seu castelo. Cuidado com a luz, pois nela você brilha...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Sua encomenda do sangue mais raro do mundo, o sangue Bombay,fora extraviada pelos correios.");
        System.out.println();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Seus comandos são:");
        System.out.println("   partiu | sair | acode");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Ir aonde?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        
        if (nextRoom == null) {
            System.out.println("Não há saída nessa direção.");
        }
        else {
            currentRoom = nextRoom;
            currentRoom.getExitString();
            System.out.println();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Sair oque?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /**
    private void printLocationInfo()
    {
        currentRoom.getExitString();
    }
    */
}
