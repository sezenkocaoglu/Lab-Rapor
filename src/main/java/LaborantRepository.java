import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborantRepository extends JpaRepository<Laborant, Long> {
    // Laborant sınıfına özel sorguları veya işlemleri tanımlayabilirsiniz.
}
