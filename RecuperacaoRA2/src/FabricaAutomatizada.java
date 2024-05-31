import java.util.Random;

public class FabricaAutomatizada {
    public static void main(String[] args) {
        GerenciadorAmbiente gerenciador = new GerenciadorAmbiente();
        Random random = new Random();

        // Adicionar pares de sensores e atuadores dinamicamente
        adicionarParIoT(gerenciador, new TermometroNexcon(20 + random.nextDouble() * 5), new ControleArCondicionadoAgratto(22, 24, 10), "Ambiente Temperatura");
        adicionarParIoT(gerenciador, new SensorFumacaA(3), new AlarmeIncendioA(), "Maquinas");
        adicionarParIoT(gerenciador, new SensorFumacaB(3), new AlarmeIncendioB(), "Estera");

        // Inicia o monitoramento do ambiente
        gerenciador.monitorarAmbiente();
    }

    private static void adicionarParIoT(GerenciadorAmbiente gerenciador, Sensor sensor, Atuador atuador, String id) {
        gerenciador.adicionarPar(sensor, atuador, id);
    }
}
