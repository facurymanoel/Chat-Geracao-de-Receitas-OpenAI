package br.com.erudio.revisao.service;

import org.springframework.stereotype.Service;

/**
 * Implementação mock da interface AIService.
 * 
 * Utilizada para testes e desenvolvimento da aplicação
 * sem depender de chamadas reais para serviços de
 * Inteligência artificial.
 * 
 *  Essa abordagem permite validar o fluxo de aplicação
 *  localmente mesmo quando a API externa estiver
 *  indisponível ou com limite de utilização.
 */
@Service
public class MockAIService implements AIService {
    
	/**
	 * Gera uma receita simulada com base nos ingredientes
	 * informados pelo usuário.
	 * 
	 * O retorno é fixo e utilizado apenas para fins
	 * de testes e desenvolvimento local.
	 * 
	 * @param ingredients ingredientes fornecidos pelo usuário
	 * @return receita simulada no formato de texto.
	 */
	@Override
	public String generateRecipe(String ingredients) {

		return """
				Receita Gerada (MOCK):

				Ingredientes: %s

				Modo de preparo:
				1. Misture tudo.
				2. Leve ao forno por 45 minutos.
				3. Sirva quente.
				""".formatted(ingredients);
	}

}
