package br.edu.poo;

public class Personagem {

    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private boolean pocaoUtilizada;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.pocaoUtilizada = false; 
    }

    public void atacar(Personagem inimigo) {
        inimigo.receberDano(this.ataque);
    }

    public void receberDano(int dano) {
        int danoReal = dano - this.defesa;

        if (danoReal > 0) {
            this.vida -= danoReal;
        }

        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public void usarPocao(Pocao pocao) {
        if (!this.pocaoUtilizada) {
            this.vida += pocao.getCura(); 
            this.pocaoUtilizada = true;
        }
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public String getNome() {
        return this.nome;
    }

    public int getVida() {
        return this.vida;
    }
}
