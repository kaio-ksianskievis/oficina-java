import java.util.Scanner;

public class Jogo {

    private int rodadas;
    private Jogador player1;
    private Jogador player2;

// CONSTRUTOR 
    public Jogo() {

    }

// MÉTODOS DA CLASSE
// Executa o jogo completo
    public void rodaJogo() {
        char controleJogo = 's';

        while(controleJogo == 's' || controleJogo == 'S') {
            int rodadas = 0;
        Scanner scan = new Scanner(System.in);

        while(rodadas != 3 && rodadas != 5) {
            System.out.println("Você quer melhor de 3 ou melhor de 5? Insira apenas o número: ");
            rodadas = scan.nextInt();
        }
        setRodadas(rodadas);
        definePlayers();

        for(int i = 0; i < rodadas; i++) {
            fazUmaRodada();
        }

        encerraJogo();
        controleJogo = jogarNovamente();
        }
        
    }

// Retorna o nome do jogador que foi digitado na tela
    public String defineNome() {
        Scanner scan = new Scanner(System.in);
        String nome = scan.nextLine();
        return nome;
    }

// Cria uma instância dos jogadores (player1 e player2)
    public void definePlayers() {
        
        System.out.println("Digite o nome do jogador 1: ");
        this.player1 = new Jogador(defineNome());
        System.out.println("Digite o nome do jogador 2: ");
        this.player2 = new Jogador(defineNome());
    }

// Faz uma rodada do jogo
    private void fazUmaRodada() {
      System.out.println(player1.getNome() + ", digite 0 (Pedra), 1 (Papel) ou 2 (Tesoura):");
      player1.fazJogada();
      System.out.println(player2.getNome() + ", digite 0 (Pedra), 1 (Papel) ou 2 (Tesoura):");
      player2.fazJogada();

      defineVencRodada();
    }

// Printa na tela quem venceu a rodada
    private void defineVencRodada() {
        int resultado = player1.getJogada() - player2.getJogada();
        String vencedor;

        if(resultado == -2 || resultado == 1) {
            vencedor = player1.getNome();
            player1.setPontos(player1.getPontos() + 1);
        } else if (resultado == 2 || resultado == -1) {
            vencedor = player2.getNome();
            player2.setPontos(player2.getPontos() + 1);
        } else {
            vencedor = "";
        }

        if(vencedor.isEmpty()) {
            System.out.println("Houve um empate!");
        } else {
            System.out.println(vencedor + " ganhou essa rodada!");
        }
    }

// Retorna uma String com o nome do vencedor, ou uma String vazia se houve empate no jogo
    private String vencedorDoJogo() {
        if (player1.getPontos() > player2.getPontos()) {
            return player1.getNome();
        } else if (player2.getPontos() > player1.getPontos()) {
            return player2.getNome();
        } else {
            return "";
        }
    }       

// Printa na tela o vencedor final do jogo
    private void encerraJogo() {
        System.out.println("---------------------------------------------------------");
        if(vencedorDoJogo().isEmpty()) {
            System.out.println("Houve um empate! Que tal jogar de novo?");
        } else {
            System.out.println(vencedorDoJogo() + " venceu esse jogo!");
        }
        System.out.println("---------------------------------------------------------");
    }

// Se a pessoa deseja iniciar um novo jogo
    private char jogarNovamente() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Gostaria de jogar novamente? S para sim e N para não: ");
        char resposta = scan.next().charAt(0);
        return resposta;
    }

    // GETTERS E SETTERS

    public void setRodadas(int rodadas) {
        this.rodadas = rodadas;
    }

    public int getRodadas() {
        return this.rodadas;
    }

    public Jogador getPlayer1() {
        return this.player1;
    }

    public Jogador getPlayer2() {
        return this.player2;
    }

}