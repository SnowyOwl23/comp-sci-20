
public class BookList {
	private BookNode list;
	private BookNode current;
	
	BookList(){
		list = null;
	}
	
	public String toString() {
		String result = "";
		
		BookNode current = list;
		while (current != null) {
			result += current.book.getTitle();
			current = current.next;
		}
		return result;
	}
	
	void insert(Book b) {
		try {
			BookNode temp = new BookNode(b);
			
			BookNode current = list;
			BookNode back = null;
			boolean found = false;
			
			while(current != null && !found) {
				if (temp.book.getTitle().compareTo(current.book.getTitle())<0) {
					found = true;
				} else {
					back = current;
					current = current.getNextNode();
				}
				
				temp.setNode(current);
				
				if (back == null) {
					list = temp;
				} else {
					back.setNode(temp);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	void remove(String title) {
		try {
			BookNode back = null;
			current = list;
			boolean found = false;
			
			while(current != null && !found) {
				if(current.book.getTitle().compareToIgnoreCase(title) == 0) {
					found = true;
				} else {
					back = current;
					current = current.getNextNode();
				}
				if(found) {
					back.setNode(current.getNextNode());
					current.setNode(null);
				}
			} 
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
}
