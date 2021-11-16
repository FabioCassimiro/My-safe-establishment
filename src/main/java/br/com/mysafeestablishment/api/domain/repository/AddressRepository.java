package br.com.mysafeestablishment.api.domain.repository;

import br.com.mysafeestablishment.api.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
