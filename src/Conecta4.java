import java.util.Scanner;

public class Conecta4 {

    private final Turno turno = new Turno();
    private final Reglas reglas = new Reglas();
    private final Jugador[] jugadores = new Jugador[2];
    private final Menu menu = new Menu();
    public final static Scanner repetir = new Scanner(System.in);
    public final static Scanner scanner = new Scanner(System.in);

    public void jugar() throws NumeroNoValido {
        System.out.println("-------- CONECTA 4 --------");
        String rep;
        Tablero tablero = new Tablero(menu.pedirCol(), menu.pedirFil());
        turno.setTurno(0);
        reiniciarV();
        tablero.iniciarTablero();
        int modo = menu.selModo();
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
                    System.out.println("Undo move? (s/n)");
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
            }while(!seguir.equals("S") && !seguir.equals("s") && !seguir.equals("N") && !seguir.equals("n"));
        }while(seguir.equals("S") || seguir.equals("s"));
    }
}