import java.util.ArrayList;
import java.util.Random;

public class MiniMax {

    private final int COL = 7;
    private final int FIL = 6;
    private Tablero tablero;

    public MiniMax(Tablero tablero) {
        this.tablero = tablero;
    }

    public int columna(Turno turno){
        Random r = new Random();
        int col = r.nextInt(COL);
        while(tablero.columnaLlena(col+1)){
            col = r.nextInt(COL);
        }
        return col+1;
    }

    /*public int mejor(Turno turno) {
        int[] coste1 = coste(turno.getFichas());
        int[] coste2 = coste(turno.getFichaOpuesta());

        if(coste1[1] > coste2[1]) return coste1[0];
        else return coste2[0];
    }
    public int[] coste(String ficha){
        /*int[] v = costeVer(ficha);
        int[] h = costeHor(ficha);
        if(v[1] > h[1]) return v;
        else return h;
        return costeVer(ficha);
    }

    private int[] costeVer(String ficha){
        String[] corte = new String[FIL];
        int[] columnaYvalor = {-1,0};

        int linea = 0;

        for(int i = 1; i < COL+1 && !tablero.columnaLlena(i); i++){
            tablero.ponerFicha(i, ficha);
            for(int j = 0; j < FIL; j++){
                corte[j] = tablero.getPosicion(i-1,j);
            }
            tablero.quitarFicha(i);
            linea = fichasEnLinea(corte, ficha);

            if(linea > columnaYvalor[1]){
                columnaYvalor[1] = linea;
                columnaYvalor[0] = i;
            }
        }
        return columnaYvalor;
    }
    private int[] costeHor(String ficha){
        String[] corte = new String[COL];
        int[] columnaYvalor = {-1,0};

        int linea = 0;
        int posicion = 0;

        for(int i = 1; i < COL+1 && !tablero.columnaLlena(i); i++){
            tablero.ponerFicha(i, ficha);
            for(int z = 0; tablero.getPosicion(i-1,z).equals(" ") && z < FIL; z++){
                posicion++;
            }
            posicion += 1; //fila ficha metida

            for(int j = 0; j < COL; j++){
                corte[j] = tablero.getPosicion(j, posicion);
            }
            tablero.quitarFicha(i);
            linea = fichasEnLinea(corte,ficha);

            if(linea > columnaYvalor[1]){
                columnaYvalor[1] = linea;
                columnaYvalor[0] = i;
            }
        }
        return columnaYvalor;
    }

    private int fichasEnLinea(String[] corte, String ficha){
        int cont = 0;

        for(int i = 0; i < corte.length; i++){
            if(corte[i] != " "){
                if(corte[i] == ficha) cont++;
                else cont = 0;
            }
        }
        return cont;
    }*/
}