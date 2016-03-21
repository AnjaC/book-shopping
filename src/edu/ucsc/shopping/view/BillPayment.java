package edu.ucsc.shopping.view;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * GUI component that allows admin to add/remove books from the system.
 * 
 * @author pallavidas
 *
 */
public class BillPayment extends JFrame {

	private static final long serialVersionUID = 8748125531386406407L;

	private JPanel contentPane;
	private JTextField cardNumberTextField;
	private JRadioButton creditCardRadioButton;
	private JList cardTypeList;
	private JComboBox monthComboBox;
	private JComboBox yearComboBox;

	/**
	 * Create the frame.
	 */
	public BillPayment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new TitledBorder(null, "Biling", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);

		JLabel lblCardNumber = new JLabel("Card Number");

		cardNumberTextField = new JTextField();
		cardNumberTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Expiration Date");

		monthComboBox = new JComboBox();

		yearComboBox = new JComboBox();

		creditCardRadioButton = new JRadioButton("Credit Card");

		creditCardRadioButton.setSelected(true);
		creditCardRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creditCardButtonSelect(e);
			}
		});

		cardTypeList = new JList();

		DefaultListModel<String> dlm = new DefaultListModel<>();
		dlm.addElement("Visa");
		dlm.addElement("Master Card");
		dlm.addElement("American express");
		cardTypeList.setModel(dlm);
		JLabel lblCardType = new JLabel("Card Type");

		JButton acceptButton = new JButton("Accept");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				if (creditCardRadioButton.isSelected()) {
					msg = "Payment Completed. Thank you for Shopping";
				}
				JOptionPane.showMessageDialog(null, msg);

			}
		});

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// filling combo box for year
		GregorianCalendar gc = new GregorianCalendar();
		int startYear = gc.get(Calendar.YEAR);
		int endYear = startYear + 8;
		for (int i = startYear; i < endYear; i++) {
			yearComboBox.addItem(Integer.toString(i));
		}

		// filling month combo box
		monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March",
				"April", "May", "June", "July", "August", "September", "October", "November", "December" }));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblCardType)
								.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE).addComponent(
										cardTypeList, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addComponent(creditCardRadioButton))
				.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(yearComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(26, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(17).addComponent(acceptButton)
										.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
										.addComponent(exitButton))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblCardNumber)
								.addGap(18)
								.addComponent(cardNumberTextField, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
						.addGap(22)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(creditCardRadioButton)
						.addGap(30)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCardType)
								.addComponent(cardTypeList, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCardNumber)
						.addComponent(cardNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(38)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
						.addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(yearComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(77).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(acceptButton).addComponent(exitButton))
						.addGap(21)));
		contentPane.setLayout(gl_contentPane);
	}

	private void creditCardButtonSelect(ActionEvent e) {
		if (creditCardRadioButton.isSelected()) {
			enableCreditCardControls(true);
		}
	}

	private void enableCreditCardControls(Boolean enable) {
		cardTypeList.setEnabled(enable);
		cardNumberTextField.setEnabled(enable);
		monthComboBox.setEnabled(enable);
		yearComboBox.setEnabled(enable);
	}

}
