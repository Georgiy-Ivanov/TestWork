import java.util.List;

public interface Filters {
    List<Flight> alreadyInFlight(List<Flight> flights);
    List<Flight> arBefDep(List<Flight> flights);
    List<Flight> grTime(List<Flight> flights);
}