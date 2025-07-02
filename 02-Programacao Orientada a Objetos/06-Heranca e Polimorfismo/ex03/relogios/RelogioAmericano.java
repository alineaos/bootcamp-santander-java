package ex03.relogios;

public class RelogioAmericano extends Relogio{
private String periodoDia;

    public String getPeriodoDia() {
        return periodoDia;
    }

    public void setHoras(int horas) {
        this.periodoDia = "am";
        if (horas > 12 && horas <= 23){
            this.horas = 12;
            this.periodoDia ="pm";
            return;
        } else if (horas >= 24){
            this.horas = 0;
        } else {
            this.horas = horas;
        }
    }

    @Override
    public Relogio formato(Relogio relogio) {
        this.segundos = relogio.getSegundos();
        this.minutos = relogio.getMinutos();
        switch (relogio) {
            case RelogioAmericano relogioAmericano:
                this.horas = relogioAmericano.getHoras();
                break;
            case RelogioBrasileiro relogioBrasileiro:
                if(relogioBrasileiro.getHoras() > 12){
                    this.horas = relogioBrasileiro.getHoras() - 12;
                    this.periodoDia = "pm";
            } else {
                    this.horas = relogioBrasileiro.getHoras();
                }
                break;
            default:
        }
        return this;
    }

    @Override
    public String chamarRelogio() {
        return super.chamarRelogio() + " " + this.periodoDia;
    }
}
