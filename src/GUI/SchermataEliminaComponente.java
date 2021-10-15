package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.ComponentiDaoImpl;
import DBConfigurazione.DBConnection;
import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SchermataEliminaComponente extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;

	/**
	 * Create the frame.
	 */
	public SchermataEliminaComponente(Main controller) {
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[::100px,center][center][grow,center]", "[][][::37.00px][][][][][]"));
		
		JLabel lblPresentazione1 = new JLabel("Eliminazione del Componente");
		lblPresentazione1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPresentazione1, "cell 1 0");
		
		JLabel lblIDEliminazione = new JLabel("ID Componente");
		lblIDEliminazione.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblIDEliminazione, "cell 0 2");
		
		JFormattedTextField formattedTextFieldIDComponente = new JFormattedTextField();
		contentPane.add(formattedTextFieldIDComponente, "cell 2 2,growx");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		contentPane.add(btnAnnulla, "cell 0 7");
		
		JButton btnProsegui = new JButton("Prosegui");
		btnProsegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ComponentiDaoImpl cDAO = new ComponentiDaoImpl();
					cDAO.deleteComponente(formattedTextFieldIDComponente.getText());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnProsegui, "cell 2 7");
	}

}
