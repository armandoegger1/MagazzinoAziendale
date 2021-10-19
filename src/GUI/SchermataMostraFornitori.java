package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Componenti;
import Classi.ComponentiDaoImpl;
import Classi.FornitoreDaoImpl;
import Classi.Fornitori;
import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SchermataMostraFornitori extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;
	private JTextField textFieldNomeFornitore;

	/**
	 * Create the frame.
	 */
	public SchermataMostraFornitori(Main controller) {
		setResizable(false);
		setTitle("Mostra Fornitori");
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][center][][grow,center]", "[][][][][][][][]"));
		
		JLabel lblPresentazione1 = new JLabel("Mostra TUTTI Fornitori");
		lblPresentazione1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPresentazione1, "cell 1 1");
		
		JButton btnMostraFornitori = new JButton("Mostra Fornitori");
		btnMostraFornitori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//VARIABILI
					FornitoreDaoImpl fDAO = new FornitoreDaoImpl();
					List<Fornitori> fornitoriTotali = new ArrayList<Fornitori>();
					
					fornitoriTotali =  fDAO.getTuttiFornitori();			
					
					
					String col[] = {"IDFornitore","Nome Fornitore","Localita", "Telefono", "Email"};
					DefaultTableModel tableModel = new DefaultTableModel(col, fornitoriTotali.size());
					
					JTable table = new JTable(tableModel);
					
					tableModel.setRowCount(0); //Normalmente il numero di righe di default è 4, quindi le imposto a 0
					
					for(Fornitori f: fornitoriTotali) {
						
						Object[] objs = {f.getIDFornitore(), f.getNomeFornitore(), f.getLocalita(), f.getTelefono(), f.getEmail()};
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
					JFrame frameMostraComponenti = new JFrame("Lista Fornitori");
					frameMostraComponenti.getContentPane().add(panel);
					frameMostraComponenti.pack();
					frameMostraComponenti.setVisible(true);
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnMostraFornitori, "cell 3 1");
		
		JLabel lblPresentazione2 = new JLabel("Mostra Specifico Fornitore");
		lblPresentazione2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPresentazione2, "cell 1 3");
		
		JLabel lblNomeFornitore = new JLabel("Inserisci Nome Fornitore");
		contentPane.add(lblNomeFornitore, "cell 1 4");
		
		textFieldNomeFornitore = new JTextField();
		contentPane.add(textFieldNomeFornitore, "cell 3 4,growx");
		textFieldNomeFornitore.setColumns(10);
		
		JButton btnMostraSpecificoFornitore = new JButton("Mostra Specifico Fornitore");
		btnMostraSpecificoFornitore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNomeFornitore.getText().trim().length() > 0) {
					
					String nomeFornitore = textFieldNomeFornitore.getText();
					
					try {
						FornitoreDaoImpl fDAO = new FornitoreDaoImpl();
						Fornitori fornitoreCorrente;
						
						fornitoreCorrente = fDAO.getFornitoreMedianteNome(nomeFornitore);		
						
						
						String col[] = {"IDFornitore","Nome Fornitore","Localita", "Telefono", "Email"};
						DefaultTableModel tableModel = new DefaultTableModel(col, 1);
						
						JTable table = new JTable(tableModel);
						
						tableModel.setRowCount(0); //Normalmente il numero di righe di default è 4, quindi le imposto a 0
							
						Object[] objs = {fornitoreCorrente.getIDFornitore(), fornitoreCorrente.getNomeFornitore(), fornitoreCorrente.getLocalita(), fornitoreCorrente.getTelefono(), fornitoreCorrente.getEmail()};
						tableModel.addRow(objs);
						
						//Crea un nuovo Panel
						JPanel panel = new JPanel();
				        panel.setLayout(new BorderLayout());
						
				        //Permetti lo scroll della tabella
						JScrollPane tableContainer = new JScrollPane(table);
						
						//Aggiungi la tabella al container
						panel.add(tableContainer, BorderLayout.CENTER);
						
						//Creazione del JFrame contenente il nuovo pannello con la tabella
						JFrame frameMostraComponenti = new JFrame("Lista Fornitori");
						frameMostraComponenti.getContentPane().add(panel);
						frameMostraComponenti.pack();
						frameMostraComponenti.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserire prima un Nome Fornitore per effettuare la ricerca", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		contentPane.add(btnMostraSpecificoFornitore, "cell 3 5");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		contentPane.add(btnAnnulla, "cell 1 7");
	}

}
