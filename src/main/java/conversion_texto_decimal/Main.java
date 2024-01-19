package conversion_texto_decimal;

import conversion_texto_decimal.conversor.Texto_A_Decimal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        try {
            Texto_A_Decimal conv = new Texto_A_Decimal(s);

            conv.conversion();

            System.out.println(conv.getNumero());

        } catch (Texto_A_Decimal.WrongFormat e) {
            System.out.println("El formato introducido para la conversión a Decimal es incorrecto.");
        }
    }
}
