fun tinhTienBanh(n: Int): Double{

    var soBanhChan: Int = 0
    var soBanhLe: Int = 0

    val giaTien1cai = 1.0
    val giatien2cai = 0.75
    val giaTien3cai = 0.5

    var tongTienBanhLe: Double = 0.0
    var tongTienBanhChan: Double = 0.0

    //tinh tien so banh le:



    if ((n%3)!=3 && (n%3)>0){
        soBanhChan = ((n/3).toInt())*3
        tongTienBanhChan = soBanhChan * giaTien3cai

        soBanhLe = n%3

        when (soBanhLe){
            1 -> tongTienBanhLe = soBanhLe * giaTien1cai
            2 -> tongTienBanhLe = soBanhLe * giatien2cai
        }}

        else {
            tongTienBanhChan = n * giaTien3cai
            tongTienBanhLe = 0.0
        }

    return (tongTienBanhChan + tongTienBanhLe)
    }

fun main(args: Array<String>) {
    var soLuongBanh: Int
    var tienBanh: Double
    tienBanh = 0.0
    print("Hay nhap so luong banh: ")
    soLuongBanh = readLine()!!.toInt()
    tienBanh = tinhTienBanh(soLuongBanh)
    println("SGD " + tienBanh)

}

