import java.util.Scanner;

public class Menu {
    //Clase degenerada Menu para limpiar el main Conecta4
    public final static Scanner col = new Scanner(System.in);
    public final static Scanner fil = new Scanner(System.in);
    public final static Scanner m = new Scanner(System.in);

    public int pedirFil() throws NumeroNoValido{
        boolean successful = false;
        int filas = 0;
        do{
            try{
                System.out.println("Numero de filas del tablero? [4-etc]");
                filas = fil.nextInt();
                if(filas < 4){
                    throw new NumeroNoValido();
                }
                successful = true;
            }catch(NumeroNoValido e){
                System.out.println(e.getMensaje());
            }
        }while(!successful);
        return filas;
    }

    public int pedirCol() throws NumeroNoValido{
        boolean successful = false;
        int columnas = 0;
        do{
            try{
                System.out.println("Numero de columnas del tablero? [4-etc]");
                columnas = col.nextInt();
                if(columnas < 4){
                    throw new NumeroNoValido();
                }
                successful = true;
            }catch(NumeroNoValido e){
                System.out.println(e.getMensaje());
            }
        }while(!successful);
        return columnas;
    }

    public int selModo() throws NumeroNoValido{
        int modo = 1;
        boolean successful = false;
        do {
            try {
                System.out.print("Elija un modo de juego:\n" +
                        "(1)Basico\n" +
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
        return modo;
    }
}