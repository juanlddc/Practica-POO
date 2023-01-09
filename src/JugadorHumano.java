import java.util.Scanner;

public class JugadorHumano extends Jugador{
    public final static Scanner scanner = new Scanner(System.in);

    public JugadorHumano(String ficha,String nombre) {
        super(ficha,nombre);
    }

    /**
     * Escoge la columna en la que Jugador Humano introduce una ficha,
     * en el caso de no estar completa
     * @param tablero tablero en el momento de la llamada
     * @return columna en la que introducir una ficha
     */
    @Override
    public int escogerPosicion(ITablero tablero) {
        int pos = -1;
        boolean successful = false;

        do{
            try{
                System.out.println("Please choose a column between 1 and " + tablero.getCOL() + " to insert your token");
                pos = scanner.nextInt();
                if(pos < 1 || pos > tablero.getCOL()){
                    throw new NumeroNoValido();
                }else if(tablero.columnaLlena(pos)){
                    throw new ColumnaCompleta();
                }
                successful = true;
            }catch (ColumnaCompleta e){
                System.out.println(e.getMensaje());

            }catch (NumeroNoValido ex){
                System.out.println(ex.getMensaje() + ". Values[1-" + tablero.getCOL() + "].");
            }
        }while(!successful);

        return pos;
    }
}