package com.example.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.content.Context
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    fun btnClick(view: View){
        val btnSelected = view as Button
        var btnId = 0
        when (btnSelected.id){
            R.id.b1 -> btnId = 1
            R.id.b2 -> btnId = 2
            R.id.b3 -> btnId = 3
            R.id.b4 -> btnId = 4
            R.id.b5 -> btnId = 5
            R.id.b6 -> btnId = 6
            R.id.b7 -> btnId = 7
            R.id.b8 -> btnId = 8
            R.id.b9 -> btnId = 9
        }
        playGame(btnId, btnSelected)
    }
    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun playGame(btnID: Int, btnSelected:Button){
        if (activePlayer == 1 ){
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.RED)
            player1.add(btnID)
            activePlayer = 2
        }else{
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.GREEN)
            player2.add(btnID)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
        checkWinner()
    }
    private fun checkWinner(){
        var win = -1
        //practice will improve it later
        //Rows
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            win = 1
        }else if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            win = 2
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            win = 1
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            win = 2
        }

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            win = 1
        }else if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            win = 2
        }

        //columns
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            win = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            win = 2
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            win = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            win = 2
        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            win = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            win = 2
        }
        //Display winner
        if (win == 1){
            Toast.makeText(this, "Player1 wins the game", Toast.LENGTH_LONG).show()
        }else if (win == 2){
            Toast.makeText(this, "Player2 wins the game", Toast.LENGTH_LONG).show()
        }
    }
}