package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.model.rooms.Classroom;
import se.sprinto.hakan.adventuregame.model.rooms.MeetingRoom;
import se.sprinto.hakan.adventuregame.model.rooms.SportsHall;
import se.sprinto.hakan.adventuregame.model.rooms.WheelOfFortuneRoom;
import se.sprinto.hakan.adventuregame.view.UI;

public class StartRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du befinner dig i start-rummet. Du ser tre dörrar framför dig.");
        boolean exit = false;
        while (!exit) {
            String choice = ui.getInput("Vilken dörr vill du ta? (1=Skog, 2=Fängelse, 3=Skattkammare," +
                    " 4=Klassrum, 5=Konferensrum,6=Idrottshallen, 7=lyckojulrum, q=avsluta)");
            switch (choice) {
                case "1":
                    if (!player.hasFoundKey()) {
                        new ForestRoom().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan hittat och plockat upp nyckeln.");
                    }
                    break;
                case "2":
                    new DungeonRoom().enterRoom(player, ui);
                    break;
                case "3":
                    if (!player.hasOpenedChest()) {
                        new TreasureRoom().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan hittat och öppnat kistan");
                    }
                    break;
                case "4":
                    if(!player.hasFoundBok()){
                        new Classroom().enterRoom(player,ui);
                    } else {
                        System.out.println("Du har varit i klassrummet och hittat en bok.");
                    }
                    break;
                case "5":
                    if(!player.hasReturnedBook()) {
                        new MeetingRoom().enterRoom(player,ui);
                    } else {
                        System.out.println("Du har redan hjälpte professorn att hitta sin bok.");
                    }
                    break;
                case "6":
                    if(!player.hasCompeted()) {
                        new SportsHall().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan tävlat 100 meter med David.");
                    }
                    break;
                case "7":
                    if(!player.hasPlayedWheelOfFortune()) {
                        new WheelOfFortuneRoom().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan spelat lyckohjulet.");
                    }
                    break;
                case "q":
                    exit = true;
                    break;
                default:
                    ui.showMessage("Ogiltigt val.");
            }
            if (player.hasWon()) {
                ui.showMessage("Grattis! Du har klarat spelet!");
                exit = true;
            } else if (player.getHealth() <= 0) {
                ui.showMessage(("Din hälsa är kritisk, du vacklar till och dör!"));
                exit = true;
            }
        }
    }
}

