public class Condo extends Property {

    private double HOAfee;

    public Condo() {
        super();
        HOAfee = 100.0;
    }

    public Condo(String addy, double price, int year, double HOAfee) {
        super(addy, price, year);
        this.HOAfee = HOAfee;
    }

    public void setHOAfee(double HOAfee) {
        this.HOAfee = HOAfee;
    }

    public double getHOAfee() {
        return HOAfee;
    }

    public String toString() {
        return super.toString() + "\t" 
            + "HOA fee: $" + this.getHOAfee();
    }
}