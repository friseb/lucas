package lucas;

import java.util.LinkedList;
import java.util.Random;

public class RumbleModel
{
    public int rumble(LinkedList<Ritter> teilnehmer, boolean detail)
    {
        int a, b;

        Random rand = new Random();
        do
        {
            for (int i = 0; i < teilnehmer.size(); i++)
            {
                a = teilnehmer.get(i).getId();
                if (i == teilnehmer.size() - 1)
                {
                    b = teilnehmer.get(0).getId();
                }
                else
                {
                    b = teilnehmer.get(i + 1).getId();
                }

                if (rand.nextInt(100) < teilnehmer.get(i).getHit())
                {
                    if (detail)
                    {

                        System.out.println("Ritter " + a
                                + " hat zugeschlagen! Ritter " + b
                                + " ist aus dem Tunier!");
                    }
                    
                    if (i == teilnehmer.size() - 1)
                    {
                        teilnehmer.remove(0);
                    }
                    else
                    {
                        teilnehmer.remove(i + 1);
                    }
                }
                else
                {
                    if (detail)
                    {
                        System.out.println("Ritter " + a + " hat verfehlt!");
                    }
                }

                if (1 == teilnehmer.size())
                {
                    break;
                }

            }
        } while (1 != teilnehmer.size());

        return teilnehmer.get(0).getId();
    }
}
