package domain;

import domain.enums.Universe;

public class Heroes {
    private String nome;
    private Integer codigo;
    private Integer forca;
    private Universe universo;

    public Heroes() {
        
    }

    public Heroes(String nome, Integer codigo, Integer forca, Universe universo) {
        this.nome = nome;
        this.codigo = codigo;
        this.forca = forca;
        this.universo = universo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getForca() {
        return this.forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Universe getUniverso() {
        return this.universo;
    }

    public void setUniverso(Universe universo) {
        this.universo = universo;
    }
    @Override
    public String toString(){
        return codigo
             + " - "
             + nome
             + " - Força do herói: "
             + forca
             + " - do "
             + universo;
    }

    public String toCsvLine(){
        return new StringBuilder()
                        .append(this.codigo).append(",")
                        .append(this.nome).append(",")
                        .append(this.forca).append(",")
                        .append(this.universo)
                        .toString();
    }

    public static Heroes fromCsvLine (String linha){
        String[] campos = linha.split(",");
        return new Heroes((campos[1]),
                    Integer.parseInt(campos[0]), 
                    Integer.parseInt(campos[2]), 
                    Universe.valueOf(campos[3]));
    }
    
}
