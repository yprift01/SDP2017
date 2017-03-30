//package labs

object Week01Lab01 {

 def loopStm() = {
 var number = -1
 while (number != 0){
      print("Enter number (0 to exit) > ")
      number = readLine.toInt
      if (number==0) { print("Done") } 
      else {
      print("Number :")
      print(number)
      print(" Squared :")
      println(number*number)
	}
      }
   }

 def printSquared(num: Int) = {
   for (x <- 1 to num) 
	println("num :" + x + " squared :" + (x*x))
 }

 def isEven(num: Int): Boolean = {
   num%2==0
 }

}
