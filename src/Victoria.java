import javafx.scene.control.Tab;

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
        return haGanadoVert(turno,tablero) || haGanadoHorz(turno,tablero) ||
                haGanadoDiagDer(turno,tablero) || haGanadoDiagIzq(turno,tablero);
    }

    /** verifCorte
     * VERIFICA SI EL ARRAY DE STRING DADO TIENE 4 FICHAS CONSECUTIVAS O NO
     * @param corte Es un array de tipo String que hace parte del tablero, o sea, un corte.
     * @param tamanio Es el tamaño del array, ya que puede ser de 6 o 7 si es horizontal o no.
     * @param turno Tiene la info de la ficha que verificar con getFichas().
     * @return Un booleano llamado victoria que dice si hay 4 fichas del mismo tipo en el corte en consecuencia.
     */

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

    private boolean haGanadoHorz(Turno turno,Tablero tablero){
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

/*
    private boolean haGanadoVert(Turno turno) {
        boolean victoria = false;
        String[] fichas = new String[4];
        for(int i = 0; i < COL; i++){
            for(int j = 0; j < FIL; j++){
                actualizarArray(fichas);
                fichas[0] = turno.getFichas();
                victoria = comprobarArray(fichas, turno.getFichas());
            }
        }
        return victoria;
    }

    private boolean haGanadoHor(Turno turno) {
        boolean victoria = false;
        String[] fichas = new String[4];
        for(int i = 0; i < FIL; i++){
            for(int j = 0; j < COL; j++){
                actualizarArray(fichas);
                fichas[0] = turno.getFichas();
                victoria = comprobarArray(fichas, turno.getFichas());
            }
        }
        return victoria;
    }

    private boolean haGanadoDiag(Turno turno){
        boolean victoria = false;
        String[] fichas = new String[4];
        for(int i = 0; i < 4 ; i++){
            for(int j = 0; j < 4; j++){

            }
        }
        return victoria;
    }

    private boolean comprobarArray(String[] fichas, String ficha) {
        boolean iguales = true;

        for(int i = 0; i < fichas.length-1; i ++){
            if(!Objects.equals(fichas[i], ficha)){ //fichas[i] != ficha
                iguales = false;
            }
        }
        return iguales;
    }

    private void actualizarArray(String[] fichas) {
        for(int i = 0; i < fichas.length-1; i ++){
            fichas[i+1] = fichas[i];
        }
    }
 */
}

