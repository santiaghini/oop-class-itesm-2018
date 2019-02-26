import java.util.*;

public class Credit{
    private Solicitant solicitant;
    private int termType;
    private Term term;
    private int monthTerm;
    private int id;
    private double creditAmount;
    private Date authDate;
    private Date deliveryDate;
    private ArrayList<Date> paymentDates;
    private double monthlyPayment;
    private double totalPayment;

    private static double maxCreditAmount = 400000.0;
    private static double annualInterestRate = 0.12;
    private static int count = 0;

    public Credit(Solicitant solicitant, int termType, double creditAmount, int authDay, int authMonth, int authYear) throws IllegalArgumentException{
        this.solicitant = solicitant;
        count++;
        this.id = count;
        switch (termType){
            case 1:
                this.term = Term.MEDIUM;
                break;
            case 2:
                this.term = Term.LONG;
                break;
            default:
                this.term = Term.MEDIUM;
                break;
        }
        this.monthTerm = term.getMonths();

        if (!(creditAmount > 0)){
            throw new IllegalArgumentException("¡El crédito debe ser mayor a cero!");
        } else if(creditAmount > maxCreditAmount){
            String text = String.format("¡El crédito no debe ser mayor a $%.2f!", maxCreditAmount);
            throw new IllegalArgumentException(text);
        } else {
            this.creditAmount = creditAmount;
        }

        this.authDate = new Date(authDay, authMonth, authYear);
        if (authDay > 20){
            this.authDate.setDay(1);
            this.authDate.add(0, 1, 0);
            System.out.println("Recuerda que los préstamos sólo se pueden autorizar los primeros 20 días del mes.");
            System.out.println("No te preocupes, el préstamo puede ser creado pero la fecha de autorización quedará para el día primero del mes entrante.");
        }

        this.deliveryDate = authDate.addAndReturnNew(7, 0, 0);

        this.paymentDates = calcPaymentDates();

        this.totalPayment = calcTotalAmount(creditAmount, term);
        this.monthlyPayment = this.totalPayment/monthTerm;
    }

    public ArrayList<Date> calcPaymentDates(){
        ArrayList<Date> array = new ArrayList<Date>();
        int nDay = deliveryDate.getDay();
        int nMonth = deliveryDate.getMonth();
        int nYear = deliveryDate.getYear();
        for (int i = 0; i < this.monthTerm; i++) {
            Date date = new Date(nDay, nMonth, nYear);
            date.add(0, i+1, 0);
            array.add(date);
        }
        return array;
    }

    public double calcTotalAmount(double creditAmount, Term term){
        int months = term.getMonths();
        double total = creditAmount + ( ( (creditAmount*annualInterestRate) / 12) * months);
        return total;
    }

    public void print(){
        System.out.println("*******************************");
        System.out.println("DATOS DEL CRÉDITO");
        System.out.println("*******************************");
        System.out.println("Solicitante:");
        solicitant.print();
        System.out.println();
        System.out.println("Crédito:");
        System.out.printf("ID: %s | Monto del crédito: %.2f | Plazo: %d meses \nPagos mensuales: %.2f | Pago total: %.1f\nFecha de autorización: %s | Fecha de entrega: %s\nFechas de pago:\n", id, creditAmount, monthTerm, monthlyPayment, totalPayment, authDate, deliveryDate);
        int counter = 0;
        for (Date paymentDate: paymentDates) {
            counter++;
            System.out.printf("Pago %d: %s\n", counter, paymentDate.toString());
        }
    }

    public int getId() {
        return id;
    }

    public ArrayList<Date> getPaymentDates() {
        return paymentDates;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public static double getMaxCreditAmount() {
        return maxCreditAmount;
    }

    public int getMonthTerm() {
        return monthTerm;
    }

    public int getTermType() {
        return termType;
    }

    public Term getTerm() {
        return term;
    }
}
