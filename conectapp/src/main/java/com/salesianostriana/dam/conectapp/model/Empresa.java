package com.salesianostriana.dam.conectapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cif;
    private String direccion;
    private String coordenadas;
    private String nombre;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Trabajador> trabajadores = new HashSet<>();



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "empresa_familia_profesional",
        joinColumns = @JoinColumn(name = "empresa_id"),
        inverseJoinColumns = @JoinColumn(name = "familia_profesional_id"),
        foreignKey = @ForeignKey(name = "fk_empresa_familia_profesional"),
        inverseForeignKey = @ForeignKey(name = "fk_familia_profesional_empresa"))
    @Builder.Default
    @ToString.Exclude
    private Set<FamiliaProfesional> familiasProfesionales = new HashSet<>();

    //Helpers Empresa - FamiliaProfesional
    public void addFamiliaProfesional(FamiliaProfesional fp){
        this.familiasProfesionales.add(fp);
        fp.getEmpresas().add(this);
    }

    public void removeFamiliaProfesional(FamiliaProfesional fp){
        this.familiasProfesionales.remove(fp);
        fp.getEmpresas().remove(this);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Empresa empresa = (Empresa) o;
        return getId() != null && Objects.equals(getId(), empresa.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
