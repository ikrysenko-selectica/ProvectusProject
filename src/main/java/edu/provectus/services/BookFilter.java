package edu.provectus.services;

import edu.provectus.dto.book.FullBookInfoDTO;

import java.util.List;

public interface BookFilter {

    public List<FullBookInfoDTO> getBooks();

    public List<FullBookInfoDTO> getBooksByGenre(String genre);

    public List<FullBookInfoDTO> getBooksByAuthor(String author);

    public FullBookInfoDTO getBookFullInfo(int bookId);

}
