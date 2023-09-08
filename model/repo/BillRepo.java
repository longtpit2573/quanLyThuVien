package QuanLyThuVien.model.repo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import QuanLyThuVien.model.entity.Bill;
import QuanLyThuVien.model.entity.Customer;
import QuanLyThuVien.model.entity.Document;


public class BillRepo {
    ArrayList<Bill> billList = new ArrayList<>();

    CustomerRepo customerRepo = new CustomerRepo();
    DocumentRepo documentRepo = new DocumentRepo();

    

    public BillRepo() {
        loadDataFromFile();
    }

    public void addBill(Bill bill){
        billList.add(bill);
        saveDataToFile();
    }

    public void removeBill(int index){
        billList.remove(index);
        saveDataToFile();
    }

    public void updateBill(int index, Bill bill){
        billList.set(index, bill);
        saveDataToFile();
    }

    public ArrayList<Bill> getAllBillList(){
        loadDataFromFile();
        return billList;
    }




    public boolean loadDataFromFile(){
        billList.clear();
        String filePath = "QuanLyThuVien\\data\\bill.txt";
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
                    Customer customer = customerRepo.getCustomerByUsername(input[0]); 
                    Document documentBorrow = documentRepo.getDocumentByID(input[1]);
                    String dayBorrow = input[2];
                    String dayReturn = input[3];
                    int fee = Integer.parseInt(input[4]);
                    String billID = input[5];
                    Bill bill = new Bill(customer, documentBorrow, dayBorrow, dayReturn, fee, billID);
                    billList.add(bill);

                    
                }
            }while(data != null);
            br.close();
        } catch (Exception e) {
          
            System.out.println(e);
            return false;
        }   

        return true;
    }

    public boolean saveDataToFile(){
        File file = new File("QuanLyThuVien\\data\\bill.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            for (Bill bill:billList){
                String data = bill.getCustomer().getUsername() + "," + bill.getDocumentBorrow().getDocumentID()+","+ bill.getDayBorrow()+","+bill.getDayReturn()+","+bill.getFee() +","+bill.getBillID();
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
