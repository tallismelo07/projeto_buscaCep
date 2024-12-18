package classes;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import records.AddressAPI;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepService {
    public AddressAPI buscaAPI(String cep) throws IOException, InterruptedException {
       URI api = URI.create("https://viacep.com.br/ws/" + cep + "/json/");


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(api)
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e){
            throw new RuntimeException("Não consegui acessar o endereço a aprtir desse CEP! ");
        }

        return new Gson().fromJson(response.body(), AddressAPI.class);
    }

    public void salvarJson(AddressAPI address) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter arquivo = new FileWriter(address.cep() + ".json");
        arquivo.write(gson.toJson(address));
        arquivo.close();
    }
}
