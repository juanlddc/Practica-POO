public class Coordenada {
    private int x;
    private int y;
    private int ocupado;
    private String dato;

    public Coordenada(int x, int y){
        this.x = x;
        this.y = y;
        this.ocupado = 0;
        this.dato = " ";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getOcupado() {
        return ocupado;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        if(dato.equals(" ")){
            this.dato = dato;
            this.ocupado = 0;
        }else{
            this.dato = dato;
            this.ocupado = 1;
        }
    }
}
