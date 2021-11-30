
public class BookList {
	private BookNode Head;
	
	
	BookList(){
		this.Head = null;
	}
	
	public String toString() {
		String result = "";
		
		BookNode current = Head;
		while (current != null) {
			result += current.book.getTitle();
			current = current.next;
		}
		return result;
	}
	
	void insert(Book b) {
		try {
			BookNode temp = new BookNode(b);
			
			BookNode current = Head;
			BookNode back = null;
			boolean found = false;
			
			if (Head == null) {
			    Head = temp;
			    found = true;
			}
			
			while(!found) {
				if (temp.book.getTitle().compareTo(current.book.getTitle())<0) {
				    if (current == Head){
				        temp.setNextNode(current);
				        found = true;
				        break;
				    }
				    temp.setNextNode(current);
				    back.setNextNode(temp);
					found = true;
				} else if (current.getNextNode() == null){
				    current.setNextNode(temp);
				    found = true;
				} else {
					back = current;
					current = back.getNextNode();
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	void remove(String title) {
		try {
			BookNode back = null;
			BookNode current = Head;
			boolean found = false;
			
			while(current != null && !found) {
				if(current.book.getTitle().compareToIgnoreCase(title) == 0) {
					found = true;
				} else {
					back = current;
					current = current.getNextNode();
				}
				if(found) {
					back.setNextNode(current.getNextNode());
					current.setNextNode(null);
				}
			} 
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
}
