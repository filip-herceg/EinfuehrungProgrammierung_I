import java.util.*;

public class Exercises_I {
    public int[] aufgabe2(int n) {
        int root = n;

        int gros = n / 144;
        n %= 144;
        int schock = n / 60;
        n %= 60;
        int dutzend = n / 12;
        int stueck = n % 12;

        return new int[]{
                root,
                gros,
                schock,
                dutzend,
                stueck
        };
    }
    public void printaufgabe2(int n) {
        int[] converted = aufgabe2(n);
        System.out.println(
                "Die Zahl " + converted[0] + " ergibt: " +
                        converted[1] + " Gros " +
                        converted[2] + " Schock " +
                        converted[3] + " Dutzend " +
                        converted[4] + " Stück " + "."
        );
    }

    public void aufgabe3(int radius) {
        double area = Math.PI * Math.pow(radius, 2);
        double circum = 2 * Math.PI * radius;
        System.out.println(
                "Radius: " + radius +
                        "\nArea: " + area +
                        "\nCircumference: " + circum
        );
    }

    public float aufgabe4(float capital, float interest, int days) {
        interest *= 0.01;
        return (capital * interest * days) / 36000;

    }

    public int aufgabe5(int num1, int num2, int num3) {
        ArrayList< Integer > nums = new ArrayList<>();
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        Collections.sort(nums);

        return nums.get(1);
    }

    public int aufgabe5(int[] nums) {
        ArrayList < Integer > numsList = new ArrayList<>();
        for (int x: nums) {
            numsList.add(x);
        }
        Collections.sort(numsList);
        if (numsList.size() % 2 != 0) {
            return numsList.get(
                    ((numsList.size() + 1) / 2) - 1
            );
        }
        return numsList.get(
                (((numsList.size() / 2) + ((numsList.size() / 2) + 1)) / 2) - 1
        );
    }

    public int aufgabe6() {
        return 31 * 24 * 3600;
    }

    public void aufgabe7() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.print("\n");
        }
    }

    public int aufgabe8() {
        Random random = new Random();
        ArrayList < Integer > wurf = new ArrayList<>();
        wurf.add(random.nextInt(1, 6));
        wurf.add(random.nextInt(1, 6));
        Comparator< Object > reverseComparator = Collections.reverseOrder();
        wurf.sort(reverseComparator);
        int result;

        if (wurf.get(0) == 2 && wurf.get(1) == 1) {
            return 1000;
        }

        result = wurf.get(0) * 10 + wurf.get(1);

        if (Objects.equals(wurf.get(0), wurf.get(1))) {
            result = wurf.get(0) * 100;
        }
        System.out.println(
                wurf.get(0) + " und " + wurf.get(1) + " ergibt " + result + " Punkte!"
        );
        return result;
    }

    public void aufgabe9() { //BETTER SOLUTION: AVOID ARRAYLIST, USELESS STEP
        //Generate code. ArrayList.
        ArrayList < int[] > list = new ArrayList<>();

        //Generate number and add to list
        for (int i = 0; i < 1000; i++) {
            int temp = i;
            int[] x = {
                    0,
                    0,
                    0
            };
            x[0] = temp / 100;
            temp %= 100;
            x[1] = temp / 10;
            temp %= 10;
            x[2] = temp;

            //Ignoring duplicate numbers
            if (x[0] != x[1] && x[0] != x[2] && x[1] != x[2]) {
                list.add(x);
            }

            //Print list.size / 8 Times:
            //Print 8 times numbers
            int current = 0;
            for (int k = 0; k < list.size() / 8; k++) {
                try {
                    for (int l = 0; l < 8; l++) {
                        int[] currentInt = list.get(current);
                        System.out.print(currentInt[0] + "" + currentInt[1] + "" + currentInt[2] + " ");
                        current++;
                    }
                } finally {}
                System.out.print("\n");
            }
        }
    }

    public void aufgabe10() {
        //Generate data
        Random random = new Random();
        HashMap< Integer, Integer > map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < 1000; i++) {
            map.compute(random.nextInt(1, 7), (k, v) -> v += 1);
        }

        //Generate Diagram
        for (int i = 1; i <= 6; i++) {

            System.out.println(
                    i + "| " + "*".repeat(Math.max(0, map.get(i) / 10))
            );
        }
    }

    public void aufgabe11(int sMaxNum) {
        for(int i = 1; i <= sMaxNum; i++) {
            for(int j = 0; j < sMaxNum; j++)
                System.out.printf("%s",i+j+"\t");
            System.out.println("\n");
        }
    }

    public void aufgabe12() {
        Random random = new Random();
        int num = random.nextInt(100, 999);
        aufgabe12(num);
    }

    public void aufgabe12(int num) {
        //Check if num is a valid number
        if(num < 100 || num >= 1000) {
            System.out.println("Fehler: Die Zahl "+num+" muss dreistellig sein.");
            return;
        }

        //Get the digits
        ArrayList<Integer> list = new ArrayList<>();

        list.add(num % 10); //add first

        if(num/10 % 10 != list.get(0)) list.add(num/10 % 10); //add second

        if(num/100 % 10 != list.get(0)) list.add(num/100 % 10); //add third


        list.removeIf(number -> number == 0);



        //Check if divisible
        for(int i = list.size()-1; i >= 0; i--) {
            if(num % list.get(i) != 0) {
                list.remove(i);
            }
        }
        if(list.isEmpty()) {
            System.out.println("Nummer "+ num +" ist durch keine Ziffer teilbar.");
        }
        else {
            System.out.println("Nummer "+ num +" ist teilbar durch " + list + ".");
        }
    }

    public void aufgabe13(double sekunden) {
        double minuten = sekunden / 60;
        double stunden = sekunden / 60 / 60;
        double tage = sekunden / 60 / 60 / 24;
        double wochen = sekunden / 60 / 60 / 24 / 7;
        double monate = sekunden / 60 / 60 / 24 / 7 / 4;
        double jahre = sekunden / 60 / 60 / 24 / 7 / 4 / 12;

        System.out.println(
                "sekunden\tentspricht:\n"+
                        minuten+"\tMinuten\n" +
                        stunden+"\tStunden\n" +
                        tage+"\tTage\n" +
                        wochen+"\tWochen\n" +
                        monate+"\tMonate\n" +
                        jahre+"\tJahre\n"
        );
    }

    public void aufgabe14(){
        class Auto{
            String typ;
            double maxGeschw;
            double PS;
            int anzahlSitze;
            boolean verfügbar;

            public Auto(String typ, double maxGeschw, double PS, int anzahlSitze, boolean verfügbar) {
                this.typ = typ;
                this.maxGeschw = maxGeschw;
                this.PS = PS;
                this.anzahlSitze = anzahlSitze;
                this.verfügbar = verfügbar;
            }

            public void anzeigen(){

            }
        }
    }
}
