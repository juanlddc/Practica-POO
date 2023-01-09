public interface ITablero {
    public void iniciarTablero();
    public int getCOL();
    public int getFIL();
    public Casilla getPosicion(int x, int y);
    public void ponerFicha(int col, String valor);
    public boolean full();
    public boolean columnaLlena(int columna);
    public String toString();
}
