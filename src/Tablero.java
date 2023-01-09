public class Tablero implements ITablero {
    private Casilla[][] tablero;
    private int COL;
    private int FIL;
    private Memento memento;

    public Tablero(int columnas, int filas) {
        this.COL = columnas;
        this.FIL = filas;
        this.tablero = new Casilla[columnas][filas];
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                this.tablero[j][i] = new Casilla();
            }
        }
    }

    public void iniciarTablero() {
        for(int i = 0; i < FIL; i++){
            for(int j = 0; j < COL; j++){
                this.tablero[j][i].setDato(" ");
            }
        }
    }

    public int getCOL() {
        return COL;
    }

    public int getFIL() {
        return FIL;
    }

    public Casilla getPosicion(int x, int y) {
        return this.tablero[x][y];
    }

    /**
     * Introduce una ficha en la cola pasada como parámertro
     * @param col columna del tablero en la que se introduce el valor
     * @param valor "ficha" que se introduce
     */
    public void ponerFicha(int col, String valor) {
        ponerFichaAux(col-1, 0, valor);
    }

    /**
     * Método recursivo en el que los valores/fichas se introducen en el tablero ("de arriba a abajo")
     * @param col int de columna
     * @param fila int
     * @param valor String
     */
    private void ponerFichaAux(int col, int fila, String valor) {
        if (tablero[col][fila].getDato().equals(" ") && fila < FIL - 1) {
            if(!tablero[col][fila+1].getDato().equals(" ")){
                tablero[col][fila].setDato(valor);
            }else ponerFichaAux(col, fila + 1, valor);
        }else tablero[col][fila].setDato(valor);
    }

    /**
     * @return numero de espacios libres en el tablero
     */
    private int ocupacion() {
        int libre = 0;
        for(int i = 0; i < FIL; i++){
            for(int j = 0; j < COL; j++){
                if(tablero[j][i].getDato().equals(" ")){
                    libre++;
                }
            }
        }
        return libre;
    }

    /**
     * @return true si el tablero está lleno
     */
    public boolean full() {
        return ocupacion() == 0;
    }

    /**
     * @param columna
     * @return true si la columna está completa
     */
    public boolean columnaLlena(int columna) {
        columna -= 1;
        return !tablero[columna][0].getDato().equals(" ");
    }

    /**
     * @return tablero por pantalla
     */
    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < FIL; i++) {
            for (int j = 0; j < COL; j++) {
                resultado = resultado + " | " + tablero[j][i].getDato();
            }
            resultado = resultado + " |" + "\n";
        }
        return resultado;
    }

    /**
     * Guarda el tablero en el atributo de memento
     */
    public void makeBackup(){
        memento = new Memento(tablero, getCOL(), getFIL());
    }

    /**
     * Modifica el tablero al guardado en memento
     */
    public void recoverBackup(){
        tablero = memento.recoverOldInformation();
    }
}