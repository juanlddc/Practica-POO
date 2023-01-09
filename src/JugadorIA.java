import java.util.Random;

public class JugadorIA extends Jugador{

    public JugadorIA(String ficha,String nombre) {
        super(ficha,nombre);
    }

    /**
     * Escoge una columna de forma aleatoria en la que Jugador IA
     * introduce una ficha, escogiendo otra en el caso de estar completa
     * @param tablero tablero en el momento de la llamada
     * @return columna en la que introducir una ficha
     */
    @Override
    public int escogerPosicion(ITablero tablero) {
        Random r = new Random();
        int col = r.nextInt(tablero.getCOL());
        while(tablero.columnaLlena(col+1)){
            col = r.nextInt(tablero.getCOL());
        }
        return col+1;
    }
}
