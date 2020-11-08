package Books

import kotlin.math.roundToInt
import kotlin.random.Random

const val maxBooksPerPerson = 5;

object Constants {
    const val BASE_URL = "https://library"
}

open class Book (val title: String, val author: String, var totalPages: Int) {
    private var page: Int = 0;
    var numberOfBooksBorrowed: Int = 0;
    open fun readPage() {
        page += 1;
    }
    fun canBorrow () = when {
        numberOfBooksBorrowed >= maxBooksPerPerson -> false
        else -> true
    }
    companion object {
        const val BASE_URL = "https://library2"
    }
    fun printUrl () = println("${BASE_URL}.${title}.html")

}

fun Book.totalWeight () = totalPages * 1.5;
fun Book.tornPages (pagesToTorn: Int): Int {
    totalPages -= pagesToTorn;
    return totalPages;
}

class Puppy {
    fun playWithBook(book: Book) {
        if (book.totalPages == 1) {
            book.tornPages(1);
        } else {
            book.tornPages(Random.nextInt(1, book.totalPages));
        }
    }
}

class eBook(title: String, author: String, var format: String = "text"): Book(title, author, 200) {
    private var word: Int = 0;
    override fun readPage() {
        word += 250;
    }
}

class BasicBook(val title: String, val author: String, val year: Int) {
    fun getTitleAndAuthor(): Pair<String, String> {
        return title to author
    }

    fun getTitleAndAuthorAndYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

fun main(args: Array<String>) {
    val book = BasicBook("Secret d'histoire", "Stephane Bern", 2014);
    val (title, author) = book.getTitleAndAuthor();
    println("The book ${title} is written by ${author}");
    val allBook = book.getTitleAndAuthorAndYear();
    println("The book ${allBook.first} is written by ${allBook.second} in ${allBook.third}");

    val book1 = BasicBook("Secret d'histoire 1", "Stephane Bern", 2014);
    val book2 = BasicBook("Secret d'histoire 2", "Stephane Bern", 2016);
    val book3 = BasicBook("Secret d'histoire 3", "Stephane Bern", 2019);
    val allBooks = setOf(book1.title, book2.title, book3.title);
    val library = mapOf("Stephane Bern" to allBooks)
    println(library.any{it.value.contains("Secret d'histoire 1")})
    val moreBooks = mutableMapOf("Stephane Bern" to "Secret d'histoire 4");
    moreBooks.put("JK Rolling", "Harry Potter")
    moreBooks.getOrPut("JK Rolling") {"Harry Potter"}
    println(moreBooks)

    val book4 = Book("Les miserables", "Victor Hugo", 250);
    book4.printUrl();
    book4.totalWeight();

    val puppy = Puppy();
    println(book4.totalPages);
    while(book4.totalWeight() > 0) {
        puppy.playWithBook((book4));
        println(book4.totalPages);
    }
    println(book4.totalPages);
}