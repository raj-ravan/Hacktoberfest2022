#include<iostream>
#include<stdlib.h>
using namespace std;
#define size 10

struct queue 
{
 int front;
 int rear;
 int a[size]; 
};

void display(struct queue *q)
{
   if(q->rear == -1)
      cout<<"Queue is Empty!!!";
   else
     {
      
      for(int i=q->front; i<=q->rear; i++)
	  cout<<q->a[i]<<" ";
     }
}

void enqueue(struct queue *q,int data)
{
   if(q->rear == size-1)
      cout<<"Queue is Full...!!"<<endl;
   else
   {
      if(q->front == -1)
	 q->front = 0;
      q->rear++;
      q->a[q->rear] = data;
      
   }
}
int dequeue(struct queue *q)
{
   if ((q->front == -1 && q->rear == -1) || q->front > q->rear)
    {
        cout << "Queue is Empty ,Nothing to Dequeue" << endl;
        return 0;
    }
    else if (q->front == q->rear)
    {
        int p = q->a[q->front];
        q->front = -1;
       q->rear = -1;
        return p;
    }
    else

    {
        int p = q->a[q->front];
        q->front++;
        return p;
    }
}

int main()
{
   int d;
 struct queue q;
 int data,choice;
 q.front = -1;
 q.rear = -1;

  cout<<"1)Enqueue the element\n2)Dequeue the element\n3)Exit"<<endl;
  while(1)
  {
  cout<<"\nEnter your choice : "<<endl;
  cin>>choice;

  switch(choice)
    {
      case 1:
           cout<<"Enter element to enqueue : ";
           cin>>data;
           enqueue(&q,data);
           display(&q);
           break;
     
      case 2: 
           d = dequeue(&q);
           cout<<d<<" is dequed from the queue."<<endl;
           display(&q);
           break;
      
      case 3: 
           exit(0);
           break;

      default: 
           cout<<"Invalid choice...!!";
    }
  }
return 0;
}
