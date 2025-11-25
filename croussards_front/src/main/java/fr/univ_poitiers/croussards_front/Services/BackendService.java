package fr.univ_poitiers.croussards_front.Services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BackendService {

    private final RestTemplate restTemplate;

    // Injection de la propriété depuis application.properties
    @Value("${backend.api.url}")
    private String backendApiUrl;

    public BackendService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Méthode d'exemple pour récupérer des données
    public String[] getSomeData() {
        String url = backendApiUrl + "/items"; 
        return restTemplate.getForObject(url, String[].class);
    }
}
