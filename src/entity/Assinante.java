package entity;

public class Assinante {

    private String celular;
    private boolean aceitouTermos;

    public Assinante(String celular, boolean aceitouTermos) {
        this.celular = celular;
        this.aceitouTermos = aceitouTermos;
    }

    public String getCelular() {
        return celular;
    }

    public boolean isAceitouTermos() {
        return aceitouTermos;
    }
}