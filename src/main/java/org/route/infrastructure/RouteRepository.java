package org.route.infrastructure;

import org.route.domain.Route;
import org.route.domain.RouteVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}