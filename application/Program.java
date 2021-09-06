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

import domain.Combate;
import domain.Heroes;
import domain.enums.Universe;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Olá, Mundo");
        System.out.println("Seja bem vindo ao Super Heroes Program!");
        System.out.println();

        HeroesFileRepository repository = new HeroesFileRepository();
        List<Heroes> herois = repository.findAll();

        int n = 0;
        int codigo = herois.size() + 1;

        while (n != 4){
            ExibicaoMenu.exibir();
            n = sc.nextInt();
            sc.nextLine();

            if (n == 1) {
                System.out.print("Nome do herói: ");
                String nome = sc.nextLine();
                System.out.print("Universo do Herói(DC/MARVEL): ");
                Universe universo = Universe.valueOf(sc.next());
                System.out.print("Vida do herói: ");
                Integer vida = sc.nextInt();
                System.out.print("Força do heroi: ");
                Integer forca = sc.nextInt();
                System.out.print("Agilidade do heroi: ");
                Integer agilidade = sc.nextInt();
                System.out.print("Inteligencia do heroi: ");
                Integer inteligencia = sc.nextInt();
                herois.add(new Heroes(codigo, nome, universo, vida, forca, agilidade, inteligencia));
                codigo++;
                System.out.println("Herói cadastrado com sucesso!");
            }

            if (n==2) {
                for (Heroes c : herois){
                    System.out.println(c.toString());
                }
            }

            if (n==3){
                Heroes player1 = null;
                Heroes player2 = null;
                System.out.println("Escolha o primeiro herói do combate(código):");
                int p1 = sc.nextInt();
                for(Heroes c : herois){
                    if (p1 == c.getCodigo()){
                        player1 = c;
                        break;
                    }
                }
                System.out.println("Escolha o segundo heroi do combate(código):");
                int p2 = sc.nextInt();
                for(Heroes c : herois){
                    if (p2 == c.getCodigo()){
                        player2 = c;
                        break;
                    }
                }
                if(player1.getCodigo() != player2.getCodigo()) {
                    Combate combate = new Combate(player1, player2);
                } else {
                    System.out.println("Você não pode selecionar herois iguais");
                }


            }
            if (n==4) {
                repository.saveAll(herois);
            }
            System.out.println();

        }

        sc.close();
    }

public static final String NOME_ARQUIVO = "dados.csv";
 
}
