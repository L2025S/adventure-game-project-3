package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

public class TreasureRoomTest {

    private TreasureRoom treasureRoom;
    private FakeUI fakeUI;
    private Player player;

    @BeforeEach
    public void setUp() {
        treasureRoom = new TreasureRoom();
        fakeUI = new FakeUI();
        player = new Player ("Test", 100, 0, 10);
    }

    @Test
    public void testEnterRoomWithYesAndFoundKey () {
        fakeUI.setInput("ja");
        player.setFoundKey(true);

        // Act
        treasureRoom.enterRoom(player, fakeUI);

        // Assert
        assertTrue(player.hasOpenedChest());
        assertEquals(100, player.getScore());

    }
}
