package repository.impl

import io.realm.RealmQuery
import io.realm.Sort
import ldimitrov.com.cryptonewsreader.api.model.Article
import repository.Repository

class ArticleRepository : Repository<Article> {
    override fun getById(id: String): Article? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun delete(filter: RealmQuery<Article>.() -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(id: String, modifier: Article.() -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(item: Article) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun addAll(items: List<Article>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(filter: RealmQuery<Article>.() -> Unit): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun query(filter: RealmQuery<Article>.() -> Unit, sortFields: Array<String>?, orders: Array<Sort>?): List<Article> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val clazz: Class<Article>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
