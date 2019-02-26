public class Address{
    private String extNumber;
    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String country;

    public Address(String extNumber, String street, String neighborhood, String zipcode, String city, String state, String country){
        this.extNumber = extNumber;
        this.street = street;
        this.neighborhood = neighborhood;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getExtNumber() {
        return extNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setExtNumber(String extNumber) {
        this.extNumber = extNumber;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String toStr(){
        return String.format("%s %s, Col. %s C.P. %s, %s, %s, %s", street, extNumber, neighborhood, zipcode, city, state, country);
    }
}
