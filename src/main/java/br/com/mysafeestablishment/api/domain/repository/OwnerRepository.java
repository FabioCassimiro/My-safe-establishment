package br.com.mysafeestablishment.api.domain.repository;

import br.com.mysafeestablishment.api.domain.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByEmail(String email);
}
