package builderPattern;

import java.util.*;

public class ECommerceApp {
    public static void main(String[] args) {

        Integer age = null;
        Scanner hlc = new Scanner(System.in);
        String firstName, lastName, email, address, phone;

        System.out.println("Application Registration Form");
        System.out.println("Please complete the following form:\n");
        System.out.print("Enter your first name: ");
        firstName = hlc.nextLine().trim();

        while (firstName.isEmpty()) {
            System.out.println("This field is mandatory. Please provide your first name.\n");
            System.out.print("Enter your first name: ");
            firstName = hlc.nextLine().trim();
        }

        System.out.print("Enter your last name: ");
        lastName = hlc.nextLine();

        while (lastName.isEmpty()) {
            System.out.println("This field is mandatory. Please provide your last name.\n");
            System.out.print("Enter your last name: ");
            lastName = hlc.nextLine().trim();
        }

        System.out.print("Enter your email (optional): ");
        email = hlc.nextLine();

        System.out.print("Enter your address (optional): ");
        address = hlc.nextLine();

        System.out.print("Enter your phone number: ");
        phone = hlc.nextLine();

        while (phone.isEmpty()) {
            System.out.println("This field is mandatory. Please provide your phone number.\n");
            System.out.print("Enter your phone number: ");
            phone = hlc.nextLine().trim();
        }

        while (age == null || age <= 0) {
            System.out.print("Enter your age: ");
            String input = hlc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("This field is mandatory. Please provide your age.\n");
                continue;
            }
            if (input.matches("\\d+")) {
                age = Integer.parseInt(input);
                if (age <= 0) {
                    System.out.println("Please enter a valid age.\n");
                }
            } else {
                System.out.println("Error! Please enter a valid age.\n");
            }
        }

        User user = new User.UserBuilder()
                .address(address)
                .email(email)
                .age(age)
                .lastName(lastName)
                .phone(phone)
                .firstName(firstName)
                .build();

        System.out.println("\nUser Information");
        System.out.println("\nFirst Name: " + user.firstName);
        System.out.println("Last Name: " + user.lastName);
        System.out.println("Email: " + user.email);
        System.out.println("Address: " + user.address);
        System.out.println("Phone: " + user.phone);
        System.out.println("Age: " + user.age);

        hlc.close();
    }
}
