package currency_converter.Repository;

import currency_converter.Entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate,Long> {
    Optional<CurrencyRate> findByFromCurrencyAndToCurrency(String from, String to);
}
