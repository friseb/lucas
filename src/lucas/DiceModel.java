package lucas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceModel
{

    private int sides;

    public DiceModel(int sides)
    {
        this.sides = sides;
    }

    public List<Integer> roll(int amount)
    {
        List<Integer> diceResult = new ArrayList<Integer>();

        for (int i = 0; i < this.sides; i++)
        {
            diceResult.add(new Integer(0));
        }
        
        Random rand = new Random();
        int number;

        for (int i = 0; i < amount; i++)
        {
            number = rand.nextInt(sides);
            
            diceResult.set(number, diceResult.get(number)+1);
        }

        return diceResult;
    }
}
