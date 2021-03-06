package module5.homeWork5.neVernoe;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

/**
 * Java#6
 * Module 5 Task 4
 * Create three implementations of API called: BookingComAPI, TripAdvisorAPI, GoogleAPI.
 * Every implementation has global variable Room[] rooms which must be initialized
 * in empty constructor with 5 differentRooms.
 *
 * @author Kontar Maryna
 */
public class BookingComAPI implements API {

    private static DAO Dao = new DAOImplementation();

    public static Room[] rooms;

    public BookingComAPI() {

        rooms = Dao.createDB();
        rooms[0] = new Room(1, 100, 2, LocalDate.of(2017, Month.MARCH, 12), "Marriott", "London");
        rooms[1] = new Room(6, 500, 3, LocalDate.of(2017, Month.FEBRUARY, 28), "Four Seasons", "Madrid");
        rooms[2] = new Room(2, 200, 1, LocalDate.of(2017, Month.APRIL, 25), "Hyatt", "Kiev");
        rooms[3] = new Room(7, 500, 3, LocalDate.of(2017, Month.FEBRUARY, 23), "Four Seasons", "Madrid");
//        rooms[2] = new Room(3, 300, 2, LocalDate.of(2017, Month.MAY, 10),"Hilton", "New York");
//        rooms[3] = new Room(4, 200, 1, LocalDate.of(2017, Month.JUNE, 1),"Ritz", "Kiev");
        rooms[4] = new Room(8, 500, 3, LocalDate.of(2017, Month.FEBRUARY, 25), "Four Seasons", "Madrid");
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        Room lookingForRoom = new Room(0, price, persons, null, hotel, city);
        Room[] lookingForRoomsArray = new Room[0];

        for (int i = 0; i < rooms.length; i++) {

            if (lookingForRoom.equals(rooms[i]) && rooms[i].getHotelName() == hotel)
                lookingForRoomsArray = addElementToArray(lookingForRoomsArray, rooms[i]);
        }
        return lookingForRoomsArray;
    }

    private Room[] addElementToArray(Room[] roomsArray, Room newRoomsMember) {

        Room[] newRoomsArray = Arrays.copyOf(roomsArray, roomsArray.length + 1);
        newRoomsArray[newRoomsArray.length - 1] = newRoomsMember;
        return newRoomsArray;
    }
}
