import java.util.Random;

public abstract class Termometro implements Sensor {
    protected double ultimaTemperatura;
    private Random random = new Random();

    public Termometro(double ultimaTemperatura) {
        this.ultimaTemperatura = ultimaTemperatura;
    }

    protected double variarTemperatura(double variacaoMaxima) {
        return ultimaTemperatura += (random.nextDouble() * variacaoMaxima * 2) - variacaoMaxima;
    }
}

class TermometroNexcon extends Termometro {
    public TermometroNexcon(double ultimaTemperatura) {
        super(ultimaTemperatura);
    }

    @Override
    public double lerDado() {
        return variarTemperatura(2); // Variação de -2 a +2
    }
}

class TermometroTuya extends Termometro {
    public TermometroTuya(double ultimaTemperatura) {
        super(ultimaTemperatura);
    }

    @Override
    public double lerDado() {
        return variarTemperatura(1); // Variação de -1 a +1
    }
}
