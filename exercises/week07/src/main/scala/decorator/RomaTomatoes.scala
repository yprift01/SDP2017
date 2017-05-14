package decorator

class RomaTomatoes( val pizza: Pizza)
  extends BasePizza(pizza, 5.20, "Roma Tomatoes") {}

