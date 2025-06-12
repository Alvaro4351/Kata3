package software.ulpgc.kata3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFreeBarchartAdapter {
    public static JFreeChart adapt(Barchart barchart){
        JFreeChart chart = ChartFactory.createBarChart(barchart.getTitle(), barchart.getxAxis(), barchart.getyAxis(), datasetOf(barchart));
        setUpChart(chart);
        return(chart);
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(BarchartElement barchartElement: barchart){
            dataset.addValue(barchartElement.getValue(), "", barchartElement.getField());
        }
        return dataset;
    }


    private static void setUpChart(JFreeChart chart) {
        chart.getCategoryPlot().getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_90);
    }
}
