public class customerInfo  {

    private String password;
    private address address;
    private String email;
    private String phoneNum;
    private String status;

    private Catalog order;

    private String username;

    public customerInfo(String password, address address, String email, String phoneNum, String status, Catalog order, String username) {
        this.password = password;
        this.address = address;
        this.email = email;
        this.phoneNum = phoneNum;
        this.status = status;
        this.order = order;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public address getAddress() {
        return address;
    }

    public void setAddress(address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}








