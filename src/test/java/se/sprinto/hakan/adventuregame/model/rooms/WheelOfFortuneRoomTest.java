package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WheelOfFortuneRoomTest {
    @Test
    public void wheelOfFortuneRoomTest() {

        // Arrange
        Player player = new Player("Test", 100, 0, 20);
        FakeUI fakeUI = new FakeUI();
        WheelOfFortuneRoom fortuneRoom = new WheelOfFortuneRoom();
        fakeUI.setInput("ja");

        // Act
        fortuneRoom.enterRoom(player, fakeUI);

        // Assert
        assertTrue(player.hasPlayedWheelOfFortune());


    }
}
