package com.example.gallery.model


data class ImagesMetaData(
    val id: String?,
    val description: String?,
    val width: Int?,
    val height: Int?,
    val urls: URLS?
) {
    data class URLS(
        val raw: String?,
        val full: String?,
        val regular: String?,
        val small: String?,
        val thumb: String?
    )
}
