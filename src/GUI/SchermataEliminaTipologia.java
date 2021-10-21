package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.TipologiaDaoImpl;
import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SchermataEliminaTipologia extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;
	private JTextField textFieldIDTipologia;

	/**
	 * Create the frame.
	 */
	public SchermataEliminaTipologia(Main controller) {
		setTitle("Elimina Tipologia");
		this.controller = controller;
		frameCorrente = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[center][center][grow,center]", "[][][][][][][][][]"));
		
		JLabel lblBenvenuto = new JLabel("Elimina Tipologia");
		lblBenvenuto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblBenvenuto, "cell 1 0");
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci ID Tipologia");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1, "cell 0 2");
		
		textFieldIDTipologia = new JTextField();
		contentPane.add(textFieldIDTipologia, "cell 2 2,growx");
		textFieldIDTipologia.setColumns(10);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		contentPane.add(btnAnnulla, "cell 0 8");
		
		JButton btnProsegui = new JButton("Prosegui");
		btnProsegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldIDTipologia.getText().trim().length() > 0) {
					try {
						int ID = Integer.parseInt(textFieldIDTipologia.getText().trim());
						int righeEliminate;
						TipologiaDaoImpl tDAO = new TipologiaDaoImpl();
						righeEliminate = tDAO.deleteTipologa(ID);
						
						JOptionPane.showMessageDialog(frameCorrente, "Hai eliminato "+righeEliminate+" righe.", "Eliminazione Tipologie", JOptionPane.INFORMATION_MESSAGE);
					}catch(NumberFormatException nfe) {
						JOptionPane.showMessageDialog(frameCorrente, "Inserisci un ID Valido (Solo Numerico)", "Eliminazione Tipologie", JOptionPane.OK_OPTION);
						textFieldIDTipologia.setText("");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frameCorrente, "Elimina prima tutti i componenti che hanno un riferimento a questa tipologia per poi poter eliminare la tipologia da te indicata", "ATTENZIONE", JOptionPane.OK_OPTION);
						e1.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(frameCorrente, "Inserisci un ID", "Eliminazione Tipologie", JOptionPane.OK_OPTION);
				}
			}
		});
		contentPane.add(btnProsegui, "cell 2 8");
	}

}
