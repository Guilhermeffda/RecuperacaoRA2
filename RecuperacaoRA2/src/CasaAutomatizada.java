import java.util.Random;

public class CasaAutomatizada {
    public static void main(String[] args) {
        GerenciadorAmbiente gerenciador = new GerenciadorAmbiente();
        Random random = new Random();
        String[] ambientes = {"Sala de Estar", "Cozinha", "Quarto"};

        // Adicionar pares de sensores e atuadores dinamicamente
        for (int i = 0; i < ambientes.length; i++) {
            double temperaturaInicial = 20 + random.nextDouble() * 5; // Valor entre 20 e 25
            Termometro termometro = (i % 2 == 0) ? new TermometroNexcon(temperaturaInicial) : new TermometroTuya(temperaturaInicial);
            ControleArCondicionado controle = (i % 2 == 0) ?
                    new ControleArCondicionadoAgratto(22, 24, 10) :
                    new ControleArCondicionadoSpringer(22, 24, 10);
            gerenciador.adicionarPar(termometro, controle, ambientes[i]);
        }

        // Inicia o monitoramento do ambiente
        gerenciador.monitorarAmbiente();
    }
}
