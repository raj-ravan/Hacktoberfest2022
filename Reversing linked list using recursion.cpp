//reversing linked list
//using recursion
#include <iostream>
using namespace std;
class Node
{
public:
	int data;
	Node *next;
};
Node *head;
Node *prevv;
void Insert(int x)
{
	Node *temp=new Node;
	temp->data=x;
	temp->next=NULL;
	if(head!=NULL)
	{
		prevv->next=temp;
	}
	if(head==NULL)
	{
		head=temp;
	}
	prevv=temp;

}
void Print()
{
	Node* temp;
	temp=head;
	while(temp!=NULL)
	{
		cout << temp->data << " ";
		temp=temp->next;
	}
	cout << "\n";

}
void reverse (Node *temp2)
{
	
	if(temp2->next==NULL)
	{
		head=temp2;
		return;
	}
	reverse(temp2->next);
	Node* temp1;
	temp1=temp2->next;
	temp1->next=temp2;
	temp2->next=NULL;
}
int main()
{
	head=NULL;
	Insert(1);
	Insert(2);
	Insert(3);
	Insert(4);
	Insert(5);
	cout << "forward list: ";
	Print();
	cout << "reverse list: ";
	reverse(head);
	Print();


	
	return 0;
}