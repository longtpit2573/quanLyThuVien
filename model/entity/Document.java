package QuanLyThuVien.model.entity;

public class Document {
    private String documentID;
    private String publishName;
    private String relaseNum;
    public Document(String documentID, String publishName, String relaseNum) {
        this.documentID = documentID;
        this.publishName = publishName;
        this.relaseNum = relaseNum;
    }
    public String getDocumentID() {
        return documentID;
    }
    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }
    public String getPublishName() {
        return publishName;
    }
    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }
    public String getRelaseNum() {
        return relaseNum;
    }
    public void setRelaseNum(String relaseNum) {
        this.relaseNum = relaseNum;
    }
    @Override
    public String toString() {
        return "Document [documentID=" + documentID + ", publishName=" + publishName + ", relaseNum=" + relaseNum + "]";
    }

    
}
