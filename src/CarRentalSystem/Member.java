package CarRentalSystem;

class Member extends Customer {
    private String memberId;

    public Member(String name, String driverLicense, String memberId) {
        super(name, driverLicense);
        this.memberId = memberId;
    }

    @Override
    public String getCustomerType() {
        return "Member";
    }
}
