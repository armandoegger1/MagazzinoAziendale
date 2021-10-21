package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Fornitori;
import Classi.TipologiaDaoImpl;
import Classi.Tipologie;
import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SchermataMostraTipologie extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;


	/**
	 * Create the frame.
	 */
	public SchermataMostraTipologie(Main controller) {
		setTitle("Mostra Tipologia");
		this.controller = controller;
		frameCorrente = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[center][center][center]", "[][][][][][][][]"));
		
		JLabel lblPresentazione = new JLabel("Mostra Tipologie");
		lblPresentazione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblPresentazione, "cell 1 0");
		
		JLabel lblPresentazione2 = new JLabel("Mostra Tutte le Tipologie");
		lblPresentazione2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPresentazione2, "cell 0 2");
		
		JButton btnMostraTutto = new JButton("Mostra Tutto");
		btnMostraTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TipologiaDaoImpl tDAO = new TipologiaDaoImpl();
					List<Tipologie> listaTipologie = new ArrayList<Tipologie>();
					listaTipologie = tDAO.getTutteTipologie();
					
					String col[] = {"IDTipologia","Nome Tipologia","Descrizione"};
					DefaultTableModel tableModel = new DefaultTableModel(col, listaTipologie.size());
					
					JTable table = new JTable(tableModel);
					
					tableModel.setRowCount(0); //Normalmente il numero di righe di default è 4, quindi le imposto a 0
					
					for(Tipologie t: listaTipologie) {
						
						Object[] objs = {t.getIDTipologia(), t.getNomeTipologia(), t.getDescrizione()};
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
					JFrame frameMostraComponenti = new JFrame("Lista Tipologie");
					frameMostraComponenti.getContentPane().add(panel);
					frameMostraComponenti.pack();
					frameMostraComponenti.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnMostraTutto, "cell 2 2");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		contentPane.add(btnAnnulla, "cell 0 7");
	}

}
