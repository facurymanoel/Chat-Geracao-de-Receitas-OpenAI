package br.com.erudio.revisao.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.revisao.service.RecipeService;

@RestController
@RequestMapping("/api/recipes")
public class GenerativeAIController {

	private final RecipeService recipeService;

	public GenerativeAIController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping(value = "/recipe-creator" )
	public Map<String, String> recipeCreator(
			@RequestParam String ingredients,
			@RequestParam(defaultValue = "any") String cuisine,
			@RequestParam(defaultValue = "none") String diateryRestrictions ){
		  
		return Map.of("recipe", recipeService.createRecipe(ingredients));
	}

}
