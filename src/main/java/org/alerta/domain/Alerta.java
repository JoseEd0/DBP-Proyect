package org.alerta.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.route.domain.Route;

import java.util.List;

@Data
@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Color color;
    private String description;

    public Alerta() {}

    public Alerta(Color color, String description) {
        this.color = color;
        this.description = description;
    }
    @OneToMany(mappedBy = "alert", cascade = CascadeType.ALL)
    private List<Route> routes;

    public Long getIdAlerta() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color= color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}