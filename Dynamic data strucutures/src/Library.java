
public class Library {

	public static void main(String[] args) {
		BookList books = new BookList();
		
		books.insert(new Book("Danger on the Waters"));
		books.insert(new Book("Paradise Lost"));
		books.insert(new Book("Six of Crows"));
		books.insert(new Book("Crooked Kingdom"));

		System.out.println("Original List");
		System.out.println(books.toString());
		
		books.remove("Paradise Lost");
		
		System.out.println("New List");
		System.out.println(books.toString());
	}

}
