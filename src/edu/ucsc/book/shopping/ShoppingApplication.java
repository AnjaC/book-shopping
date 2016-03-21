package edu.ucsc.book.shopping;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import edu.ucsc.shopping.view.AdminLogin;
import edu.ucsc.shopping.view.CustomerLogin;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is an Book Shopping Application. It allows customer to select books from
 * list of available books. Lets them add books to the cart. Further their
 * purchase is processed and bill is generated. On the other hand administrator
 * is allowed to add new book to the list and also delete book from the list.
 * Current system is designed only for One customer and one administrator.
 * 
 * @author pallavidas
 *
 */
public class ShoppingApplication {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingApplication window = new ShoppingApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShoppingApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CustomerLogin clf = new CustomerLogin();
				clf.setVisible(true);
			}
		});

		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminLogin alf = new AdminLogin();
				alf.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap(135, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING,
												groupLayout.createSequentialGroup().addComponent(btnCustomer).addGap(
														55))
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup().addComponent(btnAdministrator).addGap(38)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btnCustomer)
						.addComponent(btnAdministrator).addContainerGap(8, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
