public class SingleFamilyHouse extends Property {

    private int backyardSize;

    public SingleFamilyHouse() {
        super();
        this.backyardSize = 0;
    }

    public SingleFamilyHouse(String address, double offeredPrice, int year,
     int backyardSize) {
        super(address, offeredPrice, year);
        this.backyardSize = backyardSize;
    }

    public void setBackYardSize(int backyardSize) {
        this.backyardSize = backyardSize;
    }

    public int getBackYardSize() {
        return backyardSize;
    }

    public String toString() {
        return super.toString() + "\t" 
            + this.getBackYardSize() + " (sqft)";
    }
}