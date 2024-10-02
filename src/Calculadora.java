import java.util.Scanner;

public class Calculadora {

    private static final double[] notasMoedas = {100.00, 50.00, 20.00, 10.00, 5.00, 2.00, 1.00, 0.50, 0.25, 0.10, 0.05, 0.01};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Valor Total das Compras: R$ ");
        double valor_Compra = scan.nextDouble();

        System.out.print("Valor Recebido: R$ ");
        double valor_Recebido = scan.nextDouble();

        if (valor_Recebido >= valor_Compra) {
            double troco = valor_Recebido - valor_Compra;
            System.out.printf("Troco: R$ %.2f\n", troco);

            cauculandoTroco(troco);
        } else {
            System.out.println("Valor recebido é menor que o valor da compra.");
        }

        scan.close();
    }

    private static void cauculandoTroco(double troco) {
        for (double valor : notasMoedas) {
            int quantidade = (int) (troco / valor);
            if (quantidade > 0) {
                if (valor >= 1.00) {
                    System.out.printf("%d Nota(s) de R$ %.2f\n", quantidade, valor);
                } else {
                    System.out.printf("%d Moeda(s) de R$ %.2f\n", quantidade, valor);
                }
                troco -= quantidade * valor;
            }
        }
    }
}