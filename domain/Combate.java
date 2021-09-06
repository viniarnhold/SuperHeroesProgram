package domain;

public class Combate {
    private Heroes player1;
    private Heroes player2;

    public Combate(Heroes player1, Heroes player2) {
        this.player1 = player1;
        this.player2 = player2;
        if(this.player1.getForca() > this.player2.getForca()){
            System.out.println(this.player1.getNome() + " ganhou o combate!");
        } else if(this.player1.getForca() < this.player2.getForca()){
            System.out.println(this.player2.getNome() + " ganhou o combate!");
        } else{
            System.out.println("Houve um empate no combate");
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
