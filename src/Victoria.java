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

    public boolean haGanado(Turno turno,Tablero tablero) {
        return haGanadoVert(turno,tablero) || haGanadoHor(turno,tablero) ||
                haGanadoDiagDer(turno,tablero) || haGanadoDiagIzq(turno,tablero);
    }

    /** haGanadoVert
     * VERIFICA LAS COLUMNAS DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param turno Determina cuál ficha verificar.
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */

    private boolean haGanadoVert(Turno turno,Tablero tablero){
        boolean victoria = false;
        String[] corte = new String[6];
        for(int i=0;i<COL;i++){
            for(int j=0; j<FIL; j++){
                corte[i].equals(tablero.getPosicion(i,j));
            }
            if(verifCorte(corte,6,turno))
                victoria = true;
        }
        return victoria;
    }

    /** haGanadoHorz
     * VERIFICA LAS FILAS DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param turno Determina cuál ficha verificar.
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */
    private boolean haGanadoHor(Turno turno,Tablero tablero){
        boolean victoria = false;
        String[] corte = new String[7];
        for(int i=0; i<FIL; i++){
            for(int j=0; j<COL; j++){
                corte[i].equals(tablero.getPosicion(i,j));
            }
            if(verifCorte(corte,7,turno))
                victoria = true;
        }
        return victoria;
    }

    /** haGanadoDiagDer
     * VERIFICA LAS DIAGONALES TIPO \ DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param turno Determina cuál ficha verificar.
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */

    private boolean haGanadoDiagDer(Turno turno,Tablero tablero){
        boolean victoria = false;
        String[] corte = new String[4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                corte[i].equals(tablero.getPosicion(i+j,j));
            }
            if(verifCorte(corte,4,turno))
                victoria = true;
        }
        return victoria;
    }

    /** haGanadoDiagIzq
     * VERIFICA LAS DIAGONALES TIPO / DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param turno Determina cuál ficha verificar.
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */

    private boolean haGanadoDiagIzq(Turno turno,Tablero tablero){
        boolean victoria = false;
        String[] corte = new String[4];
        for(int i=COL; i>2; i--){
            for(int j=0; j<3; j++){
                corte[i].equals(tablero.getPosicion(i-j,j));
            }
            if(verifCorte(corte,4,turno))
                victoria = true;
        }
        return victoria;
    }

    private boolean verifCorte (String[] corte,int tamanio, Turno turno){
        boolean victoria = false;
        int cont = 0;
        for(int i=0; i< tamanio; i++){
            if(corte[i].equals(turno.getFichas())){
                cont++;
            }else
                cont = 0;
            if(cont == 4)
                victoria = true;
        }
        return victoria;
    }
}
