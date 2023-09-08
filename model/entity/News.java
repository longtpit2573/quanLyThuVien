package QuanLyThuVien.model.entity;

public class News extends Document{
    private String relaseDate;

    public News(String documentID, String publishName, String relaseNum) {
        super(documentID, publishName, relaseNum);
    }

    public News(String documentID, String publishName, String relaseNum, String relaseDate) {
        super(documentID, publishName, relaseNum);
        this.relaseDate = relaseDate;
    }

    public String getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(String relaseDate) {
        this.relaseDate = relaseDate;
    }

    @Override
    public String toString() {
        return super.toString()+ "News [relaseDate=" + relaseDate + "]";
    }
    

  
    
}
