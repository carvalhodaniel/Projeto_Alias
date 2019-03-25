package front;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import Objetos.ProdutoDetalhes;
import sources.mProdutos;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JEditorPane;

public class fProdutos extends JFrame {

	private JPanel contentPane;
	private JTable tbListaProd;
	private JTextField tfPesquisa;
	private JTextField tfCodigoBarras;
	private JTextField tfCodigo;
	private JTextField tfNomeProduto;
	private JTextField tfPrecoVenda;
	private JTextField tfPrecoCompra;
	private JTextField tfEstoque;
	private JTextField tfCodigo1;
	private JTextField tfCodigoBarras1;
	private JTextField tfDtInc;
	private JTextField tfNomeProduto1;
	private JTextField tfPrecoCompra1;
	private JTextField tfPrecoVenda1;
	private JTextField tfEstoque1;
	private JComboBox cbStatus;
	private JComboBox cbTipoPesquisa;
	private JEditorPane epDesc;
	
	private int iIndex;
	private boolean alteratedMode;
	private int inCodigo;
	private int codigoFornecedor;
	
	private ProdutoDetalhes produtoBKP;
	
	mProdutos code;
	private JTextField tfFornecedor1;
	private JTextField tfFornecedor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fProdutos frame = new fProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public fProdutos() throws ClassNotFoundException, SQLException {
		
		code = new mProdutos();
		
		iIndex = 0;
		
		setTitle("Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pCad = new JPanel();
		pCad.setBounds(10, 45, 504, 305);
		contentPane.add(pCad);
		pCad.setLayout(null);
		pCad.setVisible(false);
		
		JPanel pDetalhes = new JPanel();
		pDetalhes.setBounds(10, 45, 504, 305);
		contentPane.add(pDetalhes);
		pDetalhes.setLayout(null);
		
		JPanel pGeral = new JPanel();
		pGeral.setBounds(10, 45, 504, 305);
		contentPane.add(pGeral);
		pGeral.setLayout(null);
		pGeral.setVisible(false);
		
		JLabel lblDetalhes = new JLabel("Detalhes");
		lblDetalhes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDetalhes.setBounds(10, 11, 121, 14);
		pDetalhes.add(lblDetalhes);
		
		JLabel lblCdigo_1 = new JLabel("C\u00F3digo");
		lblCdigo_1.setBounds(10, 46, 46, 14);
		pDetalhes.add(lblCdigo_1);
		
		JLabel lblCdigoDeBarras_1 = new JLabel("C\u00F3digo de Barras");
		lblCdigoDeBarras_1.setBounds(249, 46, 127, 14);
		pDetalhes.add(lblCdigoDeBarras_1);
		
		tfCodigo1 = new JTextField();
		tfCodigo1.setBounds(10, 62, 86, 20);
		pDetalhes.add(tfCodigo1);
		tfCodigo1.setColumns(10);
		
		tfCodigoBarras1 = new JTextField();
		tfCodigoBarras1.setBounds(249, 62, 245, 20);
		pDetalhes.add(tfCodigoBarras1);
		tfCodigoBarras1.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(163, 11, 36, 14);
		pDetalhes.add(lblStatus);
		
		cbStatus = new JComboBox();
		cbStatus.setBounds(209, 8, 78, 20);
		pDetalhes.add(cbStatus);
		
		JLabel lblDataInclusao = new JLabel("Data Inclusao");
		lblDataInclusao.setBounds(307, 11, 69, 14);
		pDetalhes.add(lblDataInclusao);
		
		tfDtInc = new JTextField();
		tfDtInc.setBounds(389, 8, 86, 20);
		pDetalhes.add(tfDtInc);
		tfDtInc.setColumns(10);
		
		JLabel lblNomeProduto_1 = new JLabel("Nome Produto");
		lblNomeProduto_1.setBounds(10, 93, 86, 14);
		pDetalhes.add(lblNomeProduto_1);
		
		tfNomeProduto1 = new JTextField();
		tfNomeProduto1.setBounds(10, 111, 258, 20);
		pDetalhes.add(tfNomeProduto1);
		tfNomeProduto1.setColumns(10);
		
		JLabel lblPrecoCompra = new JLabel("Preco Compra");
		lblPrecoCompra.setBounds(10, 142, 69, 14);
		pDetalhes.add(lblPrecoCompra);
		
		tfPrecoCompra1 = new JTextField();
		tfPrecoCompra1.setBounds(10, 159, 69, 20);
		pDetalhes.add(tfPrecoCompra1);
		tfPrecoCompra1.setColumns(10);
		
		JLabel lblPreoVenda_1 = new JLabel("Pre\u00E7o Venda");
		lblPreoVenda_1.setBounds(116, 142, 60, 14);
		pDetalhes.add(lblPreoVenda_1);
		
		tfPrecoVenda1 = new JTextField();
		tfPrecoVenda1.setBounds(113, 159, 63, 20);
		pDetalhes.add(tfPrecoVenda1);
		tfPrecoVenda1.setColumns(10);
		
		JLabel lblEstoqueMinimo_1 = new JLabel("Estoque Minimo");
		lblEstoqueMinimo_1.setBounds(307, 162, 89, 14);
		pDetalhes.add(lblEstoqueMinimo_1);
		
		tfEstoque1 = new JTextField();
		tfEstoque1.setBounds(405, 159, 36, 20);
		pDetalhes.add(tfEstoque1);
		tfEstoque1.setColumns(10);
		
		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio_1.setBounds(10, 190, 46, 14);
		pDetalhes.add(lblDescrio_1);
		
		JEditorPane epDescricao1 = new JEditorPane();
		epDescricao1.setBounds(10, 209, 484, 85);
		pDetalhes.add(epDescricao1);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(307, 114, 69, 14);
		pDetalhes.add(lblFornecedor);
		
		tfFornecedor1 = new JTextField();
		tfFornecedor1.setBounds(373, 111, 121, 20);
		pDetalhes.add(tfFornecedor1);
		tfFornecedor1.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alteratedMode = true;
			}
		});
		btnAlterar.setBounds(425, 11, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btngeral = new JButton("btnGeral");
		btngeral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (iIndex == 1) {
					pGeral.setVisible(true);
					pCad.setVisible(false);
					pDetalhes.setVisible(false);
					alteratedMode = false;
				}
				else if(iIndex == 2) {
					pGeral.setVisible(true);
					pCad.setVisible(false);
					pDetalhes.setVisible(false);
					iIndex = 1;
					alteratedMode = false;
				}
				else {
					pGeral.setVisible(true);
					pCad.setVisible(false);
					pDetalhes.setVisible(false);
					iIndex = 1;
					btnAlterar.setVisible(false);
					alteratedMode = false;
				}
			}
		});
		btngeral.setBounds(10, 11, 89, 23);
		contentPane.add(btngeral);
		
		JButton btnCad = new JButton("btnCad");
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (iIndex == 1) {
					pGeral.setVisible(false);
					pCad.setVisible(true);
					pDetalhes.setVisible(false);
					iIndex = 2;
					alteratedMode = false;
				}
				else if (iIndex == 2) {
					pGeral.setVisible(false);
					pCad.setVisible(true);
					pDetalhes.setVisible(false);
					iIndex = 2;
					alteratedMode = false;
				}
				else {
					pGeral.setVisible(false);
					pCad.setVisible(true);
					pDetalhes.setVisible(false);
					btnAlterar.setVisible(false);
					iIndex = 2;
					alteratedMode = false;
				}
			}
		});
		btnCad.setBounds(109, 11, 89, 23);
		contentPane.add(btnCad);
		
		
		JLabel lblProdutosCadastrados = new JLabel("Produtos Cadastrados");
		lblProdutosCadastrados.setBounds(10, 11, 123, 14);
		pGeral.add(lblProdutosCadastrados);
		
		tbListaProd = new JTable();
		tbListaProd.setBounds(10, 94, 484, 200);
		pGeral.add(tbListaProd);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(325, 60, 89, 23);
		pGeral.add(btnProcurar);
		
		JLabel lblProcurarPor = new JLabel("Procurar por:");
		lblProcurarPor.setBounds(10, 36, 78, 14);
		pGeral.add(lblProcurarPor);
		
		cbTipoPesquisa = new JComboBox();
		cbTipoPesquisa.setBounds(84, 33, 191, 20);
		pGeral.add(cbTipoPesquisa);
		
		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(10, 63, 305, 20);
		pGeral.add(tfPesquisa);
		tfPesquisa.setColumns(10);
		pCad.setLayout(null);
		
		JLabel lblCadastroProdutos = new JLabel("Cadastro Produtos");
		lblCadastroProdutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastroProdutos.setBounds(10, 8, 178, 14);
		pCad.add(lblCadastroProdutos);
		
		tfCodigoBarras = new JTextField();
		tfCodigoBarras.setBounds(274, 55, 193, 20);
		pCad.add(tfCodigoBarras);
		tfCodigoBarras.setColumns(10);
		
		tfCodigo = new JTextField();
		tfCodigo.setEnabled(false);
		tfCodigo.setEditable(false);
		tfCodigo.setBounds(10, 55, 86, 20);
		pCad.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 33, 46, 14);
		pCad.add(lblCdigo);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras");
		lblCdigoDeBarras.setBounds(274, 33, 110, 14);
		pCad.add(lblCdigoDeBarras);
		
		JLabel lblNomeProduto = new JLabel("Nome Produto:");
		lblNomeProduto.setBounds(10, 101, 86, 14);
		pCad.add(lblNomeProduto);
		
		tfNomeProduto = new JTextField();
		tfNomeProduto.setBounds(10, 119, 278, 20);
		pCad.add(tfNomeProduto);
		tfNomeProduto.setColumns(10);
		
		JLabel lblPreoVenda = new JLabel("Pre\u00E7o Venda");
		lblPreoVenda.setBounds(171, 153, 75, 14);
		pCad.add(lblPreoVenda);
		
		tfPrecoVenda = new JTextField();
		tfPrecoVenda.setBounds(238, 150, 61, 20);
		pCad.add(tfPrecoVenda);
		tfPrecoVenda.setColumns(10);
		
		JLabel lblPreoCompra = new JLabel("Pre\u00E7o Compra");
		lblPreoCompra.setBounds(345, 153, 75, 14);
		pCad.add(lblPreoCompra);
		
		tfPrecoCompra = new JTextField();
		tfPrecoCompra.setBounds(420, 150, 61, 20);
		pCad.add(tfPrecoCompra);
		tfPrecoCompra.setColumns(10);
		
		JLabel lblEstoqueMinimo = new JLabel("Estoque Minimo:");
		lblEstoqueMinimo.setBounds(10, 153, 86, 14);
		pCad.add(lblEstoqueMinimo);
		
		tfEstoque = new JTextField();
		tfEstoque.setBounds(93, 150, 33, 20);
		pCad.add(tfEstoque);
		tfEstoque.setColumns(10);
		
		epDesc = new JEditorPane();
		epDesc.setBounds(10, 196, 484, 75);
		pCad.add(epDesc);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 178, 61, 14);
		pCad.add(lblDescrio);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(264, 282, 89, 23);
		pCad.add(btnCancelar);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(code.VerificaValores(Integer.parseInt(tfCodigo.getText()), tfCodigoBarras.getText(), tfNomeProduto.getText(), Double.parseDouble(tfPrecoVenda.getText()), Double.parseDouble(tfPrecoCompra.getText()), Integer.parseInt(tfEstoque.getText()), codigoFornecedor)) {
					if(code.CadastraProduto(Integer.parseInt(tfCodigo.getText()), tfCodigoBarras.getText(), tfNomeProduto.getText(), Double.parseDouble(tfPrecoVenda.getText()), Double.parseDouble(tfPrecoCompra.getText()), Integer.parseInt(tfEstoque.getText()), epDesc.getText(), codigoFornecedor)) {
						JOptionPane.showMessageDialog(null, "Produto cadastrado com Sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
						iIndex = 3;
						pCad.setVisible(false);
						pDetalhes.setVisible(true);
						inCodigo = Integer.parseInt(tfCodigo.getText());
						
						PopulaDetalhes();
					}
				}
			}
		});
		btnIncluir.setBounds(378, 282, 89, 23);
		pCad.add(btnIncluir);
		
		JLabel lblFornecedor_1 = new JLabel("Fornecedor");
		lblFornecedor_1.setBounds(298, 101, 61, 14);
		pCad.add(lblFornecedor_1);
		
		tfFornecedor = new JTextField();
		tfFornecedor.setBounds(334, 119, 147, 20);
		pCad.add(tfFornecedor);
		tfFornecedor.setColumns(10);
		
		JButton btnPesqForn = new JButton("New button");
		btnPesqForn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesqForn.setBounds(298, 118, 33, 23);
		pCad.add(btnPesqForn);
		
		JButton btnDetalhes = new JButton("Detalhes");
		btnDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(iIndex == 1) {
					pGeral.setVisible(false);
					pDetalhes.setVisible(true);
					btnAlterar.setVisible(true);
					iIndex = 3;
					
					DetEnabled(false);
				}
				else if (iIndex == 2) {
					pCad.setVisible(false);
					pDetalhes.setVisible(true);
					btnAlterar.setVisible(true);
					iIndex = 3;
					DetEnabled(false);
				}
				else {
					pDetalhes.setVisible(true);
					PopulaDetalhes();
					
					DetEnabled(alteratedMode);
				}
			}
		});
		btnDetalhes.setBounds(208, 11, 89, 23);
		contentPane.add(btnDetalhes);
		
		btnAlterar.setVisible(false);
		pCad.setVisible(false);
		pDetalhes.setVisible(false);
		pGeral.setVisible(true);
		alteratedMode = false;
		
	}
	
	private void DetEnabled(boolean bool) {
		this.tfCodigoBarras1.setEnabled(bool);;
		this.cbStatus.setEnabled(bool);
		this.tfNomeProduto.setEnabled(bool);
		this.tfPrecoCompra1.setEnabled(bool);
		this.tfPrecoVenda1.setEnabled(bool);
		this.epDesc.setEnabled(bool);
		this.tfFornecedor1.setEnabled(bool);
	}
	
	private void PopulaDetalhes() {
		produtoBKP = code.produto(inCodigo);
		
		tfCodigo1.setText(inCodigo + "");
		tfCodigoBarras1.setText(produtoBKP.getCodigoBarras());
		tfNomeProduto1.setText(produtoBKP.getNome());
		tfFornecedor1.setText(produtoBKP.getFornecedor() + "");
		tfEstoque1.setText(produtoBKP.getEstmin() + "");
		tfPrecoCompra1.setText(produtoBKP.getPrecocompra() + "");
		tfPrecoVenda1.setText(produtoBKP.getPrecovenda() + "");
		epDesc.setText(produtoBKP.getDesc());
	}
}
