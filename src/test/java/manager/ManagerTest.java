package manager;

import org.junit.jupiter.api.Test;
import domain.Ticket;
import repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private final Repository repository = new Repository();
    private Manager manager = new Manager(repository);

    private Ticket fromMoscowToKazanMorningSVOKZN = new Ticket(1, 1200, "SVO", "KZN", 90);
    private Ticket fromMoscowToKazanMorningVKOKZN = new Ticket(2, 1500, "VKO", "KZN", 90);
    private Ticket fromMoscowToKazanMorningDMEKZN = new Ticket(3, 1750, "DME", "KZN", 90);
    private Ticket fromMoscowToKazanEveningDMEKZN = new Ticket(4, 2250, "DME", "KZN", 90);
    private Ticket fromMoscowToKazanEveningVKOKZN = new Ticket(14, 2700, "DME", "KZN", 100);
    private Ticket fromMoscowToPiterEveningVKOLED = new Ticket(5, 2000, "VKO", "KZN", 90);
    private Ticket fromMoscowToNizhnekamskMorningVKONBC = new Ticket(6, 2600, "VKO", "NBC", 95);
    private Ticket fromMoscowToNizhnekamskMorningSVONBC = new Ticket(7, 3700, "SVO", "NBC", 120);
    private Ticket fromMoscowToNizhnekamskEveningSVONBC = new Ticket(8, 2300, "SVO", "NBC", 100);
    private Ticket fromPiterToMoscowMorningLEDVKO = new Ticket(9, 1500, "LED", "VKO", 90);
    private Ticket fromPiterToMoscowEveningLEDSVO = new Ticket(10, 1800, "LED", "SVO", 85);
    private Ticket fromPiterToMoscowEveningLEDVKO = new Ticket(11, 1900, "LED", "VKO", 90);
    private Ticket fromPiterToMoscowEveningLEDDME = new Ticket(12, 2500, "LED", "DME", 90);
    private Ticket fromPiterToMoscowMorningLEDDME = new Ticket(13, 2700, "LED", "DME", 80);
    private Ticket fromMoscowToPiterMorningDMELED = new Ticket(15, 2000, "DME", "LED", 120);


    @Test
    public void shouldSearchFreeTicketsNot() {
        String fromAirport = "DME";
        String toAirport = "LED";

        manager.add(fromPiterToMoscowMorningLEDDME);
        manager.add(fromMoscowToKazanEveningVKOKZN);
        manager.add(fromPiterToMoscowEveningLEDDME);
        manager.add(fromMoscowToKazanMorningDMEKZN);
        manager.add(fromMoscowToPiterEveningVKOLED);


        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.search(fromAirport, toAirport);


        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFourTicketsOutOfSeven() {
        String fromAirport = "KZN";
        String toAirport = "SVO";

        manager.add(fromMoscowToKazanMorningSVOKZN);
        manager.add(fromMoscowToKazanMorningDMEKZN);
        manager.add(fromMoscowToPiterEveningVKOLED);
        manager.add(fromMoscowToKazanEveningVKOKZN);
        manager.add(fromPiterToMoscowEveningLEDDME);
        manager.add(fromPiterToMoscowMorningLEDDME);
        manager.add(fromMoscowToPiterMorningDMELED);

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.search(fromAirport, toAirport);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicketsOutOfSeven() {
        String fromAirport = "VKO";
        String toAirport = "LED";

        manager.add(fromMoscowToKazanMorningSVOKZN);
        manager.add(fromMoscowToKazanMorningDMEKZN);
        manager.add(fromMoscowToPiterEveningVKOLED);
        manager.add(fromMoscowToKazanEveningVKOKZN);
        manager.add(fromPiterToMoscowEveningLEDDME);
        manager.add(fromPiterToMoscowMorningLEDDME);
        manager.add(fromMoscowToPiterMorningDMELED);

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.search(fromAirport, toAirport);


        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTickets() {
        String fromAirport = "SVO";
        String toAirport = "KZN";

        manager.add(fromMoscowToKazanMorningSVOKZN);
        manager.add(fromMoscowToKazanMorningDMEKZN);
        manager.add(fromMoscowToPiterEveningVKOLED);
        manager.add(fromMoscowToKazanEveningVKOKZN);
        manager.add(fromPiterToMoscowEveningLEDDME);
        manager.add(fromPiterToMoscowMorningLEDDME);
        manager.add(fromMoscowToPiterMorningDMELED);

        Ticket[] expected = new Ticket[]{fromMoscowToKazanMorningSVOKZN};
        Ticket[] actual = manager.search(fromAirport, toAirport);

        assertArrayEquals(expected, actual);
    }

}
