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
import com.medicare.database.model.User
import java.lang.Class
import java.util.concurrent.Callable
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.jvm.JvmStatic

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class UserDao_Impl(
  __db: RoomDatabase,
) : UserDao {
  private val __db: RoomDatabase

  private val __upsertionAdapterOfUser: EntityUpsertionAdapter<User>
  init {
    this.__db = __db
    this.__upsertionAdapterOfUser = EntityUpsertionAdapter<User>(object :
        EntityInsertionAdapter<User>(__db) {
      protected override fun createQuery(): String =
          "INSERT INTO `user` (`id`,`userName`) VALUES (nullif(?, 0),?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: User) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindString(2, entity.userName)
      }
    }, object : EntityDeletionOrUpdateAdapter<User>(__db) {
      protected override fun createQuery(): String =
          "UPDATE `user` SET `id` = ?,`userName` = ? WHERE `id` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: User) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindString(2, entity.userName)
        statement.bindLong(3, entity.id.toLong())
      }
    })
  }

  public override suspend fun upsertUser(user: User): Unit = CoroutinesRoom.execute(__db, true,
      object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __upsertionAdapterOfUser.upsert(user)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun getUser(): User? {
    val _sql: String = "SELECT * FROM user LIMIT 1"
    val _statement: RoomSQLiteQuery = acquire(_sql, 0)
    val _cancellationSignal: CancellationSignal? = createCancellationSignal()
    return execute(__db, false, _cancellationSignal, object : Callable<User?> {
      public override fun call(): User? {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _cursorIndexOfUserName: Int = getColumnIndexOrThrow(_cursor, "userName")
          val _result: User?
          if (_cursor.moveToFirst()) {
            val _tmpId: Int
            _tmpId = _cursor.getInt(_cursorIndexOfId)
            val _tmpUserName: String
            _tmpUserName = _cursor.getString(_cursorIndexOfUserName)
            _result = User(_tmpId,_tmpUserName)
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

  public companion object {
    @JvmStatic
    public fun getRequiredConverters(): List<Class<*>> = emptyList()
  }
}
