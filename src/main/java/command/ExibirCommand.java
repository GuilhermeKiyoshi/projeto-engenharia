package command;

import application.Dominio;
import application.Resultado;

public class ExibirCommand extends AbstractCommand{

	@Override
	public Resultado execute(Dominio dominio) {
		return fachada.findAll();
	}

}
