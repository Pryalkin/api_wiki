package com.bsuir.wikipedia.app.model.item

data class WikiPage(
    val pageid: Int,
    val ns: Int,
    val title: String,
    val contentmodel: String,
    val pagelanguage: String,
    val pagelanguagehtmlcode: String,
    val pagelanguagedir: String,
    val touched: String,
    val lastrevid: Int,
    val length: Int
)
