package observer

/**
  * Created by yprift01 on 13/05/17.
  */
class SMSUsersObserver(subject: Subject, message: String) extends Observer {

  override def update(desc: String) = println(message + ": " + desc)

  override def subscribe() = subject.subscribeObserver(this)

  override def unSubscribe() = subject.unSubscribeObserver(this)


}
