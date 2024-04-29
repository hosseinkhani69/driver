package com.example.appointment.dirver.orm;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "model_vehicle")
    private String modelVehicle;

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(getId(), driver.getId()) && Objects.equals(getName(), driver.getName()) && Objects.equals(getFullName(), driver.getFullName()) && Objects.equals(getModelVehicle(), driver.getModelVehicle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFullName(), getModelVehicle());
    }
}
