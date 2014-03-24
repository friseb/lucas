package lucas;

import java.util.ArrayList;
import java.util.List;

public class EvalModel
{

    private int amount;
    private int sides;
    private List<Integer> diceResults;
    private double expectedValues;
    private List<Double> approximateErrors;

    public EvalModel(List<Integer> diceResults, int amount, int sides)
    {
        this.sides = sides;
        this.amount = amount;
        this.diceResults = diceResults;
    }

    public double expectedValues()
    {
        this.expectedValues = (double)this.amount / this.sides;
        return this.expectedValues;
    }

    public List<Double> approximateErrors()
    {
        this.approximateErrors = new ArrayList<Double>();

        for (int i = 0; i < this.sides; i++)
        {
            this.approximateErrors.add(new Double(
                    (this.diceResults.get(i) - this.expectedValues)
                            / this.diceResults.get(i)));
        }

        return this.approximateErrors;
    }
}
