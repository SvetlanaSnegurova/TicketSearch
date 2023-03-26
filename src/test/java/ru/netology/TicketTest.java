package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketTest {

    @Test
    public void sortTicketPrice() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 1000, "MSK", "SPB", 90);
        Ticket ticket2 = new Ticket(2, 1000, "KRD", "SPB", 90);
        Ticket ticket3 = new Ticket(3, 2000, "KRD", "AER", 60);
        Ticket ticket4 = new Ticket(4, 1500, "MSK", "SPB", 120);
        Ticket ticket5 = new Ticket(5, 500, "KRD", "SPB", 70);
        Ticket ticket6 = new Ticket(6, 1000, "AER", "KRD", 60);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket1, ticket4};
        Ticket[] actual = manager.findAll("MSK", "SPB");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketPrice2() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 1000, "MSK", "SPB", 90);
        Ticket ticket2 = new Ticket(2, 1000, "KRD", "SPB", 90);
        Ticket ticket3 = new Ticket(3, 2000, "KRD", "AER", 60);
        Ticket ticket4 = new Ticket(4, 1500, "MSK", "SPB", 120);
        Ticket ticket5 = new Ticket(5, 500, "KRD", "SPB", 70);
        Ticket ticket6 = new Ticket(6, 1000, "AER", "KRD", 60);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket5, ticket2};
        Ticket[] actual = manager.findAll("KRD", "SPB");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortAllTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 1000, "KRD", "MSK", 90);
        Ticket ticket2 = new Ticket(2, 1000, "KRD", "MSK", 90);
        Ticket ticket3 = new Ticket(3, 2000, "KRD", "MSK", 60);
        Ticket ticket4 = new Ticket(4, 1500, "KRD", "MSK", 120);
        Ticket ticket5 = new Ticket(5, 500, "KRD", "MSK", 70);
        Ticket ticket6 = new Ticket(6, 1000, "KRD", "MSK", 60);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket5, ticket1, ticket2, ticket6, ticket4, ticket3};
        Ticket[] actual = manager.findAll("KRD", "MSK");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void noSortTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 1000, "KRD", "MSK", 90);
        Ticket ticket2 = new Ticket(2, 1000, "KRD", "AER", 90);
        Ticket ticket3 = new Ticket(3, 2000, "KRD", "SPB", 60);
        Ticket ticket4 = new Ticket(4, 1500, "KRD", "EKB", 120);
        Ticket ticket5 = new Ticket(5, 500, "KRD", "AER", 70);
        Ticket ticket6 = new Ticket(6, 1000, "KRD", "BRK", 60);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MSK", "KRD");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void TravelTime() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 1000, "KRD", "MSK", 90);
        Ticket ticket2 = new Ticket(2, 1000, "KRD", "AER", 90);
        Ticket ticket3 = new Ticket(3, 2000, "KRD", "SPB", 60);
        Ticket ticket4 = new Ticket(4, 1500, "KRD", "EKB", 120);
        Ticket ticket5 = new Ticket(5, 500, "KRD", "AER", 70);
        Ticket ticket6 = new Ticket(6, 1000, "KRD", "BRK", 60);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        ticket1.getTravelTime();

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 1000, "KRD", "MSK", 90);
        Ticket ticket2 = new Ticket(2, 1000, "KRD", "AER", 90);
        Ticket ticket3 = new Ticket(3, 2000, "KRD", "SPB", 60);
        Ticket ticket4 = new Ticket(4, 1500, "KRD", "EKB", 120);
        Ticket ticket5 = new Ticket(5, 500, "KRD", "AER", 70);
        Ticket ticket6 = new Ticket(6, 1000, "KRD", "BRK", 60);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] actual = {repo.findById(2)};
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }
}
