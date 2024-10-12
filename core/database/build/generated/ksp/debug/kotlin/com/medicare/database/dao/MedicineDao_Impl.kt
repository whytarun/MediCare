package com.medicare.database.dao

import android.database.Cursor
import android.os.CancellationSignal
import androidx.room.CoroutinesRoom
import androidx.room.CoroutinesRoom.Companion.execute
import androidx.room.EntityDeletionOrUpdateAdapter
import androidx.room.EntityInsertionAdapter
import androidx.room.EntityUpsertionAdapter
import androidx.room.RoomDatabase
import androidx.room.RoomSQLiteQuery
import androidx.room.RoomSQLiteQuery.Companion.acquire
import androidx.room.util.createCancellationSignal
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.query
import androidx.sqlite.db.SupportSQLiteStatement
import com.medicare.database.model.Medicine
import java.lang.Class
import java.util.ArrayList
import java.util.concurrent.Callable
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class MedicineDao_Impl(
  __db: RoomDatabase,
) : MedicineDao {
  private val __db: RoomDatabase

  private val __insertionAdapterOfMedicine: EntityInsertionAdapter<Medicine>

  private val __deletionAdapterOfMedicine: EntityDeletionOrUpdateAdapter<Medicine>

  private val __upsertionAdapterOfMedicine: EntityUpsertionAdapter<Medicine>
  init {
    this.__db = __db
    this.__insertionAdapterOfMedicine = object : EntityInsertionAdapter<Medicine>(__db) {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `medicine` (`id`,`name`,`dose`,`strength`) VALUES (?,?,?,?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Medicine) {
        val _tmpId: Int? = entity.id
        if (_tmpId == null) {
          statement.bindNull(1)
        } else {
          statement.bindLong(1, _tmpId.toLong())
        }
        statement.bindString(2, entity.name)
        statement.bindString(3, entity.dose)
        statement.bindString(4, entity.strength)
      }
    }
    this.__deletionAdapterOfMedicine = object : EntityDeletionOrUpdateAdapter<Medicine>(__db) {
      protected override fun createQuery(): String = "DELETE FROM `medicine` WHERE `id` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Medicine) {
        val _tmpId: Int? = entity.id
        if (_tmpId == null) {
          statement.bindNull(1)
        } else {
          statement.bindLong(1, _tmpId.toLong())
        }
      }
    }
    this.__upsertionAdapterOfMedicine = EntityUpsertionAdapter<Medicine>(object :
        EntityInsertionAdapter<Medicine>(__db) {
      protected override fun createQuery(): String =
          "INSERT INTO `medicine` (`id`,`name`,`dose`,`strength`) VALUES (?,?,?,?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Medicine) {
        val _tmpId: Int? = entity.id
        if (_tmpId == null) {
          statement.bindNull(1)
        } else {
          statement.bindLong(1, _tmpId.toLong())
        }
        statement.bindString(2, entity.name)
        statement.bindString(3, entity.dose)
        statement.bindString(4, entity.strength)
      }
    }, object : EntityDeletionOrUpdateAdapter<Medicine>(__db) {
      protected override fun createQuery(): String =
          "UPDATE `medicine` SET `id` = ?,`name` = ?,`dose` = ?,`strength` = ? WHERE `id` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Medicine) {
        val _tmpId: Int? = entity.id
        if (_tmpId == null) {
          statement.bindNull(1)
        } else {
          statement.bindLong(1, _tmpId.toLong())
        }
        statement.bindString(2, entity.name)
        statement.bindString(3, entity.dose)
        statement.bindString(4, entity.strength)
        val _tmpId_1: Int? = entity.id
        if (_tmpId_1 == null) {
          statement.bindNull(5)
        } else {
          statement.bindLong(5, _tmpId_1.toLong())
        }
      }
    })
  }

  public override suspend fun insertMedicines(medicines: List<Medicine>): Unit =
      CoroutinesRoom.execute(__db, true, object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __insertionAdapterOfMedicine.insert(medicines)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun deleteMedicine(medicine: Medicine): Unit =
      CoroutinesRoom.execute(__db, true, object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __deletionAdapterOfMedicine.handle(medicine)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun upsertMedicine(medicine: Medicine): Unit =
      CoroutinesRoom.execute(__db, true, object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __upsertionAdapterOfMedicine.upsert(medicine)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun getMedicineById(id: Int): Medicine? {
    val _sql: String = "SELECT * FROM medicine WHERE id = ?"
    val _statement: RoomSQLiteQuery = acquire(_sql, 1)
    var _argIndex: Int = 1
    _statement.bindLong(_argIndex, id.toLong())
    val _cancellationSignal: CancellationSignal? = createCancellationSignal()
    return execute(__db, false, _cancellationSignal, object : Callable<Medicine?> {
      public override fun call(): Medicine? {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _cursorIndexOfName: Int = getColumnIndexOrThrow(_cursor, "name")
          val _cursorIndexOfDose: Int = getColumnIndexOrThrow(_cursor, "dose")
          val _cursorIndexOfStrength: Int = getColumnIndexOrThrow(_cursor, "strength")
          val _result: Medicine?
          if (_cursor.moveToFirst()) {
            val _tmpId: Int?
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId)
            }
            val _tmpName: String
            _tmpName = _cursor.getString(_cursorIndexOfName)
            val _tmpDose: String
            _tmpDose = _cursor.getString(_cursorIndexOfDose)
            val _tmpStrength: String
            _tmpStrength = _cursor.getString(_cursorIndexOfStrength)
            _result = Medicine(_tmpId,_tmpName,_tmpDose,_tmpStrength)
          } else {
            _result = null
          }
          return _result
        } finally {
          _cursor.close()
          _statement.release()
        }
      }
    })
  }

  public override fun getMedicine(): Flow<List<Medicine>> {
    val _sql: String = "SELECT * FROM medicine"
    val _statement: RoomSQLiteQuery = acquire(_sql, 0)
    return CoroutinesRoom.createFlow(__db, false, arrayOf("medicine"), object :
        Callable<List<Medicine>> {
      public override fun call(): List<Medicine> {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _cursorIndexOfName: Int = getColumnIndexOrThrow(_cursor, "name")
          val _cursorIndexOfDose: Int = getColumnIndexOrThrow(_cursor, "dose")
          val _cursorIndexOfStrength: Int = getColumnIndexOrThrow(_cursor, "strength")
          val _result: MutableList<Medicine> = ArrayList<Medicine>(_cursor.getCount())
          while (_cursor.moveToNext()) {
            val _item: Medicine
            val _tmpId: Int?
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId)
            }
            val _tmpName: String
            _tmpName = _cursor.getString(_cursorIndexOfName)
            val _tmpDose: String
            _tmpDose = _cursor.getString(_cursorIndexOfDose)
            val _tmpStrength: String
            _tmpStrength = _cursor.getString(_cursorIndexOfStrength)
            _item = Medicine(_tmpId,_tmpName,_tmpDose,_tmpStrength)
            _result.add(_item)
          }
          return _result
        } finally {
          _cursor.close()
        }
      }

      protected fun finalize() {
        _statement.release()
      }
    })
  }

  public companion object {
    @JvmStatic
    public fun getRequiredConverters(): List<Class<*>> = emptyList()
  }
}
