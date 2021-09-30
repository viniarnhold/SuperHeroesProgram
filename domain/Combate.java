package domain;

import java.util.Scanner;

public class Combate {
    private Heroes player1;
    private Heroes player2;

    public Combate(Heroes player1, Heroes player2) {
        Scanner sc = new Scanner(System.in);
        this.player1 = player1;
        this.player2 = player2;
        System.out.println("Selecione o atributo(V/F/A/I)");
        char atributo = sc.nextLine().charAt(0);

        if(atributo == 'V'){                  //COMBATE COM O ATRIBUTO VIDA
            if(this.player1.getVida() > this.player2.getVida()){
                System.out.println(this.player1.getNome() + " ganhou o combate!");
            } else if(this.player1.getVida() < this.player2.getVida()){
                System.out.println(this.player2.getNome() + " ganhou o combate!");
            } else{
                System.out.println("Houve um empate no combate");
            }

        } else if (atributo == 'F') {        //COMBATE COM O ATRIBUTO FORÇA
            if (this.player1.getForca() > this.player2.getForca()) {
                System.out.println(this.player1.getNome() + " ganhou o combate!");
            } else if (this.player1.getForca() < this.player2.getForca()) {
                System.out.println(this.player2.getNome() + " ganhou o combate!");
            } else {
                System.out.println("Houve um empate no combate");
            }
        } else if (atributo == 'A'){         //COMBATE COM O ATRIBUTO AGILIDADE
            if (this.player1.getAgilidade() > this.player2.getAgilidade()) {
                System.out.println(this.player1.getNome() + " ganhou o combate!");
            } else if (this.player1.getAgilidade() < this.player2.getAgilidade()) {
                System.out.println(this.player2.getNome() + " ganhou o combate!");
            } else {
                System.out.println("Houve um empate no combate");
            }
        } else if (atributo == 'I'){         //COMBATE COM O ATRIBUTO INTELIGÊNCIA
            if (this.player1.getInteligencia() > this.player2.getInteligencia()) {
                System.out.println(this.player1.getNome() + " ganhou o combate!");
            } else if (this.player1.getInteligencia() < this.player2.getInteligencia()) {
                System.out.println(this.player2.getNome() + " ganhou o combate!");
            } else {
                System.out.println("Houve um empate no combate");
            }
        } else {
            System.out.println("Atributo não encontrado!");
        }
    }

    public Heroes getPlayer1() {
        return player1;
    }

    public void setPlayer1(Heroes player1) {
        this.player1 = player1;
    }

    public Heroes getPlayer2() {
        return player2;
    }

    public void setPlayer2(Heroes player2) {
        this.player2 = player2;
    }
}
