/*
	Author		 : Sayef Reyadh Khan
	Channel 	 : https://www.youtube.com/SayefReyadh
	Language	 : C/C++
	Project 	 : Data Structure (Linked List) in C++/JAVA	
*/

package linkedlistexample;

public class Node {
    private int data;
    private Node link;

    public Node() { //header
        this.data = Integer.MIN_VALUE;
        this.link = null;
    }

    public Node(int data, Node link) {
        this.data = data;
        this.link = link;
    }
    
    public Node(int data) {
        this.data = data;
        this.link = null;
    }

    
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
    
    
}
