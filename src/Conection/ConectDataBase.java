package Conection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLStreamException;

import Objetos.Serialization;
import front.fConfig;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ConectDataBase {

	private String DataBase;
	private String User;
	private String Password;
	private int TipoBanco;
	private String Service;
	
	private File ArquivoXML = new File("conn.cfg");
	
	private Connection conect;
	private Statement st;
	
	public ConectDataBase() throws ClassNotFoundException, SQLException {
		
		if(!ArquivoXML.exists()) {
/*			fConfig configurador = new fConfig();
			configurador.setVisible(true);*/
			
			JOptionPane.showMessageDialog(null, "Não existe configuração feita no Configurador", "ERROR", JOptionPane.ERROR_MESSAGE);
			
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
		}
		
		if (TipoBanco == 1) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			this.conect = DriverManager.getConnection("jdbc:oracle:thin:@" + DataBase + ":1521:" + Service , User , Password);
			this.st = (Statement) conect.createStatement();
			
		}
		else {
			
		}
		
	}
	
	public String Select(String Query) {		
		if(TipoBanco == 1) {
			try {
				ResultSet rs = ((java.sql.Statement) st).executeQuery(Query);
				if(rs.next()) {
					return rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}
	
	public boolean ExecuteQuery(String Query) {
		try {
			return true;
		}
		catch (Exception Ex) {
			return false;
		}
	}
	
	public String[][] SelectList(String sTabela, String sWhere, String sColunas[], int iQtaColumn) throws SQLException{
		String[][] lista;
		
		lista = new String[0][0];
		
		String Qry;
		
		Qry = "SELECT ";
		for(int i = 0; i<iQtaColumn; i++) {
			if (i == iQtaColumn-1) {
				Qry += sColunas[i];
			}
			else {
				Qry += sColunas[i] + ",";
			}
		}
		
		Qry += " FROM " + sTabela;
		Qry += sWhere;
		
		if (TipoBanco == 1) {
			ResultSet rs = ((java.sql.Statement) this.st).executeQuery(Qry);
			rs.first();
			if(rs.next()) {
				int iQtaLinha = 0;
				while(rs.next()) {
					iQtaLinha++;
				}
				rs.first();
				int linha = 0;
				lista = new String [iQtaLinha][iQtaColumn];
				while(rs.next()) {
					int coluna = 0;
					for(coluna = 0; coluna < iQtaColumn; coluna++) {
						lista[linha][coluna] = rs.getString(coluna+1);
					}
					linha++;
				}	
			}
		}
		
		
		return lista;
	}
}
