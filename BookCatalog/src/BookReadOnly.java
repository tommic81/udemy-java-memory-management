public interface BookReadOnly {
    int getId();

    String getTitle();

    String getAuthor();

    String toString();

    //#2 reference escaping??
    Price getPrice();
}
