///include<stdio.h>  //C
///include<iostream> //c++

#include<bits/stdc++.h>
using namespace std;

struct node
{
    int data;
    node *link;
};

///insert
void insertFront(node *header, int data);
void insertLast(node *header, int data);
void insertAt(node *header, int data, int index);
void insertBeforeValue(node *header, int data, int value);
void insertSortedOrder(node *header, int data);

///update
void updateFront(node *header, int data);
void updateLast(node *header, int data);
void updateAt(node *header, int data, int index);
void updateValue(node *header, int data, int value);

///delete
void deleteFront(node *header);
void deleteLast(node *header);
void deleteAt(node *header, int index);
void deleteValue(node *header, int value);


///search
int searchIndexOfValue(node *header, int data);
int valueOfIndex(node *header, int index);

///print
void printList(node *header);


int main()
{
    node *header;
    header = (node *) malloc(sizeof(node));

    if(header == NULL) // '\0'
    {
        cout << "Memory Not Available" << endl;
        return 0;
    }

    header->data = INT_MAX;
    header->link = NULL; ///singly linked list
    ///header->link = header;

    int n;
    cin >> n;
    for(int i = 0 ; i < n ; i++)
    {
        int number = rand()%1000;
        cout << number << " ";
        insertSortedOrder(header, number);
    }
    cout << endl;
    updateAt(header, 5000, 4);
    printList(header);
    deleteValue(header, 5000);
    printList(header);
    deleteAt(header, 3);
    printList(header);
    deleteFront(header);
    deleteLast(header);
    printList(header);

}



void printList(node *header)
{
    node *ptr = header->link;
    while(ptr != NULL)
    {
        cout << ptr->data << " ";
        ptr = ptr->link;
    }
    cout << endl;
}

int searchIndexOfValue(node *header, int data)
{
    node *ptr = header->link;
    int index = 0;

    while(ptr -> data != data && ptr !=NULL)
    {
        index++;
        ptr = ptr->link;
    }
    if(ptr -> data == data)
        return index;
    else
        return -1;
}

///header - n0 - n1 - n2 - newNode - n3 - n4 - n5
int valueOfIndex(node *header, int index)
{
    node *ptr = header->link;
    int i = 0;
    do
    {
        if(ptr == NULL)
        {
            cout <<"Array out of Bound OR Empty List" << endl;
            return -9999;
        }
        else
        {
            ptr = ptr->link;
            i++;
        }

    }
    while(i!=index);
    return ptr->data;
}

///header - newNode - n1 - n2 - n3
void insertFront(node *header, int data)
{
    node *newNode = (node *) malloc(sizeof(node));
    if(newNode == NULL) // '\0'
    {
        cout << "Memory Not Available Function Not Compiled" << endl;
    }
    else
    {
        newNode->data = data;
        newNode->link = header->link;
        header->link = newNode;
    }
}

///header - n1 - n2 - n3 - newNode
void insertLast(node *header, int data)
{
    node *ptr = header;
    while(ptr->link != NULL)
    {
        ptr = ptr->link;
    }

    node *newNode = (node *) malloc(sizeof(node));
    if(newNode == NULL) // '\0'
    {
        cout << "Memory Not Available Function Not Compiled" << endl;
    }
    else
    {
        newNode->data = data;
        newNode->link = ptr->link;
        ptr->link = newNode;
    }

}

///header - n0 - n1 - n2 - newNode - n3 - n4 - n5
void insertAt(node *header, int data, int index)
{
    node *ptr = header;
    int indexCheck = -1;
    ///MODIFIED
    while(indexCheck < index - 1 && ptr->link != NULL)
    {
        indexCheck++;
        ptr = ptr->link;
    }
    if(indexCheck+1 != index)
    {
        cout <<"Out of Bound" << endl;
    }
    else
    {
        node *newNode = (node *) malloc(sizeof(node));
        if(newNode == NULL) // '\0'
        {
            cout << "Memory Not Available Function Not Compiled" << endl;
        }
        else
        {
            newNode->data = data;
            newNode->link = ptr->link;
            ptr->link = newNode;
        }
    }

}

void insertBeforeValue(node *header, int data, int value)
{
    int index = searchIndexOfValue(header, value);
    insertAt(header, data, index);
}

///41
///465 < 41
///333 == 465 333 41
///70 == 465 333 70 41
/// 500 ==
void insertSortedOrder(node *header, int data)
{
    node *ptr = header->link;
    node *pred;
    node *newNode = (node *) malloc(sizeof(node));

    if(ptr == NULL || ptr->data > data)
    {
        newNode->data = data;
        newNode->link = ptr;
        header->link = newNode;
    }
    else
    {
        pred = header;
        while(ptr != NULL && ptr->data < data)
        {
            pred = ptr;
            ptr = ptr->link;
        }

        newNode->data = data;
        newNode->link = pred->link;
        pred->link = newNode;
    }
}

///header - n1 - n2 - n3
void updateFront(node *header, int data)
{
//    node *ptr = header ->link;
//    ptr ->data = data;
    header->link->data = data;
}


void updateLast(node *header, int data)
{
    node *ptr = header;
    while(ptr ->link != NULL)
    {
        ptr = ptr->link;
    }
    ptr ->data = data;
}

///header n0 n1 n2 n3
void updateAt(node *header, int data, int index)
{
    node *ptr = header;
    int indexCheck = -1;

    while(indexCheck < index - 1 && ptr->link != NULL)
    {
        indexCheck++;
        ptr = ptr->link;
    }
    if(indexCheck+1 != index)
    {
        return;
    }
    ptr ->link ->data = data;
}

void updateValue(node *header, int data, int value)
{
    int index = searchIndexOfValue(header, value);
    updateAt(header, data, index);
}


///header n0 n1 n2 n3
void deleteFront(node *header)
{
    if(header ->link == NULL)
        return;

    node *ptr = header ->link;

    header -> link = ptr->link;
    free(ptr);
}

void deleteLast(node *header)
{
    if(header ->link == NULL)
        return;

    node *ptr = header;
    while(ptr ->link ->link != NULL)
    {
        ptr = ptr->link;
    }
    free(ptr->link);
    ptr ->link = NULL;

}

///header n0 n1 n3
void deleteAt(node *header, int index)
{
    if(header ->link == NULL)
        return;

    node *ptr = header;
    int indexCheck = -1;
    while(indexCheck < index - 1 && ptr->link != NULL)
    {
        indexCheck++;
        ptr = ptr->link;
    }
    if(indexCheck+1 != index)
    {
        return;
    }

    node *temp = ptr ->link ->link;
    free(ptr->link);
    ptr->link = temp;
}

void deleteValue(node *header, int value)
{
    int index = searchIndexOfValue(header, value);
    deleteAt(header, index);
}






