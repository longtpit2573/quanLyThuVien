package QuanLyThuVien.model.entity;

public class Bill {
    private Customer customer;
    private Document documentBorrow;
    private String dayBorrow;
    private String dayReturn;
    private int fee;
    private String billID;
    
    public Bill() {
    }
    
    public Bill(Customer customer, Document documentBorrow, String dayBorrow, String dayReturn, int fee, String billID) {
        this.customer = customer;
        this.documentBorrow = documentBorrow;
        this.dayBorrow = dayBorrow;
        this.dayReturn = dayReturn;
        this.fee = fee;
        this.billID = billID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Document getDocumentBorrow() {
        return documentBorrow;
    }

    public void setDocumentBorrow(Document documentBorrow) {
        this.documentBorrow = documentBorrow;
    }

    public String getDayBorrow() {
        return dayBorrow;
    }

    public void setDayBorrow(String dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    public String getDayReturn() {
        return dayReturn;
    }

    public void setDayReturn(String dayReturn) {
        this.dayReturn = dayReturn;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getBillID(){
        return billID;
    }

    public void setBillID(String billID){
        this.billID = billID;
    }

    @Override
    public String toString() {
        return "Bill [customer=" + customer + ", documentBorrow=" + documentBorrow + ", dayBorrow=" + dayBorrow
                + ", dayReturn=" + dayReturn + ", fee=" + fee + ", billID=" + billID + "]";
    }

    
}
