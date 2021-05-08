package br.com.mysafeestablishment.repository.company;

import br.com.mysafeestablishment.domain.company.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByEmailAndPassword(String email,String password);

    Owner findByEmailOrCpfOrPhoneNumber(String email,String cpf, String phoneNumber);
}
