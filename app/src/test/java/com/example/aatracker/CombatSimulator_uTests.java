package com.example.aatracker;

import com.example.aatracker.Model.GameTypes;
import com.example.aatracker.Model.Troops;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombatSimulator_uTests {
    @Test
    public void SimulateCombat_EqualTroopsGiven_CombatSimulated()
    {
        // Arrange
        Troops attackers = Troops.CreateTroops(100, 0, 0, 0, 0, 0, 0, GameTypes.Pacific1940);
        Troops defenders = Troops.CreateTroops(100, 0, 0, 0, 0, 0, 0, GameTypes.Pacific1940);

        ICombatRunner combatRunner = new CombatRunner(new Dice());
        IUnitCombiner unitCombiner = new UnitCombiner();
        ICombatCalculator combatCalculator = new CombatCalculator(combatRunner, unitCombiner);
        CombatSimulator sut = new CombatSimulator(combatCalculator);

        // Act
        List<Double> results = sut.SimulateCombat(attackers, defenders, 10000, GameTypes.Pacific1940);

        // Assert
        Assert.assertTrue(results.get(0) > 0.47);
        Assert.assertTrue(results.get(0) < 0.53);
    }

    @Test
    public void SimulateCombat_InfantryGiven_CombatSimulated()
    {
        // Arrange
        Troops attackers = Troops.CreateTroops(0, 0, 10, 0, 0, 0, 0, GameTypes.Pacific1940);
        Troops defenders = Troops.CreateTroops(0, 0, 10, 0, 0, 0, 0, GameTypes.Pacific1940);

        ICombatRunner combatRunner = new CombatRunner(new Dice());
        IUnitCombiner unitCombiner = new UnitCombiner();
        ICombatCalculator combatCalculator = new CombatCalculator(combatRunner, unitCombiner);
        CombatSimulator sut = new CombatSimulator(combatCalculator);

        // Act
        List<Double> results = sut.SimulateCombat(attackers, defenders, 10000, GameTypes.Pacific1940);
    }

    @Test
    public void SimulateCombat_EqualTroopsGivenByUpdate_CombatSimulated()
    {
        // Arrange
        Troops attackers = Troops.CreateTroops(100, 0, 100, 0, 0, 0, 0, GameTypes.Pacific1940);
        Troops defenders = Troops.CreateTroops(0, 0, 200, 0, 0, 0, 0, GameTypes.Pacific1940);

        ICombatRunner combatRunner = new CombatRunner(new Dice());
        IUnitCombiner unitCombiner = new UnitCombiner();
        ICombatCalculator combatCalculator = new CombatCalculator(combatRunner, unitCombiner);
        CombatSimulator sut = new CombatSimulator(combatCalculator);

        // Act
        List<Double> results = sut.SimulateCombat(attackers, defenders, 10000, GameTypes.Pacific1940);

        // Assert
        //Attacker, Defender, Draw
        Assert.assertTrue(results.get(0) > 0.47);
        Assert.assertTrue(results.get(0) < 0.53);
    }
}
