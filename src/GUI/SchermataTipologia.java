package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchermataTipologia extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JFrame frameCorrente;
	private JTextField textFieldNomeTipologia;
	private JTextField textFieldDescrizione;

	/**
	 * Create the frame.
	 */
	public SchermataTipologia(Main controller) {
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[136.00,center][127.00,center][grow,center]", "[][][][][][][][][]"));
		
		JLabel lblTipologia = new JLabel("Creazione Tipologia");
		lblTipologia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblTipologia, "cell 1 0");
		
		JLabel lblNomeTipologia = new JLabel("Nome Tipologia");
		lblNomeTipologia.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNomeTipologia, "cell 0 2");
		
		textFieldNomeTipologia = new JTextField();
		contentPane.add(textFieldNomeTipologia, "cell 2 2,growx");
		textFieldNomeTipologia.setColumns(10);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblDescrizione, "cell 0 4");
		
		textFieldDescrizione = new JTextField();
		contentPane.add(textFieldDescrizione, "cell 2 4,growx");
		textFieldDescrizione.setColumns(10);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Ritorno(frameCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnAnnulla, "cell 0 8");
		
		JButton btnProsegui = new JButton("Prosegui");
		btnProsegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNomeTipologia.getText().length() > 0) {
					
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Campi in grassetto vuoti!", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		btnProsegui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnProsegui, "cell 2 8");
	}

}
