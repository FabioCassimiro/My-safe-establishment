package br.com.mysafeestablishment.api.domain.repository;

import br.com.mysafeestablishment.api.domain.Establishment;
import org.springframework.data.repository.CrudRepository;

public interface EstablishmentRepository extends CrudRepository<Establishment,Long> {
    Establishment findByCompanyNameOrCnpj(String companyName, String cnpj);
}
