
public class Reglas implements IReglas {
    private boolean victoria;

    public Reglas(){
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
     * @param ficha ficha que se ha introducido en el ultimo turno
     * @param tablero tablero en sí
     * @return true si se ha ganado
     */
    public boolean haGanado(String ficha, ITablero tablero) {
        boolean victoria = (haGanadoVert(ficha, tablero) || haGanadoHor(ficha, tablero) || haGanadoDiagDer(ficha, tablero) || haGanadoDiagIzq(ficha, tablero));
        setVictoria(victoria);
        return victoria;
    }

    /** haGanadoVert
     * VERIFICA LAS COLUMNAS DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param ficha Ficha que hay que verificar
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */
    private boolean haGanadoVert(String ficha,ITablero tablero){
        Casilla[] corte = new Casilla[tablero.getFIL()];
        boolean cumple = false;
        for(int i = 0; i < tablero.getCOL() && !cumple; i++){
            for(int j = 0; j < tablero.getFIL(); j++){
                corte[j] = tablero.getPosicion(i, j);
            }
            cumple = verifCorte(corte, tablero.getFIL(), ficha);
        }
        return cumple;
    }

    /** haGanadoHorz
     * VERIFICA LAS FILAS DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param ficha Ficha que hay que verificar
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */
    private boolean haGanadoHor(String ficha,ITablero tablero){
        Casilla[] corte = new Casilla[tablero.getCOL()];
        boolean cumple = false;
        for(int i=0; i < tablero.getFIL() && !cumple; i++){
            for(int j=0; j < tablero.getCOL(); j++){
                corte[j] = tablero.getPosicion(j,i);
            }
            cumple = verifCorte(corte, tablero.getCOL(), ficha);
        }
        return cumple;
    }

    /** haGanadoDiagDer
     * VERIFICA LAS DIAGONALES TIPO \ DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param ficha Ficha que hay que verificar
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */
    private boolean haGanadoDiagDer(String ficha,ITablero tablero){
        Casilla[] corte = new Casilla[4];
        boolean cumple = false;
        for(int i=0; i <= tablero.getCOL()-4 && !cumple; i++){
            for(int j=0; j <= tablero.getFIL()-4 && !cumple; j++){
                for(int k=0; k<4; k++){
                    corte[k] = tablero.getPosicion(i+k,j+k);
                }
                cumple = verifCorte(corte,4,ficha);
            }
        }
        return cumple;
    }

    /** haGanadoDiagIzq
     * VERIFICA LAS DIAGONALES TIPO / DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
     * @param ficha Ficha que hay que verificar
     * @param tablero El tablero en sí
     * @return Un booleano si se cumple la condición o no.
     */
    private boolean haGanadoDiagIzq(String ficha,ITablero tablero){
        Casilla[] corte = new Casilla[4];
        boolean cumple = false;
        for(int i = (tablero.getCOL()-1); i >= 3 && !cumple; i--){
            for(int j=0; j <= tablero.getFIL()-4 && !cumple; j++){
                for(int k=0; k<4 ;k++){
                    corte[k] = tablero.getPosicion(i-k,j+k);
                }
                cumple = verifCorte(corte,4,ficha);
            }
        }
        return cumple;
    }

    /**
     * Verifica si hay cuatro mismos valores seguidos
     * @param corte Array de Casillas
     * @param tamanio tamaño del array corte
     * @param ficha Ficha que hay que verificar
     * @return true si hay cuatro valores iguales seguidos
     */
    private boolean verifCorte (Casilla[] corte,int tamanio, String ficha){
        boolean victoria = false;
        int cont = 0;
        for(int i=0; i<tamanio && !victoria; i++){
            if(corte[i].getDato().equals(ficha)){
                cont++;

            }else
                cont = 0;
            if(cont == 4)
                victoria = true;
        }
        return victoria;
    }
}
