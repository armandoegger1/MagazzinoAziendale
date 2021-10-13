package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Driver.Main;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class SchermataApparato extends JFrame {

	private JPanel contentPane;
	private Main controller;
	private JTextField textFieldNomeApparato;
	private JTextField textFieldDescrizione;
	private JFrame frameCorrente;

	/**
	 * Create the frame.
	 */
	public SchermataApparato(Main controller) {
		this.controller = controller;
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[179px][][96px][99px]", "[14px][20px][20px][14px][23px][][][][]"));
		
		JLabel lblApparato = new JLabel("Creazione Apparato");
		lblApparato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblApparato, "cell 1 0,alignx left,aligny top");
		
		JLabel lblNomeApparato = new JLabel("Nome Apparato");
		lblNomeApparato.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeApparato.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNomeApparato, "cell 0 1,growx,aligny center");
		
		textFieldNomeApparato = new JTextField();
		textFieldNomeApparato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textFieldNomeApparato, "cell 2 1,alignx center,aligny top");
		textFieldNomeApparato.setColumns(10);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDescrizione, "cell 0 3,growx,aligny center");
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.Ritorno(frameCorrente);
				
			}
		});
		
		textFieldDescrizione = new JTextField();
		textFieldDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDescrizione.setColumns(10);
		contentPane.add(textFieldDescrizione, "cell 2 3,growx,aligny top");
		
		JLabel lblScheda = new JLabel("Scheda in Uso");
		lblScheda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScheda.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblScheda, "cell 0 5,growx,aligny top");
		
		JList listSchede = new JList();
		listSchede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(listSchede, "cell 2 5,grow");
		contentPane.add(btnAnnulla, "cell 0 8,growx,aligny top");
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldNomeApparato.getText().length() > 0 && textFieldDescrizione.getText().length() > 0) {
					//TODO Query al DB
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Presente almeno un campo vuoto!", "Attenzione", JOptionPane.OK_OPTION);
				}
			}
		});
		contentPane.add(btnConferma, "cell 2 8,growx,aligny top");
	}

}
