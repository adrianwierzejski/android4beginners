package com.daftmobile.a4bhomework3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

const val REQUEST_SELECT_CONTACT = 1
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EMAIL_RETRIEVER = EmailRetriever.Impl(applicationContext)
        sendMailButton.setOnClickListener(this::onButtonClicked)
    }

    private fun onButtonClicked(viev:View){

        val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Email.CONTENT_URI)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            val contactUri: Uri = data?.data!!
            val email= EMAIL_RETRIEVER.retrieve(contactUri)
            sendEmail(arrayOf(email),"Wiadomość z pracy domowej")
        }
    }
    fun sendEmail(addresses: Array<String?>,subject :String){
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)

        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    companion object {
        lateinit var EMAIL_RETRIEVER: EmailRetriever
    }
}
