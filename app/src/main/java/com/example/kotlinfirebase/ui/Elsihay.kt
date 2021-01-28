package com.example.kotlinfirebase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AlertDialog
import com.example.kotlinfirebase.R

class Elsihay : AppCompatActivity() {


    lateinit var TaG: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elsihay)
        TaG = "CLASS"
        fuctions()
        funciones()



    }

    private fun fuctions() {
        clasFunction01()
        classFunction02()
        classFunction03()
        classFunction06()
        classFunction07()


    }

    private fun clasFunction01() {

        data class person(var name: String) {
            init {
                name = "pedorro"
            }
        }

        class person01(var name: String = "pedro", var apellido: String = "nava", var edad: Int = 23, var aper: ArrayList<Int> = arrayListOf())

        var namber = arrayListOf<Int>(1212, 12, 2112, 12120)
        var p1 = person01(aper = namber)

    }

    private fun classFunction02() {
        open class personas {
            constructor(nombre: String, apellido: String) {

            }

            inner class persona : personas {
                constructor(nombre: String) : super(nombre, "alejandres")

            }

            val p1 = persona("aldair")
        }
    }

    private fun classFunction03() {
        class Persona1 {
            init {
                Log.i("CONTRUCTORCLASS", "HOLO ESTAS EN UN INIT")
            }

            constructor(firsname: String, lastname: String)
        }

        class Persona02(nombre: String, lasname: String) {
            init {
                Log.i("CLASS-03", "$nombre,$lasname")
            }

            constructor() : this("fernandes", "arellano")

        }

        val person1 = Persona1("pedro", "aler")
        val person2 = Persona02("hernandez", "patricia")
    }

    private fun classFunction04() {
        class Person01(firsname: String)
        class Person02(val firsname: String, var lasname: String)

        val name = Person01("alermane")
        val name01 = Person02("", "")
        name01.firsname
        name01.lasname
    }

    private fun classFunction05() {
        class Person1(var firsname: String)

        val p1 = Person1("fernando")
        p1.firsname
        p1.firsname = "Aldair"

        class Person02 {
            var name: String
                get() = field.capitalize()
                set(value) {
                    field = value.capitalize()
                }

            constructor(name: String) {
                this.name = name
            }
        }
    }

    private fun classFunction06() {
        open class Person constructor(open var name: String)
        open class Person01(var name: String)
        open class Person02(open var name: String, var lasName: String) {

        }

        class Persona11(override var name: String) : Person(name)
        class Person12(override var name: String, override var age: Int) : Person02("Orlando", ""), InterfacePerson {
            override fun personalidad() {

            }

        }


    }

    private fun classFunction07() {
        abstract class Person(open var name: String, open var lastname: String) {
            abstract fun helloW()
            open fun welcome() {
                Log.i("CLASS-34", "HOLA WELLCPME")
            }

            open fun developers() {
                Log.i("CLASS-34", "HOLA developers")
            }
        }

        class MAN(override var name: String, override var lastname: String) : Person(name, lastname) {
            override fun helloW() {
                Log.i("CLASS", "HOLA DE NUEVO")
            }

            override fun developers() {
                super.developers()
            }

        }

        val man = MAN("pedro", "isac")
        man.lastname
        man.developers()
        man.helloW()
    }

    private fun classFunction08() {
        data class Personita(var name: String)

        val p = Personita("jose")
    }

    private fun Ejercicio1() {
        var num1: Int = 2
        var num2: Int = 34


    }

    private fun Functions01() {

        fun funcioncita01(name: String, lastname: String, num1: Int, num2: Int, parametro: (name: String, num1: Int, num2: Int,result:Int) -> Unit){
            parametro("${name} ${lastname}", num1, num2,num1+num2)

            }
        funcioncita01("jose aldair", "Nava", 2, 1) { name, num1, num2,result ->
            Log.i(TaG,"Hola, ${name}, tu suma de ${num1} y ${num2} es igual a la cantidad de ${result}")
        }

    }
    private fun funciones(){
        Functions01()
    }

    interface InterfacePerson {
        var age: Int
        open fun personalidad() {

        }
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Salir del registro")
                builder.setMessage("¿Confirmas salir del registro?")

                builder.setPositiveButton("Si") { dialog, which ->
                    onBackPressed()
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
                }

                builder.setNegativeButton("No") { dialog, which ->

                }
                builder.show()
                return true
            }

        }
        return super.onKeyDown(keyCode, event)
    }
}
