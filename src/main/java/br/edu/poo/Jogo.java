package br.edu.poo;

public class Jogo {

    public static void main(String[] args) {
        Personagem artemis = new Personagem("Artemis", 30, 10, 2);
        Personagem goblin = new Personagem("Goblin", 20, 5, 4);
        Pocao pocaoPequena = new Pocao("Poção Pequena", 10);

        System.out.println("=== BATALHA INICIADA ===");
        System.out.println();

        boolean goblinUsouPocao = false; 

        while (artemis.estaVivo() && goblin.estaVivo()) {

            System.out.println(artemis.getNome() + " ataca " + goblin.getNome());
            artemis.atacar(goblin);
            System.out.println(goblin.getNome() + " possui " + goblin.getVida() + " de vida");
            System.out.println();

            if (!goblin.estaVivo()) {
                break;
            }

            if (goblin.getVida() <= 14 && !goblinUsouPocao) {
                System.out.println(goblin.getNome() + " usa " + pocaoPequena.getNome());
                goblin.usarPocao(pocaoPequena);
                goblinUsouPocao = true; 
                System.out.println(goblin.getNome() + " possui " + goblin.getVida() + " de vida");
                System.out.println();
            } else {
                System.out.println(goblin.getNome() + " ataca " + artemis.getNome());
                goblin.atacar(artemis);
                System.out.println(artemis.getNome() + " possui " + artemis.getVida() + " de vida");
                System.out.println();
            }
        }

        System.out.println("...");
        System.out.println();
        System.out.println("=== FIM DA BATALHA ===");
        System.out.println();

        if (artemis.estaVivo()) {
            System.out.println("Vencedor: " + artemis.getNome());
        } else {
            System.out.println("Vencedor: " + goblin.getNome());
        }
    }
}
