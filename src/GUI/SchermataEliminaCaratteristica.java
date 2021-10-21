package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.CaratteristicheDaoImpl;
import Classi.ComponentiDaoImpl;
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
import javax.swing.JFormattedTextField;

public class SchermataEliminaCaratteristica extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;

	/**
	 * Create the frame.
	 */
	public SchermataEliminaCaratteristica(Main controller) {
		this.controller = controller;
		frameCorrente = this;
		setResizable(false);
		setTitle("Elimina Caratteristica");
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[center][center][grow,center]", "[][][][][][][][]"));
		
		JLabel lblPresentazione = new JLabel("Elimina Componente");
		lblPresentazione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblPresentazione, "cell 1 0");
		
		JLabel lblNewLabel = new JLabel("ID della caratteristica");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel, "cell 0 2");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		
		JFormattedTextField formattedTextFieldIDCaratteristica = new JFormattedTextField();
		contentPane.add(formattedTextFieldIDCaratteristica, "cell 2 2,growx");
		contentPane.add(btnAnnulla, "cell 0 7");
		
		JButton btnProsegui = new JButton("Prosegui");
		btnProsegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(formattedTextFieldIDCaratteristica.getText().trim().length() > 0) {
					try {
						Integer ID = Integer.parseInt(formattedTextFieldIDCaratteristica.getText());
						CaratteristicheDaoImpl cDAO = new CaratteristicheDaoImpl();
						int righeEliminate = cDAO.deleteCaratteristica(ID);
						
						JOptionPane.showMessageDialog(frameCorrente, "Hai eliminato "+righeEliminate+" righe.", "Eliminazione Caratteristiche", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(frameCorrente, "Inserisci un ID Valido (Solo Numerico)", "Eliminazione Caratteristiche", JOptionPane.OK_OPTION);
						formattedTextFieldIDCaratteristica.setText("");
					}
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Inserisci un ID", "Eliminazione Caratteristiche", JOptionPane.OK_OPTION);
				}

			}
		});
		contentPane.add(btnProsegui, "cell 2 7");
	}

}
