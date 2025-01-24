/**
 The date class is what creates the release date objects and is able to check, verify, and compare dates.
 */

public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUARTERCENTENNIAL = 400;

    /*
    This constructor is used to initialize a Date object
     */
    public Date()
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    /*
    This is a string constructor that represents a date and creates a new date object
    @param date to create a new date object
     */
    public Date(String date)
    {
        Date d = new Date(date);
    }

    public boolean isValid()
    {
        boolean validD = validDay(day);
        boolean validM = validMonth(month);
        boolean validY = validYear(year);

        return validD && validM && validY;

    }
    //method to check if the month is valid
    public boolean validMonth(int month)
    {
        return month >= 1 && month <= 12;
    }
    //method to check if the day is valid
    public boolean validDay(int day)
    {
        boolean leap = leapYear(year);
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && ((day <= 31) && (day >= 1)))
        {
            return true;
        }
        else if ((month == 4 || month == 6 || month == 9 || month == 11) && ((day <= 30) && (day >= 1)))
        {
            return true;
        }
        else return (month == 2) && (leap) && ((day <= 29) && (day >= 1));
    }
    //method to check if the year is a leap year
    public boolean leapYear(int year)
    {
        if (year / QUARTERCENTENNIAL == 0)
        {
            return true;
        }
        else return (year / QUADRENNIAL) == 0 && ((year / CENTENNIAL) != 0);
    }
/*
method to determine whether a given year is valid
@param year to see if it is valid
@return true if year is valid, otherwise false
 */
    public boolean validYear(int year)
    {
        if(year > 2007)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    /* Method used to compare one date to another
    @param date that needs to be compared
    @return int value
     */
    @Override
    public int compareTo(Date otherDate) {
        if (this.year != otherDate.year) {
            return Integer.compare(this.year, otherDate.year);
        }
        if (this.month != otherDate.month) {
            return Integer.compare(this.month, otherDate.month);
        }
        return Integer.compare(this.day, otherDate.day);
    }
    public static void main(String args[])
    {
        Date test1 = new Date("1/1/2015");
        Date test2 = new Date("3/1/2018");
        Date test3 = new Date("13/18/2002");
        Date test4 = new Date("45/2/2140");
        Date test5 = new Date("2/200/2002");
        Date test6 = new Date("5/67/2004");
        Date test7 = new Date("2/31/2007");

        test1.isValid();
        test2.isValid();
        test3.isValid();
        test4.isValid();
        test5.isValid();
        test6.isValid();
        test7.isValid();
    }
}
