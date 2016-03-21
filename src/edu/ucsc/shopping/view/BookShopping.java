package edu.ucsc.shopping.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import edu.ucsc.book.controller.BookController;
import edu.ucsc.shopping.model.Book;
import edu.ucsc.shopping.model.BookCartItem;

/**
 * 
 * GUI component that gives customer the list of books available to select from.
 * Once book is selected it displays total price. Using this interface customer
 * can add book to cart.
 * 
 * @author pallavidas
 *
 */
public class BookShopping extends JFrame {

	private static final long serialVersionUID = 5161519889858864173L;

	private JPanel contentPane;
	private JTextField bookCodeTextField;
	private JTextField priceTextField;
	private JTextField quantityTextField;
	private JTextField totalTextField;
	private JComboBox bookComboBox;
	private ArrayList<Book> books;
	private ArrayList<BookCartItem> bookList;
	private Book book;
	private int quantity = 0;

	private BookController controller = new BookController();

	/**
	 * Create the frame.
	 */
	public BookShopping() {

		initialize();
		books = controller.getAllBooks();
		for (Book book : books) {
			bookComboBox.addItem(book.getBookName());
		}
	}

	private void initialize() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel labelBooks = new JLabel("Select Books");

		bookComboBox = new JComboBox();
		bookComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookComboBoxActionPerformed(e);
			}

			private void bookComboBoxActionPerformed(ActionEvent e) {
				int i = bookComboBox.getSelectedIndex();
				book = books.get(i);
				bookCodeTextField.setText(book.getBookCode());
				priceTextField.setText(book.getFormattedPrice());

				priceTextField.setEditable(false);
				bookCodeTextField.setEditable(false);
			}
		});

		JLabel labelBookCode = new JLabel("Book Code");

		bookCodeTextField = new JTextField();
		bookCodeTextField.setColumns(10);

		JLabel labelPrice = new JLabel("Price");

		priceTextField = new JTextField();
		priceTextField.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity");

		quantityTextField = new JTextField();
		quantityTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("ItemSelected");

		JList selectedlist = new JList();

		JLabel labelTotal = new JLabel("Total");

		totalTextField = new JTextField();
		totalTextField.setColumns(10);

		DefaultListModel<String> dlm = new DefaultListModel<>();

		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String total = "";
				try {
					quantity = Integer.parseInt(quantityTextField.getText());
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Please Enter valid number");
				}

				controller.addBookToCart(new BookCartItem(book, quantity));
				bookList = controller.getBooksFromCart();
				for (BookCartItem bookItem : bookList) {
					total = bookItem.getFormattedTotal();
				}
				BookCartItem bookItem = new BookCartItem(book, quantity);

				dlm.addElement(book.getBookName() + " " + bookItem.getFormattedTotal());
				selectedlist.setModel(dlm);

				totalTextField.setText(controller.getFormattedBookTotal());

				totalTextField.setEditable(false);

			}
		});

		JButton btnRemove = new JButton("Remove from the cart");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = selectedlist.getSelectedIndex();
				dlm.remove(index);
				controller.removeBookFromCart(index);
				totalTextField.setText(controller.getFormattedBookTotal());
				totalTextField.setEditable(false);
			}
		});

		JButton btnProceedForBilling = new JButton("Proceed for billing");
		btnProceedForBilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillPayment bill = new BillPayment();
				bill.setVisible(true);
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(26)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(labelBooks, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(labelBookCode, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelPrice, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelTotal, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addGap(52)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(quantityTextField, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(bookCodeTextField, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(bookComboBox, GroupLayout.PREFERRED_SIZE, 252,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(selectedlist, GroupLayout.PREFERRED_SIZE, 219,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(
								gl_contentPane.createSequentialGroup().addGap(16)
										.addComponent(btnAddToCart, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 179,
												GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnProceedForBilling, GroupLayout.PREFERRED_SIZE, 159,
										GroupLayout.PREFERRED_SIZE).addGap(18)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(34)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(labelBooks).addComponent(
						bookComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(42)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(labelBookCode)
						.addComponent(bookCodeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(26)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(labelPrice).addComponent(
						priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(27)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblQuantity).addComponent(
						quantityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(60).addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(34).addComponent(selectedlist,
								GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(labelTotal).addComponent(
						totalTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(48).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnAddToCart)
						.addComponent(btnRemove).addComponent(btnProceedForBilling).addComponent(btnExit))
				.addGap(35)));
		contentPane.setLayout(gl_contentPane);
	}
}
