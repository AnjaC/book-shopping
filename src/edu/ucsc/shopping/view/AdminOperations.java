package edu.ucsc.shopping.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ucsc.book.controller.BookController;
import edu.ucsc.shopping.model.Book;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

/**
 * 
 * GUI component that allows admin to add/remove books from the system.
 * 
 * @author pallavidas
 *
 */
public class AdminOperations extends JFrame {

	private JPanel contentPane;
	private JTextField bookCodeTextField;
	private JTextField bookNameTextField;
	private JTextField priceTextField;
	private JButton btnShowBookList;
	private JList updatedBookList;
	private ArrayList<Book> books;
	private JButton btnRemoveBook;
	private JLabel lblBookName_1;
	private JTextField bookName;
	private DefaultListModel<String> dlm;
	private JButton btnExit;
	private BookController controller = new BookController();

	/**
	 * Create the frame.
	 */
	public AdminOperations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();
				book.setBookCode(bookCodeTextField.getText());
				book.setBookName(bookNameTextField.getText());
				book.setPrice(Double.parseDouble(priceTextField.getText()));
				boolean flag = controller.addNewBook(book);
				if (flag) {
					JOptionPane.showMessageDialog(null, "Addition succesful");
				} else {
					JOptionPane.showMessageDialog(null, "Addition failed");
				}
				showBookList(e);
			}
		});

		JLabel lblBookCode = new JLabel("Book Code");

		bookCodeTextField = new JTextField();
		bookCodeTextField.setColumns(10);

		JLabel lblBookName = new JLabel("Book Name");

		bookNameTextField = new JTextField();
		bookNameTextField.setColumns(10);

		JLabel lblBookPrice = new JLabel("Book Price");

		priceTextField = new JTextField();
		priceTextField.setColumns(10);

		dlm = new DefaultListModel<>();
		btnShowBookList = new JButton("Show Book List");
		btnShowBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBookList(e);
			}
		});

		updatedBookList = new JList();

		btnRemoveBook = new JButton("Delete Book");
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();
				book.setBookName(bookName.getText());
				boolean flag = controller.delBook(book);
				if (flag) {
					JOptionPane.showMessageDialog(null, "Deleted");
				} else {
					JOptionPane.showMessageDialog(null, "failed");
				}
				showBookList(e);
			}
		});

		lblBookName_1 = new JLabel("Book Name");

		bookName = new JTextField();
		bookName.setColumns(10);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnShowBookList)
								.addComponent(btnAddBook)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(14)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnExit).addComponent(btnRemoveBook))))
				.addGap(43)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblBookName_1).addGap(28)
								.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addComponent(updatedBookList, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBookName).addComponent(lblBookPrice).addComponent(lblBookCode))
								.addGap(94)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(bookNameTextField, GroupLayout.PREFERRED_SIZE, 123,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(bookCodeTextField, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(8, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(15)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookCodeTextField, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBookCode).addComponent(btnAddBook))
				.addGap(18)
				.addGroup(
						gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookNameTextField, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBookName))
				.addGap(17)
				.addGroup(
						gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBookPrice))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(updatedBookList, GroupLayout.PREFERRED_SIZE, 292,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnShowBookList))
				.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnRemoveBook)
						.addComponent(lblBookName_1).addComponent(bookName, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(41).addComponent(btnExit).addGap(36)));
		contentPane.setLayout(gl_contentPane);
	}

	public void showBookList(ActionEvent e) {
		dlm.clear();
		updatedBookList.setModel(dlm);
		books = controller.getAllBooks();
		for (Book book : books) {
			dlm.addElement(book.getBookName());
			updatedBookList.setModel(dlm);
		}
	}

}
