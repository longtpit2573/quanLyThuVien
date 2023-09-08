package QuanLyThuVien.controller;

import java.util.Scanner;


import QuanLyThuVien.model.entity.Bill;
import QuanLyThuVien.model.entity.Book;
import QuanLyThuVien.model.entity.Customer;
import QuanLyThuVien.model.entity.Document;
import QuanLyThuVien.model.entity.Employee;
import QuanLyThuVien.model.entity.Journal;
import QuanLyThuVien.model.entity.News;
import QuanLyThuVien.model.service.BillService;
import QuanLyThuVien.model.service.CustomerService;
import QuanLyThuVien.model.service.DocumentService;
import QuanLyThuVien.model.service.EmployeeService;

public class ThuVienController {
    static Scanner sc = new Scanner(System.in);
    static BillService billService = new BillService();
    static CustomerService customerService = new CustomerService();
    static EmployeeService employeeService = new EmployeeService();
    static DocumentService documentService = new DocumentService();

    public void displayMenu() {
        while (true) {
            System.out.println("-----Login System-----");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int key = Integer.parseInt(sc.nextLine());

            switch (key) {
                case 1: {
                    loginMenu();
                    break;
                }
                case 2: {
                    break;
                }

            }
        }
    }

    public void loginMenu() {
        while (true) {
            System.out.println("You are: ");
            System.out.println("1. Employee");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            int key = Integer.parseInt(sc.nextLine());

            switch (key) {
                case 1: {
                    employeeLogin();
                    break;
                }

                case 2: {
                    customerLogin();
                    break;
                }

                case 3: {
                    break;
                }

            }

        }
    }

    // EMPLOYEE LOGIN

    public int checkExistEmployee(String username) {
        for (Employee employee : employeeService.getAllEmployeeList()) {
            if (employee.getUsername().equals(username))
                return 1;
        }
        return 0;
    }

    public void employeeLogin() {
        String username;
        String password;
        // username
        do {
            System.out.println("Enter username of employee: ");
            username = sc.nextLine();

            if (checkExistEmployee(username) == 0) {
                System.out.println("User name is not exist");
            }
        } while (checkExistEmployee(username) == 0);

        // password
        int mark = 1;
        do {
            System.out.println("Enter password of employee: ");
            password = sc.nextLine();
            for (Employee employee : employeeService.getAllEmployeeList()) {
                if (employee.getUsername().equals(username)) {
                    if (employee.getPassword().equals(password)) {
                        System.out.println("Login success!");
                        mark = 1;
                    } else {
                        mark = 0;
                    }
                }
            }

        } while (mark == 0);

        while (true) {
            System.out.println("----- Menu Employee Management -----");
            System.out.println("1. Manager Document");
            System.out.println("2. Manager Customer");
            System.out.println("3. Manager Bill");
            System.out.println("4. Exit");

            int key = Integer.parseInt(sc.nextLine());

            switch (key) {
                case 1: {
                    managerDocument();
                    break;
                }
                case 2: {
                    managerCustomer();
                    break;
                }
                case 3: {
                    managerBill();
                    break;
                }
                case 4: {
                    return;
                }
            }
        }

    }

