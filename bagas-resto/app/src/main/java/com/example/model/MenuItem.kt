package com.example.model

data class MenuItem(
    val id: String,
    val name: String,
    val priceString: String,
    val priceVal: Double,
    val description: String,
    val category: String, // "Makanan" or "Minuman"
    val iconName: String, // For matching with beautiful Material Icons
    val tag: String? = null // For tags like "Terlaris", "Rekomendasi", etc.
) {
    companion object {
        val dummyList = listOf(
            MenuItem(
                id = "nasgor_spesial",
                name = "Nasi Goreng Spesial Bagas",
                priceString = "Rp 35.000",
                priceVal = 35000.0,
                description = "Nasi goreng premium khas Bagas Resto dengan paduan bumbu rempah rahasia, disajikan hangat lengkap dengan telur mata sapi setengah matang, udang segar, acar segar, emping melinjo gurih, dan potongan ayam bakar.",
                category = "Makanan",
                iconName = "Restaurant",
                tag = "Terlaris"
            ),
            MenuItem(
                id = "sate_madura",
                name = "Sate Ayam Madura Premium",
                priceString = "Rp 40.000",
                priceVal = 40000.0,
                description = "10 tusuk sate ayam pilihan dengan daging yang gurih, empuk, dan tebal. Dipanggang di atas arang kelapa alami hingga beraroma smokey murni, lalu disajikan dengan lumuran bumbu kacang gurih khas Madura yang kental manis.",
                category = "Makanan",
                iconName = "OutdoorGrill",
                tag = "Rekomendasi"
            ),
            MenuItem(
                id = "rendang_minang",
                name = "Rendang Daging Sapi Minang",
                priceString = "Rp 55.000",
                priceVal = 55000.0,
                description = "Rendang daging sapi pilihan bertekstur empuk yang diungkep perlahan selama 8 jam dengan paduan kelapa sangrai dan 21 rempah-rempah otentik khas Sumatera Barat hingga bumbu hitamnya meresap melimpah.",
                category = "Makanan",
                iconName = "DinnerDining",
                tag = "Spesial"
            ),
            MenuItem(
                id = "es_teler",
                name = "Es Teler Segar Nusantara",
                priceString = "Rp 22.000",
                priceVal = 22000.0,
                description = "Minuman pencuci mulut yang sangat menyegarkan terdiri dari daging kelapa muda, nangka matang wangi, alpukat mentega creamy, jeli sagu, berpadu santan cair manis, sirup coco pandan spesial, dan serutan es gunung.",
                category = "Minuman",
                iconName = "LocalBar",
                tag = "Segar"
            ),
            MenuItem(
                id = "kopi_gula_aren",
                name = "Kopi Susu Gula Aren",
                priceString = "Rp 18.000",
                priceVal = 18000.0,
                description = "Kombinasi premium cold brew espresso Arabika organik dengan susu evaporasi berkualitas tinggi dan manisnya sirup gula aren lokal asli Sukabumi.",
                category = "Minuman",
                iconName = "Coffee",
                tag = "Favorit"
            ),
            MenuItem(
                id = "teh_serai_madu",
                name = "Teh Serai Madu Hangat",
                priceString = "Rp 15.000",
                priceVal = 15000.0,
                description = "Air seduhan daun teh melati pilihan yang harum wangi, disatukan dengan batang serai organik geprek, perasan lemon segar, serta pemanis alami dari madu hutan rimba.",
                category = "Minuman",
                iconName = "LocalCafe",
                tag = "Sehat"
            )
        )
    }
}
