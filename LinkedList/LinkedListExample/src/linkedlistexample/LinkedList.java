/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistexample;

/**
 *
 * @author SayefReyadh
 */
public class LinkedList {

    private Node header;

    public LinkedList() {
        this.header = new Node();
    }

    public Node getHeader() {
        return header;
    }

    public void setHeader(Node header) {
        this.header = header;
    }

    //print
    public void printList() {
        Node ptr = header.getLink();
        while (ptr != null) {
            System.out.print(ptr.getData() + " ");
            ptr = ptr.getLink();
        }
        System.out.println("");
    }

    //search
    public int searchIndexOfValue(int data) {
        Node pointer = header.getLink();
        int index = -1;

        while (pointer.getData() != data && pointer.getLink() != null) {
            index++;
            pointer = pointer.getLink();
        }

        if (pointer.getData() == data) {
            return index;
        } else {
            return -1;
        }

    }

    public int valueOfIndex(int index) {

        Node pointer = header.getLink();
        int i = 0;
        do {
            if (pointer == null) {
                System.out.println("Empty List OR Array out of bound");
                return -9999;
            } else {
                pointer = pointer.getLink();
                i++;
            }
        } while (i != index);

        return pointer.getData();
    }

    //insert
    ///header - newNode - n1 - n2 - n3
    public void insertFront(int data) {
        Node node = new Node(data, header.getLink());
        header.setLink(node);
    }

    //header - n1 - n2 - n3 - newNode 
    public void insertLast(int data) {
        Node node = new Node(data);
        Node pointer = header;
        while (pointer.getLink() != null) {
            pointer = pointer.getLink();
        }

        pointer.setLink(node);

    }

    //header - n0 - n1 - n2 -  n3 - n4 - n5
    public void insertAt(int data, int index) {
        int indexCheck = -1;
        Node pointer = header;
        while (indexCheck < index - 1 && pointer.getLink() != null) {
            indexCheck++;
            pointer = pointer.getLink();
        }

        if (indexCheck + 1 != index) {
            return;
        } else {
            Node node = new Node(data, pointer.getLink());
            pointer.setLink(node);
        }

    }

    public void insertBeforeValue(int data, int value) {

        int index = searchIndexOfValue(value);
        insertAt(data, index);
    }

    public void insertSortedOrder(int data) {
        Node pointer = header.getLink();
        Node pred = header;
        if (pointer == null || pointer.getData() < data) {
            Node node = new Node(data, pointer);
            header.setLink(node);
        } else {
            while (pointer != null && pointer.getData() > data) {
                pred = pointer;
                pointer = pointer.getLink();
            }
            Node node = new Node(data, pred.getLink());
            pred.setLink(node);
        }

    }

    ///header 10 15 18 20
    //update
    public void updateFront(int data) {
        header.getLink().setData(data);
    }

    public void updateLast(int data) {
        Node pointer = header;
        while (pointer.getLink() != null) {
            pointer = pointer.getLink();
        }

        pointer.setData(data);

    }

    //header n0 n1 n2 n3 n4
    public void updateAt(int data, int index) {
        int indexCheck = -1;
        Node pointer = header;
        while (indexCheck < index - 1 && pointer.getLink() != null) {
            indexCheck++;
            pointer = pointer.getLink();
        }

        if (indexCheck + 1 != index) {
            return;
        } else {
            pointer.getLink().setData(data);
        }
    }

    public void updateValue(int data, int value) {
        int index = searchIndexOfValue(value);
        updateAt(data, index);
    }

    //delete
    public void deleteFront() {
        if(header.getLink() == null)
            return;
        
        header.setLink(header.getLink().getLink());
    }

    public void deleteLast() {
        if(header.getLink() == null)
            return;
        
        Node pointer = header;
        while (pointer.getLink().getLink() != null) {
            pointer = pointer.getLink();
        }
        
        pointer.setLink(null);
        

    }
    //header n0 n1 n2 n3 n4
    public void deleteAt(int index) {
        if(header.getLink() == null)
            return;
        
        int indexCheck = -1;
        Node pointer = header;
        while (indexCheck < index - 1 && pointer.getLink() != null) {
            indexCheck++;
            pointer = pointer.getLink();
        }

        if (indexCheck + 1 != index) {
            return;
        } else {
            pointer.setLink(pointer.getLink().getLink());
        }

    }

    public void deleteValue(int value) {
        if(header.getLink() == null)
            return;
        
        int index = searchIndexOfValue(value);
        deleteAt(index);

    }

}
