package calculator

import com.techverito.calculator.Calculator
import spock.lang.Specification

class CalculatorSpecification extends Specification {

    void setup() {

    }

    def "should return subscription amount"() {

        when:
        long subscriptionAmount = Calculator.getSubscriptionAmount(cost, numberOfMonths)

        then:
        subscriptionAmount == result

        where:
        cost | numberOfMonths | result
        100  | 1              | 100
        100  | 2              | 200
        200  | 1              | 200
    }

    def "should return discount amount"() {

        when:
        long discount = Calculator.getDiscount(cost, numberOfMonths)

        then:
        discount == result

        where:
        cost | numberOfMonths | result
        100  | 1              | 0
        100  | 3              | 10
        100  | 4              | 10
    }

}
