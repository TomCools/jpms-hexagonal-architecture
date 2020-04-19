package be.tomcools.javamod.infra.persistance.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import be.tomcools.javamod.infra.persistance.spring.entity.BeerEntity;

@Repository
public interface BeerRepositorySpring extends JpaRepository<BeerEntity, Long> {

}
