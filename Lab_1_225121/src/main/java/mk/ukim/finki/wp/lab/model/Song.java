package mk.ukim.finki.wp.lab.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Song {
    private Long id;
    private String trackId;

    private String title;
    private String genre;
    private int releaseYear;

    private List<Artist> performers;
    private Album album;

    public Song(String trackId,
                String title,
                String genre,
                int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.id = new Random().nextLong(10000);
    }

    public Song(String trackId,
                String title,
                String genre,
                int releaseYear,Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.id = new Random().nextLong(10000);
        this.album = album;
    }

    public void addPerformer(Artist artist) {
        this.performers.add(artist);
    }
}
