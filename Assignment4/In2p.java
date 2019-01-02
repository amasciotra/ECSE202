/*Alex Masciotra 260746829*/

package a4;

public class In2p {

	 public static void main(String[] args) {
	        Queue inputQ = new Queue (100);
	        Queue outputQ = new Queue (100);
	        Stack stack =  new Stack (100);
	        Token candidateToken;

	        System.out.print("In2post:");
	        int i;
	        for(i=0;i<args.length;i++){
	        	System.out.print(" "+args[i]);/*printing what is entered into the command line*/
	        	inputQ.add(new Token (args[i]));/*fill the input queue with the values from command line*/
	        }

	        while (!inputQ.isEmpty()){
	            candidateToken =inputQ.remove();/*sorting operators and numbers from the input queue by precedence value*/
	            if(candidateToken.getPrecedence() == 0) {
	                outputQ.add(candidateToken);/*store the numbers from the input queue to output queue*/
	            }else{
	                
	                if(!stack.isEmpty()){
	                    if(candidateToken.getPrecedence()<=(stack.peek().getPrecedence())){
	                        outputQ.add(stack.pop());/*store the operators onto the stack from input queue*/
	                    }
	                }
	                stack.push(candidateToken);
	            }
	            

	        }

	        while(!stack.isEmpty()){
	            outputQ.add(stack.pop());/* pop operators*/
	        }
	        
	        System.out.print("\n"+"Postfix: ");
	        
	        while(!outputQ.isEmpty()){
	            System.out.print(outputQ.remove().getToken()+ " ");
	        }
	    }


	    private static class Token {
	        String token;

	        public Token(String token){
	            this.token=token;
	        }

	        public String getToken(){
	            return token;
	        }
	        /*below setting the priority of each operator obeying mathematic rules*/
	        public int getPrecedence(){
	            if ("+".equals(this.token) ||"-".equals(this.token)){
	                return 1;
	            }else if ("x".equals(this.token) || "*".equals(this.token) || "/".equals(this.token)){
	                return 2;/* either x or * will work for multiplication*/ 
	                /*returning 2 higher precedence which takes priority*/
	            }
	            return 0; /*this will return the numbers*/
	        }
	    }
	

         private static class Stack{
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

         private static class Queue{
                 int front=-1;
                 int rear=-1;
                 int maxsize;
                 Token array[];

                 /*set size of array*/
                 public Queue(int size){
                         maxsize = size;
                         array = new Token[size];
                 }

                 public void add(Token t){
                         if(rear+1 == maxsize){
                                 rear=-1;
                         }
                         rear++;
                         array[rear]=t;
                 }
                 
                 public Token remove(){
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

