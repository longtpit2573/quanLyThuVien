package QuanLyThuVien.model.repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import QuanLyThuVien.model.entity.Book;
import QuanLyThuVien.model.entity.Document;
import QuanLyThuVien.model.entity.Journal;
import QuanLyThuVien.model.entity.News;

public class DocumentRepo {
    ArrayList<Document> documentList = new ArrayList<>();
    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<Journal> journalList = new ArrayList<>();
    ArrayList<News> newsList = new ArrayList<>();


    

    public DocumentRepo() {
        loadDataFromFile();
    }

    public void addDocument(Document document){
        documentList.add(document);
        saveDataToFile();
    }

    public void removeDocument(int index){
        documentList.remove(index);
        saveDataToFile();
    }

    public void updateDocument(int index, Document document){
        documentList.set(index, document);
        saveDataToFile();
    }

    public ArrayList<Document> getAllDocument(){
        loadDataFromFile();
        return documentList;
    }

    public void addBook(Book book){
        bookList.add(book);
        saveDataToFile();
    }

    public void removeBook(int index){
        bookList.remove(index);
        saveDataToFile();
    }

    public void updateBook(int index, Book book){
        bookList.set(index, book);
        saveDataToFile();
    }

    public ArrayList<Book> getAllBook(){
        loadDataFromFile();
        return bookList;
    }

    public void addJournal(Journal journal){
        journalList.add(journal);
        saveDataToFile();
    }

    public void removeJournal(int index){
        journalList.remove(index);
        saveDataToFile();
    }

    public void updateJournal(int index, Journal journal){
        journalList.set(index, journal);
        saveDataToFile();
    }

    public ArrayList<Journal> getAllJournal(){
        loadDataFromFile();
        return journalList;
    }

    public void addNews(News news){
        newsList.add(news);
        saveDataToFile();
    }

    public void removeNews(int index){
        newsList.remove(index);
        saveDataToFile();
    }

    public void updateNews(int index, News news){
        newsList.set(index, news);
        saveDataToFile();
    }

    public ArrayList<News> getAllNews(){
        loadDataFromFile();
        return newsList;
    }

    public Document getDocumentByID(String documentID){
        for (Document document : documentList) {
            if(document.getDocumentID().equals(documentID)){
                return document;
            }
        }
        return null;
    }

    public boolean loadDataFromFile(){
        documentList.clear();
        bookList.clear();
        journalList.clear();
        newsList.clear();;
        String filePath = "QuanLyThuVien\\data\\tailieu.txt";
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
                    if(data.split(",")[0].charAt(0)=='B'){
                        String input [] = data.split(",");
                        String documentID = input[0];
                        String publishName = input [1];
                        String relaseNum = input [2];
                        String authorName = input [3];
                        String pageNum = input[4];

                        Book book = new Book(documentID, publishName, relaseNum, authorName, pageNum);
                        documentList.add(book);
                        bookList.add(book);
                    
                    }
                    else if(data.split(",")[0].charAt(0)=='J'){
                        String input [] = data.split(",");
                        String documentID = input[0];
                        String publishName = input [1];
                        String relaseNum = input [2];
                        String relaseOfNum = input[3];
                        String relaseMonth = input [4];

                        Journal journal = new Journal(documentID, publishName, relaseNum, relaseOfNum, relaseMonth);
                        documentList.add(journal);
                        journalList.add(journal);
                        

                    }
                    else if(data.split(",")[0].charAt(0)=='N'){
                        String input [] = data.split(",");
                        String documentID = input[0];
                        String publishName = input [1];
                        String relaseNum = input [2];
                        String relaseDate = input[3];

                        News news = new News(documentID, publishName, relaseNum, relaseDate);
                        documentList.add(news);
                        newsList.add(news);
                    }
                }
                       
            }while(data != null);
            br.close();
        } catch (Exception e) {
          
            System.out.println("Error happens while reading file");
            return false;
        }   

        return true;
    }
        


    public boolean saveDataToFile(){
        File file = new File("QuanLyThuVien\\data\\tailieu.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            for (Book book:bookList){
                String data = book.getDocumentID() + "," + book.getPublishName()+","+ book.getRelaseNum()+","+book.getAuthorName()+","+book.getPageNum();
                pw.println(data);
        
            }

            for (Journal journal : journalList) {
                String data = journal.getDocumentID() + "," + journal.getPublishName() + "," + journal.getRelaseNum() + "," + journal.getRelaseOfNum() + "," + journal.getRelaseMonth();
                pw.println(data);
            }

            for (News news : newsList) {
                String data = news.getDocumentID() + "," + news.getPublishName() + "," + news.getRelaseNum() + "," + news.getRelaseDate();
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
