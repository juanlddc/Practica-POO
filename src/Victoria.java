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

    /**
     * Determina si se ha ganado la partida vertical, horizontal o diagonalmente
     * @param turno turno en el que se ha introducdo la última ficha
     * @param tablero tablero en sí
     * @return true si se ha ganado
     */
    public boolean haGanado(Turno turno,Tablero tablero) {
        setVictoria(haGanadoVert(turno,tablero) ||  haGanadoHor(turno, tablero) || haGanadoDiagIzq(turno,tablero));
        return victoria;
    }

    /** haGanadoVert
     * VERIFICA LAS COLUMNAS DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param turno Determina cuál ficha verificar.
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */

    private boolean haGanadoVert(Turno turno,Tablero tablero){
        String[] corte = new String[FIL];
        for(int i = 0; i < COL && !this.victoria; i++){
            for(int j = 0; j < FIL; j++){
                corte[j] = tablero.getPosicion(i, j);
            }
            setVictoria(verifCorte(corte, FIL, turno));
        }
        return this.victoria;
    }

    /** haGanadoHorz
     * VERIFICA LAS FILAS DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param turno Determina cuál ficha verificar.
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */
    private boolean haGanadoHor(Turno turno,Tablero tablero){
        String[] corte = new String[COL];
        for(int i=0; i < FIL && !this.victoria; i++){
            for(int j=0; j < COL; j++){
                corte[j] = tablero.getPosicion(j,i);
            }
            setVictoria(verifCorte(corte, COL, turno));
        }
        return this.victoria;
    }

    /** haGanadoDiagDer
     * VERIFICA LAS DIAGONALES TIPO \ DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param turno Determina cuál ficha verificar.
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */

    /*private boolean haGanadoDiagDer(Turno turno,Tablero tablero) {
        String[] corte = new String[];
        for(int i = 3; i < && this.victoria; i++){
            for(int j = 0; j < ; j++){
                corte[j] = tablero.getPosicion();
            }
            setVictoria(verifCorte(corte, , turno));
        }
    }*/


    /** haGanadoDiagIzq
     * VERIFICA LAS DIAGONALES TIPO / DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param turno Determina que ficha verificar.
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */

    private boolean haGanadoDiagIzq(Turno turno,Tablero tablero){
        boolean victoria = false;
        String[] corte = new String[4];
        for(int i=COL; i>2; i--){
            for(int j=0; j<3; j++){
                corte[i] = tablero.getPosicion(i-j,j);
            }
            if(verifCorte(corte,4,turno))
                victoria = true;
        }
        return victoria;
    }

    /**
     * Verifica si hay cuatro mismos valores seguidos
     * @param corte array
     * @param tamanio tamaño del array corte
     * @param turno turno que
     * @return true si hay cuatro valores iguales seguidos
     */
    private boolean verifCorte (String[] corte,int tamanio, Turno turno){
        boolean victoria = false;
        int cont = 0;
        for(int i=0; i<tamanio && !victoria; i++){
            if(corte[i] == turno.getFichas()){
                cont++;
            }else
                cont = 0;
            if(cont == 4)
                victoria = true;
        }
        return victoria;
    }
}