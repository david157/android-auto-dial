package me.davidrosa.autodial.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.preference.PreferenceManager
import me.davidrosa.autodial.R
import me.davidrosa.autodial.libs.PhoneNumberProcessor


class CallInterceptor : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        if (sharedPreferences.getBoolean("call_format_enabled", false)) {
            val cspCode = sharedPreferences.getString("csp_code", "")
            val oldNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER)
            val processor = PhoneNumberProcessor()
            val newNumber = processor.proccessPhoneNumber(oldNumber, cspCode)

            this.resultData = newNumber
            if (newNumber != oldNumber) {
                val changedPhoneNumberMessage = context.getString(R.string.changed_number_message)
                val msg = "$changedPhoneNumberMessage $newNumber"
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
            }
        }


    }
}