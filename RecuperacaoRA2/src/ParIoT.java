public class ParIoT {
    Sensor sensor;
    Atuador atuador;
    String id;

    public ParIoT(Sensor sensor, Atuador atuador, String id) {
        this.sensor = sensor;
        this.atuador = atuador;
        this.id = id;
    }
}
