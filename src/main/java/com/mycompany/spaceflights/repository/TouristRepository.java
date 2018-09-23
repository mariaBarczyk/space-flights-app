package com.mycompany.spaceflights.repository;

import com.mycompany.spaceflights.domain.Tourist;
import org.springframework.data.repository.CrudRepository;

public interface TouristRepository extends CrudRepository<Tourist, Long> {

}
