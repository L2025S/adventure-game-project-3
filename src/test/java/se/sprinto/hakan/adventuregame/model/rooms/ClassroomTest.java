package se.sprinto.hakan.adventuregame.model.rooms;


import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClassroomTest {
    private FakeUI fakeUI;
    private Player player;
    private Classroom classroom;

     @Test
    public void testEnterRoom() {
         // Arrange
         fakeUI = new FakeUI();
         player = new Player("Test", 100,0,20);
         classroom = new Classroom();
         fakeUI.setInput("ja");

         // Act
         classroom.enterRoom(player, fakeUI);

         // Assert

         assertEquals(50, player.getScore());
         assertTrue(player.hasFoundBook());
     }
}
