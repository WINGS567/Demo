package Demo;

import DAO.BookDAO;
import DTO.BookDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("enter mode of operation");
        System.out.println("1:Add book");
        System.out.println("2:Delete book");
        System.out.println("3:View book");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
            addBooks();
            break;
            case 2:
                deleteBook();
                break;
            case 3:
                viewBooks();
                break;
            default:
                System.out.println("Invalid input");
        }

        }
        private static void viewBooks(){
        BookDAO d1=new BookDAO();
            ArrayList<BookDTO>booklist=d1.displayBooks();
            for(BookDTO b:booklist){
                System.out.println(b);
            }
        }

//    private static void viewBooks() {
//        BookDAO b=new BookDAO();
//        ResultSet rs;
//       rs=b.showBooks();
//
//    try {
//        System.out.println("Book ID \t\tBook Name \t\t Book Price");
//        while (rs.next())
//        {
//            System.out.println(rs.getInt(1)+"\t\t\t\t" +
//                    rs.getString(2)+"\t\t\t"+
//                    rs.getDouble(3));
//        }
//
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }



    private static void deleteBook() {
        System.out.println("enter id");
        int id=sc.nextInt();
        BookDTO d1=new BookDTO();
        d1.setBookid(id);
        BookDAO d2=new BookDAO();
        int count=d2.deletebooks(d1);
        System.out.println(count+"book deleted successfully");
    }
    private static void addBooks() {
        System.out.println("enter book id");
        int id=sc.nextInt();
        System.out.println("enter book  name");
        String name=sc.next();
        System.out.println("enter book price");
        double price=sc.nextDouble();
        //add data into dto object
        BookDTO d1=new BookDTO();
        d1.setBookid(id);
        d1.setBookname(name);
        d1.setBookprice(price);
        //call method from dao class
        BookDAO b1=new BookDAO();
        int count=b1.insertBooks(d1);
        System.out.println(count+"Book inserted successfully");
    }
}

