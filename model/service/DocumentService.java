package QuanLyThuVien.model.service;

import java.util.ArrayList;

import QuanLyThuVien.model.entity.Book;
import QuanLyThuVien.model.entity.Document;
import QuanLyThuVien.model.entity.Journal;
import QuanLyThuVien.model.entity.News;
import QuanLyThuVien.model.repo.DocumentRepo;

public class DocumentService {
    DocumentRepo documentRepo = new DocumentRepo();
    

    public void addDocument(Document document){
        documentRepo.addDocument(document);
    }

    public void removeDocument(int index){
        documentRepo.removeDocument(index);
    }

    public void updateDocument(int index, Document document){
        documentRepo.updateDocument(index, document);
    }
    public ArrayList<Document> getAllDocumentList(){
        return documentRepo.getAllDocument();
    }

    public void addBook(Book book){
        documentRepo.addBook(book);
    }

    public void removeBook(int index){
        documentRepo.removeBook(index);
    }

    public void updateBook(int index, Book book){
        documentRepo.updateBook(index, book);
    }

    public ArrayList<Book> getAllBook(){
        return documentRepo.getAllBook();
    }

    public void addJournal(Journal journal){
        documentRepo.addJournal(journal);
    }

    public void removeJournal(int index){
        documentRepo.removeJournal(index);
    }

    public void updateJournal(int index, Journal journal){
        documentRepo.updateJournal(index, journal);
    }

    public ArrayList<Journal> getAllJournal(){
        return documentRepo.getAllJournal();
    }

    public void addNews(News news){
        documentRepo.addNews(news);
    }

    public void removeNews(int index){
        documentRepo.removeNews(index);
    }

    public void updateNews(int index, News news){
        documentRepo.updateNews(index, news);
    }

    public ArrayList<News> getAllNews(){
        return documentRepo.getAllNews();
    }

}
