public abstract class ControleArCondicionado implements Atuador {
    protected double temperaturaMinima;
    protected double temperaturaMaxima;
    protected int potenciaMaxima;
    protected int potenciaAtual;

    public ControleArCondicionado(double temperaturaMinima, double temperaturaMaxima, int potenciaMaxima) {
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.potenciaMaxima = potenciaMaxima;
        this.potenciaAtual = 0;
    }

    protected void ajustarPotencia(int ajuste) {
        potenciaAtual = Math.max(0, Math.min(potenciaAtual + ajuste, potenciaMaxima));
        System.out.println("Potência do ar-condicionado ajustada para: " + potenciaAtual);
    }
}

class ControleArCondicionadoAgratto extends ControleArCondicionado {
    public ControleArCondicionadoAgratto(double temperaturaMinima, double temperaturaMaxima, int potenciaMaxima) {
        super(temperaturaMinima, temperaturaMaxima, potenciaMaxima);
    }

    @Override
    public void aplicar(double valor) {
        if (valor < temperaturaMinima) {
            ajustarPotencia(1);
        } else if (valor > temperaturaMaxima) {
            ajustarPotencia(-1);
        }
    }
}

class ControleArCondicionadoSpringer extends ControleArCondicionado {
    public ControleArCondicionadoSpringer(double temperaturaMinima, double temperaturaMaxima, int potenciaMaxima) {
        super(temperaturaMinima, temperaturaMaxima, potenciaMaxima);
    }

    @Override
    public void aplicar(double valor) {
        if (valor < temperaturaMinima) {
            ajustarPotencia(2);
        } else if (valor > temperaturaMaxima) {
            ajustarPotencia(-2);
        }
    }
}
