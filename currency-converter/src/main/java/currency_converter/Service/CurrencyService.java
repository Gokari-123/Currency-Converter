package currency_converter.Service;


import currency_converter.Entity.CurrencyRate;
import currency_converter.Repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;


    public CurrencyRate addRate(CurrencyRate rate){
        return currencyRateRepository.save(rate);
    }

    public List<CurrencyRate> getAllRates(){
     return currencyRateRepository.findAll();
    }

    public double convert(String from,String to,double amount){
        CurrencyRate rate=currencyRateRepository.findByFromCurrencyAndToCurrency(from,to).
                orElseThrow(()-> new RuntimeException("Exchange rate not found"));
        return amount * rate.getRate();
    }
}
