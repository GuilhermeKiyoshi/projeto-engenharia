package facade;

import java.util.List;

import application.Resultado;

public interface IFacade<T> {
	Resultado create(T t);
	Resultado delete(T t);
	Resultado findAll();
	Resultado edit(T t);
}
