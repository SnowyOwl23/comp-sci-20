
public class BookNode {
	Book book;
	BookNode next;
	
	BookNode(Book b){
		book = b;
		next = null;
	}
	
	Book getBook() {return book;}
	
	BookNode getNextNode() {return next;}
	
	void setNode(BookNode b) {next = b;}
}
