package QuanLyThuVien.model.service;

import java.util.ArrayList;

import QuanLyThuVien.model.entity.Bill;
import QuanLyThuVien.model.repo.BillRepo;

public class BillService {
    BillRepo billRepo = new BillRepo();

    public void addBill(Bill bill){
        billRepo.addBill(bill);
    }

    public void removeBill(int index){
        billRepo.removeBill(index);
    }

    public void updateBill(int index, Bill bill){
        billRepo.updateBill(index, bill);
    }

    public ArrayList<Bill> getAlBillList(){
        return billRepo.getAllBillList();
    }
}
