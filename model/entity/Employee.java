package QuanLyThuVien.model.entity;

public class Employee {
    private String name;
    private String email;
    private String phoneNum;
    private String username;
    private String password;
    
    public Employee(String name, String email, String phoneNum, String username, String password) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Employee [name=" + name + ", email=" + email + ", phoneNum=" + phoneNum + ", username=" + username
                + ", password=" + password + "]";
    }

    
}
