package com.example.translateapitest

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import me.bush.translator.Language
import me.bush.translator.Translator


class MainActivity : AppCompatActivity() {
    private lateinit var textShow:TextView
    private lateinit var editText:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textShow=findViewById(R.id.textShow)
        editText=findViewById(R.id.editText)
        val translator = Translator()
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                lifecycleScope.launch {

////                    read more https://androidexample365.com/a-simple-and-free-google-translate-library-for-kotlin-jvm-and-java/

                    delay(300)
                    val translation = translator.translate(
                        text = s.toString(),
                        target = Language.UZBEK,
                        Language.AUTO
                    )
                    textShow.text = translation.translatedText
                }
            }
        })

//        println(translation.translatedText) // Переводчик Буша такой классный!
//        println(translation.pronunciation) // Perevodchik Busha takoy klassnyy!
//        println(translation.sourceLanguage)

    }
}