package dao;

import entity.Artist;
import entity.Song;
import entity.User;

import java.util.*;

public class MusicLibraryInventoryImpl {
    private Map<Long, User> users;
    private Map<Long, Artist> artists;
    private Map<Long, Song> songs;
    private Map<Long, List<Long>> userSongHistory;

    public MusicLibraryInventoryImpl() {
        this.users = new HashMap<>();
        this.artists = new HashMap<>();
        this.songs = new HashMap<>();
        this.userSongHistory = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }
    public void addArtist(Artist artist) {
        artists.put(artist.getId(), artist);
    }

    public void addSong(Song song) {
        songs.put(song.getId(), song);
    }

    public Artist getArtistById(Long artistId) {
        return artists.get(artistId);
    }

    public User getUserById(Long userId) {
        return users.get(userId);
    }

    public Song getSongById(Long songId) {
        return songs.get(songId);
    }


    public void addSongToUserHistory(Long userId, List<Long> songId) {
        userSongHistory.put(userId,songId);
    }

    public List<Long> getUserLitsenHistory(Long userId){
        return userSongHistory.get(userId);
    }

    public List<Song> getAllSongs(){
        List<Song> songList = new ArrayList<>();
        for(Song s : songs.values()){
            songList.add(s);
        }
        return songList;
    }

    public Map<Long, Artist> getAllArtists() {
        return artists;
    }
}
