import java.lang.Double.parseDouble
import java.util.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime

fun main(args: Array<String>) {

    //GET CLASS -----------------------------------------------------------
    var classID: String = ""
    var flightClass: Int = 0
    while (classID == "") {
        println("We offer following classes:")
        println("003    E   Economic")
        println("002    B   Business")
        println("001    P   Premium Business")
        print("Please indicate your class: ")
        classID = readLine()!!.toString()
    }

    flightClass = getClass(classID)

    //GET LUGGAGE -----------------------------------------------------------
    var luggageWeight: String =""
    var luggagePrice: Int = 0

    while (luggageWeight == "") {
        print("Please type your luggage weight in kilogrammes: ")
        luggageWeight = readLine()!!.toString()
    }

    luggagePrice = getLuggage(luggageWeight.toInt())

    //GET CHILDREN -----------------------------------------------------------
    var nbChild: String = ""
    val childPrice: Int = 100
    var childTotalPrice: Int = 0
    print("How many children in your flight? ")
    nbChild = readLine()!!.toString()


    if (checkNumeric(nbChild) == true && nbChild.toInt() == 0){
        println("Do you still want to attach children in your flight? (Y/N)")
        nbChild = readLine()!!.toString()

        if (nbChild == "" || nbChild.toUpperCase() =="N" || nbChild.toInt() == 0){
            println("You have chosen not to accompany any children in your flight. Thanks.")
            nbChild = "0"
        }

        if (nbChild.toInt() > 0){
            println("You have chosen to accompany " + nbChild + " child(ren) in your flight. Thanks.")
        }

    }

    if (checkNumeric(nbChild) == true && nbChild.toInt() > 0){
        println("You have chosen to accompany " + nbChild + " child(ren) in your flight. Thanks.")
    }

    var age: Int
    var y = nbChild.toInt()
    var nbChildToAccompany: Int = nbChild.toInt()

    for (i: Int in 1..y){
        print("Please type year of birth of your #$i child: ")
        age = LocalDateTime.now().year - readLine()!!.toInt()
        if (age > 15){
            println("This child is older than 15 years old. You must buy him/her a separate ticket as an adult.")
            nbChildToAccompany = nbChildToAccompany-1
        }

    }

    childTotalPrice = nbChildToAccompany*childPrice
    println("Finally, you have totally $nbChildToAccompany child(ren): pay S$$childTotalPrice")

    //GET MEAL -----------------------------------------------------------
    var mealID: String = ""
    var nbOfMeal: Int = 1
    var continueToAddMeal: Boolean = true
    var mealPrice: Int = 0
    var mealReceipt: String = ""
    var mealName: String = ""
    var mealUnitPrice: Int = 0

    println("Do you want to add meal to your flight? Y/N")
    var answer: String = readLine()!!.toString()

    if (answer == "" || answer.toUpperCase() == "NO" || answer.toUpperCase() == "N") {
        nbOfMeal = 0
        mealPrice = 0
        print("Total payment for meals: S$$mealPrice")
        //Do nothing
    } else{

        while (continueToAddMeal == true) {

            println("We offer following meals:")
            println("1    Mee Goreng  $8")
            println("2    Mee Rebus   $12")
            println("3    Ramen       $14")

            while (mealID == "") {
                print("Please indicate your meal ID: ")
                mealID = readLine()!!.toString()
                }

            when (mealID){
                "1" -> {
                    mealPrice += 8
                    mealName = "Mee Goreng"
                    mealUnitPrice = 8
                }
                "2" -> {
                    mealPrice += 12
                    mealName = "Mee Rebus"
                    mealUnitPrice = 12
                }
                "3" -> {
                    mealPrice += 14
                    mealName = "Ramen"
                    mealUnitPrice = 14
                }
            }

            mealReceipt += ("\n ID:$mealID     $mealName        S$$mealUnitPrice")

            print("Add more meal? Y/N")
            answer = readLine()!!.toString()
            if (answer.toUpperCase() == "Y" || answer.toUpperCase() == "YES") {
                //continueToAddMeal = true
                mealID = ""
            } else {
                continueToAddMeal = false
            } }

        println(mealReceipt)
        println("Total payment for meals: S$$mealPrice")

    }





}

//----------------------------------------------------

fun getClass(classID: String): Int{
    var flightClass: Int = 0
    when (classID){
        "001" -> flightClass = 1
        "002" -> flightClass = 2
        "003" -> flightClass = 3
    }

    when (classID.toUpperCase()){
        "P" -> flightClass = 1
        "B" -> flightClass = 2
        "E" -> flightClass = 3
    }

    when (classID.toUpperCase()){
        "PREMIUM BUSINESS" -> flightClass = 1
        "BUSINESS" -> flightClass = 2
        "ECONOMIC" -> flightClass = 3
    }


    when (flightClass){
        1 -> println("Your class is Premium Business")
        2 -> println("Your class is Business")
        3 -> println("Your class is Economic")
    }

    return flightClass
}

//----------------------------------------------------

fun getLuggage(weight: Int): Int{
    var luggageFee: Int = 0

    if (weight == 0){
        luggageFee = 0
    }

    if ((weight > 0) && (weight <=10)){
        luggageFee = 15
    }

    if (weight > 10){
        luggageFee = 15
        luggageFee += (((weight-10)/5).toInt())*5

        if (((weight-10)%5)!=0){
            luggageFee += 5
        }

    }

    println("Your luggage fee is: S$" + luggageFee)
    return luggageFee
}

//----------------------------------------------------

fun checkNumeric(aString: String): Boolean{
    val string = aString
    var numeric = true

    try {
        var num = parseDouble(string)
    } catch (e: NumberFormatException) {
        numeric = false
    }

    return numeric
}