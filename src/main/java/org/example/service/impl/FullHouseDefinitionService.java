package org.example.service.impl;

import org.example.service.CombinationsDefinable;

import java.util.List;

public class FullHouseDefinitionService implements CombinationsDefinable {
    private final PairDefinitionService pairDefinitionService;
    private final TripsDefinitionService tripsDefinitionService;

    public FullHouseDefinitionService(PairDefinitionService pairDefinitionService, TripsDefinitionService tripsDefinitionService) {
        this.pairDefinitionService = pairDefinitionService;
        this.tripsDefinitionService = tripsDefinitionService;
    }

    @Override
    public boolean hasCombination(List<String> cards) {
        boolean combination = pairDefinitionService.hasCombination(cards);
        boolean combination1 = tripsDefinitionService.hasCombination(cards);
        return combination && combination1;
    }
}
