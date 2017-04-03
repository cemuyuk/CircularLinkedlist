
public class CircularlyLinkedList{

	private Card tail;
	private int size;
	
	public CircularlyLinkedList() {
		// TODO Auto-generated constructor stub
		tail=null;
		size=0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}

	public Card last(){
		if(isEmpty()) return null;
		return tail;
	}
	
	public Card search(Card c){
		if(size==0) return null;
		Card temp=this.head();
		if(temp==c) return temp;
		temp=temp.getNext();
		while(temp!=this.head()){
			if(temp==c) return temp;
			temp=temp.getNext();
		}
		return null;
	}
	
	
	public void addFirst(Card c){
		if(size==0){
			tail=c;
			tail.setNext(tail);
		}else{
			c.setNext(tail.getNext());
			tail.setNext(c);
		}
		size++;
	}
	
	public void addLast(Card c){
		addFirst(c);
		tail=tail.getNext();
	}
	
	public Card removeFirst(){
		if(isEmpty()) return null;
		Card head=tail.getNext();
		if(head==tail) tail=null;
		else tail.setNext(head.getNext());
		size--;
		return head;
	}
	
	public Card head(){
		if(tail==null)return tail;
		return tail.getNext();
	}
	
	public Card tail(){
		return tail;
	}
	
	public String printTheList(){
		Card temp=this.head();
		if(temp==null) return null;
		String t="";
		if(temp.getSuit()==1)
			t="S|";
		else if(temp.getSuit()==2)
			t="H|";
		else if(temp.getSuit()==3)
			t="C|";
		else 
			t="D|";
		
		if(temp==tail)
			t=t+temp.getRank();
		else
			t=t+temp.getRank()+"-> ";
		
		temp=temp.getNext();
		while(temp!=this.head()){
			if(temp.getSuit()==1)
				t=t+"S|";
			else if(temp.getSuit()==2)
				t=t+"H|";
			else if(temp.getSuit()==3)
				t=t+"C|";
			else 
				t=t+"D|";
			if(temp==tail)
				t=t+temp.getRank();
			else
				t=t+temp.getRank()+"-> ";
			temp=temp.getNext();
		}
		return t;
	}
}
