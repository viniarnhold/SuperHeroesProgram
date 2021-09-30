package domain;

import domain.enums.Universe;

public class Heroes {
    private Integer codigo;
    private String nome;
    private Universe universo;
    private Integer vida;
    private Integer forca;
    private Integer agilidade;
    private Integer inteligencia;

    public Heroes() {
        
    }

    public Heroes(Integer codigo, String nome, Universe universo, Integer vida, Integer forca, Integer agilidade, Integer inteligencia) {
        this.codigo = codigo;
        this.nome = nome;
        this.universo = universo;
        this.vida = vida;
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Universe getUniverso() {
        return universo;
    }

    public void setUniverso(Universe universo) {
        this.universo = universo;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(Integer agilidade) {
        this.agilidade = agilidade;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void cadastrarHerois(){

    }

    @Override
    public String toString() {
        return  "Codigo = " + codigo +
                ", nome = " + nome + '\'' +
                ", universo = " + universo +
                ", vida = " + vida +
                ", forca = " + forca +
                ", agilidade = " + agilidade +
                ", inteligencia = " + inteligencia;
    }

    public String toCsvLine(){
        return new StringBuilder()
                        .append(this.codigo).append(",")
                        .append(this.nome).append(",")
                        .append(this.universo).append(",")
                        .append(this.vida).append(",")
                        .append(this.forca).append(",")
                        .append(this.inteligencia).append(",")
                        .append(this.agilidade).append(",")
                        .toString();
    }

    public static Heroes fromCsvLine (String linha){
        String[] campos = linha.split(",");
        return new Heroes(Integer.parseInt(campos[0]),
                    (campos[1]),
                    Universe.valueOf(campos[2]),
                    Integer.parseInt(campos[3]),
                    Integer.parseInt(campos[4]),
                    Integer.parseInt(campos[5]),
                    Integer.parseInt(campos[6]));
    }
}
