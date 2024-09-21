package JavaProgramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp extends JFrame {
	
	private double balance;
	private JTextField balanceField;
	private JTextField amountField;
	private JLabel balanceLabel;
	
	public BankBalanceApp () {
		
		// Set frame 
		setTitle("Bank Balance Application");
		setSize(500,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Initialize Balance
		balance = 0.0;
		
		// JPanel 
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,2));
		
		// Create Components
		JLabel initialBalanceLabel = new JLabel("Initial Balance:");
        balanceField = new JTextField(10);
        
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField(10);
        
        balanceLabel = new JLabel("Balance: $0.0");
        
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        
        // Components to Panel
        panel.add(initialBalanceLabel);
        panel.add(balanceField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(balanceLabel);
        
        // Action listeners
        depositButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		deposit();
        	}
        });
        
        withdrawButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		withdraw();
        	}
        });
        
        // Add panel to frame
        add(panel);
        setVisible(true);
	}
     // Method for depositing amount
    public void deposit () {
    	try {
    		double depositAmount = Double.parseDouble(amountField.getText());
            if (balanceField.isEnabled()) {
            	balance = Double.parseDouble(balanceField.getText());
                    balanceField.setEnabled(false); // Disable after initial input
                }
                balance += depositAmount;
                System.out.println("Sucessfully Deposited");
                updateBalanceLabel();
                JOptionPane.showMessageDialog(this, "Deposit successful. $" + depositAmount + " has been added to your account.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
    	}
    	
    	// Method for withdrawing amount
    	public void withdraw () {
    		try {
                double withdrawAmount = Double.parseDouble(amountField.getText());
                if (balanceField.isEnabled()) {
                    balance = Double.parseDouble(balanceField.getText());
                    balanceField.setEnabled(false); // Disable after initial input
                }
                if (withdrawAmount > balance) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds.");
                } else {
                    balance -= withdrawAmount;
                    updateBalanceLabel();
                    JOptionPane.showMessageDialog(this, "Withdrawal successful. $" + withdrawAmount + " has been withdrawn from your account.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
    	}
    	// Update balance label
        private void updateBalanceLabel() {
            balanceLabel.setText("Balance: $" + String.format("%.2f", balance));
        }

        public static void main(String[] args) {
            new BankBalanceApp();
        }
   }