package br.ufrpe.libelula.testes;

import java.time.LocalDate;
import java.util.Calendar;

import br.ufrpe.libelula.negocio.beans.Pacote;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;

public class Teste {
	public static void main(String[] args) {

		Fachada f = Fachada.getInstance();
		
		LocalDate b =LocalDate.now();

		try {
			f.login("admin", "admin");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Pacote a = new Pacote(10 ,900, 1000, 100, b, b, 0, 1);
		try {
			f.login("admin", "admin");
			System.out.println(f.ListarPacote());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			f.logout();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
