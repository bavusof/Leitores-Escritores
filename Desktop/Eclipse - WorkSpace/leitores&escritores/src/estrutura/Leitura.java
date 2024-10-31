package estrutura;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitura {
    public static void main(String[] args) {
        String fileName = "bd.txt"; 	// Nome do arquivo de texto
        List<String> wordsList = new ArrayList<>();		// Estrutura utilizada

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove todas as pontuações substituindo-as por espaço
                line = line.replaceAll("[\\p{Punct}]", " ");
            	
                // Divide a linha em palavras por espaços em branco
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordsList.add(word); // Adiciona a palavra na estrutura
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Transfere a lista para um array
        String[] wordsArray = wordsList.toArray(new String[0]);

        // Imprime o array
        for (String word : wordsArray) {
            System.out.println(word);
        }
    }
}