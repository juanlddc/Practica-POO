public class Tablero {
    private String[][] tablero;

    //HACER COL Y FIL ATRIBUTO PARA PODER UTILIZARLOS EN OTRAS CLASES?
    private final int COL = 7;
    private final int FIL = 6;

    public Tablero() {
        this.tablero = new String[COL][FIL];
    }

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

    public void ponerFicha(int col, String valor) {
        ponerFichaAux(col-1, 0, valor);
    }

    private void ponerFichaAux(int col, int fila, String valor) {
        if (tablero[col][fila].equals(" ") && fila < FIL - 1) {
            if(!tablero[col][fila+1].equals(" ")){
                tablero[col][fila] = valor;
            }else ponerFichaAux(col, fila + 1, valor);
        }else tablero[col][fila] = valor;
    }

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

    public boolean full() {
        return ocupacion() == 0;
    }

    public boolean columnaLlena(int columna) {
        columna -= 1;
        return !tablero[columna][0].equals(" ");
    }

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