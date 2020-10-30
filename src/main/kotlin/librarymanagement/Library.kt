package librarymanagement


class Library {

    private val availableBooks: MutableMap<Book, Boolean> = mutableMapOf()

    fun add(book: Book) {
        availableBooks[book] = true
    }

    fun getAvailableBooks(): List<Book> {
        return availableBooks.filter { it.value }.map { it.key }.toList()
    }

    fun markAsUnAvailable(book: Book) {
        availableBooks[book] = false
    }

    fun markAsAvailable(book: Book) {
        availableBooks[book] = true
    }

}
