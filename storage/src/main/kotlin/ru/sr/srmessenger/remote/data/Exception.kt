package ru.sr.srmessenger.remote.data

class NonAuthException : Exception("User not Auth")
class NonGoogleAccountException : Exception("User does not have a google account")
class TimeOutException : Exception("Timeout exceeded")
class UnSupportException : Exception("Something didn't go according to plan")