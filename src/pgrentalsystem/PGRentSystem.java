package pgrentalsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PGRentSystem {
	private List<PG> pgList;
	private List<Tenant> tenantList;
	private List<Booking> bookingList;

	public PGRentSystem() {
		this.pgList = new ArrayList<>();
		this.tenantList = new ArrayList<>();
		this.bookingList = new ArrayList<>();
	}

	public static void main(String[] args) {
		PGRentSystem pgRentSystem = new PGRentSystem();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("******* Welcome To MyCodeWorks PG Rental System ********");			
			System.out.println("1. Add PG");
			System.out.println("2. Add Tenant");
			System.out.println("3. Book Room");
			System.out.println("4. Make Payment");
			System.out.println("5. Vacate Room");
			System.out.println("6. Display All Bookings");
			System.out.println("7. Search Tenant by Name");
			System.out.println("8. Exit");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				pgRentSystem.addPG();
				break;
			case 2:
				pgRentSystem.addTenant();
				break;
			case 3:
				pgRentSystem.bookRoom();
				break;
			case 4:
				pgRentSystem.makePayment();
				break;
			case 5:
				pgRentSystem.vacateRoom();
				break;
			case 6:
				pgRentSystem.displayAllBookings();
				break;
			case 7:
				pgRentSystem.searchTenantByName();
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// Methods to add PG, Tenant, Book Room, Make Payment
	public void addPG() {
		// Implementation
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter PG name:");
		String name = scanner.nextLine();

		System.out.println("Enter PG address:");
		String address = scanner.nextLine();

		System.out.println("Enter owner name:");
		String ownerName = scanner.nextLine();

		System.out.println("Enter owner contact number:");
		String ownerContactNumber = scanner.nextLine();

		Owner owner = new Owner(ownerName, ownerContactNumber);
		PG pg = new PG(name, address, owner);
		System.out.println("*********How Many Rooms Your PG Have********");
		int nRoom = scanner.nextInt();
		System.out.println("*********Enter Room Details********");
//        List<Room> rooms= new ArrayList<>();

		for (int l = 0; l < nRoom; l++) {
			System.out.println("*********Enter Room No********");
			int roomNumber = scanner.nextInt();
			System.out.println("*********Enter Room Rent********");
			double rent = scanner.nextDouble();
			System.out.println("*********Enter Room Type(Sharing)********");
			String sharing = scanner.next();

			Room r = new Room(roomNumber, rent, sharing);
			pg.addRoom(r);
			System.out.println("Room Number " + roomNumber + " added successfully " + pg.getName() + " PG");
		}
		pgList.add(pg);
		System.out.println("PG added successfully");
	}

	public void addTenant() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter tenant name:");
		String name = scanner.nextLine();

		System.out.println("Enter tenant contact number:");
		String contactNumber = scanner.nextLine();

		Tenant tenant = new Tenant(name, contactNumber);
		tenantList.add(tenant);
		System.out.println("Tenant added successfully");
		// Implementation
	}

	public void bookRoom() {
		// Implementation
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select PG:");
		for (int i = 0; i < pgList.size(); i++) {
			System.out.println((i + 1) + ". " + pgList.get(i).getName());
		}

		int pgChoice = scanner.nextInt();
		PG pg = pgList.get(pgChoice - 1);

		System.out.println("Select room:");
		for (int i = 0; i < pg.getRooms().size(); i++) {
			System.out.println((i + 1) + ". Room " + (i + 1));
		}

		int roomChoice = scanner.nextInt();
		Room room = pg.getRooms().get(roomChoice - 1);

		System.out.println("Enter tenant ID:");
		int tenantId = scanner.nextInt();
		Tenant tenant = tenantList.get(tenantId - 1);
//		Booking booking = new Booking( tenant, room, 0);
//		bookingList.add(booking);
	
		
		 if (pg.hasAvailableRooms()) {
		        if (!room.isOccupied()) {
		            tenant.assignRoom(room); // Assign room to tenant
		            Booking booking = new Booking(tenant, room, 0);
		            bookingList.add(booking);
		            System.out.println("Room booked successfully");
		        } else {
		            System.out.println("The selected room is already occupied.");
		        }
		    } else {
		        System.out.println("No available rooms in " + pg.getName());
		    }
	}

	public void makePayment() {
		Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Select Booking:");
	    for (int i = 0; i < bookingList.size(); i++) {
	        Booking booking = bookingList.get(i);
	        System.out.println((i + 1) + ". " + booking);
	    }

	    int bookingChoice = scanner.nextInt();
	    Booking selectedBooking = bookingList.get(bookingChoice - 1);
	    
	    double remainingAmount = selectedBooking.calculateRemainingAmount();
	    System.out.println("Remaining amount due: " + remainingAmount);
	    
	    System.out.println("Enter payment amount:");
	    double paymentAmount = scanner.nextDouble();

	    // Create the payment
	    Payment payment = new Payment(selectedBooking, paymentAmount);
	    System.out.println("Payment of " + payment.getAmount() + " made successfully for Booking ID: " + selectedBooking.getBookingId());

	}

	public void vacateRoom() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select Booking to Vacate:");
		for (int i = 0; i < bookingList.size(); i++) {
			Booking booking = bookingList.get(i);
			System.out.println((i + 1) + ". " + booking);
		}

		int bookingChoice = scanner.nextInt();
		Booking selectedBooking = bookingList.get(bookingChoice - 1);

		// Mark the room as vacant
		selectedBooking.getRoom().setOccupied(false);
		System.out.println("Room vacated successfully for Booking ID: " + selectedBooking.getBookingId());
	}

	public void displayAllBookings() {
		System.out.println("All Bookings:");
		for (Booking booking : bookingList) {
			Tenant tenant = booking.getTenant();
			Room room = booking.getRoom();
			System.out.println("Booking ID: " + booking.getBookingId() + ", Tenant: " + tenant.getName() + ", Contact: "
					+ tenant.getContactNumber() + ", Room Number: " + room.getRoomNumber() + ", Due Amount: "
					+ booking.calculateRemainingAmount() + ", Booking Date: " + booking.getBookingDate());
		}
	}
	


	public void searchTenantByName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter tenant name to search:");
		String nameToSearch = scanner.nextLine();

		boolean found = false;
		for (Tenant tenant : tenantList) {
			if (tenant.getName().equalsIgnoreCase(nameToSearch)) {
				System.out.println("Tenant found: " + tenant);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("No tenant found with the name: " + nameToSearch);
		}
	}
}
