import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		inputRead();
	}

	public static void inputRead() throws IOException{
		try{
			BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
			boolean check=false;
			Deck myDeck=new Deck();
			while(true){
				System.out.println("\nThere are 5 available operations:"
						+ "\n1- To create the deck write: createDeck*filename.txt,"
						+ "\n2- To mergeSort the deck write: mergeSort,"
						+ "\n3- To quickSort the deck write: quickSort,"
						+ "\n4- To print the deck write: printDeck"
						+ "\n5- To exit write: Terminate");
				String str=rd.readLine();
				if(str.length()>8){
					if(str.toLowerCase().equals("mergesort")){
						if(check){
							myDeck.mergeSort();
						}else{
							System.out.println("FIRST, you have to create a deck from an input.txt to mergeSort it.");
						}
					}else if(str.toLowerCase().equals("quicksort")){
						if(check){
							myDeck.quickSort();
						}else{
							System.out.println("FIRST, you have to create a deck from an input.txt to quickSort it.");
						}
					}else if(str.toLowerCase().equals("printdeck")){
						if(check){
							myDeck.printDeck();
						}else{
							System.out.println("FIRST, you have to create a deck from an input.txt to print it.");
						}
					}else if(str.toLowerCase().equals("terminate")){
						System.out.println("Terminated!");
						break;
					}else if(str.substring(0, 9).toLowerCase().equals("createdec")){
						myDeck.createDeck(str.substring(11));
						check=true;
					}else{
						System.out.println("Please enter a valid command from the description below.");
					}
				}else{
					System.out.println("Please enter a valid command from the description below.");
				}
			}
			rd.close();

		}catch(IOException e){
			System.out.println("Input Stream Read Error.");
		}

	}

}
