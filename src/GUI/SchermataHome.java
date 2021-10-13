package GUI;
import Driver.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchermataHome extends JFrame {

	private JPanel contentPane;
	private Main controller;

	/**
	 * Create the frame.
	 */
	public SchermataHome(Main controller) {
		this.controller = controller;
		
		setTitle("Pagina di Benvenuto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Creazione = new JPanel();
		contentPane.add(Creazione, BorderLayout.CENTER);
		Creazione.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNuovoApparato = new JButton("Nuovo Apparato");
		btnNuovoApparato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.CreaApparato();
			}
		});
		Creazione.add(btnNuovoApparato);
		
		JButton btnNuovoComponente = new JButton("Nuovo Componente");
		btnNuovoComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.CreaComponente();
			}
		});
		Creazione.add(btnNuovoComponente);
		
		JButton btnNuovaScheda = new JButton("Nuova Scheda");
		btnNuovaScheda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaScheda();
			}
		});
		Creazione.add(btnNuovaScheda);
		
		JButton btnNuovoFornitore = new JButton("Nuovo Fornitore");
		btnNuovoFornitore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.CreaFornitore();
			}
		});
		Creazione.add(btnNuovoFornitore);
		
		JButton btnNuovaCaratteristica = new JButton("Nuova Caratteristica");
		btnNuovaCaratteristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaCaratteristica();
			}
		});
		Creazione.add(btnNuovaCaratteristica);
		
		JButton btnNuovaScatola = new JButton("Nuova Scatola");
		btnNuovaScatola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaScatola();
			}
		});
		Creazione.add(btnNuovaScatola);
		
		JButton btnNuovaTipologia = new JButton("Nuova Tipologia");
		btnNuovaTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaTipologia();
			}
		});
		Creazione.add(btnNuovaTipologia);
		
		JLabel lblBnvenuto = new JLabel("Pagina Home");
		lblBnvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBnvenuto, BorderLayout.NORTH);
		
		JPanel Recuperi = new JPanel();
		contentPane.add(Recuperi, BorderLayout.SOUTH);
		Recuperi.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnOttieniComponentiTotali = new JButton("Ottieni Componenti Totali");
		Recuperi.add(btnOttieniComponentiTotali);
		
		JButton btnOttieniScatole = new JButton("Ottieni Scatole Presenti");
		Recuperi.add(btnOttieniScatole);
	}

}
