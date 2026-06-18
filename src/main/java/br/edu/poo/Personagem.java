package br.edu.poo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {

    @Test
    void deveCriarPersonagem() {

        Personagem p =
                new Personagem(
                        "Artemis",
                        30,
                        8,
                        3);

        assertEquals("Artemis", p.getNome());
        assertEquals(30, p.getVida());
    }

    @Test
    void deveReceberDano() {

        Personagem p =
                new Personagem(
                        "Artemis",
                        30,
                        8,
                        3);

        p.receberDano(10);

        assertEquals(20, p.getVida());
    }

    @Test
    void vidaNaoPodeFicarNegativa() {

        Personagem p =
                new Personagem(
                        "Artemis",
                        30,
                        8,
                        3);

        p.receberDano(100);

        assertEquals(0, p.getVida());
    }

    @Test
    void deveCalcularAtaque() {

        Personagem heroi =
                new Personagem(
                        "Heroi",
                        30,
                        8,
                        3);

        Personagem goblin =
                new Personagem(
                        "Goblin",
                        20,
                        6,
                        2);

        heroi.atacar(goblin);

        assertEquals(14, goblin.getVida());
    }

    @Test
    void danoMinimoDeveSerUm() {

        Personagem tanque =
                new Personagem(
                        "Tanque",
                        30,
                        5,
                        10);

        Personagem guerreiro =
                new Personagem(
                        "Guerreiro",
                        30,
                        8,
                        3);

        guerreiro.atacar(tanque);

        assertEquals(29, tanque.getVida());
    }

    @Test
    void personagemDerrotadoNaoEstaVivo() {

        Personagem p =
                new Personagem(
                        "Heroi",
                        30,
                        8,
                        3);

        p.receberDano(30);

        assertFalse(p.estaVivo());
    }

    @Test
    void deveUsarPocao() {

        Personagem heroi =
                new Personagem(
                        "Heroi",
                        30,
                        8,
                        3);

        heroi.receberDano(10);

        Pocao pocao =
                new Pocao(
                        "Pequena",
                        5);

        heroi.usarPocao(pocao);

        assertEquals(25, heroi.getVida());
    }

    @Test
    void devePermitirApenasUmaPocao() {

        Personagem heroi =
                new Personagem(
                        "Heroi",
                        30,
                        8,
                        3);

        heroi.receberDano(20);

        Pocao p1 =
                new Pocao(
                        "Pequena",
                        5);

        Pocao p2 =
                new Pocao(
                        "Grande",
                        20);

        heroi.usarPocao(p1);
        heroi.usarPocao(p2);

        assertEquals(15, heroi.getVida());
    }
}
