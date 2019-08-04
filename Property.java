public class Property {

    private String address;
    private double offeredPrice;
    private int year;
    private Property next;

    public Property() {
        this.address = "";
        this.offeredPrice = 0.0;
        this.year = 0000;
        this.next = null;
    }

    public Property(String address, double offeredPrice, int year) {
        this.address = address;
        this.offeredPrice = offeredPrice;
        this.year = year;
        this.next = null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setOfferedPrice(double offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    public double getOfferedPrice() {
        return offeredPrice;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setNext(Property next) {
        this.next = next;
    }

    public Property getNext() {
        return next;
    }

    public String toString() {
        String s = String.format("%50s $%10.2f\t%4d",
            this.getAddress(),this.getOfferedPrice(),this.getYear());
        return s;
    }
}
