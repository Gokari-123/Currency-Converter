package currency_converter.DTO;


import lombok.Data;

@Data
public class ConversionRequest {

    private String fromCurrency;
    private String toCurrency;
    private double amount;
}
