package br.com.erudio.revisao.service;

 /**
  * Interface responsável pelo contrato de geração de receitas
  * utilizando inteligência artificial
  * 
  * Permite diferentes implementações de IA sem alterar 
  * a lógica de negócio da aplicação.
  */
public interface AIService {
	
	/**
	 * Gera uma receita com base nos ingredientes informados.
	 *  
	 * @param ingredients ingredientes fornecidos pelo usuário
	 * @return receita gerada pela IA.
	 */
     String generateRecipe(String ingredients);
}
