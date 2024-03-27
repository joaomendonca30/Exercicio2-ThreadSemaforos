package view;

import controller.AeronaveController;

public class Main {
    private static final int NUMERO_AERONAVES = 12;

    public static void main(String[] args) {
        for (int i = 1; i <= NUMERO_AERONAVES; i++) {
            AeronaveController aeronave = new AeronaveController("A aeronave " + i);
            aeronave.start();
        }
    }
}