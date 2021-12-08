package manager;


import domain.Ticket;
import repository.Repository;

import java.sql.Array;
import java.util.Arrays;
import java.util.Objects;

public class Manager {
    private Repository repository = new Repository();


    public Manager(Repository repository) {
        this.repository = repository;
    }


    public void add(Ticket ticket) {

        repository.save(ticket);
    }

    public Ticket[] getAll() {
        return repository.findAll();
    }


    public Ticket[] search(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getDepartureAirport() .equals(from) && ticket.getArrivalAirport().equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }

        }
        return result;
    }
}

