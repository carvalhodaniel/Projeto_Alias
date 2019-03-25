package front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Principal {

	private JFrame frmAliasAssistence;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmAliasAssistence.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAliasAssistence = new JFrame();
		frmAliasAssistence.setTitle("Alias Assistence");
		frmAliasAssistence.setBounds(100, 100, 755, 442);
		frmAliasAssistence.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAliasAssistence.getContentPane().setLayout(null);
		
		JButton btnBtnvendas = new JButton("btnVendas");
		btnBtnvendas.setBounds(41, 56, 89, 23);
		frmAliasAssistence.getContentPane().add(btnBtnvendas);
		
		JMenuBar menuBar = new JMenuBar();
		frmAliasAssistence.setJMenuBar(menuBar);
		
		JMenu mnMncadastro = new JMenu("mnCadastro");
		menuBar.add(mnMncadastro);
		
		JMenuItem mntmMnivenda = new JMenuItem("mniVenda");
		mnMncadastro.add(mntmMnivenda);
		
		JMenuItem mntmMniproduto = new JMenuItem("mniProduto");
		mnMncadastro.add(mntmMniproduto);
		
		JMenuItem mntmMnifornecedor = new JMenuItem("mniFornecedor");
		mnMncadastro.add(mntmMnifornecedor);
		
		JMenu mnMncontrole = new JMenu("mnControle");
		menuBar.add(mnMncontrole);
		
		JMenuItem mntmMniestoque = new JMenuItem("mniEstoque");
		mnMncontrole.add(mntmMniestoque);
		
		JMenuItem mntmMniprecos = new JMenuItem("mniPrecos");
		mnMncontrole.add(mntmMniprecos);
		
		JMenuItem mntmMnifechamento = new JMenuItem("mniFechamento");
		mnMncontrole.add(mntmMnifechamento);
		
		JMenu mnMnconfig = new JMenu("mnConfig");
		menuBar.add(mnMnconfig);
		
		JMenuItem mntmMniconfiguracoes = new JMenuItem("mniConfiguracoes");
		mnMnconfig.add(mntmMniconfiguracoes);
		
		JSeparator separator = new JSeparator();
		mnMnconfig.add(separator);
		
		JMenuItem mntmMnisair = new JMenuItem("mniSair");
		mnMnconfig.add(mntmMnisair);
	}
}
