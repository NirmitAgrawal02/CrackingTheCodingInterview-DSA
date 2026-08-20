package LLD.Amazon;

class User {
    private int uuid;
    private String name;
    private String address;
    private String phoneNumber;
    User(int uuid, String name, String address, String phoneNumber) {
        this.uuid = uuid;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getUuid() {
        return uuid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}