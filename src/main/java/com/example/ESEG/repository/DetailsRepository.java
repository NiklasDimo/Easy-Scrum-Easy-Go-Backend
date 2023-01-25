package com.example.ESEG.repository;

import com.example.ESEG.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DetailsRepository extends CrudRepository<Details, Long> {

    Details findByProductId(Long productId);

}
