public class PremiumSolicitant extends Solicitant{

    public PremiumSolicitant(String firstName, String lastName, String phoneNumber, String mobileNumber, Address address){
        super(firstName, lastName, phoneNumber, mobileNumber, address);
    }

    public void greeting(){
        System.out.printf("Es un placer tenerlo de vuelta, estimad@ %s\n", this.firstName);
    }
}
