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

    //Aufgabe 14 Class
    static class Aufgabe14 {
        String typ;
        double maxGeschw;
        double PS;
        int anzahlSitze;
        boolean verfuegbar;

        public Aufgabe14(String typ, double maxGeschw, double PS, int anzahlSitze, boolean verfuegbar) {
            this.typ = typ;
            this.maxGeschw = maxGeschw;
            this.PS = PS;
            this.anzahlSitze = anzahlSitze;
            this.verfuegbar = verfuegbar;
        }

        public void anzeigen(){
            System.out.println("Typ:\t" + typ);
            System.out.println("Höchstgeschwindigkeit:\t" + maxGeschw + " km/h");
            System.out.println("PS:\t" + PS);
            System.out.println("Anzahl Sitze:\t" + anzahlSitze);
            System.out.println("Ist Verfügbar?\t" + verfuegbar);
        }

        public void ausleihbar(){
            if(verfuegbar == true){
                System.out.println("Dieses Auto ist ausleihbar.");
                return;
            }
            System.out.println("Dieses Auto ist nicht ausleibar.");
        }

        public void ausleihen(){
            if(verfuegbar == false){
                System.out.println("Fehler: dieses Auto ist nicht ausleihbar.");
                return;
            }
            System.out.println("Auto wurde ausgeliehen!");
            verfuegbar = false;
        }
    }

    public void aufgabe15(int jahreszahl){
        if((jahreszahl % 4 == 0) && (jahreszahl % 100 != 0)){
            System.out.println("Ist Schaltjahr");
            return;
        }
        if(jahreszahl %400 == 0){
            System.out.println("Ist Schaltjahr");
            return;
        }
        System.out.println("Kein Schaltjahr");
    }

    public static class Aufgabe16{
        double kredithoehe, zinssatz, mtlRate, zinsen, tilgung,jahreszahl, laufzeit;

        public Aufgabe16(double kredithoehe, double zinssatz, double mtlRate, double jahreszahl, double laufzeit) {
            this.kredithoehe = kredithoehe;
            this.zinssatz = zinssatz;
            this.mtlRate = mtlRate;
            this.jahreszahl = jahreszahl;
            this.laufzeit = laufzeit;
            double tilgung = mtlRate * 12 * jahreszahl;
            double startjahr = jahreszahl;
            double zinsen = neuerZins();
        }

        public void info(){
            System.out.println("Es fallen für das Jahr " + jahreszahl + " " + zinsen + "€ Zinsen an.\n" +
                    "Gezahlt werden " + tilgung + "€ (je " + mtlRate + "€ in 12 Monaten),\n" +
                    "d. h. der Stand des Darlehns am 31.12." + (jahreszahl+1) + " beträgt " + neuerStand() + "€.");

            System.out.println("Für das Folgejahr beträgt die Darlehnssumme dann nur noch " + neuerStandLoop(1) + "€ und damit sind\n" +
                    "nur noch " + neuerZins() + "€ an Zinsen zu zahlen. Da aber nach wie vor 12000€ eingezahlt\n" +
                    "werden, beträgt die Darlehnssumme nach Ablauf des Folgejahres noch "+(kredithoehe + zinsen - tilgung)+"€.");
        }

        public double aufgabe16_neueZinsen(double kredithoehe, double zinssatz){
            return kredithoehe *zinssatz/100;
        }

        public double neuerStand(){
            kredithoehe = kredithoehe + zinsen - mtlRate*12;
            return kredithoehe;
        }

        public double neuerStandLoop(int jahre){
            double temp = kredithoehe;
            for (int i = 0; i <= jahre; i++)
            temp += neuerStand();
            return temp;
        }

        public double neuerZins(){
            zinsen = (kredithoehe * zinssatz)/100;
            return zinsen;
        }
    }

    public void aufgabe17(int day, int month){
        int gesT = day + (month-1)*30;
        if(month > 3){
            gesT -= 2;
        }
        System.out.println((gesT));
    }

    public void aufgabe17_loesung(int day, int month){
        int sum = day;
        for (int i = 1; i < month; i++) {
            switch (i){
                case 1:
                    sum += 31;
                    break;
                case 2:
                    sum += 28;
                    break;
                case 3:
                    sum += 31;
                    break;
                case 4:
                    sum += 30;
                    break;
                case 5:
                    sum += 31;
                    break;
                case 6:
                    sum += 30;
                    break;
                case 7:
                    sum += 31;
                    break;
                case 8:
                    sum += 31;
                    break;
                case 9:
                    sum += 30;
                    break;
                case 10:
                    sum += 31;
                    break;
                case 11:
                    sum += 30;
                    break;
                case 12:
                    sum += 31;
                    break;
            }
        }
        System.out.println(sum);
    }

    public void aufgabe18(int gesZahl){
        int[] dice = new int[4];
        dice = new int[]{1, 1, 1, 1};
        ArrayList<int[]> result = func18_cycleUp(0, dice);
        System.out.println(result);
    }
    private ArrayList<int[]> func18_cycleUp(int welcherWuerfel, int[] wuerfelSet){
        ArrayList<int[]> result = new ArrayList();
        while(wuerfelSet[welcherWuerfel] <7){   //von 1-6 fuehre aus
            result.add(wuerfelSet);         //Resultatwurf in result schreiben
            wuerfelSet[welcherWuerfel]++;   //Augenzahl erhoehen

            if((wuerfelSet.length-1) > (wuerfelSet[welcherWuerfel])){   //Wenn nicht letzte zahl, gehe zur nächsten
                wuerfelSet[welcherWuerfel+1] = 1;           //Setze nachfolgenden Würfel wieder auf 1
                func18_cycleUp(welcherWuerfel+1, wuerfelSet); //Wiederhole programm mit nächstem Wuerfel
            }
        }
        return result; //gebe resultat zurück
    }

    public void aufgabe18_loesung(int augenZahl){
        int[] augen = new int[25];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    for (int l = 1; l <= 6; l++) {
                        augen[i+j+k+l]++;
                    }

                }
            }
        }
        System.out.println(augen[augenZahl]);
    }
}

