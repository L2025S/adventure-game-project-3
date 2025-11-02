package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {


    private Player player;
    private Enemy goblin;

    @Test
    public void testAttack() {
        // Arrange
        player = new Player ("Test", 100, 0, 10);
        goblin = new Enemy ("EnemyTest", 20, 0, 5);

        // Act
        player.attack(goblin);

        // Assert
        assertEquals(10, goblin.getHealth());



    }
}
