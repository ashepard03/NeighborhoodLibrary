package com.workshop;

import java.sql.SQLOutput;
import java.util.Scanner;

public class NeighborhoodLibraryUI {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        boolean done = false;

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
                        System.out.println(i.getId() + " " + i.getTitle() + " " + i.getIsbn());

                        System.out.println("Would you like to check out a book? (Yes/No)");
                        String answer = userInput.nextLine().trim();
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
                                }
                                break;
                            case "No":
                                System.out.println("Returning to home screen");
                        }
                    }
                    break;
                case 2:
                    bookInventory = BookInventory.bookInventory;
                    for (Book i : bookInventory) {
                        if (!i.isCheckedOut()) continue;
                        System.out.println(i.getId() + " " + i.getTitle());
                    }
                    break;
                case 3:
                    System.out.println("Thank you for visiting the Java Section 10 Library!");
                    done = true;
                    break;
            }
        } while (!done);
            // check out the book
        //If the user selected to view checked out books display them
            //ask the user to check in a book (c) or return to home screen (x)
            //prompt them for book id
            //check in book
    }
}
