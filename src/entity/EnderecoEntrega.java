package entity;

public class EnderecoEntrega {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoEntrega(String logradouro,
                           String numero,
                           String bairro,
                           String cidade,
                           String estado,
                           String cep) {

        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getEnderecoCompleto() {

        return logradouro + ", " +
                numero + " - " +
                bairro + ", " +
                cidade + "/" +
                estado + " - CEP: " +
                cep;
    }
}