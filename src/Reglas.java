import java.util.Arrays;
import java.util.Objects;

public class Reglas {
        private boolean victoria;
        private final int COL = 7;
        private final int FIL = 6;

        public Reglas(){
            this.victoria = false;
        }

        public boolean getVictoria() {
            return this.victoria;
        }

        public void setVictoria(boolean v) {
            this.victoria = v;
        }

        /**
         * Determina si se ha ganado la partida vertical, horizontal o diagonalmente
         * @param ficha ficha que se ha introducido en el ultimo turno
         * @param tablero tablero en sí
         * @return true si se ha ganado
         */
        public boolean haGanado(String ficha,Tablero tablero) {
            setVictoria(haGanadoVert(ficha,tablero) ||  haGanadoHor(ficha, tablero) || haGanadoDiagIzq(ficha,tablero) || haGanadoDiagDer(ficha,tablero));
            return victoria;
        }

        /** haGanadoVert
         * VERIFICA LAS COLUMNAS DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
         * @param ficha Ficha que hay que verificar
         * @param tablero El tablero en sí
         * @return Un booleano si se cumple la condición o no.
         */

        private boolean haGanadoVert(String ficha,Tablero tablero){
            String[] corte = new String[FIL];
            for(int i = 0; i < COL && !this.victoria; i++){
                for(int j = 0; j < FIL; j++){
                    corte[j] = tablero.getPosicion(i, j);
                }
                setVictoria(verifCorte(corte, FIL, ficha));
            }
            return this.victoria;
        }

        /** haGanadoHorz
         * VERIFICA LAS FILAS DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
         * @param ficha Ficha que hay que verificar
         * @param tablero El tablero en sí
         * @return Un booleano si se cumple la condición o no.
         */
        private boolean haGanadoHor(String ficha,Tablero tablero){
            String[] corte = new String[COL];
            for(int i=0; i < FIL && !this.victoria; i++){
                for(int j=0; j < COL; j++){
                    corte[j] = tablero.getPosicion(j,i);
                }
                setVictoria(verifCorte(corte, COL, ficha));
            }
            return this.victoria;
        }

        /** haGanadoDiagDer
         * VERIFICA LAS DIAGONALES TIPO \ DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
         * @param ficha Ficha que hay que verificar
         * @param tablero El tablero en sí
         * @return Un booleano si se cumple la condición o no.
         */

        private boolean haGanadoDiagDer(String ficha,Tablero tablero){
            String[] corte = new String[4];
            for(int i = 0; (i < 4) && !verifCorte(corte,4,ficha); i++){
                for(int j = 0; (j < 3) && !verifCorte(corte,4,ficha); j++){
                    for(int k = 0; k < 4; k++){
                        corte[k] = tablero.getPosicion(i+k,j+k);
                    }
                }
            }
            setVictoria(verifCorte(corte, 4, ficha));
            return this.victoria;
        }

        /** haGanadoDiagIzq
         * VERIFICA LAS DIAGONALES TIPO / DEL TABLERO PARA LA CONDICIÓN DE VICTORIA
         * @param ficha Ficha que hay que verificar
         * @param tablero El tablero en sí
         * @return Un booleano si se cumple la condición o no.
         */

        private boolean haGanadoDiagIzq(String ficha,Tablero tablero){
            String[] corte = new String[4];
            for(int i = 0; (i < 4) && !verifCorte(corte,4,ficha); i++){
                for(int j = 5; (j > 2) && !verifCorte(corte,4,ficha); j--){
                    for(int k = 0; k < 4; k++){
                        corte[k] = tablero.getPosicion(i+k,j-k);
                    }
                }
            }
            setVictoria(verifCorte(corte, 4, ficha));
            return this.victoria;
        }

        /**
         * Verifica si hay cuatro mismos valores seguidos
         * @param corte array
         * @param tamanio tamaño del array corte
         * @param ficha Ficha que hay que verificar
         * @return true si hay cuatro valores iguales seguidos
         */
        private boolean verifCorte (String[] corte,int tamanio, String ficha){
            boolean victoria = false;
            int cont = 0;
            for(int i=0; i<tamanio && !victoria; i++){
                if(corte[i] == ficha){
                    cont++;

                }else
                    cont = 0;
                if(cont == 4)
                    victoria = true;
            }
            return victoria;
        }
}
