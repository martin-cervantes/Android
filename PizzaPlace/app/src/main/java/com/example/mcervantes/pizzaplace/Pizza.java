package com.example.mcervantes.pizzaplace;

/**
 * Created by mcervantes on 4/06/17.
 */

public class Pizza
{
    private int size = 60;

    private boolean onion;
    private boolean beacon;
    private boolean sausage;
    private boolean pepperoni;
    private boolean mushrooms;
    private boolean extCheese;

    private int total;

    public void setSize(int s)
    {
        switch(s)
        {
            case 1:
                size = 60;
                break;
            case 2:
                size = 70;
                break;
            case 3:
                size = 80;
                break;
        }
    }

    public void setOnion(boolean value)
    {
        onion = value;
    }

    public void setBeacon(boolean value)
    {
        beacon = value;
    }

    public void setSausage(boolean value)
    {
        sausage = value;
    }

    public void setPepperoni(boolean value)
    {
        pepperoni = value;
    }

    public void setMushrooms(boolean value)
    {
        mushrooms = value;
    }

    public void setExtCheese(boolean value)
    {
        extCheese = value;
    }

    public int getTotal()
    {
        total = size;

        if(onion)
            total += 5;

        if(beacon)
            total += 15;

        if(sausage)
            total += 8;

        if(pepperoni)
            total += 6;

        if(mushrooms)
            total += 9;

        if(extCheese)
            total += 7;

        return total;
    }
}
