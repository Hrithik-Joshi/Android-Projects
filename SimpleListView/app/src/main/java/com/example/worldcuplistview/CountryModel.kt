package com.example.worldcuplistview

class CountryModel {
    var countryName:String=""
    var totalWins:String=""
    var flagImg: Int

    constructor(countryName:String,totalWins:String,flagImg: Int){
        this.countryName=countryName
        this.totalWins=totalWins
        this.flagImg=flagImg
    }
}