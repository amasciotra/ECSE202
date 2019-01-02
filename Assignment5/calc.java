package calc;
//Alex Masciotra 260746829
public class calc {

	
			 public static void main(String[] args) {
			        Queue inputQ = new Queue (100);//input command line
			        Queue outputQ = new Queue (100);//hold the postfix expression
			        Stack stack =  new Stack (100);//hold the operators while doing the shunting yard algorithm
			        Stack stackf= new Stack (100);//stack to hold the numbers before and after each calculation
			        Token candidateToken;
			        float temp;
			        float one; //first value in the operation
			        float two; //second value in the operation 
			        
			        //System.out.print("Input");
			        int i;
			        for(i=0;i<args.length;i++){
			        	System.out.print(" "+args[i]);/*printing what is entered into the command line*/
			        	inputQ.enqueue(new Token (args[i]));/*fill the input queue with the values from command line*/
			        }

			        while (!inputQ.isEmpty()){
			            candidateToken =inputQ.dequeue();/*sorting operators and numbers from the input queue by precedence value*/
			            if(candidateToken.getPrecedence() == 0) {
			                outputQ.enqueue(candidateToken);/*store the numbers from the input queue to output queue*/
			            }else{
			                
			                if(!stack.isEmpty()){
			                    if(candidateToken.getPrecedence()<=(stack.peek().getPrecedence())){
			                        outputQ.enqueue(stack.pop());/*store the operators onto the stack from input queue*/
			                    }
			                }
			                stack.push(candidateToken);
			            }
			            

			        }

			        while(!stack.isEmpty()){
			            outputQ.enqueue(stack.pop());/* pop operators*/
			        }
			        
			       
			   
			       while(!outputQ.isEmpty()){
			        	candidateToken=outputQ.dequeue();//dequeue elements from the outputQ
			        	switch(candidateToken.getType()){//check to see what type is up in the outputQ
			        		case "NUMBER"://if its a number, put it on the stackf
			        			stackf.push(candidateToken);
			        			break;
			        			/*if its one of the following operators, pop the top 2 values in the stackf and perform the operation
			        			once operation is done, push the new number back onto the stackf*/
			        		case "x":
			        			two = stackf.pop().tokenToFloat();//tokentofloat is added in here so it converts each number to a float to do the operation
			        			one = stackf.pop().tokenToFloat();
			        			temp= one * two;
			        			stackf.push(new Token(temp));//this is the new number, in token form to be used with the stack class, which will later be converted to a float once popped again
			        			break;
			        		case "/":
			        			two = stackf.pop().tokenToFloat();
			        			one = stackf.pop().tokenToFloat();
			        			temp= one / two;
			        			stackf.push(new Token(temp));
			        			break;
			        		case "+":
			        			two = stackf.pop().tokenToFloat();
			        			one = stackf.pop().tokenToFloat();
			        			temp= one + two;
			        			stackf.push(new Token(temp));
			        			break;
			        		case "-":
			        			two = stackf.pop().tokenToFloat();
			        			one = stackf.pop().tokenToFloat();	
			        			temp= one - two;
			        			stackf.push(new Token(temp));
			        			break;
			        		case "^":
			        			two = stackf.pop().tokenToFloat();
			        			one = stackf.pop().tokenToFloat();	
			        			temp = (float)(Math.pow(one, two));//casting the double to a float, using the Math.pow to perform exponent
			        			stackf.push(new Token(temp));
			        			break;
			        				
			        	}
			        
			        	
			        }
			       
			       System.out.print(" = ");
			        System.out.println(stackf.peek().tokenToFloat()); //print the top element which is the only element left on stackf, this is the answer
			       
			    }


			    private static class Token {
			        String token;
			        
			        //converting token to floats so no need for a separate Float Stack Class
			      public float tokenToFloat(){
			        	Float tempObject;
			        	tempObject = Float.valueOf(this.token);
			        	return tempObject.floatValue();
			        	
			        }

			        public Token(String token){
			            this.token=token;
			        }
			        
			       
			       public Token(float value){
			  	        	this.token=Float.toString(value);
			        }

			        
			        
			        /*below setting the priority of each operator obeying mathematic rules*/
			        public int getPrecedence(){
			            if ("+".equals(this.token) ||"-".equals(this.token)){
			                return 1;
			            }else if ("x".equals(this.token) || "*".equals(this.token) || "/".equals(this.token)){
			                return 2;/* either x or * will work for multiplication*/ 
			                /*returning 2 higher precedence which takes priority*/
			            }else if ("^".equals(this.token)){
			            	return 3;
			            }
			           
			            return 0; /*this will return the numbers*/
			        }
			        	 
			        //this is to see if its a number to put into the stackf, or else token will be the operator
			        public String getType(){
			     	        
			 	        	//if precedence is equal to 0 then it's a number
			 	        	if(this.getPrecedence()==0){
			 	        		return "NUMBER";
			 	        	}else{
			 	        		return token;
			 	        	}
			        }
			    }
			

		         private static class Stack{//generic stack class to be used to hold operators while translating infix to postfix first and then to hold floats after while evaluating expressions
		                 int top=-1;
		                 Token array[];

		                /*size of array*/
		                 public Stack(int size){
		                         array = new Token[size];		
		                 }

		                 public void push(Token t){
		                         top=top+1;
		                         array[top]=t;
		                 }

		                 public Token pop(){
		                         Token temp;
		                         temp=array[top];
		                         top--;
		                         return temp;	
		                 }

		                 public Token peek(){
		                         return array[top];/*item on top of stack*/
		                 }
		                 /*to check if stack is empty or not*/
		                 public boolean isEmpty(){
		                         if(top == -1){
		                                 return true;
		                         }
		                         else{
		                                 return false;
		                         }
		                 }
		         }
		 

		         private static class Queue{// queue was used in assignment 4, input and output queue, the outputQ is used now to feed the postfix to the stackf and do operations on
		                 int front=-1;
		                 int rear=-1;
		                 int maxsize;
		                 Token array[];

		                 /*set size of array*/
		                 public Queue(int size){
		                         maxsize = size;
		                         array = new Token[size];
		                 }

		                 public void enqueue(Token t){
		                         if(rear+1 == maxsize){
		                                 rear=-1;
		                         }
		                         rear++;
		                         array[rear]=t;
		                 }
		                 
		                 public Token dequeue(){
		                         if(front+1 == maxsize){
		                                 front=-1;
		                         }

		                         Token character;
		                         front++;
		                         character=array[front];

		                         return character;
		                 }
		                 /*to check if queue is empty or not*/
		                 public boolean isEmpty(){
		                         if(rear == front){
		                                 return true;
		                         }

		                         else{
		                                 return false;
		                         }
		                 }



		         }
		}

