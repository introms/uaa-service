package it.itresources.demo.micro.uaaservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.itresources.demo.micro.uaaservice.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findOneByName(String name);
    
}