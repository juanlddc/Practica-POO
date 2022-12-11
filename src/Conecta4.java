import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Conecta4 {

    private Tablero tablero = new Tablero();
    private Turno turno = new Turno();
    private Reglas victoria = new Reglas();
    private Modos mode = new Modos();
    public final static Scanner m = new Scanner(System.in);
    public final static Scanner sc = new Scanner(System.in);
    public final static Scanner scanner = new Scanner(System.in);

    public void jugar() throws ColumnaNoValida, ColumnaCompleta {
        System.out.println("-------- CONECTA 4 --------");
        tablero.iniciarTablero();
        reiniciarV();
        int modo;
        System.out.println("Elija un modo de juego: (1)Basico | (2)Entrenamiento | (3)Demo");
        do{
            modo = m.nextInt();
            if(modo != 1 && modo != 2 && modo != 3) System.out.println("Invalid number! Values[1-3]");
        }while(modo != 1 && modo != 2 && modo != 3);

        mode.setModo(modo-1);
        System.out.println("Modo -> " + mode.getModo());

        System.out.println(tablero);

        while(!tablero.full() && !victoria.getVictoria()){
            if(mode.getModo() == "BASICO"){
                int columna;
                do{
                    System.out.println("Turn: " + turno.getJugador());
                    System.out.print("Enter a column to drop a token: ");
                    columna = sc.nextInt();
                    if(columna < 1 || columna > 7){
                        //throw new ColumnaNoValida();
                        System.out.println("Invalid column! Values[1-7]");
                    }
                    if(tablero.columnaLlena(columna)){
                        //throw new ColumnaCompleta();
                        System.out.println("Invalid column! Its completed");
                    }
                }while((columna < 1 || columna > 7) || tablero.columnaLlena(columna));

                tablero.ponerFicha(columna, turno.getFichas());

                System.out.println(" -----------------------------");
                System.out.print(tablero);
                System.out.println(" -----------------------------");

                if(victoria.haGanado(turno.getFichas(), tablero)){
                    System.out.println("HA GANADO!!! " + turno.getJugador());
                }
            }
            else if(mode.getModo() == "ENTRENAMIENTO"){ // Humano = RED , Máquina = YELLOW
                int opcion = -1;
                if(turno.getJugador().equals("RED")){
                    do{
                        System.out.println("Turn PLAYER: " + turno.getJugador());
                        System.out.print("Enter a column to drop a token: ");
                        opcion = sc.nextInt();
                        if(opcion < 1 || opcion > 7){
                            //throw new ColumnaNoValida();
                            System.out.println("Invalid column! Values[1-7]");
                        }
                        if(tablero.columnaLlena(opcion)){
                            //throw new ColumnaCompleta();
                            System.out.println("Invalid column! Its completed");
                        }
                    }while((opcion < 1 || opcion > 7) || tablero.columnaLlena(opcion));

                    tablero.ponerFicha(opcion, turno.getFichas());

                    System.out.println(" -----------------------------");
                    System.out.print(tablero);
                    System.out.println(" -----------------------------");

                    if(victoria.haGanado(turno.getFichas(), tablero)){
                        System.out.println("HA GANADO PLAYER!!! " + turno.getJugador());
                    }
                }
                else{
                    MiniMax IA = new MiniMax(tablero,victoria);
                    System.out.println("Turn IA: " + turno.getJugador());
                    ArrayList<Integer> jugadasValidas = tablero.getJugadasValidas();
                    System.out.println("Jugadas Validas: " + jugadasValidas);
                    opcion = IA.miniMax(tablero, turno);
                    System.out.println("Columna escogida por la IA: " + opcion);

                    tablero.ponerFicha(opcion, turno.getFichas());

                    System.out.println(" -----------------------------");
                    System.out.print(tablero);
                    System.out.println(" -----------------------------");

                    if(victoria.haGanado(turno.getFichas(), tablero)){
                        System.out.println("HA GANADO IA!!! " + turno.getJugador());
                    }
                }
            }
            else{ //demo
                int opcion = -1;
                int ident;
                if(turno.getJugador().equals("RED")) ident = 1;
                else ident = 2;

                MiniMax IA = new MiniMax(tablero,victoria);

                System.out.println("Turn IA" + ident + " " + turno.getJugador() + ":");
                ArrayList<Integer> jugadasValidas = tablero.getJugadasValidas();
                System.out.println("Jugadas Validas: " + jugadasValidas);
                opcion = IA.miniMax(tablero,turno);
                System.out.println("Columna escogida por la IA" + ident + " " + turno.getJugador() + ": " + opcion);

                tablero.ponerFicha(opcion, turno.getFichas());

                System.out.println(" -----------------------------");
                System.out.print(tablero);
                System.out.println(" -----------------------------");

                if(victoria.haGanado(turno.getFichas(), tablero)){
                    System.out.println("HA GANADO IA" + ident + " " + turno.getJugador() + " !!!!");
                }
            }
            turno.nextTurno();
        }
        if(!victoria.getVictoria()) System.out.println("TIED!!!");
    }

    /**
     * Pone el valor de victoria a false para el caso en el que se vuelve a jugar
     */
    public void reiniciarV() {
        this.victoria.setVictoria(false);
    }

    public static void main(String[] args) throws ColumnaCompleta, ColumnaNoValida {
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
