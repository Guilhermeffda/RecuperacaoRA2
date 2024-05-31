import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAmbiente {
    private List<ParIoT> pares = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void adicionarPar(Sensor sensor, Atuador atuador, String id) {
        ParIoT par = new ParIoT(sensor, atuador, id);
        pares.add(par);
    }

    public void monitorarAmbiente() {
        while (true) {
            for (ParIoT par : pares) {
                double dado = par.sensor.lerDado();
                par.atuador.aplicar(dado);
                String timestamp = LocalDateTime.now().format(formatter);
                System.out.println(timestamp + " (" + par.id + ") Dado lido: " + dado);
            }
            try {
                Thread.sleep(1000); // Espera 1 segundo antes da próxima leitura
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
