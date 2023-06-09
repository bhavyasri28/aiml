package registration_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField r1;
	private JTextField r2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =   new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("email");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(102, 51, 84, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSetPassword = new JLabel("set password");
		lblSetPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSetPassword.setBounds(36, 102, 160, 37);
		frame.getContentPane().add(lblSetPassword);
		
		r1 = new JTextField();
		r1.setBounds(196, 57, 86, 20);
		frame.getContentPane().add(r1);
		r1.setColumns(10);
		
		r2 = new JTextField();
		r2.setColumns(10);
		r2.setBounds(196, 102, 86, 20);
		frame.getContentPane().add(r2);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=r1.getText();
				String password=r2.getText();

				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec33","root","mrec");
					String q="Insert into login values('"+email+"','"+password+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(137, 170, 131, 26);
		frame.getContentPane().add(btnNewButton);
	}
}
