package backend.house.model;

public class HouseSale {

    private String postcode;

    private String saleDate;

    private int price;

    private char newBuild;

    private String street;

    private String locality;

    private String district;

    private String county;

    private String town;

    public String getPostcode() {
        return postcode;
    }

    public HouseSale setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public HouseSale setSaleDate(String saleDate) {
        this.saleDate = saleDate;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public HouseSale setPrice(int price) {
        this.price = price;
        return this;
    }

    public char getNewBuild() {
        return newBuild;
    }

    public HouseSale setNewBuild(char newBuild) {
        this.newBuild = newBuild;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public HouseSale setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public HouseSale setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public HouseSale setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public HouseSale setCounty(String county) {
        this.county = county;
        return this;
    }

    public String getTown(){
        return town;
    }

    public HouseSale setTown(String town){
        this.town = town;
        return this;
    }

    public Object[] getList() {
        Object[] toReturn = new Object[7];
        toReturn[0] = getStreet();
        toReturn[1] = getLocality();
        toReturn[2] = getTown();
        toReturn[3] = getDistrict();
        toReturn[4] = getCounty();
        toReturn[5] = getSaleDate();
        toReturn[6] = getPrice();
        return toReturn;
    }
}
