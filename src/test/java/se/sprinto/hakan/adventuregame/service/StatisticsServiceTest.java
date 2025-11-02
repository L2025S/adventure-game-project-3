package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.dao.FakeFileStatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsServiceTest {
    private FakeFileStatisticsDao dao;
    private StatisticsService statisticsService;

    @Test
    void testGetSortedStatistics() {

        // Arrange
        dao = new FakeFileStatisticsDao();
        statisticsService = new StatisticsService(dao);

        // Act
        statisticsService.getSortedStatistics();


        Statistics result = statisticsService.getSortedStatistics().get(0);

        // Assert

        assertEquals("L;170", result.toString());


    }
}