    public void managerDocument() {
        while (true) {
            System.out.println("-----Management Document-----");
            System.out.println("1. Add Document");
            System.out.println("2. Remove Document");
            System.out.println("3. Update Document");
            System.out.println("4. Display all document");
            System.out.println("5. Return");

            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1: {
                    addDocument();
                    break;
                }
                case 2: {
                    removeDocument();
                    break;
                }
                case 3: {
                    updateDocument();
                    break;
                }
                case 4: {
                    displayAllDocument();
                    ;
                    break;
                }
                case 5: {
                    return;
                }

            }
        }

    }

    public void addDocument() {

        while (true) {
            System.out.println("This document is: ");
            System.out.println("1. Book");
            System.out.println("2. Journal");
            System.out.println("3. Newspaper");
            System.out.println("4. Exit");

            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1: {
                    addBook();
                    break;
                }
                case 2: {
                    addJournal();
                    break;
                }
                case 3: {
                    addNewspaper();
                    break;
                }
                case 4: {
                    return;
                }
            }
        }

    }

    // public Book(String documentID, String publishName, String relaseNum, String
    // authorName, String pageNum) {
    // super(documentID, publishName, relaseNum);
    // this.authorName = authorName;
    // this.pageNum = pageNum;

    public void addBook() {
        String documentId;
        String publishName;
        String relaseNum;
        String authorName;
        String pageNum;

        System.out.println("Enter document ID:");
        documentId = sc.nextLine();
        System.out.println("Enter publish name:");
        publishName = sc.nextLine();
        System.out.println("Enter relase number:");
        relaseNum = sc.nextLine();
        System.out.println("Enter author name:");
        authorName = sc.nextLine();
        System.out.println("Enter page number:");
        pageNum = sc.nextLine();

        Book bookDocument = new Book(documentId, publishName, relaseNum, authorName, pageNum);
        documentService.addBook(bookDocument);
        System.out.println("Add book success");

    }

    public void addJournal() {
        String documentID;
        String publishName;
        String relaseNum;
        String relaseOfNum;
        String relaseMonth;

        System.out.println("Enter document ID:");
        documentID = sc.nextLine();
        System.out.println("Enter publish name: ");
        publishName = sc.nextLine();
        System.out.println("Enter relase number: ");
        relaseNum = sc.nextLine();
        System.out.println("Enter relase of number: ");
        relaseOfNum = sc.nextLine();
        System.out.println("Enter relase month: ");
        relaseMonth = sc.nextLine();

        Journal journalDocument = new Journal(documentID, publishName, relaseNum, relaseOfNum, relaseMonth);
        documentService.addJournal(journalDocument);

    }

    public void addNewspaper() {
        String documentID;
        String publishName;
        String relaseNum;
        String relaseDate;

        System.out.println("Enter document ID: ");
        documentID = sc.nextLine();
        System.out.println("Enter publish name: ");
        publishName = sc.nextLine();
        System.out.println("Enter relase number: ");
        relaseNum = sc.nextLine();
        System.out.println("Enter relase date: ");
        relaseDate = sc.nextLine();

        News newsDocument = new News(documentID, publishName, relaseNum, relaseDate);
        documentService.addNews(newsDocument);
    }

    public int doucumentIdIndex(String documentID) {
        int i = 0;
        for (Document document : documentService.getAllDocumentList()) {
            if (document.getDocumentID().equals(documentID)) {
                return i;
            }
            i++;

        }
        return -1;
    }

    public void removeDocument() {
        System.out.println("Enter doucument ID you want to remove: ");
        String documentID = sc.nextLine();
        int i = doucumentIdIndex(documentID);
        if (i == -1) {
            System.out.println("The document is not exist");
        } else {
            if (documentService.getAllBook().get(i).getDocumentID().charAt(0) == 'B') {
                documentService.removeBook(i);
                System.out.println("Remove success!");
            } else if (documentService.getAllBook().get(i).getDocumentID().charAt(0) == 'J') {
                documentService.removeDocument(i);
                System.out.println("Remove success!");
            } else if (documentService.getAllBook().get(i).getDocumentID().charAt(0) == 'N') {
                documentService.removeNews(i);
                System.out.println("Remove success!");
            }

        }

    }

    public void updateDocument() {
        System.out.println("Enter document ID you want to update: ");
        String documentID = sc.nextLine();
        int i = doucumentIdIndex(documentID);
        if (i == -1) {
            System.out.println("The document is not exit");
        }

        else {
            if (documentService.getAllBook().get(i).getDocumentID().charAt(0) == 'B') {
                System.out.println("Enter doucumentID:");
                String documentIDNew = "B" + sc.nextLine();
                System.out.println("Enter publish name: ");
                String publishName = sc.nextLine();
                System.out.println("Enter relaseNum: ");
                String relaseNum = sc.nextLine();
                System.out.println("Enter authorName: ");
                String authorName = sc.nextLine();
                System.out.println("Enter pageNum: ");
                String pageNum = sc.nextLine();

                Book bookNew = new Book(documentIDNew, publishName, relaseNum, authorName, pageNum);
                documentService.updateBook(i, bookNew);
                System.out.println("Update success!");

            } else if (documentService.getAllBook().get(i).getDocumentID().charAt(0) == 'J') {
                System.out.println("Enter doucumentID:");
                String documentIDNew = "J" + sc.nextLine();
                System.out.println("Enter publish name: ");
                String publishName = sc.nextLine();
                System.out.println("Enter relase Num: ");
                String relaseNum = sc.nextLine();
                System.out.println("Enter relase of num : ");
                String relaseOfNum = sc.nextLine();
                System.out.println("Enter relase of month: ");
                String relaseMonth = sc.nextLine();

                Journal journalNew = new Journal(documentIDNew, publishName, relaseNum, relaseOfNum, relaseMonth);

                documentService.updateJournal(i, journalNew);

                System.out.println("Update success!");
            } else if (documentService.getAllBook().get(i).getDocumentID().charAt(0) == 'N') {
                System.out.println("Enter doucumentID:");
                String documentIDNew = "N" + sc.nextLine();
                System.out.println("Enter publish name: ");
                String publishName = sc.nextLine();
                System.out.println("Enter relaseNum: ");
                String relaseNum = sc.nextLine();
                System.out.println("Enter relaseDate: ");
                String relaseDate = sc.nextLine();

                News newsNew = new News(documentIDNew, publishName, relaseNum, relaseDate);

                documentService.updateNews(i, newsNew);

                System.out.println("Update success!");
            }

        }

    }

    public void displayAllDocument() {
        for (Document document : documentService.getAllDocumentList()) {
            System.out.println(document.toString());
        }
    }

    public void managerBill() {
        while (true) {
            System.out.println("-----Manager Bill-----");
            System.out.println("1. Add bill");
            System.out.println("2. Remove bill");
            System.out.println("3. Update bill");
            System.out.println("4. Display all bill");
            System.out.println("5. Exit");

            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1: {
                    addBill();
                    break;
                }
                case 2: {
                    removeBillByDocumentID();
                    break;
                }
                case 3: {
                    updateBill();
                    break;
                }
                case 4: {
                    displayAllBill();
                    break;
                }
                case 5: {
                    return;
                }

            }

        }
    }

    // private Customer customer;
    // private Document documentBorrow;
    // private String dayBorrow;
    // private String dayReturn;
    // private int fee;

    public void addBill() {
        String name;
        String email;
        String phoneNum;
        String username;
        String password;
        String typeCustomer;
        System.out.println("Enter customer name: ");
        name = sc.nextLine();
        System.out.println("Enter customer email: ");
        email = sc.nextLine();
        System.out.println("Enter customer phone number: ");
        phoneNum = sc.nextLine();
        System.out.println("Enter customer username: ");
        username = sc.nextLine();
        System.out.println("Enter customer passowrd: ");
        password = sc.nextLine();
        System.out.println("Enter type customer: ");
        typeCustomer = sc.nextLine();
        Customer customer = new Customer(name, email, phoneNum, username, password, typeCustomer);

        System.out.println("Choose document type:");
        System.out.println("1. Book");
        System.out.println("2. Journal");
        System.out.println("3. News");
        System.out.println("Enter your choice: ");
        int key = Integer.parseInt(sc.nextLine());
        Document document = null;

        switch (key) {

            case 1:
                document = addDocumentBook();
                break;
            case 2:
                document = addDocumentJournal();
                break;
            case 3:
                document = addDocumentNews();
                break;
            default:
                System.out.println("Invalid choice.");
                return;

        }

        System.out.println("Enter day borrow");
        String dayBorrow = sc.nextLine();
        System.out.println("Enter day return: ");
        String dayReturn = sc.nextLine();
        System.out.println("Enter bill ID: ");
        String billID = sc.nextLine();
        Bill bill = new Bill(customer, document, dayBorrow, dayReturn, 0, billID);
        billService.addBill(bill);
        customerService.addCustomer(customer);

    }

    public Document addDocumentBook() {
        System.out.println("Enter document ID:");
        String documentId = sc.nextLine();
        System.out.println("Enter publish name:");
        String publishName = sc.nextLine();
        System.out.println("Enter relase number:");
        String relaseNum = sc.nextLine();
        System.out.println("Enter author name:");
        String authorName = sc.nextLine();
        System.out.println("Enter page number:");
        String pageNum = sc.nextLine();

        return new Book(documentId, publishName, relaseNum, authorName, pageNum);
    }

    public Document addDocumentJournal() {
        System.out.println("Enter document ID:");
        String documentID = sc.nextLine();
        System.out.println("Enter publish name: ");
        String publishName = sc.nextLine();
        System.out.println("Enter relase number: ");
        String relaseNum = sc.nextLine();
        System.out.println("Enter relase of number: ");
        String relaseOfNum = sc.nextLine();
        System.out.println("Enter relase month: ");
        String relaseMonth = sc.nextLine();

        return new Journal(documentID, publishName, relaseNum, relaseOfNum, relaseMonth);
    }

    public Document addDocumentNews() {
        System.out.println("Enter document ID: ");
        String documentID = sc.nextLine();
        System.out.println("Enter publish name: ");
        String publishName = sc.nextLine();
        System.out.println("Enter relase number: ");
        String relaseNum = sc.nextLine();
        System.out.println("Enter relase date: ");
        String relaseDate = sc.nextLine();

        return new News(documentID, publishName, relaseNum, relaseDate);
    }

    public int billIdIndex(String billID) {
        int i = 0;
        for (Bill bill : billService.getAlBillList()) {
            if (bill.getBillID().equals(billID)) {
                return i;
            }
            i++;

        }
        return -1;
    }

    public void removeBillByDocumentID() {
        System.out.println("Enter bill ID you want to remove : ");
        String billID = sc.nextLine();
        int i = billIdIndex(billID);
        if (i == -1) {
            System.out.println("The bill is not exist");
        } else {
            billService.removeBill(i);
            customerService.removeCustomer(i);
        }
    }

    public void updateBill() {
        System.out.println("Enter document ID you want to update bill: ");
        String billtID = sc.nextLine();
        int i = billIdIndex(billtID);

        if (i == -1) {
            System.out.println("The bill is not exit");
        }

        else {

            while (true) {
                System.out.println("Choose field to update:");
                System.out.println("1. Day borrow");
                System.out.println("2. Day return");
                System.out.println("3. Fee");
                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.println("Enter new day borrow: ");
                        String newDayBorrow = sc.nextLine();
                        billService.getAlBillList().get(i).setDayBorrow(newDayBorrow);
                        ;
                        break;
                    }
                    case 2: {
                        System.out.println("Enter new day return: ");
                        String newDayReturn = sc.nextLine();
                        billService.getAlBillList().get(i).setDayReturn(newDayReturn);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter new Fee: ");
                        int newFee = Integer.parseInt(sc.nextLine());
                        billService.getAlBillList().get(i).setFee(newFee);
                        break;
                    }
                    default:
                        System.out.println("Invalid choice.");
                        return;
                }

                System.out.println("Bill updated successfully!");
            }

        }

    }

    public void displayAllBill() {
        for (Bill bill : billService.getAlBillList()) {
            System.out.println(bill.toString());
        }
    }

    public void managerCustomer() {
        while (true) {
            System.out.println("-----Manager Customer-----");
            System.out.println("1. Add customer");
            System.out.println("2. Remove customer");
            System.out.println("3. Update customer");
            System.out.println("4. Display all customer");
            System.out.println("5. Exit");

            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1: {
                    addCustomer();
                    break;
                }
                case 2: {
                    removeCustomerByUsername();
                    break;
                }
                case 3: {
                    updateCustomer();
                    break;
                }
                case 4: {
                    displayAllCustomer();
                    break;
                }
                case 5: {
                    return;
                }

            }

        }

    }

    public void addCustomer() {
        String name;
        String email;
        String phoneNum;
        String username;
        String password;
        String typeCustomer;

        System.out.println("Enter customer name: ");
        name = sc.nextLine();
        System.out.println("Enter customer email: ");
        email = sc.nextLine();
        System.out.println("Enter phone number: ");
        phoneNum = sc.nextLine();
        System.out.println("Enter username: ");
        username = sc.nextLine();
        System.out.println("Enter password: ");
        password = sc.nextLine();
        System.out.println("Enter type customer: ");
        typeCustomer = sc.nextLine();

        Customer customer = new Customer(name, email, phoneNum, username, password, typeCustomer);
        customerService.addCustomer(customer);
        billService.addBill(null);

    }

    public int usernameIndex(String username) {
        int i = 0;
        for (Customer customer : customerService.getAllCustomerList()) {
            if (customer.getUsername().equals(username)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void removeCustomerByUsername() {
        System.out.println("Enter username customer you want to remove: ");
        String username = sc.nextLine();
        int i = usernameIndex(username);

        if (i == -1) {
            System.out.println("This customer is not exist");
        } else {
            customerService.removeCustomer(i);
            billService.removeBill(i);
        }
    }

    public void updateCustomer() {
        System.out.println("Enter username customer you want to update: ");
        String username = sc.nextLine();
        int i = usernameIndex(username);

        if (i == -1) {
            System.out.println("This username is not exist");
        } else {
            System.out.println("Enter new Name: ");
            String newName = sc.nextLine();
            customerService.getAllCustomerList().get(i).setName(newName);

            System.out.println("Enter new Email: ");
            String newEmail = sc.nextLine();
            customerService.getAllCustomerList().get(i).setEmail(newEmail);

            System.out.println("Enter new Phone Number: ");
            String newPhoneNum = sc.nextLine();
            customerService.getAllCustomerList().get(i).setPhoneNum(newPhoneNum);

            System.out.println("Enter new Password: ");
            String newPassword = sc.nextLine();
            customerService.getAllCustomerList().get(i).setPassword(newPassword);

            System.out.println("Enter new Type of Customer: ");
            String newTypeCustomer = sc.nextLine();
            customerService.getAllCustomerList().get(i).setTypeCustomer(newTypeCustomer);

            Customer customerNew = new Customer(newName, newEmail, newPhoneNum, username, newPassword, newTypeCustomer);
            customerService.updateCustomer(i, customerNew);
            ;
            System.out.println("Customer updated successfully!");
        }
    }

    public void displayAllCustomer() {
        for (Customer customer : customerService.getAllCustomerList()) {
            System.out.println(customer.toString());
        }
    }

    // CUSTOMER LOGIN ///////////////////////////////////////////////////////////////////////////////////

    public int checkExistCustomer(String username) {
        
        for (Customer customer : customerService.getAllCustomerList()) {
            if (customer.getUsername().equals(username))
                return 1;
        }
        
        return 0;
    }

    public void customerLogin() {
        String username;
        String password;
        // username
        do {
            System.out.println("Enter username of customer: ");
            username = sc.nextLine();

            if (checkExistCustomer(username) == 0) {
                System.out.println("User name is not exist");
            }
        } while (checkExistCustomer(username) == 0);

        // password
        int mark = 1;
        do {
            System.out.println("Enter password of customer: ");
            password = sc.nextLine();
            for (Customer customer : customerService.getAllCustomerList()) {
                if (customer.getUsername().equals(username)) {
                    if (customer.getPassword().equals(password)) {
                        System.out.println("Login success!");
                        mark = 1;
                    } else {
                        mark = 0;
                    }
                }
            }

        } while (mark == 0);

        while (true) {
            System.out.println("----- Menu Customer Library-----");
            System.out.println("1. Borrow Document");
            System.out.println("2. Display My Information");
            System.out.println("3. Display Information you borrowed");
            System.out.println("4. Return");

            int key = Integer.parseInt(sc.nextLine());

            switch (key) {
                case 1: {
                    borrowDocument(username);
                    break;
                }
                case 2: {
                    displayMyInformation(username);
                    break;
                }
                case 3: {
                    displayInformationDocumentBorrow(username);
                    break;
                }
                case 4: {
                    return;
                }
            }
        }

    }

    // Customer Manager

    public void borrowDocument(String username) {
        displayAllDocument();
        System.out.println("Enter document id you want to borrow: ");
        String documentID = sc.nextLine();
        int i = doucumentIdIndex(documentID);
        if (i == -1) {
            System.out.println("This document is not exits");
        } else {
            if (documentService.getAllBook().get(i).getDocumentID().charAt(0) == 'B') {
                Customer customer = getCustomerByUsername(username);
                Book book = getBookByID(documentID);
                System.out.println("Enter day borrow: ");
                String dayBorrow = sc.nextLine();
                System.out.println("Enter day return: ");
                String dayReturn = sc.nextLine();
                System.out.println("Enter fee: ");
                int fee = Integer.parseInt(sc.nextLine());
                System.out.println("Enter billId : ");
                String billID = sc.nextLine();

                Bill bill = new Bill(customer, book, dayBorrow, dayReturn, fee, billID);
                billService.addBill(bill);


                System.out.println("You borrowed book success!");
            } 
            else if (documentService.getAllJournal().get(i).getDocumentID().charAt(0) == 'J') {
                Customer customer = getCustomerByUsername(username);
                Journal journal = getJournalByID(documentID);
                System.out.println("Enter day borrow: ");
                String dayBorrow = sc.nextLine();
                System.out.println("Enter day return: ");
                String dayReturn = sc.nextLine();
                System.out.println("Enter fee: ");
                int fee = Integer.parseInt(sc.nextLine());
                System.out.println("Enter billId : ");
                String billID = sc.nextLine();

                Bill bill = new Bill(customer, journal, dayBorrow, dayReturn, fee, billID);
                billService.addBill(bill);


                System.out.println("You borrowed journal success!");
            }
            else if (documentService.getAllNews().get(i).getDocumentID().charAt(0) == 'N') {
                Customer customer = getCustomerByUsername(username);
                News news = getNewsByID(documentID);
                System.out.println("Enter day borrow: ");
                String dayBorrow = sc.nextLine();
                System.out.println("Enter day return: ");
                String dayReturn = sc.nextLine();
                System.out.println("Enter fee: ");
                int fee = Integer.parseInt(sc.nextLine());
                System.out.println("Enter billId : ");
                String billID = sc.nextLine();

                Bill bill = new Bill(customer, news, dayBorrow, dayReturn, fee, billID);
                billService.addBill(bill);


                System.out.println("You borrowed news success!");
            }
        }

    }

    public Book getBookByID(String documentID){
        for (Book book : documentService.getAllBook()) {
            if(book.getDocumentID().equals(documentID)){
                return book;
            }
        }

        return null;
    }
    public Journal getJournalByID(String documentID){
        for (Journal journal : documentService.getAllJournal()) {
            if(journal.getDocumentID().equals(documentID)){
                return journal;
            }
        }

        return null;
    }
    public News getNewsByID(String documentID){
        for (News news : documentService.getAllNews()) {
            if(news.getDocumentID().equals(documentID)){
                return news;
            }
        }

        return null;
    }

    public Customer getCustomerByUsername(String username){
        for (Customer customer : customerService.getAllCustomerList()){
            if(customer.getUsername().equals(username)){
                return customer;
            }
        }
        return null;
            
    }


    public int getIndexCustomer(String username){
        int i = 0;
        for (Customer customer : customerService.getAllCustomerList()) {
            if(customer.getUsername().equals(username)){
                return i;
            }
            i++;
        }
        return -1;
    }


    public void displayMyInformation(String username){
        for (Customer customer : customerService.getAllCustomerList()) {
            if(customer.getUsername().equals(username)){
                System.out.println(customer.toString());
            }
        }
    }

    public void displayInformationDocumentBorrow(String username){
        for (Bill bill : billService.getAlBillList()) {
            if(bill.getCustomer().getUsername().equals(username)){
                System.out.println("123");
                System.out.println(bill.toString());
            }
        }
    }



    public static void main(String[] args) {
        ThuVienController thuVienController = new ThuVienController();
        thuVienController.displayMenu();
    }

}
