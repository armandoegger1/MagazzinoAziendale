package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.FornitoreDaoImpl;
import Classi.Fornitori;
import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SchermataCreazioneFornitore extends JFrame {

	private JPanel contentPane;
	private JFrame frameCorrente;
	private Main controller;
	private JTextField textFieldNomeFornitore;
	private JTextField textFieldLocalita;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;

	/**
	 * Create the frame.
	 */
	public SchermataCreazioneFornitore(Main controller) {
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[147.00,center][132.00,center][119.00,grow,center]", "[][][][][][][][][]"));
		
		JLabel lblFornitore = new JLabel("Creazione Fornitore");
		lblFornitore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblFornitore, "cell 1 0");
		
		JLabel lblNome = new JLabel("Nome Fornitore");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNome, "cell 0 2,alignx center");
		
		textFieldNomeFornitore = new JTextField();
		contentPane.add(textFieldNomeFornitore, "cell 2 2,growx");
		textFieldNomeFornitore.setColumns(10);
		
		JLabel lblLocalita = new JLabel("Localita'");
		lblLocalita.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblLocalita, "cell 0 3,alignx center");
		
		textFieldLocalita = new JTextField();
		textFieldLocalita.setColumns(10);
		contentPane.add(textFieldLocalita, "cell 2 3,growx");
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblTelefono, "cell 0 4,alignx center");
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		contentPane.add(textFieldTelefono, "cell 2 4,growx");
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblEmail, "cell 0 5,alignx center");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		contentPane.add(textFieldEmail, "cell 2 5,growx");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnAnnulla, "cell 0 8");
		
		JButton btnNewButton_1 = new JButton("Conferma");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldNomeFornitore.getText().length() > 0) {
					
					String nomeFornitore, localita, telefono, email;
					nomeFornitore = textFieldNomeFornitore.getText();
					localita = textFieldLocalita.getText();
					telefono = textFieldTelefono.getText();
					email = textFieldEmail.getText();
					
					Fornitori fornitore = new Fornitori(nomeFornitore, localita, telefono, email);
					
					try {
						FornitoreDaoImpl fDAO = new FornitoreDaoImpl();
						
						fDAO.saveFornitore(fornitore);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserisci il nome del fornitore", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton_1, "cell 2 8");
	}

}
