package com.example.aatracker;

import com.example.aatracker.Model.GameTypes;
import com.example.aatracker.Model.Troops;
import com.example.aatracker.Model.Unit;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CombatRunner_uTests {

    @Test
    public void RemoveTroopsByIPCValue_NoTroopsLeft_ReturnsEmptyTroops(){
        // Arrange
        IDice dice = mock(Dice.class);
        Troops troops = Troops.CreateTroops(0,0,0,0,0,0,0 , GameTypes.Pacific1940);
        ICombatRunner sut = new CombatRunner(dice);

        // Act
        Troops remainingTroops = sut.RemoveTroopsByIPCValue(troops, 0, GameTypes.Pacific1940);

        // Assert
        Assert.assertEquals(0, remainingTroops.NumberOfTroops());
    }

    @Test
    public void RemoveTroopsByIPCValue_LessTroopsThanHits_ReturnsEmptyTroops(){
        // Arrange
        IDice dice = mock(Dice.class);
        Troops troops = Troops.CreateTroops(1,0,0,0,0,0,0 , GameTypes.Pacific1940);
        ICombatRunner sut = new CombatRunner(dice);

        // Act
        Troops remainingTroops = sut.RemoveTroopsByIPCValue(troops, 2, GameTypes.Pacific1940);

        // Assert
        Assert.assertEquals(0, remainingTroops.NumberOfTroops());
    }

    @Test
    public void RemoveTroopsByIPCValue_NoHits_AllTroopsReturned(){
        // Arrange
        IDice dice = mock(Dice.class);
        Troops troops = Troops.CreateTroops(1,1,1,1,1,1,1 , GameTypes.Pacific1940);
        ICombatRunner sut = new CombatRunner(dice);

        // Act
        Troops remainingTroops = sut.RemoveTroopsByIPCValue(troops, 0, GameTypes.Pacific1940);

        // Assert
        Assert.assertEquals(7, remainingTroops.NumberOfTroops());
    }

    @Test
    public void RemoveTroopsByIPCValue_TroopsHit_LowestIPCValueTroopsRemoved(){
        // Arrange
        IDice dice = mock(Dice.class);
        Troops troops = Troops.CreateTroops(1,1,1,1,1,1,1 , GameTypes.Pacific1940);
        ICombatRunner sut = new CombatRunner(dice);

        // Act
        Troops remainingTroops = sut.RemoveTroopsByIPCValue(troops, 5, GameTypes.Pacific1940);

        // Assert
        Assert.assertEquals(23, GetCosts(remainingTroops.GetUnitsByIPCCost()));
    }

    @Test
    public void Attack_TroopGiven_HitsCalculated(){
        // Arrange
        IDice dice = mock(Dice.class);
        when(dice.RollDice(1, 6))
                .thenReturn(3);

        Troops troops = Troops.CreateTroops(1,1,1,1,1,1,1 , GameTypes.Pacific1940);
        ICombatRunner sut = new CombatRunner(dice);

        // Act
        int hits = sut.Attack(troops);

        // Assert
        Assert.assertEquals(4, hits);
    }

    @Test
    public void Defense_TroopGiven_HitsCalculated(){
        // Arrange
        IDice dice = mock(Dice.class);
        when(dice.RollDice(1, 6))
                .thenReturn(3);

        Troops troops = Troops.CreateTroops(1,1,1,1,1,1,1 , GameTypes.Pacific1940);
        ICombatRunner sut = new CombatRunner(dice);

        // Act
        int hits = sut.Defense(troops);

        // Assert
        Assert.assertEquals(3, hits);
    }

    private int GetCosts(List<Unit> units)
    {
        int sum = 0;
        for (Unit unit : units){
            sum += unit.Cost;
        }
        return sum;
    }
}
