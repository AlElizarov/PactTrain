import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import cons.BookClient;
import cons.BookResponse;
import org.junit.Assert;

import java.io.IOException;
import static org.hamcrest.core.Is.is;

public class ConsumerTest2 extends ConsumerPactTestMk2 {

    @Override
    @Pact(consumer="book_consumer2")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .given("Onegin")
                .uponReceiving("Get Book 2")
                .path("/book/2")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("{\"author\": \"Pushkin\", \"name\": \"Onegin\"}")
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
        BookResponse br = bc.getBook(mockServer.getUrl() + "/book/2");
        Assert.assertThat(br.getAuthor(), is("Pushkin"));
        Assert.assertThat(br.getName(), is("Onegin"));
    }

}
