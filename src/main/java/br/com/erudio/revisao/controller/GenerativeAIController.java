package br.com.erudio.revisao.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.revisao.service.RecipeService;

/**
 * Controller REST responsável pelos endpoints
 * relacionados à geração de receitas utilizando
 * inteligência artificial.
 * 
 * O controller recebe as requisições HTTP,
 * processa os parâmetros enviados pelo cliente
 * e delega a geração das receitas para a camada 
 * de serviço.
 */
@RestController
@RequestMapping("/api/recipes")
public class GenerativeAIController {

	private final RecipeService recipeService;

	public GenerativeAIController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	/**
	 * Endpoint responsável pela criação de receitas
	 * com base nos ingredientes enviados pelo usuário.
	 * 
	 * Os dados são recebidos através de query params.
	 * 
	 * Endpoint:
	 * GET /api/recipes/recipe-creator
	 * 
	 * Parâmetros:
	 * - ingredients: ingredientes utilizadas na receita
	 * - cuisine; tipo de culinária desejada
	 * - dietaryRestrictions: restrições alimentares
	 * 
	 * Valores default: 
	 * - cuisine = "any"
	 * - dietaryRestrictions = "none"
	 * 
	 * A resposta é retornada no formato JSON contendo 
	 * a receita gerada.
	 * 
	 *  Exemplo de resposta:
	 *  {
	 *    "recipe": "Receita gerada..."
	 *  }
	 *  
	 * @param ingredients ingredientes fornecidos pelo usuário
	 * @param cuisine tipo de culinária desejada
	 * @param diateryRestrictions restrições alimentares
	 * @return resposta JSON contendo a receita gerada
	 */
	@GetMapping(value = "/recipe-creator" )
	public Map<String, String> recipeCreator(
			@RequestParam String ingredients,
			@RequestParam(defaultValue = "any") String cuisine,
			@RequestParam(defaultValue = "none") String diateryRestrictions ){
		  
		return Map.of("recipe", recipeService.createRecipe(ingredients));
	}

}
