import java.util.ArrayList;
import java.util.Objects;

public class Tablero {
    private String[][] tablero;
    private final int COL = 7;
    private final int FIL = 6;

    public Tablero() {
        this.tablero = new String[COL][FIL];
    }

    /**
     * Inicia el tablero a vacio (" ")
     */
    public void iniciarTablero() {
        for(int i = 0; i < FIL; i++){
            for(int j = 0; j < COL; j++){
                this.tablero[j][i] = " ";
            }
        }
    }

    public String[][] getTablero() {
        return this.tablero;
    }

    public String getPosicion(int x, int y) {
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
     * @param col
     * @param fila
     * @param valor
     */
    private void ponerFichaAux(int col, int fila, String valor) {
        if (tablero[col][fila].equals(" ") && fila < FIL - 1) {
            if(!tablero[col][fila+1].equals(" ")){
                tablero[col][fila] = valor;
            }else ponerFichaAux(col, fila + 1, valor);
        }else tablero[col][fila] = valor;
    }

    /**
     * Elimina la ficha "más alta" de la columna introducida como parámetro
     * @param col columna de la que se elimina la ficha
     */
    public void quitarFicha(int col) {
        boolean borrado = false;
        for(int i = 0; i < FIL && !borrado; i++){
            if(!Objects.equals(tablero[col-1][i], " ")){
                tablero[col-1][i] = " ";
                borrado = true;
            }
        }
    }

    /**
     * @return numero de espacios libres en el tablero
     */
    public int ocupacion() {
        int libre = 0;
        for(int i = 0; i < FIL; i++){
            for(int j = 0; j < COL; j++){
                if(tablero[j][i].equals(" ")){
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
        return !tablero[columna][0].equals(" ");
    }

    public ArrayList<Integer> getJugadasValidas() {
        ArrayList<Integer> solucion = new ArrayList<Integer>();

        return solucion;
    }

    /**
     * @return tablero por pantalla
     */
    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < FIL; i++) {
            for (int j = 0; j < COL; j++) {
                resultado = resultado + " | " + tablero[j][i];
            }
            resultado = resultado + " |" + "\n";
        }
        return resultado;
    }
}