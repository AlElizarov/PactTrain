import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;

import au.com.dius.pact.provider.junit.target.TestTarget;

import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import com.swtecnn.rest.Book;
import com.swtecnn.rest.BookLogic;
import com.swtecnn.rest.HelloRestService;
import org.junit.Before;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(PactRunner.class)
@Provider("book_provider")
@PactFolder("pacts")
public class BookProviderTest {

    @Mock
    BookLogic bl;

    @InjectMocks
    HelloRestService ser = new HelloRestService();

    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    @Before
    public void setUp(){
        initMocks(this);
        target.setControllers(ser);
    }

    @State({"War and Piece"})
    public void getBook1() {
        when(bl.getBookById(1)).thenReturn(new Book("Tolstoi", "War and Piece"));
    }

    @State({"Onegin"})
    public void getBook2() {
        when(bl.getBookById(2)).thenReturn(new Book("Pushkin", "Onegin"));
    }
}
