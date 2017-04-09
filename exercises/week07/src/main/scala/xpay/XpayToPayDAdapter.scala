package xpay

/**
  * Created by yprift01 on 02/04/17.
  */
class XpayToPayDAdapter(val payD: PayD) extends Xpay{

  var cardYear: String = null

  override def getCreditCardNo: String = payD.getCustCardNo

  override def setCreditCardNo(creditCardNo: String): Unit = payD.setCustCardNo(creditCardNo)

  override def getCustomerName: String = payD.getCardOwnerName

  override def setCustomerName(customerName: String): Unit = payD.setCardOwnerName(customerName)

  override def getCardExpMonth: String = payD.getCardExpMonthDate

  override def setCardExpMonth(cardExpMonth: String): Unit = payD.setCardExpMonthDate(cardExpMonth)

  override def getCardExpYear: String = cardYear

  override def setCardExpYear(cardExpYear: String) = {
    cardYear = cardExpYear
  }

  override def getCardCVVNo: Short = payD.getCVVNo.asInstanceOf[Short]

  override def setCardCVVNo(cardCVVNo: Short): Unit = payD.setCVVNo(cardCVVNo.asInstanceOf[Integer])

  override def getAmount: Double = payD.getTotalAmount

  override def setAmount(amount: Double): Unit = payD.setTotalAmount(amount)
}
