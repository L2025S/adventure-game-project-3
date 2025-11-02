package se.sprinto.hakan.adventuregame.dao;

import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class FakeFileStatisticsDao implements StatisticsDao{

    @Override
    public void save (Statistics stat) {

    }

    @Override
    public List<Statistics> loadAll() {
        List<Statistics> stat = new ArrayList<>();
        stat.add (new Statistics("L",0));
        stat.add(new Statistics("L",50));
        stat.add(new Statistics("L",170));
        return stat;

    }

}
