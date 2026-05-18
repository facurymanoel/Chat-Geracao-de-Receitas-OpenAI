package br.com.erudio.revisao.service;

import org.springframework.stereotype.Service;

@Service
public class MockAIService implements AIService {

	@Override
	public String generateRecipe(String ingredients) {
		 
		return """
	               Receita Gerada (MOCK):

	               Ingredientes: %s

	               Modo de preparo:
	               1. Misture tudo.
	               2. Leve ao forno por 40 minutos.
	               3. Sirva quente.
	               """.formatted(ingredients);
	}

}
