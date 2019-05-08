package pe.edu.upc.esfuerzo2.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_article.view.*
import pe.edu.upc.esfuerzo2.models.Article
import pe.edu.upc.esfuerzo2.R
import pe.edu.upc.esfuerzo2.controllers.activities.ArticleActivity
import java.io.Serializable

class ArticlesAdapter(var articles: List<Article>) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pictureImageView = itemView.pictureImageView
        val titleTextView = itemView.titleTextView
        val moreButton = itemView.moreButton

        fun bindTo(article: Article) {
            pictureImageView.apply {
                setDefaultImageResId(R.mipmap.ic_launcher)
                setErrorImageResId(R.mipmap.ic_launcher)
                setImageUrl(article.urlToImage)
            }
            titleTextView.text = article.title
            moreButton.setOnClickListener {
                val intent = Intent(it.context, ArticleActivity::class.java)
                intent.putExtra("article", article as Serializable)
                it.context.startActivity(intent)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_article, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(articles[position])
    }

}