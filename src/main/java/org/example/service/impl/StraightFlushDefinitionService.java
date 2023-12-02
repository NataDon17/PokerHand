package org.example.service.impl;

import org.example.service.CombinationsDefinable;

import java.util.List;


public class StraightFlushDefinitionService implements CombinationsDefinable {

    private final StraightDefinitionService straightDefinitionService;
    private final FlashDefinitionService flashDefinitionService;

    public StraightFlushDefinitionService(StraightDefinitionService straightDefinitionService, FlashDefinitionService flashDefinitionService) {
        this.straightDefinitionService = straightDefinitionService;
        this.flashDefinitionService = flashDefinitionService;
    }

    @Override
    public boolean hasCombination(List<String> cards) {
        boolean combination = straightDefinitionService.hasCombination(cards);
        boolean combination1 = flashDefinitionService.hasCombination(cards);
        return combination && combination1;
    }
}
