package entity;

import java.util.Random;

public class Protocolo {

    private String numeroProtocolo;

    public Protocolo() {

        Random random = new Random();

        this.numeroProtocolo = "FF-" + (10000 + random.nextInt(90000));
    }

    public String getNumeroProtocolo() {

        return numeroProtocolo;
    }
}