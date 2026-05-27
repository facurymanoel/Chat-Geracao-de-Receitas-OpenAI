package br.com.erudio.revisao.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela comunicação com o modelo
 * de inteligência artificial utilizando Spring AI.
 * 
 * A classe realiza o envio de prompts para o modelo
 * de linguagem e retorna as respostas geradas pela IA.
 * 
 * Possui suporte para:
 * - chamadas simples 
 * - chamadas configuradas com opções personalizadas
 * - controle de temperatura das respostas
 */
@Service
public class ChatService {
	
	private final ChatModel chatModel;

	public ChatService(ChatModel chatModel) {
		 this.chatModel = chatModel;
	}
	
	/**
	 * Envia um prompt simples para o modelo de IA
	 * e retorna a resposta gerada.
	 * 
	 * Nesse formato são utilizadas as configurações
	 * padrão do modelo.
	 * 
	 * @param prompt texto enviado para a IA
	 * @return resposta gerada pelo modelo
	 */
	public String getResponse(String prompt) {
		return chatModel.call(prompt);
	}
	
	/**
	 * Envia um prompt configurado para o modelo de IA
	 * utilizando opções personalizadas através de 
	 * ChatOptions.
	 * 
	 * A classe Prompt representa a estrutura enviada 
	 * para o modelo contendo:
	 * - o texto da solicitação
	 * - configurações adicionais da requisição
	 * 
	 * O ChatOptions permite configurar parâmetros
	 * do comportamento da IA, como temperatura, 
	 * limite de tokens e outras opções do modelo.
	 * 
	 * A temperatura controla o nível de criatividade
	 * das respostas:
	 * - Valores baixos geram respostas mais estáveis
	 * e previsíveis
	 * - Valores altos geram respostas mais criativas 
	 * e variadas.
	 * 
	 * Neste projeto foi utilizada temperatura 0.4
	 * para obter repostas mais controladas e objetivas.
	 * 
	 * @param prompt texto enviado para a IA
	 * @return resposta gerada pelo modelo configurado.
	 */
	public String getResponseWithOptions(String prompt) {
		ChatResponse response = chatModel.call( 
				    new Prompt(
				    	prompt,
				    	ChatOptions.builder()
				    	.temperature(0.4)
				    	.build()
				    		));
		return response.getResult().getOutput().getText(); 
				
	}
	
	

}
