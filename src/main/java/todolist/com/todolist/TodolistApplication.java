package todolist.com.todolist;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import todolist.com.todolist.model.Tarefa;
import todolist.com.todolist.repository.TarefaRepository;
import todolist.com.todolist.service.TarefaServico;

@SpringBootApplication
@EnableFeignClients
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);


		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/tarefas";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		String json = "{\"titulo\": \"Estudar Java\", \"concluida\": false}";
		HttpEntity<String> entity = new HttpEntity<>(json, headers);

		String response = restTemplate.postForObject(url, entity, String.class);
		System.out.println(response);
	}

}
