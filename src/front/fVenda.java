package front;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;

public class fVenda extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfCodigoBarras;
	private JTextField tfCodigoProduto;
	private JTextField tfNomeProduto;
	private JTable tblVendas;
	private JTextField tfProcura;
	private JTable tblProdVendidos;
	private JTextField tfValorVendido;
	private JTextField tfValorGasto;
	private JTextField tfSaldoFinal;
	private JTextField tfStatus;
	private JTable tblMaisVend;
	private JTable tblProdVendidosSem;
	private JTable tblMaisVendSem;
	private JTextField tfTotalVendidoSem;
	private JTextField tfTotalGastoSem;
	private JTextField tfSaldoFinalSem;
	private JTextField tfStatusSem;
	private JTable tblProdVendidosMes;
	private JTable tblMaisVendMes;
	private JTextField tfTotalVendidoMes;
	private JTextField tfTotalGastoMes;
	private JTextField tfSaldoFinalMes;
	private JTextField tfStatusMes;
	private JTable tblProdVendidosAno;
	private JTable tblMaisVendidosAno;
	private JTextField tfTotalVendidoAno;
	private JTextField tfTotalGastoAno;
	private JTextField tfSaldoFinalAno;
	private JTextField tfStatusAno;
	private JTable tblPedidoCliente;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fVenda frame = new fVenda();
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
	public fVenda() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAlwaysOnTop(true);
		setTitle("Vendas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 937, 560);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPesquisa = new JMenu("Pesquisa");
		menuBar.add(mnPesquisa);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmAbrirCaixa = new JMenuItem("Abrir caixa");
		mnVendas.add(mntmAbrirCaixa);
		
		JMenuItem mntmFecharCaixa = new JMenuItem("Fechar caixa");
		mnVendas.add(mntmFecharCaixa);
		
		JMenuItem mntmIncluirVenda = new JMenuItem("Incluir Venda");
		mnVendas.add(mntmIncluirVenda);
		
		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorios);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pCaixa = new JPanel();
		pCaixa.setBounds(10, 11, 901, 478);
		contentPane.add(pCaixa);
		pCaixa.setLayout(null);
		
		JLabel lblCauxa = new JLabel("Caixa");
		lblCauxa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCauxa.setBounds(10, 11, 118, 25);
		pCaixa.add(lblCauxa);
		
		JPanel pAbrirCaixa = new JPanel();
		pAbrirCaixa.setBounds(20, 44, 871, 423);
		pCaixa.add(pAbrirCaixa);
		
		JPanel pFinalizarVenda = new JPanel();
		pFinalizarVenda.setBounds(10, 11, 901, 478);
		contentPane.add(pFinalizarVenda);
		pFinalizarVenda.setLayout(null);
		pFinalizarVenda.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Finalizar Venda");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 11, 212, 25);
		pFinalizarVenda.add(lblNewLabel_3);
		
		tblPedidoCliente = new JTable();
		tblPedidoCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblPedidoCliente.setShowVerticalLines(false);
		tblPedidoCliente.setShowHorizontalLines(false);
		tblPedidoCliente.setBounds(10, 59, 288, 408);
		pFinalizarVenda.add(tblPedidoCliente);
		
		JButton btnAdicionarItens = new JButton("Adicionar");
		btnAdicionarItens.setBounds(308, 120, 89, 23);
		pFinalizarVenda.add(btnAdicionarItens);
		
		JButton btnRemoverProduto = new JButton("Remover");
		btnRemoverProduto.setBounds(308, 154, 89, 23);
		pFinalizarVenda.add(btnRemoverProduto);
		
		JRadioButton rbtnDinheiro = new JRadioButton("Dinheiro");
		rbtnDinheiro.setBounds(471, 304, 89, 23);
		pFinalizarVenda.add(rbtnDinheiro);
		
		JLabel lblFormaPagamento = new JLabel("Forma pagamento:");
		lblFormaPagamento.setBounds(471, 283, 153, 14);
		pFinalizarVenda.add(lblFormaPagamento);
		
		JRadioButton rbtnCartao = new JRadioButton("Cart\u00E3o");
		rbtnCartao.setBounds(575, 304, 72, 23);
		pFinalizarVenda.add(rbtnCartao);
		
		JLabel lblSubtotal = new JLabel("Total:");
		lblSubtotal.setBounds(471, 231, 65, 14);
		pFinalizarVenda.add(lblSubtotal);
		
		textField = new JTextField();
		textField.setBounds(528, 228, 132, 20);
		pFinalizarVenda.add(textField);
		textField.setColumns(10);
		
		JButton btnFinalizarVenda = new JButton("Finalizar");
		btnFinalizarVenda.setBounds(786, 444, 89, 23);
		pFinalizarVenda.add(btnFinalizarVenda);
		
		JButton btnCancelarVenda = new JButton("Cancelar");
		btnCancelarVenda.setBounds(665, 444, 89, 23);
		pFinalizarVenda.add(btnCancelarVenda);
		
		JPanel pRelatorio = new JPanel();
		pRelatorio.setBounds(10, 11, 901, 478);
		contentPane.add(pRelatorio);
		pRelatorio.setLayout(null);
		pRelatorio.setVisible(false);
		
		JLabel lblRelatrios = new JLabel("Relat\u00F3rios");
		lblRelatrios.setBounds(10, 11, 175, 25);
		lblRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pRelatorio.add(lblRelatrios);
		
		JTabbedPane tabbledPane = new JTabbedPane(JTabbedPane.TOP);
		tabbledPane.setBounds(20, 47, 858, 390);
		tabbledPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		pRelatorio.add(tabbledPane);
		
		JPanel pDiario = new JPanel();
		tabbledPane.addTab("Diario", null, pDiario, null);
		tabbledPane.setEnabledAt(0, true);
		pDiario.setLayout(null);
		
		JLabel lblFechamentoDirio = new JLabel("Fechamento Di\u00E1rio");
		lblFechamentoDirio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechamentoDirio.setBounds(10, 11, 172, 25);
		pDiario.add(lblFechamentoDirio);
		
		tblProdVendidos = new JTable();
		tblProdVendidos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblProdVendidos.setEnabled(false);
		tblProdVendidos.setBounds(10, 63, 430, 286);
		pDiario.add(tblProdVendidos);
		
		JLabel lblProdutosMaisVendidos = new JLabel("Produtos Vendidos");
		lblProdutosMaisVendidos.setBounds(10, 47, 159, 14);
		pDiario.add(lblProdutosMaisVendidos);
		
		JLabel lblNewLabel = new JLabel("Total Vendido:");
		lblNewLabel.setBounds(469, 228, 98, 14);
		pDiario.add(lblNewLabel);
		
		JLabel lblTotalGasto = new JLabel("Total Gasto:");
		lblTotalGasto.setBounds(469, 253, 84, 14);
		pDiario.add(lblTotalGasto);
		
		JLabel lblStatusFinal = new JLabel("Saldo Final:");
		lblStatusFinal.setBounds(469, 288, 77, 14);
		pDiario.add(lblStatusFinal);
		
		JLabel lblNewLabel_1 = new JLabel("Status");
		lblNewLabel_1.setBounds(490, 313, 46, 14);
		pDiario.add(lblNewLabel_1);
		
		tfValorVendido = new JTextField();
		tfValorVendido.setBounds(557, 225, 137, 20);
		pDiario.add(tfValorVendido);
		tfValorVendido.setColumns(10);
		
		tfValorGasto = new JTextField();
		tfValorGasto.setBounds(557, 250, 137, 20);
		pDiario.add(tfValorGasto);
		tfValorGasto.setColumns(10);
		
		tfSaldoFinal = new JTextField();
		tfSaldoFinal.setBounds(557, 285, 137, 20);
		pDiario.add(tfSaldoFinal);
		tfSaldoFinal.setColumns(10);
		
		tfStatus = new JTextField();
		tfStatus.setBounds(557, 310, 86, 20);
		pDiario.add(tfStatus);
		tfStatus.setColumns(10);
		
		JLabel lblTopMais = new JLabel("Top 3 mais Vendidos");
		lblTopMais.setBounds(469, 34, 188, 14);
		pDiario.add(lblTopMais);
		
		tblMaisVend = new JTable();
		tblMaisVend.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblMaisVend.setShowHorizontalLines(false);
		tblMaisVend.setShowVerticalLines(false);
		tblMaisVend.setEnabled(false);
		tblMaisVend.setBounds(469, 60, 357, 91);
		pDiario.add(tblMaisVend);
		
		JComboBox cmbDia = new JComboBox();
		cmbDia.setBounds(190, 15, 127, 20);
		pDiario.add(cmbDia);
		
		JPanel pSemanal = new JPanel();
		tabbledPane.addTab("Semanal", null, pSemanal, null);
		tabbledPane.setEnabledAt(1, true);
		pSemanal.setLayout(null);
		
		JLabel lblFechamentoSemanal = new JLabel("Fechamento Semanal");
		lblFechamentoSemanal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechamentoSemanal.setBounds(10, 11, 213, 25);
		pSemanal.add(lblFechamentoSemanal);
		
		JComboBox cmbSemana = new JComboBox();
		cmbSemana.setBounds(190, 15, 127, 20);
		pSemanal.add(cmbSemana);
		
		tblProdVendidosSem = new JTable();
		tblProdVendidosSem.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblProdVendidosSem.setBounds(10, 63, 430, 286);
		pSemanal.add(tblProdVendidosSem);
		
		JLabel lblNewLabel_2 = new JLabel("Produtos Vendidos");
		lblNewLabel_2.setBounds(10, 47, 114, 14);
		pSemanal.add(lblNewLabel_2);
		
		JLabel label_7 = new JLabel("Top 3 mais Vendidos");
		label_7.setBounds(469, 34, 188, 14);
		pSemanal.add(label_7);
		
		tblMaisVendSem = new JTable();
		tblMaisVendSem.setShowVerticalLines(false);
		tblMaisVendSem.setShowHorizontalLines(false);
		tblMaisVendSem.setEnabled(false);
		tblMaisVendSem.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblMaisVendSem.setBounds(469, 60, 357, 91);
		pSemanal.add(tblMaisVendSem);
		
		JLabel label_8 = new JLabel("Total Vendido:");
		label_8.setBounds(469, 228, 98, 14);
		pSemanal.add(label_8);
		
		JLabel label_9 = new JLabel("Total Gasto:");
		label_9.setBounds(469, 253, 84, 14);
		pSemanal.add(label_9);
		
		JLabel label_10 = new JLabel("Saldo Final:");
		label_10.setBounds(469, 288, 77, 14);
		pSemanal.add(label_10);
		
		JLabel label_11 = new JLabel("Status");
		label_11.setBounds(490, 313, 46, 14);
		pSemanal.add(label_11);
		
		tfTotalVendidoSem = new JTextField();
		tfTotalVendidoSem.setColumns(10);
		tfTotalVendidoSem.setBounds(557, 225, 137, 20);
		pSemanal.add(tfTotalVendidoSem);
		
		tfTotalGastoSem = new JTextField();
		tfTotalGastoSem.setColumns(10);
		tfTotalGastoSem.setBounds(557, 250, 137, 20);
		pSemanal.add(tfTotalGastoSem);
		
		tfSaldoFinalSem = new JTextField();
		tfSaldoFinalSem.setColumns(10);
		tfSaldoFinalSem.setBounds(557, 285, 137, 20);
		pSemanal.add(tfSaldoFinalSem);
		
		tfStatusSem = new JTextField();
		tfStatusSem.setColumns(10);
		tfStatusSem.setBounds(557, 310, 86, 20);
		pSemanal.add(tfStatusSem);
		
		JPanel pMensal = new JPanel();
		pMensal.setLayout(null);
		tabbledPane.addTab("Mensal", null, pMensal, null);
		tabbledPane.setEnabledAt(2, true);
		
		JLabel lblFechamentoMensal = new JLabel("Fechamento Mensal");
		lblFechamentoMensal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechamentoMensal.setBounds(10, 11, 213, 25);
		pMensal.add(lblFechamentoMensal);
		
		JComboBox cmbMes = new JComboBox();
		cmbMes.setBounds(190, 15, 127, 20);
		pMensal.add(cmbMes);
		
		tblProdVendidosMes = new JTable();
		tblProdVendidosMes.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblProdVendidosMes.setBounds(10, 63, 430, 286);
		pMensal.add(tblProdVendidosMes);
		
		JLabel label_13 = new JLabel("Produtos Vendidos");
		label_13.setBounds(10, 47, 114, 14);
		pMensal.add(label_13);
		
		JLabel label_14 = new JLabel("Top 3 mais Vendidos");
		label_14.setBounds(469, 34, 188, 14);
		pMensal.add(label_14);
		
		tblMaisVendMes = new JTable();
		tblMaisVendMes.setShowVerticalLines(false);
		tblMaisVendMes.setShowHorizontalLines(false);
		tblMaisVendMes.setEnabled(false);
		tblMaisVendMes.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblMaisVendMes.setBounds(469, 60, 357, 91);
		pMensal.add(tblMaisVendMes);
		
		JLabel label_15 = new JLabel("Total Vendido:");
		label_15.setBounds(469, 228, 98, 14);
		pMensal.add(label_15);
		
		JLabel label_16 = new JLabel("Total Gasto:");
		label_16.setBounds(469, 253, 84, 14);
		pMensal.add(label_16);
		
		JLabel label_17 = new JLabel("Saldo Final:");
		label_17.setBounds(469, 288, 77, 14);
		pMensal.add(label_17);
		
		JLabel label_18 = new JLabel("Status");
		label_18.setBounds(490, 313, 46, 14);
		pMensal.add(label_18);
		
		tfTotalVendidoMes = new JTextField();
		tfTotalVendidoMes.setColumns(10);
		tfTotalVendidoMes.setBounds(557, 225, 137, 20);
		pMensal.add(tfTotalVendidoMes);
		
		tfTotalGastoMes = new JTextField();
		tfTotalGastoMes.setColumns(10);
		tfTotalGastoMes.setBounds(557, 250, 137, 20);
		pMensal.add(tfTotalGastoMes);
		
		tfSaldoFinalMes = new JTextField();
		tfSaldoFinalMes.setColumns(10);
		tfSaldoFinalMes.setBounds(557, 285, 137, 20);
		pMensal.add(tfSaldoFinalMes);
		
		tfStatusMes = new JTextField();
		tfStatusMes.setColumns(10);
		tfStatusMes.setBounds(557, 310, 86, 20);
		pMensal.add(tfStatusMes);
		
		JPanel pAnual = new JPanel();
		pAnual.setLayout(null);
		tabbledPane.addTab("Anual", null, pAnual, null);
		tabbledPane.setEnabledAt(3, true);
		
		JLabel lblFechamentoAnual = new JLabel("Fechamento Anual");
		lblFechamentoAnual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechamentoAnual.setBounds(10, 11, 213, 25);
		pAnual.add(lblFechamentoAnual);
		
		JComboBox cmbAno = new JComboBox();
		cmbAno.setBounds(190, 15, 127, 20);
		pAnual.add(cmbAno);
		
		tblProdVendidosAno = new JTable();
		tblProdVendidosAno.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblProdVendidosAno.setBounds(10, 63, 430, 286);
		pAnual.add(tblProdVendidosAno);
		
		JLabel label_19 = new JLabel("Produtos Vendidos");
		label_19.setBounds(10, 47, 114, 14);
		pAnual.add(label_19);
		
		JLabel label_20 = new JLabel("Top 3 mais Vendidos");
		label_20.setBounds(469, 34, 188, 14);
		pAnual.add(label_20);
		
		tblMaisVendidosAno = new JTable();
		tblMaisVendidosAno.setShowVerticalLines(false);
		tblMaisVendidosAno.setShowHorizontalLines(false);
		tblMaisVendidosAno.setEnabled(false);
		tblMaisVendidosAno.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblMaisVendidosAno.setBounds(469, 60, 357, 91);
		pAnual.add(tblMaisVendidosAno);
		
		JLabel label_21 = new JLabel("Total Vendido:");
		label_21.setBounds(469, 228, 98, 14);
		pAnual.add(label_21);
		
		JLabel label_22 = new JLabel("Total Gasto:");
		label_22.setBounds(469, 253, 84, 14);
		pAnual.add(label_22);
		
		JLabel label_23 = new JLabel("Saldo Final:");
		label_23.setBounds(469, 288, 77, 14);
		pAnual.add(label_23);
		
		JLabel label_24 = new JLabel("Status");
		label_24.setBounds(490, 313, 46, 14);
		pAnual.add(label_24);
		
		tfTotalVendidoAno = new JTextField();
		tfTotalVendidoAno.setColumns(10);
		tfTotalVendidoAno.setBounds(557, 225, 137, 20);
		pAnual.add(tfTotalVendidoAno);
		
		tfTotalGastoAno = new JTextField();
		tfTotalGastoAno.setColumns(10);
		tfTotalGastoAno.setBounds(557, 250, 137, 20);
		pAnual.add(tfTotalGastoAno);
		
		tfSaldoFinalAno = new JTextField();
		tfSaldoFinalAno.setColumns(10);
		tfSaldoFinalAno.setBounds(557, 285, 137, 20);
		pAnual.add(tfSaldoFinalAno);
		
		tfStatusAno = new JTextField();
		tfStatusAno.setColumns(10);
		tfStatusAno.setBounds(557, 310, 86, 20);
		pAnual.add(tfStatusAno);
		
		JPanel pPesquisa = new JPanel();
		pPesquisa.setBounds(10, 11, 901, 478);
		contentPane.add(pPesquisa);
		pPesquisa.setLayout(null);
		pPesquisa.setVisible(false);
		
		JLabel lblPesquisa = new JLabel("Pesquisa");
		lblPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPesquisa.setBounds(10, 11, 130, 25);
		pPesquisa.add(lblPesquisa);
		
		JComboBox cmbPesquisa = new JComboBox();
		cmbPesquisa.setBounds(50, 47, 255, 20);
		pPesquisa.add(cmbPesquisa);
		
		JLabel lblPor = new JLabel("Por:");
		lblPor.setBounds(20, 50, 46, 14);
		pPesquisa.add(lblPor);
		
		tblVendas = new JTable();
		tblVendas.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblVendas.setCellSelectionEnabled(true);
		tblVendas.setBounds(10, 145, 881, 323);
		pPesquisa.add(tblVendas);
		
		JButton btnDetalhes = new JButton("Detalhes");
		btnDetalhes.setBounds(786, 118, 89, 23);
		pPesquisa.add(btnDetalhes);
		
		JLabel lbPesquisa = new JLabel("Procurar por:");
		lbPesquisa.setBounds(30, 85, 89, 14);
		pPesquisa.add(lbPesquisa);
		
		tfProcura = new JTextField();
		tfProcura.setBounds(113, 82, 317, 20);
		pPesquisa.add(tfProcura);
		tfProcura.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(475, 81, 89, 23);
		pPesquisa.add(btnProcurar);
		
		JPanel pInclusao = new JPanel();
		pInclusao.setBounds(10, 11, 901, 478);
		contentPane.add(pInclusao);
		pInclusao.setLayout(null);
		pInclusao.setVisible(false);
		
		JLabel label = new JLabel("Inclus\u00E3o de Pedido");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 11, 189, 25);
		pInclusao.add(label);
		
		JLabel label_1 = new JLabel("C\u00F3digo");
		label_1.setBounds(34, 58, 57, 14);
		pInclusao.add(label_1);
		
		tfCodigo = new JTextField();
		tfCodigo.setEnabled(false);
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(80, 55, 44, 20);
		pInclusao.add(tfCodigo);
		
		JLabel label_2 = new JLabel("C\u00F3digo de Barras");
		label_2.setBounds(28, 121, 143, 14);
		pInclusao.add(label_2);
		
		tfCodigoBarras = new JTextField();
		tfCodigoBarras.setColumns(10);
		tfCodigoBarras.setBounds(137, 118, 233, 20);
		pInclusao.add(tfCodigoBarras);
		
		JLabel label_3 = new JLabel("C\u00F3digo do Produto");
		label_3.setBounds(28, 149, 104, 14);
		pInclusao.add(label_3);
		
		tfCodigoProduto = new JTextField();
		tfCodigoProduto.setColumns(10);
		tfCodigoProduto.setBounds(137, 146, 86, 20);
		pInclusao.add(tfCodigoProduto);
		
		JLabel label_4 = new JLabel("Nome do Produto:");
		label_4.setBounds(28, 204, 104, 14);
		pInclusao.add(label_4);
		
		tfNomeProduto = new JTextField();
		tfNomeProduto.setColumns(10);
		tfNomeProduto.setBounds(137, 201, 256, 20);
		pInclusao.add(tfNomeProduto);
		
		JLabel label_5 = new JLabel("Quantidade");
		label_5.setBounds(56, 235, 68, 14);
		pInclusao.add(label_5);
		
		JSpinner spQuantidade = new JSpinner();
		spQuantidade.setBounds(137, 232, 86, 20);
		pInclusao.add(spQuantidade);
		
		JLabel label_6 = new JLabel("Valor");
		label_6.setBounds(91, 274, 33, 14);
		pInclusao.add(label_6);
		
		JFormattedTextField edtPreco = new JFormattedTextField();
		edtPreco.setBounds(137, 271, 86, 20);
		pInclusao.add(edtPreco);
		
		JList listItens = new JList();
		listItens.setEnabled(false);
		listItens.setBorder(new LineBorder(new Color(0, 0, 0)));
		listItens.setBounds(591, 11, 300, 414);
		pInclusao.add(listItens);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(484, 173, 89, 23);
		pInclusao.add(btnRemover);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(665, 436, 89, 23);
		pInclusao.add(btnCancelar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(802, 436, 89, 23);
		pInclusao.add(btnFinalizar);
	}
}
