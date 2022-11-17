public class Turno {
    private static final String[] jugadores = {"RED","YELLOW"};
    private static final String[] fichas = {"R","Y"};
    private int turno;
    public Turno(){
        turno = 0;
    }

    public void nextTurno(){
        turno = (turno + 1)%2;
    }

    public int getTurno() {
        return turno;
    }

    public String getJugador(){
        return jugadores[this.turno];
    }

    public String getFichas() {
        return fichas[this.turno];
    }
}
