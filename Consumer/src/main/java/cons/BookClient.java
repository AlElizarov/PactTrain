package cons;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;

public class BookClient {

    public BookResponse getBook(String uri){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        Gson g = new Gson();
        BookResponse b = g.fromJson(result, BookResponse.class);
        return b;
    }

}
