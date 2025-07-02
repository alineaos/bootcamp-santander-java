package ex03.relogios;

public abstract class  Relogio {
    protected int horas;
    protected int minutos;
    protected int segundos;

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (horas >= 24){
            this.horas = 00;
            return;
        }
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        if (minutos >= 60){
            this.minutos = 00;
            return;
        }
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        if (segundos >= 60){
            this.segundos = 00;
            return;
        }
        this.segundos = segundos;
    }

    public String chamarRelogio(){
        return this.horas+":"+this.minutos+":"+this.segundos;
    }

    abstract Relogio formato(Relogio relogio);
}
