package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class MeetingRoom implements Room {
    @Override
    public void enterRoom (Player player, UI ui) {
        ui.showMessage(" Du kommer in i konferensrummet . En professor säger att han har tappat en bok.");
        String choice = ui.getInput ("Vill du hjälp professorn att leta efter sin bok? (ja/nej)");
        if(choice.equalsIgnoreCase("ja")) {
            if(player.hasFoundBok()) {
                ui.showMessage("Du hjälpte professorn att hitta sin bok.");
                player.setReturnedBook(true);
                player.addScore(150);
            } else {
                ui.showMessage("Du har letat men har inte tur.");
            }

        } else {
            ui.showMessage("Du lämnar konferensrummet utan att erbjuda hjälp.");
        }
    }

}
