package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.appinfo.AppInfo;
import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.StartRoom;
import se.sprinto.hakan.adventuregame.model.Statistics;
import se.sprinto.hakan.adventuregame.service.StatisticsService;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        UI ui = new ScannerUI();
        AppInfo instance = AppInfo.getInstance();
        instance.readProperty();
        ui.showMessage("Välkommen till Äventyrsspelet!");
        // New property
        ui.showMessage("Version " + instance.getVersion() + " av " + instance.getAuthor());
        String name = ui.getInput("Ange ditt namn:");

        // Builder pattern
        Player player = new Player.Builder()
                .setName(name)
                .setHealth(100)
                .setScore(0)
                .setStrength(10)
                .build();


        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}


