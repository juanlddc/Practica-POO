import java.util.Objects;

public class Victoria {
    private boolean victoria;
    private final int COL = 7;
    private final int FIL = 6;

    public Victoria(){
        this.victoria = false;
    }

    public boolean getVictoria() {
        return this.victoria;
    }

    public void setVictoria(boolean v) {
        this.victoria = v;
    }

    public boolean haGanado(Tablero tablero, Turno turno) {
        haGanadoVert(tablero, turno);
        haGanadoHor(tablero, turno);
        return victoria;
    }

    private void haGanadoVert(Tablero tablero, Turno turno) {
        String[] fichas = new String[3];
        for(int i = 0; i < COL; i++){
            for(int j = 0; j < FIL; j++){
                for(int z = 0; z < 3; z++){
                    fichas[i+1] = fichas[i];
                }
                fichas[0] = tablero.getPosicion(i,j);
                victoria = comprobarArray(fichas);
            }
        }
    }

    private void haGanadoHor(Tablero tablero, Turno turno) {
        String[] fichas = new String[3];
        for(int i = 0; i < FIL; i++){
            for(int j = 0; j < COL; j++){
                for(int z = 0; z < 3; z++){
                    fichas[i+1] = fichas[i];
                }
                fichas[0] = tablero.getPosicion(i,j);
                victoria = comprobarArray(fichas);
            }
        }
    }

    private boolean comprobarArray(String[] fichas) {
        boolean iguales = true;

        for(int i = 0; i < 3; i ++){
            if(!Objects.equals(fichas[i], fichas[i + 1])){ //fichas[i] != fichas[i+1]
                iguales = false;
            }
        }
        return iguales;
    }
}
