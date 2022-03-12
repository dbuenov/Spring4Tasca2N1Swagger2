package cat.dbuenov.app.dades;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.dbuenov.app.bean.Empleat;

public interface BaseDeDades extends JpaRepository<Empleat, Long>{

}
