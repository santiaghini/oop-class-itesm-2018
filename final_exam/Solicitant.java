public abstract class Solicitant{
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String mobileNumber;
    protected Address address;

    //Gloabl variable for ID
    private static int count = 0;

    public Solicitant(String firstName, String lastName, String phoneNumber, String mobileNumber, Address address){
        count++;
        this.id = count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public abstract void greeting();

    public void print(){
        System.out.printf("ID: %d | Nombre: %s %s \nTeléfono casa: %s | Celular: %s\nDirección: %s\n", id, firstName, lastName, phoneNumber, mobileNumber, address.toStr());

    }
}
