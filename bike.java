public class bike {
    private String bikeID;
    private String brand;
    private String model;
    private double basepriceperday;
    private boolean isavailable;

    public bike(String bikeID, String brand, String model, double basepriceperday){
        this.bikeID = bikeID;
        this.brand = brand;
        this.model = model;
        this.basepriceperday = basepriceperday;
        this.isavailable = true;
    }

    public String getbikeID(){
        return bikeID;
    }

    public String getbrand(){
        return brand;
    }

    public String getmodel(){
        return model;
    }

    public boolean getisavailable(){
        return isavailable;
    }

    public void rent(){
        isavailable = false;
    }

    public void returnbike(){
        isavailable = true;
    }

    public double calculateprice(int rentaldays){
        return basepriceperday*rentaldays;
    }

}
