package id.ac.prisma.bayarjobackend.data.repo;

import id.ac.prisma.bayarjobackend.data.model.TbTransactions;
import org.springframework.data.repository.CrudRepository;

public interface TbTransactionsRepository extends CrudRepository<TbTransactions, Integer> {
}