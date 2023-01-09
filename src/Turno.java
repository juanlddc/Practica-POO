public class Turno {
    private int turno;
    private int numJugadores;

    public Turno(){
        turno = 0;
        numJugadores = 2;
    }

    public void nextTurno(){
        turno = (turno + 1)%numJugadores;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno){
        this.turno = turno % numJugadores;
    }
}