package me.davidrosa.autodial.libs

class PhoneNumberProcessor() {

    fun proccessPhoneNumber(phoneNumber: String, carrier: String): String {
        return if ("(0)?(\\d{2})(\\d{8,9})".toRegex().matches(phoneNumber))
            this.addCarrierCodeToPhone(phoneNumber, carrier)
        else
            phoneNumber
    }

    fun addCarrierCodeToPhone(phoneNumber: String, carrier: String): String {
        var newPhoneNumber = phoneNumber
        if(phoneNumber.startsWith("0"))
            // removes the leading 0 in the phone number
            newPhoneNumber = newPhoneNumber.removeRange(0..0)

        return if (carrier.isNullOrEmpty())
            newPhoneNumber
        else "0$carrier$newPhoneNumber"
    }
}