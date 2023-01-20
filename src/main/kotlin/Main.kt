fun main() {

//    val trickFunction = trick
//    trick()
//    trickFunction()
//    treat()

    val coins: (Int) -> String = { quantity ->
        "$quantity quarters!"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    fun tips(): (Int) -> String = {
        "$it quarters!"
    }

    fun cents(): (Int) -> String {
        return { "$it quarters!" }
    }

    val treatFunction = trickOrTreat(false, coins)
    val treatFunctionConcise = trickOrTreat(false, { "$it quarters" })
    val treatFunctionFinal = trickOrTreat(false) { "$it quarters" }

    val trickFunction = trickOrTreat(true, cupcake)
    val trickFunctionNull = trickOrTreat(true, null)
    //val treatFunctionB = trickOrTreat(true, tips())
//    val trickFunction = trickOrTreat(true) {
//        "$it quarters"
//    }

    //treatFunctionC()
    //treatFunctionB()
    treatFunction()
    trickFunction()
    trickFunctionNull()

    repeat(4) {
        treatFunctionFinal()
    }
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}