/**
 * Escreva a descrição da classe Missions aqui.
 * 
 * @authors Bruno Alef, Bruno Giovani, Lazaro Junior, Lucas Laet and Matheus Giovanny.
 * @version 1.0 of 2019.
 */

import java.util.concurrent.TimeUnit;

public class Console {
    public static void writeText(String textToByWritten) throws Exception
    {
        for(Character textChar : textToByWritten.toCharArray())
        {
            System.out.print(textChar);
            TimeUnit.MILLISECONDS.sleep(50);
        }
        System.out.println();
    }
}
