package injection

import android.content.Context
import api.ApiFactory
import api.NewsApi
import dagger.Module
import dagger.Provides
import ldimitrov.com.cryptonewsreader.api.model.Article
import ldimitrov.com.cryptonewsreader.api.model.Source
import repository.Repository
import repository.impl.ArticleRepository
import repository.impl.SourceRepository

@Module
class AppModule(private val context: Context) {

    @Provides
    fun providesSharedPrefs() = context.getSharedPreferences("PREF", Context.MODE_PRIVATE)

    @Provides
    fun providesNewsApi() = ApiFactory.create<NewsApi>()

    @Provides
    fun providesSourcesRepo(): Repository<Source> = SourceRepository()

    @Provides
    fun providesArticlesRepo(): Repository<Article> = ArticleRepository()

}