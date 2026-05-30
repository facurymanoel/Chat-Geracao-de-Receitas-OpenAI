package br.com.erudio.revisao.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

	@Mock
	private AIService aiService;

	@InjectMocks
	private RecipeService recipeService;

	@Test
	void shouldCreateRecipeSuccessfully() {

		// Arrange
		String ingredients = "tomate, queijo";
		String expectedRecipe = "Receita mock";

		when(aiService.generateRecipe(ingredients))
		       .thenReturn(expectedRecipe);

		// Act
		String result = recipeService.createRecipe(ingredients);

		// Assert
		assertEquals(expectedRecipe, result);

		verify(aiService).generateRecipe(ingredients);
	}

}
