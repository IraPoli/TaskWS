package model;

public class RegisterGenre {
    private int genreId;
    private String genreName;
    private String genreDescription;

    public RegisterGenre(int genreId, String genreName, String genreDescription) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.genreDescription = genreDescription;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getGenreDescription() {
        return genreDescription;
    }
}