package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

public class DungeonRoomTest {
    private DungeonRoom dungeonRoom;
    private FakeUI fakeUI;
    private Player player;
    private Enemy goblin;

    @BeforeEach
    public void setUp() {
        dungeonRoom = new DungeonRoom();
        fakeUI = new FakeUI();
        player = new Player("Test", 100, 0, 10);
        goblin = new Enemy ("EnemyTest", 20, 0, 5);

    }

    @Test
    public void testEnterRoomWithOneAttack () {
        // Arrange
        fakeUI.setInput("a");

        // Act
        dungeonRoom.enterRoom(player, fakeUI);

        // Assert
        assertTrue(goblin.isAlive());
        assertEquals(50, player.getScore());
        assertEquals(95, player.getHealth());

    }

    @Test
    public void testEnterRoomWithTwoAttacks() {
        // Arrange
        fakeUI.setInput("a");
        fakeUI.setInput("a");

        // Act
        dungeonRoom.enterRoom(player, fakeUI);

        //Assert
        assertTrue(player.hasDefeatedEnemy());
        assertEquals(50, player.getScore());
        assertEquals(95, player.getHealth());

    }

    @Test
    public void testEnterRoomWithNo () {

        //Arrange
        fakeUI.setInput("r");

        // Act
        dungeonRoom.enterRoom(player, fakeUI);

        // Assert
        assertTrue(goblin.isAlive());
        assertEquals(0, player.getScore());

    }
}
