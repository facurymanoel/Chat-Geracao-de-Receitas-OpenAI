package br.com.erudio.revisao.service;

import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela regra de negócio
 * relacionada à geração de receitas
 * 
 * A classe utiliza a abstração AIService para
 * realizar a comunicação com a inteligência artificial,
 * mantendo a aplicação desacoplada da implementação
 * real utilizada.
 * 
 * Essa abordagem permite substituir facilmente
 * a implementação da IA sem alterar a lógica 
 * de negócio da aplicação.
 */
@Service
public class RecipeService {
	
	private final AIService aiService;

	public RecipeService(AIService aiService) {
		 this.aiService = aiService;
	}
	
	/**
	 * Cria uma receita com base nos ingredientes
	 * informados pelo usuário 
	 * 
	 * O processamento é delegado para a implementação
	 * da interface AIService responsável pela geração
	 * da receita.
	 * 
	 * @param ingredients ingredientes fornecidos pelo usuário
	 * @return receita gerada pela IA.
	 */
	 public String createRecipe(String ingredients) {
		 return aiService.generateRecipe(ingredients);
	}
	
	

}
