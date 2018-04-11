
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mauryagnes/IdeaProjects/test_garage/conf/routes
// @DATE:Wed Apr 11 16:56:13 CEST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
