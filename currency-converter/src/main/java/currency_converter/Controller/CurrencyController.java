package currency_converter.Controller;


import currency_converter.DTO.ConversionRequest;
import currency_converter.Entity.CurrencyRate;
import currency_converter.Service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController{

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/add-rate")
    public ResponseEntity<CurrencyRate> addRate(@RequestBody CurrencyRate rate){
                  return new ResponseEntity<>(currencyService.addRate(rate), HttpStatus.CREATED);
    }

    @GetMapping("/all-rates")
    public ResponseEntity<List<CurrencyRate>> getAllRates(){
        List<CurrencyRate> rate=currencyService.getAllRates();
        return ResponseEntity.ok(rate);
    }

    @PostMapping("/convert")
    public  double convertCurrency(@RequestBody ConversionRequest request){
    return currencyService.convert(request.getFromCurrency(),request.getToCurrency(),request.getAmount());
    }
}
