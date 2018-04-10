package TestAuthor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SayefReyadh
 */
public class TestAuthor {

    public static void main(String args[]) {
        Author anAuthor = new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm');
        System.out.println(anAuthor.toString()); // call toString()
        anAuthor.setEmail("paul@nowhere.com");
        System.out.println(anAuthor.toString());
        
        Book aBook = new Book("Java for dummy", anAuthor , 19.95, 1000);
        // Use an anonymous instance of Author
        
        ///Author anotherAuthor = new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm');
        
        Book anotherBook = new Book("more Java for dummy", new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm') , 29.95 , 888);
        
        System.out.println(aBook.getAuthor().getName() + " " + aBook.getAuthor().getEmail());
        
        System.out.println(anotherBook);
        
        anotherBook.setPrice(0);
        anotherBook.setQtyInStock(0);
        anotherBook.getAuthor().setEmail("aust@aust.com");
        
    }

}
