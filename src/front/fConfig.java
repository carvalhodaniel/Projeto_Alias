package front;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conection.ConectDataBase;
import Objetos.Serialization;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class fConfig extends JFrame {

	private JPanel contentPane;
	private JTextField tfServidor;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JTextField tfServico;
	private JComboBox cbTipoBanco;
	
	private String DataBase;
	private String User;
	private String Password;
	private int TipoBanco;
	private String Service;
	
	private File ArquivoXML = new File("\\Objetos\\conn.cfg");

	Component frame = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fConfig frame = new fConfig();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fConfig() {
		setTitle("Configurador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 297, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 33, 225, 274);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConfiguraesDoBanco = new JLabel("Configura\u00E7\u00F5es do Banco");
		lblConfiguraesDoBanco.setBounds(10, 11, 178, 14);
		panel.add(lblConfiguraesDoBanco);
		
		JLabel lblTipoBanco = new JLabel("Tipo Banco");
		lblTipoBanco.setBounds(20, 36, 79, 14);
		panel.add(lblTipoBanco);
		
		cbTipoBanco = new JComboBox();
		cbTipoBanco.setModel(new DefaultComboBoxModel(new String[] {"Oracle", "SQL Server"}));
		cbTipoBanco.setBounds(90, 33, 125, 20);
		panel.add(cbTipoBanco);
		
		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(20, 76, 60, 14);
		panel.add(lblServidor);
		
		tfServidor = new JTextField();
		tfServidor.setBounds(90, 73, 125, 20);
		panel.add(tfServidor);
		tfServidor.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(20, 138, 46, 14);
		panel.add(lblUsurio);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(90, 135, 125, 20);
		panel.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(20, 169, 46, 14);
		panel.add(lblSenha);
		
		tfSenha = new JTextField();
		tfSenha.setBounds(90, 166, 125, 20);
		panel.add(tfSenha);
		tfSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(126, 223, 89, 23);
		panel.add(btnSalvar);
		
		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setBounds(20, 107, 46, 14);
		panel.add(lblServio);
		
		tfServico = new JTextField();
		tfServico.setBounds(90, 104, 125, 20);
		panel.add(tfServico);
		tfServico.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfServidor.setText("");
				tfUsuario.setText("");
				tfSenha.setText("");
				tfServico.setText("");
			}
		});
		btnLimpar.setBounds(10, 223, 89, 23);
		panel.add(btnLimpar);
	}
	
	public boolean GravarAlterações() {
		Serialization XMLSerial = new Serialization();
		if(!ArquivoXML.exists()) {
			if(cbTipoBanco.getSelectedIndex() == 0) {
				XMLSerial.setTpDB(1);
			}
			else {
				XMLSerial.setTpDB(2);
			}
			XMLSerial.setDb(tfServidor.getText());
			XMLSerial.setUser(tfUsuario.getText());
			XMLSerial.setPass(tfSenha.getText());
			XMLSerial.setService(tfServico.getText());
			
			FileOutputStream fst;
			try {
				fst = new FileOutputStream(ArquivoXML);
				java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(fst);
				xe1.writeObject(fst);
				xe1.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				String erro = ("Erro em gravar o Arquivo. " + e);
				JOptionPane.showMessageDialog(frame, erro, "Alert", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			try {
				ConectDataBase conectar = new ConectDataBase();
				JOptionPane.showMessageDialog(frame, "Conexão aberta", "Alert", JOptionPane.INFORMATION_MESSAGE);
				return true;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				String erro = "Erro na abertura da Conexão. " + e;
				JOptionPane.showMessageDialog(frame, erro, "Alert", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		else {
			try {
				java.beans.XMLDecoder decoder = new java.beans.XMLDecoder(new FileInputStream(ArquivoXML));
				List<Serialization> XML = (List<Serialization>) decoder.readObject();
				decoder.close();
				
				DataBase = XML.get(0).getDb();
				Service = XML.get(0).getService();
				User = XML.get(0).getUser();
				Password = XML.get(0).getPass();
				TipoBanco = XML.get(0).getTpDB();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				ConectDataBase conectar = new ConectDataBase();
				JOptionPane.showMessageDialog(frame, "Conexão aberta", "Alert", JOptionPane.INFORMATION_MESSAGE);
				return true;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				String erro = "Erro na abertura da Conexão. " + e;
				JOptionPane.showMessageDialog(frame, erro, "Alert", JOptionPane.ERROR_MESSAGE);
				return false;
			}	
		}
	}
}
