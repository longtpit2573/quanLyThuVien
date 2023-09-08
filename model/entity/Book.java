package QuanLyThuVien.model.entity;

public class Book extends Document{
    private String authorName;
    private String pageNum;
    
    public Book(String documentID, String publishName, String relaseNum) {
        super(documentID, publishName, relaseNum);
    }
    public Book(String documentID, String publishName, String relaseNum, String authorName, String pageNum) {
        super(documentID, publishName, relaseNum);
        this.authorName = authorName;
        this.pageNum = pageNum;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getPageNum() {
        return pageNum;
    }
    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }
    @Override
    public String toString() {
        return super.toString() + "Book [authorName=" + authorName + ", pageNum=" + pageNum + "]";
    }
    
    

    
}
