import java.util.ArrayList;

class Library {
  public ArrayList<Book> books = new ArrayList<Book>();
  private ArrayList<Book> borrowedBooks = new ArrayList<Book>();
  public ArrayList<Member> members = new ArrayList<Member>();

  public void addMember(Member member) {
    
    this.members.add(member);
  }

  public void addBook(Book book) {
    this.books.add(book);
  }

  public void giveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);
    if (book == null) {
      System.out.println("Buku tidak ditemukan");
    } else {
    this.borrowedBooks.add(book);
    this.books.remove(book);
    }

    Member member = this.getMemberById(memberId);
    if (member == null) {
      System.out.println("Member tidak ditemukan");
    } else {
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.add(book);
  }
}

public void receiveBook(String bookId, String memberId) {
    Book borrowedBook = this.getBorrowedBookById(bookId);
    if (borrowedBook == null) {
      System.out.println("Buku tidak ditemukan");
    } else {
      this.books.add(borrowedBook);
    this.borrowedBooks.remove(borrowedBook);
    }
    
    

    Member member = this.getMemberById(memberId);
    if (member == null) {
      System.out.println("Member tidak ditemukan");
    } else {
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.remove(borrowedBook);
  }
}

private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id) {
    for (Book book : this.books) {
        if (book.id.equals(id)) {
          return book;
        }
      }
    return null;
  }

  private Book getBorrowedBookById(String id) {
    for (Book borrowedBook : this.borrowedBooks) {
        if (borrowedBook.id.equals(id)) {
          return borrowedBook;
        }
      }
    return null;
  }
}