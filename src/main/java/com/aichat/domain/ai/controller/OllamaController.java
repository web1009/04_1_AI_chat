package com.aichat.domain.ai.controller;

import com.aichat.domain.ai.dto.request.OllamaChatRequest;
import com.aichat.domain.ai.service.OllamaService;
import com.aichat.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai/ollama")
public class OllamaController {

  private final OllamaService ollamaService;

  @PostMapping("/chat")
  public ApiResponse<String> chat(@RequestBody OllamaChatRequest request) {
    return ApiResponse.ok(ollamaService.chat(request.getMessage()));
  }

  @PostMapping("/chat/options")
  public ApiResponse<String> chatWithOptions(@RequestBody OllamaChatRequest request) {
    return ApiResponse.ok(
        ollamaService.chatWithOptions(request.getSystemPrompt(), request.getMessage(),
            request.getTemperature()));
  }

}
