package pkg1.pkg11.book.and.author.classes.again;

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
    private Author authors[];
    private double price;
    private int qtyInStock = 0;

    public Book(String name, Author authors[], double price, int qtyInStock) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public Book(String name, Author authors[], double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
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

        for (int i = 0; i < authors.length; i++) {
            str += authors[i].getName();
            if(i!=authors.length-1)
                str+=" , ";
            
        }
        return str;
    }

    public void printAuthors() {
        for (int i = 0; i < this.authors.length; i++) {
            System.out.print(authors[i].getName());
            if(i!=authors.length-1)
                System.out.print(" , ");
        }
        System.out.println();
    }

}
