import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Deck {

	private CircularlyLinkedList cards;
	public Deck() {
		// TODO Auto-generated constructor stub
		cards=new CircularlyLinkedList();
	}
	
	//Reads input file and fills the circularly linked list of cards that is a field of this class.
	public void createDeck(String inputFile){
		try {
			if(!cards.isEmpty()){
				while(cards.size()!=0)
					cards.removeFirst();
			}
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			String str;
			str = in.readLine();
			String[] values=str.split("\\W+");
			Card temp=new Card(values[0], Integer.parseInt(values[1]));
			cards.addLast(temp);
			while ((str = in.readLine()) != null) {	
				values =str.split("\\W+");
				temp=new Card(values[0], Integer.parseInt(values[1]));
				cards.addLast(temp);
			}
			System.out.println("The file has been read without any error and the deck has been created from "
					+inputFile+".");
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
	}

	//Calls the merge sort helper method.
	public void mergeSort(){
		System.out.println("\nMERGE SORT:");
		System.out.println("Wisdom gotten from age is better than the shell of a tortoise. "
				+ "\nJapanese idiom.");
		System.out.println("\nInitial Unsorted Deck:");
		printDeck();
		System.out.println("\nMergeSort started:");
		
		mergeSortHelper(cards);
		
		System.out.println("\nFinally merged:"+cards.printTheList());
	}

	//Auxilary method for merge sort.
	private void mergeSortHelper(CircularlyLinkedList c){
		int size=c.size();
		if(size<2) return;
		CircularlyLinkedList CLL1=new CircularlyLinkedList();
		CircularlyLinkedList CLL2=new CircularlyLinkedList();

		while(CLL1.size()<size/2)
			CLL1.addLast(c.removeFirst());
		while(!c.isEmpty())
			CLL2.addLast(c.removeFirst());
		mergeSortHelper(CLL1);
		mergeSortHelper(CLL2);
		merge(CLL1,CLL2, c);
	}

	private void merge(CircularlyLinkedList CLL1, CircularlyLinkedList CLL2, CircularlyLinkedList c){
		System.out.println("\nLeft Partition: "+CLL1.printTheList());
		System.out.println("Right Partition: "+CLL2.printTheList());
		while(!CLL1.isEmpty() && !CLL2.isEmpty()){
			if(CLL1.head().getSuit()<CLL2.head().getSuit()){
				c.addLast(CLL1.removeFirst());
			}else if(CLL1.head().getSuit()==CLL2.head().getSuit()){
				if(CLL1.head().getRank()<CLL2.head().getRank()){
					c.addLast(CLL1.removeFirst());
				}else{
					c.addLast(CLL2.removeFirst());
				}
			}else{
				c.addLast(CLL2.removeFirst());
			}
		}

		while(!CLL1.isEmpty())
			c.addLast(CLL1.removeFirst());
		while(!CLL2.isEmpty())
			c.addLast(CLL2.removeFirst());

		System.out.println("Left and Right merged: "+c.printTheList());
	}

	//Calls the helper method
	public void quickSort(){
		System.out.println("\nQUICK SORT:");
		System.out.println("Dunyada kusursuz iki insan vardir. Biri olmustur, digeri dogmamistir. "
				+ "\nCin atasozu.");
		System.out.println("\nInitial Unsorted Deck:");
		printDeck();
		System.out.println("\nQuickSort started:");
		System.out.println("Recursively quicksorting the list above:");
		
		quickSortHelper(cards);
		
		System.out.println("\nFinally quick-sorted:"+cards.printTheList());
	}
	
	//Auxilary method for merge sort.
	private void quickSortHelper(CircularlyLinkedList c){

		if(c.size()<2) return;
		Card tailAsPivot=c.tail();
		CircularlyLinkedList less=new CircularlyLinkedList();
		CircularlyLinkedList equal=new CircularlyLinkedList();
		CircularlyLinkedList greater=new CircularlyLinkedList();

		while(!c.isEmpty()){
			Card temp=c.removeFirst();
			if(temp.getSuit()<tailAsPivot.getSuit()){
				less.addLast(temp);
			}else if(temp.getSuit()==tailAsPivot.getSuit()){
				if(temp.getRank()<tailAsPivot.getRank()){
					less.addLast(temp);
				}else if(temp.getRank()>tailAsPivot.getRank()){
					greater.addLast(temp);
				}else{
					equal.addLast(temp);
				}
			}else{
				greater.addLast(temp);
			}
		}
		System.out.println("\n");
		if(tailAsPivot.getSuit()==1)
			System.out.println("Pivot: S|"+tailAsPivot.getRank());
		else if(tailAsPivot.getSuit()==2)
			System.out.println("Pivot: H|"+tailAsPivot.getRank());
		else if(tailAsPivot.getSuit()==3)
			System.out.println("Pivot: C|"+tailAsPivot.getRank());
		else
			System.out.println("Pivot: D|"+tailAsPivot.getRank());
		System.out.println("Less:"+less.printTheList());
		System.out.println("Equal:"+equal.printTheList());
		System.out.println("Greater:"+greater.printTheList());
		
		quickSortHelper(less);
		quickSortHelper(greater);


		while(!less.isEmpty())
			c.addLast(less.removeFirst());
		while(!equal.isEmpty())
			c.addLast(equal.removeFirst());
		while(!greater.isEmpty())
			c.addLast(greater.removeFirst());
	}


	//Calls the print method of circularly linked list of this class called cards.
	public void printDeck(){
		System.out.println(cards.printTheList());
	}

	public int size(){
		return cards.size();
	}

	// TEST METHODS
	public void add(Card c){
		cards.addLast(c);
	}

	public CircularlyLinkedList getCards() {
		return cards;
	}

	public void setCards(CircularlyLinkedList cards) {
		this.cards = cards;
	}

}
