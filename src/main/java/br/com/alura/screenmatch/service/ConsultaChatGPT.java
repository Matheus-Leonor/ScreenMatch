package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

//chave: 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
public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
    OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
