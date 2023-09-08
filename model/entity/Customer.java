package QuanLyThuVien.model.entity;

public class Customer {
    private String name;
    private String email;
    private String phoneNum;
    private String username;
    private String password;
    private String typeCustomer;
    
    public Customer() {
    }

    public Customer(String name, String email, String phoneNum, String username, String password, String typeCustomer) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.username = username;
        this.password = password;
        this.typeCustomer = typeCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", email=" + email + ", phoneNum=" + phoneNum + ", username=" + username
                + ", password=" + password + ", typeCustomer=" + typeCustomer + "]";
    }
    
}
