package repository.impl

import io.realm.RealmQuery
import io.realm.Sort
import ldimitrov.com.cryptonewsreader.api.model.Source
import repository.Repository

class SourceRepository : Repository<Source> {
    override fun getById(id: String): Source? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun delete(filter: RealmQuery<Source>.() -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(id: String, modifier: Source.() -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(item: Source) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun addAll(items: List<Source>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(filter: RealmQuery<Source>.() -> Unit): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun query(filter: RealmQuery<Source>.() -> Unit, sortFields: Array<String>?, orders: Array<Sort>?): List<Source> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val clazz: Class<Source>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

}