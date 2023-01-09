public class Memento {
    public Casilla[][] memoryData;

    public Memento(Casilla[][] data, int col, int fil) {
        this.memoryData = new Casilla[col][fil];
        for(int i = 0; i < fil; i++){
            for(int j = 0; j < col; j++){
                this.memoryData[j][i] = new Casilla(data[j][i].getDato());
            }
        }
    }

    /**
     * Devuelve el dato guardado en el atributo
     * @return memorydata
     */
    public Casilla[][] recoverOldInformation(){
        return memoryData;
    }
}