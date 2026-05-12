package entity;

public class Produto {

    private String nome;
    private String tipo;
    private String unidadeComercial;
    private int quantidade;

    public Produto(String nome,
                   String tipo,
                   String unidadeComercial,
                   int quantidade) {

        this.nome = nome;
        this.tipo = tipo;
        this.unidadeComercial = unidadeComercial;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUnidadeComercial() {
        return unidadeComercial;
    }

    public int getQuantidade() {
        return quantidade;
    }
}