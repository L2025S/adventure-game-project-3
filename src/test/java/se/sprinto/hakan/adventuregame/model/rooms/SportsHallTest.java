package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.view.FakeUI;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SportsHallTest {

    @Test
    public void testSportsHall() {

        // Arrange
        SportsHall sportsHall = new SportsHall();
        Player player = new Player ("Test", 100, 0, 20);
        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        // Act
        sportsHall.enterRoom(player, fakeUI);

        // Assert
        assertTrue(player.hasCompeted());

    }
}
