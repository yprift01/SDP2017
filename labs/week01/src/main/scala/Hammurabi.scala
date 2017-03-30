package labs

import scala.util.Random

object Hammurabi {
	def printIntroductoryMessage() = {
		println("""
            	Congratulations, you are the newest ruler of ancient Samaria, elected
							for a ten year term of office. Your duties are to dispense food, direct
							farming, and buy and sell land as needed to support your people. Watch
							out for rat infestations and the plague! Grain is the general currency,
							measured in bushels. The following will help you in your decisions:
									* Each person needs at least 20 bushels of grain per year to survive.
									* Each person can farm at most 10 acres of land.
									* It takes 2 bushels of grain to farm an acre of land.
									* The market price for land fluctuates yearly.
							Rule wisely and you will be showered with appreciation at the end of
							your term. Rule poorly and you will be kicked out of office! """)


	    } 

    def hammurabi() = {

	var starved = 0
	var immigrants = 5
	var population = 100
	var harvest = 3000
	var bushelsPerAcre = 3
	var rats_ate = 200
	var bushelsInStorage = 2800
	var acresOwned = 1000
	var pricePerAcre = 19
	var plagueDeaths = 0

			printIntroductoryMessage

	for (i <- 0 to 10){ 
	var j = i+1
		println(s"""
		$i great Hammurabi!
 		You are in year $j of your ten year rule.
		In the previous year $starved people starved to death.
		In the previous year $immigrants people entered the kingdom.
	 	The population is now $population.
		We harvested $harvest bushels at $bushelsPerAcre bushels per acre.
 		Rats destroyed $rats_ate bushels, leaving $bushelsInStorage bushels in storage.
		The city owns $acresOwned acres of land.
		Land is currently worth $pricePerAcre bushels per acre.
		There were $plagueDeaths deaths from the plague.""")

    val toBuy = getToBuy()
    var toSell = 0
	if(toBuy<=0)
	   toSell = readInt("How many acres of land to sell :");
	var toFeed = readInt("How much grain to feed to the people :");
	var toPlant = readInt("How many acres to plant with seed :");



	  }

}

  def getToBuy():Int= {
    val toBuy = readInt("How many acres of land to buy :");
    toBuy
  }

	def readInt(message: String): Int = {		
		try {
      print(message);
		 scala.io.StdIn.readInt()
	} catch {
	case _ : Throwable =>
		println("That’s not an integer. Please enter an integer.")
    print(message);
    scala.io.StdIn.readInt()
	   }
	} 

}
