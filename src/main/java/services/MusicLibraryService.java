package services;

import entity.Song;

import java.util.LinkedHashMap;
import java.util.List;

public interface MusicLibraryService {

    void registerUser(String firstName, String lastName, Long phoneNumber,
                      String email, String city, String locality,
                      String state, Long pinCode);
    void registerArtist(String firstName, String lastName);
    void releaseSong(String title, String genre, String releaseYear, String language, Long artistId);
    void playSong(Long userId, Long songId);
    void getTopTenForSpecificUser(Long userId);
    void getTopTenOverall();
    void getAllSongsOfAnArtist(Long artistId);

    void getAllArtists();
}
