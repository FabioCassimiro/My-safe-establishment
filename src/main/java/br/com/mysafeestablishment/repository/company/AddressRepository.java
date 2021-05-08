package br.com.mysafeestablishment.repository.company;

import br.com.mysafeestablishment.domain.company.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
