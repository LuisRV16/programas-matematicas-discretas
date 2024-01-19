package conversion_texto_decimal.conversor;

public class Texto_A_Decimal {

    private String num;
    private double numero;

    public Texto_A_Decimal(){}

    public Texto_A_Decimal(String num) throws WrongFormat {setNum(num);}

    public String getNum() {return num;}

    public void setNum(String num) throws WrongFormat {
        this.num = num;
        evaluateFormat();
    }

    private final void evaluateFormat() throws WrongFormat{

        /*

        El código mostrado es correcto, pero se puede hacer más conciso.

        if (this.num.isEmpty()){
            throw new WrongFormat();
        } else if (this.num.charAt(0) < 48 || this.num.charAt(0) > 57) {
            throw new WrongFormat();
        } else {
            int points = 0;
            for (int i = 0; i < this.num.length(); i++) {
                char c = this.num.charAt(i);
                if (!(c >= 48 && c <= 57 || c == '.')) {
                    throw new WrongFormat();
                }
                if (c == '.') {
                    points++;
                }
            }
            if (points >= 2) throw new WrongFormat();
        }
        */

        /*
         * El código anterior primero analiza que la cadena recibida esté vacía, en caso de estarlo, lanza
         * la excepción. Por el contrario, si no está vacía, pasa a analizar si el primer caracter de la
         * cadena esté dentro del rango de numeros decimales, en caso de que no, se lanza la excepción. Por
         * ultimo, se verifica que algún caracter de la cadena no sea numero o punto, en caso de que esto sea así
         * se lanza la excepción, esto mientras se va recoriendo toda la cadena en un ciclo. Si nunca saltó la
         * excepción dentro del ciclo, al final de todo se verifica que la cadena tenga 2 o más puntos, si esto es
         * así, se lanza la excepción.
         */

        /*
         * El código mas conciso se logra simplificar en una sola sentencia if.
         * Se utiliza num.matches("\\d+(\\.\\d+)?") para verificar si num consiste en uno o más dígitos seguidos
         * opcionalmente por un punto y más dígitos.
         * Esto simplifica la lógica de la comprobación y reemplaza el bucle for.
         *
         * La expresión regular \\d+(\\.\\d+)? significa lo siguiente:
         *   \\d+: Uno o más dígitos.
         *   (\\.\\d+)?: Un punto seguido de uno o más dígitos, opcional.
         *
         * Este enfoque es más compacto y mantiene la misma lógica de validación que se tenía en el código anterior.*/

        if (!num.matches("\\d+(\\.\\d+)?"))
            throw new WrongFormat();

    }

    public void conversion() {
        int pos = num.indexOf('.');
        double temp = 0;
        int potencia = 0;
        int digito;
        if (pos != -1) {

            for (int i = pos - 1; i >= 0 ; i--, potencia++) {
                digito = Integer.parseInt(num.charAt(i)+"");
                temp += digito*Math.pow(10, potencia);
            }

            potencia = -1;

            for (int i = pos + 1; i < num.length(); i++, potencia--) {
                digito = Integer.parseInt(num.charAt(i)+"");
                temp += digito*Math.pow(10, potencia);
            }

        } else {
            for (int i = num.length() - 1; i >= 0 ; i--, potencia++) {
                digito = Integer.parseInt(num.charAt(i)+"");
                temp += digito*Math.pow(10, potencia);
            }
        }

        numero = temp;

    }

    public double getNumero() {
        return numero;
    }

    public static final class WrongFormat extends Exception{
        public WrongFormat(){
            /*
             * Método vació debido a que sólo está creado
             * para identificar el tipo de excepción
             * prevista dentro del contexto del problema
             */
        }
    }
}
