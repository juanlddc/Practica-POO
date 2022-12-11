import java.util.ArrayList;

public class MiniMax {
    private final int MAX_PROF = 0;
    private Tablero tablero;
    private Reglas victoria;

    public MiniMax(Tablero tablero, Reglas victoria) {
        this.tablero = tablero;
        this.victoria = victoria;
    }

    public int miniMax(Tablero tablero, Turno turno) {
        int mejorJugada;
        int max = Integer.MIN_VALUE;
        int maxTmp;
        ArrayList<Integer> jugadasValidas = tablero.getJugadasValidas();
        mejorJugada = jugadasValidas.get(0);
        for(Integer columna : jugadasValidas) {
            tablero.ponerFicha(columna, turno.getFichas());
            maxTmp = valorMin(tablero,0,turno);
            tablero.quitarFicha(columna);
            if(maxTmp > max) {
                max = maxTmp;
                mejorJugada = columna;
            }
        }
        return mejorJugada;
    }

    private int valorMin(Tablero tablero, int prof, Turno turno) {
        int min = Integer.MAX_VALUE;
        int minTmp;
        if(hayFinPartida()) return heuristica(tablero,turno);
        if(prof > MAX_PROF) return heuristica(tablero,turno);
        else{
            ArrayList<Integer> jugadasValidas = tablero.getJugadasValidas();
            for(Integer columna : jugadasValidas) {
                tablero.ponerFicha(columna, turno.getFichas());
                minTmp = valorMax(tablero,prof+1,turno);
                tablero.quitarFicha(columna);
                if(minTmp < min) min = minTmp;
            }
            return min;
        }
    }

    private int valorMax(Tablero tablero, int prof, Turno turno) {
        int max = Integer.MIN_VALUE;
        int maxTmp;
        if(hayFinPartida()) return heuristica(tablero,turno);
        if(prof > MAX_PROF) return heuristica(tablero, turno);
        else{
            ArrayList<Integer> jugadasValidas = tablero.getJugadasValidas();
            for(Integer columna : jugadasValidas) {
                tablero.ponerFicha(columna, turno.getFichas());
                maxTmp = valorMax(tablero,prof+1, turno);
                tablero.quitarFicha(columna);
                if(maxTmp > max) max = maxTmp;
            }
            return max;
        }
    }

    private int heuristica(Tablero tablero, Turno turno) {
        if(victoria.haGanado(turno.getFichas(), tablero)) return Integer.MAX_VALUE; //Player1
        if(victoria.haGanado(turno.getFichaOpuesta(), tablero)) return Integer.MIN_VALUE; //Player2
        if;
        return tablero.coste(turno.getFichas()) - tablero.coste(turno.getFichaOpuesta()); //la ficha del otro jugador
    }

    private boolean hayFinPartida() {
        return victoria.getVictoria() || tablero.full();
    }
}
