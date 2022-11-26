import java.util.Arrays;
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

    public boolean haGanado(Tablero tablero) {
        haGanadoVert(tablero);
        //haGanadoHor(tablero);
        return victoria;
    }

    private void haGanadoVert(Tablero tablero) {
        String[] fichas = new String[4];

        for(int i = 0; i < COL && !this.victoria; i++){
            for(int j = 0; j < FIL && !this.victoria; j++){
                actualizarArray(fichas, tablero.getPosicion(i, j));
                setVictoria(comprobarArray(fichas, tablero.getPosicion(i, j)));
            }
        }
    }

    /*private void haGanadoHor(Tablero tablero) {
        String[] fichas = new String[4];
        for(int i = 0; i < FIL; i++){
            for(int j = 0; j < COL; j++){
                actualizarArray(fichas);
                fichas[0] = turno.getFichas();
                victoria = comprobarArray(fichas, turno.getFichas());
            }
        }
    }*/

    private boolean comprobarArray(String[] fichas, String ficha) {
        boolean iguales = true;
            for(int i = 0; i < fichas.length-1 && iguales; i ++){
                if(fichas[i] != ficha){
                    iguales = false;
                }
            /*if (!Objects.equals(fichas[i], fichas[i + 1])) { //fichas[i] != fichas[i+1]
                iguales = false;
            }*/
            }
        return iguales;
    }

    private void actualizarArray(String[] fichas, String ficha) {
        for(int i = 0; i < fichas.length-1; i ++){
            fichas[i+1] = fichas[i];
        }
        fichas[0] = ficha;
    }
}
