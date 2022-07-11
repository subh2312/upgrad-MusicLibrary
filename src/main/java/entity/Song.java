package entity;

public class Song {
    private static Long counter = 1L;
    private Long id;

    private String title;
    private String genre;
    private String releaseYear;
    private String language;
    private int totalListens;
    private Long artistId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotalListens() {
        return totalListens;
    }

    public void setTotalListens(int totalListens) {
        this.totalListens = totalListens;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Song(String title, String genre, String releaseYear, String language) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.language = language;
        this.id=counter;
        counter++;
        this.totalListens=0;
    }


    public void litsen() {
        this.totalListens++;
    }
}
