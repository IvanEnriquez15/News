package pe.edu.upc.esfuerzo2.network

abstract class NewsApiResponse(
    val status: String,
    val code: String?,
    val message: String?
) {
    constructor() : this("", "", "")

}