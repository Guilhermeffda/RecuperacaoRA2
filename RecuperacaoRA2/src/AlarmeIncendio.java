public abstract class AlarmeIncendio implements Atuador {
    protected boolean alarmeAtivado;

    public AlarmeIncendio() {
        this.alarmeAtivado = false;
    }

    protected void verificarAtivacao(double nivel, double limite) {
        alarmeAtivado = nivel > limite;
        System.out.println("Alarme de Incêndio ativado: " + alarmeAtivado);
    }
}

class AlarmeIncendioA extends AlarmeIncendio {
    @Override
    public void aplicar(double valor) {
        verificarAtivacao(valor, 5);
    }
}

class AlarmeIncendioB extends AlarmeIncendio {
    @Override
    public void aplicar(double valor) {
        verificarAtivacao(valor, 7);
    }
}
