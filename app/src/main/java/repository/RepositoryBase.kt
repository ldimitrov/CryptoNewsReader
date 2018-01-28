package repository

import extensions.inTransactionAsync
import extensions.loadAsync
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmQuery
import io.realm.Sort

abstract class RepositoryBase<T> : Repository<T> where T : RealmModel {
    private val realm: Realm = Realm.getDefaultInstance()

    abstract protected val primaryKey: String

    override fun getById(id: String): T? {
        return realm.where(clazz)
                .equalTo(primaryKey, id)
                .findFirst()
    }

    override suspend fun delete(filter: RealmQuery<T>.() -> Unit) {
        return realm.inTransactionAsync {
            val results = where(clazz)
            filter(results)
            results.findAll().deleteAllFromRealm()
        }
    }

    override suspend fun deleteAll() = realm.inTransactionAsync { delete(clazz) }

    override fun update(id: String, modifier: T.() -> Unit) {
        realm.executeTransaction { realm ->
            val dbItem = realm.where(clazz)
                    .equalTo(primaryKey, id)
                    .findFirst()
            modifier(dbItem)
        }
    }

    override fun add(item: T) {
        return realm.executeTransaction { realm ->
            realm.copyToRealm(item)
        }
    }

    override suspend fun addAll(items: List<T>) = realm.inTransactionAsync { copyToRealmOrUpdate(items) }

    override fun count(): Long = realm.where(clazz).count()

    override fun count(filter: RealmQuery<T>.() -> Unit): Long {
        val results = realm.where(clazz)
        filter(results)
        return results.count()
    }

    override suspend fun query(filter: RealmQuery<T>.() -> Unit, sortFields: Array<String>?, orders: Array<Sort>?): List<T> {
        val results = realm.where(clazz)
        filter(results)
        return if (sortFields == null) {
            results.findAllAsync()
                    .loadAsync()
        } else {
            results.findAllSortedAsync(sortFields, orders)
                    .loadAsync()
        }
    }

    // Closing Realm instances
    override fun close() {
        realm.close()
    }
}