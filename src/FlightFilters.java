import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilters implements Filters {
    @Override
    public List<Flight> alreadyInFlight(List<Flight> flights) {
        List<Flight> listFlight = new ArrayList<>(flights);
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                    listFlight.remove(flight);
                }
            }
        }
        return listFlight;
    }
    @Override
    public List<Flight> arBefDep(List<Flight> flights) {
        List<Flight> listFlight = new ArrayList<>(flights);
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    listFlight.remove(flight);
                }
            }
        }
        return listFlight;
    }
    @Override
    public List<Flight> grTime(List<Flight> flights) {
        int onGround;
        List<Flight> listFlight = new ArrayList<>(flights);
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            onGround = 0;
            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    onGround += Math.abs(Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours());
                }
                if (onGround > 2) {
                    listFlight.remove(flight);
                }
            }
        }
        return listFlight;
    }
}