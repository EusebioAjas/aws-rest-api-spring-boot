package com.aws.sicei.api.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @PositiveOrZero(message = "Debe especificar un identificador valido para el profesor")
    private Long id = Long.MIN_VALUE;

    @Column
    @NotNull
    @Min(value = 1, message = "El número del empleado deber ser mayor a 1")
    private Long numeroEmpleado = Long.MIN_VALUE;

    @Column
    @NotNull
    @Size(min = 5, message = "Los nombres deben tener un minimo de 5 caracteres")
    private String nombres;

    @Column
    @NotNull
    @Size(min = 5, message = "Los apellidos deben de tener un minimo de 5 caracteres")
    private String apellidos;

    @Column
    @Min(value = 0, message = "El número de horas de clases deber ser positivo")
    private Integer horasClase = Integer.MIN_VALUE;

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(Long numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
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

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(numeroEmpleado, teacher.numeroEmpleado) && Objects.equals(nombres, teacher.nombres) && Objects.equals(apellidos, teacher.apellidos) && Objects.equals(horasClase, teacher.horasClase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroEmpleado, nombres, apellidos, horasClase);
    }
}
