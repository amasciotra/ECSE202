//Alex Masciotra 260746829

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator extends JFrame {
	private JButton num1;//creating a variable for every number button that will later be created
	private JButton num2;
	private JButton num3;
	private JButton num4;
	private JButton num5;
	private JButton num6;
	private JButton num7;
	private JButton num8;
	private JButton num9;
	private JButton num0;
	private JButton decimalnum;

	private JButton add;//creating variables for the operator buttons
	private JButton subtract;
	private JButton multiply;
	private JButton divide;
	private JButton exponent;
	private JButton equals;
	private JButton clear;
	private JTextField inputexpression;//variables for the textfields
	private JTextField solution;
	public String equation;
	private JSlider decimalplaces;//variable for the slider
	
	Boolean addBool = false;//this is created to give the operators a false boolean
	Boolean subBool = false;
	Boolean divBool = false;
	Boolean mulBool = false;
	Boolean expBool = false;
	
	String display = "";

	public Calculator() {//this class is for the display (look) of the calculator
		equation= new String("");
		JPanel numbers_operators= new JPanel();//this panel is to hold all the buttons, (numbers and operators)
		numbers_operators.setLayout(new GridLayout(4, 5));//4 rows by 5 columns for this grid 
		numbers_operators.add(num1 = new JButton("1"));//creating buttons now with the previous variables created
		numbers_operators.add(num2 = new JButton("2"));
		numbers_operators.add(num3 = new JButton("3"));
		numbers_operators.add(add = new JButton("+"));
		numbers_operators.add(subtract = new JButton("-"));//the order inserted is for how they will look in rows and columns
		numbers_operators.add(num4 = new JButton("4"));
		numbers_operators.add(num5 = new JButton("5"));
		numbers_operators.add(num6 = new JButton("6"));
		numbers_operators.add(multiply = new JButton("*"));
		numbers_operators.add(divide = new JButton("/"));
		numbers_operators.add(num7 = new JButton("7"));
		numbers_operators.add(num8 = new JButton("8"));
		numbers_operators.add(num9 = new JButton("9"));
		numbers_operators.add(exponent = new JButton("^"));
		numbers_operators.add(equals = new JButton("="));
		numbers_operators.add(num0 = new JButton("0"));
		numbers_operators.add(decimalnum = new JButton("."));
		numbers_operators.add(clear = new JButton("C"));
	
		
		
		JPanel input_output = new JPanel();// this panel is to hold the textfields and the slider, which will be set on top
		input_output.setLayout(new FlowLayout());
		input_output.add(inputexpression = new JTextField(25));
		input_output.add(solution=new JTextField(25));
		inputexpression.setHorizontalAlignment(JTextField.RIGHT);//set right so input starts on the right and slides to middle as characters are added
		inputexpression.setEditable(false);
		
		solution.setHorizontalAlignment(JTextField.CENTER);// so it displays solution in the middle of textfield
		solution.setEditable(false);
		
		decimalplaces= new JSlider(JSlider.HORIZONTAL,0,8,6);//horizontal slider, preset to 6, option of 8 decimal places
		decimalplaces.setMajorTickSpacing(1);
		decimalplaces.setPaintTicks(true);
		decimalplaces.setPaintLabels(true);
		input_output.add(decimalplaces);//adding this to the panel with the textfields

		JPanel panel = new JPanel();//combining both panels into a new panel, to be able to put textfields on top and buttons below it
		panel.setLayout(new GridLayout(2,1));
		panel.add(input_output);
		panel.add(numbers_operators);
		
		add(panel);

		num1.addActionListener(new ListenToOne());//for each button pressed, will call the associated action listener class for that button
		num2.addActionListener(new ListenToTwo());
		num3.addActionListener(new ListenToThree());
		num4.addActionListener(new ListenToFour());
		num5.addActionListener(new ListenToFive());
		num6.addActionListener(new ListenToSix());
		num7.addActionListener(new ListenToSeven());
		num8.addActionListener(new ListenToEight());
		num9.addActionListener(new ListenToNine());
		num0.addActionListener(new ListenToZero());
		decimalnum.addActionListener(new ListenToDecimal());
		//these are for the operators
		add.addActionListener(new ListenToAdd());
		subtract.addActionListener(new ListenToSubtract());
		multiply.addActionListener(new ListenToMultiply());
		divide.addActionListener(new ListenToDivide());
		exponent.addActionListener(new ListenToExponent());
		equals.addActionListener(new ListenToSolve());
		clear.addActionListener(new ListenToClear());

		
	} 
	
	
//clear class to set the new equation, input and solution all to blank when pressed
	class ListenToClear implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation ="";
			inputexpression.setText("");
			solution.setText("");
		}
	}
	
	
//all these classes below are to physically add what each button is to the input expression
	class ListenToOne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation=equation + "1";
			inputexpression.setText(equation);// this is so that we can put together all the buttons pressed in one string
		}
	}

	class ListenToTwo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation =equation + "2";
			inputexpression.setText(equation);
		}
	}

	class ListenToThree implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation =equation +"3";
			inputexpression.setText(equation);
		}
	}

	class ListenToFour implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation =equation +"4"; 
			inputexpression.setText(equation);
		}
	}

	class ListenToFive implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation =equation +"5";
			inputexpression.setText(equation);
		}
	}

	class ListenToSix implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation =equation +"6";
			inputexpression.setText(equation);
		}
	}

	class ListenToSeven implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation =equation +"7";
			inputexpression.setText(equation);
		}
	}

	class ListenToEight implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation =equation +"8";
			inputexpression.setText(equation);
		}
	}

	class ListenToNine implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation =equation +"9";
			inputexpression.setText(equation);
		}
	}

	class ListenToZero implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation =equation +"0";
			inputexpression.setText(equation);
		}
	}


	class ListenToDecimal implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			equation=equation + ".";
			inputexpression.setText(equation);
			
		}
	}
	
	
	class ListenToAdd implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation = equation +" + ";
			inputexpression.setText(equation);

		}
	}

	class ListenToSubtract implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation = equation +" - ";
			inputexpression.setText(equation);

		}
	}

	class ListenToMultiply implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation = equation +" x ";
			inputexpression.setText(equation);

		}
	}

	class ListenToDivide implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation = equation +" / ";
			inputexpression.setText(equation);

		}
	}

	class ListenToExponent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			equation = equation +" ^ ";
			inputexpression.setText(equation);

		}
	}
	
	//the expression to solve is in string form called inputexpression
	class ListenToSolve implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			inputexpression.setText(equation);
			double result = calc(equation);//this here calls the calc class which is below and is more or less the same code as prevous assignments, which will do the calculation
			int precision = decimalplaces.getValue();
			String format = new String("%1$." + precision + "f");
			solution.setText(String.format(format, result));
		
		}
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.pack();
		calculator.setLocationRelativeTo(null);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setVisible(true);
	}
	
	
	//below is the code from the previous assignments with minor changes
	public double calc (String expression) {
        Queue inputQ = new Queue (100);//input from inputexpression
        Queue outputQ = new Queue (100);//hold the postfix expression
        Stack stack =  new Stack (100);//hold the operators while doing the shunting yard algorithm
        Stack stackf= new Stack (100);//stack to hold the numbers before and after each calculation
        Token candidateToken;
        float temp;
        float one; //first value in the operation
        float two; //second value in the operation 
        
        String [] args = expression.split(" ");
        
        int i;
        for(i=0;i<args.length;i++){
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
        	return stackf.peek().tokenToFloat();//this returns the answer of the expression
        	
        
        	
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
	


