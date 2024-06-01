package org.vehicle.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.user.domain.User;

@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTransporte;

    private String name;

    private String nick;

    public Vehicle() {}

    public Vehicle(String name, String nick) {
        this.name = name;
        this.nick = nick;
    }
    @ManyToOne
    private User user;

    public Long getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Long idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}