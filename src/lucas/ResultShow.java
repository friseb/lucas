package lucas;

import java.text.DecimalFormat;
import java.util.List;

public class ResultShow
{

    public void show(List<Integer> diceResults, List<Double> approximateErrors,
            double expectedValues)
    {
        DecimalFormat f = new DecimalFormat("#0.00");

        String text;

        System.out.println("\nErgbnis:");

        for (int i = 0; i < diceResults.size(); i++)
        {

            if (diceResults.get(i) != 0)
            {
                text = f.format(approximateErrors.get(i) * 100) + "%";
            } else
            {
                text = "---";
            }

            System.out.println(i + 1 + " | IST: " + diceResults.get(i)
                    + " | SOLL: " + f.format(expectedValues)
                    + " | ABWEICHUNG: " + text);

        }

    }
}
