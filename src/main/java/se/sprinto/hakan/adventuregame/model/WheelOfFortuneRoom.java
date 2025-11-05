package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class WheelOfFortuneRoom implements Room {

    @Override
    public void enterRoom (Player player, UI ui) {
        ui.showMessage ("Nu finns en lyckohjul framför dig.");
        Staff staff = new Staff.Builder()
                .setName("Mike")
                .setHealth(100)
                .setScore(200)
                .setStrength(20)
                .build();
        while(staff.getScore() > 150) {
            String choice = ui.getInput ("Vill du spela lyckohjul? Det är möjligt att du kan max få 100 poäng,\n" +
                    "men det kan också ta max 100 poäng från dig.\n" +
                    "Vill du spela? (ja/nej)");
            if (choice.equalsIgnoreCase("ja")) {
                staff.drawLotteryFor(player);
            } else {
                ui.showMessage( "Du lämnar rummet utan att spela lyckohjulet.");
            }
        }
        player.setPlayedWheelOfFortune(true);
    }
}
