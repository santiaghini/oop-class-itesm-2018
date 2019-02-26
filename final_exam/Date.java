public class Date{

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        adjustDate(day, month, year);
    }

    public void adjustDate(int day, int month, int year){
        if (day > 30){
            month += (int) day/31;
            day = day % 30;
        }
        if (month > 12) {
            if (month % 12 == 0) {
                year += (int) month/13;
                month = 12;
            } else{
                year += (int) month/12;
                month = month % 12;
            }
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void add(int day, int month, int year){
        this.day += day;
        this.month += month;
        this.year += year;
        adjustDate(this.day, this.month, this.year);
    }

    public Date addAndReturnNew(int day, int month, int year){
        Date newDate = new Date(this.day, this.month, this.year);
        newDate.add(day, month, year);
        return newDate;
    }

    @Override
    public String toString(){
        return String.format("%d/%d/%d", day, month, year);
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
