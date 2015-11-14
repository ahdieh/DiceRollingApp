import java.util.Random;

public class DiceRolling {
	
	//PRIVATE VARIABLES +++++++++++++++++++++++++

	 private int _dice1; 
	 private int _dice2; 
	 private int[] _diceArray1; 
	 private int[] _diceArray2;
	private int _number;
	 private int[] _frequency = new int[11];
	 
	 Random random = new Random();

	// CONSTRUCTOR ++++++++++++++++++++++++++
	 
	 public DiceRolling(){
		 _initialize();
	 }

	 // PRIVATE METHOD ++++++++++++++++++++++++++++
	private void _initialize() {
		this._number = 6;
		setDice1(random.nextInt(this._number)+1);
		setDice2(random.nextInt(this._number)+1);
		
	}

	// PROPERTIES +++++++++++++++++++++++++++

	

	public int getDice1() {
		return this._dice1;
	}

	public void setDice1(int dice) {
		this._dice1 = dice;
	}	
	
	public int getDice2() {
		return this._dice2;
	}

	public void setDice2(int dice) {
		this._dice2 = dice;
	}	
	
	 
	// PUBLIC METHODS ++++++++++++++++++++++++++++++

public int total(int number1, int number2){
	
	return number1+number2;
	
	}


public void diceProcess(int number){
	int [] totals = new int[number];
	this._diceArray1 = new int[number];
	this._diceArray2 = new int[number];
	for (int i = 0; i<number; i++){
		setDice1(random.nextInt(this._number)+1);
		

		
		this._diceArray1[i]=getDice1();
		

		setDice2(random.nextInt(this._number)+1);
		this._diceArray2[i]=getDice2();
		totals[i] = total(getDice1(),getDice2());	
		
	}
	
	frequency(totals,2,12);

	
	outputTotals();
	
	
	frequency(this._diceArray1,1,this._number);
	

	outputDice("Dice1");
		

frequency(this._diceArray2,1,this._number);


	
	outputDice("Dice2");
}

private void frequency(int[] dices, int num1, int num2){
	for (int l = 0; l<this._frequency.length; l++){
			this._frequency[l]=0;
		}
	
	for (int i = 0; i<=num2; i++){
	for (int j = 0; j<dices.length; j++ ){
		if (dices[j] == i+num1)
		this._frequency[i]++;
	}
}

}


public String toString(){
	return String.format("dice1 is %d and dice2 is %d.", getDice1(),getDice2());
}

public void outputTotals(){
	System.out.println("The sums are:");
	System.out.printf("%8s%s%n"," ","frequency");
	
	 			
     for (int row = 0; row<8; row++){
         	  System.out.printf("Total=%d%8d%n",row+2,this._frequency[row]);
     
          }
     for (int row = 8; row<11; row++){
    	  System.out.printf("Total=%d%7d%n",row+2,this._frequency[row]);

     }
}

public void outputDice(String dice){
			
	System.out.printf("The frequencies of %s is:%n",dice);
	System.out.printf("%10s%n",dice);
	
	 			
     for (int row = 0; row<6; row++){
         	  System.out.printf("%d%8d%n",row+1,this._frequency[row]);
     
          }
     
}
}


	

