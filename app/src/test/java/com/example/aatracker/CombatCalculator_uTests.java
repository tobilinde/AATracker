package com.example.aatracker;

import com.example.aatracker.Model.GameTypes;
import com.example.aatracker.Model.Troops;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.configuration.IMockitoConfiguration;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CombatCalculator_uTests {

    @Test
    public void CalculateCombat_AttackerWins_ReturnOne(){
        // Arrange
        Troops attacker = Troops.CreateTroops(1,0,0,0,0,0,0,GameTypes.Pacific1940);
        Troops defender = Troops.CreateTroops(1,0,0,0,0,0,0,GameTypes.Pacific1940);
        Troops defenderAfterCombat = Troops.CreateTroops(0,0,0,0,0,0,0,GameTypes.Pacific1940);

        ICombatRunner combatRunner = mock(CombatRunner.class);
        when(combatRunner.RemoveTroopsByIPCValue(any(Troops.class), any(int.class), any(GameTypes.class)))
                .thenReturn(attacker)
                .thenReturn(defenderAfterCombat);

        IUnitCombiner unitCombiner = mock(UnitCombiner.class);

        ICombatCalculator sut = new CombatCalculator(combatRunner, unitCombiner);

        // Act
        int result = sut.CalculateCombat(attacker, defender, GameTypes.Pacific1940);

        // Assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void CalculateCombat_DefenderWins_ReturnMinusOne(){
        // Arrange
        Troops attacker = Troops.CreateTroops(1,0,0,0,0,0,0,GameTypes.Pacific1940);
        Troops attackerAfterCombat = Troops.CreateTroops(0,0,0,0,0,0,0,GameTypes.Pacific1940);
        Troops defender = Troops.CreateTroops(1,0,0,0,0,0,0,GameTypes.Pacific1940);

        ICombatRunner combatRunner = mock(CombatRunner.class);
        when(combatRunner.RemoveTroopsByIPCValue(any(Troops.class), any(int.class), any(GameTypes.class)))
                .thenReturn(attackerAfterCombat)
                .thenReturn(defender);

        IUnitCombiner unitCombiner = mock(UnitCombiner.class);

        ICombatCalculator sut = new CombatCalculator(combatRunner, unitCombiner);

        // Act
        int result = sut.CalculateCombat(attacker, defender, GameTypes.Pacific1940);

        // Assert
        Assert.assertEquals(-1, result);
    }

    @Test
    public void CalculateCombat_Draw_ReturnZero(){
        // Arrange
        Troops attacker = Troops.CreateTroops(1,0,0,0,0,0,0,GameTypes.Pacific1940);
        Troops attackerAfterCombat = Troops.CreateTroops(0,0,0,0,0,0,0,GameTypes.Pacific1940);
        Troops defender = Troops.CreateTroops(1,0,0,0,0,0,0,GameTypes.Pacific1940);
        Troops defenderAfterCombat = Troops.CreateTroops(0,0,0,0,0,0,0,GameTypes.Pacific1940);

        ICombatRunner combatRunner = mock(CombatRunner.class);
        when(combatRunner.RemoveTroopsByIPCValue(any(Troops.class), any(int.class), any(GameTypes.class)))
                .thenReturn(attackerAfterCombat)
                .thenReturn(defenderAfterCombat);

        IUnitCombiner unitCombiner = mock(UnitCombiner.class);

        ICombatCalculator sut = new CombatCalculator(combatRunner, unitCombiner);

        // Act
        int result = sut.CalculateCombat(attacker, defender, GameTypes.Pacific1940);

        // Assert
        Assert.assertEquals(0, result);
    }
}
