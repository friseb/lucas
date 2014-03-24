package lucas;

import java.util.List;
import java.util.Scanner;


public class InputController
{

    private int sides;
    private int amount;
    private List<Integer> diceResults;
    private double expectedValues;
    private List<Double> approximateErrors;

    public void run()
    {
        this.getParams();
        this.roll();
        this.eval();
        this.show();
    }

    public void getParams()
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Anzahl der Seiten eingeben:");
        this.sides = in.nextInt();

        System.out.print("Anzahl der Würfe eingeben:");
        this.amount = in.nextInt();

        in.close();
    }

    public void roll()
    {
        DiceModel dice = new DiceModel(this.sides);
        this.diceResults = dice.roll(this.amount);
    }

    public void eval()
    {
        EvalModel eval = new EvalModel(this.diceResults, this.amount, this.sides);
        
        this.expectedValues = eval.expectedValues();
        this.approximateErrors = eval.approximateErrors();
    }

    public void show()
    {
        ResultShow show = new ResultShow();
        show.show(this.diceResults, this.approximateErrors, this.expectedValues);
    }
}
