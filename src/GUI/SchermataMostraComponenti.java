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
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SchermataMostraComponenti extends JFrame {

	private JPanel contentPane;
	Main controller;
	JFrame frameCorrente;
	private JTextField textFieldCodiceCostruttore;
	

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
		contentPane.setLayout(new MigLayout("", "[197.00,center][][][grow,center]", "[][][][][][][][][][center]"));
		
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
					JFrame frameMostraComponenti = new JFrame("Lista Componenti");
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
		contentPane.add(lblMostraSpecificoComponente, "cell 0 2");
		
		JLabel lblMostraSpecificoComponente2 = new JLabel("Inserisci ID Componente");
		contentPane.add(lblMostraSpecificoComponente2, "cell 0 3");
		
		JFormattedTextField formattedTextFieldIDComponente = new JFormattedTextField();
		contentPane.add(formattedTextFieldIDComponente, "cell 3 3,growx");		
		
				
		JButton btnMostraSpecifico = new JButton("Mostra Specifico");
		
		btnMostraSpecifico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(formattedTextFieldIDComponente.getText().trim().length() > 0) {
					try {
						int ID = Integer.parseInt(formattedTextFieldIDComponente.getText().trim());	//Ottengo l'ID
						
						ComponentiDaoImpl cDAO = new ComponentiDaoImpl();	//Creo un Oggetto DAO per i componenti
						Componenti componenteRecuperato = cDAO.getSpecificComponente(formattedTextFieldIDComponente.getText().trim());	//Ottengo il singolo componente
 					
						
						
						String col[] = {"IDComponente","Codice Componente","Codice Costruttore", "Descrizione", "Quantita", "Tipologia", "Caratteristica", "Fornitore", "Scatolo"};
						DefaultTableModel tableModel = new DefaultTableModel(col, 1);
						
						JTable table = new JTable(tableModel);
						
						tableModel.setRowCount(0); //Normalmente il numero di righe di default è 4, quindi le imposto a 0
							
						Object[] objs = {componenteRecuperato.getIDComponente(), componenteRecuperato.getNomeComponente(), componenteRecuperato.getCodiceCostruttore(), componenteRecuperato.getDescrizione(), componenteRecuperato.getQuantita(), componenteRecuperato.getTipologiaComponente(), componenteRecuperato.getCaratteristicheComponente(), componenteRecuperato.getFornitoreComponente(), componenteRecuperato.getScatoloComponente()};
						tableModel.addRow(objs);
						
						//Crea un nuovo Panel
						JPanel panel = new JPanel();
				        panel.setLayout(new BorderLayout());
						
				        //Permetti lo scroll della tabella
						JScrollPane tableContainer = new JScrollPane(table);
						
						//Aggiungi la tabella al container
						panel.add(tableContainer, BorderLayout.CENTER);
						
						//Creazione del JFrame contenente il nuovo pannello con la tabella
						JFrame frameMostraComponenti = new JFrame("Informazioni Componente Singolo");
						frameMostraComponenti.getContentPane().add(panel);
						frameMostraComponenti.pack();
						frameMostraComponenti.setVisible(true);
						
					}
					catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(frameCorrente, "Inserisci un valore numerico", "Attenzione", JOptionPane.OK_OPTION);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserire prima un ID Componente per poter effettuare la ricerca", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		contentPane.add(btnMostraSpecifico, "cell 3 4");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		
		JLabel ComponenteCodiceCostruttore = new JLabel("Mostra Componenti mediante");
		ComponenteCodiceCostruttore.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(ComponenteCodiceCostruttore, "cell 0 5");
		
		JLabel ComponenteCodiceCostruttore2 = new JLabel("Codice Costruttore");
		ComponenteCodiceCostruttore2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(ComponenteCodiceCostruttore2, "cell 0 6");
		
		JLabel lblMostraTramiteCodiceCostruttore = new JLabel("Inserisci Codice Costruttore");
		contentPane.add(lblMostraTramiteCodiceCostruttore, "cell 0 7");
		
		textFieldCodiceCostruttore = new JTextField();
		contentPane.add(textFieldCodiceCostruttore, "cell 3 7,growx");
		textFieldCodiceCostruttore.setColumns(10);
		
		JButton btnMostraTramiteCodiceCostruttore = new JButton("Mostra Tramite CC");
		btnMostraTramiteCodiceCostruttore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldCodiceCostruttore.getText().trim().length() > 0) {
					try {
						String CodiceCostruttore = textFieldCodiceCostruttore.getText().trim();	//Ottengo l'ID
						
						ComponentiDaoImpl cDAO = new ComponentiDaoImpl();	//Creo un Oggetto DAO per i componenti
						List <Componenti> componentiRecuperatiCodiceCostruttore = cDAO.getComponentiMedianteCodiceFornitore(CodiceCostruttore);	//Ottengo il singolo componente
 					
						
						
						String col[] = {"IDComponente","Codice Componente","Codice Costruttore", "Descrizione", "Quantita", "Tipologia", "Caratteristica", "Fornitore", "Scatolo"};
						DefaultTableModel tableModel = new DefaultTableModel(col, componentiRecuperatiCodiceCostruttore.size());
						
						JTable table = new JTable(tableModel);
						
						tableModel.setRowCount(0); //Normalmente il numero di righe di default è 4, quindi le imposto a 0
							
						
						
						for(Componenti c: componentiRecuperatiCodiceCostruttore) {
							
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
						JFrame frameMostraComponenti = new JFrame("Informazioni Componente Mdiante Codice Costruttore");
						frameMostraComponenti.getContentPane().add(panel);
						frameMostraComponenti.pack();
						frameMostraComponenti.setVisible(true);
						
					}
					 catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserire prima un Codice Costruttore per poter effettuare la ricerca", "Attenzione", JOptionPane.OK_OPTION);
				}
			
			}
		});
		contentPane.add(btnMostraTramiteCodiceCostruttore, "cell 3 8");
		contentPane.add(btnAnnulla, "cell 0 9");
	}

}
