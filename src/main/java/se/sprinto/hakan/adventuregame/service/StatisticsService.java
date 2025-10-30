package se.sprinto.hakan.adventuregame.service;

import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.Comparator;
import java.util.List;

public class StatisticsService {
    private final StatisticsDao dao;

    public StatisticsService(StatisticsDao dao) {
        this.dao = dao;
    }

    /**
     * @return Lista med statistik sorterad efter högst score
     */
    public List<Statistics> getSortedStatistics() {
        List<Statistics> stats = dao.loadAll();
        stats.sort(Comparator.comparingInt(Statistics::getScore).reversed());
        return stats;
    }
}
/*  `loadAll()`

•  是 dao 对象的方法，用于加载所有的 Statistics 数据。
•  它通常会执行一个 SQL 查询，比如 SELECT * FROM statistics，然后将结果转换为 Statistics 对象列表。

 */
