package ru.itmo.chizhikov;

import java.time.Clock;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventsStatisticImpl implements EventsStatistic {
    private final Clock clock;

    @Override
    public void incEvent(String name) {

    }

    @Override
    public double getEventStatisticByName(String name) {
        return 0;
    }

    @Override
    public Map<String, Double> getAllEventStatistic() {
        return null;
    }

    @Override
    public void printStatistic() {

    }
}