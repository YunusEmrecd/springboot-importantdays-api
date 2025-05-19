package com.example.importantdays.service;

import com.example.importantdays.dto.Eventdto;
import com.example.importantdays.model.Event;
import com.example.importantdays.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Eventdto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Eventdto addEvent(Eventdto eventDto) {
        Event event = toEntity(eventDto);
        Event saved = eventRepository.save(event);
        System.out.println("Event added: " + eventDto);
        return toDto(saved);

    }

    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
        System.out.println("Event with id " + id + " deleted.");
    }

    public Eventdto getClosestEvent() {
        LocalDate now = LocalDate.now();
        Eventdto closestEvent= eventRepository.findAll().stream()
                .filter(event -> event.getDate().isAfter(now))
                .min((e1, e2) -> e1.getDate().compareTo(e2.getDate()))
                .map(this::toDto)
                .orElse(null);
                System.out.println("Closest event: " + closestEvent);
                return closestEvent;
    }

    private Eventdto toDto(Event event) {
        return new Eventdto(
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getDate()
        );
    }

    private Event toEntity(Eventdto dto) {
        Event event = new Event();
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setDate(dto.getDate());
        return event;
    }
}