package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeetingRoomTest {
    private Player player;
    private FakeUI fakeUI;
    private MeetingRoom meetingRoom;

    @Test
    public void testMeetingRoom() {
        // Arrange
        fakeUI = new FakeUI();
        meetingRoom = new MeetingRoom();
        player = new Player ("Test", 100, 0, 20);
        fakeUI.setInput("ja");
        player.setFoundBook(true);

        // Act
        meetingRoom.enterRoom(player, fakeUI);

        // Assert
        assertTrue(player.hasFoundBook());
        assertEquals(150, player.getScore());
    }
}
