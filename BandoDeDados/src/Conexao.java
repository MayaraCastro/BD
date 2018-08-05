import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private Connection c0;
	private Connection c1;
	private Connection c2;
	
	public Conexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c1 = DriverManager.getConnection("jdbc:mysql://localhost/AGENCIA", "root", "");
		}	
		catch(SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
		
		//jdbc:mysql://ip/nome_do_banco
	public Connection getConnection(int tipo){
			if(tipo == 0) return c0;
			else if(tipo == 1) return c1;
			else if(tipo == 2) return c2;
			return null;
	}
}
