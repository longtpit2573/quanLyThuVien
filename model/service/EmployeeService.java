package QuanLyThuVien.model.service;

import java.util.ArrayList;

import QuanLyThuVien.model.entity.Employee;
import QuanLyThuVien.model.repo.EmployeeRepo;

public class EmployeeService {
    EmployeeRepo employeeRepo = new EmployeeRepo();

    public ArrayList<Employee> getAllEmployeeList(){
        return employeeRepo.getAllEmployeeList();
    }
}
