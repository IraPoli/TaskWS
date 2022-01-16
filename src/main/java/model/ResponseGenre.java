package model;

public class ResponseGenre {
    public int genreId;
    public String genreName;
    public String genreDescription;

    public ResponseGenre(int genreId, String genreName, String genreDescription) {
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

    @Override
    public String toString() {
        return "ResponseGenre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", genreDescription='" + genreDescription + '\'' +
                '}';
    }
}
