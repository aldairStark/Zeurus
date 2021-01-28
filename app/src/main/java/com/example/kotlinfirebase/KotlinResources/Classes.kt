package com.example.kotlinfirebase

import android.util.Log

class Classes {



    private fun showCase() {
        showCase1()
        showcase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
    }
    private fun showCase1(){
        open class Person{
            constructor( firsname:String, lastName: String){
                Log.i("constructor_2","$firsname $lastName")
            }
        }
        class Person1:Person{
            constructor(firsname:String):super(firsname,"lorensa")
            constructor(firsname:String,lastName: String):super(firsname, lastName)

        }

        val p=Person1("pedro","armando")
        p
    }
    private fun showcase2(){
        class User()
        class User1(val frName:String, val lastName:String, var age: Int)

        class User2(var name:String  , var age:Int){
            init {
                name = "pedro"
                age = 2

            }


        }
        class User3(val frName:String="", val lastName:String="", var age: Int=25){
            var p1=User()
            var p2=User1("armando","perales",2)
            var p12=User2("",25)
            var p3=User3("","",25)

        }
        class person(var fname:String, var apellido:String)
        val us1=person("jose", apellido = "altur")
        us1.fname
        us1.apellido

    }
    private fun showCase3(){
        //propiedades getters & setters
        class Person1(var firsname :String)
        val p1=Person1("jose")
        p1.firsname
        Log.i("Case_4",p1.firsname.toString())

        open class Person2{
            var firsname:String
                get() = field.capitalize()
                set(value) {
                    value.capitalize()
                }
            constructor(firsname:String){
                this.firsname=firsname
                Log.i("Herencia",firsname)
            }

        }
        class User:Person2{
            constructor(firsname:String):super(firsname){
            }
            val p=User("pedro")
        }
    }
    fun showCase4(){
        open class Person11(open var name:String)
        open class Person3(open var name:String)
        class Person12(override var name: String):Person11(name)
        class Person33(override var name:String, override var age:Int):Person3(name),Iperson {
            override fun hello() {
                super.hello()
            }
        }
        val man=Person33("",5)
        man.hello()
    }
    interface  Iperson{
        var age:Int
        fun hello(){
            Log.i("targer","function")
        }
    }
    private fun showCase5(){
        abstract class Unit(open var firsname:String, open var lastname:String){
            abstract  fun hellow()
            open fun welcome(){
                Log.i("CASE","Hola locos")
            }
            open fun welcomeDeveloper(){
                Log.i("Case34","WELCOME DEVELOPERS")
            }
        }
        class man(override var firsname:String, override var lastname:String):Unit(firsname,lastname) {
            override fun hellow() {
                Log.i("Case7","$firsname,$lastname")
            }
            override fun welcome() {
                super.welcome()
                super.welcomeDeveloper()
            }

            override fun welcomeDeveloper() {
                Log.i("OVERRIDE_WD","hola developers ahora cambio")
            }

        }
        val man1=man("fernando","jimena")
        man1.firsname
        man1.lastname
        man1.hellow()
        man1.welcome()
        man1.welcomeDeveloper()
    }

    private fun showCase6(){
        data class Person(var firsname:String,var lastName:String)
        val p =Person("alejandro","maya")
        val p2=p
        val persona=p.toString()
        val personCopy=p.copy()
        val clone=p.copy(firsname = "pedro")
        val (firstname, lastname)=p//destructuring

        Log.i("CLASE7", "===> $persona")
        Log.i("CLASE7", "===> $personCopy")
        Log.i("CLASE7", "===> $clone")
        Log.i("CLASE7", "===> $p")
        Log.i("CLASE7", "===> $p2")
        Log.i("CLASE7", "===> ${p === p2}") //boolean reference equality
        Log.i("CLASE7", "===> ${p !== personCopy}")
        Log.i("CLASE7", "===> ${p == personCopy}")
        Log.i("CLASE7", "===> ${firstname}")
        Log.i("CLASE7", "===> ${lastname}")
    }
    private  fun showCase7(){
        Log.i("CLASE8", "===> ${DayOfweek.lunes.name}")
        Log.i("CLASE8", "===> ${DayOfweek.lunes.ordinal}")
    }
    interface Interface2 {
        val property: Int
        var propertyString: String
            get() = "By default"
            set(value) {
                this.propertyString = value
            }

        fun hellow() {
            Log.i("INTERFAZ", "Insta trabajando $propertyString, $property")
        }

    }
}
enum class DayOfweek{lunes,martes,miercoles,jueves,viernes,sabado,domingo}

private fun Function0(){
    Function01()
    Function02()

}
private fun Function01(){
    //funciones parametros y unit
    fun function1(){}
    val result1=function1()

    fun function02(param1:String,param2:String):String{

        val param=param1
        val param2=param2

        return "$param,$param2"
    }
    var result03 =function02("perriman","forest")
    result03
    Log.i("FUNCTIONS",result03)

}
private fun Function02(){
    //funciones con funciones como parametro callback y llamadas lambda
    fun function03( param1:Int,param2:Int, Option:(result:Int) -> Unit ){
        Option(param1 + param2)
    }
    function03(5,5){
        result ->
        Log.i("Result","Result sum $result")
    }

    fun Fumction04(param1:Int,param2:Int, Parameter:(result:Int,parameter:String,param2:String)->Unit){
        Parameter(param1 + param2,"antonio","jose")
    }
    Fumction04(4,5,){result, parameter, param2 ->

    }

}
