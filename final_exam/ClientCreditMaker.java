import java.util.*;
import java.io.*;

public class ClientCreditMaker{
    private static Scanner sc = new Scanner(System.in);
    private static Solicitant solicitant;

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de solicitud de crédito!");
        System.out.println("Pasaremos a registrar al solicitante");
        System.out.print("Nombre(s): ");
        String firstName = sc.nextLine();
        System.out.print("Apellidos: ");
        String lastName = sc.nextLine();
        System.out.print("Teléfono de casa: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Teléfono celular: ");
        String mobileNumber = sc.nextLine();

        System.out.println("Ahora te preguntaré la dirección");
        System.out.print("Calle (sin el número): ");
        String street = sc.nextLine();
        System.out.print("Número exterior: ");
        String extNumber = sc.nextLine();
        System.out.print("Colonia: ");
        String neighborhood = sc.nextLine();
        System.out.print("Código Postal: ");
        String zipcode = sc.nextLine();
        System.out.print("Delegación: ");
        String city = sc.nextLine();
        System.out.print("Estado: ");
        String state = sc.nextLine();
        System.out.print("País: ");
        String country = sc.nextLine();
        Address address = new Address(extNumber, street, neighborhood, zipcode, city, state, country);

        System.out.println("El solicitante es del programa Premium? (s/n): ");
        String premium = sc.nextLine();
        if (premium.equals("s")){
            solicitant = new PremiumSolicitant(firstName, lastName, phoneNumber, mobileNumber, address);
        } else {
            solicitant = new SilverSolicitant(firstName, lastName, phoneNumber, mobileNumber, address);
        }

        solicitant.greeting();

        System.out.println("Ahora solicitemos un crédito!");
        System.out.print("Monto: ");
        double creditAmount = sc.nextDouble();
        sc.nextLine();
        System.out.println("El plazo es:");
        System.out.println("(1) Mediano");
        System.out.println("(2) Largo");
        System.out.print("Selecciona la opción: ");
        String termTypeStr = sc.nextLine();
        int termType = Integer.valueOf(termTypeStr);
        System.out.println("Ahora la fecha de hoy");
        System.out.print("Día: ");
        int authDay = sc.nextInt();
        sc.nextLine();
        System.out.print("Mes: ");
        int authMonth = sc.nextInt();
        sc.nextLine();
        System.out.print("Año: ");
        int authYear = sc.nextInt();
        sc.nextLine();
        try {
            Credit credit = new Credit(solicitant, termType, creditAmount, authDay, authMonth, authYear);
            System.out.println("Súper, aquí te va el crédito que creaste: ");
            credit.print();
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
