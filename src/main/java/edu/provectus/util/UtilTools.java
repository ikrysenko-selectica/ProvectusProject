package edu.provectus.util;

import edu.provectus.dto.book.ShortBookInfoDTO;
import edu.provectus.model.Author;
import edu.provectus.model.Book;
import edu.provectus.model.Genre;

import java.util.ArrayList;
import java.util.List;

public class UtilTools {

    public static List<String> extractAuthorsNames(List<Author> authors) {
        List<String> authorsNames = new ArrayList<>();
        authors.forEach(author -> authorsNames.add(author.getName()));
        return authorsNames;
    }

    public static List<String> extractGenresNames(List<Genre> genres) {
        List<String> genresNames = new ArrayList<>();
        genres.forEach(genre -> genresNames.add(genre.getName()));
        return genresNames;
    }

    public static List<ShortBookInfoDTO> convertBooksToBooksInfo(List<Book> books) {
        List<ShortBookInfoDTO> listOfBooksInfo = new ArrayList<>();
        books.forEach(book -> listOfBooksInfo.add(new ShortBookInfoDTO(
                        book.getId(),
                        book.getTitle(),
                        convertListOfAuthorsToSingleAuthorsString(book.getAuthors()),
                        book.getPrice()
                ))
        );
        return listOfBooksInfo;
    }

    private static String convertListOfAuthorsToSingleAuthorsString(List<Author> authors) {
        StringBuilder allBooksAuthorsName = new StringBuilder();
        authors.forEach(author -> allBooksAuthorsName.append(author.getName()).append(", "));
        return allBooksAuthorsName.toString();
    }

}
