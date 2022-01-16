package model;
public class Author {

    private long authorId;

    private Name authorName;


    public static class Name{
        private String first;
        private String second;

        public Name(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "first='" + first + '\'' +
                    ", second='" + second + '\'' +
                    '}';
        }
    }

    private String nationality;

    private Birth birth;
    public static class Birth{
        private String date;
        private String country;
        private String city;

        public Birth(String date, String country, String city) {
            this.date = date;
            this.country = country;
            this.city = city;
        }

        @Override
        public String toString() {
            return "Birth{" +
                    "date='" + date + '\'' +
                    ", country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    private String authorDescription;

    public Author(long authorId, Name authorName, String nationality, Birth birth, String authorDescription) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.nationality = nationality;
        this.birth = birth;
        this.authorDescription = authorDescription;
    }

    public Author(long authorId, String first, String second, String nationality, String date, String country, String city, String authorDescription) {
        this.authorId = authorId;
        this.authorName = new Name(first, second);
        this.nationality = nationality;
        this.birth = new Birth( date,  country,  city);
        this.authorDescription = authorDescription;
    }

    public long getAuthorId() {
        return authorId;
    }


    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + authorId +
                ", authorName=" + authorName +
                ", nationality='" + nationality + '\'' +
                ", birth=" + birth +
                ", authorDescription='" + authorDescription + '\'' +
                '}';
    }
}
