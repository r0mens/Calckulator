package com.roman_druck.myapplication

data class Pantone(
    var name_pantone: String = "",
    var colorsampl: String ="",
    var basecolor1: String = "",
    var percent1: Double = 0.0,
    var basecolor2: String = "",
    var percent2: Double = 0.0,
    var basecolor3: String = "",
    var percent3: Double = 0.0,
    var basecolor4: String = "",
    var percent4: Double = 0.0,
    var totalmassa:Double = 0.0


){
    constructor(name_pantone: String) : this()
}
{

}
