package it.epicode.economicair.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.economicair.model.Role;
import it.epicode.economicair.model.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	public Optional<Role> findByRoleName(Roles name);
}
