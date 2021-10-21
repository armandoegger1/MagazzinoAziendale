package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Caratteristiche;
import Classi.CaratteristicheDaoImpl;
import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SchermataMostraCaratteristiche extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;

	/**
	 * Create the frame.
	 */
	public SchermataMostraCaratteristiche(Main controller) {
		setResizable(false);
		setTitle("Mostra Caratteristiche");
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][center][grow,center][]", "[][][][][][][][]"));
		
		JLabel lblPresentazione1 = new JLabel("Mostra tutte le Caratteristiche");
		lblPresentazione1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPresentazione1, "cell 1 1");
		
		JButton btnMostraTutto = new JButton("Mostra Tutto");
		btnMostraTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Caratteristiche> caratteristicheTotali = new ArrayList<Caratteristiche>();
					CaratteristicheDaoImpl caratteristicheDAO = new CaratteristicheDaoImpl();
	
					caratteristicheTotali =  caratteristicheDAO.getTutteCaratteristiche();
							
					
					String col[] = {"IDCaratteristica","Nome Caratteristica","Valore", "Descrizione"};
					DefaultTableModel tableModel = new DefaultTableModel(col, caratteristicheTotali.size());
					
					JTable table = new JTable(tableModel);
					
					tableModel.setRowCount(0); //Normalmente il numero di righe di default è 4, quindi le imposto a 0
					
					for(Caratteristiche c: caratteristicheTotali) {
						
						Object[] objs = {c.getIDCaratteristica(), c.getNomeCaratteristica(), c.getValore(), c.getDescrizione()};
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
					JFrame frameMostraComponenti = new JFrame("Lista Caratteristiche");
					frameMostraComponenti.getContentPane().add(panel);
					frameMostraComponenti.pack();
					frameMostraComponenti.setVisible(true);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnMostraTutto, "cell 2 1");
		
		JLabel lblPresentazione2 = new JLabel("Mostra Specifica Caratteristica");
		lblPresentazione2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPresentazione2, "cell 1 3,alignx center");
		
		JLabel lblPresentazione2_1 = new JLabel("Inserisci ID Caratteristica");
		lblPresentazione2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblPresentazione2_1, "cell 1 4,alignx center");
		
		JFormattedTextField formattedTextFieldIDCaratteristica = new JFormattedTextField();
		contentPane.add(formattedTextFieldIDCaratteristica, "cell 2 4,growx");
		
		JButton btnMostraSpecifico = new JButton("Mostra Specifico");
		btnMostraSpecifico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(formattedTextFieldIDCaratteristica.getText().trim().length() > 0) {
					try {
						int ID = Integer.parseInt(formattedTextFieldIDCaratteristica.getText().trim());
						
						CaratteristicheDaoImpl cDAO = new CaratteristicheDaoImpl();
						
						Caratteristiche c = cDAO.getCaratteristicaSpecifica(ID);
						
						String col[] = {"IDCaratteristica","Nome Caratteristica","Valore", "Descrizione"};
						DefaultTableModel tableModel = new DefaultTableModel(col, 1);
						
						JTable table = new JTable(tableModel);
						
						tableModel.setRowCount(0); //Normalmente il numero di righe di default è 4, quindi le imposto a 0
						
						Object[] objs = {c.getIDCaratteristica(), c.getNomeCaratteristica(), c.getValore(), c.getDescrizione()};
						tableModel.addRow(objs);
						
						//Crea un nuovo Panel
						JPanel panel = new JPanel();
				        panel.setLayout(new BorderLayout());
						
				        //Permetti lo scroll della tabella
						JScrollPane tableContainer = new JScrollPane(table);
						
						//Aggiungi la tabella al container
						panel.add(tableContainer, BorderLayout.CENTER);
						
						//Creazione del JFrame contenente il nuovo pannello con la tabella
						JFrame frameMostraTabella = new JFrame("Lista Caratteristica");
						frameMostraTabella.getContentPane().add(panel);
						frameMostraTabella.pack();
						frameMostraTabella.setVisible(true);
						
					}
					catch(NumberFormatException nfe) {
						JOptionPane.showMessageDialog(frameCorrente, "Inserisci un valore numerico", "Attenzione", JOptionPane.OK_OPTION);
						formattedTextFieldIDCaratteristica.setText("");
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserisci un valore", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		contentPane.add(btnMostraSpecifico, "cell 2 5");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		contentPane.add(btnAnnulla, "cell 1 7");
	}

}
