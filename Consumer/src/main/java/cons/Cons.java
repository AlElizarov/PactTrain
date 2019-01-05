package cons;

public class Cons {

    public static void main(String[] args) {
        BookClient c = new BookClient();
        BookResponse b = c.getBook("http://localhost:8080/book/2");

        System.out.println(b.getName() + " " + b.getAuthor());
    }

}
