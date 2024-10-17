package com.example.primerappkotlin

fun main() {
    println("Hello mundo")

    // Usar val de preferencia
    var numeroFavorito = 11;
    val numeroFavorito2 = 18;
    println(numeroFavorito)
    println(numeroFavorito2)

    // Tipos de variable
    val numeroRandom: Int = 9;
    val numeroRandom2: Double = 4.5;

    // Operaciones aritméticas
    var suma = numeroFavorito + numeroFavorito2;
    var suma2 = numeroRandom.plus(numeroFavorito);
    var multiplicacion = numeroFavorito2.times(numeroRandom);
    var resta = numeroFavorito2.minus(numeroFavorito2);
    var division = numeroRandom.div(numeroFavorito2);

    // Strings
    val saludo = "Hola";
    val nombre = "Martha";

    val frase = saludo + " " + nombre;
    val frase2 = "$saludo $nombre";
    println(frase)
    println(frase2)

    val miFrase = "$saludo, $nombre, me gusta el número $numeroFavorito";
    println(miFrase);
    val miFrase2 = "La suma de números favoritos es ${numeroFavorito + numeroFavorito2}";
    println(miFrase2);

    // Llamar funciones
    showMyName();
    getMyName("Eren", "Jaeger");
    getMyName(name = "Eren", lastName = "Jaeger");
    getMyName(lastName = "Jaeger", name = "Eren");

    println(returnMyName());
    myLineFunction()

    // Listas y arreglos
    val finSemana = arrayOf(
        "Sábado",
        "Domingo"
    )

    val invierno = listOf(
        "Diciembre",
        "Enero",
        "Febrero"
    )

    invierno.forEach { element ->
        println(element)
    }
    // Cuando no se especifica nombre, se usa it
    invierno.forEach {
        println(it)
    }

    val list = finSemana.map { item ->
        println(item)
    }
    val itemFound = finSemana.find { item ->
        item == "Sábado"
    }
    val items = finSemana.filter { item:String ->
        item.contains("a")
    }
}

fun myLineFunction() = println("Soy de una línea")

fun showMyName() {
    println("My name is Eren Jaeger");
}

fun getMyName(name: String, lastName: String) {
    println("My name us $name $lastName");
}

fun returnMyName():String {
    return "Eren Jaeger"
}