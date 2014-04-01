package lucas;

import java.util.LinkedList;

public class SortModel
{
    protected LinkedList<Ritter> ritter;

    public SortModel(LinkedList<Ritter> ritter)
    {
        this.ritter = ritter;
    }

    public LinkedList<Ritter> bubbleSort()
    {
        boolean swapped;
        int size = this.ritter.size();
        do
        {
            swapped = false;
            for (int i = 0; i < size - 1; i++)
            {
                if (this.ritter.get(i).hit > this.ritter.get(i + 1).hit)
                {
                    Ritter helper = this.ritter.get(i);
                    this.ritter.set(i, this.ritter.get(i + 1));
                    this.ritter.set(i + 1, helper);
                    swapped = true;
                }
            }
        } while (true == swapped);

        return this.ritter;
    }
}
