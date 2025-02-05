package com.salesianostriana.dam.conectapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {

    @EmbeddedId
    private ContactoPK contactoPK;

    private String resumen;
    private String canal;
    private LocalDate fecha;

    @ManyToOne( fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @MapsId("profesorId")
    @JsonIgnore
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @MapsId("trabajadorId")
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Contacto contacto = (Contacto) o;
        return getContactoPK() != null && Objects.equals(getContactoPK(), contacto.getContactoPK());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(contactoPK);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "EmbeddedId = " + contactoPK + ", " +
                "resumen = " + resumen + ", " +
                "canal = " + canal + ", " +
                "fecha = " + fecha + ")";
    }
}
