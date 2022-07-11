package services;

import dao.MusicLibraryInventoryImpl;
import entity.*;
import java.util.Map.Entry;
import java.util.*;

public class MusicLibraryServiceImpl implements MusicLibraryService{
    private MusicLibraryInventoryImpl inventory;

    public MusicLibraryServiceImpl() {
        this.inventory = new MusicLibraryInventoryImpl();
    }


    @Override
    public void registerUser(String firstName, String lastName, Long phoneNumber, String email, String city, String locality, String state, Long pinCode) {
        Contact contact = new Contact(email,phoneNumber);
        Address address = new Address(city, locality,state,pinCode);
        User user = new User(firstName,lastName,contact,address);
        inventory.addUser(user);
        System.out.println("User Added :"+ user.getId() +" : "+user.getFirstName()+" "+user.getLastName());

    }

    @Override
    public void registerArtist(String firstName, String lastName) {
        Artist artist = new Artist(firstName,lastName);
        inventory.addArtist(artist);
        System.out.println("Artist Added :"+ artist.getId() +" : "+artist.getFirstName()+" "+artist.getLastName());
    }

    @Override
    public void releaseSong(String title, String genre, String releaseYear, String language, Long artistId) {
        Song song = new Song(title,genre,releaseYear,language);
        Artist artist = inventory.getArtistById(artistId);
        artist.addSong(song);
        inventory.addSong(song);
        System.out.println("Song Added "+song.getTitle());
        System.out.println("Artist "+artist.getId()+". "+artist.getFirstName()+" "+artist.getLastName());
    }

    @Override
    public void playSong(Long userId, Long songId) {
        Song song = inventory.getSongById(songId);
        User user = inventory.getUserById(userId);
        List<Long> songsLitsened = new ArrayList<>();
        if(user==null){
            System.out.println("User Not Found By this ID");
            return;
        }
        if(song==null){
            System.out.println("Song Not Found By this ID");
            return;
        }
        song.litsen();
        songsLitsened.add(songId);
        inventory.addSongToUserHistory(userId, songsLitsened);
        System.out.println(inventory.getUserById(userId).getFirstName()+" "
                +inventory.getUserById(userId).getLastName()
                +" listening to "+inventory.getSongById(songId).getTitle()
                +", Sung by "+inventory.getArtistById(inventory.getSongById(songId).getArtistId()).getFirstName()
                +" "+inventory.getArtistById(inventory.getSongById(songId).getArtistId()).getLastName());

    }

    @Override
    public void getTopTenForSpecificUser(Long userId) {
        List<Long> songIds = inventory.getUserLitsenHistory(userId);
        List<Song> songList = new ArrayList<>();
        for(Long id : songIds){
            songList.add(inventory.getSongById(id));
        }

        songList.sort(Comparator.comparing(
                Song::getTotalListens, Comparator.reverseOrder()));
        for (Song s: songList) {
            System.out.println("Song: "+s.getTitle()+", Played: "+s.getTotalListens()+"times");
        }
    }

    @Override
    public void getTopTenOverall() {
        List<Song> songList = inventory.getAllSongs();

        songList.sort(Comparator.comparing(
                Song::getTotalListens, Comparator.reverseOrder()));
        for (Song s: songList) {
            System.out.println("Song: "+s.getTitle()+", Played: "+s.getTotalListens()+"times");

        }
    }

    @Override
    public void getAllSongsOfAnArtist(Long artistId) {
        Artist artist = inventory.getArtistById(artistId);
        List<Song> songList = artist.getSongList();
        for(Song s: songList){
            System.out.println(s.getId()+". "+s.getTitle());
        }
    }

    @Override
    public void getAllArtists() {
        Map<Long, Artist> artistMap= inventory.getAllArtists();
        artistMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        });
    }
}
