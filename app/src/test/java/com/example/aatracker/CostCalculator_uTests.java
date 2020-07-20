package com.example.aatracker;

import com.example.aatracker.Model.Artilery;
import com.example.aatracker.Model.Fighter;
import com.example.aatracker.Model.Infantry;
import com.example.aatracker.Model.MechanizedInfantry;
import com.example.aatracker.Model.StrategicalBomber;
import com.example.aatracker.Model.TacticalBomber;
import com.example.aatracker.Model.Tank;
import com.example.aatracker.Model.Unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CostCalculator_uTests {

    @Test
    public void CalculateCosts_UnitsGiven_CostsCalculated()
    {
        CalculateCosts_UnitsGiven_CostsCalculated(1, 1, 1, 1, 1, 1, 1, 50);
    }

    private void CalculateCosts_UnitsGiven_CostsCalculated(
            int nArtilery, int nFighter, int nInfantry, int nMechanizedInfantry, int nStrategicalBomber, int nTacticalBomber, int nTank, int expectedCosts) {
        // Arrange
        List<Unit> units = new ArrayList<>();
        units.addAll(CreateUnits(nArtilery, Artilery.Create1940PacificArtilery()));
        units.addAll(CreateUnits(nFighter, Fighter.Create1940PacificFighter()));
        units.addAll(CreateUnits(nInfantry, Infantry.Create1940PacificInfantry()));
        units.addAll(CreateUnits(nMechanizedInfantry, MechanizedInfantry.Create1940PacificMechanizedInfantry()));
        units.addAll(CreateUnits(nStrategicalBomber, StrategicalBomber.Create1940PacificStrategicBomber()));
        units.addAll(CreateUnits(nTacticalBomber, TacticalBomber.Create1940PacificTacticalBomber()));
        units.addAll(CreateUnits(nTank, Tank.Create1940PacificTank()));

        CostCalculator costCalculator = new CostCalculator();

        // Act
        int cost = costCalculator.CalculateCost(units);

        //Assert
        Assert.assertEquals(expectedCosts, cost);
    }

    private Object[] parametersForWhenWithnoParam_thenLoadByNameSafe() {
        return new Object[]{
                new Object[]{1, 1, 1, 1, 1, 1, 1, 53}
        };
    }

    private List<Unit> CreateUnits(int nUnits, Unit unit)
    {
        List<Unit> units = new ArrayList<Unit>();

        for (int i = 0; i < nUnits; i++)
        {
            units.add(unit);
        }

        return units;
    }
}
