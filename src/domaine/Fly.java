package domaine;

import domaine.destination.City;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * I am a class that describe a fly.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Fly implements DAOSerializable {

    protected Long id;

    protected City origin;

    protected City destination;

    protected DayOfWeek day;

    protected LocalTime hour;

    protected Integer duration;

    protected Integer firstTimeCapacity;

    protected Integer secondClassCapacity;

    protected Integer daysOfResignation;

    public Fly(City origin, City destination, DayOfWeek day, LocalTime hour, Integer duration, Integer firstTimeCapacity, Integer secondClassCapacity, Integer daysOfResignation) {
        this(0L, origin, destination, day, hour, duration, firstTimeCapacity, secondClassCapacity, daysOfResignation);
    }

    public Fly(Long id, City origin, City destination, DayOfWeek day, LocalTime hour, Integer duration, Integer firstTimeCapacity, Integer secondClassCapacity, Integer daysOfResignation) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.day = day;
        this.hour = hour;
        this.duration = duration;
        this.firstTimeCapacity = firstTimeCapacity;
        this.secondClassCapacity = secondClassCapacity;
        this.daysOfResignation = daysOfResignation;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getFirstTimeCapacity() {
        return firstTimeCapacity;
    }

    public void setFirstTimeCapacity(Integer firstTimeCapacity) {
        this.firstTimeCapacity = firstTimeCapacity;
    }

    public Integer getSecondClassCapacity() {
        return secondClassCapacity;
    }

    public void setSecondClassCapacity(Integer secondClassCapacity) {
        this.secondClassCapacity = secondClassCapacity;
    }

    public Integer getDaysOfResignation() {
        return daysOfResignation;
    }

    public void setDaysOfResignation(Integer daysOfResignation) {
        this.daysOfResignation = daysOfResignation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fly)) return false;

        Fly fly = (Fly) o;

        if (!origin.equals(fly.origin)) return false;
        if (!destination.equals(fly.destination)) return false;
        if (day != fly.day) return false;
        if (!hour.equals(fly.hour)) return false;
        if (!duration.equals(fly.duration)) return false;
        if (!firstTimeCapacity.equals(fly.firstTimeCapacity)) return false;
        if (!secondClassCapacity.equals(fly.secondClassCapacity)) return false;
        return daysOfResignation.equals(fly.daysOfResignation);

    }

    @Override
    public int hashCode() {
        int result = origin.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + day.hashCode();
        result = 31 * result + hour.hashCode();
        result = 31 * result + duration.hashCode();
        result = 31 * result + firstTimeCapacity.hashCode();
        result = 31 * result + secondClassCapacity.hashCode();
        result = 31 * result + daysOfResignation.hashCode();
        return result;
    }

    public Long getOriginId() {
        return origin.getId();
    }

    public Long getDestinationId() {
        return destination.getId();
    }
}
