package command;

import application.Dominio;
import application.Resultado;

public class RemoverCommand extends AbstractCommand{

	@Override
	public Resultado execute(Dominio dominio) {
		return fachada.delete(dominio);
	}

}
