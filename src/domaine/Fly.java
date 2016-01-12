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

    protected Integer firstClassCapacity;

    protected Integer firstClassPrice;

    protected Integer secondClassPrice;

    protected Integer secondClassCapacity;

    protected Integer daysOfResignation;

    public Fly(City origin, City destination, DayOfWeek day, LocalTime hour, Integer duration, Integer firstClassCapacity, Integer firstClassPrice, Integer secondClassCapacity, Integer secondClassPrice, Integer daysOfResignation) {
        this(0L, origin, destination, day, hour, duration, firstClassCapacity, firstClassPrice, secondClassCapacity, secondClassPrice, daysOfResignation);
    }

    public Fly(Long id, City origin, City destination, DayOfWeek day, LocalTime hour, Integer duration, Integer firstClassCapacity, Integer firstClassPrice, Integer secondClassCapacity, Integer secondClassPrice, Integer daysOfResignation) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.day = day;
        this.hour = hour;
        this.duration = duration;
        this.firstClassCapacity = firstClassCapacity;
        this.firstClassPrice = firstClassPrice;
        this.secondClassCapacity = secondClassCapacity;
        this.secondClassPrice = secondClassPrice;
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

    public Integer getFirstClassCapacity() {
        return firstClassCapacity;
    }

    public void setFirstClassCapacity(Integer firstClassCapacity) {
        this.firstClassCapacity = firstClassCapacity;
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

    public Integer getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(Integer firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public Integer getSecondClassPrice() {
        return secondClassPrice;
    }

    public void setSecondClassPrice(Integer secondClassPrice) {
        this.secondClassPrice = secondClassPrice;
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
        if (!firstClassCapacity.equals(fly.firstClassCapacity)) return false;
        if (!firstClassPrice.equals(fly.firstClassPrice)) return false;
        if (!secondClassPrice.equals(fly.secondClassPrice)) return false;
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
        result = 31 * result + firstClassCapacity.hashCode();
        result = 31 * result + firstClassPrice.hashCode();
        result = 31 * result + secondClassPrice.hashCode();
        result = 31 * result + secondClassCapacity.hashCode();
        result = 31 * result + daysOfResignation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vol " + origin.toString() + " - " + destination.toString() + " du " + day + " à " + hour;
    }

    public Long getOriginId() {
        return origin.getId();
    }

    public Long getDestinationId() {
        return destination.getId();
    }
}
