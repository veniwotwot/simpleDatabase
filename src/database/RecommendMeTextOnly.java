package database;

import java.util.List;
import javax.sql.DataSource;
import testing.datasourceManager;
import database.entity.Book;
import database.entity.Tag;
import database.services.BookService;
import database.services.TagService;
import database.services.impl.BookServiceImpl;
import database.services.impl.TagServiceImpl;

public class RecommendMeTextOnly {

	public static void main(String[] args) throws Exception {

		// Setup
		DataSource datasource = datasourceManager.getDataSource();
		BookService bookService = new BookServiceImpl(datasource);
		TagService tagService = new TagServiceImpl(datasource);

		System.out.println("");
		// Case one: Attempt to retrieve book. Return from Try = Book found. Return from
		// Catch = Book not found.
		try {
			Book result = new Book();
			result = bookService.retrieve(9999);
			System.out.println("We found your book!");
			System.out.println("Book title: " + result.getTitle());
			System.out.println("Book author: " + result.getAuthor());
			System.out.println("Book id: " + result.getId());
			System.out.println("Book description: " + result.getDescription());
		} catch (Exception e) {
			System.out.println("We could not find a book with that id. Did you make a mistake?");
		}

		System.out.println("");
		// Case two: Create new book entity
		Book insert = buildBook();
		try {
			insert = bookService.create(insert);
			System.out.println("Your book has been created!");
			System.out.println("Book title: " + insert.getTitle());
			System.out.println("Book author: " + insert.getAuthor());
			System.out.println("Book id: " + insert.getId());
			System.out.println("Book description: " + insert.getDescription());
		} catch (Exception e) {
			System.out.println("Your book could not be created. Book.id should be 0 before creating.");
		}

		System.out.println("");
		// Case three: Create new book entity using different method
		Book insert2 = new Book(0, "New Book", "Vincent Wong", "Book Description");
		try {
			insert2 = bookService.create(insert2);
			System.out.println("Your book has been created!");
			System.out.println("Book title: " + insert2.getTitle());
			System.out.println("Book author: " + insert2.getAuthor());
			System.out.println("Book id: " + insert2.getId());
			System.out.println("Book description: " + insert2.getDescription());
		} catch (Exception e) {
			System.out.println("Your book could not be created. Check to see if it had a zero id before inserting");
		}

		System.out.println("");
		// Case three-B: Create tags for the book in question
		int id = insert2.getId();
		Tag tag1 = new Tag(0, "Book", id, "Support");
		Tag tag2 = new Tag(0, "Book", id, "Reference");
		try {
			tag1 = tagService.create(tag1);
			tag2 = tagService.create(tag2);

			System.out.println("Your tag has been created!");
			System.out.println("Your tag id is: "+tag1.getId());
			System.out.println("You tag is connected to: " + tag1.getCategoryName() + " " + tag1.getCategoryId());
			System.out.println("Tag description: " + tag1.getDescription());

			System.out.println("Your tag has been created!");
			System.out.println("Your tag id is: "+tag1.getId());
			System.out.println("You tag is connected to: " + tag2.getCategoryName() + " " + tag2.getCategoryId());
			System.out.println("Tag description: " + tag2.getDescription());
		} catch (Exception e) {
			System.out.println("Your tag(s) could not be created. Check to see if it had a zero id before inserting");
		}

		System.out.println("");
		// Case four: Retrieve Book by Title
		String title = "New Book";
		try {
			List<Book> b2 = bookService.retrieveByTitle(title);

			System.out.println("Your search by title for: " + title + " yielded " + b2.size() + " results.");
			System.out.println("Your results were:");

			for (Book bk : b2) {
				System.out.println("Book title: " + bk.getTitle());
				System.out.println("Book author: " + bk.getAuthor());
				System.out.println("Book id: " + bk.getId());
				System.out.println("Book description: " + bk.getDescription());
			}
		} catch (Exception e) {
			System.out.println("There was an unexpected error in Search By Title: " + title);
		}

		System.out.println("");
		// Case five: Retrieve Book by Author
		String author = "Vincent Wong";
		try {
			List<Book> b2 = bookService.retrieveByAuthor(author);

			System.out.println("Your search by author for: " + author + " yielded " + b2.size() + " results.");
			System.out.println("Your results were:");

			for (Book bk : b2) {
				System.out.println("Book title: " + bk.getTitle());
				System.out.println("Book author: " + bk.getAuthor());
				System.out.println("Book id: " + bk.getId());
				System.out.println("Book description: " + bk.getDescription());
			}
		} catch (Exception e) {
			System.out.println("There was an unexpected error in Search By Author: " + author);
		}

		System.out.println("");
		// Case six: Retrieve Book by Tag
		String tagName = "Support";
		try {
			List<Book> b2 = bookService.retrieveByTagName(tagName);

			System.out.println("Your search by Tag for: " + tagName + " yielded " + b2.size() + " results.");
			System.out.println("Your results were:");

			for (Book bk : b2) {
				System.out.println("Book title: " + bk.getTitle());
				System.out.println("Book author: " + bk.getAuthor());
				System.out.println("Book id: " + bk.getId());
				System.out.println("Book description: " + bk.getDescription());
			}
		} catch (Exception e) {
			System.out.println("There was an unexpected error in Search By Tag: " + tagName);
		}

		System.out.println("");
		// Case seven: Update book (Uses BookID From Case 3)
		insert2.setTitle("New Book vol 2");
		insert2.setDescription("New Description for an updated book!");
		try {
			bookService.update(insert2);
			System.out.println("Your book has been updated!");
			System.out.println("Book title: " + insert2.getTitle());
			System.out.println("Book author: " + insert2.getAuthor());
			System.out.println("Book id: " + insert2.getId());
			System.out.println("Book description: " + insert2.getDescription());
		} catch (Exception e) {
			System.out.println("Your book could not be updated. Looks like something went wrong.");
		}

		System.out.println("");
		// Case eight: Delete Book and Tags (Deletes the book and tag from above cases)
		id = insert2.getId();
		int id2 = insert.getId();
		try {
			bookService.delete(id);
			bookService.delete(id2);
			System.out.println("Your books have been deleted!");
		} catch (Exception e) {
			System.out.println("Your book could not be deleted. Looks like something went wrong.");
		}
	}

	private static Book buildBook() {
		Book result = new Book();
		result.setTitle("Example Book");
		result.setAuthor("Vincent Wong");
		result.setDescription("Ever needed to write your own book to test your program with?");
		return result;
	}

}
