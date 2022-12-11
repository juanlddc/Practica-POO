import java.util.ArrayList;

public class MiniMax {
    private final int MAX_PROF = 0;
    private Tablero tablero;
    private Reglas victoria;

    public MiniMax(Tablero tablero, Reglas victoria) {
        this.tablero = tablero;
        this.victoria = victoria;
    }

    public int miniMax(Tablero tablero) {
        int mejorJugada;
        int max = Integer.MIN_VALUE;
        int maxTmp;
        ArrayList<Integer> jugadasValidas = tablero.getJugadasValidas();
        mejorJugada = jugadasValidas.get(0);
        for(Integer columna : jugadasValidas) {
            tablero.ponerFicha(columna, "M");
            maxTmp = valorMin(tablero,0);
            tablero.quitarFicha(columna);
            if(maxTmp > max) {
                max = maxTmp;
                mejorJugada = columna;
            }
        }
        return mejorJugada;
    }

    private int valorMin(Tablero tablero, int prof) {
        int min = Integer.MAX_VALUE;
        int minTmp;
        if(hayFinPartida()) return heuristica(tablero);
        if(prof > MAX_PROF) return heuristica(tablero);
        else{
            ArrayList<Integer> jugadasValidas = tablero.getJugadasValidas();
            for(Integer columna : jugadasValidas) {
                tablero.ponerFicha(columna, "H");
                minTmp = valorMax(tablero,prof+1);
                tablero.quitarFicha(columna);
                if(minTmp < min) min = minTmp;
            }
            return min;
        }
    }

    private int valorMax(Tablero tablero, int prof) {
        int max = Integer.MIN_VALUE;
        int maxTmp;
        if(hayFinPartida()) return heuristica(tablero);
        if(prof > MAX_PROF) return heuristica(tablero);
        else{
            ArrayList<Integer> jugadasValidas = tablero.getJugadasValidas();
            for(Integer columna : jugadasValidas) {
                tablero.ponerFicha(columna, "M");
                maxTmp = valorMax(tablero,prof+1);
                tablero.quitarFicha(columna);
                if(maxTmp > max) max = maxTmp;
            }
            return max;
        }
    }

    private int heuristica(Tablero tablero) {
        if(victoria.haGanado(,tablero));
        if(victoria.haGanado(,tablero));
        if;
        return tablero.coste() - tablero.coste();
    }

    private boolean hayFinPartida() {
        return victoria.getVictoria() || tablero.full();
    }
}
