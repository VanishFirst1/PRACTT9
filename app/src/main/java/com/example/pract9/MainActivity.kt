package com.example.stone_paper_scissors

import android.R
import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.stone_paper_scissors.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    public var choose : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun stone(view: View) {
        disableallimg1()
        choose="камень"
        binding.rigthStone.isVisible=true
        chooseNext()
    }

    fun paper(view: View) {
        disableallimg1()
        choose="бумага"
        binding.rigthPaper.isVisible=true

        chooseNext()
    }

    fun spok(view: View) {
        disableallimg1()
        choose="спок"
        binding.rigthSpoke.isVisible=true

        chooseNext()
    }

    fun scissors(view: View) {
        disableallimg1()
        choose="ножницы"
        binding.rigthScissors.isVisible=true

        chooseNext()
    }

    fun lizard(view: View) {
        disableallimg1()
        choose="ящерица"
        binding.rigthLizard.isVisible=true

        chooseNext()
    }

    fun chooseNext(){
        binding.img1.isVisible=true
        binding.txtpeople.text=choose
        enableStart()
    }
    fun disableallimg1() {
        binding.rigthStone.isVisible=false
        binding.rigthLizard.isVisible=false
        binding.rigthSpoke.isVisible=false
        binding.rigthPaper.isVisible=false
        binding.rigthScissors.isVisible=false

        binding.leftLizard.isVisible=false
        binding.leftScissors.isVisible=false
        binding.leftpaper.isVisible=false
        binding.leftstone.isVisible=false
        binding.leftSpoke.isVisible=false
    }

    fun startPlay(view: View){
        binding.img1.isVisible=false
        binding.img2.isVisible=false

        disablebtn()
        val symbolArr = arrayListOf<String>("камень","бумага","спок","ножницы","ящерица")
        val machineChosee = symbolArr.random()
        machinechooseImg(machineChosee)

        binding.txtMachine.text=machineChosee
        if(choose == "камень" && machineChosee=="бумага")
        {
            machinewin()
        }else if(choose == "камень" && machineChosee=="спок")
        {
            machinewin()
        }else if(choose == "камень" && machineChosee=="ножницы")
        {
            peoplewin()
        }else if(choose == "камень" && machineChosee=="ящерица")
        {
            peoplewin()
        }else if(choose == "бумага" && machineChosee=="спок")
        {
            peoplewin()
        }else if(choose == "бумага" && machineChosee=="ножницы")
        {
            machinewin()
        }else if(choose == "бумага" && machineChosee=="ящерица")
        {
            machinewin()
        }else if(choose == "бумага" && machineChosee=="камень")
        {
            peoplewin()
        }else if(choose == "спок" && machineChosee=="ножницы")
        {
            peoplewin()
        }else if(choose == "спок" && machineChosee=="ящерица")
        {
            machinewin()
        }else if(choose == "спок" && machineChosee=="камень")
        {
            peoplewin()
        }else if(choose == "спок" && machineChosee=="бумага")
        {
            machinewin()
        }else if(choose == "ножницы" && machineChosee=="камень")
        {
            machinewin()
        }else if(choose == "ножницы" && machineChosee=="бумага")
        {
            peoplewin()
        }else if(choose == "ножницы" && machineChosee=="спок")
        {
            machinewin()
        }else if(choose == "ножницы" && machineChosee=="ящерица")
        {
            peoplewin()
        }else if(choose == "ящерица" && machineChosee=="камень")
        {
            machinewin()
        }else if(choose == "ящерица" && machineChosee=="бумага")
        {
            peoplewin()
        }else if(choose == "ящерица" && machineChosee=="спок")
        {
            peoplewin()
        }else if(choose == "ящерица" && machineChosee=="ножницы")
        {
            machinewin()
        }else {
            draw()
        }

    }

    fun machinechooseImg(machineChoose : String) {
        binding.leftLizard.isVisible=false
        binding.leftScissors.isVisible=false
        binding.leftpaper.isVisible=false
        binding.leftstone.isVisible=false
        binding.leftSpoke.isVisible=false
        when(machineChoose) {
            "камень" -> binding.leftstone.isVisible=true
            "бумага" ->binding.leftpaper.isVisible=true
            "спок"->binding.leftSpoke.isVisible=true
            "ножницы"->binding.leftScissors.isVisible=true
            "ящерица"->binding.leftLizard.isVisible=true
        }
    }

    fun peoplewin() {
        binding.txtWin.text="Победил игрок!"
        enablebtn()

    }

    fun machinewin() {
        binding.txtWin.text="Победил компьютер!"
        enablebtn()

    }

    fun draw() {
        binding.txtWin.text="Ничья переигрываем!"
        enablebtn()

    }

    fun enablebtn() {
        binding.btnStone.isEnabled=true
        binding.btnPaper.isEnabled=true
        binding.btnSpok.isEnabled=true
        binding.btnScissors.isEnabled=true
        binding.btnLizard.isEnabled=true


    }
    fun disablebtn() {
        binding.btnStone.isEnabled=false
        binding.btnPaper.isEnabled=false
        binding.btnSpok.isEnabled=false
        binding.btnScissors.isEnabled=false
        binding.btnLizard.isEnabled=false
    }
    fun enableStart() {
        binding.btnstart.isEnabled=true
    }



}


