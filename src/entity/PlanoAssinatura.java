package entity;

public class PlanoAssinatura {

    private String nomePlano;
    private double valorSemanal;

    private int qtdFrutas;
    private int qtdLegumes;
    private int qtdVerduras;

    private String descricao;

    public PlanoAssinatura(String nomePlano,
                           double valorSemanal,
                           int qtdFrutas,
                           int qtdLegumes,
                           int qtdVerduras,
                           String descricao) {

        this.nomePlano = nomePlano;
        this.valorSemanal = valorSemanal;

        this.qtdFrutas = qtdFrutas;
        this.qtdLegumes = qtdLegumes;
        this.qtdVerduras = qtdVerduras;

        this.descricao = descricao;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public double getValorSemanal() {
        return valorSemanal;
    }

    public int getQtdFrutas() {
        return qtdFrutas;
    }

    public int getQtdLegumes() {
        return qtdLegumes;
    }

    public int getQtdVerduras() {
        return qtdVerduras;
    }

    public String getDescricao() {
        return descricao;
    }
}