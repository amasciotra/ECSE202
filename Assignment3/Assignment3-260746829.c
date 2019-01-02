/*
 ============================================================================
 Name        : Assignment3-260746829.c
 Author      : Alex Masciotra
 Version     :
 Copyright   : Your copyright notice
 Description : 
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node {
	char* data;
	struct Node* nextNode;
};


/*struct to hold information about queue*/
struct Queue{
	struct Node* front;
	struct Node* rear;
};
struct Node* stackTop=NULL;

struct Queue initQueue(struct Queue q);
void enqueue(char* data, struct Queue* q);
int isQueueEmpty(struct Queue* queue);
char* dequeue(struct Queue* q);
void push(char* value);
char* pop();
char* peek();
int isStackEmpty();
int precedence (char* string);


int main(int argc, char* argv[]){

/* this for loop is to print the input in infix notation*/
	int j;
	 printf("In2post: ");
	for (j = 1; j < argc; j++)
	 printf("%s ", argv[j]);


	struct Queue inputQ;
	struct Queue outputQ;

	inputQ=initQueue(inputQ);
	outputQ=initQueue(outputQ);
	stackTop=NULL;

	char* candidateToken;

	/*fill the input queue with the values from command line*/
	int i;
	/* start at 1 to ignore program name*/
	for (i=1;i<argc; i++){

		enqueue(argv[i],&inputQ);
	}


	/*keep running program as long as queue and stack are not empty*/
	for(i=0; isQueueEmpty(&inputQ)==0 && i<15;i++){

		/*dequeue element in input queue if it exists*/
		candidateToken=dequeue(&inputQ);


		/* check order of tokens, if it is equal to 0, this means it is a number and should be pushed*/

		if(precedence(candidateToken)==0){
			enqueue(candidateToken,&outputQ);
		}else{

			if(precedence(candidateToken)<=precedence(peek())){
				enqueue(pop(),&outputQ);
			}

			push(candidateToken);

		}
	}

	printf("\nPostfix: ");
	while(isStackEmpty()==0){
		enqueue(pop(),&outputQ);
	}

	while(isQueueEmpty(&outputQ)==0){
		printf("%s ",dequeue(&outputQ));
	}
	printf("\n");

return 0;

}



struct Queue initQueue(struct Queue q){
	q.front=NULL;
	q.rear=NULL;

	return q;
}

void enqueue(char* data, struct Queue* q) {
	struct Node* temp =
		(struct Node*)malloc(sizeof(struct Node));
	temp->data =data;
	temp->nextNode = NULL;
	if(q->front == NULL && q->rear == NULL){
		q->front = q->rear = temp;
		return;
	}
	(q->rear)->nextNode = temp;
	(q->rear) = temp;
}


int isQueueEmpty(struct Queue* queue){
	if(queue->front==NULL){
		return 1;
	}
	return 0;
}


char* dequeue(struct Queue* q) {
	struct Node* temp = q->front;
	char* returnData;
	if(q->front == NULL) {
		printf("Queue is Empty\n");
		return NULL;
	}
	if((q->front) == (q->rear)) {
		returnData=(q->front)->data;
		(q->front) = (q->rear) = NULL;
		return returnData;
	}
	else {
		returnData=(q->front)->data;
		q->front = (q->front)->nextNode;
		return returnData;
	}
	free(temp);
}





/* creation of stack with push and pop functions*/
void push(char* value){
    struct Node *temp;
    temp=(struct Node *)malloc(sizeof(struct Node));
    temp->data=value;
    if (stackTop == NULL)
    {
         stackTop=temp;
         stackTop->nextNode=NULL;
    }
    else
    {
        temp->nextNode=stackTop;
        stackTop=temp;
    }
}

char* pop(){
	char* returnChar;

	struct Node* temp= stackTop;
	returnChar=stackTop->data;
	stackTop=temp->nextNode;
	free(temp);
	return returnChar;
}

char* peek(){

	if (stackTop == NULL)
	{
		return "null";
	}
	return stackTop->data;
}


int isStackEmpty()
{
    if (stackTop==NULL){
    	return 1;
    }else {
    	return 0;
    }
}

int precedence (char* string){
	if ((strcmp(string,"+") ==0)|| (strcmp(string,"-")==0)){
		return 1;
	} else if((strcmp(string,"x") ==0)|| (strcmp(string,"*")==0) || (strcmp(string,"/")==0)){
		return 2;
	} else {
		return 0;
	}
}



