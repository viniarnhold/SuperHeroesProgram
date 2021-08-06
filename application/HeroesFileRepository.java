package application;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import domain.Heroes;
import domain.HeroesRepository;

public class HeroesFileRepository implements HeroesRepository {

    @Override
    public List<Heroes> findAll() {

        List<Heroes> herois = new ArrayList<>();
        File dados = new File(NOME_ARQUIVO);
        if(dados.exists() && !dados.isDirectory()){

            try {
                List<String> linhasLidas = Files.readAllLines(Paths.get(NOME_ARQUIVO));
                for(String linha : linhasLidas){

                    herois.add(Heroes.fromCsvLine(linha));
                }
            } 
            catch (IOException e) {
                System.out.println("Erro ao carregar banco de dados");
                
                System.exit(-1);
		    }
        }
        return herois;
    }

    @Override
    public void saveAll(List<Heroes> herois) {
        
        List<String> linhas = new ArrayList<>();
        for(Heroes c : herois) {
        linhas.add(c.toCsvLine());
    }	
        try {
            Files.write(Paths.get(NOME_ARQUIVO), linhas, StandardCharsets.ISO_8859_1, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.print("Houve um erro ao salvar os herois");;
        }
        
    }
    public static String NOME_ARQUIVO = "dados.csv";  
}
