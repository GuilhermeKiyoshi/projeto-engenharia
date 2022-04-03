package dao;

import java.util.List;

import application.Dominio;

public interface IDAO {
	void create(Dominio dominio);
	void delete(Dominio dominio);
	List<Dominio> findAll();
	void edit(Dominio dominio);
}