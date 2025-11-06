package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.Room;
import se.sprinto.hakan.adventuregame.model.roles.Sprinter;
import se.sprinto.hakan.adventuregame.view.UI;

public class SportsHall implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Nu är du i idrottshallen och en sprinter David vill tävla 100 meter med dig.");
        Sprinter sprinter = new Sprinter.Builder()
                .setName("David")
                .setHealth(100)
                .setScore(0)
                .setStrength(20)
                .build();
        String choice = ui.getInput("Vill du tävla med David? (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            int playerTime = player.run100m();
            int sprinterTime = sprinter.run100m();
            if (sprinterTime > playerTime) {
                ui.showMessage("Du har vunnit!");
                player.addScore(100);
                sprinter.addScore(100);
            } else {
                ui.showMessage("Du har förlorat!");
                player.addScore(-100);
                sprinter.addScore(100);
            }
            player.setCompeted(true);
        } else {
            ui.showMessage("Du lämnat idrottshallen utan att tävla");
        }
    }
}
