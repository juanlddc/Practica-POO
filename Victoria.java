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
        return haGanadoVert(turno,tablero) || haGanadoHor(turno,tablero) || haGanadoDiagIzq(turno, tablero) || haGanadoDiagDer(turno, tablero);
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

    private boolean haGanadoDiagDer(Turno turno,Tablero tablero){
        String[] corte = new String[4];
        for(int i = 6; (i > 2) && !verifCorte(corte,4,turno); i--){
            for(int j = 5; (j > 2) && !verifCorte(corte,4,turno); j--){
                for(int k = 0; k < 4; k++){
                    corte[k] = tablero.getPosicion(i-k,j-k);
                }
            }
        }
        setVictoria(verifCorte(corte, 4, turno));
        return this.victoria;
    }

    /** haGanadoDiagIzq
     * VERIFICA LAS DIAGONALES TIPO / DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param turno Determina cuál ficha verificar.
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */

    private boolean haGanadoDiagIzq(Turno turno,Tablero tablero){
        String[] corte = new String[4];
        for(int i = 0; (i < 4) && !verifCorte(corte,4,turno); i++){
            for(int j = 5; (j > 2) && !verifCorte(corte,4,turno); j--){
                for(int k = 0; k < 4; k++){
                    corte[k] = tablero.getPosicion(i+k,j-k);
                }
            }
        }
        setVictoria(verifCorte(corte, 4, turno));
        return this.victoria;
    }

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