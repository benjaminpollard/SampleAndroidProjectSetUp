package mosquito.sample.com.myapplication.Repositories;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmQuery;

public class DatabaseRepository {

    private Realm realm;

    public DatabaseRepository()
    {
        realm = Realm.getDefaultInstance();
    }

    public <T extends RealmObject> T MakeObjectManaged(T item)
    {
        //realm.beginTransaction();
        return realm.copyToRealm(item);
        //realm.commitTransaction();
    }

    public <T extends RealmObject> List<T> GetUnmanagedObjects(Class<T> type)
    {
        RealmQuery<T> query = realm.where(type);
        if(query.findAll() == null)
            return null;
        else
            return  realm.copyFromRealm(query.findAll());
    }
    public <T extends RealmObject> T GetUnmanagedObject(Class<T> type)
    {
        RealmQuery<T> query = realm.where(type);
        if(query.findFirst() == null)
            return null;
        else
            return realm.copyFromRealm(query.findFirst());
    }

    public <T extends RealmObject> void UpdateOrInsertItem(List<T> item)
    {
        realm.beginTransaction();
        realm.insertOrUpdate(item);
        realm.commitTransaction();
    }
    public <T extends RealmObject> void UpdateOrInsertItem(T  item)
    {
        realm.beginTransaction();
        realm.insertOrUpdate(item);
        realm.commitTransaction();
    }

    public <T extends RealmObject> T GetItem(Class<T> type)
    {
        RealmQuery<T> query = realm.where(type);
        return query.findFirst();
    }

    public <T extends RealmObject> List<T> GetItems(Class<T> type)
    {
        RealmQuery<T> query = realm.where(type);
        return query.findAll();
    }

    public <T extends RealmObject> void SaveItem(T item)
    {
        realm.beginTransaction();
        realm.copyToRealm(item);
        realm.commitTransaction();
    }

    public <T extends RealmObject> void SaveItems(List<T> items)
    {
        realm.beginTransaction();
        for (T item : items) {
            realm.copyToRealm(item);
        }
        realm.commitTransaction();
    }

    public <T extends RealmObject> void Remove(Class<T> item)
    {
        realm.beginTransaction();
        realm.delete(item);
        realm.commitTransaction();
    }
    public <T extends RealmObject> void DropDatabase()
    {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    public <T extends  RealmObject> T createItem(Class<T> item, Object key)
    {
        return realm.createObject(item,key);
    }

    public void AddDataChangeListener(RealmChangeListener listener)
    {
        realm.addChangeListener(listener);
    }

    public void RemoveDataChangeListener(RealmChangeListener listener)
    {
        realm.removeChangeListener(listener);
    }
}
