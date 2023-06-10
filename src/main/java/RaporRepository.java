import org.springframework.data.jpa.repository.JpaRepository;

public interface RaporRepository extends JpaRepository<Rapor, Long> {


}
import org.springframework.stereotype.Repository;

@Repository
public interface RaporRepository extends JpaRepository<Rapor, Long> {
    // Rapor sınıfına özel sorguları veya işlemleri tanımlayabilirsiniz.
}
