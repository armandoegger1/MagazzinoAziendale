package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class SchermataComponenti extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;
	private JTextField textFieldNomeComponente;
	private JTextField textFieldDescrizione;
	private JButton btnAnnulla;

	/**
	 * Create the frame.
	 */
	public SchermataComponenti(Main controller) {
		setResizable(false);
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[141px,center][141px][141px]", "[27px][27px][27px][27px][27px][27px][27px][27px][27px]"));
		
		JLabel label = new JLabel("");
		contentPane.add(label, "cell 0 0,grow");
		
		JLabel lblComponente = new JLabel("Creazione Componente");
		lblComponente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblComponente, "cell 1 0,grow");
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1, "cell 2 0,grow");
		
		JLabel lblNomeComponente = new JLabel("Nome Componente");
		lblNomeComponente.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNomeComponente, "cell 0 1,alignx center,growy");
		
		JLabel label_2 = new JLabel("");
		contentPane.add(label_2, "cell 1 1,grow");
		
		textFieldNomeComponente = new JTextField();
		contentPane.add(textFieldNomeComponente, "cell 2 1,grow");
		textFieldNomeComponente.setColumns(10);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblDescrizione, "cell 0 2,alignx center,growy");
		
		JLabel label_3 = new JLabel("");
		contentPane.add(label_3, "cell 1 2,grow");
		
		textFieldDescrizione = new JTextField();
		contentPane.add(textFieldDescrizione, "cell 2 2,grow");
		textFieldDescrizione.setColumns(10);
		
		JLabel lblQuantita = new JLabel("Quantit\u00E0");
		lblQuantita.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblQuantita, "cell 0 3,alignx center,growy");
		
		JLabel label_4 = new JLabel("");
		contentPane.add(label_4, "cell 1 3,grow");
		
		JFormattedTextField formattedTextFieldQuantita = new JFormattedTextField();
		contentPane.add(formattedTextFieldQuantita, "cell 2 3,grow");
		
		JLabel lblCaratteristica = new JLabel("Caratteristica");
		lblCaratteristica.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblCaratteristica, "cell 0 4,alignx center,growy");
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.Ritorno(frameCorrente);
			}
		});
		
		JLabel label_5 = new JLabel("");
		contentPane.add(label_5, "cell 1 4,grow");
		
		JList listCaratteristiche = new JList();
		contentPane.add(listCaratteristiche, "cell 2 4,grow");
		
		JLabel lblFornitore = new JLabel("Fornitore");
		lblFornitore.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblFornitore, "cell 0 5,alignx center,growy");
		
		JLabel label_6 = new JLabel("");
		contentPane.add(label_6, "cell 1 5,grow");
		
		JList listFornitore = new JList();
		contentPane.add(listFornitore, "cell 2 5,grow");
		
		JLabel lblScatola = new JLabel("Scatola");
		lblScatola.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblScatola, "cell 0 6,alignx center,growy");
		
		JLabel label_7 = new JLabel("");
		contentPane.add(label_7, "cell 1 6,grow");
		
		JList listScatola = new JList();
		listScatola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(listScatola, "cell 2 6,grow");
		
		JLabel label_8 = new JLabel("");
		contentPane.add(label_8, "cell 0 7,grow");
		
		JLabel label_9 = new JLabel("");
		contentPane.add(label_9, "cell 1 7,grow");
		
		JLabel label_10 = new JLabel("");
		contentPane.add(label_10, "cell 2 7,grow");
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnAnnulla, "cell 0 8,grow");
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNomeComponente.getText().length() > 0 && textFieldDescrizione.getText().length() > 0 && formattedTextFieldQuantita.getText().length() > 0) {
					
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Presente almeno un campo necessario (Nome, Descrizione, Quantita) vuoto!", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		
		JLabel label_11 = new JLabel("");
		contentPane.add(label_11, "cell 1 8,grow");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnConferma, "cell 2 8,grow");
	}

}
