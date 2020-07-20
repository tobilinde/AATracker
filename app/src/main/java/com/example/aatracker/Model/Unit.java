package com.example.aatracker.Model;

public class Unit implements Comparable<Unit> {
    public int Cost;
    public int Attack;
    public int Defense;
    public int Hitpoints;

    @Override
    public int compareTo(Unit unit) {
        return this.Cost - unit.Cost;
    }
}

