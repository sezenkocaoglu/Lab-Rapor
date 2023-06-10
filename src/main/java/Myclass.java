import javax.persistence.*;

@Entity
@Table(name = "laborant")
public class Laborant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;

    private String soyad;

    private String hastaneKimlikNo;

    // Getter ve setter metotları

    // Diğer işlevsel metotlar
}

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rapor")
public class Rapor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dosyaNumarasi;

    private String hastaAdi;

    private String hastaSoyadi;

    private String hastaKimlikNo;

    private String koyulanTaniBasligi;

    private String taniDetaylari;

    private LocalDate raporVerilisTarihi;

    private String fotoDosyaAdi;

    // Getter ve setter metotları

    // Diğer işlevsel metotlar
}
