package decorator

class Meat( val pizza: Pizza)
  extends BasePizza(pizza, 14.25, "Meat") {}

