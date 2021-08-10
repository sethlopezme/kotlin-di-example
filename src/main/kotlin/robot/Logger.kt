package robot

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Logger @Inject constructor() {
    fun log(message: String? = "") {
        println(message)
    }
}