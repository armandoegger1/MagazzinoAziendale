package GUI;
import Driver.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.CaratteristicheDaoImpl;
import Classi.FornitoreDaoImpl;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class SchermataHome extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JButton btnMostraComponenti;
	private JFrame frameCorrente;

	/**
	 * Create the frame.
	 */
	public SchermataHome(Main controller) {
		this.controller = controller;
		frameCorrente = this;
		setTitle("Pagina di Benvenuto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 418);
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
		Creazione.setLayout(new MigLayout("", "[113px,center][121.00px,center][103px,center][center]", "[][23px][23px][23px][][][][][][][][][][]"));
		
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
		
		JButton btnMostraFornitori = new JButton("Mostra Fornitori");
		btnMostraFornitori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.MostraFornitori();
			}
		});
		
		JButton btnMostraTipologie = new JButton("Mostra Tipologie");
		btnMostraTipologie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.MostraTipologie();
			}
		});
		Creazione.add(btnMostraTipologie, "cell 3 6");
		Creazione.add(btnMostraFornitori, "cell 0 7");
		
		JButton btnMostraCaratteristiche = new JButton("Mostra Caratteristiche");
		btnMostraCaratteristiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.MostraCaratteristiche();
			}
		});
		Creazione.add(btnMostraCaratteristiche, "cell 1 7");
		
		JLabel lblBenvenuto3 = new JLabel("Pulsanti di Eliminazioni");
		lblBenvenuto3.setFont(new Font("Tahoma", Font.BOLD, 14));
		Creazione.add(lblBenvenuto3, "cell 0 8");
		Creazione.add(btnEliminaComponente, "cell 1 9");
		
		JButton btnEliminaFornitore = new JButton("Elimina Fornitore");
		btnEliminaFornitore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.EliminaFornitore();
			}
		});
		
		JButton btnEliminaTipologia = new JButton("Elimina Tipologia");
		btnEliminaTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.EliminaTipologia();
			}
		});
		Creazione.add(btnEliminaTipologia, "cell 3 9");
		Creazione.add(btnEliminaFornitore, "cell 0 10");
		
		JButton btnEliminaCaratteristica = new JButton("Elimina Caratteristica");
		btnEliminaCaratteristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.EliminaCaratteristica();
			}
		});
		Creazione.add(btnEliminaCaratteristica, "cell 1 10");
		
		JLabel lblRecuperi = new JLabel("Pulsanti di Recupero");
		Creazione.add(lblRecuperi, "cell 0 11");
		lblRecuperi.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnRecuperoQuantitaComponenti = new JButton("Recupero Quantita Componenti");
		Creazione.add(btnRecuperoQuantitaComponenti, "cell 1 12");
		
		JButton btnRecuperoQuantitaFornitori = new JButton("Recupero Quantita Fornitori");
		Creazione.add(btnRecuperoQuantitaFornitori, "cell 0 13");
		
		JButton btnRecuperoQuantitaCaratteristiche = new JButton("Recupero Quantita Caratteristiche");
		Creazione.add(btnRecuperoQuantitaCaratteristiche, "cell 1 13");
		btnRecuperoQuantitaCaratteristiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int caratteristicheEsistenti;
				
				try {
					CaratteristicheDaoImpl cDAO = new CaratteristicheDaoImpl();
					caratteristicheEsistenti = cDAO.getQuantitaTotaleCaratteristiche();
					JOptionPane.showMessageDialog(frameCorrente, "Sono presenti in totale "+caratteristicheEsistenti+" caratteristiche.","Caratteristiche Totali!", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRecuperoQuantitaFornitori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int fornitoriEsistenti;
				try {
					FornitoreDaoImpl fDAO = new FornitoreDaoImpl();
					fornitoriEsistenti = fDAO.getQuantitaTotaleFornitori();
					JOptionPane.showMessageDialog(frameCorrente, "Sono presenti in totale "+fornitoriEsistenti+" fornitori.","Fornitori Totali!", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnRecuperoQuantitaComponenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RecuperoComponentiQuantita();
			}
		});
	}

}
