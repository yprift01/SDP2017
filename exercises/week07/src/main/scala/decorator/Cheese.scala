package decorator

class Cheese(val pizza: Pizza)
      extends BasePizza(pizza, 20.72, "Cheese") {}
