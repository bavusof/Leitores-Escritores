package estrutura;

import estrutura.threads.Reader;
import estrutura.threads.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import estrutura.dados.Data;

public class Main {
    public static void main(String[] args) {
        
        // Inicializa a estrutura de dados e carrega o arquivo
        Data data = new Data("bd.txt");

        // Popula o array de threads de maneira aleatória com Readers e Writers
        List<Thread> threads = new ArrayList<>();
        populateThreadsArray(threads, 50, 50);

        // Executa cada thread no array
        for (Thread thread : threads) {
            thread.start();
        }

        // Espera todas as threads terminarem
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void populateThreadsArray(List<Thread> threads, int numReaders, int numWriters) {
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < numReaders; i++) {
            threadList.add(new Thread(new Reader()));
        }

        for (int i = 0; i < numWriters; i++) {
            threadList.add(new Thread(new Writer()));
        }

        // Embaralha a lista para garantir a aleatoriedade
        Collections.shuffle(threadList);

        // Adiciona as threads embaralhadas à lista principal
        threads.addAll(threadList);
    }
}
