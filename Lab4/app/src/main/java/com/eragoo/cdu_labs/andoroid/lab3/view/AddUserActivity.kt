package com.eragoo.cdu_labs.andoroid.lab3.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.eragoo.cdu_labs.andoroid.lab3.R
import com.eragoo.cdu_labs.andoroid.lab3.model.User
import com.eragoo.cdu_labs.andoroid.lab3.viewmodel.AddUserViewModel
import java.util.UUID

class AddUserActivity : AppCompatActivity() {
    private lateinit var viewModel: AddUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this)[AddUserViewModel::class.java]
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_user, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.confirmButton -> {


                val userAddList = listOf<EditText>(
                    findViewById(R.id.addName), findViewById(R.id.addSurname), findViewById(R.id.addEmail)
                )
                for (userAddText in userAddList) {
                    if (userAddText.text.isEmpty() && userAddText != userAddList[1]) {
                        Toast.makeText(
                            applicationContext,
                            "All fields should be specified!",
                            Toast.LENGTH_SHORT
                        ).show()
                        return true
                    }
                }
                val user = User(
                    UUID.randomUUID().toString(),
                    userAddList[0].text.toString(),
                    userAddList[1].text.toString(),
                    userAddList[2].text.toString(),
                )
                viewModel.insertUser(user)
                finish()
            }
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}