package entity;

import java.util.Random;

public class VerificacaoSMS {

    private String codigoGerado;

    public String gerarCodigoSMS(String numero) {

        Random random = new Random();

        int codigo = 1000 + random.nextInt(9000);

        this.codigoGerado = String.valueOf(codigo);

        return this.codigoGerado;
    }

    public boolean validarCodigo(String codigoInformado) {

        return codigoGerado != null &&
                codigoGerado.equals(codigoInformado);
    }

    public String reenviarCodigo(String numero) {

        return gerarCodigoSMS(numero);
    }
}