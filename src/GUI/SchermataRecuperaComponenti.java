package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.ComponentiDaoImpl;
import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SchermataRecuperaComponenti extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;
	private JTextField textFieldCodiceCostruttore;

	/**
	 * Create the frame.
	 */
	public SchermataRecuperaComponenti(Main controller) {
		setResizable(false);
		setTitle("Recupero Componenti");
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][center][][][][grow,center]", "[][][][][][][][][]"));
		
		JLabel lblOttieniTutto = new JLabel("Ottieni la Quantita' Totale");
		lblOttieniTutto.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblOttieniTutto, "cell 1 1");
		
		JButton btnOttieniQuantitaTotale = new JButton("Ottieni Quantita Totale");
		btnOttieniQuantitaTotale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int quantitaTotale;
					ComponentiDaoImpl cDAO = new ComponentiDaoImpl();
					
					quantitaTotale = cDAO.getQuantitaTotale();
					
					if(quantitaTotale >= 0) {
						JOptionPane.showMessageDialog(frameCorrente, "In magazzino sono presenti in totale "+quantitaTotale+" componenti.","Quantita Totale dal Magazzino!", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnOttieniQuantitaTotale, "cell 5 1");
		
		JLabel lblNewLabel = new JLabel("Ottieni Quantita Specifica");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel, "cell 1 3");
		
		JLabel lblCodiceCostruttore = new JLabel("Inserisci Codice Costruttore");
		contentPane.add(lblCodiceCostruttore, "cell 1 5");
		
		JButton btnOttieniQuantitaSpecifica = new JButton("Ottieni Quantita Specifica");
		btnOttieniQuantitaSpecifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldCodiceCostruttore.getText().trim().length() > 0) {
					String codiceCostruttore = textFieldCodiceCostruttore.getText().trim();	
					int quantitaSpecifica;
					try {
						ComponentiDaoImpl cDAO = new ComponentiDaoImpl();
						
						quantitaSpecifica = cDAO.getQuantitaSpecifica(codiceCostruttore);
						
						JOptionPane.showMessageDialog(frameCorrente, "In magazzino sono presenti in totale "+quantitaSpecifica+" componenti per il codice Costruttore: "+codiceCostruttore+".","Quantita Totale dato un Codice Costruttore!", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserisci un Codice Costruttore","Inserimento Errato!", JOptionPane.OK_OPTION);
				}
			}
		});
		
		textFieldCodiceCostruttore = new JTextField();
		contentPane.add(textFieldCodiceCostruttore, "cell 5 5,growx");
		textFieldCodiceCostruttore.setColumns(10);
		contentPane.add(btnOttieniQuantitaSpecifica, "cell 5 6");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		contentPane.add(btnAnnulla, "cell 1 8");
	}

}
