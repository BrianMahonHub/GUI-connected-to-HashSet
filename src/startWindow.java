import java.awt.Color;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

import java.util.TreeSet;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class startWindow {

	HashSet<Team> hset = new HashSet<Team>();
	List<Team> set = new ArrayList<Team>(hset);
	int current = 0;

	private JFrame frmA;
	private JTextField textField;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField1;
	String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startWindow window = new startWindow();
					window.frmA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public startWindow() {
		initialize();
		Collections.addAll(set, new Team("Arsenal", "Emirates Stadium","60,432"),
				new Team("Bournemouth", "Vitality Stadium", "11,700"),
				new Team("Burnley", "Turf Moor", "22,546"), 
				new Team("Chelsea","Stamford Bridge", "41,798"), 
				new Team("Crystal Palace", "Selhurst Park", "26,309"), 
				new Team("Everton", "Goodison Park", "39,571"), 
				new Team("Hull City", "KCOM Stadium", "25,400"), 
				new Team("Leicester City", "King Power", "32,500"), 
				new Team("Liverpool", "Anfield", "54,167"), 
				new Team("Manchester City", "Etihad Stadium", "55,000"),
				new Team("Manchester Utd", "Old Trafford", "75,635"), 
				new Team("Middlesbrough", "Riverside Stadium", "33,746"),
				new Team("Southampton", "St.Mary's Stadium", "32,689"),
				new Team("Stoke City", "bet365 Stadium", "27,740"), 
				new Team("Sunderland", "Stadium of Light", "48,707"), 
				new Team("Swansea City", "Liberty Stadium", "20,937"), 
				new Team("Tottenham", "White Hart Lane", "36,284"), 
				new Team("Watford", "Vicarage Road", "21,977"), 
				new Team("West Brom", "The Hawthorns", "26,445"), 
				new Team("West Ham", "London Stadium", "60,000"));
		display(navigate(0));
	}

	public Team search(String n) {
		Team res = null;
		Iterator<Team> iter = set.iterator();
		while (iter.hasNext()) {
			Team element = (Team) iter.next();
			if (n.equals(element.readName()))
				res = element;
		}
		return res;
	}

	public Team navigate(int index) {
		Team res = null;
		Iterator<Team> iter = set.iterator();
		int count = 0;
		while (iter.hasNext() && count <= index) {
			res = (Team) iter.next();
			count++;
		}

		return res;
	}

	public void display(Team element) {
		textField1.setText(element.readName());
		textField2.setText(element.readStadium());
		textField3.setText("" + element.readCapacity());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmA = new JFrame();
		frmA.setTitle("A00211953 Software Design");	
		frmA.setBackground(new Color(0, 0, 0));
		frmA.getContentPane().setBackground(new Color(255, 250, 205));
		frmA.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmA.setBounds(100, 100, 340, 505);
		frmA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmA.getContentPane().setLayout(null);

		JLabel lblCountries = new JLabel("Club Profiles");
		lblCountries.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountries.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblCountries.setBounds(30, 11, 280, 52);
		frmA.getContentPane().add(lblCountries);

		JLabel l1 = new JLabel("      Name :");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		l1.setBounds(30, 140, 125, 40);
		frmA.getContentPane().add(l1);

		JLabel l2 = new JLabel("   Stadium :");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		l2.setBounds(30, 180, 125, 40);
		frmA.getContentPane().add(l2);

		JLabel lblNewLabel = new JLabel("   Capacity :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 220, 125, 40);
		frmA.getContentPane().add(lblNewLabel);

		textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField2.setBounds(170, 190, 140, 25);
		frmA.getContentPane().add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField3.setBounds(170, 230, 140, 25);
		frmA.getContentPane().add(textField3);
		textField3.setColumns(10);

		JButton btnUpdateStadium = new JButton("Update Stadium");
		btnUpdateStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Team name = search(textField1.getText());
				String newName = (textField4.getText());
				if (newName != null && !newName.isEmpty()) {
					name.updateStadium(newName);
					textField2.setText("" + newName);
					textField4.setText("");
					JOptionPane.showMessageDialog(null, textField1.getText() + "'s stadium name has beeen updated");
				} else {
					JOptionPane.showMessageDialog(null,"Invalid stadium name entered");
				}
			}
		});
		btnUpdateStadium.setBounds(20, 310, 140, 25);
		frmA.getContentPane().add(btnUpdateStadium);

		textField4 = new JTextField();
		textField4.setBounds(170, 310, 140, 25);
		frmA.getContentPane().add(textField4);
		textField4.setColumns(10);

		JButton b2_Next = new JButton("Next");
		b2_Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (current < set.size() - 1)
					current++;
				display(navigate(current));
			}
		});
		b2_Next.setBounds(20, 70, 140, 25);
		frmA.getContentPane().add(b2_Next);

		JButton b3_Prev = new JButton("Previous");
		b3_Prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (current > 0)
					current--;
				display(navigate(current));
			}
		});
		b3_Prev.setBounds(170, 70, 140, 25);
		frmA.getContentPane().add(b3_Prev);

		JButton b4_First = new JButton("First");
		b4_First.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = 0;
				display(navigate(current));
			}
		});
		b4_First.setBounds(20, 110, 140, 25);
		frmA.getContentPane().add(b4_First);

		JButton b5_Last = new JButton("Last");
		b5_Last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = set.size() - 1;
				display(navigate(current));
			}
		});
		b5_Last.setBounds(170, 110, 140, 25);
		frmA.getContentPane().add(b5_Last);

		JButton b6_Search = new JButton("Find Team");
		b6_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team team = search(textField5.getText());
				if (team == null) {
					JOptionPane.showMessageDialog(null, "Search found no results");
				} else {
					display(team);
					textField5.setText("");
				}
			}
		});
		b6_Search.setBounds(20, 390, 140, 25);
		frmA.getContentPane().add(b6_Search);

		textField5 = new JTextField();
		textField5.setBounds(170, 390, 140, 25);
		frmA.getContentPane().add(textField5);
		textField5.setColumns(10);

		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField1.setBounds(170, 150, 140, 25);
		frmA.getContentPane().add(textField1);
		textField1.setColumns(10);

		JButton b7_Clear = new JButton("Clear");
		b7_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
			}
		});
		b7_Clear.setBounds(20, 270, 140, 25);
		frmA.getContentPane().add(b7_Clear);

		JButton b8_Insert = new JButton("Insert");
		b8_Insert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String newName = (textField1.getText());
				String newStad = (textField2.getText());
				String newCap = (textField3.getText());
				Team team = search(textField1.getText());
				if (team != null) {
					JOptionPane.showMessageDialog(null, "Team information already exists");
				} else if ((newName != null && !newName.isEmpty())
						&& (newStad != null && !newStad.isEmpty())
						&& (newCap != null && !newCap.isEmpty())) {
					Team element = new Team(textField1.getText(), textField2.getText(), textField3.getText());
					set.add(element);
					current = set.size() - 1;
					JOptionPane.showMessageDialog(null,
							"The team information of " + textField1.getText() + " has been added to the list");
				} else {
					JOptionPane.showMessageDialog(null,
							"Invalid textfields entered");
				}
			}
		});
		b8_Insert.setBounds(170, 270, 140, 25);
		frmA.getContentPane().add(b8_Insert);

		JButton btnUpdateCapacity = new JButton("Update Capacity");
		btnUpdateCapacity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Team name = search(textField1.getText());
				String newCapacity = (textField.getText());
				if (newCapacity != null && !newCapacity.isEmpty()) {
					name.updateCapacity(newCapacity);
					textField3.setText("" + newCapacity);
					textField.setText("");
					JOptionPane.showMessageDialog(null, textField1.getText() + "'s stadium capacity has been updated");
				} else {
					JOptionPane.showMessageDialog(null, "Invalid capacity entered");
				}
			}
		});
		btnUpdateCapacity.setBounds(20, 350, 140, 25);
		frmA.getContentPane().add(btnUpdateCapacity);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(170, 350, 140, 25);
		frmA.getContentPane().add(textField);

		JButton btnPlayerProfiles = new JButton("Display List of Clubs");
		btnPlayerProfiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					System.out.println(set);
			}
		});
		btnPlayerProfiles.setBounds(20, 430, 290, 25);
		frmA.getContentPane().add(btnPlayerProfiles);
	}
}