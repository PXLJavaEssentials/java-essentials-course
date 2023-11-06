package be.pxl.h6.example;

public enum Genre {
    SCIENCE_FICTION("SF"),
    FANTASY("FY"),
    THRILLER("TR"),
    DRAMA("DM"),
    COMEDY("CM");

    private String code;

    private Genre(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
