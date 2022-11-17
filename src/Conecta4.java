import java.util.Scanner;

public class Conecta4 {

    private Tablero tablero = new Tablero();
    private Turno turno = new Turno();
    public final static Scanner sc = new Scanner(System.in);
    public final static Scanner scanner = new Scanner(System.in);

    public void jugar () throws ColumnaNoValida, ColumnaCompleta {
        System.out.println("------ CONECTA 4 ------");
        tablero.iniciarTablero();
        System.out.println(tablero);
        do{
            int columna;
            do{
                System.out.println("Turn: " + turno.getJugador());
                System.out.print("Enter a column to drop a token: ");
                columna = sc.nextInt();
                if(columna < 1 || columna > 7){
                    throw new ColumnaNoValida();
                    //System.out.println("Invalid column! Values[1-7]");
                }
                if(tablero.columnaLlena(columna)){
                    throw new ColumnaCompleta();
                    //System.out.println("Invalid column! Its completed");
                }
            }while((columna < 1 || columna > 7) || tablero.columnaLlena(columna));

            tablero.ponerFicha(columna, turno.getFichas());

            turno.nextTurno();

            System.out.println(" -----------------------------");
            System.out.print(tablero);
            System.out.println(" -----------------------------");
        }while(!tablero.full());
    }

    public static void main(String[] args) throws ColumnaCompleta, ColumnaNoValida {
        Conecta4 partida = new Conecta4();
        String seguir;
        do{
            partida.jugar();
            //System.out.println("TIED!!!");
            System.out.print("Do you want to continue? (s/n): ");
            seguir = scanner.nextLine();
            System.out.println("\n");
        }while(seguir.equals("S") || seguir.equals("s"));
    }
}
