
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

    public class Principal {
        static Double rate = 0.0;

        public static void main(String[] args) {

        while (true) {
            try {
                Double monto = 0.0;
                //Moneda Origen lectura
                Scanner tipoMoneda = new Scanner(System.in);
                System.out.println("Escriba la moneda :");
                var monedaOrigen = tipoMoneda.nextLine();
                Consultarmoneda consulta = new Consultarmoneda();
                Scanner montoLectura = new Scanner(System.in);
                // monto a cambiar
                System.out.println("escriba el monto : ");
                monto = montoLectura.nextDouble();
                System.out.println("**************************************");

                //Moneda de cambio
                Scanner coinOne = new Scanner(System.in);
                System.out.println("Cual es la moneda de Cambio :");
                var monedaBuscar = coinOne.nextLine();

                Moneda moneda = consulta.buscaMoneda(monedaOrigen);
                rate = moneda.conversion_rates().get(monedaBuscar);
                System.out.println("**************************************");
                System.out.println("El monto convertido es : " + rate * monto + " ");
                System.out.println("**************************************");

            } catch (NumberFormatException e) {
                System.out.println("Moneda no encontrada " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
            }

            System.out.println("Para una nueva consulta escribe 1, pasa salir 2");

            Scanner opcionSistema = new Scanner(System.in);
            var opcion = opcionSistema.nextLine();
            if (Objects.equals(opcion, "2")) {
                System.out.println("Saliendo........");
                break;
            }


        }
        }
    }


