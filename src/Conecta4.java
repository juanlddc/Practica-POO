import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Conecta4 {

    private Turno turno = new Turno();
    private Reglas reglas = new Reglas();
    private Jugador[] jugadores = new Jugador[2];
    public final static Scanner col = new Scanner(System.in);
    public final static Scanner fil = new Scanner(System.in);
    public final static Scanner repetir = new Scanner(System.in);
    public final static Scanner m = new Scanner(System.in);
    public final static Scanner scanner = new Scanner(System.in);

    public void jugar() throws NumeroNoValido {
        System.out.println("-------- CONECTA 4 --------");
        int filas = 0;
        int columnas = 0;
        boolean successful = false;
        String rep;
        do{
            try{
                System.out.println("Numero de columnas del tablero? [4-etc]");
                columnas = col.nextInt();
                System.out.println("Numero de filas del tablero? [4-etc]");
                filas = fil.nextInt();
                if(columnas < 4 || filas < 4){
                    throw new NumeroNoValido();
                }
                successful = true;
            }catch(NumeroNoValido e){
                System.out.println(e.getMensaje());
            }
        }while(!successful);

        Tablero tablero = new Tablero(columnas, filas);
        turno.setTurno(0);
        reiniciarV();
        tablero.iniciarTablero();
        int modo = 1;

        successful = false;
        do {
            try {
                System.out.print("Elija un modo de juego:\n" +
                        "(1)Básico\n" +
                        "(2)Entrenamiento\n" +
                        "(3)Demo\n" +
                        "(0)Salir del juego\n");
                modo = m.nextInt();
                if (modo < 0 || modo > 3) {
                    throw new NumeroNoValido();
                }
                successful = true;
            } catch (NumeroNoValido e) {
                System.out.println(e.getMensaje() + " Values[0-3]");
            }
        }while(!successful);

        if (modo != 0) {
            switch (modo) {
                case 1:
                    jugadores[0] = new JugadorHumano("R","RED");
                    jugadores[1] = new JugadorHumano("Y","YELLOW");
                    break;
                case 2:
                    jugadores[0] = new JugadorHumano("R","RED");
                    jugadores[1] = new JugadorIA("Y","YELLOW");
                    break;
                case 3:
                    jugadores[0] = new JugadorIA("R","RED");
                    jugadores[1] = new JugadorIA("Y","YELLOW");
                    break;
            }
            do {
                System.out.println(tablero);
                tablero.makeBackup();
                System.out.println(jugadores[turno.getTurno()].getNombre()+" player's turn:");
                tablero.ponerFicha(jugadores[turno.getTurno()].escogerPosicion(tablero),jugadores[turno.getTurno()].getFicha());
                System.out.println(tablero);
                if (jugadores[turno.getTurno()].getClass().equals(JugadorHumano.class)){
                    System.out.println("Repetir movimiento ? (s/n)");
                    rep = repetir.nextLine();
                    if(rep.equals("s")){
                        tablero.recoverBackup();
                        System.out.println(tablero);
                        tablero.ponerFicha(jugadores[turno.getTurno()].escogerPosicion(tablero),jugadores[turno.getTurno()].getFicha());
                    }
                }

                if(!reglas.getVictoria() && tablero.full()){
                    System.out.println("It's a tie! Game over.");
                }else if(reglas.haGanado(jugadores[turno.getTurno()].getFicha(),tablero)){
                    System.out.println(tablero);
                    System.out.println(jugadores[turno.getTurno()].getNombre()+" has won! Game over.");
                }else{
                    turno.nextTurno();
                }
            } while (!tablero.full() && !reglas.getVictoria());
        }
    }

    /**
     * Pone el valor de victoria a false para el caso en el que se vuelve a jugar
     */

    public void reiniciarV() {
        this.reglas.setVictoria(false);
    }

    public static void main(String[] args) throws NumeroNoValido {
        Conecta4 partida = new Conecta4();
        String seguir;
        do{
            partida.jugar();
            do{
                System.out.print("Do you want to continue? (s/n): ");
                seguir = scanner.nextLine();
                System.out.println("\n");
            }while(!Objects.equals(seguir, "S") && !Objects.equals(seguir, "s") && !Objects.equals(seguir, "N") && !Objects.equals(seguir, "n"));
        }while(seguir.equals("S") || seguir.equals("s"));
    }
}
