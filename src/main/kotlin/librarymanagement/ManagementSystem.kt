package librarymanagement

import java.time.Duration

class ManagementSystem(private val library: Library, private val paymentSystem: PaymentSystem) {

    private val issues: MutableSet<Issue> = mutableSetOf()

    fun searchBook(name: String): Book? {
        return library.getAvailableBooks().firstOrNull { it.name == name }
    }

    fun borrow(user: User, book: Book): Boolean {
        library.markAsUnAvailable(book)
        issues.add(Issue(user.id, book.id))
        return true
    }

    fun returnBook(user: User, book: Book): Invoice {
        library.markAsAvailable(book)
        issues.remove(Issue(user.id, book.id))
        return paymentSystem.generateInvoice(Duration.ofHours(2), book.basePrice)
    }

}
