package application;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Heroes;
import domain.enums.Universe;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Olá, Mundo");
        System.out.println("Seja bem vindo ao Super Heroes Program!");
        System.out.println();

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
        int n = 0;
        int codigo = herois.size() + 1;

        while (n != 3){

            System.out.println("Escolha a opção desejada:");
            System.out.println("1 - Cadastro de herói");
            System.out.println("2 - Listar heróis");
            System.out.println("3 - Sair do programa");
            n = sc.nextInt();
            sc.nextLine();

            if (n == 1) {
                System.out.print("Nome do herói: ");
                String nome = sc.nextLine();
                System.out.print("Coeficiente de força do herói(1-1000): ");
                int forca = sc.nextInt();
                System.out.print("Universo do Herói: ");
                Universe universo = Universe.valueOf(sc.next());
                herois.add(new Heroes(nome, codigo, forca, universo));
                codigo++;
            }

            if (n==2) {
                for (Heroes c : herois){
                    System.out.println(c.toString());
                }
            }

            if (n==3) {
                List<String> linhas = new ArrayList<>();
		        for(Heroes c : herois) {
			    linhas.add(c.toCsvLine());
		    }	
		        try {
                    Files.write(Paths.get(NOME_ARQUIVO), linhas, StandardCharsets.ISO_8859_1, StandardOpenOption.CREATE);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            System.out.println();

        }

        sc.close();
    }
    private static final String NOME_ARQUIVO = "dados.csv";
}
