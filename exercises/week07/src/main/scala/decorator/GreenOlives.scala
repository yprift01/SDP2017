package decorator

class GreenOlives( val pizza: Pizza)
        extends BasePizza(pizza, 5.47, "Green Olives") {}
