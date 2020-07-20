package com.example.aatracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Dice_uTests {

    @Test
    public void RollDice_HighNumberOfRolls_DivergesTowardsAverage()
    {
        // Arrange
        IDice sut = new Dice();

        // Act
        List<Integer> results = sut.RollDice(1, 6, 100000);
        double averageRoll = CalculateAverage(results);

        // Assert
        Assert.assertTrue(averageRoll > 3.49);
        Assert.assertTrue(averageRoll < 3.51);
    }

    private Double CalculateAverage(List<Integer> rolls)
    {
        int nRolls = rolls.size();
        double sum = 0;
        for (int i = 0; i < nRolls; i++){
            sum += rolls.get(i);
        }
        return sum / nRolls;
    }
}
