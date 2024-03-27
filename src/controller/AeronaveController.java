package controller;

import java.util.concurrent.Semaphore;

public class AeronaveController extends Thread{

    private static final Semaphore semaforoManobra = new Semaphore(1);
    private static final Semaphore semaforoTaxiar = new Semaphore(1);
    private static final Semaphore semaforoDecolagem = new Semaphore(1);
    private static final Semaphore semaforoAfastamento = new Semaphore(1);
    private static final Semaphore semaforoAreaDecolagem = new Semaphore(2);
    private final String nome;

    public AeronaveController(String nome) {
        this.nome = nome;
    }

    private void faseManobra() throws InterruptedException {
        semaforoManobra.acquire();
        Thread.sleep((long) (Math.random() * 401) + 300);
        System.out.println(nome + " completou a fase de manobra.");
        semaforoManobra.release();
    }

    private void faseTaxiar() throws InterruptedException {
        semaforoTaxiar.acquire();
        Thread.sleep((long) (Math.random() * 501) + 500);
        System.out.println(nome + " completou a fase de taxiar.");
        semaforoTaxiar.release();
    }

    private void faseDecolagem() throws InterruptedException {
        semaforoDecolagem.acquire();
        semaforoAreaDecolagem.acquire();
        Thread.sleep((long) (Math.random() * 201) + 600);
        System.out.println(nome + " completou a fase de decolagem.");
        semaforoDecolagem.release();
        semaforoAreaDecolagem.release();
    }

    private void faseAfastamento() throws InterruptedException {
        semaforoAfastamento.acquire();
        Thread.sleep((long) (Math.random() * 501) + 300);
        System.out.println(nome + " completou a fase de afastamento.");
        semaforoAfastamento.release();
    }

    @Override
    public void run() {
        try {
            faseManobra();
            faseTaxiar();
            faseDecolagem();
            faseAfastamento();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
