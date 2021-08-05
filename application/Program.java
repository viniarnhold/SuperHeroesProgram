package application;

import java.nio.charset.StandardCharsets;
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

            List<Heroes> list = new ArrayList<>();

            int n = 0;
            int codigo = 1;
        while (n != 3){

            System.out.println("Escolha a opção desejada:");
            System.out.println("1 - Cadastro de herói");
            System.out.println("2 - Listar heróis");
            System.out.println("3 - Sair do programa");
            n = sc.nextInt();
            sc.nextLine();

            if (n == 1){
                System.out.print("Nome do herói: ");
                String nome = sc.nextLine();
                System.out.print("Coeficiente de força do herói(1-1000): ");
                int forca = sc.nextInt();
                System.out.print("Universo do Herói: ");
                Universe universo = Universe.valueOf(sc.next());
                list.add(new Heroes(nome, codigo, forca, universo));
                codigo++;
            }

            if (n==2){
                for (Heroes c : list){
                    System.out.println(c.toString());
                }
            }
            System.out.println();

        }

        sc.close();
    }
}
