package se.sprinto.hakan.adventuregame.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;


public class ForestRoomTest {

    private FakeUI fakeUI;
    private Player player;
    private ForestRoom forestRoom;

    @BeforeEach
    public void setUp() {

        fakeUI = new FakeUI();
        player = new Player("Test", 100, 0, 10);
        forestRoom = new ForestRoom();
    }


    @Test
    public void testEnterRoomWithYes() {

       fakeUI.setInput("ja");

       // Act
        forestRoom.enterRoom(player, fakeUI);

        boolean result = player.hasFoundKey();

        // Assert
        assertTrue(result);

    }
}
