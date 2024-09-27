import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bike_rental_System {
    
    private List<bike> bikes;
    private List<customer> customers;
    private List<rental> rentals;

    public bike_rental_System() {
        bikes = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addbike(bike bike) {
        bikes.add(bike);
    }

    public void addCustomer(customer customer) {
        customers.add(customer);
    }

    public void rentbike(bike bike, customer customer, int days) {
        if (bike.getisavailable()) {
            bike.rent();
            rentals.add(new rental(bike, customer, days));

        } else {
            System.out.println("Bike is not available for rent.");
        }
    }

    public void returnCar(bike bike) {
        bike.returnbike();
        rental rentalToRemove = null;
        for (rental rental : rentals) {
            if (rental.getbike() == bike) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);

        } else {
            System.out.println("Bike was not rented.");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Anuj Bike Rental System =====");
            System.out.println("1. Rent a Bike");
            System.out.println("2. Return a Bike");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.println("\n== Rent a Bike ==\n");
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();

                System.out.println("\nAvailable Bikes:");
                for (bike bike : bikes) {
                    if (bike.getisavailable()) {
                        System.out.println(bike.getbikeID() + " - " + bike.getbrand() + " " + bike.getmodel());
                    }
                }

                System.out.print("\nEnter the Bike ID you want to rent: ");
                String bikeid = scanner.nextLine();

                System.out.print("Enter the number of days for rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                customer newCustomer = new customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                bike selectedbike = null;
                for (bike bike : bikes) {
                    if (bike.getbikeID().equals(bikeid) && bike.getisavailable()) {
                        selectedbike = bike;
                        break;
                    }
                }

                if (selectedbike != null) {
                    double totalPrice = selectedbike.calculateprice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID: " + newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Bike: " + selectedbike.getbrand() + " " + selectedbike.getmodel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentbike(selectedbike, newCustomer, rentalDays);
                        System.out.println("\nBike rented successfully.");
                    } else {
                        System.out.println("\nRental canceled.");
                    }
                } else {
                    System.out.println("\nInvalid Bike selection or Bike not available for rent.");
                }
            } else if (choice == 2) {
                System.out.println("\n== Return a bike ==\n");
                System.out.print("Enter the Bike ID you want to return: ");
                String bikeId = scanner.nextLine();

                bike bikeToReturn = null;
                for (bike bike : bikes) {
                    if (bike.getbikeID().equals(bikeId) && !bike.getisavailable()) {
                        bikeToReturn = bike;
                        break;
                    }
                }

                if (bikeToReturn != null) {
                    customer customer = null;
                    for (rental rental : rentals) {
                        if (rental.getbike() == bikeToReturn) {
                            customer = rental.getcustomer();
                            break;
                        }
                    }

                    if (customer != null) {
                        returnCar(bikeToReturn);
                        System.out.println("Bike returned successfully by " + customer.getName());
                    } else {
                        System.out.println("Bike was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid Bike ID or Bike is not rented.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("\nThank you for using the Anuj Bike Rental System!");
    }


}
