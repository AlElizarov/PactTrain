package cons;

public class BookResponse {

    String author;
    String name;

    public BookResponse(String a, String n){
        author = a;
        name = n;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getName(){
        return name;
    }
}
