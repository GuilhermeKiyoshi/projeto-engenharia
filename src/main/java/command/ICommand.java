package command;

import application.Dominio;
import application.Resultado;

public interface ICommand{
	public Resultado execute(Dominio dominio);
}
