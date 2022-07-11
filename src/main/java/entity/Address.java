package entity;

public class Address {
    private String city;
    private String locality;
    private String state;
    private Long pinCode;

    public Address(String city, String locality, String state, Long pinCode) {
        this.city = city;
        this.locality = locality;
        this.state = state;
        this.pinCode = pinCode;
    }
}
