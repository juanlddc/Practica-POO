public abstract class Jugador {
    private String ficha;
    private String nombre;

    public Jugador(String ficha,String nombre){
        this.ficha = ficha;
        this.nombre = nombre;
    }

    public String getFicha() {
        return ficha;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Método abstracto para la eleccion de la columna en la que intrucir una ficha
     * @param tablero
     * @return columna en la que se introducira una ficha
     */
    public abstract int escogerPosicion(ITablero tablero);
}
