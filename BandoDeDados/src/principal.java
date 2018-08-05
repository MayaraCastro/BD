import java.sql.Connection;

public class principal {
	public static void main(String[] args) {
		new Conexao();
		try {
			//Connection connection = Conexao.getConnection();
			Connection conn = new Conexao().getConnection(0);
			System.out.println("Conectado");
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
