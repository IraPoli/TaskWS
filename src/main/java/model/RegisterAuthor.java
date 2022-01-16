package model;

public class RegisterAuthor {
    private long authorId;

    private Author.Name authorName;


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

    private Author.Birth birth;
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


    public RegisterAuthor(long authorId, String first, String second, String nationality, String date, String country, String city, String authorDescription) {
        this.authorId = authorId;
        this.authorName = new Author.Name(first, second);
        this.nationality = nationality;
        this.birth = new Author.Birth( date,  country,  city);
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
