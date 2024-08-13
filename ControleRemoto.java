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
    public void ligar() {
        setLigado(true);
    }
    public void desligar() {
        setLigado(false);
    }
    public void abrirMenu() {
        System.out.println(getLigado());
        System.out.println(getVolume());
        for (int i = 0; getVolume() >= i; i += 10) {
            System.out.print("|");
        }
        System.out.println(getTocando());
    }
    public void fecharMenu() {
        System.out.println("Fechando menu");
    }
    public void maisVolume() {
        if (getLigado()) { //Se "getLigado()" for verdadeiro, então..
            setVolume(getVolume() + 5); //"setVolume()" define o valor atual de "getVolume()" + 1
        }
    }
    public void menosVolume() {
        if (getLigado()) { //Se "getLigado()" for verdadeiro, então..
            setVolume(getVolume() - 5); //"setVolume()" define o valor atual de "getVolume()" + 1
        }
    }
    public void ligarMudo() {
        if (getLigado() & getVolume() > 0) {
            setVolume(0);;
        }
    }
    public void desligarMudo() {
        if (getLigado() & getVolume() == 0) {
            setVolume(50);;
        }
    }
    public void play() {
        if (getLigado() && !getTocando()) { //Se "getLigado()" for verdadeiro e ("&&") "getTocando()" for falso ("!"), então...
            setTocando(true); //"setTocando()" recebe "true"
        }
    }
    public void pause() {
        if (getLigado() && getTocando()) { //Se "getLigado()" for verdadeiro e ("&&") "getTocando()" for verdadeiro, então...
            setTocando(false); //"setTocando()" recebe "false"
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
        this.ligado = t;
    }
}

