public class Victoria {
    private boolean victoria;
    private String[] fichas;
    private final int f = 3;
    private final int COL = 7;
    private final int FIL = 6;

    public Victoria(){
        this.victoria = false;
        this.fichas = new String[f];
    }

    public boolean getVictoria() {
        return this.victoria;
    }

    public void setVictoria(boolean v) {
        this.victoria = v;
    }

    /*public boolean haGanado(Tablero tablero, Turno turno) {

    }*/

    /*private*/ public boolean haGanadoVert(Tablero tablero, Turno turno) {
        int a = 0;
        for(int i = 0; i < COL; i++){
            for(int j = 0; j < FIL; j++){

            }
        }
        return victoria;
    }

    private boolean haGanadoHor() {

    }
}
