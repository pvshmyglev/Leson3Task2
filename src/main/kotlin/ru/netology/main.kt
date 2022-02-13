package ru.netology

fun main() {
    val sumAmount : Int = 55000
    val sumOldAmount : Int = 7490000
    val cardType : String = "MasterCard"

    val result = calculateCommission(sumAmount, cardType, sumOldAmount)
        println("Комиссия составляет: ${result / 100} руб. ${result % 100} коп.")
}

fun calculateCommission(sumAmount : Int, cardType: String = "Vk Pay", sumOldAmount: Int = 0): Int {

    val cardTypeLowerCase = cardType.lowercase()
    val sumLimitMastercard : Int = 7500000
    val percentCommissionMastercard : Int = 60
    val sumCommissionMastercard : Int = 2000

    val percentCommissionMir : Int = 75
    val minCommissionMir : Int = 3500

    return when {

        (cardTypeLowerCase == "mastercard" || cardTypeLowerCase == "maestro") -> {
            val exceedLimit = sumOldAmount + sumAmount - sumLimitMastercard
            if (exceedLimit > 0) exceedLimit * percentCommissionMastercard / 1000 + sumCommissionMastercard else 0
        }

        (cardTypeLowerCase == "visa" || cardTypeLowerCase == "мир") -> {
            if ((sumAmount * percentCommissionMir / 1000) < minCommissionMir) minCommissionMir else sumAmount * percentCommissionMir / 1000
        }
        else -> 0

    }
}