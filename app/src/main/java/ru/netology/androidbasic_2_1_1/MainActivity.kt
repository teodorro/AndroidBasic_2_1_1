package ru.netology.androidbasic_2_1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.androidbasic_2_1_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растем сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остается с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен -> http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            likes = 5,
            shares = 999,
            views = 1500000
        )

        with(binding){
            initPost(post)
            setListeners(post)
        }

    }

    private fun ActivityMainBinding.setListeners(post: Post) {
        imageButtonLikes?.setOnClickListener {
            post.likedByMe = !post.likedByMe
            if (post.likedByMe) {
                imageButtonLikes.setImageResource(R.drawable.ic_liked_24)
                post.likes++
            }
            else{
                imageButtonLikes.setImageResource(R.drawable.ic_like_outline_24)
                post.likes--
            }
            textViewLikes.text = convertIntToStr(post.likes)
        }

        imageButtonShares?.setOnClickListener{
            post.shares++
            textViewShares.text = convertIntToStr(post.shares)
        }
    }

    private fun ActivityMainBinding.initPost(post: Post) {
        this.textViewAuthor.text = post.author
        textViewMessage.text = post.content
        textViewPublished.text = post.published
        if (post.likedByMe) {
            imageButtonLikes?.setImageResource(R.drawable.ic_liked_24)
        }
        textViewLikes.text = convertIntToStr(post.likes)
        textViewShares.text = convertIntToStr(post.shares)
        textViewViews.text = convertIntToStr(post.views)
    }

    private fun convertIntToStr(value: Int): String{
        return when(value){
            in 0..999 -> value.toString()
            in 1000..1099 -> (value / 1000).toString() + "K"
            in 1100..9999 -> ((value / 100).toDouble() / 10).toString() + "K"
            in 10000..999000 -> (value / 1000).toString() + "K"
            in 1000000..1099999 -> (value / 1000000).toString() + "M"
            in 1100000..9999999 -> ((value / 100000).toDouble() / 10).toString() + "M"
            in 10000000..999999999 -> (value / 1000000).toString() + "M"
            else -> value.toString()
        }
    }
}