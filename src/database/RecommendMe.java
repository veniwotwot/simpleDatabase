package database;

import javax.swing.JFrame;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;


public class RecommendMe extends JFrame implements ActionListener {
	
	private static final Color BACKGROUND_GUI_COLOR = new Color(128, 128, 128);
	private static final Color BUTTON_COLOR = new Color(90, 90, 90);
	
	//Main Menu
	private static JLabel title;
	private static JButton accessStaffLogin;
	private static JButton searchBooksGUI;
	private static JButton searchSongsGUI;
	private static JButton searchMoviesGUI;
	
	//Staff Login
	private static JTextField username;
	private static JTextField password;
	private static JButton loginButton;
	
	//Book Search Option Menu
	private static JLabel bookSearchHeader;
	private static JButton bookTitleSearchOption;
	private static JButton bookAuthorSearchOption;
	private static JButton bookTagSearchOption;
	
	//Song Search Option Menu
	private static JLabel songSearchHeader;
	private static JButton songTitleSearchOption;
	private static JButton songArtistSearchOption;
	private static JButton songTagSearchOption;
	
	//Movie Search Option Menu
	private static JLabel movieSearchHeader;
	private static JButton movieTitleSearchOption;
	private static JButton movieDirectorSearchOption;
	private static JButton movieDescriptionSearchOption;
	private static JButton movieTagSearchOption;
	
	private static JButton getBooks;
	private static JButton getSongs;
	private static JButton getMovies;
	
	
	
