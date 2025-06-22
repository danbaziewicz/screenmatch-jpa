package br.com.alura.screenmatch.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiKeyLoader {
    public static String loadApiKey() {
        // Tenta pegar a chave da variável de ambiente primeiro
        String apiKey = System.getenv("OMDB_API_KEY");

        // Se não encontrou na variável de ambiente, tenta carregar do arquivo
        if (apiKey == null || apiKey.isBlank()) {
            Properties props = new Properties();
            try (InputStream input = ApiKeyLoader.class.getClassLoader().getResourceAsStream("api-key.properties")) {
                if (input == null) {
                    throw new RuntimeException("Arquivo api-key.properties não encontrado");
                }
                props.load(input);
                apiKey = props.getProperty("API_KEY");

                // Se a chave no arquivo estiver usando ${OMDB_API_KEY}, tenta substituir
                if (apiKey != null && apiKey.startsWith("${") && apiKey.endsWith("}")) {
                    String envVar = apiKey.substring(2, apiKey.length() - 1);
                    apiKey = System.getenv(envVar);
                }

                if (apiKey == null || apiKey.isBlank()) {
                    throw new RuntimeException("API_KEY não encontrada nas variáveis de ambiente nem no arquivo de propriedades");
                }
            } catch (IOException e) {
                throw new RuntimeException("Erro ao carregar a chave da API", e);
            }
        }

        return apiKey;
    }
}
