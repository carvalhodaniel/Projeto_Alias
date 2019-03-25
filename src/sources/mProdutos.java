package sources;
import java.sql.SQLException;

import Conection.ConectDataBase;
import Objetos.ProdutoDetalhes;

public class mProdutos {	
	
	ConectDataBase conn;
	ProdutoDetalhes prod;
	
	private String[] colunas = {
		"CODIGO",
		"CODIGOBARRAS",
		"NOME",
		"ID_FORNECEDOR",
		"EST_MIN",
		"PRECO_COM",
		"PRECO_VEN",
		"STATUS",
		"DT_INCL",
		"DESC"		
	};
	
	public mProdutos() throws ClassNotFoundException, SQLException {
		conn = new ConectDataBase();
		
	}
	
	public boolean VerificaValores(int codigo, String codigobarras, String nomeprod, double precovenda, double precocompra, int estoquemin, int codFornecedor ) {
		int codigodobanco;
		String Qry;
		
		Qry = "SELECT CODIGO FROM ALPROD WHERE CODIGO = ";
		Qry += codigo;
		
		codigodobanco = Integer.parseInt(conn.Select(Qry));
		
		if (codigodobanco > codigo) {
			return false;
		}
		
		Qry = "SELECT CODIGOBARRAS FROM ALPROD WHERE CODIGOBARRAS = '";
		Qry += codigobarras;
		Qry += "' ";
		
		if (conn.Select(Qry) != "SemRegistro") {
			return false;
		}
		
		if (nomeprod.length() == 0 || nomeprod == null || nomeprod.equals("")) {
			return false;
		}
		
		if(estoquemin == 0 || estoquemin < 0) {
			return false;
		}
		
		Qry = "SELECT CODIGO FROM ALFORN WHERE CODIGO = '";
		Qry += codFornecedor;
		Qry += "' ";
		if(conn.Select(Qry) == "SemRegistro") {
			return false;
		}
		
		return true;
	}
	
	public boolean CadastraProduto(int codigo, String codigobarras, String nomeprod, double precovenda, double precocompra, int estoquemin, String desc, int codFornecedor) {
		String Qry, data;
		
		data = "1";
		
		Qry = "INSERT INTO ALPROD (CODIGO, CODIGOBARRAS, NOME, PRECOVENDA, PRECOCOMPRA, ESTOQUEMIN, DESC, STATUS, DATAINC, ID_FORNECEDOR)";
		Qry += "VALUES(" + codigo + ", '" + codigobarras + "', '" + nomeprod + "', " + precovenda + ", " + precocompra + ", " + estoquemin + ", '" + desc + "'";
		Qry += ", ATIVO, '" + data + "', " + codFornecedor + ")";
		
		if(conn.ExecuteQuery(Qry)) {
			return true;
		}
		else {
			return false;
		}
	}

	public ProdutoDetalhes produto(int codigo) {
		prod = new ProdutoDetalhes();
		
		int iQtaColumn = 10;
			
		String banco[][];
		banco = new String[0][iQtaColumn];
		
		try {
			banco = conn.SelectList("ALPROD", ("WHERE CODIGO = " + codigo) , colunas , iQtaColumn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prod.setCodigo(Integer.parseInt(banco[0][0]));
		prod.setCodigoBarras(banco[0][1]);
		prod.setNome(banco[0][2]);
		prod.setFornecedor(Integer.parseInt(banco[0][3]));
		prod.setEstmin(Integer.parseInt(banco[0][4]));
		prod.setPrecocompra(Double.parseDouble(banco[0][5]));
		prod.setPrecovenda(Double.parseDouble(banco[0][6]));
		prod.setStatus(Integer.parseInt(banco[0][7]));
		prod.setDtIncl(banco[0][8]);
		prod.setDesc(banco[0][9]);
	
		return prod;
		
	}


}
