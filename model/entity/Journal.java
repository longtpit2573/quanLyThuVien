package QuanLyThuVien.model.entity;

public class Journal extends Document{
    private String relaseOfNum;
    private String relaseMonth;
    
    public Journal(String documentID, String publishName, String relaseNum) {
        super(documentID, publishName, relaseNum);
    }

    public Journal(String documentID, String publishName, String relaseNum, String relaseOfNum, String relaseMonth) {
        super(documentID, publishName, relaseNum);
        this.relaseOfNum = relaseOfNum;
        this.relaseMonth = relaseMonth;
    }

    public String getRelaseOfNum() {
        return relaseOfNum;
    }

    public void setRelaseOfNum(String relaseOfNum) {
        this.relaseOfNum = relaseOfNum;
    }

    public String getRelaseMonth() {
        return relaseMonth;
    }

    public void setRelaseMonth(String relaseMonth) {
        this.relaseMonth = relaseMonth;
    }

    @Override
    public String toString() {
        return super.toString() + "Journal [relaseNum=" + relaseOfNum + ", relaseMonth=" + relaseMonth +  "]";
    }

    
}
