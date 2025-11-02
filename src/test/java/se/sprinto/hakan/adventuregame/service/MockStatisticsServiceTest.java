package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MockStatisticsServiceTest {

    @Mock
    private FileStatisticsDao dao;
    @InjectMocks
    private StatisticsService service;

    @Test
    void getStatistics() {
        // Arrange
        List<Statistics> sats = new ArrayList(List.of(
                new Statistics("L",0),
                (new Statistics("L", 170)),
                new Statistics("L",50)));
        List<Statistics> expected = new ArrayList(List.of(
                new Statistics("L", 170),
                new Statistics("L",50),
                new Statistics("L", 0)));

        Mockito.when(dao.loadAll()).thenReturn(sats);

        // Act
        List<Statistics> result = service.getSortedStatistics();

        // Assert
        assertEquals(expected, result);

    }

}
