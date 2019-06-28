package it.itresources.demo.micro.uaaservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.itresources.demo.micro.uaaservice.domain.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {}