import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import cons.BookClient;
import cons.BookResponse;
import org.junit.Assert;

import java.io.IOException;
import static org.hamcrest.core.Is.is;

public class ConsumerTest extends ConsumerPactTestMk2 {

    @Override
    @Pact(consumer="book_consumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .given("War and Piece")
                .uponReceiving("Get Book 1")
                    .path("/book/1")
                    .method("GET")
                .willRespondWith()
                    .status(200)
                    .body("{\"author\": \"Tolstoi\", \"name\": \"War and Piece\"}")
                .toPact();
    }

    @Override
    protected String providerName() {
        return "book_provider";
    }

    @Override
    protected String consumerName() {
        return "book_consumer";
    }

    protected void runTest(MockServer mockServer) throws IOException {
        BookClient bc = new BookClient();
        BookResponse br = bc.getBook(mockServer.getUrl() + "/book/1");
        Assert.assertThat(br.getAuthor(), is("Tolstoi"));
        Assert.assertThat(br.getName(), is("War and Piece"));
    }

}
