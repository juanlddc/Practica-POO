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
        //haGanadoHor(tablero, turno);
        return victoria;
    }

    private void haGanadoVert(Tablero tablero, Turno turno) {
        String[] fichas = new String[3];
        for(int i = 0; i < COL; i++){
            for(int j = 0; j < FIL; j++){
                actualizarArray(fichas, turno.getFichas());
                fichas[0] = turno.getFichas();
                victoria = comprobarArray(fichas, turno.getFichas());
            }
        }
    }

    /*private void haGanadoHor(Tablero tablero, Turno turno) {
        String[] fichas = new String[4];
        for(int i = 0; i < FIL; i++){
            for(int j = 0; j < COL; j++){
                actualizarArray(fichas, turno.getFichas());
                fichas[0] = turno.getFichas();
                victoria = comprobarArray(fichas, turno.getFichas());
            }
        }
    }*/

    private boolean comprobarArray(String[] fichas, String ficha) {
        boolean iguales = true;

        for(int i = 0; i < fichas.length-1; i ++){
            if(!Objects.equals(fichas[i], ficha)){ //fichas[i] != ficha
                iguales = false;
            }
        }
        return iguales;
    }

    private void actualizarArray(String[] fichas, String ficha) {
        for(int i = 0; i < fichas.length-1; i ++){
            fichas[i+1] = fichas[i];
        }
    }
}
