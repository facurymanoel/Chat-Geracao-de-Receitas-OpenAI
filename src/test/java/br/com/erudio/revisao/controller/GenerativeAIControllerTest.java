package br.com.erudio.revisao.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.erudio.revisao.service.RecipeService;

@WebMvcTest(GenerativeAIController.class)
public class GenerativeAIControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RecipeService recipeService;
	
	@Test
	void shouldReturnRecipeSuccessfully() throws Exception {
		
		 // Arrange
		 when(recipeService.createRecipe("tomate"))
		                   .thenReturn("Receita mock");
		 
		 // Act + Assert
		 mockMvc.perform(get("/api/recipes/recipe-creator")
				.param("ingredients", "tomate"))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.recipe")
		         .value("Receita mock"));
		
		
	}

}
