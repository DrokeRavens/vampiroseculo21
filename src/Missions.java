/**
 * Escreva a descrição da classe Missions aqui.
 * 
 * @authors Bruno Alef, Bruno Giovani, Lazaro Junior, Lucas Laet and Matheus Giovanny.
 * @version 1.0 of 2019.
 */

import java.util.concurrent.TimeUnit;
import java.util.*;

public class Missions
{
    // Anterior era um ArrayList, foi alterado para um HashMap pois é necessário saber se a quest foi concluida ou não.
    //Sendo True para concluida e False para pendente.
    private HashMap<String, Boolean> missions;
    private int orderHierarchy;
    private Quiz quiz;
    
    /**
     * COnstrutor para objetos da classe Missions
     */
    public Missions()
    {
        // inicializa variáveis de instância
        quiz = new Quiz();
        missions = new HashMap<>();
        orderHierarchy = 1;
    }
    
    /**
     * Imprime as missões existentes no jogo
     */
    public void getMissions()
    {
        for(String mission : missions.keySet()){
            System.out.println(" •> " + mission + (missions.get(mission) ? " [Concluida]" : " [Pendente]"));
        }
    }
    
    /**
     * Adiciona uma nova missão
     * @param mission A missão a ser adicionada
     */
    public void addMission(String mission)
    {
        missions.put(mission, false);
    }

    /**
     * Encerra a missão de nome informado.
     * @param mission A missão a ser encerrada
     * @return True se foi possivel finalizar a missao, and false caso contrario
     */
    public boolean finishMission(String mission)
    {
        if(missions.containsKey(mission))
        {
           missions.replace(mission, true);
           return true;
        }
        else
        {
            return false;
        }        
    }
    
    /**
     * This calls a quiz object method for the purpose to do the final quiz of the game.
     */
    public boolean getFinalQuiz() throws Exception
    {
        return quiz.finalQuiz();
    }
    
    /**
     * This method set's the order of missions, to bring the line of a sequencial game tasks. 
     */
    public void setHierarchy(int order)
    {
        orderHierarchy = order;
    }

    /**
     * Return the mission hierarchy
     * @return the hierarchy
     */
    public int getHierarchy()
    {
        return orderHierarchy;
    }
}
