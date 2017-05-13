package observer

import scala.collection.mutable.ListBuffer

/**
  * Created by yprift01 on 13/05/17.
  */
class CommentaryObjectObservable (val title: String) extends Subject with Commentary {


  private val _subscribers = new ListBuffer[Observer]
  private var _newUpdate: String = ""

  def subscribeObserver(observer: Observer) = _subscribers.append(observer)

  def unSubscribeObserver(observer: Observer) = {
    val index = _subscribers.indexOf(observer)
    if(index >= 0) _subscribers.remove(index)
  }
  override def subjectDetails = title + ": " + _newUpdate

  def notifyObservers() = _subscribers.foreach(obs => obs.update(subjectDetails))

  override def setDesc(desc: String) = {
    _newUpdate = desc
    notifyObservers()
  }

}


