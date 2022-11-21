package id.ac.prisma.bayarjobackend.data.repo;

import id.ac.prisma.bayarjobackend.data.model.TbMerchant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TbMerchantRepository extends CrudRepository<TbMerchant, Integer> {
    Optional<TbMerchant> findByEmail(String email);
}


