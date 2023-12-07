package Insurance;

import java.time.LocalDate;

public class CarInsurance extends Insurance{
    public CarInsurance(String name, double price) {
        super.setName(name);
        super.setPrice(price);
        startingDate = LocalDate.now();
        super.setStartingDate(startingDate);
        endDate = startingDate.plusYears(2);
        super.setEndDate(endDate);
    }

    @Override
    public double calculate() {
        return 0.0;
    }
}
