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
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class SchermataHome extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JButton btnMostraComponenti;

	/**
	 * Create the frame.
	 */
	public SchermataHome(Main controller) {
		this.controller = controller;
		
		setTitle("Pagina di Benvenuto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Creazione = new JPanel();
		contentPane.add(Creazione, BorderLayout.CENTER);
		
		JButton btnNuovoApparato = new JButton("Nuovo Apparato");
		btnNuovoApparato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.CreaApparato();
			}
		});
		Creazione.setLayout(new MigLayout("", "[113px,center][131px,center][103px,center][center]", "[][23px][23px][23px][][][][][][]"));
		
		JLabel lblBnvenuto = new JLabel("Pulsanti di Creazione");
		lblBnvenuto.setFont(new Font("Tahoma", Font.BOLD, 14));
		Creazione.add(lblBnvenuto, "cell 0 0");
		lblBnvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		Creazione.add(btnNuovoApparato, "cell 0 1,alignx center,aligny top");
		
		JButton btnNuovoComponente = new JButton("Nuovo Componente");
		btnNuovoComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.CreaComponente();
			}
		});
		Creazione.add(btnNuovoComponente, "cell 1 1,alignx center,aligny top");
		
		JButton btnNuovaScheda = new JButton("Nuova Scheda");
		btnNuovaScheda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaScheda();
			}
		});
		Creazione.add(btnNuovaScheda, "cell 2 1,alignx center,aligny top");
		
		JButton btnNuovoFornitore = new JButton("Nuovo Fornitore");
		btnNuovoFornitore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.CreaFornitore();
			}
		});
		
		JButton btnNuovaTipologia = new JButton("Nuova Tipologia");
		btnNuovaTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaTipologia();
			}
		});
		Creazione.add(btnNuovaTipologia, "cell 3 1,alignx center,aligny top");
		Creazione.add(btnNuovoFornitore, "cell 0 2,alignx center,aligny top");
		
		JButton btnNuovaCaratteristica = new JButton("Nuova Caratteristica");
		btnNuovaCaratteristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaCaratteristica();
			}
		});
		Creazione.add(btnNuovaCaratteristica, "cell 1 2,alignx center,aligny top");
		
		JButton btnNuovaScatola = new JButton("Nuova Scatola");
		btnNuovaScatola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaScatola();
			}
		});
		Creazione.add(btnNuovaScatola, "cell 2 2,alignx center,aligny top");
		
		JLabel lblPulsantiMostra = new JLabel("Pulsanti Mostra");
		lblPulsantiMostra.setFont(new Font("Tahoma", Font.BOLD, 14));
		Creazione.add(lblPulsantiMostra, "cell 0 5");
		
		btnMostraComponenti = new JButton("Mostra Componenti");
		btnMostraComponenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.MostraComponenti();
			}
		});
		Creazione.add(btnMostraComponenti, "cell 1 6");
		
		JButton btnEliminaComponente = new JButton("Elimina Componente");
		btnEliminaComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.EliminaComponente();
			}
		});
		
		JLabel lblBenvenuto3 = new JLabel("Pulsanti Eliminazioni");
		lblBenvenuto3.setFont(new Font("Tahoma", Font.BOLD, 14));
		Creazione.add(lblBenvenuto3, "cell 0 8");
		Creazione.add(btnEliminaComponente, "cell 1 9");
		
		JPanel Recuperi = new JPanel();
		contentPane.add(Recuperi, BorderLayout.SOUTH);
		Recuperi.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnOttieniComponentiTotali = new JButton("Ottieni Componenti Totali");
		Recuperi.add(btnOttieniComponentiTotali);
		
		JButton btnOttieniScatole = new JButton("Ottieni Scatole Presenti");
		Recuperi.add(btnOttieniScatole);
	}

}
