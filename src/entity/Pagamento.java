package entity;

public class Pagamento {

    private double valorPago;
    private String statusPagamento;

    public Pagamento(double valorPago) {

        this.valorPago = valorPago;
        this.statusPagamento = "Pendente";
    }

    public boolean processarPagamento(CartaoCredito cartao) {

        if (cartao.validarCartao()) {

            statusPagamento = "Confirmado";

            return true;
        }

        statusPagamento = "Recusado";

        return false;
    }

    public double getValorPago() {

        return valorPago;
    }

    public String getStatusPagamento() {

        return statusPagamento;
    }
}