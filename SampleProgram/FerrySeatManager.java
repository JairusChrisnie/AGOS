package SampleProgram;

import java.util.HashSet;
import java.util.Set;

public class FerrySeatManager implements SeatManager {
    private Set<Integer> takenSeats = new HashSet<>();
    private final int totalSeats;

    public FerrySeatManager(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public boolean bookSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > totalSeats || takenSeats.contains(seatNumber)) {
            return false;
        }
        takenSeats.add(seatNumber);
        return true;
    }

    @Override
    public boolean cancelSeat(int seatNumber) {
        return takenSeats.remove(seatNumber);
    }

    @Override
    public boolean isSeatAvailable(int seatNumber) {
        return !takenSeats.contains(seatNumber);
    }

    @Override
    public int getAvailableSeats() {
        return totalSeats - takenSeats.size();
    }
}

