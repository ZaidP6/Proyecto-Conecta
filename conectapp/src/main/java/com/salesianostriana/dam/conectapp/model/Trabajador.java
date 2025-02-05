package com.salesianostriana.dam.conectapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Trabajador extends Persona{
     private String puesto;
     private String area;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "empresa_id")
     @JsonBackReference
     private Empresa empresa;



     @Override
     public final boolean equals(Object o) {
          if (this == o) return true;
          if (o == null) return false;
          Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
          Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
          if (thisEffectiveClass != oEffectiveClass) return false;
          Trabajador that = (Trabajador) o;
          return getId() != null && Objects.equals(getId(), that.getId());
     }

     @Override
     public final int hashCode() {
          return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
     }
}
