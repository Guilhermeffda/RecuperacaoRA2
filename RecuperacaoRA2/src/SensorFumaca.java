import java.util.Random;

public abstract class SensorFumaca implements Sensor {
    protected double nivelFumaca;
    private Random random = new Random();

    public SensorFumaca(double nivelFumaca) {
        this.nivelFumaca = nivelFumaca;
    }

    protected double variarNivelFumaca(double variacaoMaxima) {
        return nivelFumaca += (random.nextDouble() * variacaoMaxima * 2) - variacaoMaxima;
    }
}

class SensorFumacaA extends SensorFumaca {
    public SensorFumacaA(double nivelFumaca) {
        super(nivelFumaca);
    }

    @Override
    public double lerDado() {
        return variarNivelFumaca(1); // Variação de -1 a +1
    }
}

class SensorFumacaB extends SensorFumaca {
    public SensorFumacaB(double nivelFumaca) {
        super(nivelFumaca);
    }

    @Override
    public double lerDado() {
        return variarNivelFumaca(2); // Variação de -2 a +2
    }
}
