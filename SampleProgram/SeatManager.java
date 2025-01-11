package SampleProgram;

public interface SeatManager {
    boolean bookSeat(int seatNumber);
    boolean cancelSeat(int seatNumber);
    boolean isSeatAvailable(int seatNumber);
    int getAvailableSeats();
}

