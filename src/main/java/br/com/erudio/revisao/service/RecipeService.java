package br.com.erudio.revisao.service;

import org.springframework.stereotype.Service;

@Service
public class RecipeService {
	
	private final AIService aiService;

	public RecipeService(AIService aiService) {
		 this.aiService = aiService;
	}
	
	public String createRecipe(String ingredients) {
		return aiService.generateRecipe(ingredients);
	}
	
	

}
