package singleton

/**
  * Created by yprift01 on 22/04/17.
  */


/**
  * Eager Singleton, the instance is initialized on object definition.
  * Useful when you need the functionality to have some delay when starting but to be fust during execution
  */
class SingletonEager private () {}

object SingletonEager{
  private val _instance = new SingletonEager
  def instance() = _instance
}

class SingletonLazy private() {}

object SingletonLazy {
  private var _instance:SingletonLazy = null;
  def instance() = {
    if(_instance == null)
       _instance = new SingletonLazy
    _instance
  }
}

class SingletonProtectedScala private() { }

object SingletonProtectedScala {
  private var _instance:SingletonProtectedScala = null

   def instance()  = {
      if (_instance == null ) classOf[SingletonProtectedScala] synchronized {
         if (_instance == null) {
             _instance = new SingletonProtectedScala
          }
       }
      _instance
    }

  override def clone(): AnyRef = {
    throw new CloneNotSupportedException("This is a Singleton and cannot be clonned")
  }

}


