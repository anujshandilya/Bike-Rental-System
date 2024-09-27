public class rental {
    private bike bike;
    private customer customer;
    private int days;

    public rental(bike bike, customer customer, int days){
        this.bike=bike;
        this.customer=customer;
        this.days=days;
    }

    public bike getbike(){
        return bike;
    }

    public customer getcustomer(){
        return customer;
    }

    public int getdays(){
        return days;
    }

}
