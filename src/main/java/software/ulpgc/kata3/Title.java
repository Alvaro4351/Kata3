package software.ulpgc.kata3;

public class Title {
    private final String title;
    private final int year;
    private final int duration;
    private final TitleType titleType;

    public Title(String title, int year, int duration, TitleType titleType) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.titleType = titleType;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public TitleType getTitleType() {
        return titleType;
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", titleType=" + titleType +
                '}';
    }

    public enum TitleType {
        VIDEOGAME,
        TVPILOT,
        MOVIE,
        TVSERIES,
        TVMINISERIES,
        SHORT,
        TVSPECIAL,
        TVSHORT,
        VIDEO,
        TVMOVIE,
        TVEPISODE
    }
}
