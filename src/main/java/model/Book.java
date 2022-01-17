package model;

public class Book {
    private long bookId;
    private String bookName;
    private String bookLanguage;
    private String bookDescription;
    private Additional additional;
    private int publicationYear;

    public Book(long bookId, String bookName, String bookLanguage, String bookDescription, Additional additional, int publicationYear) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookLanguage = bookLanguage;
        this.bookDescription = bookDescription;
        this.additional = additional;
        this.publicationYear = publicationYear;
    }

    public Book(long bookId, String bookName, String bookLanguage, String bookDescription , int publicationYear) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookLanguage = bookLanguage;
        this.bookDescription = bookDescription;
        this.publicationYear = publicationYear;
        this.additional = new Additional(0,new Additional.Size(10,10,4));
    }


    public static class Additional {
        private int pageCount;
        private Size size;

        public Additional(int pageCount, Size size) {
            this.pageCount = pageCount;
            this.size = size;
        }

        public static class Size {
            private double height;
            private double width;
            private double length;

            public Size(double height, double width, double length) {
                this.height = height;
                this.width = width;
                this.length = length;
            }
        }
    }

}
