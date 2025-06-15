package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Barchart;
import software.ulpgc.kata3.architecture.model.BarchartElement;

import java.util.List;

public class MoviesBarchartLoader implements BarchartLoader{

    private final List<BarchartElement> titlesPerYear;
    private final List<BarchartElement> titlesTypeCount;

    public MoviesBarchartLoader(List<BarchartElement> titlesPerYear, List<BarchartElement> titlesTypeCount) {
        this.titlesPerYear = titlesPerYear;
        this.titlesTypeCount = titlesTypeCount;
    }

    @Override
    public Barchart load(int id) {
        return switch(id){
            case 0 -> loadBarchart("Titles per year", "Year", "Number of Titles", titlesPerYear);
            case 1 -> loadBarchart("Titles type Count", "Titles type", "Count", titlesTypeCount);
            default -> null;
        };
    }

    private Barchart loadBarchart(String titles, String xAxis, String yAxis, List<BarchartElement> barchartElement) {
        return new Barchart(titles, xAxis, yAxis, barchartElement);
    }
}
