package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.Room;
import se.sprinto.hakan.adventuregame.view.UI;

public class Classroom implements Room {

    @Override
    public void enterRoom (Player player, UI ui) {
        ui.showMessage ("Du kommer in i klassrummet och märker någonting ligger på golvet.");
        String choice = ui.getInput("Vill du plock upp och kolla? (ja/nej)");
        if(choice.equalsIgnoreCase("ja")) {
            ui.showMessage("Du hittar en bok!");
            player.setFoundBook(true);
            player.addScore(50);
        } else {
            ui.showMessage("Du ignorerar det och går vidare.");
        }


    }

}
