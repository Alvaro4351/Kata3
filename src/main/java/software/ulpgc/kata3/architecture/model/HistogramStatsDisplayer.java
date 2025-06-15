package software.ulpgc.kata3.architecture.model;

import java.util.List;

public class HistogramStatsDisplayer implements StatsDisplayer{

    private final List<BarchartElement> histogramElements;

    public HistogramStatsDisplayer(BarchartElementBuilder histogramElementBuilder ) {
        this.histogramElements = histogramElementBuilder.build();
    }

    @Override
    public void displayStats() {
        for(BarchartElement histogramElement: histogramElements){
            System.out.println(histogramElement.getField() + " " + "X".repeat(histogramElement.getValue()/1000));
        }
    }
}
