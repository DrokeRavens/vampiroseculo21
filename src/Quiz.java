/**
 * @authors Bruno Alef, Bruno Giovani, Lazaro Junior, Lucas Laet and Matheus Giovanny.
 * @version 1.0 of 2019.
 */

import java.util.*;

public class Quiz
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String[] questsAnswers;
    private String[] quests;
    private Parser parser;
    
    /**
     * COnstrutor para objetos da classe FinalQuiz
     */
    public Quiz()
    {
        createQuestions();
        parser = new Parser();
    }

    private void createQuestions()
    {
        quests = new String[] {"Se ontem fosse amanhã, hoje seria sexta-feira.\nQue dia é hoje?",
                            "Um número é denominado vampiro quando possui uma quantidade par de algarismos.\n" + 
                            "Pode ser escrito a partir da multiplicação de dois fatores (chamados presas).\n" +
                            "Estes, devem conter os mesmos algarismos deste número e a mesma quantidade de vezes que são repetidos nele."};
        questsAnswers = new String[] {" - Segunda\n - Quarta\n - Domingo\n - Sexta"," - 2187\n - 2056\n - 2331", 
                                    " - 105750\n - 111181\n - 129452", " - 1397\n - 126027\n - 200998"};                                        
    }
    
    public boolean finalQuiz() throws Exception
    {
        Random maybeRandom = new Random();
        for(int i = 0;i < 2;i++){
           if(i == 0){
               Console.writeText(quests[i] + "\nOpções de resposta:\n" + questsAnswers[i]);
               String answer = parser.getAnswer();
               if(answer.equals("domingo")){
                   Console.writeText("Que interessante.\nSua pontuação é K. Vamos para a última proposição.");
                }
           }else{
               Console.writeText(quests[i] + "\nOpções de resposta:\n" + questsAnswers[( 1 + maybeRandom.nextInt(3))]);
               String answer = parser.getAnswer();
               if(answer.equals("105750") || answer.equals("2187") || answer.equals("126027")){
                   Console.writeText("Parabéns! Sua pontuação foi K + 1.\nVocê é digno de recuperar sua encomenda!!");
                   return true;
                }
           }
        }
        return false;
    }
    
}
