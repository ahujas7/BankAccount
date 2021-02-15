import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BankAccountGUI {

	private JFrame frame;
	private Integer accountNum;
	private JPanel frontPage;

	private static HashMap<Integer, BankAccount> bankAccounts = new HashMap<Integer, BankAccount>();


	public class FrontPage extends JPanel {

		public FrontPage() {

			frontPage = new JPanel();
			frontPage.setBackground(new Color(73, 108, 163));
			frontPage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(frontPage);
			frontPage.setLayout(null);

			JLabel title = new JLabel("Bank of Java");
			title.setBounds(201, 36, 291, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			frontPage.add(title);

			JButton loginBtn = new JButton("Login");
			loginBtn.setBackground(Color.WHITE);
			loginBtn.setBounds(279, 262, 136, 49);
			loginBtn.setFont(new Font("Perpetua", Font.PLAIN, 35));
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new LoginPage());
					frame.validate();
					frame.repaint();
				}
			});
			frontPage.add(loginBtn);

			JButton newAccBtn = new JButton("Create New Account");
			newAccBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new NewAccPage());
					frame.validate();
					frame.repaint();
				}
			});
			newAccBtn.setFont(new Font("Perpetua", Font.PLAIN, 35));
			newAccBtn.setBackground(Color.WHITE);
			newAccBtn.setBounds(181, 366, 331, 49);
			frontPage.add(newAccBtn);

			JButton exitBtn = new JButton("Exit");
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					System.exit(1);
				}
			});
			exitBtn.setFont(new Font("Perpetua", Font.PLAIN, 35));
			exitBtn.setBackground(Color.WHITE);
			exitBtn.setBounds(279, 524, 136, 49);
			frontPage.add(exitBtn);
		} 

	}

	public class LoginPage extends JPanel {

		public LoginPage() {

			JPanel loginPage = new JPanel();
			loginPage.setBackground(new Color(73, 108, 163));
			loginPage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(loginPage);
			loginPage.setLayout(null);

			JLabel title = new JLabel("Login");
			title.setBounds(201, 36, 291, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			loginPage.add(title);

			JTextField textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Perpetua", Font.PLAIN, 35));
			textField.setBounds(281, 215, 291, 58);
			loginPage.add(textField);
			textField.setColumns(10);

			JPasswordField passwordField = new JPasswordField();
			passwordField.setFont(new Font("Perpetua", Font.PLAIN, 35));
			passwordField.setHorizontalAlignment(SwingConstants.CENTER);
			passwordField.setBounds(281, 331, 291, 58);
			loginPage.add(passwordField);

			JLabel lblNewLabel = new JLabel("Account Number:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lblNewLabel.setBounds(12, 214, 235, 58);
			loginPage.add(lblNewLabel);

			JLabel lastName = new JLabel("Password:");
			lastName.setHorizontalAlignment(SwingConstants.CENTER);
			lastName.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lastName.setBounds(12, 330, 235, 58);
			loginPage.add(lastName);

			JLabel lblError = new JLabel("");
			lblError.setForeground(Color.WHITE);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
			lblError.setBounds(0, 125, 694, 58);
			loginPage.add(lblError);

			JButton btnCreate = new JButton("Login");
			btnCreate.setBackground(Color.WHITE);
			btnCreate.setFont(new Font("Perpetua", Font.PLAIN, 35));
			btnCreate.setBounds(229, 464, 235, 49);
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (bankAccounts.containsKey(Integer.parseInt(textField.getText())) && bankAccounts.get(Integer.parseInt(textField.getText())).checkPswd(passwordField.getText())) {

						accountNum = Integer.parseInt(textField.getText());

						Container contain = frame.getContentPane();
						contain.removeAll();

						contain.add(new WelcomePage());
						frame.validate();
						frame.repaint();

					}
					else { 

						lblError.setText("Error. Incorrect Credentials Entered. Please Try Again.");

						textField.setText("");
						passwordField.setText("");	}
				}
			});
			loginPage.add(btnCreate);

			JButton back = new JButton("Back");
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new FrontPage());
					frame.validate();
					frame.repaint();
				}
			});
			back.setFont(new Font("Perpetua", Font.PLAIN, 35));
			back.setBackground(Color.WHITE);
			back.setBounds(12, 603, 120, 49);
			loginPage.add(back);

		} 

	}

	public class NewAccPage extends JPanel {

		public NewAccPage() {

			JPanel newAccPage = new JPanel();
			newAccPage.setBackground(new Color(73, 108, 163));
			newAccPage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(newAccPage);
			newAccPage.setLayout(null);

			JLabel title = new JLabel("New Account");
			title.setBounds(201, 36, 291, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			newAccPage.add(title);

			JTextField tfFName = new JTextField();
			tfFName.setHorizontalAlignment(SwingConstants.CENTER);
			tfFName.setFont(new Font("Perpetua", Font.PLAIN, 35));
			tfFName.setBounds(281, 190, 291, 58);
			newAccPage.add(tfFName);
			tfFName.setColumns(10);

			JLabel lblNewLabel = new JLabel("First Name:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lblNewLabel.setBounds(12, 189, 235, 58);
			newAccPage.add(lblNewLabel);

			JLabel lastName = new JLabel("Last Name:");
			lastName.setHorizontalAlignment(SwingConstants.CENTER);
			lastName.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lastName.setBounds(12, 287, 235, 58);
			newAccPage.add(lastName);

			JButton back = new JButton("Back");
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new FrontPage());
					frame.validate();
					frame.repaint();
				}
			});
			back.setFont(new Font("Perpetua", Font.PLAIN, 35));
			back.setBackground(Color.WHITE);
			back.setBounds(12, 603, 120, 49);
			newAccPage.add(back);

			JTextField tfLName = new JTextField();
			tfLName.setHorizontalAlignment(SwingConstants.CENTER);
			tfLName.setFont(new Font("Perpetua", Font.PLAIN, 35));
			tfLName.setColumns(10);
			tfLName.setBounds(281, 287, 291, 58);
			newAccPage.add(tfLName);

			JButton btnCreate = new JButton("Create");
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					BankAccount newAcc = new BankAccount(tfFName.getText(), tfLName.getText());

					bankAccounts.put(newAcc.getAcctNum(), newAcc);

					accountNum = newAcc.getAcctNum();

					if (tfFName.getText().equals("") && tfLName.getText().equals("")) {

						newAcc.log += (BankAccount.genTimestamp() + " New Account Opened!");
					}
					else {

						newAcc.log += (BankAccount.genTimestamp() + " New Account Opened With Name " + newAcc.getFName() + " " + newAcc.getLName() + "!");
					}

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new PostNewAcc());
					frame.validate();
					frame.repaint();
				}
			});
			btnCreate.setBackground(Color.WHITE);
			btnCreate.setFont(new Font("Perpetua", Font.PLAIN, 35));
			btnCreate.setBounds(229, 446, 235, 49);
			newAccPage.add(btnCreate);

		}
	}

	public class PostNewAcc extends JPanel {

		public PostNewAcc() {

			JPanel postNewAcc = new JPanel();
			postNewAcc.setBackground(new Color(73, 108, 163));
			postNewAcc.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(postNewAcc);
			postNewAcc.setLayout(null);

			JLabel title = new JLabel("New Account");
			title.setBounds(201, 36, 291, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			postNewAcc.add(title);

			JLabel lblNewLabel = new JLabel("Your Account Number Is:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lblNewLabel.setBounds(12, 189, 377, 58);
			postNewAcc.add(lblNewLabel);

			JLabel lblPassword = new JLabel("Your Password Is:");
			lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblPassword.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lblPassword.setBounds(85, 286, 235, 58);
			postNewAcc.add(lblPassword);

			JLabel lblError = new JLabel("Please keep the following credentials secure:");
			lblError.setForeground(Color.WHITE);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
			lblError.setBounds(0, 103, 694, 58);
			postNewAcc.add(lblError);

			JButton btnCreate = new JButton("Login");
			btnCreate.setBackground(Color.WHITE);
			btnCreate.setFont(new Font("Perpetua", Font.PLAIN, 35));
			btnCreate.setBounds(229, 446, 235, 49);
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new LoginPage());
					frame.validate();
					frame.repaint();
				} 
			});
			postNewAcc.add(btnCreate);

			JLabel lblPassword_2 = new JLabel(bankAccounts.get(accountNum).getPswd());
			lblPassword_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPassword_2.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lblPassword_2.setBounds(376, 286, 235, 58);
			postNewAcc.add(lblPassword_2);

			JLabel lblAccountNum = new JLabel(bankAccounts.get(accountNum).getAcctNum() + "");
			lblAccountNum.setHorizontalAlignment(SwingConstants.CENTER);
			lblAccountNum.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lblAccountNum.setBounds(376, 189, 235, 58);
			postNewAcc.add(lblAccountNum);
		}

	}

	public class WelcomePage extends JPanel {

		public WelcomePage() {

			JPanel welcomePage = new JPanel();
			welcomePage.setBackground(new Color(73, 108, 163));
			welcomePage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(welcomePage);
			welcomePage.setLayout(null);

			JLabel title = new JLabel("Welcome " + bankAccounts.get(accountNum).getFName() + " " + bankAccounts.get(accountNum).getLName());
			title.setBounds(12, 13, 670, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			welcomePage.add(title);

			JButton logout = new JButton("Logout");
			logout.setBackground(Color.WHITE);
			logout.setFont(new Font("Perpetua", Font.PLAIN, 35));
			logout.setBounds(12, 603, 151, 49);
			logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new FrontPage());
					frame.validate();
					frame.repaint();
				}
			});
			welcomePage.add(logout);

			JButton btnDeposit = new JButton("Deposit");
			btnDeposit.setFont(new Font("Perpetua", Font.PLAIN, 35));
			btnDeposit.setBackground(Color.WHITE);
			btnDeposit.setBounds(193, 94, 307, 49);
			btnDeposit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new Deposit());
					frame.validate();
					frame.repaint();
				}
			});
			welcomePage.add(btnDeposit);

			JButton withdraw = new JButton("Withdraw");
			withdraw.setFont(new Font("Perpetua", Font.PLAIN, 35));
			withdraw.setBackground(Color.WHITE);
			withdraw.setBounds(193, 164, 307, 49);
			withdraw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new Withdraw());
					frame.validate();
					frame.repaint();
				}
			});
			welcomePage.add(withdraw);

			JButton transfer = new JButton("Transfer");
			transfer.setFont(new Font("Perpetua", Font.PLAIN, 35));
			transfer.setBackground(Color.WHITE);
			transfer.setBounds(193, 233, 307, 49);
			transfer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new Transfer());
					frame.validate();
					frame.repaint();
				}
			});
			welcomePage.add(transfer);

			JButton resetPswd = new JButton("Reset Password");
			resetPswd.setFont(new Font("Perpetua", Font.PLAIN, 35));
			resetPswd.setBackground(Color.WHITE);
			resetPswd.setBounds(193, 438, 307, 49);
			resetPswd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new ResetPswd());
					frame.validate();
					frame.repaint();
				}
			});
			welcomePage.add(resetPswd);

			JButton balance = new JButton("Balance");
			balance.setFont(new Font("Perpetua", Font.PLAIN, 35));
			balance.setBackground(Color.WHITE);
			balance.setBounds(193, 303, 307, 49);
			balance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new Balance());
					frame.validate();
					frame.repaint();
				}
			});
			welcomePage.add(balance);

			JButton history = new JButton("Transaction History");
			history.setFont(new Font("Perpetua", Font.PLAIN, 35));
			history.setBackground(Color.WHITE);
			history.setBounds(193, 370, 307, 49);
			history.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new History());
					frame.validate();
					frame.repaint();
				}
			});
			welcomePage.add(history);

			JButton delete = new JButton("Delete Account");
			delete.setFont(new Font("Perpetua", Font.PLAIN, 35));
			delete.setBackground(Color.WHITE);
			delete.setBounds(193, 508, 307, 49);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new DeleteAcc());
					frame.validate();
					frame.repaint();
				}
			});
			welcomePage.add(delete);

		}

	}


	public class Deposit extends JPanel {

		public Deposit() {

			JPanel depositPage = new JPanel();
			depositPage.setBackground(new Color(73, 108, 163));
			depositPage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(depositPage);
			depositPage.setLayout(null);

			JLabel title = new JLabel("Deposit");
			title.setBounds(12, 13, 670, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			depositPage.add(title);

			JLabel lblError = new JLabel("");
			lblError.setForeground(Color.WHITE);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
			lblError.setBounds(0, 84, 694, 58);
			depositPage.add(lblError);

			JButton back = new JButton("Back");
			back.setBackground(Color.WHITE);
			back.setFont(new Font("Perpetua", Font.PLAIN, 35));
			back.setBounds(12, 603, 151, 49);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new WelcomePage());
					frame.validate();
					frame.repaint();
				}
			});
			depositPage.add(back);

			JLabel lblAmount = new JLabel("Amount:");
			lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
			lblAmount.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lblAmount.setBounds(12, 268, 228, 58);
			depositPage.add(lblAmount);

			JTextField textField = new JTextField();
			textField.setFont(new Font("Perpetua", Font.PLAIN, 35));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setBounds(252, 273, 390, 49);
			depositPage.add(textField);
			textField.setColumns(10);

			JLabel dollars = new JLabel("$");
			dollars.setHorizontalAlignment(SwingConstants.CENTER);
			dollars.setFont(new Font("Perpetua", Font.PLAIN, 35));
			dollars.setBounds(229, 268, 22, 58);
			depositPage.add(dollars);

			JButton confirm = new JButton("Confirm");
			confirm.setFont(new Font("Perpetua", Font.PLAIN, 35));
			confirm.setBackground(Color.WHITE);
			confirm.setBounds(217, 412, 260, 49);
			confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (bankAccounts.get(accountNum).deposit(Double.parseDouble(textField.getText()))) {

						lblError.setText("Deposit Successful.");	 
						textField.setText("");
					}
					else {

						lblError.setText("Error. Deposit Unsuccessful. Please Try Again.");
						textField.setText(""); 
					}
				}		
			});
			depositPage.add(confirm);
		}
	}

	public class Withdraw extends JPanel {

		public Withdraw() {

			JPanel withdrawPage = new JPanel();
			withdrawPage.setBackground(new Color(73, 108, 163));
			withdrawPage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(withdrawPage);
			withdrawPage.setLayout(null);

			JLabel title = new JLabel("Withdraw");
			title.setBounds(12, 13, 670, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			withdrawPage.add(title);

			JLabel lblError = new JLabel("");
			lblError.setForeground(Color.WHITE);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
			lblError.setBounds(0, 84, 694, 58);
			withdrawPage.add(lblError);

			JButton back = new JButton("Back");
			back.setBackground(Color.WHITE);
			back.setFont(new Font("Perpetua", Font.PLAIN, 35));
			back.setBounds(12, 603, 151, 49);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new WelcomePage());
					frame.validate();
					frame.repaint();
				}
			});
			withdrawPage.add(back);

			JLabel lblAmount = new JLabel("Amount:");
			lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
			lblAmount.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lblAmount.setBounds(12, 268, 228, 58);
			withdrawPage.add(lblAmount);

			JTextField textField = new JTextField();
			textField.setFont(new Font("Perpetua", Font.PLAIN, 35));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setBounds(252, 273, 390, 49);
			withdrawPage.add(textField);
			textField.setColumns(10);

			JLabel dollars = new JLabel("$");
			dollars.setHorizontalAlignment(SwingConstants.CENTER);
			dollars.setFont(new Font("Perpetua", Font.PLAIN, 35));
			dollars.setBounds(229, 268, 22, 58);
			withdrawPage.add(dollars);

			JButton confirm = new JButton("Confirm");
			confirm.setFont(new Font("Perpetua", Font.PLAIN, 35));
			confirm.setBackground(Color.WHITE);
			confirm.setBounds(217, 412, 260, 49);
			confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (bankAccounts.get(accountNum).withdraw(Double.parseDouble(textField.getText()))) {

						lblError.setText("Withdrawal Successful.");
						textField.setText("");
					}
					else {

						lblError.setText("Error. Withdrawal Unsuccessful. Please Try Again.");
						textField.setText("");
					}
				}
			});
			withdrawPage.add(confirm);
		}

	}

	public class Transfer extends JPanel {

		public Transfer() {

			JPanel transferPage = new JPanel();
			transferPage.setBackground(new Color(73, 108, 163));
			transferPage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(transferPage);
			transferPage.setLayout(null);

			JLabel title = new JLabel("Transfer");
			title.setBounds(12, 13, 670, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			transferPage.add(title);

			JLabel lblError = new JLabel("");
			lblError.setForeground(Color.WHITE);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
			lblError.setBounds(0, 83, 694, 58);
			transferPage.add(lblError);

			JButton back = new JButton("Back");
			back.setBackground(Color.WHITE);
			back.setFont(new Font("Perpetua", Font.PLAIN, 35));
			back.setBounds(12, 603, 151, 49);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new WelcomePage());
					frame.validate();
					frame.repaint();
				}
			});
			transferPage.add(back);

			JTextField textField = new JTextField();
			textField.setFont(new Font("Perpetua", Font.PLAIN, 35));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setBounds(325, 188, 315, 49);
			transferPage.add(textField);
			textField.setColumns(10);

			JLabel label = new JLabel("To Account Number:");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Perpetua", Font.PLAIN, 35));
			label.setBounds(12, 183, 273, 58);
			transferPage.add(label);

			JLabel otherLabel = new JLabel("Amount:");
			otherLabel.setHorizontalAlignment(SwingConstants.CENTER);
			otherLabel.setFont(new Font("Perpetua", Font.PLAIN, 35));
			otherLabel.setBounds(12, 315, 260, 58);
			transferPage.add(otherLabel);

			JTextField amount = new JTextField();
			amount.setHorizontalAlignment(SwingConstants.CENTER);
			amount.setFont(new Font("Perpetua", Font.PLAIN, 35));
			amount.setColumns(10);
			amount.setBounds(325, 320, 315, 49);
			transferPage.add(amount);

			JLabel dollars = new JLabel("$");
			dollars.setHorizontalAlignment(SwingConstants.CENTER);
			dollars.setFont(new Font("Perpetua", Font.PLAIN, 35));
			dollars.setBounds(303, 315, 22, 58);
			transferPage.add(dollars);

			JButton confirm = new JButton("Confirm");
			confirm.setFont(new Font("Perpetua", Font.PLAIN, 35));
			confirm.setBackground(Color.WHITE);
			confirm.setBounds(217, 468, 260, 49);
			confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (bankAccounts.containsKey(Integer.parseInt(textField.getText())) && 
							bankAccounts.get(accountNum).transferTo(Double.parseDouble(amount.getText()), bankAccounts.get(Integer.parseInt(textField.getText()))) &&
							!(accountNum == Integer.parseInt(textField.getText()))) {

						lblError.setText("Transfer Made Successfully.");
						textField.setText("");
						amount.setText("");
					}
					else {

						lblError.setText("Error. Transfer Failed. Please Try Again.");
						textField.setText("");
						amount.setText("");
					}
				}
			});
			transferPage.add(confirm);
		}

	}

	public class Balance extends JPanel {

		public Balance() {

			JPanel balancePage = new JPanel();
			balancePage.setBackground(new Color(73, 108, 163));
			balancePage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(balancePage);
			balancePage.setLayout(null);

			JLabel title = new JLabel("Balance");
			title.setBounds(12, 13, 670, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			balancePage.add(title);

			JButton back = new JButton("Back");
			back.setBackground(Color.WHITE);
			back.setFont(new Font("Perpetua", Font.PLAIN, 35));
			back.setBounds(12, 603, 151, 49);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new WelcomePage());
					frame.validate();
					frame.repaint();
				}
			});
			balancePage.add(back);

			JTextField textField = new JTextField();
			textField.setEditable(false);
			textField.setFont(new Font("Perpetua", Font.PLAIN, 35));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setBounds(152, 273, 390, 49);
			textField.setText(bankAccounts.get(accountNum).getBalance() + "");
			balancePage.add(textField);
			textField.setColumns(10);

			JLabel dollars = new JLabel("$");
			dollars.setHorizontalAlignment(SwingConstants.CENTER);
			dollars.setFont(new Font("Perpetua", Font.PLAIN, 35));
			dollars.setBounds(132, 268, 22, 58);
			balancePage.add(dollars);	
		}

	}

	public class ResetPswd extends JPanel {

		public ResetPswd() {

			JPanel resetPage = new JPanel();
			resetPage.setBackground(new Color(73, 108, 163));
			resetPage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(resetPage);
			resetPage.setLayout(null);

			JLabel title = new JLabel("Reset Password");
			title.setBounds(12, 13, 670, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			resetPage.add(title);

			JLabel lblError = new JLabel("");
			lblError.setForeground(Color.WHITE);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
			lblError.setBounds(0, 84, 694, 58);
			resetPage.add(lblError);

			JButton back = new JButton("Back");
			back.setBackground(Color.WHITE);
			back.setFont(new Font("Perpetua", Font.PLAIN, 35));
			back.setBounds(12, 603, 151, 49);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new WelcomePage());
					frame.validate();
					frame.repaint();
				}
			});
			resetPage.add(back);

			JLabel label = new JLabel("Current Password:");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Perpetua", Font.PLAIN, 35));
			label.setBounds(12, 183, 260, 58);
			resetPage.add(label);

			JLabel lblNewPassword = new JLabel("New Password:");
			lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewPassword.setFont(new Font("Perpetua", Font.PLAIN, 35));
			lblNewPassword.setBounds(12, 315, 260, 58);
			resetPage.add(lblNewPassword);

			JPasswordField currentPswd = new JPasswordField();
			currentPswd.setFont(new Font("Perpetua", Font.PLAIN, 35));
			currentPswd.setBounds(314, 192, 304, 49);
			currentPswd.setHorizontalAlignment(SwingConstants.CENTER);
			resetPage.add(currentPswd);

			JPasswordField newPswd = new JPasswordField();
			newPswd.setFont(new Font("Perpetua", Font.PLAIN, 35));
			newPswd.setBounds(314, 324, 304, 49);
			newPswd.setHorizontalAlignment(SwingConstants.CENTER);
			resetPage.add(newPswd);

			JButton confirm = new JButton("Confirm");
			confirm.setFont(new Font("Perpetua", Font.PLAIN, 35));
			confirm.setBackground(Color.WHITE);
			confirm.setBounds(217, 468, 260, 49);
			confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (bankAccounts.get(accountNum).resetPswd(currentPswd.getText(), newPswd.getText())) {

						lblError.setText("Password Change Successful.");
						currentPswd.setText("");
						newPswd.setText("");		
					}
					else {

						lblError.setText("Error. Password Entered Incorrectly. Please Try Again.");
						currentPswd.setText("");
						newPswd.setText("");	
					}
				}
			});
			resetPage.add(confirm);
		}

	}

	public class History extends JPanel {

		public History() { 

			JPanel historyPage = new JPanel();
			historyPage.setBackground(new Color(73, 108, 163));
			historyPage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(historyPage);
			historyPage.setLayout(null);

			JLabel title = new JLabel("Transaction History");
			title.setBounds(12, 13, 670, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			historyPage.add(title);

			JLabel lblError = new JLabel("");
			lblError.setForeground(Color.WHITE);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
			lblError.setBounds(0, 84, 694, 58);
			historyPage.add(lblError);

			JButton back = new JButton("Back");
			back.setBackground(Color.WHITE);
			back.setFont(new Font("Perpetua", Font.PLAIN, 35));
			back.setBounds(12, 603, 151, 49);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new WelcomePage());
					frame.validate();
					frame.repaint();
				}
			});
			historyPage.add(back);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(43, 123, 607, 418);
			historyPage.add(scrollPane);

			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
			textArea.setRows(bankAccounts.get(accountNum).getRows());
			textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
			textArea.setText(bankAccounts.get(accountNum).getLog());
		}

	}

	public class DeleteAcc extends JPanel {

		public DeleteAcc() {

			JPanel deletePage = new JPanel();
			deletePage.setBackground(new Color(73, 108, 163));
			deletePage.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(deletePage);
			deletePage.setLayout(null);

			JLabel title = new JLabel("Delete My Account");
			title.setBounds(12, 13, 670, 58);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Perpetua", Font.PLAIN, 50));
			deletePage.add(title);

			JLabel lblError = new JLabel("Please note that the following action is permanent.");
			lblError.setForeground(Color.WHITE);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
			lblError.setBounds(0, 134, 694, 58);
			deletePage.add(lblError);

			JButton logout = new JButton("Back");
			logout.setBackground(Color.WHITE);
			logout.setFont(new Font("Perpetua", Font.PLAIN, 35));
			logout.setBounds(12, 603, 151, 49);
			logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new WelcomePage());
					frame.validate();
					frame.repaint();
				}
			});
			deletePage.add(logout);

			JButton delete = new JButton("Delete My Account");
			delete.setFont(new Font("Perpetua", Font.PLAIN, 35));
			delete.setBackground(Color.WHITE);
			delete.setBounds(193, 323, 307, 49);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					bankAccounts.remove(accountNum);

					Container contain = frame.getContentPane();
					contain.removeAll();

					contain.add(new FrontPage());
					frame.validate();
					frame.repaint();
				}
			});
			deletePage.add(delete);
		}

	}

	public BankAccountGUI() {

		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setTitle("Bank of Java");

		frame.setResizable(false);

		frame.setSize(700, 700);

		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
		
		FrontPage fp = new FrontPage();
		
		frame.setContentPane(frontPage);

	}

	public static void main (String [] args) {

		new BankAccountGUI();

	}

}
