public class main{
    public static void main(String[] args) {
        bike_rental_System rentalSystem = new bike_rental_System();

        bike b1 = new bike("C001", "TVS", "APACHE", 100.0); // Different base price per day for each car
        bike b2 = new bike("C002", "Honda", "HORNET", 70.0);
        bike b3 = new bike("C003", "YAMAHA", "R15", 65.0);
        rentalSystem.addbike(b1);
        rentalSystem.addbike(b2);
        rentalSystem.addbike(b3);
        //rentalSystem.addbike(b3);
        rentalSystem.menu();
    }
}