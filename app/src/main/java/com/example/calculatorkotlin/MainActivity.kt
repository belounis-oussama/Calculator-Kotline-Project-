package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {


    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var button0: Button
    lateinit var button00: Button
    lateinit var buttonpercent: Button
    lateinit var buttonclear: Button
    lateinit var buttondot: Button
    lateinit var buttonequal: Button
    lateinit var buttonadd: Button
    lateinit var buttonsub: Button
    lateinit var buttonamul: Button
    lateinit var buttonadivide: Button
    lateinit var buttonaback_space: Button
    lateinit var input_text: EditText
    lateinit var result_text: EditText

    var check=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button0=findViewById(R.id.button0)
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        button00=findViewById(R.id.button00)
        buttonpercent=findViewById(R.id.percentage)
        buttonclear=findViewById(R.id.clear)
        buttondot=findViewById(R.id.dote)
        buttonequal=findViewById(R.id.equal)
        buttonadd=findViewById(R.id.add)
        buttonsub=findViewById(R.id.minus)
        buttonamul=findViewById(R.id.multiply)
        buttonadivide=findViewById(R.id.Divide)
        buttonaback_space=findViewById(R.id.back_space)
        input_text=findViewById(R.id.input_number)
        result_text=findViewById(R.id.result)


        input_text.movementMethod=ScrollingMovementMethod()

        var text:String


        button1.setOnClickListener{
            text=input_text.text.toString()+"1"
            input_text.setText(text)

            result(text)
        }

        button0.setOnClickListener{
            text=input_text.text.toString()+"0"
            input_text.setText(text)

            result(text)
        }


        button00.setOnClickListener{
            text=input_text.text.toString()+"00"
            input_text.setText(text)

            result(text)
        }


        buttondot.setOnClickListener{
            text=input_text.text.toString()+"."
            input_text.setText(text)

            result(text)
        }


        button2.setOnClickListener{
            text=input_text.text.toString()+"2"
            input_text.setText(text)

            result(text)
        }


        button3.setOnClickListener{
            text=input_text.text.toString()+"3"
            input_text.setText(text)

            result(text)
        }



        button4.setOnClickListener{
            text=input_text.text.toString()+"4"
            input_text.setText(text)

            result(text)
        }




        button5.setOnClickListener{
            text=input_text.text.toString()+"5"
            input_text.setText(text)

            result(text)
        }


        button6.setOnClickListener{
            text=input_text.text.toString()+"6"
            input_text.setText(text)

            result(text)
        }



        button7.setOnClickListener{
            text=input_text.text.toString()+"7"
            input_text.setText(text)

            result(text)
        }



        button8.setOnClickListener{
            text=input_text.text.toString()+"8"
            input_text.setText(text)

            result(text)
        }



        button9.setOnClickListener{
            text=input_text.text.toString()+"9"
            input_text.setText(text)

            result(text)
        }


        buttonadd.setOnClickListener {
            text=input_text.text.toString()+"+"
            input_text.setText(text)
            check++
        }

        buttonsub.setOnClickListener {
            text=input_text.text.toString()+"-"
            input_text.setText(text)
            check++
        }

        buttonamul.setOnClickListener {
            text=input_text.text.toString()+"*"
            input_text.setText(text)
            check++
        }

        buttonadivide.setOnClickListener {
            text=input_text.text.toString()+"/"
            input_text.setText(text)
            check++
        }

        buttonpercent.setOnClickListener {
            text=input_text.text.toString()+"%"
            input_text.setText(text)
            check++
        }


        buttonequal.setOnClickListener {
            text=result_text.text.toString()
            input_text.setText(text)
            result_text.setText(null)
        }

        buttonclear.setOnClickListener {
            input_text.setText(null)
            result_text.setText(null)
        }

        buttonaback_space.setOnClickListener {

            var Backspace:String?=null
            if (input_text.text.isNotEmpty())
            {
               val stringBuilder: StringBuilder=StringBuilder(input_text.text)
               val find=input_text.text.toString()
                val find2=find.last()

                if (find2.equals('+') || find2.equals('-') || find2.equals('*') || find2.equals('/') || find2.equals('%'))
                {
                    check=check-1
                }

                stringBuilder.deleteCharAt(input_text.text.length-1)
                Backspace=stringBuilder.toString()
                input_text.setText(Backspace)
                result(Backspace)
            }
        }
    }

    private fun result(text: String) {

        val engine:ScriptEngine =ScriptEngineManager().getEngineByName("rhino")
        try {
            val resut:Any=engine.eval(text)
            var mainrult=resut.toString()

            if (check ==0)
            {
                result_text.setText(null)
            }
            else
            {
                result_text.setText(mainrult)
            }
        }
        catch (e: ScriptException)
        {
            Log.d("TAG","ERROR")
        }

    }
}