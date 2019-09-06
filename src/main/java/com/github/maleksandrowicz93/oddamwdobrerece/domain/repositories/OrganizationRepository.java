package com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization findFirstById(Long id);
    Organization findFirstByName(String name);

    @Query(value = "select COUNT(id) from organizations", nativeQuery = true)
    Long countAllOrganizations();

}
