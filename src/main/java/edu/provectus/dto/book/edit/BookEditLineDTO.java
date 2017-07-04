package edu.provectus.dto.book.edit;

public class BookEditLineDTO {

    private int bookId;

    private String lineToEdit;

    public BookEditLineDTO() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getLineToEdit() {
        return lineToEdit;
    }

    public void setLineToEdit(String lineToEdit) {
        this.lineToEdit = lineToEdit;
    }
}
