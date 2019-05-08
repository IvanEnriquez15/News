package pe.edu.upc.esfuerzo2.network

import pe.edu.upc.esfuerzo2.models.Article

class ArticlesResponse(val totalResults: Int,
                       val articles: List<Article>) : NewsApiResponse() {
    constructor() : this(0, ArrayList<Article>())
}