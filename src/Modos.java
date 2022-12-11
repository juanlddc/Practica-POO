public class Modos {
    private static final String[] modos = {"BASICO","ENTRENAMIENTO","DEMO"};
    private int mod;

    public Modos() {
        this.mod = 0;
    }

    public void setModo(int modo) {
        this.mod = modo;
    }

    public String getModo() {
        return modos[this.mod];
    }
}
