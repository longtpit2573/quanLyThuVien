package QuanLyThuVien.model.service;

import java.util.ArrayList;

import QuanLyThuVien.model.entity.Customer;
import QuanLyThuVien.model.repo.CustomerRepo;

public class CustomerService {
    CustomerRepo customerRepo = new CustomerRepo();
    
    public void addCustomer(Customer customer){
        customerRepo.addCustomer(customer);
    }

    public void removeCustomer(int index){
        customerRepo.removeCustomer(index);
    }

    public void updateCustomer(int index, Customer customer){
        customerRepo.updateCustomer(index, customer);
    }

    public ArrayList<Customer> getAllCustomerList(){
        return customerRepo.getAllCustomers();
    }
}
