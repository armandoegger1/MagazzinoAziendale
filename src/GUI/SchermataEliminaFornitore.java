package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.FornitoreDaoImpl;
import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SchermataEliminaFornitore extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;
	private JTextField textFieldNomeFornitore;

	/**
	 * Create the frame.
	 */
	public SchermataEliminaFornitore(Main controller) {
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[center][center][grow,center]", "[][][][][][][][]"));
		
		JLabel lblPresentazione = new JLabel("Eliminazione di un Fornitore");
		lblPresentazione.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPresentazione, "cell 1 0");
		
		JLabel lblNomeF = new JLabel("Nome Fornitore");
		lblNomeF.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNomeF, "cell 0 2");
		
		textFieldNomeFornitore = new JTextField();
		contentPane.add(textFieldNomeFornitore, "cell 2 2,growx");
		textFieldNomeFornitore.setColumns(10);
		
		JButton btnAnnulla = new JButton("Annulla");
		contentPane.add(btnAnnulla, "cell 0 7");
		
		JButton btnProsegui = new JButton("Prosegui");
		btnProsegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNomeFornitore.getText().length() > 0) {
					
					String nomeFornitore = textFieldNomeFornitore.getText();
					int righeEliminate;
					
					try {
						FornitoreDaoImpl fDAO = new FornitoreDaoImpl();
						righeEliminate = fDAO.deleteFornitore(nomeFornitore);
						
						JOptionPane.showMessageDialog(frameCorrente, "Hai eliminato "+righeEliminate+" righe.", "Eliminazione Fornitori", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserisci il nome del fornitore", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		contentPane.add(btnProsegui, "cell 2 7");
	}

}
