package xpay

/**
  * Created by yprift01 on 13/05/17.
  */
class XpayToPayDAdapter(payD: PayD) extends Xpay{

  private var _expMonth:String = ""
  private var _expYear:String = ""

  private def setExpDate = payD.setCardExpMonthDate(_expMonth +"-"+_expYear)

  override def getCreditCardNo: String = payD.getCustCardNo

  override def setCreditCardNo(creditCardNo: String) = payD.setCustCardNo(creditCardNo)

  override def setCustomerName(customerName: String) = payD.setCardOwnerName(customerName)

  override def getCustomerName: String = payD.getCardOwnerName

  //Format dd-yyyy
  override def getCardExpMonth: String = _expMonth

  override def setCardExpMonth(cardExpMonth: String) = {
    _expMonth = cardExpMonth
    setExpDate
  }

  override def getCardExpYear: String = _expYear

  override def setCardExpYear(cardExpYear: String) = {
    _expYear = cardExpYear
    setExpDate
  }

  override def getCardCVVNo: Short = {
     payD.getCVVNo.toShort
  }

  override def setCardCVVNo(cardCVVNo: Short) = {
    payD.setCVVNo(cardCVVNo.toInt)
  }

  override def getAmount: Double = {
    payD.getTotalAmount
  }

  override def setAmount(amount: Double) = {
    payD.setTotalAmount(amount)
  }

}
