/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.pkg12.book.and.author.classes.once.more;

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

        // Test program
        Book javaDummy = new Book("Java for Dummy", 19.99, 99);
        System.out.println(javaDummy); // toString()
        System.out.print("The authors are: "); // No authors inserted
        javaDummy.printAuthors();

        javaDummy.addAuthor(new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm'));
        javaDummy.addAuthor(new Author("Paul Tan", "Paul@nowhere.com", 'm'));
        javaDummy.addAuthor(new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm'));
        javaDummy.addAuthor(new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm'));
        javaDummy.addAuthor(new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm'));
        
        System.out.println(javaDummy); // toString()
        
        String authorName = "Tan Ah Teck";
        //System.out.println(authorName);
        //System.out.println(javaDummy.getAuthors()[0]);
        //System.out.println(authorName.equals(javaDummy.getAuthors()[0].getName()));
        
        boolean check = javaDummy.removeAuthorByName(authorName);
        check = javaDummy.removeAuthorByName(authorName);
        check = javaDummy.removeAuthorByName(authorName);
        
        
        
        System.out.print("The authors are: ");
        javaDummy.printAuthors();

    }

}
