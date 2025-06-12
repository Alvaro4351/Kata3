package software.ulpgc.kata3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\alvar\\OneDrive\\Documentos\\title.basics.tsv");

        List<Title> titles = new FileTitleLoader(file, new TsvTitleDeserializer()).load();
        Map<Integer, Integer> titlesperYearStats = new HashMap<>();
        Map<Title.TitleType, Integer> titleTypeCountStats = new HashMap<>();
        for(Title title: titles) {
            titlesperYearStats.put(title.getYear(), titlesperYearStats.getOrDefault(title.getYear(), 0) + 1);
            titleTypeCountStats.put(title.getTitleType(),
                    titleTypeCountStats.getOrDefault(
                            title.getTitleType(),0) + 1);
        }

        MainFrame mainFrame = new MainFrame();
        MoviesBarchartLoader loader = new MoviesBarchartLoader(
                new FromMapBarchartElementBuilder<>(titlesperYearStats).build(),
                new FromMapBarchartElementBuilder<>(titleTypeCountStats).build()
        );

        mainFrame.put("toggle", new ToggleBarchartCommand(loader, mainFrame.getDisplay()));
        mainFrame.getDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }
}
