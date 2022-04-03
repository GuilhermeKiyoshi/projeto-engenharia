package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.Dominio;
import application.Resultado;
import dao.IDAO;
import strategy.IStrategy;

public class Fachada implements IFacade<Dominio>{
	Resultado resultado = null;
	
	Map<String, IDAO> daos;
	Map<String, Map<String, List<IStrategy>>> rns;
	
	@Override
	public Resultado create(Dominio dominio) {		
		String className = dominio.getClass().getName();
		
		resultado = new Resultado();
		
		String message = executarRegras(dominio, "SALVAR");	
		
		if(message == null) {
			IDAO dao = daos.get(className);
			dao.create(dominio);			
			List<Dominio> dominios = new ArrayList<Dominio>();
			dominios.add(dominio);
			resultado.setDominios(dominios);
			System.out.println("Fornecedor cadastrado com sucesso!");
		}else {
			resultado.setMessage(message);	
			System.out.println(message);
		}		
		return resultado;
	}

	@Override
	public Resultado delete(Dominio dominio) {
		String className = dominio.getClass().getName();
		IDAO dao = daos.get(className);				
		resultado = new Resultado();
		dao.delete(dominio);		
		List<Dominio> dominios = new ArrayList<Dominio>();
		dominios.add(dominio);
		resultado.setDominios(dominios);
		return resultado;
	}

	@Override
	public Resultado findAll() {	
		resultado = new Resultado();
		List <Dominio> dominios = null;
		resultado.setDominios(dominios);
		return resultado;
	}

	@Override
	public Resultado edit(Dominio dominio) {	
		String className = dominio.getClass().getName();
		IDAO dao = daos.get(className);	
		
		resultado = new Resultado();
		String message = executarRegras(dominio, "ALTERAR");
		List<Dominio> dominios = new ArrayList<Dominio>();
		
		if(message == null) {
			dao.edit(dominio);		
			dominios.add(dominio);
			resultado.setDominios(dominios);			
		}else {
			dominios.add(dominio);
			resultado.setMessage(message);
			resultado.setDominios(dominios);
		}
		
		return resultado;
	}
	
	
	private String executarRegras(Dominio dominio, String operacao) {
		String className = dominio.getClass().getName();
		StringBuilder message = new StringBuilder();
		
		Map<String, List<IStrategy>> regrasOperacao = rns.get(className);
		
		if(regrasOperacao != null) {
			List<IStrategy> regras = regrasOperacao.get(operacao);
			for(IStrategy s : regras) {
				if(s.processar(dominio) != null) {
					message.append(s.processar(dominio));
					message.append('\n');
				}
			}
		}
		
		if(message.length() > 0) {
			return message.toString();
		}else {
			return null;
		}
	}

}
