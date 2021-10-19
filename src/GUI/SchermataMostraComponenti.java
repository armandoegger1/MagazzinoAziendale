package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Componenti;
import Classi.ComponentiDaoImpl;
import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SchermataMostraComponenti extends JFrame {

	private JPanel contentPane;
	Main controller;
	JFrame frameCorrente;
	

	/**
	 * Create the frame.
	 */
	public SchermataMostraComponenti(Main controller) {
		setResizable(false);
		setTitle("Mostra Componenti");
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[197.00,center][][][grow,center]", "[][][][][][][][][center]"));
		
		JLabel lblMostra1 = new JLabel("Mostra tutti i Componenti");
		lblMostra1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblMostra1, "cell 0 1");
		
		JButton btnMostraTuttiComponenti = new JButton("Mostra Tutto");
		btnMostraTuttiComponenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//VARIABILI
					ComponentiDaoImpl cDAO = new ComponentiDaoImpl();
					List<Componenti> componentiTotali = new ArrayList<Componenti>();
					
					componentiTotali =  cDAO.getTuttiComponenti();			
					
					
					String col[] = {"IDComponente","Codice Componente","Codice Costruttore", "Descrizione", "Quantita", "Tipologia", "Caratteristica", "Fornitore", "Scatolo"};
					DefaultTableModel tableModel = new DefaultTableModel(col, componentiTotali.size());
					
					JTable table = new JTable(tableModel);
					
					tableModel.setRowCount(0); //Normalmente il numero di righe di default è 4, quindi le imposto a 0
					
					for(Componenti c: componentiTotali) {
						
						Object[] objs = {c.getIDComponente(), c.getNomeComponente(), c.getCodiceCostruttore(), c.getDescrizione(), c.getQuantita(), c.getTipologiaComponente(), c.getCaratteristicheComponente(), c.getFornitoreComponente(), c.getScatoloComponente()};
						tableModel.addRow(objs);
					}
					
					//Crea un nuovo Panel
					JPanel panel = new JPanel();
			        panel.setLayout(new BorderLayout());
					
			        //Permetti lo scroll della tabella
					JScrollPane tableContainer = new JScrollPane(table);
					
					//Aggiungi la tabella al container
					panel.add(tableContainer, BorderLayout.CENTER);
					
					//Creazione del JFrame contenente il nuovo pannello con la tabella
					JFrame frameMostraComponenti = new JFrame();
					frameMostraComponenti.getContentPane().add(panel);
					frameMostraComponenti.pack();
					frameMostraComponenti.setVisible(true);
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnMostraTuttiComponenti, "cell 3 1");
		
		JLabel lblMostraSpecificoComponente = new JLabel("Mostra Specifico Componente");
		lblMostraSpecificoComponente.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblMostraSpecificoComponente, "cell 0 4");
		
		JLabel lblMostraSpecificoComponente2 = new JLabel("Inserisci ID Componente");
		contentPane.add(lblMostraSpecificoComponente2, "cell 0 5");
		
		JFormattedTextField formattedTextFieldIDComponente = new JFormattedTextField();
		contentPane.add(formattedTextFieldIDComponente, "cell 3 5,growx");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		
				
				JButton btnMostraSpecifico = new JButton("Mostra Specifico");
				btnMostraSpecifico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});
				contentPane.add(btnMostraSpecifico, "cell 3 7");
		contentPane.add(btnAnnulla, "cell 0 8");
	}

}
