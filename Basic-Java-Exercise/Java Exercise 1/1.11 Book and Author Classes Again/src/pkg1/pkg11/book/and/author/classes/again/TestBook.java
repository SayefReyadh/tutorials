/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.pkg11.book.and.author.classes.again;

/**
 *
 * @author SayefReyadh
 */
public class TestBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Declare and allocate an array of Authors
        Author[] authors = new Author[2];
        authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
        authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');

        // Declare and allocate a Book instance
        Book javaDummy = new Book("Java for Dummy", authors, 19.99, 99);
        System.out.println(javaDummy); // toString()
        System.out.print("The authors are: ");
        javaDummy.printAuthors();
        
        Book anotherBook = new Book("more Java for dummy", authors , 29.95 , 888);
        
        anotherBook.setPrice(0);
        anotherBook.setQtyInStock(0);
        anotherBook.getAuthors()[0].setEmail("aust@aust.com");
        
    }

}
