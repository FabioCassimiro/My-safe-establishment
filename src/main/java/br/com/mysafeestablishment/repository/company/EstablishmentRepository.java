package br.com.mysafeestablishment.repository.company;

import br.com.mysafeestablishment.domain.company.Establishment;
import org.springframework.data.repository.CrudRepository;

public interface EstablishmentRepository extends CrudRepository<Establishment,Long> {
    Establishment findByCompanyNameOrCnpj(String companyName, String cnpj);
}
