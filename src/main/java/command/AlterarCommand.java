package command;

import application.Dominio;
import application.Resultado;

public class AlterarCommand extends AbstractCommand{

	@Override
	public Resultado execute(Dominio dominio) {
		return fachada.edit(dominio);
	}
}
