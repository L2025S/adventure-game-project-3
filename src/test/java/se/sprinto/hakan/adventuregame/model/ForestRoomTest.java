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
        FakeUI fakeUI = new FakeUI();
        Player player = new Player("Test", 100, 0, 10);
        ForestRoom forestRoom = new ForestRoom();
    }


    @Test
    public void testEnterRoomWithYes() {

       fakeUI.setInput("ja");

       // Act
        forestRoom.enterRoom(player, fakeUI);

        boolean result1 = player.hasFoundKey();
        int result2 = player.getScore();

        // Assert
        assertTrue(result1);
        assertEquals(20, result2);

    }

    @Test
    public void testEnterRoomWithNo() {

        fakeUI.setInput("nej");

        // Act
        forestRoom.enterRoom(player,fakeUI);
        boolean result1 =player.hasFoundKey();
        int result2 = player.getScore();

        // Assert
        assertFalse(result1);
        assertEquals(0, result2);

        
    }
}
