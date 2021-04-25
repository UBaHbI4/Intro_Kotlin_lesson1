package softing.ubah4ukdev.intro_kotlin_les1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cat = Cat(resources.getString(R.string.cat_name), 3)
        val catInfo: TextView = findViewById(R.id.cat_info)
        val catCopyInfo: TextView = findViewById(R.id.cat_copy_info)

        //4. Добавить кнопку в разметку и повесить на неё clickListener в Activity
        val btnShowProperty: MaterialButton = findViewById(R.id.btn_show_properties)
        btnShowProperty.setOnClickListener {
            catInfo.text = cat.toString()
        }

        //5. b. создайте Object, в Object вызывайте copy и выводите значения скопированного класса на экран;
        val btnShowCopyProperty: MaterialButton = findViewById(R.id.btn_show_copy_properties)
        btnShowCopyProperty.setOnClickListener {
            val copyCat: Cat = cat.copy(age = 2)
            catCopyInfo.text = copyCat.toString()
        }

        //5. c. выводите значения из разных циклов в консоль, используя примеры из методических материалов
        val btnShowCycleExample: MaterialButton = findViewById(R.id.btn_cycle_example)
        btnShowCycleExample.setOnClickListener {
            //Получим массив имен из ресурсов
            val listName = arrayListOf<String>(*resources.getStringArray(R.array.names))

            //Заполним arrayList экземплярами класса кошек
            val listCats = arrayListOf(
                    Cat(listName[0], 3),
                    Cat(listName[1], 6),
                    Cat(listName[2], 5),
                    Cat(listName[3], 14),
                    Cat(listName[4], 4)
            )

            //Выведем все имена котов
            listCats.forEach {
                printLog(it.name)
            }

            //Выведем имена котов в обратном порядке
            printDelimiter()
            for (i in listCats.size - 1 downTo 0) {
                printLog(listCats[i].name)
            }

            //Выведем имена котов и информацию о четности возраста
            printDelimiter()
            for (i in 0 until listCats.size) {
                printLog(listCats[i].name + " " + if ((listCats[i].age % 2) == 0) getOddText(true) else getOddText(false))
            }

            //Выведем нечетные числа от 0 до 10
            printDelimiter()
            var notOddVal = ""
            for (i in 1..10 step 2) {
                notOddVal += "$i "
            }
            printLog(notOddVal)
        }
    }

    //метод для печати в лог сообщений
    fun printLog(message: String) {
        Log.i(resources.getString(R.string.log_tag), message)
    }

    //печать разделителя
    fun printDelimiter() = printLog(resources.getString(R.string.delimiter))

    //Получить текст с ресурсов для четного или нечетного значения
    fun getOddText(isOdd: Boolean): String {
        if (isOdd) {
            return resources.getString(R.string.odd_text)
        } else {
            return resources.getString(R.string.not_odd_text)
        }
    }
}