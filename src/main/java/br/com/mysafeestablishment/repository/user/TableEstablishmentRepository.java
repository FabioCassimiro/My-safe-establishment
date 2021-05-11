package br.com.mysafeestablishment.repository.user;

import br.com.mysafeestablishment.domain.TableEstablishment;
import org.springframework.data.repository.CrudRepository;

public interface TableEstablishmentRepository extends CrudRepository<TableEstablishment,Long> {
    TableEstablishment findByIdAndAndStatusTable(long tableId,String status);
}
