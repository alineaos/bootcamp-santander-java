package ex03.relogios;

public class RelogioBrasileiro extends Relogio{
    @Override
    public Relogio formato(Relogio relogio) {
        this.segundos = relogio.getSegundos();
        this.minutos = relogio.getMinutos();
        switch (relogio) {
            case RelogioAmericano relogioAmericano:
                this.horas = relogioAmericano.getPeriodoDia().equals("pm") ?
                        relogioAmericano.getHoras() + 12 : relogioAmericano.getHoras();
                break;
            case RelogioBrasileiro relogioBrasileiro:
                this.horas = relogioBrasileiro.getHoras();
                break;
            default:
        }
        return this;

    }
}
