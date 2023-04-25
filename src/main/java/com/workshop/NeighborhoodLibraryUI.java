package com.workshop;

import java.util.Scanner;

public class NeighborhoodLibraryUI {
    public static void main(String[] args) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);

        boolean done = true;
        do {
            System.out.println("Welcome to Java Section 10 Library. Please select an option: ");
            //prompt user to select what screen they want to view
            System.out.println("1. View Available Books");
            System.out.println("2. View Checked out Books");
            System.out.println("3. Exit Library");

            int choice = userInput.nextInt();
            userInput.nextLine();
            switch (choice) {
                case 1:
                    Book[] bookInventory = BookInventory.bookInventory;
                    for (Book i : bookInventory) {
                        if (i.isCheckedOut()) continue;
                        System.out.println(i.getId() + " / " + i.getTitle() + " / " + i.getIsbn());
                    }
                    //ask the user to select a book or return to home screen
                    System.out.println("Would you like to check out a book? (Yes/No)");
                    String answer = userInput.nextLine();
                    // if yes, prompt them for book id and name
                    switch (answer) {
                        case "Yes":
                            System.out.println("Please provide the ID of the book you would like to check out.");
                            int bookId = userInput.nextInt();
                            userInput.nextLine();
                            for (Book b : bookInventory) {
                                if (b.getId() == bookId) {
                                    System.out.println("Please enter you name: ");
                                    String name = userInput.nextLine();
                                    b.checkOut(name);
                                    System.out.println("You have checked out the book " + b.getTitle());
                                }
                            }Thread.sleep(1000);
                            main(null);
                        case "No":
                            System.out.println("Returning to home screen");
                            Thread.sleep(1000);
                            main(null);
                    }
                    break;
                case 2:
                    System.out.println("--------Checked Out Books--------");
                    bookInventory = BookInventory.bookInventory;
                    for (Book i : bookInventory) {
                        if (!i.isCheckedOut()) continue;
                        System.out.println(i.getId() + " " + i.getTitle());
                    }
                    System.out.println("Would you like to check in a book (c) or return to the home screen (x)");
                    String userResponse = userInput.nextLine().trim();
                    switch (userResponse) {
                        case "c":
                            System.out.println("Please provide the book id of the book you would like to check in");
                            int bookId = userInput.nextInt();
                            userInput.nextLine();
                            for (Book b : bookInventory)
                                if (b.getId() == bookId) {
                                    b.checkIn();
                                    System.out.println("You have checked in the book " + b.getTitle());
                                    System.out.println("Returning to the library home screen" );
                                    Thread.sleep(1000);
                                    main(null);
                                }
                        case "x":
                            System.out.println("Returning to the library home screen");
                            break;
                    }
                case 3:
                    System.out.println("Thank you for visiting the Java Section 10 Library!");
                    break;
                default:
                    System.out.println("Please Try again");
            }
        } while (!done);
    }
}
