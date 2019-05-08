package pe.edu.upc.esfuerzo2.network

import java.lang.Exception
import java.net.URI

class LogoApi {
    companion object {
        const val BASE_URL = "https://logo.clearbit.com/"

        fun urlToLogo(urlString: String?): String {
            urlString?.apply {
                try {
                    val domain =  URI(this).host
                    return "$BASE_URL$domain"
                } catch (e: Exception) {
                    return this
                }
            }
            return ""
        }
    }
}