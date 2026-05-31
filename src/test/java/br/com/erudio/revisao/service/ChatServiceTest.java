package br.com.erudio.revisao.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;

@ExtendWith(MockitoExtension.class)
public class ChatServiceTest {

	@Mock
	private ChatModel chatModel;

	@InjectMocks
	private ChatService chatService;

	@Test
	void shouldReturnAIResponse() {

		// Arrange
		String prompt = "Crie uma receita com queijo";
		String expectedResponse = "Receita Criada";

		when(chatModel.call(prompt)).thenReturn(expectedResponse);

		// Act
		String result = chatService.getResponse(prompt);

		// Assert
		assertEquals(expectedResponse, result);

		verify(chatModel).call(prompt);
	}

	@Test
	void shouldReturnConfiguredAIResponse() {

		// Arrange
		AssistantMessage assistantMessage = new AssistantMessage("Receita configurada");

		Generation generation = new Generation(assistantMessage);

		ChatResponse response = new ChatResponse(List.of(generation));

		when(chatModel.call(any(Prompt.class)))
		              .thenReturn(response);

		// Act
		String result = chatService
				.getResponseWithOptions("Crie uma receita");

		// Assert
		assertEquals("Receita configurada", result);

	}

}
