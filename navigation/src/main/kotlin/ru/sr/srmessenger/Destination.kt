package ru.sr.srmessenger

interface Destination{
   val route:String
}

sealed class AuthFlow(override val route:String):Destination  {
    object Auth : AuthFlow("Auth")
}