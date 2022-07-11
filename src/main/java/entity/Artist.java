package entity;

import java.util.LinkedList;
import java.util.List;

public class Artist {
    private static Long counter = 1L;
    private Long id;

    private String firstName;
    private String lastName;
    private List<Song> songList;

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.songList = new LinkedList<>();
        this.id = counter;
        counter++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
    public void addSong(Song song){
        this.songList.add(song);
    }
}
