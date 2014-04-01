package lucas;

import java.util.LinkedList;
import java.util.Scanner;

public class Controller
{
    protected LinkedList<Ritter> teilnehmer = new LinkedList<Ritter>();

    protected int anzahl = 1;

    protected int runden;

    public void run()
    {
        this.getParams();

        this.sortTeilnehmer();

        this.rumble();
    }

    public void getParams()
    {
        Scanner in = new Scanner(System.in);
        int hit;
        System.out
                .print("Trefferwahrscheinlichkeit (zwischen 1 und 99) für Ritter eingeben oder 0 zum Abbruch.\n");
        do
        {
            System.out.println("Ritter Nummer " + anzahl + " :");
            hit = in.nextInt();
            if (0 > hit || 99 < hit)
            {
                System.out.println("zwischen 1 und 99!");
                continue;
            }
            else if (0 != hit)
            {
                Ritter ritter = new Ritter();
                ritter.setHit(hit);
                ritter.setId(anzahl);
                teilnehmer.add(ritter);
                this.anzahl++;
            }

        } while (0 != hit);

        System.out.println("Anzahl der Runden eingeben:");

        this.runden = in.nextInt();

        in.close();
    }

    public void sortTeilnehmer()
    {
        SortModel sort = new SortModel(this.teilnehmer);
        this.teilnehmer = sort.bubbleSort();
    }
    
    public void rumble()
    {
        RumbleModel model = new RumbleModel();

        if (1 < this.runden)
        {
            for (int i = 1; i <= this.runden; i++)
            {
                //irgendwas stimmt hier nicht
                System.out.println("Sieger der Runde " + i
                        + " ist Ritter Nummer "
                        + model.rumble(this.teilnehmer, false) + "!");
            }
        }
        else
        {
            //das geht schon 1a
            System.out.println("Sieger ist Ritter Nummer "
                    + model.rumble(this.teilnehmer, true) + "!");
        }
    }
}
