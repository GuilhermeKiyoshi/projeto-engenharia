package command;

import facade.Fachada;
import facade.IFacade;

public abstract class AbstractCommand implements ICommand{
	protected IFacade fachada = new Fachada();
}
