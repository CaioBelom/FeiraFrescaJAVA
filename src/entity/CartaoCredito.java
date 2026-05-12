package entity;

public class CartaoCredito {

    private String nomeTitular;
    private String numeroCartao;
    private String validade;
    private String cvv;

    public CartaoCredito(String nomeTitular,
                         String numeroCartao,
                         String validade,
                         String cvv) {

        this.nomeTitular = nomeTitular;
        this.numeroCartao = numeroCartao;
        this.validade = validade;
        this.cvv = cvv;
    }

    public boolean validarCartao() {

        return numeroCartao.length() >= 12 && cvv.length() == 3;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getValidade() {
        return validade;
    }

    public String getCvv() {
        return cvv;
    }

    public String getNumeroMascarado() {

        if (numeroCartao.length() < 4) {
            return "****";
        }

        return "**** **** **** " +
                numeroCartao.substring(numeroCartao.length() - 4);
    }
}