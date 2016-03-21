package edu.ucsc.book.datasources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ucsc.shopping.model.Book;

public class BookDB implements BookDAO{
	private static BookDAO bookdbInstance = null;
	
	private BookDB(){
		//its a private constructor for singleton pattern.
	}
	
	public static BookDAO getBookdbInstance(){
		if(bookdbInstance == null){
			bookdbInstance = new BookDB();
		}
		return bookdbInstance;
	}

	private static Connection connect() {
		Connection connection = null;
		try {
			String dbDirectory = "Resources";
			System.setProperty("derby.system.home", dbDirectory);

			String url = "jdbc:derby:BookDB";
			String user = "";
			String password = "";
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("Error loading database driver: " + e);
		}
		return connection;
	}

	public ArrayList<Book> getBooks() {
		ArrayList<Book> bookList = new ArrayList<>();
		try {

			Book bookObj;
			Connection connection = connect();
			String query = "SELECT BookCode, BookName, Price " + "FROM Books ORDER BY BookCode ASC ";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			System.out.println("BOOK LIST");
			while (rs.next()) {
				String bookCode = rs.getString("BookCode");
				String bookName = rs.getString("BookName");
				double price = rs.getDouble("Price");

				bookObj = new Book(bookCode, bookName, price);
				bookList.add(bookObj);
			}

			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException sqle) {
			// sqle.printStackTrace(); // for debugging
		}
		return bookList;
	}

	public boolean addBook(Book bookObj) {
		try {
			Connection connection = connect();
			String insert = "INSERT INTO Books(BookCode, BookName, Price) " + "VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setString(1, bookObj.getBookCode());
			ps.setString(2, bookObj.getBookName());
			ps.setDouble(3, bookObj.getPrice());
			ps.executeUpdate();
			ps.close();
			connection.close();
			return true;
		} catch (SQLException sqle) {
			return false;
		}
	}

	public boolean deleteBook(Book bookObj) {
		try {
			Connection connection = connect();
			String delete = "DELETE FROM Books " + "WHERE BookName = ?";
			PreparedStatement ps = connection.prepareStatement(delete);
			ps.setString(1, bookObj.getBookName());
			ps.executeUpdate();
			ps.close();
			connection.close();
			return true;
		} catch (SQLException sqle) {
			return false;
		}
	}
}
