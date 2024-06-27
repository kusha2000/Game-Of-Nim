import java.util.Scanner;
public class GameOfNim{
	Scanner sc=new Scanner(System.in);
	int player;
	int player01=1;
	int player02=2;
	int currentPlayer;
	String NumberOfSticks;
	int NumberOfSticksInt;
	String player1;
	String player2;
	String p1;
	String p2;
	String firstPlayer;
	String secondPlayer;
	String totalStick;
	int totalStickInt;
	String stickValue;
	int stickValueInt;
	String winner;

	public static void main(String[] args) {
		GameOfNim gon=new GameOfNim();
		gon.menu();
	}
	public void firstPlayer(){
			System.out.println();
			System.out.print("Enter the name of player 1:");
			player1=sc.next();
			System.out.print("Enter the name of player 2:");
			player2=sc.next();
			System.out.println();
			System.out.println(player1+" You can start the game:");
			System.out.println("--------------------------------------------");
			while(true){
				System.out.print(player1+" You can decide who can start the game first(enter the name):");
				firstPlayer=sc.next();
				if(firstPlayer.equals(player1) || firstPlayer.equals(player2) ){
					//System.out.print("Correct");
					break;
				}else{
					System.out.println("|-----Please enter correct name("+ player1+" or "+player2+")-----|");
				}
			}
	}//end of FirstPalyer()
	public void howManySticks(){
		if(firstPlayer.equals(player1)){
				while(true){
					System.out.print(player2+" You can decide, How many sticks can we use to the game(20-30):");
					NumberOfSticks=sc.next();
					try{
						NumberOfSticksInt=Integer.parseInt(NumberOfSticks);  
						if(NumberOfSticksInt<=30 && NumberOfSticksInt>=20){
							break;
						}else{
							System.out.println("|-----Please enter correct value(20-30)-----|");
						}
					}catch(Exception e){
						System.out.println("|-----Please enter correct Integer value(20-30)-----|");
					}
					
				}
			}else{
				while(true){
					System.out.print(player1+" You can decide, How many sticks can we use to the game(20-30):");
					NumberOfSticks=sc.next();
					try{
						NumberOfSticksInt=Integer.parseInt(NumberOfSticks);  
						if(NumberOfSticksInt<=30 && NumberOfSticksInt>=20){
							break;
						}else{
							System.out.println("|-----Please enter correct value(20-30)-----|");
						}
					}catch(Exception e){
						System.out.println("|-----Please enter correct Integer value(20-30)-----|");
					}
					
				}
			}//end of if
	}//end of HowManySticks()
	public void play(){
		System.out.println();
		System.out.println("|---------------------Game Details------------------------------|");
		System.out.println("|                                                               |");
		System.out.println("|Players\t\t\t:"+player1+" and "+player2+"\t\t\t\t\t\t\t|");
		System.out.println("|First Player\t\t:"+firstPlayer+"\t\t\t\t\t\t\t\t\t\t|");
		System.out.println("|Number of stick\t:"+NumberOfSticks+"\t\t\t\t\t\t\t\t\t\t\t|");
		System.out.println("|                                                               |");
		System.out.println("|---------------------Let's Play--------------------------------|");
		/*System.out.print("Sticks-->"+NumberOfSticksInt+":");
		for(int i=1;i<=NumberOfSticksInt;i++){
			System.out.print(" | ");
		}*/
		System.out.println();
		System.out.print("|-------------Please get 1-3 stick only-----------------|");
		System.out.println();
		totalStickInt=NumberOfSticksInt;
		if(firstPlayer.equals(player1)){
			currentPlayer=0;
			secondPlayer=player2;
		}else{
			currentPlayer=0;
			secondPlayer=player1;
		}
		System.out.println();
			System.out.print("Sticks -->"+totalStickInt+":");
			for(int i=1;i<=totalStickInt;i++){
				System.out.print(" | ");
			}
		while(totalStickInt>1){//play-while 1
			
			while(true){//play-while 2
				try{
					System.out.println();
					System.out.println();
					
					if(currentPlayer==0){
						System.out.print(firstPlayer+" Plese enter the value of stick do you want(1-3):");
						stickValue=sc.next();
						stickValueInt=Integer.parseInt(stickValue);
						if(stickValueInt>=1 && stickValueInt<=3){
							System.out.println(stickValueInt);
							currentPlayer=currentPlayer+1;
							break;
						}else{
							System.out.println("|------Please enter the Correct Value(1-3)--------|");
						}
						
					}else{
						System.out.print(secondPlayer+" Plese enter the value of stick do you want(1-3):");
						stickValue=sc.next();
						stickValueInt=Integer.parseInt(stickValue);
						if(stickValueInt>=1 && stickValueInt<=3){
							//System.out.println(stickValueInt);
							currentPlayer=currentPlayer-1;
							break;
						}else{
							System.out.println("|------Please enter the Correct Value(1-3)--------|");
						}
						
					}
					
				}catch(Exception e){
					System.out.println("|------Please enter the Correct Integer Value(1-3)--------|");
				}
			}//play-end while 2
			totalStickInt=totalStickInt-stickValueInt;
			System.out.println();
			System.out.print("Sticks left-->"+totalStickInt+":");
			for(int i=1;i<=totalStickInt;i++){
				System.out.print(" | ");
			}

			if(totalStickInt<=1){
				//System.out.println("Current Player"+currentPlayer);
				if(currentPlayer==0){
					winner=secondPlayer;
				}else{
					winner=firstPlayer;
				}
				break;

			}
			

		}//play-end while 1
		System.out.println();
		System.out.println("|+-------------Game Over--------------+|");
		System.out.println("Winner is:"+winner);
		System.out.println("Contragulations "+winner);
		System.out.println("Thank you for play with us");
		System.out.println("|+----------------End-----------------+|");




	}
	public void menu(){
		System.out.println("\t|-------------|");
		System.out.println("\t|+Game of Nim+|");
		System.out.println("\t|-------------|");
		

		while(true){//while 1
			System.out.println("+-----------------------+");
			System.out.println("|       Main Menu       |");
			System.out.println("+-----------------------+");
			System.out.println("| 1.To Play Nim         |");
			System.out.println("| 2.How to Play Nim     |");
			System.out.println("| 3.Exit                |");
			System.out.println("+-----------------------+");
			while(true){//while 1
				System.out.print("Enter Your Choice(1-3):");
				String choice=sc.next();
				try{
					int choiceInt=Integer.parseInt(choice);
					if(choiceInt==1){
						GameOfNim gon=new GameOfNim();
						gon.firstPlayer();
						gon.howManySticks();
						gon.play();
						System.out.println();
						System.out.print("Press any key to go to the main menu:");
						String press=sc.next();
						System.out.println();
						break;
					}else if(choiceInt==2){
						System.out.println();
						System.out.println("\t*Imagine that there are 20 - 30 toothpicks to choose from."); 
						System.out.println("\t*Players in turn can pick 1, 2, or 3 toothpicks at a time.");
						System.out.println("\t*This process repeats, alternating between players.");
						System.out.println("\t*A and B, until there are no more toothpicks left."); 
						System.out.println("\t*The player who removes the last toothpick is the loser.");
						System.out.println("\t*Player A decide who play first."); 
						System.out.println("\t*Player B choose the number of tooth picks to play with..");
						System.out.println();
						System.out.print("Press any key to go to the main menu:");
						String press=sc.next();
						System.out.println();
						break;
					}else if(choiceInt==3){
						System.exit(0);
					}else{
						System.out.println("|+=--Plese enter correct value(1-3)---+|");
					}
			}catch(Exception e){
				System.out.println("|+=--Plese enter correct integer value(1-3)---+|");
			}

			}//end of while 2
		}// end of while 1
	}
}