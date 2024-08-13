package com.aula06;

public class ControleRemoto implements Controlador{ //Quando uma classe implementa uma "interface" (Controlador), precisamos sobrescrever o código que está no arquivo .java da "interface"

    //Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;

    //Método construtor
    public ControleRemoto() {
        this.setVolume(50);
        this.setLigado(false);
        this.setTocando(false);
    }

    //Sobrescrevendo métodos da "interface"

    @Override //Significa que estou reescrevendo métodos que coloquei na minha interface e agora estão sendo usadas com verdadeira utilidade
    public void ligar() {
        setLigado(true);
    }

    @Override
    public void desligar() {
        setLigado(false);
    }

    @Override
    public void abrirMenu() {
        System.out.println("====M E N U====");
        System.out.println("Está ligado? " + this.getLigado());
        System.out.println("Está tocando? " + this.getTocando());
        System.out.println("Volume: "+ this.getVolume());
        for (int i = 0; i <= this.getVolume(); i += 10) {
            System.out.print(" | ");
        }
        System.out.println("");
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando menu...");
    }

    @Override
    public void maisVolume() {
        if (getLigado()) { //Se "getLigado()" for verdadeiro, então..
            setVolume(getVolume() + 5); //"setVolume()" define o valor atual de "getVolume()" + 1
        } else {
            System.out.println("Impossível aumentar o volume");
        }
    }

    @Override
    public void menosVolume() {
        if (getLigado()) { //Se "getLigado()" for verdadeiro, então..
            setVolume(getVolume() - 5); //"setVolume()" define o valor atual de "getVolume()" + 1
        } else {
            System.out.println("Impossível diminuir o volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (getLigado() && getVolume() > 0) {
            setVolume(0);;
        }
    }

    @Override
    public void desligarMudo() {
        if (getLigado() && getVolume() == 0) {
            setVolume(50);;
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())) { //Se "getLigado()" for verdadeiro e ("&&") "getTocando()" for falso ("!"), então...
            this.setTocando(true); //"setTocando()" recebe "true"
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()) { //Se "getLigado()" for verdadeiro e ("&&") "getTocando()" for verdadeiro, então...
            this.setTocando(false); //"setTocando()" recebe "false"
        }
    }

    //Setters e Getters
    private int getVolume() {
        return this.volume;
    }
    private void setVolume(int v) {
        this.volume = v;
    }
    private boolean getLigado() {
        return this.ligado;
    }
    private void setLigado(boolean l) {
        this.ligado = l;
    }
    private boolean getTocando() {
        return this.tocando;
    }
    private void setTocando(boolean t) {
        this.tocando = t;
    }
}
