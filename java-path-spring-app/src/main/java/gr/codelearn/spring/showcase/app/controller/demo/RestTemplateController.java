package gr.codelearn.spring.showcase.app.controller.demo;

import com.fasterxml.jackson.databind.JsonNode;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/restTemplate")
public class RestTemplateController {

	private RestTemplate restTemplate;

	@GetMapping
	public ResponseEntity<ApiResponse<String>> getResult() {
		String joke = getSingleJoke("Programming", "Dark");
		return ResponseEntity.ok(ApiResponse.<String>builder().data(joke).build());
	}

	// Good to be replaced by a Service/Repository
	private String getSingleJoke(String... genres) {
		String endpoint = "https://v2.jokeapi.dev/joke/";

		URI builtEndpoint = uriBuilder(endpoint, "single", genres);

		ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity(builtEndpoint, JsonNode.class);
		JsonNode jsonNode = responseEntity.getBody();
		String joke = jsonNode.get("joke").textValue();
		return joke;
	}

	private URI uriBuilder(String endpoint, String type, String... genres) {
		return UriComponentsBuilder.fromUriString(endpoint).pathSegment(String.join(",", genres)).queryParam("type",
																											 type)
								   .build().toUri();
	}
}
