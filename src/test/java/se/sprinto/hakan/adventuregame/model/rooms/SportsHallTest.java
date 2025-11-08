package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.roles.Sprinter;
import se.sprinto.hakan.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.view.UI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

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