	@SuppressWarnings("unchecked")
	public RecommendMe () {
		super("RecommendMe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//Main Menu GUI
		title = new JLabel("RecommendMe");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		title.setForeground(new Color(150, 150, 245));
		
		searchMoviesGUI = new JButton("Search Movies");
		searchMoviesGUI.setActionCommand("movieGUI");
		searchMoviesGUI.addActionListener(this);
		searchMoviesGUI.setBackground(BUTTON_COLOR);
		searchMoviesGUI.setOpaque(true);
		searchMoviesGUI.setForeground(Color.WHITE);
		
		searchSongsGUI = new JButton("Search Songs");
		searchSongsGUI.setActionCommand("songGUI");
		searchSongsGUI.addActionListener(this);
		searchSongsGUI.setBackground(BUTTON_COLOR);
		searchSongsGUI.setOpaque(true);
		searchSongsGUI.setForeground(Color.WHITE);
		
		searchBooksGUI = new JButton("Search Books");
		searchBooksGUI.setActionCommand("bookGUI");
		searchBooksGUI.addActionListener(this);
		searchBooksGUI.setBackground(BUTTON_COLOR);
		searchBooksGUI.setOpaque(true);
		searchBooksGUI.setForeground(Color.WHITE);
		
		accessStaffLogin = new JButton("Staff Login");
		accessStaffLogin.setActionCommand("staffLogin");
		accessStaffLogin.addActionListener(this);
		accessStaffLogin.setBackground(BUTTON_COLOR);
		accessStaffLogin.setOpaque(true);
		accessStaffLogin.setForeground(Color.WHITE);
		
		//Staff Login GUI
		username = new JTextField("Username", 25);
		password = new JTextField("Password", 25);
		username.setBackground(BUTTON_COLOR);
		password.setBackground(BUTTON_COLOR);
		username.setForeground(Color.WHITE);
		password.setForeground(Color.WHITE);
		
		loginButton = new JButton("Login");
		loginButton.setActionCommand("checkLogin");
		loginButton.addActionListener(this);
		loginButton.setBackground(BUTTON_COLOR);
		loginButton.setOpaque(true);
		loginButton.setForeground(Color.WHITE);
		
		//Book Search Option Menu
		bookSearchHeader = new JLabel("Search for Books");
		bookSearchHeader.setFont(new Font("Arial", Font.BOLD, 30));
		bookSearchHeader.setForeground(new Color(150, 150, 245));
		
		bookTitleSearchOption = new JButton("Search by Title");
		bookTitleSearchOption.setActionCommand("bookTitleSearchOption");
		bookTitleSearchOption.addActionListener(this);
		bookTitleSearchOption.setBackground(BUTTON_COLOR);
		bookTitleSearchOption.setOpaque(true);
		bookTitleSearchOption.setForeground(Color.WHITE);
		
		bookAuthorSearchOption = new JButton("Search by Author");
		bookAuthorSearchOption.setActionCommand("bookAuthorSearchOption");
		bookAuthorSearchOption.addActionListener(this);
		bookAuthorSearchOption.setBackground(BUTTON_COLOR);
		bookAuthorSearchOption.setOpaque(true);
		bookAuthorSearchOption.setForeground(Color.WHITE);
		
		bookTagSearchOption = new JButton("Search by Tags");
		bookTagSearchOption.setActionCommand("bookTagSearchOption");
		bookTagSearchOption.addActionListener(this);
		bookTagSearchOption.setBackground(BUTTON_COLOR);
		bookTagSearchOption.setOpaque(true);
		bookTagSearchOption.setForeground(Color.WHITE);
		
		//Song Search Option Menu
		songSearchHeader = new JLabel("Search for Songs");
		songSearchHeader.setFont(new Font("Arial", Font.BOLD, 30));
		songSearchHeader.setForeground(new Color(150, 150, 245));
		
		songTitleSearchOption = new JButton("Search by Title");
		songTitleSearchOption.setActionCommand("songTitleSearchOption");
		songTitleSearchOption.addActionListener(this);
		songTitleSearchOption.setBackground(BUTTON_COLOR);
		songTitleSearchOption.setOpaque(true);
		songTitleSearchOption.setForeground(Color.WHITE);
		
		songArtistSearchOption = new JButton("Search by Artist");
		songArtistSearchOption.setActionCommand("songArtistSearchOption");
		songArtistSearchOption.addActionListener(this);
		songArtistSearchOption.setBackground(BUTTON_COLOR);
		songArtistSearchOption.setOpaque(true);
		songArtistSearchOption.setForeground(Color.WHITE);
		
		songTagSearchOption = new JButton("Search by Tags");
		songTagSearchOption.setActionCommand("songTagSearchOption");
		songTagSearchOption.addActionListener(this);
		songTagSearchOption.setBackground(BUTTON_COLOR);
		songTagSearchOption.setOpaque(true);
		songTagSearchOption.setForeground(Color.WHITE);
		
		//Movie Search Option Menu
		movieSearchHeader = new JLabel("Search for Movies");
		movieSearchHeader.setFont(new Font("Arial", Font.BOLD, 30));
		movieSearchHeader.setForeground(new Color(150, 150, 245));
		
		movieTitleSearchOption = new JButton("Search by Title");
		movieTitleSearchOption.setActionCommand("movieTitleSearchOption");
		movieTitleSearchOption.addActionListener(this);
		movieTitleSearchOption.setBackground(BUTTON_COLOR);
		movieTitleSearchOption.setOpaque(true);
		movieTitleSearchOption.setForeground(Color.WHITE);
		
		movieDirectorSearchOption = new JButton("Search by Director");
		movieDirectorSearchOption.setActionCommand("movieDirectorSearchOption");
		movieDirectorSearchOption.addActionListener(this);
		movieDirectorSearchOption.setBackground(BUTTON_COLOR);
		movieDirectorSearchOption.setOpaque(true);
		movieDirectorSearchOption.setForeground(Color.WHITE);
		
		movieDescriptionSearchOption = new JButton("Search by Description");
		movieDescriptionSearchOption.setActionCommand("movieDescriptionSearchOption");
		movieDescriptionSearchOption.addActionListener(this);
		movieDescriptionSearchOption.setBackground(BUTTON_COLOR);
		movieDescriptionSearchOption.setOpaque(true);
		movieDescriptionSearchOption.setForeground(Color.WHITE);
		
		movieTagSearchOption = new JButton("Search by Tags");
		movieTagSearchOption.setActionCommand("movieTagSearchOption");
		movieTagSearchOption.addActionListener(this);
		movieTagSearchOption.setBackground(BUTTON_COLOR);
		movieTagSearchOption.setOpaque(true);
		movieTagSearchOption.setForeground(Color.WHITE);
		
	}
	
	public static void main(String[] args) {
		RecommendMe go = new RecommendMe();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createMainGUI(go); 
            }
        });
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("movieGUI".equals(e.getActionCommand())) {
	 		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createMovieGUI(); 
	            }
        	});
        } else if ("songGUI".equals(e.getActionCommand())) {
	 		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createSongGUI(); 
	            }
        	});
        }
        else if ("bookGUI".equals(e.getActionCommand())) {
	 		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createBookGUI(); 
	            }
        	});
        } else if ("staffLogin".equals(e.getActionCommand())) {
	 		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createStaffLoginGUI(); 
	            }
        	});
        }
	}
	
	protected void createStaffLoginGUI() {
		JFrame frame = new JFrame("Staff Login");
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.getContentPane().setBackground(BACKGROUND_GUI_COLOR);
		
		c.insets = new Insets(25,30,15,30);
		c.gridx = 0;
		c.gridy = 0;
		frame.add(username, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 1;
		frame.add(password, c);
		
		c.insets = new Insets(15,30,25,30);
		c.gridx = 0;
		c.gridy = 2;
		frame.add(loginButton, c);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	protected void createMovieGUI() {
		JFrame frame = new JFrame("Movie Search");
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.getContentPane().setBackground(BACKGROUND_GUI_COLOR);
		
		c.insets = new Insets(30,30,15,30);
		c.gridx = 0;
		c.gridy = 0;
		frame.add(movieSearchHeader, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 1;
		frame.add(movieTitleSearchOption, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 2;
		frame.add(movieDirectorSearchOption, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 3;
		frame.add(movieDescriptionSearchOption, c);
		
		c.insets = new Insets(15,30,30,30);
		c.gridx = 0;
		c.gridy = 4;
		frame.add(movieTagSearchOption, c);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	protected void createSongGUI() {
		JFrame frame = new JFrame("Song Search");
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.getContentPane().setBackground(BACKGROUND_GUI_COLOR);
		
		c.insets = new Insets(30,30,15,30);
		c.gridx = 0;
		c.gridy = 0;
		frame.add(songSearchHeader, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 1;
		frame.add(songTitleSearchOption, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 2;
		frame.add(songArtistSearchOption, c);
		
		c.insets = new Insets(15,30,30,30);
		c.gridx = 0;
		c.gridy = 3;
		frame.add(songTagSearchOption, c);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	protected void createBookGUI() {
		JFrame frame = new JFrame("Book Search");
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.getContentPane().setBackground(BACKGROUND_GUI_COLOR);
		
		c.insets = new Insets(30,30,15,30);
		c.gridx = 0;
		c.gridy = 0;
		frame.add(bookSearchHeader, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 1;
		frame.add(bookTitleSearchOption, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 2;
		frame.add(bookAuthorSearchOption, c);
		
		c.insets = new Insets(15,30,30,30);
		c.gridx = 0;
		c.gridy = 3;
		frame.add(bookTagSearchOption, c);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void createMainGUI(JFrame frame) {
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(BACKGROUND_GUI_COLOR);
		
		c.insets = new Insets(30,30,15,30);
		c.gridx = 0;
		c.gridy = 0;
		frame.add(title, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 1;
		frame.add(searchMoviesGUI, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 2;
		frame.add(searchSongsGUI, c);
		
		c.insets = new Insets(15,30,15,30);
		c.gridx = 0;
		c.gridy = 3;
		frame.add(searchBooksGUI, c);
		
		c.insets = new Insets(15,30,30,30);
		c.gridx = 0;
		c.gridy = 4;
		frame.add(accessStaffLogin, c);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}
	
}