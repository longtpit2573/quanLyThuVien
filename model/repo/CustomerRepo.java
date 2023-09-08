package QuanLyThuVien.model.repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import QuanLyThuVien.model.entity.Customer;

public class CustomerRepo {
    ArrayList<Customer> customerList = new ArrayList<>();
    

    public CustomerRepo() {
        loadDataFromFile();
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
        saveDataToFile();
    }

    public void removeCustomer(int index){
        customerList.remove(index);
        saveDataToFile();
    }

    public void updateCustomer(int index, Customer customer){
        customerList.set(index, customer);
        saveDataToFile();
    }

    public ArrayList<Customer> getAllCustomers(){
        loadDataFromFile();
        return customerList;
    }


    public Customer getCustomerByUsername(String username){
        for (Customer customer : getAllCustomers()) {
            if(customer.getUsername().equals(username));
            return customer;
        }
        return null;
    }

    public boolean loadDataFromFile(){
        customerList.clear();
        String filePath = "QuanLyThuVien\\data\\khachhang.txt";
        File file = new File(filePath);
        
        if(!file.exists()){
            System.out.println("The file does not exist");
            return false;
        }

        
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String data;
            do{
                data = br.readLine();

                if(data != null){
                    String input[] = data.split(",");
                    String name = input[0];
                    String email = input[1];
                    String phoneNum = input[2];
                    String username = input[3];
                    String password = input[4];
                    String typeCustomer = input[5];
                    customerList.add(new Customer(name, email, phoneNum, username, password, typeCustomer));
                }
            }while(data != null);
            br.close();
        } catch (Exception e) {
          
            System.out.println("Error happens while reading file");
            return false;
        }   

        return true;
    }

    public boolean saveDataToFile(){
        File file = new File("QuanLyThuVien\\data\\khachhang.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            for (Customer customer:customerList){
                String data = customer.getName() + "," + customer.getEmail()+","+ customer.getPhoneNum()+","+customer.getUsername()+","+customer.getPassword()+","+customer.getTypeCustomer();
                pw.println(data);
            }
        } catch (Exception e) {
            
            System.out.println("Error happen while writing to file");
            return false;
        } finally{
            if(pw != null){
                pw.flush();
                pw.close();
            }
        }
        return true;
    }
    
}


