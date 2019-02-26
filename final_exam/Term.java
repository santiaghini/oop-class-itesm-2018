public enum Term{
    LONG(12),
    MEDIUM(6);

    private int months;

    private Term(int months){
        this.months = months;
    }

    public int getMonths() {
        return months;
    }
}