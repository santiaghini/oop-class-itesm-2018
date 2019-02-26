public class SilverSolicitant extends Solicitant{

    public SilverSolicitant(String firstName, String lastName, String phoneNumber, String mobileNumber, Address address){
        super(firstName, lastName, phoneNumber, mobileNumber, address);
    }

    public void greeting(){
        System.out.printf("Hola, %s\n", this.firstName);
    }
}