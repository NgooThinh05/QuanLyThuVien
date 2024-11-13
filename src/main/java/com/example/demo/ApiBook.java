package com.example.demo;

import com.google.api.services.books.v1.Books;
import com.google.api.services.books.v1.model.Volumes;
import com.google.api.services.books.v1.model.Volume;
import com.google.api.services.books.v1.model.Volume.VolumeInfo;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class ApiBook {
    private static final String API_KEY = "AIzaSyBN2xmqGCs3si5pEX6222sKni2We-zWCi4";
    private List<Book> books;

    public static List<Book> searchbook(String searchQuery) throws IOException, GeneralSecurityException {
        List<Book> books = new ArrayList<>();

        Books booksApi = new Books.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),
                null)
                .setApplicationName("LibraryApp")
                .build();

        Books.Volumes.List volumesList = booksApi.volumes().list(searchQuery);
        volumesList.setKey(API_KEY); // Đặt API key vào đây

        Volumes volumes = volumesList.execute(); // Đối tượng trả về là kiểu com.google.api.services.books.v1.model.Volumes

        if (volumes.getItems() != null) {
            for (Volume volume : volumes.getItems()) {
                Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
                String isbn = volumeInfo.getIndustryIdentifiers() != null ? volumeInfo.getIndustryIdentifiers().get(0).getIdentifier() : "Unknown";
                String title = volumeInfo.getTitle();
                String author = volumeInfo.getAuthors() != null ? volumeInfo.getAuthors().get(0) : "Unknown";
                String category = volumeInfo.getCategories() != null ? volumeInfo.getCategories().get(0) : "Unknown";
                String description = volumeInfo.getDescription() != null ? volumeInfo.getDescription() : "No description available";
                String language = volumeInfo.getLanguage();
                String publisher = volumeInfo.getPublisher() != null ? volumeInfo.getPublisher() : "Unknown";
                String bookPath  = null;
                String image = volumeInfo.getImageLinks() != null ? volumeInfo.getImageLinks().getThumbnail() : null;
                String review = volumeInfo.getPreviewLink() != null ? volumeInfo.getPreviewLink() : "Unknown";

                Book book = new Book (isbn, title, author, publisher, category, description, language, image, review);
                books.add(book);
            }
        }

        return books;
    }
}
