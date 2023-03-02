package com.ilhomsoliev.currencyapp.core

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.ilhomsoliev.currencyapp.R
import com.ilhomsoliev.currencyapp.data.local.dto.CurrencyEntity
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


object Helper {
    fun getExchangeRateFromResponse(str: String): Double {
        var ans = str.replace("\\s".toRegex(), "")
        while (ans[0] != ':') {
            ans = ans.substring(1)
        }
        ans = ans.substring(1)
        while (ans[0] != ':') {
            ans = ans.substring(1)
        }
        ans = ans.substring(1)
        ans = ans.dropLast(1)
        return ans.toDouble()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun Long.toTimeHoursAndMinutes(): String {
        return DateTimeFormatter.ofPattern("MM/DD/YY HH:mm")
            .withZone(ZoneId.systemDefault())
            .format(Instant.ofEpochMilli(this))

    }

    fun getAllCurrencies(): List<CurrencyEntity> {
        val list = listOf<CurrencyEntity>(
            CurrencyEntity(
                initials = "aed",
                name = "United Arab Emirates Dirham",
                editedAt = 1,
                countryFlagLink = R.drawable.united_arab_emirates
            ),
            CurrencyEntity(
                initials = "afn",
                name = "Afghan afghani",
                editedAt = 1,
                countryFlagLink = R.drawable.afghanistan
            ),
            CurrencyEntity(
                initials = "all",
                name = "Albanian lek",
                editedAt = 1,
                countryFlagLink = R.drawable.albania
            ),
            CurrencyEntity(
                initials = "amd",
                name = "Armenian dram",
                editedAt = 1,
                countryFlagLink = R.drawable.armenia
            ),
            CurrencyEntity(
                initials = "ang",
                name = "Netherlands Antillean Guilder",
                editedAt = 1,
                countryFlagLink = R.drawable.netherlands_antilles
            ),
            CurrencyEntity(
                initials = "aoa",
                name = "Angolan kwanza",
                editedAt = 1,
                countryFlagLink = R.drawable.angola
            ),
            CurrencyEntity(
                initials = "ars",
                name = "Argentine peso",
                editedAt = 1,
                countryFlagLink = R.drawable.argentina
            ),
            CurrencyEntity(
                initials = "aud",
                name = "Australian dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.australia
            ),
            CurrencyEntity(
                initials = "awg",
                name = "Aruban florin",
                editedAt = 1,
                countryFlagLink = R.drawable.aruba
            ),
            CurrencyEntity(
                initials = "azn",
                name = "Azerbaijani manat",
                editedAt = 1,
                countryFlagLink = R.drawable.azerbaijan
            ),
            CurrencyEntity(
                initials = "bam",
                name = "Bosnia-Herzegovina Convertible Mark",
                editedAt = 1,
                countryFlagLink = R.drawable.bosnia_and_herzegovina
            ),
            CurrencyEntity(
                initials = "bbd",
                name = "Bajan dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.barbados
            ),
            CurrencyEntity(
                initials = "bdt",
                name = "Bangladeshi taka",
                editedAt = 1,
                countryFlagLink = R.drawable.bangladesh
            ),
            CurrencyEntity(
                initials = "bgn",
                name = "Bulgarian lev",
                editedAt = 1,
                countryFlagLink = R.drawable.bulgaria
            ),
            CurrencyEntity(
                initials = "bhd",
                name = "Bahraini dinar",
                editedAt = 1,
                countryFlagLink = R.drawable.bahrain
            ),
            CurrencyEntity(
                initials = "bif",
                name = "Burundian Franc",
                editedAt = 1,
                countryFlagLink = R.drawable.burundi
            ),
            CurrencyEntity(
                initials = "bmd",
                name = "Bermudan dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.bermuda
            ),
            CurrencyEntity(
                initials = "bnd",
                name = "Brunei dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.brunei
            ),
            CurrencyEntity(
                initials = "bob",
                name = "Bolivian boliviano",
                editedAt = 1,
                countryFlagLink = R.drawable.bolivia
            ),
            CurrencyEntity(
                initials = "brl",
                name = "Brazilian real",
                editedAt = 1,
                countryFlagLink = R.drawable.brazil
            ),
            CurrencyEntity(
                initials = "bsd",
                name = "Bahamian dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.bahamas__the
            ),
            CurrencyEntity(
                initials = "btc",
                name = "Bitcoin",
                editedAt = 1,
                countryFlagLink = R.drawable.bitcoin
            ),
            CurrencyEntity(
                initials = "btn",
                name = "Bhutan currency",
                editedAt = 1,
                countryFlagLink = R.drawable.bhutan
            ),
            CurrencyEntity(
                initials = "bwp",
                name = "Botswanan Pula",
                editedAt = 1,
                countryFlagLink = R.drawable.botswana
            ),
            CurrencyEntity(
                initials = "byn",
                name = "New Belarusian Ruble",
                editedAt = 1,
                countryFlagLink = R.drawable.belarus
            ),
            CurrencyEntity(
                initials = "byr",
                name = "Belarusian Ruble",
                editedAt = 1,
                countryFlagLink = R.drawable.belarus
            ),
            CurrencyEntity(
                initials = "bzd",
                name = "Belize dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.belize
            ),
            CurrencyEntity(
                initials = "cad",
                name = "Canadian dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.canada
            ),
            CurrencyEntity(
                initials = "cdf",
                name = "Congolese franc",
                editedAt = 1,
                countryFlagLink = R.drawable.congo__democratic_republic_of_the
            ),
            CurrencyEntity(
                initials = "chf",
                name = "Swiss franc",
                editedAt = 1,
                countryFlagLink = R.drawable.switzerland
            ),
            CurrencyEntity(
                initials = "clp",
                name = "Chilean peso",
                editedAt = 1,
                countryFlagLink = R.drawable.chile
            ),
            CurrencyEntity(
                initials = "cny",
                name = "Chinese Yuan",
                editedAt = 1,
                countryFlagLink = R.drawable.china
            ),
            CurrencyEntity(
                initials = "cop",
                name = "Colombian peso",
                editedAt = 1,
                countryFlagLink = R.drawable.colombia
            ),
            CurrencyEntity(
                initials = "crc",
                name = "Costa Rican Colón",
                editedAt = 1,
                countryFlagLink = R.drawable.costa_rica
            ),
            CurrencyEntity(
                initials = "cup",
                name = "Cuban Peso",
                editedAt = 1,
                countryFlagLink = R.drawable.cuba
            ),
            CurrencyEntity(
                initials = "czk",
                name = "Czech koruna",
                editedAt = 1,
                countryFlagLink = R.drawable.czech_republic
            ),
            CurrencyEntity(
                initials = "djf",
                name = "Djiboutian franc",
                editedAt = 1,
                countryFlagLink = R.drawable.djibouti
            ),
            CurrencyEntity(
                initials = "dkk",
                name = "Danish krone",
                editedAt = 1,
                countryFlagLink = R.drawable.denmark
            ),
            CurrencyEntity(
                initials = "dop",
                name = "Dominican peso",
                editedAt = 1,
                countryFlagLink = R.drawable.dominica
            ),
            CurrencyEntity(
                initials = "dzd",
                name = "Algerian dinar",
                editedAt = 1,
                countryFlagLink = R.drawable.algeria
            ),
            CurrencyEntity(
                initials = "egp",
                name = "Egyptian pound",
                editedAt = 1,
                countryFlagLink = R.drawable.egypt
            ),
            CurrencyEntity(
                initials = "ern",
                name = "Eritrean nakfa",
                editedAt = 1,
                countryFlagLink = R.drawable.eritrea
            ),
            CurrencyEntity(
                initials = "etb",
                name = "Ethiopian birr",
                editedAt = 1,
                countryFlagLink = R.drawable.ethiopia
            ),
            CurrencyEntity(
                initials = "eur",
                name = "Euro",
                editedAt = 1,
                countryFlagLink = R.drawable.european_union
            ),
            CurrencyEntity(
                initials = "fjd",
                name = "Fijian dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.fiji
            ),
            CurrencyEntity(
                initials = "gbp",
                name = "Pound sterling",
                editedAt = 1,
                countryFlagLink = R.drawable.british_virgin_islands
            ),
            CurrencyEntity(
                initials = "gel",
                name = "Georgian lari",
                editedAt = 1,
                countryFlagLink = R.drawable.georgia
            ),
            CurrencyEntity(
                initials = "ghs",
                name = "Ghanaian cedi",
                editedAt = 1,
                countryFlagLink = R.drawable.ghana
            ),
            CurrencyEntity(
                initials = "gip",
                name = "Gibraltar pound",
                editedAt = 1,
                countryFlagLink = R.drawable.gibraltar
            ),
            CurrencyEntity(
                initials = "gmd",
                name = "Gambian dalasi",
                editedAt = 1,
                countryFlagLink = R.drawable.gambia__the
            ),
            CurrencyEntity(
                initials = "gnf",
                name = "Guinean franc",
                editedAt = 1,
                countryFlagLink = R.drawable.guinea
            ),
            CurrencyEntity(
                initials = "gtq",
                name = "Guatemalan quetzal",
                editedAt = 1,
                countryFlagLink = R.drawable.guatemala
            ),
            CurrencyEntity(
                initials = "gyd",
                name = "Guyanaese Dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.guyana
            ),
            CurrencyEntity(
                initials = "hkd",
                name = "Hong Kong dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.hong_kong
            ),
            CurrencyEntity(
                initials = "hnl",
                name = "Honduran lempira",
                editedAt = 1,
                countryFlagLink = R.drawable.honduras
            ),
            CurrencyEntity(
                initials = "hrk",
                name = "Croatian kuna",
                editedAt = 1,
                countryFlagLink = R.drawable.croatia
            ),
            CurrencyEntity(
                initials = "htg",
                name = "Haitian gourde",
                editedAt = 1,
                countryFlagLink = R.drawable.haiti
            ),
            CurrencyEntity(
                initials = "huf",
                name = "Hungarian forint",
                editedAt = 1,
                countryFlagLink = R.drawable.hungary
            ),
            CurrencyEntity(
                initials = "idr",
                name = "Indonesian rupiah",
                editedAt = 1,
                countryFlagLink = R.drawable.indonesia
            ),
            CurrencyEntity(
                initials = "ils",
                name = "Israeli New Shekel",
                editedAt = 1,
                countryFlagLink = R.drawable.israel
            ),
            CurrencyEntity(
                initials = "inr",
                name = "Indian rupee",
                editedAt = 1,
                countryFlagLink = R.drawable.india
            ),
            CurrencyEntity(
                initials = "iqd",
                name = "Iraqi dinar",
                editedAt = 1,
                countryFlagLink = R.drawable.iraq
            ),
            CurrencyEntity(
                initials = "irr",
                name = "Iranian rial",
                editedAt = 1,
                countryFlagLink = R.drawable.iran
            ),
            CurrencyEntity(
                initials = "isk",
                name = "Icelandic króna",
                editedAt = 1,
                countryFlagLink = R.drawable.iceland
            ),
            CurrencyEntity(
                initials = "jep",
                name = "Jersey Pound",
                editedAt = 1,
                countryFlagLink = R.drawable.jersey
            ),
            CurrencyEntity(
                initials = "jmd",
                name = "Jamaican dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.jamaica
            ),
            CurrencyEntity(
                initials = "jod",
                name = "Jordanian dinar",
                editedAt = 1,
                countryFlagLink = R.drawable.jordan
            ),
            CurrencyEntity(
                initials = "jpy",
                name = "Japanese yen",
                editedAt = 1,
                countryFlagLink = R.drawable.japan
            ),
            CurrencyEntity(
                initials = "kes",
                name = "Kenyan shilling",
                editedAt = 1,
                countryFlagLink = R.drawable.kenya
            ),
            CurrencyEntity(
                initials = "kgs",
                name = "Kyrgystani Som",
                editedAt = 1,
                countryFlagLink = R.drawable.kyrgyzstan
            ),
            CurrencyEntity(
                initials = "khr",
                name = "Cambodian riel",
                editedAt = 1,
                countryFlagLink = R.drawable.cambodia
            ),
            CurrencyEntity(
                initials = "kmf",
                name = "Comorian franc",
                editedAt = 1,
                countryFlagLink = R.drawable.comoros
            ),
            CurrencyEntity(
                initials = "kpw",
                name = "North Korean won",
                editedAt = 1,
                countryFlagLink = R.drawable.korea__north
            ),
            CurrencyEntity(
                initials = "krw",
                name = "South Korean won",
                editedAt = 1,
                countryFlagLink = R.drawable.korea__south
            ),
            CurrencyEntity(
                initials = "kwd",
                name = "Kuwaiti dinar",
                editedAt = 1,
                countryFlagLink = R.drawable.kuwait
            ),
            CurrencyEntity(
                initials = "kyd",
                name = "Cayman Islands dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.cayman_islands
            ),
            CurrencyEntity(
                initials = "kzt",
                name = "Kazakhstani tenge",
                editedAt = 1,
                countryFlagLink = R.drawable.kazakhstan
            ),
            CurrencyEntity(
                initials = "lkr",
                name = "Sri Lankan rupee",
                editedAt = 1,
                countryFlagLink = R.drawable.sri_lanka
            ),
            CurrencyEntity(
                initials = "lrd",
                name = "Liberian dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.liberia
            ),
            CurrencyEntity(
                initials = "lvl",
                name = "Latvian lats",
                editedAt = 1,
                countryFlagLink = R.drawable.latvia
            ),
            CurrencyEntity(
                initials = "lyd",
                name = "Libyan dinar",
                editedAt = 1,
                countryFlagLink = R.drawable.libya
            ),
            CurrencyEntity(
                initials = "mad",
                name = "Moroccan dirham",
                editedAt = 1,
                countryFlagLink = R.drawable.morocco
            ),
            CurrencyEntity(
                initials = "mdl",
                name = "Moldovan leu",
                editedAt = 1,
                countryFlagLink = R.drawable.moldova
            ),
            CurrencyEntity(
                initials = "mkd",
                name = "Macedonian denar",
                editedAt = 1,
                countryFlagLink = R.drawable.macedonia
            ),
            CurrencyEntity(
                initials = "mnt",
                name = "Mongolian tugrik",
                editedAt = 1,
                countryFlagLink = R.drawable.mongolia
            ),
            CurrencyEntity(
                initials = "mro",
                name = "Mauritanian ouguiya",
                editedAt = 1,
                countryFlagLink = R.drawable.mauritania
            ),
            CurrencyEntity(
                initials = "mur",
                name = "Mauritian rupee",
                editedAt = 1,
                countryFlagLink = R.drawable.mauritius
            ),
            CurrencyEntity(
                initials = "mvr",
                name = "Maldivian rufiyaa",
                editedAt = 1,
                countryFlagLink = R.drawable.maldives
            ),
            CurrencyEntity(
                initials = "mwk",
                name = "Malawian kwacha",
                editedAt = 1,
                countryFlagLink = R.drawable.malawi
            ),
            CurrencyEntity(
                initials = "mxn",
                name = "Mexican peso",
                editedAt = 1,
                countryFlagLink = R.drawable.mexico
            ),
            CurrencyEntity(
                initials = "myr",
                name = "Malaysian ringgit",
                editedAt = 1,
                countryFlagLink = R.drawable.malaysia
            ),
            CurrencyEntity(
                initials = "mzn",
                name = "Mozambican Metical",
                editedAt = 1,
                countryFlagLink = R.drawable.mozambique
            ),
            CurrencyEntity(
                initials = "nad",
                name = "Namibian dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.namibia
            ),
            CurrencyEntity(
                initials = "ngn",
                name = "Nigerian naira",
                editedAt = 1,
                countryFlagLink = R.drawable.nigeria
            ),
            CurrencyEntity(
                initials = "nok",
                name = "Norwegian krone",
                editedAt = 1,
                countryFlagLink = R.drawable.norway
            ),
            CurrencyEntity(
                initials = "npr",
                name = "Nepalese rupee",
                editedAt = 1,
                countryFlagLink = R.drawable.nepal
            ),
            CurrencyEntity(
                initials = "nzd",
                name = "New Zealand dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.new_zealand
            ),
            CurrencyEntity(
                initials = "omr",
                name = "Omani rial",
                editedAt = 1,
                countryFlagLink = R.drawable.oman
            ),
            CurrencyEntity(
                initials = "pab",
                name = "Panamanian balboa",
                editedAt = 1,
                countryFlagLink = R.drawable.panama
            ),
            CurrencyEntity(
                initials = "pgk",
                name = "Papua New Guinean kina",
                editedAt = 1,
                countryFlagLink = R.drawable.papua_new_guinea
            ),
            CurrencyEntity(
                initials = "php",
                name = "Philippine peso",
                editedAt = 1,
                countryFlagLink = R.drawable.philippines
            ),
            CurrencyEntity(
                initials = "pkr",
                name = "Pakistani rupee",
                editedAt = 1,
                countryFlagLink = R.drawable.pakistan
            ),
            CurrencyEntity(
                initials = "pln",
                name = "Poland złoty",
                editedAt = 1,
                countryFlagLink = R.drawable.poland
            ),
            CurrencyEntity(
                initials = "pyg",
                name = "Paraguayan guarani",
                editedAt = 1,
                countryFlagLink = R.drawable.paraguay
            ),
            CurrencyEntity(
                initials = "qar",
                name = "Qatari Rial",
                editedAt = 1,
                countryFlagLink = R.drawable.qatar
            ),
            CurrencyEntity(
                initials = "ron",
                name = "Romanian leu",
                editedAt = 1,
                countryFlagLink = R.drawable.romania
            ),
            CurrencyEntity(
                initials = "rsd",
                name = "Serbian dinar",
                editedAt = 1,
                countryFlagLink = R.drawable.serbia
            ),
            CurrencyEntity(
                initials = "rub",
                name = "Russian ruble",
                editedAt = 1,
                countryFlagLink = R.drawable.russia
            ),
            CurrencyEntity(
                initials = "rwf",
                name = "Rwandan Franc",
                editedAt = 1,
                countryFlagLink = R.drawable.rwanda
            ),
            CurrencyEntity(
                initials = "sar",
                name = "Saudi riyal",
                editedAt = 1,
                countryFlagLink = R.drawable.saudi_arabia
            ),
            CurrencyEntity(
                initials = "sbd",
                name = "Solomon Islands dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.solomon_islands
            ),
            CurrencyEntity(
                initials = "scr",
                name = "Seychellois rupee",
                editedAt = 1,
                countryFlagLink = R.drawable.seychelles
            ),
            CurrencyEntity(
                initials = "sdg",
                name = "Sudanese pound",
                editedAt = 1,
                countryFlagLink = R.drawable.sudan
            ),
            CurrencyEntity(
                initials = "sek",
                name = "Swedish krona",
                editedAt = 1,
                countryFlagLink = R.drawable.sweden
            ),
            CurrencyEntity(
                initials = "sgd",
                name = "Singapore dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.singapore
            ),
            CurrencyEntity(
                initials = "shp",
                name = "Saint Helena pound",
                editedAt = 1,
                countryFlagLink = R.drawable.saint_helena
            ),
            CurrencyEntity(
                initials = "sll",
                name = "Sierra Leonean leone",
                editedAt = 1,
                countryFlagLink = R.drawable.sierra_leone
            ),
            CurrencyEntity(
                initials = "sos",
                name = "Somali shilling",
                editedAt = 1,
                countryFlagLink = R.drawable.somalia
            ),
            CurrencyEntity(
                initials = "srd",
                name = "Surinamese dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.suriname
            ),
            CurrencyEntity(
                initials = "svc",
                name = "Salvadoran Colón",
                editedAt = 1,
                countryFlagLink = R.drawable.el_salvador
            ),
            CurrencyEntity(
                initials = "syp",
                name = "Syrian pound",
                editedAt = 1,
                countryFlagLink = R.drawable.syria
            ),
            CurrencyEntity(
                initials = "szl",
                name = "Swazi lilangeni",
                editedAt = 1,
                countryFlagLink = R.drawable.swaziland
            ),
            CurrencyEntity(
                initials = "thb",
                name = "Thai baht",
                editedAt = 1,
                countryFlagLink = R.drawable.thailand
            ),
            CurrencyEntity(
                initials = "tjs",
                name = "Tajikistani somoni",
                editedAt = 1,
                countryFlagLink = R.drawable.tajikistan
            ),
            CurrencyEntity(
                initials = "tmt",
                name = "Turkmenistani manat",
                editedAt = 1,
                countryFlagLink = R.drawable.turkmenistan
            ),
            CurrencyEntity(
                initials = "tnd",
                name = "Tunisian dinar",
                editedAt = 1,
                countryFlagLink = R.drawable.tunisia
            ),
            CurrencyEntity(
                initials = "top",
                name = "Tongan Paʻanga",
                editedAt = 1,
                countryFlagLink = R.drawable.tonga
            ),
            CurrencyEntity(
                initials = "try",
                name = "Turkish lira",
                editedAt = 1,
                countryFlagLink = R.drawable.turkey
            ),
            CurrencyEntity(
                initials = "ttd",
                name = "Trinidad & Tobago Dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.trinidad_and_tobago
            ),
            CurrencyEntity(
                initials = "twd",
                name = "New Taiwan dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.taiwan
            ),
            CurrencyEntity(
                initials = "tzs",
                name = "Tanzanian shilling",
                editedAt = 1,
                countryFlagLink = R.drawable.tanzania
            ),
            CurrencyEntity(
                initials = "uah",
                name = "Ukrainian hryvnia",
                editedAt = 1,
                countryFlagLink = R.drawable.ukraine
            ),
            CurrencyEntity(
                initials = "ugx",
                name = "Ugandan shilling",
                editedAt = 1,
                countryFlagLink = R.drawable.uganda
            ),
            CurrencyEntity(
                initials = "usd",
                name = "United States dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.united_states
            ),
            CurrencyEntity(
                initials = "uyu",
                name = "Uruguayan peso",
                editedAt = 1,
                countryFlagLink = R.drawable.uruguay
            ),
            CurrencyEntity(
                initials = "uzs",
                name = "Uzbekistani som",
                editedAt = 1,
                countryFlagLink = R.drawable.uzbekistan
            ),
            CurrencyEntity(
                initials = "vnd",
                name = "Vietnamese dong",
                editedAt = 1,
                countryFlagLink = R.drawable.vietnam
            ),
            CurrencyEntity(
                initials = "vuv",
                name = "Vanuatu vatu",
                editedAt = 1,
                countryFlagLink = R.drawable.vanuatu
            ),
            CurrencyEntity(
                initials = "wst",
                name = "Samoan tala",
                editedAt = 1,
                countryFlagLink = R.drawable.samoa
            ),
            CurrencyEntity(
                initials = "yer",
                name = "Yemeni rial",
                editedAt = 1,
                countryFlagLink = R.drawable.yemen
            ),
            CurrencyEntity(
                initials = "zar",
                name = "South African rand",
                editedAt = 1,
                countryFlagLink = R.drawable.south_africa
            ),
            CurrencyEntity(
                initials = "zmw",
                name = "Zambian Kwacha",
                editedAt = 1,
                countryFlagLink = R.drawable.zambia
            ),
            CurrencyEntity(
                initials = "zwl",
                name = "Zimbabwean Dollar",
                editedAt = 1,
                countryFlagLink = R.drawable.zimbabwe
            ),
        )
        return list
    }
}

fun getCountryIdByName(context: Context):Int{
    val locale = context.resources.configuration.locale.displayCountry
    return 1
}
