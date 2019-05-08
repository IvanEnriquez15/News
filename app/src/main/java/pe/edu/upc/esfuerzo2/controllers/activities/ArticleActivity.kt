package pe.edu.upc.esfuerzo2.controllers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.content_article.*
import pe.edu.upc.esfuerzo2.R
import pe.edu.upc.esfuerzo2.models.Article
import pe.edu.upc.esfuerzo2.network.NewsApi

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent?.extras?.apply {
            val article = getSerializable("article") as Article
            val sources = NewsApi.sources.asSequence().filter { it.id == article.source.id }

            sources?.apply {
                if (this.count() == 0) return
                article.source = first()
                logoImageView.apply {
                    setDefaultImageResId(R.mipmap.ic_launcher)
                    setErrorImageResId(R.mipmap.ic_launcher)
                    setImageUrl(article.source.urlToLogo)
                }
            }

            pictureImageView.apply {
                setDefaultImageResId(R.mipmap.ic_launcher)
                setErrorImageResId(R.mipmap.ic_launcher)
                setImageUrl(article.urlToImage)
            }
            article.apply {
                titleTextView.text = title
                descriptionTextView.text = description
                contentTextView.text = content
            }

        }
    }
}
