package com.example.aatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aatracker.Model.GameTypes;
import com.example.aatracker.Model.StrategicalBomber;
import com.example.aatracker.Model.Troops;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int AttackingInfantryCounter = 0;
    private int AttackingArtilleryCounter = 0;
    private int AttackingMechInfantryCounter = 0;
    private int AttackingTankCounter = 0;
    private int AttackingFighterCounter = 0;
    private int AttackingTBomberCounter = 0;
    private int AttackingSBomberCounter = 0;

    private int DefendingInfantryCounter = 0;
    private int DefendingArtilleryCounter = 0;
    private int DefendingMechInfantryCounter = 0;
    private int DefendingTankCounter = 0;
    private int DefendingFighterCounter = 0;
    private int DefendingTBomberCounter = 0;
    private int DefendingSBomberCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attackers
        final Button attackInfantryPlusButton = findViewById(R.id.AttackInfanteryPlusButton);
        attackInfantryPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingInfantryCounter++;
                TextView infantryTextView = (TextView)findViewById(R.id.AttackInfantryTextView);
                infantryTextView.setText(Integer.toString(AttackingInfantryCounter));
            }
        });

        final Button attackInfantryMinusButton = findViewById(R.id.AttackInfantryMinusButton);
        attackInfantryMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingInfantryCounter = SubtractFromCounter(AttackingInfantryCounter);
                TextView infantryTextView = (TextView)findViewById(R.id.AttackInfantryTextView);
                infantryTextView.setText(Integer.toString(AttackingInfantryCounter));
            }
        });

        final Button attackArtileryPlusButton = findViewById(R.id.AttackArtileryPlusButton);
        attackArtileryPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingArtilleryCounter++;
                TextView artilleryTextView = (TextView)findViewById(R.id.AttackArtileryTextView);
                artilleryTextView.setText(Integer.toString(AttackingArtilleryCounter));
            }
        });

        final Button attackArtileryMinusButton = findViewById(R.id.AttackArtileryMinusButton);
        attackArtileryMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingArtilleryCounter = SubtractFromCounter(AttackingArtilleryCounter);
                TextView artilleryTextView = (TextView)findViewById(R.id.AttackArtileryTextView);
                artilleryTextView.setText(Integer.toString(AttackingArtilleryCounter));
            }
        });

        final Button attackMechInfantryPlusButton = findViewById(R.id.AttackMechInfantryPlusButton);
        attackMechInfantryPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingMechInfantryCounter++;
                TextView textView = (TextView)findViewById(R.id.AttackMechInfantryTextView);
                textView.setText(Integer.toString(AttackingMechInfantryCounter));
            }
        });

        final Button attackMechInfantryMinusButton = findViewById(R.id.AttackMechInfantryMinusButton);
        attackMechInfantryMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingMechInfantryCounter = SubtractFromCounter(AttackingMechInfantryCounter);
                TextView textView = (TextView)findViewById(R.id.AttackMechInfantryTextView);
                textView.setText(Integer.toString(AttackingMechInfantryCounter));
            }
        });

        final Button attackTankPlusButton = findViewById(R.id.AttackTankPlusButton);
        attackTankPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingTankCounter++;
                TextView textView = (TextView)findViewById(R.id.AttackTankTextView);
                textView.setText(Integer.toString(AttackingTankCounter));
            }
        });

        final Button attackTankMinusButton = findViewById(R.id.AttackTankMinusButton);
        attackTankMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingTankCounter = SubtractFromCounter(AttackingTankCounter);
                TextView textView = (TextView)findViewById(R.id.AttackTankTextView);
                textView.setText(Integer.toString(AttackingTankCounter));
            }
        });

        final Button attackFighterPlusButton = findViewById(R.id.AttackFighterPlusButton);
        attackFighterPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingFighterCounter++;
                TextView textView = (TextView)findViewById(R.id.AttackFighterTextView);
                textView.setText(Integer.toString(AttackingFighterCounter));
            }
        });

        final Button attackFighterMinusButton = findViewById(R.id.AttackFighterMinusButton);
        attackFighterMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingFighterCounter = SubtractFromCounter(AttackingFighterCounter);
                TextView textView = (TextView)findViewById(R.id.AttackFighterTextView);
                textView.setText(Integer.toString(AttackingFighterCounter));
            }
        });

        final Button attackTBomberPlusButton = findViewById(R.id.AttackTBomberPlusButton);
        attackTBomberPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingTBomberCounter++;
                TextView textView = (TextView)findViewById(R.id.AttackTBomberTextView);
                textView.setText(Integer.toString(AttackingTBomberCounter));
            }
        });

        final Button attackTBomberMinusButton = findViewById(R.id.AttackTBomberMinusButton);
        attackTBomberMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingTBomberCounter = SubtractFromCounter(AttackingTBomberCounter);
                TextView textView = (TextView)findViewById(R.id.AttackTBomberTextView);
                textView.setText(Integer.toString(AttackingTBomberCounter));
            }
        });

        final Button attackSBomberPlusButton = findViewById(R.id.AttackSBomberPlusButton);
        attackSBomberPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingSBomberCounter++;
                TextView textView = (TextView)findViewById(R.id.AttackSBomberTextView);
                textView.setText(Integer.toString(AttackingSBomberCounter));
            }
        });

        final Button attackSBomberMinusButton = findViewById(R.id.AttackSBomberMinusButton);
        attackSBomberMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttackingSBomberCounter = SubtractFromCounter(AttackingSBomberCounter);
                TextView textView = (TextView)findViewById(R.id.AttackSBomberTextView);
                textView.setText(Integer.toString(AttackingSBomberCounter));
            }
        });

        // Defenders
        final Button defenseInfantryPlusButton = findViewById(R.id.DefenseInfantryPlusButton);
        defenseInfantryPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingInfantryCounter++;
                TextView infantryTextView = (TextView)findViewById(R.id.DefenseInfantryTextView);
                infantryTextView.setText(Integer.toString(DefendingInfantryCounter));
            }
        });

        final Button defenseInfantryMinusButton = findViewById(R.id.DefenseInfantryMinusButton);
        defenseInfantryMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingInfantryCounter = SubtractFromCounter(DefendingInfantryCounter);
                TextView infantryTextView = (TextView)findViewById(R.id.DefenseInfantryTextView);
                infantryTextView.setText(Integer.toString(DefendingInfantryCounter));
            }
        });

        final Button defenseArtileryPlusButton = findViewById(R.id.DefenseArtilleryPlusButton);
        defenseArtileryPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingArtilleryCounter++;
                TextView artilleryTextView = (TextView)findViewById(R.id.DefenseArtilleryTextView);
                artilleryTextView.setText(Integer.toString(DefendingArtilleryCounter));
            }
        });

        final Button defenseArtileryMinusButton = findViewById(R.id.DefenseArtilleryMinusButton);
        defenseArtileryMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingArtilleryCounter = SubtractFromCounter(DefendingArtilleryCounter);
                TextView artilleryTextView = (TextView)findViewById(R.id.DefenseArtilleryTextView);
                artilleryTextView.setText(Integer.toString(DefendingArtilleryCounter));
            }
        });

        final Button defenseMechInfantryPlusButton = findViewById(R.id.DefenseMechInfantryPlusButton);
        defenseMechInfantryPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingMechInfantryCounter++;
                TextView textView = (TextView)findViewById(R.id.DefenseMechInfantryTextView);
                textView.setText(Integer.toString(DefendingMechInfantryCounter));
            }
        });

        final Button defenseMechInfantryMinusButton = findViewById(R.id.DefenseMechInfantryMinusButton);
        defenseMechInfantryMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingMechInfantryCounter = SubtractFromCounter(DefendingMechInfantryCounter);
                TextView textView = (TextView)findViewById(R.id.DefenseMechInfantryTextView);
                textView.setText(Integer.toString(DefendingMechInfantryCounter));
            }
        });

        final Button defenseTankPlusButton = findViewById(R.id.DefenseTankPlusButton);
        defenseTankPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingTankCounter++;
                TextView textView = (TextView)findViewById(R.id.DefenseTankTextView);
                textView.setText(Integer.toString(DefendingTankCounter));
            }
        });

        final Button defenseTankMinusButton = findViewById(R.id.DefenseTankMinusButton);
        defenseTankMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingTankCounter = SubtractFromCounter(DefendingTankCounter);
                TextView textView = (TextView)findViewById(R.id.DefenseTankTextView);
                textView.setText(Integer.toString(DefendingTankCounter));
            }
        });

        final Button defenseFighterPlusButton = findViewById(R.id.DefenseFighterPlusButton);
        defenseFighterPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingFighterCounter++;
                TextView textView = (TextView)findViewById(R.id.DefenseFighterTextView);
                textView.setText(Integer.toString(DefendingFighterCounter));
            }
        });

        final Button defenseFighterMinusButton = findViewById(R.id.DefenseFighterMinusButton);
        defenseFighterMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingFighterCounter = SubtractFromCounter(DefendingFighterCounter);
                TextView textView = (TextView)findViewById(R.id.DefenseFighterTextView);
                textView.setText(Integer.toString(DefendingFighterCounter));
            }
        });

        final Button defenseTBomberPlusButton = findViewById(R.id.DefenseTBomberPlusButton);
        defenseTBomberPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingTBomberCounter++;
                TextView textView = (TextView)findViewById(R.id.DefenseTBomberTextView);
                textView.setText(Integer.toString(DefendingTBomberCounter));
            }
        });

        final Button defenseTBomberMinusButton = findViewById(R.id.DefenseTBomberMinusButton);
        defenseTBomberMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingTBomberCounter = SubtractFromCounter(DefendingTBomberCounter);
                TextView textView = (TextView)findViewById(R.id.DefenseTBomberTextView);
                textView.setText(Integer.toString(DefendingTBomberCounter));
            }
        });

        final Button defenseSBomberPlusButton = findViewById(R.id.DefenseSBomberPlusButton);
        defenseSBomberPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingSBomberCounter++;
                TextView textView = (TextView)findViewById(R.id.DefenseSBomberTextView);
                textView.setText(Integer.toString(DefendingSBomberCounter));
            }
        });

        final Button defenseSBomberMinusButton = findViewById(R.id.DefenseSBomberMinusButton);
        defenseSBomberMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DefendingSBomberCounter = SubtractFromCounter(DefendingSBomberCounter);
                TextView textView = (TextView)findViewById(R.id.DefenseSBomberTextView);
                textView.setText(Integer.toString(DefendingSBomberCounter));
            }
        });

        final Button simulateCombatButton = findViewById(R.id.SimulateCombatButton);
        simulateCombatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                IDice dice = new Dice();
                ICombatRunner combatRunner = new CombatRunner(dice);
                IUnitCombiner unitCombiner = new UnitCombiner();
                ICombatCalculator combatCalculator = new CombatCalculator(combatRunner, unitCombiner);
                CombatSimulator combatSimulator = new CombatSimulator(combatCalculator);

                Troops attacker = Troops.CreateTroops(AttackingArtilleryCounter, AttackingFighterCounter, AttackingInfantryCounter, AttackingMechInfantryCounter, AttackingSBomberCounter, AttackingTBomberCounter, AttackingTankCounter, GameTypes.Pacific1940);
                Troops defender = Troops.CreateTroops(DefendingArtilleryCounter, DefendingFighterCounter, DefendingInfantryCounter, DefendingMechInfantryCounter, DefendingSBomberCounter, DefendingTBomberCounter, DefendingTankCounter, GameTypes.Pacific1940);

                List<Double> combatResults = combatSimulator.SimulateCombat(attacker, defender, 10000, GameTypes.Pacific1940);

                TextView attackerVictoriesTextView = (TextView)findViewById(R.id.AttackerVictoriesTextView);
                attackerVictoriesTextView.setText(Double.toString(combatResults.get(0)));
                TextView drawsTextView = (TextView)findViewById(R.id.DrawsTextView);
                drawsTextView.setText(Double.toString(combatResults.get(2)));
                TextView defenderVictoriesTextView = (TextView)findViewById(R.id.DefenderVictoriesTextView);
                defenderVictoriesTextView.setText(Double.toString(combatResults.get(1)));
            }
        });
    }

    private int SubtractFromCounter(int counter)
    {
        counter--;
        if (counter < 0){
            return 0;
        }
        return counter;
    }
}