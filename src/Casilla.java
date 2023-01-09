public class Casilla {
    private boolean ocupado;    //Se cambia a un booleano para evitar errores.
    private String dato;
    public Casilla(){           //Por defecto una casilla está libre, sin dato.
        this.ocupado = false;
        this.dato = " ";
    }

    public Casilla(String dato){
        this.dato = dato;
        if(dato.equals(" ")){
            this.ocupado = false;
        }else{
            this.ocupado = true;
        }
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public String getDato() {
        return dato;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setDato(String dato) {
        if(dato.equals(" ")){
            this.dato = dato;
            this.ocupado = false;
        }else{
            this.dato = dato;
            this.ocupado = true;
        }
    }
}
