package pl.gren.demo.repository;

import pl.gren.demo.model.EnumRole;
import pl.gren.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(EnumRole name);
}
