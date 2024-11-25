package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.BootStrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static mk.ukim.finki.wp.lab.BootStrap.DataHolder.SONGS;

@Repository
public class SongRepository {


    public List<Song> findAll() {

        return SONGS;
    }

    public Optional<Song> findByTrackID(String trackId) {
        return Optional.ofNullable(SONGS.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null));
    }

    public Optional<Song> findById(Long id) {
        return SONGS.stream()
                .filter(song -> song.getId().equals(id))
                .findFirst();
    }

    public void deleteSong(Long id) {
        SONGS.removeIf(song -> song.getId().equals(id));
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        for(Song s: SONGS) {
            if(s.getTrackId().equals(song.getTrackId())){
                s.getPerformers().add(artist);
                return artist;
            }
        }

        return null;
    }

    public Song save(Song song) {
        if(song.getAlbum() == null) {
            throw new IllegalArgumentException();
        }

        SONGS.removeIf(s -> s.getId().equals(song.getId()));
        SONGS.add(song);

        return song;
    }
}
