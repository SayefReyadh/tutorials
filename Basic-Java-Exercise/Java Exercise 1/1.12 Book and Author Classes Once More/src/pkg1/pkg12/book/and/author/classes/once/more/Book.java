package pkg1.pkg12.book.and.author.classes.once.more;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SayefReyadh
 */
public class Book {

    private String name;
    private Author authors[] = new Author[5];
    private int numAuthors=0;
    private double price;
    private int qtyInStock=0;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Book(String name, double price, int qtyInStock) {
        this.name = name;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    @Override
    public String toString() {
        String str = name + " by ";

        for (int i = 0; i < this.numAuthors; i++) {
            str += authors[i].getName();
            if(i!=this.numAuthors-1)
                str+=" , ";
            
        }
        return str;
    }

    public void printAuthors() {
        for (int i = 0; i < this.numAuthors; i++) {
            System.out.print(authors[i].getName());
            if(i!=this.numAuthors-1)
                System.out.print(" , ");
        }
        System.out.println();
    }
    
    public void addAuthor(Author author)
    {
        this.authors[this.numAuthors++] = author;
    }
    
    boolean removeAuthorByName(String authorName)
    {
        boolean check = false;
        for(int i = 0 ; i<this.numAuthors ; i++)
        {
            //System.out.println(this.authors[i].equals(authorName));
            if(authorName.equals(this.authors[i].getName()))
            {
                int j;
                for(j = i ; j<this.numAuthors-1 ; j++)
                {
                    this.authors[j] = this.authors[j+1];
                }
                this.authors[j] = null;
                this.numAuthors--;
                check = true;
                break;
            }
        }
        return check;
    }
}
