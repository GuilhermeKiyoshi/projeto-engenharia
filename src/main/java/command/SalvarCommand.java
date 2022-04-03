package command;

import application.Dominio;
import application.Resultado;

public class SalvarCommand extends AbstractCommand{

	@Override
	public Resultado execute(Dominio dominio) {
		return fachada.create(dominio);
	}

}
