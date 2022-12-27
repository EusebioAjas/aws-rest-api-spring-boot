package com.aws.sicei.api.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @PositiveOrZero(message = "Debe especificar un identificador valido para el alumno")
    private Long id = Long.MIN_VALUE;

    @Column
    @NotNull
    @Size(min = 5, message = "Los nombres deben tener un minímo de 5 caracteres")
    private String nombres;

    @Column
    @NotNull
    @Size(min = 5, message = "Los apellidos deben tener un minimo de 5 caracteres")
    private String apellidos;

    @Column
    @NotNull
    private String matricula;

    @Column
    @NotNull
    @DecimalMin(value = "0.0", message = "El promedio debe ser mayor a 0")
    @DecimalMax(value = "100.0", message = "El promedio debe ser menor a 100")
    private double promedio = Double.MIN_VALUE;

    public Student() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.promedio, promedio) == 0 && Objects.equals(id, student.id) && Objects.equals(nombres, student.nombres) && Objects.equals(apellidos, student.apellidos) && Objects.equals(matricula, student.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombres, apellidos, matricula, promedio);
    }
}
