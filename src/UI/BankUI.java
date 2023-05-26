package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import accounts.Accounts;
import accounts.Savingsaccount;
import accounts.Currentaccount;
import BankWriter.BankFileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BankUI {


    Accounts accounts = new Accounts();
    float balance = accounts.getBalance();
     public static void main(String[] args) {
         BankUI atm=new BankUI();
         atm.WelcomeUI();



     }
    JFrame frame= new JFrame("World Bank");
     JLabel welcomelabel = new JLabel("Welcome to World bank");
     JLabel enterpinlabel= new JLabel("Enter pin::");
    JTextField enterpin= new JTextField();
    JButton Loginbtn= new JButton("LOGIN");

    public void WelcomeUI(){
        frame.setLayout(new GridLayout(4, 1));
        frame.setSize(300, 200);
        frame.add(welcomelabel);
        frame.add(enterpinlabel);
        frame.add(enterpin);
        frame.add(Loginbtn);



        Loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accounttypeUI();
            }
        });




        frame.setVisible(true);
    }

    JFrame accountframe =new JFrame("Account Type");
    JLabel accountchoice= new JLabel("Choose Account Type");
    JButton savingsbtn= new JButton("SAVINGS");
    JButton currentbtn= new JButton("CURRENT");

    public void accounttypeUI(){
        String enteredpin= enterpin.getText();

        if (!enteredpin.equals("5555")){
            JOptionPane.showMessageDialog(null, "Invalid Pin");
            return;
        }

        accountframe.setLayout(new GridLayout(3, 1));
        accountframe.setSize(300, 200);
        accountframe.add(accountchoice);
        accountframe.add(savingsbtn);
        accountframe.add(currentbtn);

        savingsbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionUI("Savings");
            }
        });
        currentbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionUI("Current");
            }
        });










        accountframe.setVisible(true);
        accountframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    JFrame transactionframe= new JFrame();
    JLabel transactionlabel= new JLabel("What Do You Want To Do");
    JButton depositbtn= new JButton("DEPOSIT");
    JButton withdrawbtn= new JButton("WITHDRAW");

    public void transactionUI(String accountType){
        transactionframe.setLayout(new GridLayout(3,1));
        transactionframe.setSize(300, 200);
        transactionframe.add(transactionlabel);
        transactionframe.add(depositbtn);
        transactionframe.add(withdrawbtn);

        depositbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositUI(accountType);
            }
        });
        withdrawbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawUI(accountType);
            }
        });





        transactionframe.setVisible(true);
        transactionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JFrame depositframe= new JFrame("Deposit");
    JLabel depositlabel = new JLabel("Enter Deposit Amount");
    JTextField depositinput= new JTextField();
    JButton depositbutton= new JButton("Deposit");

    public void depositUI(String accountType){
        depositframe.setLayout(new GridLayout(3,1));
        depositframe.setSize(300,200);
        depositframe.add(depositlabel);
        depositframe.add(depositinput);
        depositframe.add(depositbutton);






        depositbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    float amount= Float.parseFloat(depositinput.getText());
                    JOptionPane.showMessageDialog(null, "Deposited-" +amount);
                    BankFileWriter.writeTransaction(accountType, "Deposit", amount);



                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "invalid input");
                }
                    }
        });
                depositframe.setVisible(true);
                depositframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    JFrame withdrawframe = new JFrame("Withdraw");
    JLabel withdrawlabel = new JLabel("Enter Withdrawal Amount");
    JTextField withdrawinput = new JTextField();
    JButton withdrawbutton = new JButton("Withdraw");

    public void withdrawUI(String accountType){
        withdrawframe.setLayout(new GridLayout(3,1));
        withdrawframe.setSize(300,200);
        withdrawframe.add(withdrawlabel);
        withdrawframe.add(withdrawinput);
        withdrawframe.add(withdrawbutton);

        withdrawbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float amount = Float.parseFloat(withdrawinput.getText());
                    if (accountType.equals("Savings")) {
                        if (amount > 20000) {
                            JOptionPane.showMessageDialog(null, "Withdrawal limit exceeded");
                        } else {
                            JOptionPane.showMessageDialog(null, "Withdrawn - " + amount);
                        }
                    } else if (accountType.equals("Current")) {
                        if (amount > balance) {
                            JOptionPane.showMessageDialog(null, "Insufficient Funds");
                        } else {
                            JOptionPane.showMessageDialog(null, "Withdrawn - " + amount);
                        }
                    }
                    BankFileWriter.writeTransaction(accountType, "Withdrawal", amount);



                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        });


        withdrawframe.setVisible(true);
        withdrawframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }









}
